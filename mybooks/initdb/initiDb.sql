-- Table: public.vendor

-- DROP TABLE IF EXISTS public.vendor;

CREATE TABLE IF NOT EXISTS public.vendor
(
    vendor_id character varying COLLATE pg_catalog."default" NOT NULL,
    name character varying COLLATE pg_catalog."default" NOT NULL,
    email character varying COLLATE pg_catalog."default" NOT NULL,
    phone_number character varying COLLATE pg_catalog."default",
    address character varying COLLATE pg_catalog."default",
    bank_details character varying COLLATE pg_catalog."default" NOT NULL,
    created_at timestamp with time zone NOT NULL DEFAULT now(),
    updated_at timestamp with time zone NOT NULL,
    CONSTRAINT vendor_pkey PRIMARY KEY (vendor_id)
)
TABLESPACE pg_default;

ALTER TABLE IF EXISTS public.vendor
    OWNER to postgres;

-- Table: public.customer_entity

-- DROP TABLE IF EXISTS public.customer_entity;

CREATE TABLE IF NOT EXISTS public.customer_entity
(
    customer_id character varying COLLATE pg_catalog."default" NOT NULL,
    name character varying COLLATE pg_catalog."default" NOT NULL,
    email character varying COLLATE pg_catalog."default" NOT NULL,
    phone_number character varying COLLATE pg_catalog."default",
    address character varying COLLATE pg_catalog."default",
    created_at timestamp with time zone NOT NULL,
    updated_at timestamp with time zone NOT NULL,
    CONSTRAINT customer_entity_pkey PRIMARY KEY (customer_id)
)
TABLESPACE pg_default;

ALTER TABLE IF EXISTS public.customer_entity
    OWNER to postgres;

-- Table: public.product_group_entity

-- DROP TABLE IF EXISTS public.product_group_entity;

CREATE TABLE IF NOT EXISTS public.product_group_entity
(
    product_group_id character varying COLLATE pg_catalog."default" NOT NULL,
    vendor_id character varying COLLATE pg_catalog."default" NOT NULL,
    name character varying COLLATE pg_catalog."default" NOT NULL,
    description text COLLATE pg_catalog."default",
    created_at timestamp with time zone NOT NULL,
    updated_at timestamp with time zone NOT NULL,
    CONSTRAINT product_group_entity_pkey PRIMARY KEY (product_group_id),
    CONSTRAINT fk_product_group_vendor FOREIGN KEY (vendor_id)
        REFERENCES public.vendor (vendor_id) MATCH SIMPLE
        ON UPDATE NO ACTION
        ON DELETE NO ACTION
        NOT VALID
)
TABLESPACE pg_default;

ALTER TABLE IF EXISTS public.product_group_entity
    OWNER to postgres;

-- Table: public.recurring_plans_entity

-- DROP TABLE IF EXISTS public.recurring_plans_entity;

CREATE TABLE IF NOT EXISTS public.recurring_plans_entity
(
    plan_id character varying COLLATE pg_catalog."default" NOT NULL,
    vendor_id character varying COLLATE pg_catalog."default" NOT NULL,
    product_group_id character varying COLLATE pg_catalog."default" NOT NULL,
    name character varying COLLATE pg_catalog."default" NOT NULL,
    amount numeric(10, 2) NOT NULL,
    frequency character varying COLLATE pg_catalog."default" NOT NULL,
    start_date timestamp with time zone NOT NULL,
    end_date timestamp with time zone,
    day_of_week character varying COLLATE pg_catalog."default",
    day_of_month integer,
    created_at timestamp with time zone NOT NULL,
    CONSTRAINT recurring_plans_entity_pkey PRIMARY KEY (plan_id),
    CONSTRAINT fk_recurring_vendor FOREIGN KEY (vendor_id)
        REFERENCES public.vendor (vendor_id) MATCH SIMPLE
        ON UPDATE NO ACTION
        ON DELETE NO ACTION
        NOT VALID,
    CONSTRAINT fk_recurring_product_group FOREIGN KEY (product_group_id)
        REFERENCES public.product_group_entity (product_group_id) MATCH SIMPLE
        ON UPDATE NO ACTION
        ON DELETE NO ACTION
        NOT VALID
)
TABLESPACE pg_default;

ALTER TABLE IF EXISTS public.recurring_plans_entity
    OWNER to postgres;

-- Table: public.subscription_entity

-- DROP TABLE IF EXISTS public.subscription_entity;

