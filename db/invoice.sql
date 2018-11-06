--
-- PostgreSQL database dump
--

-- Dumped from database version 10.1
-- Dumped by pg_dump version 10.4

-- Started on 2018-11-03 09:28:40

SET statement_timeout = 0;
SET lock_timeout = 0;
SET idle_in_transaction_session_timeout = 0;
SET client_encoding = 'UTF8';
SET standard_conforming_strings = on;
SELECT pg_catalog.set_config('search_path', '', false);
SET check_function_bodies = false;
SET client_min_messages = warning;
SET row_security = off;

SET default_tablespace = '';

SET default_with_oids = false;

--
-- TOC entry 199 (class 1259 OID 41441)
-- Name: invoiceId; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.invoiceId (
    invoice_id bigint NOT NULL,
    paid character varying(15),
    tax_id integer,
    project_id integer,
    created_at timestamp without time zone,
    amount_id integer,
    deliverydate timestamp without time zone
);


ALTER TABLE public.invoiceId OWNER TO postgres;

--
-- TOC entry 198 (class 1259 OID 41439)
-- Name: invoice_invoice_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.invoice_invoice_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.invoice_invoice_id_seq OWNER TO postgres;

--
-- TOC entry 2849 (class 0 OID 0)
-- Dependencies: 198
-- Name: invoice_invoice_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.invoice_invoice_id_seq OWNED BY public.invoiceId.invoice_id;


--
-- TOC entry 2715 (class 2604 OID 41444)
-- Name: invoiceId invoice_id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.invoiceId ALTER COLUMN invoice_id SET DEFAULT nextval('public.invoice_invoice_id_seq'::regclass);


--
-- TOC entry 2842 (class 0 OID 41441)
-- Dependencies: 199
-- Data for Name: invoiceId; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.invoiceId (invoice_id, paid, tax_id, project_id, created_at, amount_id, deliverydate) FROM stdin;
123	betaald	345	1	2015-01-01 10:58:39.061	345	2016-08-03 10:59:42.4
234	onbetaald	876	2	2017-11-02 12:00:47.826	261	2017-07-02 12:01:24.817
545	onbtaald	756	3	2017-07-02 12:11:10.318	778	2017-12-02 12:11:32.891
365	Onbetaald	563	5	2016-11-02 13:05:07.964	535	2018-11-06 13:11:40.728
768	Afwachting	2432	6	2014-09-07 14:01:49.123	234	2013-07-04 14:03:17.016
\.


--
-- TOC entry 2851 (class 0 OID 0)
-- Dependencies: 198
-- Name: invoice_invoice_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.invoice_invoice_id_seq', 1, false);


--
-- TOC entry 2717 (class 2606 OID 41446)
-- Name: invoiceId invoice_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.invoiceId
    ADD CONSTRAINT invoice_pkey PRIMARY KEY (invoice_id);


--
-- TOC entry 2718 (class 2606 OID 41518)
-- Name: invoiceId fk_invoiceproject; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.invoiceId
    ADD CONSTRAINT fk_invoiceproject FOREIGN KEY (project_id) REFERENCES public.project(project_id);


--
-- TOC entry 2719 (class 2606 OID 41523)
-- Name: invoiceId fk_invoicetax; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.invoiceId
    ADD CONSTRAINT fk_invoicetax FOREIGN KEY (tax_id) REFERENCES public.tax(tax_id);


--
-- TOC entry 2848 (class 0 OID 0)
-- Dependencies: 199
-- Name: TABLE invoiceId; Type: ACL; Schema: public; Owner: postgres
--

GRANT ALL ON TABLE public.invoiceId TO albert WITH GRANT OPTION;


--
-- TOC entry 2850 (class 0 OID 0)
-- Dependencies: 198
-- Name: SEQUENCE invoice_invoice_id_seq; Type: ACL; Schema: public; Owner: postgres
--

GRANT ALL ON SEQUENCE public.invoice_invoice_id_seq TO albert WITH GRANT OPTION;


-- Completed on 2018-11-03 09:28:40

--
-- PostgreSQL database dump complete
--

