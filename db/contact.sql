--
-- PostgreSQL database dump
--

-- Dumped from database version 10.1
-- Dumped by pg_dump version 10.4

-- Started on 2018-11-03 09:26:37

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
-- TOC entry 211 (class 1259 OID 41498)
-- Name: contactId; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.contactId (
    contact_id bigint NOT NULL,
    first_name character varying,
    last_name character varying,
    tel_number integer,
    postal_code character varying,
    street_name character varying,
    house_number character varying,
    city character varying,
    created_at timestamp without time zone,
    website character varying,
    description character varying,
    project_id integer
);


ALTER TABLE public.contactId OWNER TO postgres;

--
-- TOC entry 210 (class 1259 OID 41496)
-- Name: contact_contact_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.contact_contact_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.contact_contact_id_seq OWNER TO postgres;

--
-- TOC entry 2848 (class 0 OID 0)
-- Dependencies: 210
-- Name: contact_contact_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.contact_contact_id_seq OWNED BY public.contactId.contact_id;


--
-- TOC entry 2715 (class 2604 OID 41501)
-- Name: contactId contact_id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.contactId ALTER COLUMN contact_id SET DEFAULT nextval('public.contact_contact_id_seq'::regclass);


--
-- TOC entry 2841 (class 0 OID 41498)
-- Dependencies: 211
-- Data for Name: contactId; Type: TABLE DATA; Schema: public; Owner: postgres
--

INSERT INTO public.contactId (contact_id, first_name, last_name, tel_number, postal_code, street_name, house_number, city, created_at, website, description, project_id) VALUES (1234, 'Richard', 'Hary', 643456734, '2134 GB', 'Tolheksbos', '84', 'Hoofddorp', '2014-09-01 11:17:26.091', 'www.R-hary.nl', 'Dat is een vaste klant', 1);
INSERT INTO public.contactId (contact_id, first_name, last_name, tel_number, postal_code, street_name, house_number, city, created_at, website, description, project_id) VALUES (2345, 'Alex', 'Barbara', 693293944, '2344 DD', 'Aardenburg', '345', 'Amsterdam', '2017-01-04 11:47:45.086', 'www.A-barbara.com', 'nieuewe klant', 2);
INSERT INTO public.contactId (contact_id, first_name, last_name, tel_number, postal_code, street_name, house_number, city, created_at, website, description, project_id) VALUES (3453, 'Karmer', 'Harmsen', 683716273, '3443 SA', 'Markt ', '4', 'Leiden', '2015-07-02 12:05:13.357', 'www.K-harmen.com', 'nieuwe klant', 3);
INSERT INTO public.contactId (contact_id, first_name, last_name, tel_number, postal_code, street_name, house_number, city, created_at, website, description, project_id) VALUES (8678, 'bennink', 'Andre', 643577677, '5436 TY', 'Rozenlaan', '7', 'Rotterdam ', '2016-11-04 12:55:34.186', 'www.B.Andre.com', 'Een vaste klant', 4);
INSERT INTO public.contactId (contact_id, first_name, last_name, tel_number, postal_code, street_name, house_number, city, created_at, website, description, project_id) VALUES (2344, 'Ruud
', 'Gerard', 543342145, '2425 Al', 'Iplaan', '34', 'Haalrm', '2012-11-09 12:52:50.776', 'www.R-Gererad.nl', 'vaste klant', 6);


--
-- TOC entry 2850 (class 0 OID 0)
-- Dependencies: 210
-- Name: contact_contact_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.contact_contact_id_seq', 1, false);


--
-- TOC entry 2717 (class 2606 OID 41506)
-- Name: contactId contact_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.contactId
    ADD CONSTRAINT contact_pkey PRIMARY KEY (contact_id);


--
-- TOC entry 2718 (class 2606 OID 41533)
-- Name: contactId fk_contactproject; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.contactId
    ADD CONSTRAINT fk_contactproject FOREIGN KEY (project_id) REFERENCES public.project(project_id);


--
-- TOC entry 2847 (class 0 OID 0)
-- Dependencies: 211
-- Name: TABLE contactId; Type: ACL; Schema: public; Owner: postgres
--

GRANT ALL ON TABLE public.contactId TO albert WITH GRANT OPTION;


--
-- TOC entry 2849 (class 0 OID 0)
-- Dependencies: 210
-- Name: SEQUENCE contact_contact_id_seq; Type: ACL; Schema: public; Owner: postgres
--

GRANT ALL ON SEQUENCE public.contact_contact_id_seq TO albert WITH GRANT OPTION;


-- Completed on 2018-11-03 09:26:38

--
-- PostgreSQL database dump complete
--

