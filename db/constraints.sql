ALTER TABLE project
ADD CONSTRAINT fk_projectinvoice FOREIGN KEY (invoice_id)
REFERENCES invoice(invoice_id);

ALTER TABLE project
ADD CONSTRAINT fk_projectcontact FOREIGN KEY (contact_id)
REFERENCES contact(contact_id);

ALTER TABLE project
ADD CONSTRAINT fk_projectexpense FOREIGN KEY (expense_id)
REFERENCES expense(expense_id);

ALTER TABLE project
ADD CONSTRAINT fk_projectinvoice FOREIGN KEY (quotation_id)
REFERENCES quotation(quotation_id);


ALTER TABLE quotation
ADD CONSTRAINT fk_quotationamount FOREIGN KEY (amount_id)
REFERENCES amount(amount_id);

ALTER TABLE contact_email
ADD CONSTRAINT fk_contactemails FOREIGN KEY (contact_id)
REFERENCES contact(contact_id);





