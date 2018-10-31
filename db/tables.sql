CREATE TABLE project
(
    project_id BIGSERIAL PRIMARY KEY,
    name VARCHAR,
    invoice_id integer,
    contact_id integer,
    expense_id integer,
    quotation_id integer,
    created_at TIMESTAMP,
    done BOOLEAN DEFAULT FALSE
);

CREATE TABLE invoice
(
    invoice_id BIGSERIAL PRIMARY KEY,
    paid VARCHAR(15),
    tax_id integer,
    created_at TIMESTAMP,
    amount integer,
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
    created_at TIMESTAMP
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
    name varchar
);

CREATE TABLE contact
(
    contact_id BIGSERIAL PRIMARY KEY,
    first_name varchar,
    last_name varchar,
    tel_number integer,
    postal_code varchar,
    street_name varchar,
    house_number varchar,
    created_at TIMESTAMP,
    website varchar,
    description varchar
);

CREATE TABLE contact_email
(
    email_id BIGSERIAL PRIMARY KEY,
    contact_id integer,
    email_address varchar
);





