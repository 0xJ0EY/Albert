
INSERT INTO public.project (project_id, name, invoice_id, contact_id, expense_id, quotation_id, created_at, done) VALUES (3, 'Sky', 545, 3453, 5621, 53565, '2017-11-02 12:07:42.4', false);
INSERT INTO public.project (project_id, name, invoice_id, contact_id, expense_id, quotation_id, created_at, done) VALUES (4, 'Drive', 453, 1234, 5435, 45343, '2014-11-02 12:21:28.493', false);
INSERT INTO public.project (project_id, name, invoice_id, contact_id, expense_id, quotation_id, created_at, done) VALUES (2, 'Posten', 234, 2345, 8787, 23456, '2016-05-03 11:51:05.265', true);
INSERT INTO public.project (project_id, name, invoice_id, contact_id, expense_id, quotation_id, created_at, done) VALUES (1, 'Natuur ', 123, 1234, 1234, 12345, '2018-11-02 10:56:27.07', true);
INSERT INTO public.project (project_id, name, invoice_id, contact_id, expense_id, quotation_id, created_at, done) VALUES (5, 'Bank', 365, 8678, 2324, 95865, '2013-11-05 12:41:23.149', false);
INSERT INTO public.project (project_id, name, invoice_id, contact_id, expense_id, quotation_id, created_at, done) VALUES (6, 'Bedrijf', 768, 2344, 5462, 23564, '2011-07-02 13:49:09.56', false);
INSERT INTO public.project (project_id, name, invoice_id, contact_id, expense_id, quotation_id, created_at, done) VALUES (7, 'Auto', 536, 6743, 3655, 93786, '2015-07-07 14:17:35.348', false);

INSERT INTO public.tax (tax_id, name, percentage) VALUES (345, 'natuur_btw', 30);
INSERT INTO public.tax (tax_id, name, percentage) VALUES (876, 'posten_btw', 20);
INSERT INTO public.tax (tax_id, name, percentage) VALUES (756, 'Sky_btw', 10);
INSERT INTO public.tax (tax_id, name, percentage) VALUES (563, 'Bank_btw', 3);
INSERT INTO public.tax (tax_id, name, percentage) VALUES (2432, 'Bedrijf_tax', 2);


INSERT INTO public.report (report_id, end_date, start_date) VALUES (95, '2017-09-09 11:21:08.233', '2017-06-03 11:21:26.483');
INSERT INTO public.report (report_id, end_date, start_date) VALUES (56, '2018-11-02 12:03:21.118', '2017-11-02 12:03:24.43');
INSERT INTO public.report (report_id, end_date, start_date) VALUES (64, '2016-05-02 12:13:27.629', '2015-11-02 12:13:37.939');
INSERT INTO public.report (report_id, end_date, start_date) VALUES (45, '2014-11-02 14:04:44.323', '2013-11-02 14:04:54.1');
INSERT INTO public.report (report_id, end_date, start_date) VALUES (423, '2018-11-04 14:08:50.882', '2017-11-02 14:08:55.765');

