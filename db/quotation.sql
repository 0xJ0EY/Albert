--
-- PostgreSQL database dump
--

-- Dumped from database version 10.1
-- Dumped by pg_dump version 10.4

-- Started on 2018-11-03 09:30:06

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
-- TOC entry 203 (class 1259 OID 41460)
-- Name: quotationId; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.quotationId (
    name character varying,
    quotation_id bigint NOT NULL,
    description character varying,
    product character varying,
    amount_id integer,
    created_at timestamp without time zone,
    project_id integer,
    hours_excpected integer
);


ALTER TABLE public.quotationId OWNER TO postgres;

--
-- TOC entry 202 (class 1259 OID 41458)
-- Name: quotation_quotation_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.quotation_quotation_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.quotation_quotation_id_seq OWNER TO postgres;

--
-- TOC entry 2849 (class 0 OID 0)
-- Dependencies: 202
-- Name: quotation_quotation_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.quotation_quotation_id_seq OWNED BY public.quotationId.quotation_id;


--
-- TOC entry 2715 (class 2604 OID 41463)
-- Name: quotationId quotation_id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.quotationId ALTER COLUMN quotation_id SET DEFAULT nextval('public.quotation_quotation_id_seq'::regclass);


--
-- TOC entry 2842 (class 0 OID 41460)
-- Dependencies: 203
-- Data for Name: quotationId; Type: TABLE DATA; Schema: public; Owner: postgres
--

INSERT INTO public.quotationId (name, quotation_id, description, product, amount_id, created_at, project_id, hours_excpected) VALUES ('Sky offerte', 53565, 'offerte voor sky', 'sky product', 778, '2016-12-04 12:16:22.896', 3, 46);
INSERT INTO public.quotationId (name, quotation_id, description, product, amount_id, created_at, project_id, hours_excpected) VALUES ('Posten offerte', 23456, 'offerte voor posten', 'post product', 261, '2017-11-02 11:53:29.982', 2, 43);
INSERT INTO public.quotationId (name, quotation_id, description, product, amount_id, created_at, project_id, hours_excpected) VALUES ('Natuur offerte', 12345, 'Offerte voor het project natuur', 'Natuur product', 345, '2014-06-05 11:13:51.999', 1, 3);
INSERT INTO public.quotationId (name, quotation_id, description, product, amount_id, created_at, project_id, hours_excpected) VALUES ('Bank offerte', 95865, 'Offerte voor Bank', 'Bank product', 535, '2018-08-04 13:16:53.751', 5, 60);
INSERT INTO public.quotationId (name, quotation_id, description, product, amount_id, created_at, project_id, hours_excpected) VALUES ('Drive offerte', 45343, 'Offerte voor Drive', 'Drive product', 565, '2016-12-04 13:44:04.651', 4, 12);
INSERT INTO public.quotationId (name, quotation_id, description, product, amount_id, created_at, project_id, hours_excpected) VALUES ('Bedrijf offerte', 23564, 'Offerte voor Bedrijf', 'Bedrijf product', 234, '2013-07-07 14:08:19.03', 6, 53);


--
-- TOC entry 2851 (class 0 OID 0)
-- Dependencies: 202
-- Name: quotation_quotation_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.quotation_quotation_id_seq', 1, false);


--
-- TOC entry 2717 (class 2606 OID 41468)
-- Name: quotationId quotation_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.quotationId
    ADD CONSTRAINT quotation_pkey PRIMARY KEY (quotation_id);


--
-- TOC entry 2719 (class 2606 OID 41538)
-- Name: quotationId fk_quotationamount; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.quotationId
    ADD CONSTRAINT fk_quotationamount FOREIGN KEY (amount_id) REFERENCES public.amount(amount_id);


--
-- TOC entry 2718 (class 2606 OID 41528)
-- Name: quotationId fk_quotationproject; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.quotationId
    ADD CONSTRAINT fk_quotationproject FOREIGN KEY (project_id) REFERENCES public.project(project_id);


--
-- TOC entry 2848 (class 0 OID 0)
-- Dependencies: 203
-- Name: TABLE quotationId; Type: ACL; Schema: public; Owner: postgres
--

GRANT ALL ON TABLE public.quotationId TO albert WITH GRANT OPTION;


--
-- TOC entry 2850 (class 0 OID 0)
-- Dependencies: 202
-- Name: SEQUENCE quotation_quotation_id_seq; Type: ACL; Schema: public; Owner: postgres
--

GRANT ALL ON SEQUENCE public.quotation_quotation_id_seq TO albert WITH GRANT OPTION;


-- Completed on 2018-11-03 09:30:06

--
-- PostgreSQL database dump complete
--

