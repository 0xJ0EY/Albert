--
-- PostgreSQL database dump
--

-- Dumped from database version 10.1
-- Dumped by pg_dump version 10.4

-- Started on 2018-11-03 09:32:54

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
-- TOC entry 201 (class 1259 OID 41449)
-- Name: tax; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.tax (
    tax_id bigint NOT NULL,
    name character varying,
    percentage integer
);


ALTER TABLE public.tax OWNER TO postgres;

--
-- TOC entry 200 (class 1259 OID 41447)
-- Name: tax_tax_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.tax_tax_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.tax_tax_id_seq OWNER TO postgres;

--
-- TOC entry 2847 (class 0 OID 0)
-- Dependencies: 200
-- Name: tax_tax_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.tax_tax_id_seq OWNED BY public.tax.tax_id;


--
-- TOC entry 2715 (class 2604 OID 41452)
-- Name: tax tax_id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.tax ALTER COLUMN tax_id SET DEFAULT nextval('public.tax_tax_id_seq'::regclass);


--
-- TOC entry 2840 (class 0 OID 41449)
-- Dependencies: 201
-- Data for Name: tax; Type: TABLE DATA; Schema: public; Owner: postgres
--

INSERT INTO public.tax (tax_id, name, percentage) VALUES (345, 'natuur_btw', 30);
INSERT INTO public.tax (tax_id, name, percentage) VALUES (876, 'posten_btw', 20);
INSERT INTO public.tax (tax_id, name, percentage) VALUES (756, 'Sky_btw', 10);
INSERT INTO public.tax (tax_id, name, percentage) VALUES (563, 'Bank_btw', 3);
INSERT INTO public.tax (tax_id, name, percentage) VALUES (2432, 'Bedrijf_tax', 2);


--
-- TOC entry 2849 (class 0 OID 0)
-- Dependencies: 200
-- Name: tax_tax_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.tax_tax_id_seq', 1, false);


--
-- TOC entry 2717 (class 2606 OID 41457)
-- Name: tax tax_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.tax
    ADD CONSTRAINT tax_pkey PRIMARY KEY (tax_id);


--
-- TOC entry 2846 (class 0 OID 0)
-- Dependencies: 201
-- Name: TABLE tax; Type: ACL; Schema: public; Owner: postgres
--

GRANT ALL ON TABLE public.tax TO albert WITH GRANT OPTION;


--
-- TOC entry 2848 (class 0 OID 0)
-- Dependencies: 200
-- Name: SEQUENCE tax_tax_id_seq; Type: ACL; Schema: public; Owner: postgres
--

GRANT ALL ON SEQUENCE public.tax_tax_id_seq TO albert WITH GRANT OPTION;


-- Completed on 2018-11-03 09:32:55

--
-- PostgreSQL database dump complete
--