INSERT INTO public.contact (contact_id, first_name, last_name, tel_number, postal_code, street_name, house_number, city, created_at, website, description, project_id) VALUES (1234, 'Richard', 'Hary', 643456734, '2134 GB', 'Tolheksbos', '84', 'Hoofddorp', '2014-09-01 11:17:26.091', 'www.R-hary.nl', 'Dat is een vaste klant', 1);
INSERT INTO public.contact (contact_id, first_name, last_name, tel_number, postal_code, street_name, house_number, city, created_at, website, description, project_id) VALUES (2345, 'Alex', 'Barbara', 693293944, '2344 DD', 'Aardenburg', '345', 'Amsterdam', '2017-01-04 11:47:45.086', 'www.A-barbara.com', 'nieuewe klant', 2);
INSERT INTO public.contact (contact_id, first_name, last_name, tel_number, postal_code, street_name, house_number, city, created_at, website, description, project_id) VALUES (3453, 'Karmer', 'Harmsen', 683716273, '3443 SA', 'Markt ', '4', 'Leiden', '2015-07-02 12:05:13.357', 'www.K-harmen.com', 'nieuwe klant', 3);
INSERT INTO public.contact (contact_id, first_name, last_name, tel_number, postal_code, street_name, house_number, city, created_at, website, description, project_id) VALUES (8678, 'bennink', 'Andre', 643577677, '5436 TY', 'Rozenlaan', '7', 'Rotterdam ', '2016-11-04 12:55:34.186', 'www.B.Andre.com', 'Een vaste klant', 4);
INSERT INTO public.contact (contact_id, first_name, last_name, tel_number, postal_code, street_name, house_number, city, created_at, website, description, project_id) VALUES (2344, 'Ruud
', 'Gerard', 543342145, '2425 Al', 'Iplaan', '34', 'Haalrm', '2012-11-09 12:52:50.776', 'www.R-Gererad.nl', 'vaste klant', 6);

INSERT INTO public.amount (amount_id, hours, price, contact_id) VALUES (345, 25, 1500, 1234);
INSERT INTO public.amount (amount_id, hours, price, contact_id) VALUES (261, 19, 1200, 2345);
INSERT INTO public.amount (amount_id, hours, price, contact_id) VALUES (778, 12, 1093, 3453);
INSERT INTO public.amount (amount_id, hours, price, contact_id) VALUES (535, 43, 1245, 8678);
INSERT INTO public.amount (amount_id, hours, price, contact_id) VALUES (565, 54, 1233, 1234);
INSERT INTO public.amount (amount_id, hours, price, contact_id) VALUES (234, 23, 4342, 2344);

INSERT INTO public.quotation (name, quotation_id, description, product, amount_id, created_at, project_id, hours_expected) VALUES ('Sky offerte', 53565, 'offerte voor sky', 'sky product', 778, '2016-12-04 12:16:22.896', 3, 46);
INSERT INTO public.quotation (name, quotation_id, description, product, amount_id, created_at, project_id, hours_expected) VALUES ('Posten offerte', 23456, 'offerte voor posten', 'post product', 261, '2017-11-02 11:53:29.982', 2, 43);
INSERT INTO public.quotation (name, quotation_id, description, product, amount_id, created_at, project_id, hours_expected) VALUES ('Natuur offerte', 12345, 'Offerte voor het project natuur', 'Natuur product', 345, '2014-06-05 11:13:51.999', 1, 3);
INSERT INTO public.quotation (name, quotation_id, description, product, amount_id, created_at, project_id, hours_expected) VALUES ('Bank offerte', 95865, 'Offerte voor Bank', 'Bank product', 535, '2018-08-04 13:16:53.751', 5, 60);
INSERT INTO public.quotation (name, quotation_id, description, product, amount_id, created_at, project_id, hours_expected) VALUES ('Drive offerte', 45343, 'Offerte voor Drive', 'Drive product', 565, '2016-12-04 13:44:04.651', 4, 12);
INSERT INTO public.quotation (name, quotation_id, description, product, amount_id, created_at, project_id, hours_expected) VALUES ('Bedrijf offerte', 23564, 'Offerte voor Bedrijf', 'Bedrijf product', 234, '2013-07-07 14:08:19.03', 6, 53);



INSERT INTO public.invoice (invoice_id, paid, tax_id, project_id, created_at, amount_id, deliverydate) VALUES (123, 'betaald', 345, 1, '2015-01-01 10:58:39.061', 345, '2016-08-03 10:59:42.4');
INSERT INTO public.invoice (invoice_id, paid, tax_id, project_id, created_at, amount_id, deliverydate) VALUES (234, 'onbetaald', 876, 2, '2017-11-02 12:00:47.826', 261, '2017-07-02 12:01:24.817');
INSERT INTO public.invoice (invoice_id, paid, tax_id, project_id, created_at, amount_id, deliverydate) VALUES (545, 'onbtaald', 756, 3, '2017-07-02 12:11:10.318', 778, '2017-12-02 12:11:32.891');
INSERT INTO public.invoice (invoice_id, paid, tax_id, project_id, created_at, amount_id, deliverydate) VALUES (365, 'Onbetaald', 563, 5, '2016-11-02 13:05:07.964', 535, '2018-11-06 13:11:40.728');
INSERT INTO public.invoice (invoice_id, paid, tax_id, project_id, created_at, amount_id, deliverydate) VALUES (768, 'Afwachting', 2432, 6, '2014-09-07 14:01:49.123', 234, '2013-07-04 14:03:17.016');


INSERT INTO public.expense (expense_id, price, created_at, description, name) VALUES (1234, 15, '2015-01-01 11:02:11.984', 'Onkosten voor Natuur project', 'Natuur onkosten');
INSERT INTO public.expense (expense_id, price, created_at, description, name) VALUES (8787, 14, '2017-05-01 11:58:42.908', 'onkosten voor posten project', 'Posten onkosten');
INSERT INTO public.expense (expense_id, price, created_at, description, name) VALUES (5621, 33, '2017-09-08 12:08:41.285', 'Onkosten voor Sky project', 'Sky onkosten');
INSERT INTO public.expense (expense_id, price, created_at, description, name) VALUES (2324, 56, '2016-11-02 13:01:24.108', 'Onkosten voor Bank project', 'Bank onkosten');
INSERT INTO public.expense (expense_id, price, created_at, description, name) VALUES (5462, 43, '2013-10-05 13:59:23.234', 'Onkosten voor Bedrijf', 'Bedrijf onkosten');


INSERT INTO public.contact_email (email_id, contact_id, email_address) VALUES (445576, 8678, 'B-andre@hsleiden.nl');
INSERT INTO public.contact_email (email_id, contact_id, email_address) VALUES (757825, 3453, 'K-harsmen@hasleiden.nl');
INSERT INTO public.contact_email (email_id, contact_id, email_address) VALUES (234561, 2345, 'A-bar@hsleiden.nl');
INSERT INTO public.contact_email (email_id, contact_id, email_address) VALUES (123456, 1234, 'R-hary@hsleiden.nl');
INSERT INTO public.contact_email (email_id, contact_id, email_address) VALUES (45664756, 2344, 'r-gereard@hsleiden.nl');





