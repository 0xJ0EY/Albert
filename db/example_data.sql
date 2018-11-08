INSERT INTO public.project (project_id, name, contact_id, created_at, done) VALUES (3, 'Sky', 3453, '2017-11-02 12:07:42.4', false);
INSERT INTO public.project (project_id, name, contact_id, created_at, done) VALUES (4, 'Drive', 1234, '2014-11-02 12:21:28.493', false);
INSERT INTO public.project (project_id, name, contact_id, created_at, done) VALUES (2, 'Posten', 2345, '2016-05-03 11:51:05.265', true);
INSERT INTO public.project (project_id, name, contact_id, created_at, done) VALUES (1, 'Natuur ', 1234, '2018-11-02 10:56:27.07', true);
INSERT INTO public.project (project_id, name, contact_id, created_at, done) VALUES (5, 'Bank', 8678, '2013-11-05 12:41:23.149', false);
INSERT INTO public.project (project_id, name, contact_id, created_at, done) VALUES (6, 'Bedrijf', 2344, '2011-07-02 13:49:09.56', true);
INSERT INTO public.project (project_id, name, contact_id, created_at, done) VALUES (7, 'Auto', 6743, '2015-07-07 14:17:35.348', false);

INSERT INTO public.tax (tax_id, name, percentage) VALUES (1, 'btw', 21);

INSERT INTO public.report (report_id, end_date, start_date) VALUES (1, '2017-09-09 11:21:08.233', '2017-06-03 11:21:26.483');
INSERT INTO public.report (report_id, end_date, start_date) VALUES (2, '2018-11-02 12:03:21.118', '2017-11-02 12:03:24.43');
INSERT INTO public.report (report_id, end_date, start_date) VALUES (3, '2016-05-02 12:13:27.629', '2015-11-02 12:13:37.939');
INSERT INTO public.report (report_id, end_date, start_date) VALUES (4, '2014-11-02 14:04:44.323', '2013-11-02 14:04:54.1');
INSERT INTO public.report (report_id, end_date, start_date) VALUES (5, '2018-11-04 14:08:50.882', '2017-11-02 14:08:55.765');

INSERT INTO public.contact (contact_id, first_name, last_name, company, postal_code, street_name, house_number, city, created_at, website, description) VALUES (1, 'Richard', 'Hary', 'Heineken', '2134 GB', 'Tolheksbos', '84', 'Hoofddorp', '2014-09-01 11:17:26.091', 'www.R-hary.nl', 'Een vaste klant');
INSERT INTO public.contact (contact_id, first_name, last_name, company, postal_code, street_name, house_number, city, created_at, website, description) VALUES (2, 'Alex', 'Barbara', 'Pearson', '2344 DD', 'Aardenburg', '345', 'Amsterdam', '2017-01-04 11:47:45.086', 'www.A-barbara.com', 'Een kennis');
INSERT INTO public.contact (contact_id, first_name, last_name, company, postal_code, street_name, house_number, city, created_at, website, description) VALUES (3, 'Karmer', 'Harmsen', 'Pioneer', '3443 SA', 'Markt ', '4', 'Leiden', '2015-07-02 12:05:13.357', 'www.K-harmen.com', 'Nieuwe klant');
INSERT INTO public.contact (contact_id, first_name, last_name, company, postal_code, street_name, house_number, city, created_at, website, description) VALUES (4, 'bennink', 'Andre', 'ASUS', '5436 TY', 'Rozenlaan', '7', 'Rotterdam ', '2016-11-04 12:55:34.186', 'www.B.Andre.com', 'Een vaste klant');
INSERT INTO public.contact (contact_id, first_name, last_name, company, postal_code, street_name, house_number, city, created_at, website, description) VALUES (5, 'Ruud', 'Gerard', 'NVIDIA', '2425 Al', 'Iplaan', '34', 'Haarkem', '2012-11-09 12:52:50.776', 'www.R-Gererad.nl', 'Vaste klant');

INSERT INTO public.amount (amount_id, hours, price, contact_id) VALUES (1, 25, 1500, 1);
INSERT INTO public.amount (amount_id, hours, price, contact_id) VALUES (2, 19, 1200, 2);
INSERT INTO public.amount (amount_id, hours, price, contact_id) VALUES (3, 12, 1093, 2);
INSERT INTO public.amount (amount_id, hours, price, contact_id) VALUES (4, 43, 1245, 4);
INSERT INTO public.amount (amount_id, hours, price, contact_id) VALUES (5, 54, 1233, 3);
INSERT INTO public.amount (amount_id, hours, price, contact_id) VALUES (6, 23, 4342, 1);

