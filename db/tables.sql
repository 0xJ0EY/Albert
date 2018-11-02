CREATE TABLE project
(
    project_id BIGSERIAL PRIMARY KEY,
    name VARCHAR,
    contact_id integer,
    created_at TIMESTAMP,
    done BOOLEAN DEFAULT FALSE
);

CREATE TABLE invoice
(
    invoice_id BIGSERIAL PRIMARY KEY,
    paid VARCHAR(15),
    tax_id integer,
    project_id integer,
    created_at TIMESTAMP,
    amount_id integer,
    deliverydate TIMESTAMP
);

CREATE TABLE tax
(
    tax_id BIGSERIAL PRIMARY KEY,
    name VARCHAR,
    percentage integer
);

CREATE TABLE quotation
(
    name VARCHAR,
    quotation_id BIGSERIAL PRIMARY KEY,
    description VARCHAR,
    product VARCHAR,
    amount_id integer,
    created_at TIMESTAMP,
    project_id integer
);

CREATE TABLE report
(
    report_id BIGSERIAL PRIMARY KEY,
    end_date TIMESTAMP,
    start_date TIMESTAMP
);

CREATE TABLE expense
(
    expense_id BIGSERIAL PRIMARY KEY,
    price numeric(2),
    created_at TIMESTAMP,
    description varchar,
    name varchar
);

CREATE TABLE amount
(
    amount_id BIGSERIAL PRIMARY KEY,
    hours integer,
    price integer,
    contact_id integer
);

CREATE TABLE contact
(
    contact_id BIGSERIAL PRIMARY KEY,
    first_name varchar,
    last_name varchar,
    postal_code varchar,
    street_name varchar,
    house_number varchar,
    city varchar,
    created_at TIMESTAMP,
    website varchar,
    description varchar,
    project_id integer
);

CREATE TABLE contact_email
(
    email_id BIGSERIAL PRIMARY KEY,
    contact_id integer,
    email_address varchar
);

-- auto-generated definition
CREATE TABLE contact_phone
(
  id           BIGSERIAL NOT NULL
    CONSTRAINT contact_phone_pkey
    PRIMARY KEY,
  phone_number VARCHAR(20),
  contact_id   BIGINT
    CONSTRAINT fk_contact_phone
    REFERENCES contact
    ON UPDATE CASCADE ON DELETE CASCADE
);

CREATE UNIQUE INDEX contact_phone_id_uindex
  ON contact_phone (id);

ALTER TABLE invoice
ADD CONSTRAINT fk_invoiceproject fOREIGN KEY (project_id)
REFERENCES project(project_id);

ALTER TABLE invoice
ADD CONSTRAINT fk_invoicetax fOREIGN KEY (tax_id)
REFERENCES tax(tax_id);

ALTER TABLE quotation
ADD CONSTRAINT fk_quotationproject fOREIGN KEY (project_id)
REFERENCES project(project_id);

ALTER TABLE contact
ADD CONSTRAINT fk_contactproject fOREIGN KEY (project_id)
REFERENCES project(project_id);

ALTER TABLE quotation
ADD CONSTRAINT fk_quotationamount FOREIGN KEY (amount_id)
REFERENCES amount(amount_id);

ALTER TABLE contact_email
ADD CONSTRAINT fk_contactemails FOREIGN KEY (contact_id)
REFERENCES contact(contact_id);

ALTER TABLE amount
ADD CONSTRAINT fk_amountcontact FOREIGN KEY (contact_id)
REFERENCES contact(contact_id);