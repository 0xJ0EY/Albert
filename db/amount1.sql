--
-- PostgreSQL database dump
--

-- Dumped from database version 10.1
-- Dumped by pg_dump version 10.4

-- Started on 2018-11-03 22:08:42

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
-- TOC entry 209 (class 1259 OID 41490)
-- Name: amount; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.amount (
    amount_id bigint NOT NULL,
    hours integer,
    price integer,
    contact_id integer
);


ALTER TABLE public.amount OWNER TO postgres;

--
-- TOC entry 208 (class 1259 OID 41488)
-- Name: amount_amount_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.amount_amount_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.amount_amount_id_seq OWNER TO postgres;

--
-- TOC entry 2848 (class 0 OID 0)
-- Dependencies: 208
-- Name: amount_amount_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.amount_amount_id_seq OWNED BY public.amount.amount_id;


--
-- TOC entry 2715 (class 2604 OID 41493)
-- Name: amount amount_id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.amount ALTER COLUMN amount_id SET DEFAULT nextval('public.amount_amount_id_seq'::regclass);


--
-- TOC entry 2841 (class 0 OID 41490)
-- Dependencies: 209
-- Data for Name: amount; Type: TABLE DATA; Schema: public; Owner: postgres
--

INSERT INTO public.amount (amount_id, hours, price, contact_id) VALUES (345, 25, 1500, 1234);
INSERT INTO public.amount (amount_id, hours, price, contact_id) VALUES (261, 19, 1200, 2345);
INSERT INTO public.amount (amount_id, hours, price, contact_id) VALUES (778, 12, 1093, 3453);
INSERT INTO public.amount (amount_id, hours, price, contact_id) VALUES (535, 43, 1245, 8678);
INSERT INTO public.amount (amount_id, hours, price, contact_id) VALUES (565, 54, 1233, 1234);
INSERT INTO public.amount (amount_id, hours, price, contact_id) VALUES (234, 23, 4342, 2344);


--
-- TOC entry 2850 (class 0 OID 0)
-- Dependencies: 208
-- Name: amount_amount_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.amount_amount_id_seq', 1, false);


--
-- TOC entry 2717 (class 2606 OID 41495)
-- Name: amount amount_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.amount
    ADD CONSTRAINT amount_pkey PRIMARY KEY (amount_id);


--
-- TOC entry 2718 (class 2606 OID 41548)
-- Name: amount fk_amountcontact; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.amount
    ADD CONSTRAINT fk_amountcontact FOREIGN KEY (contact_id) REFERENCES public.contactId(contact_id);


--
-- TOC entry 2847 (class 0 OID 0)
-- Dependencies: 209
-- Name: TABLE amount; Type: ACL; Schema: public; Owner: postgres
--

GRANT ALL ON TABLE public.amount TO albert WITH GRANT OPTION;


--
-- TOC entry 2849 (class 0 OID 0)
-- Dependencies: 208
-- Name: SEQUENCE amount_amount_id_seq; Type: ACL; Schema: public; Owner: postgres
--

GRANT ALL ON SEQUENCE public.amount_amount_id_seq TO albert WITH GRANT OPTION;


-- Completed on 2018-11-03 22:08:43

--
-- PostgreSQL database dump complete
--

