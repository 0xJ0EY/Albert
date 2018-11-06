--
-- PostgreSQL database dump
--

-- Dumped from database version 10.1
-- Dumped by pg_dump version 10.4

-- Started on 2018-11-03 09:27:30

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
-- TOC entry 213 (class 1259 OID 41509)
-- Name: contact_email; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.contact_email (
    email_id bigint NOT NULL,
    contact_id integer,
    email_address character varying
);


ALTER TABLE public.contact_email OWNER TO postgres;

--
-- TOC entry 212 (class 1259 OID 41507)
-- Name: contact_email_email_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.contact_email_email_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.contact_email_email_id_seq OWNER TO postgres;

--
-- TOC entry 2848 (class 0 OID 0)
-- Dependencies: 212
-- Name: contact_email_email_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.contact_email_email_id_seq OWNED BY public.contact_email.email_id;


--
-- TOC entry 2715 (class 2604 OID 41512)
-- Name: contact_email email_id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.contact_email ALTER COLUMN email_id SET DEFAULT nextval('public.contact_email_email_id_seq'::regclass);


--
-- TOC entry 2841 (class 0 OID 41509)
-- Dependencies: 213
-- Data for Name: contact_email; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.contact_email (email_id, contact_id, email_address) FROM stdin;
445576	8678	B-andre@hsleiden.nl
757825	3453	K-harsmen@hasleiden.nl
234561	2345	A-bar@hsleiden.nl
123456	1234	R-hary@hsleiden.nl
45664756	2344	r-gereard@hsleiden.nl
\.


--
-- TOC entry 2850 (class 0 OID 0)
-- Dependencies: 212
-- Name: contact_email_email_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.contact_email_email_id_seq', 1, false);


--
-- TOC entry 2717 (class 2606 OID 41517)
-- Name: contact_email contact_email_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.contact_email
    ADD CONSTRAINT contact_email_pkey PRIMARY KEY (email_id);


--
-- TOC entry 2718 (class 2606 OID 41543)
-- Name: contact_email fk_contactemails; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.contact_email
    ADD CONSTRAINT fk_contactemails FOREIGN KEY (contact_id) REFERENCES public.contactId(contact_id);


--
-- TOC entry 2847 (class 0 OID 0)
-- Dependencies: 213
-- Name: TABLE contact_email; Type: ACL; Schema: public; Owner: postgres
--

GRANT ALL ON TABLE public.contact_email TO albert WITH GRANT OPTION;


--
-- TOC entry 2849 (class 0 OID 0)
-- Dependencies: 212
-- Name: SEQUENCE contact_email_email_id_seq; Type: ACL; Schema: public; Owner: postgres
--

GRANT ALL ON SEQUENCE public.contact_email_email_id_seq TO albert WITH GRANT OPTION;


-- Completed on 2018-11-03 09:27:30

--
-- PostgreSQL database dump complete
--