CREATE TABLE IF NOT EXISTS public.subscription_entity
(
    subscription_id character varying COLLATE pg_catalog."default" NOT NULL,
    customer_id character varying COLLATE pg_catalog."default" NOT NULL,
    plan_id character varying COLLATE pg_catalog."default" NOT NULL,
    vendor_id character varying COLLATE pg_catalog."default" NOT NULL,
    auto_pay boolean NOT NULL,
    start_date timestamp with time zone NOT NULL,
    end_date timestamp with time zone,
    next_billing_date date NOT NULL,
    created_at timestamp with time zone NOT NULL,
    updated_at timestamp with time zone NOT NULL,
    CONSTRAINT subscription_entity_pkey PRIMARY KEY (subscription_id),
    CONSTRAINT fk_subscription_customer FOREIGN KEY (customer_id)
        REFERENCES public.customer_entity (customer_id) MATCH SIMPLE
        ON UPDATE NO ACTION
        ON DELETE NO ACTION
        NOT VALID,
    CONSTRAINT fk_subscription_plan FOREIGN KEY (plan_id)
        REFERENCES public.recurring_plans_entity (plan_id) MATCH SIMPLE
        ON UPDATE NO ACTION
        ON DELETE NO ACTION
        NOT VALID,
    CONSTRAINT fk_subscription_vendor FOREIGN KEY (vendor_id)
        REFERENCES public.vendor (vendor_id) MATCH SIMPLE
        ON UPDATE NO ACTION
        ON DELETE NO ACTION
        NOT VALID
)
TABLESPACE pg_default;

ALTER TABLE IF EXISTS public.subscription_entity
    OWNER to postgres;

-- Table: public.invoice_entity

-- DROP TABLE IF EXISTS public.invoice_entity;

CREATE TABLE IF NOT EXISTS public.invoice_entity
(
    invoice_id character varying COLLATE pg_catalog."default" NOT NULL,
    subscription_id character varying COLLATE pg_catalog."default" NOT NULL,
    customer_id character varying COLLATE pg_catalog."default" NOT NULL,
    vendor_id character varying COLLATE pg_catalog."default" NOT NULL,
    amount numeric(10, 2) NOT NULL,
    status character varying COLLATE pg_catalog."default" NOT NULL,
    invoice_date timestamp with time zone NOT NULL,
    due_date timestamp with time zone NOT NULL,
    payment_link character varying COLLATE pg_catalog."default",
    created_at timestamp with time zone NOT NULL,
    updated_at timestamp with time zone NOT NULL,
    CONSTRAINT invoice_entity_pkey PRIMARY KEY (invoice_id),
    CONSTRAINT fk_subscription FOREIGN KEY (subscription_id)
        REFERENCES public.subscription_entity (subscription_id) MATCH SIMPLE
        ON UPDATE NO ACTION
        ON DELETE NO ACTION
        NOT VALID,
    CONSTRAINT fk_customer FOREIGN KEY (customer_id)
        REFERENCES public.customer_entity (customer_id) MATCH SIMPLE
        ON UPDATE NO ACTION
        ON DELETE NO ACTION
        NOT VALID,
    CONSTRAINT fk_vendor FOREIGN KEY (vendor_id)
        REFERENCES public.vendor (vendor_id) MATCH SIMPLE
        ON UPDATE NO ACTION
        ON DELETE NO ACTION
        NOT VALID
)
TABLESPACE pg_default;

ALTER TABLE IF EXISTS public.invoice_entity
    OWNER to postgres;


-- Table: public.notification_entity

-- DROP TABLE IF EXISTS public.notification_entity;

CREATE TABLE IF NOT EXISTS public.notification_entity
(
    notification_id character varying COLLATE pg_catalog."default" NOT NULL,
    customer_id character varying COLLATE pg_catalog."default" NOT NULL,
    vendor_id character varying COLLATE pg_catalog."default",
    type character varying COLLATE pg_catalog."default" NOT NULL,
    content text COLLATE pg_catalog."default" NOT NULL,
    status character varying COLLATE pg_catalog."default" NOT NULL,  -- Sent, Failed
    sent_date timestamp with time zone NOT NULL,
    created_at timestamp with time zone NOT NULL,
    CONSTRAINT notification_entity_pkey PRIMARY KEY (notification_id),
    CONSTRAINT fk_notification_customer FOREIGN KEY (customer_id)
        REFERENCES public.customer_entity (customer_id) MATCH SIMPLE
        ON UPDATE NO ACTION
        ON DELETE NO ACTION
        NOT VALID,
    CONSTRAINT fk_notification_vendor FOREIGN KEY (vendor_id)
        REFERENCES public.vendor (vendor_id) MATCH SIMPLE
        ON UPDATE NO ACTION
        ON DELETE NO ACTION
        NOT VALID
)
TABLESPACE pg_default;

ALTER TABLE IF EXISTS public.notification_entity
    OWNER to postgres;
