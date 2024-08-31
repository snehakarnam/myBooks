INSERT INTO public.vendor (vendor_id, name, email, phone_number, address, bank_details, created_at, updated_at)
VALUES
('vendor-001', 'Vendor One', 'vendor1@example.com', '123-456-7890', '123 Vendor St, Vendor City', 'Bank1 Account123', now(), now()),
('vendor-002', 'Vendor Two', 'vendor2@example.com', '234-567-8901', '456 Vendor Rd, Vendor Town', 'Bank2 Account456', now(), now()),
('vendor-003', 'Vendor Three', 'vendor3@example.com', '345-678-9012', '789 Vendor Ln, Vendor Village', 'Bank3 Account789', now(), now()),
('vendor-004', 'Vendor Four', 'vendor4@example.com', '456-789-0123', '101 Vendor Blvd, Vendor Town', 'Bank4 Account012', now(), now()),
('vendor-005', 'Vendor Five', 'vendor5@example.com', '567-890-1234', '202 Vendor Pkwy, Vendor City', 'Bank5 Account345', now(), now());

INSERT INTO public.customer (customer_id, name, email, phone_number, address, created_at, updated_at)
VALUES
('customer-001', 'Customer One', 'customer1@example.com', '123-456-7890', '123 Customer St, Customer City', now(), now()),
('customer-002', 'Customer Two', 'customer2@example.com', '234-567-8901', '456 Customer Rd, Customer Town', now(), now()),
('customer-003', 'Customer Three', 'customer3@example.com', '345-678-9012', '789 Customer Ln, Customer Village', now(), now()),
('customer-004', 'Customer Four', 'customer4@example.com', '456-789-0123', '101 Customer Blvd, Customer Town', now(), now()),
('customer-005', 'Customer Five', 'customer5@example.com', '567-890-1234', '202 Customer Pkwy, Customer City', now(), now());

INSERT INTO public.product_group (product_group_id, vendor_id, name, description, created_at, updated_at)
VALUES
('product-group-001', 'vendor-001', 'Product Group One', 'Description for Product Group One', now(), now()),
('product-group-002', 'vendor-002', 'Product Group Two', 'Description for Product Group Two', now(), now()),
('product-group-003', 'vendor-003', 'Product Group Three', 'Description for Product Group Three', now(), now()),
('product-group-004', 'vendor-004', 'Product Group Four', 'Description for Product Group Four', now(), now()),
('product-group-005', 'vendor-005', 'Product Group Five', 'Description for Product Group Five', now(), now());

INSERT INTO public.recurring_plans (plan_id, vendor_id, product_group_id, name, amount, frequency, start_date, end_date, day_of_week, day_of_month, created_at)
VALUES
('plan-001', 'vendor-001', 'product-group-001', 'Monthly Plan One', 19.99, 'Monthly', now(), null, 'Monday', 1, now()),
('plan-002', 'vendor-002', 'product-group-002', 'Weekly Plan One', 9.99, 'Weekly', now(), null, 'Friday', null, now()),
('plan-003', 'vendor-003', 'product-group-003', 'Monthly Plan Two', 29.99, 'Monthly', now(), null, 'Tuesday', 15, now()),
('plan-004', 'vendor-004', 'product-group-004', 'Weekly Plan Two', 14.99, 'Weekly', now(), null, 'Thursday', null, now()),
('plan-005', 'vendor-005', 'product-group-005', 'Annual Plan', 199.99, 'Annually', now(), null, null, 1, now());

INSERT INTO public.subscription (subscription_id, customer_id, plan_id, vendor_id, auto_pay, start_date, end_date, next_billing_date, created_at, updated_at)
VALUES
('subscription-001', 'customer-001', 'plan-001', 'vendor-001', true, now(), null, now() + interval '1 month', now(), now()),
('subscription-002', 'customer-002', 'plan-002', 'vendor-002', false, now(), null, now() + interval '1 week', now(), now()),
('subscription-003', 'customer-003', 'plan-003', 'vendor-003', true, now(), null, now() + interval '1 month', now(), now()),
('subscription-004', 'customer-004', 'plan-004', 'vendor-004', false, now(), null, now() + interval '1 week', now(), now()),
('subscription-005', 'customer-005', 'plan-005', 'vendor-005', true, now(), null, now() + interval '1 year', now(), now());

INSERT INTO public.invoice (invoice_id, subscription_id, customer_id, vendor_id, amount, status, invoice_date, due_date, payment_link, created_at, updated_at)
VALUES
('invoice-001', 'subscription-001', 'customer-001', 'vendor-001', 19.99, 'Pending', now(), now() + interval '1 month', 'http://payment-link.com/invoice-001', now(), now()),
('invoice-002', 'subscription-002', 'customer-002', 'vendor-002', 9.99, 'Paid', now(), now() + interval '1 week', 'http://payment-link.com/invoice-002', now(), now()),
('invoice-003', 'subscription-003', 'customer-003', 'vendor-003', 29.99, 'Pending', now(), now() + interval '1 month', 'http://payment-link.com/invoice-003', now(), now()),
('invoice-004', 'subscription-004', 'customer-004', 'vendor-004', 14.99, 'Paid', now(), now() + interval '1 week', 'http://payment-link.com/invoice-004', now(), now()),
('invoice-005', 'subscription-005', 'customer-005', 'vendor-005', 199.99, 'Pending', now(), now() + interval '1 year', 'http://payment-link.com/invoice-005', now(), now());

INSERT INTO public.notification (notification_id, customer_id, vendor_id, type, content, status, sent_date, created_at)
VALUES
('notification-001', 'customer-001', 'vendor-001', 'Email', 'Your subscription has been renewed.', 'Sent', now(), now()),
('notification-002', 'customer-002', 'vendor-002', 'SMS', 'Your payment is due.', 'Failed', now(), now()),
('notification-003', 'customer-003', 'vendor-003', 'Email', 'Your subscription has been renewed.', 'Sent', now(), now()),
('notification-004', 'customer-004', 'vendor-004', 'SMS', 'Your payment is due.', 'Failed', now(), now()),
('notification-005', 'customer-005', 'vendor-005', 'Email', 'Your annual subscription has been renewed.', 'Sent', now(), now());
