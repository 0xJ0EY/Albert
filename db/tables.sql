DROP TABLE IF EXISTS public.projects;

CREATE TABLE public.projects
(
    id BIGSERIAL PRIMARY KEY NOT NULL,
    name VARCHAR(100) NOT NULL,
    finished BOOLEAN DEFAULT FALSE,
    created_at TIMESTAMP DEFAULT NOW() NOT NULL,
    updated_at TIMESTAMP
);

CREATE TABLE project
(
    project_id integer PRIMARY KEY,
    name VARCHAR,
    created_at TIMESTAMP,
    afgerond BOOLEAN DEFAULT FALSE
);

CREATE TABLE invoice
(
    invoice_id integer PRIMARY KEY,
    paid BOOLEAN DEFAULT FALSE,
    created_at TIMESTAMP,
    amount integer,
    deliverydate TIMESTAMP
);

CREATE TABLE tax
(
    tax_id integer PRIMARY KEY,
    name VARCHAR,
    percentage integer,
    created_at TIMESTAMP
);

CREATE TABLE quotation
(
    name VARCHAR,
    quotation_id integer PRIMARY KEY,
    description VARCHAR,
    delivery VARCHAR,
    costs integer,
    updated_at TIMESTAMP,
    created_at TIMESTAMP
);

CREATE TABLE report
(
    report_id integer PRIMARY KEY,
    created_at TIMESTAMP,
    end_date TIMESTAMP,
    start_date TIMESTAMP
);

CREATE TABLE expense
(
    expense_id integer PRIMARY KEY,
    updated_at TIMESTAMP,
    price integer,
    created_at TIMESTAMP,
    company varchar,
    name varchar
);

CREATE TABLE supplier
(
    name varchar,
    tel_number integer
);

CREATE TABLE customer
(
    customer_id integer PRIMARY KEY,
    f_name varchar,
    b_name varchar,
    tel_number integer,
    email_address varchar,
    postal_code varchar,
    street_name varchar,
    house_nr varchar,
    created_at TIMESTAMP,
    updated_at TIMESTAMP
);

CREATE TABLE company
(
    company_customer_id integer PRIMARY KEY,
    name varchar
);

CREATE TABLE private
(
    private_customer_id integer PRIMARY KEY,
    type varchar
);