INSERT INTO public.quotation (name, quotation_id, description, product, amount_id, created_at, project_id, hours_expected, price_expected) VALUES ('Sky offerte', 1, 'offerte voor sky', 'sky product', 1, '2016-12-04 12:16:22.896', 1, 46, 500);
INSERT INTO public.quotation (name, quotation_id, description, product, amount_id, created_at, project_id, hours_expected, price_expected) VALUES ('Posten offerte', 2, 'offerte voor posten', 'post product', 2, '2017-11-02 11:53:29.982', 2, 43, 480);
INSERT INTO public.quotation (name, quotation_id, description, product, amount_id, created_at, project_id, hours_expected, price_expected) VALUES ('Natuur offerte', 3, 'Offerte voor het project natuur', 'Natuur product', 3, '2014-06-05 11:13:51.999', 3, 3, 70);
INSERT INTO public.quotation (name, quotation_id, description, product, amount_id, created_at, project_id, hours_expected, price_expected) VALUES ('Bank offerte', 4, 'Offerte voor Bank', 'Bank product', 4, '2018-08-04 13:16:53.751', 4, 60, 700);
INSERT INTO public.quotation (name, quotation_id, description, product, amount_id, created_at, project_id, hours_expected, price_expected) VALUES ('Drive offerte', 5, 'Offerte voor Drive', 'Drive product', 5, '2016-12-04 13:44:04.651', 5, 12, 200);
INSERT INTO public.quotation (name, quotation_id, description, product, amount_id, created_at, project_id, hours_expected, price_expected) VALUES ('Bedrijf offerte', 6, 'Offerte voor Bedrijf', 'Bedrijf product', 6, '2013-07-07 14:08:19.03', 6, 53, 630);

INSERT INTO public.invoice (invoice_id, paid, tax_id, project_id, created_at, amount_id, deliverydate, description) VALUES (1, 'true', 1, 1, '2015-01-01 10:58:39.061', 1, '2016-08-03 10:59:42.4', 'van een vriend');
INSERT INTO public.invoice (invoice_id, paid, tax_id, project_id, created_at, amount_id, deliverydate, description) VALUES (2, 'false', 1, 2, '2017-03-02 12:00:47.826', 2, '2017-07-02 12:01:24.817', 'belangrijke betaling');
INSERT INTO public.invoice (invoice_id, paid, tax_id, project_id, created_at, amount_id, deliverydate, description) VALUES (3, 'true', 1, 3, '2017-07-02 12:11:10.318', 3, '2017-12-02 12:11:32.891', 'belangrijk');
INSERT INTO public.invoice (invoice_id, paid, tax_id, project_id, created_at, amount_id, deliverydate, description) VALUES (4, 'false', 1, 5, '2016-11-02 13:05:07.964', 4, '2018-11-06 13:11:40.728', 'minder belangrijk');
INSERT INTO public.invoice (invoice_id, paid, tax_id, project_id, created_at, amount_id, deliverydate, description) VALUES (5, 'false', 1, 6, '2014-09-07 14:01:49.123', 5, '2015-07-04 14:03:17.016', 'verloopt snel');

INSERT INTO public.expense (expense_id, price, created_at, description, name) VALUES (1, 15, '2015-01-01 11:02:11.984', 'Onkosten voor Natuur project', 'Natuur onkosten');
INSERT INTO public.expense (expense_id, price, created_at, description, name) VALUES (2, 14, '2017-05-01 11:58:42.908', 'onkosten voor posten project', 'Posten onkosten');
INSERT INTO public.expense (expense_id, price, created_at, description, name) VALUES (3, 33, '2017-09-08 12:08:41.285', 'Onkosten voor Sky project', 'Sky onkosten');
INSERT INTO public.expense (expense_id, price, created_at, description, name) VALUES (4, 56, '2016-11-02 13:01:24.108', 'Onkosten voor Bank project', 'Bank onkosten');
INSERT INTO public.expense (expense_id, price, created_at, description, name) VALUES (5, 43, '2013-10-05 13:59:23.234', 'Onkosten voor Bedrijf', 'Bedrijf onkosten');

INSERT INTO public.contact_email (id, contact_id, email_address) VALUES (445576, 1, 'B-andre@gmail.com');
INSERT INTO public.contact_email (id, contact_id, email_address) VALUES (757825, 2, 'K-harsmen@ziggo.nl');
INSERT INTO public.contact_email (id, contact_id, email_address) VALUES (234561, 1, 'A-bar@gmail.com');
INSERT INTO public.contact_email (id, contact_id, email_address) VALUES (123456, 3, 'R-hary@outlook.com');
INSERT INTO public.contact_email (id, contact_id, email_address) VALUES (45664756, 4, 'r-gereard@nvidia.com');

INSERT INTO public.contact_phone (id, contact_id, phone_number) VALUES (445576, 1, '+31612345678');
INSERT INTO public.contact_phone (id, contact_id, phone_number) VALUES (757825, 2, '0683657689');
INSERT INTO public.contact_phone (id, contact_id, phone_number) VALUES (234561, 1, '+31698797350');
INSERT INTO public.contact_phone (id, contact_id, phone_number) VALUES (123456, 3, '0614643712');
INSERT INTO public.contact_phone (id, contact_id, phone_number) VALUES (45664756, 4, '+31687468528');



