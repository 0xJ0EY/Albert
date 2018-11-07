--
-- PostgreSQL database dump
--

-- Dumped from database version 10.1
-- Dumped by pg_dump version 10.4

-- Started on 2018-11-03 09:28:10

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
-- TOC entry 207 (class 1259 OID 41479)
-- Name: expenseId; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.expenseId (
    expense_id bigint NOT NULL,
    price numeric(2,0),
    created_at timestamp without time zone,
    description character varying,
    name character varying
);


ALTER TABLE public.expenseId OWNER TO postgres;

--
-- TOC entry 206 (class 1259 OID 41477)
-- Name: expense_expense_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.expense_expense_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.expense_expense_id_seq OWNER TO postgres;

--
-- TOC entry 2847 (class 0 OID 0)
-- Dependencies: 206
-- Name: expense_expense_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.expense_expense_id_seq OWNED BY public.expenseId.expense_id;


--
-- TOC entry 2715 (class 2604 OID 41482)
-- Name: expenseId expense_id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.expenseId ALTER COLUMN expense_id SET DEFAULT nextval('public.expense_expense_id_seq'::regclass);


--
-- TOC entry 2840 (class 0 OID 41479)
-- Dependencies: 207
-- Data for Name: expenseId; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.expenseId (expense_id, price, created_at, description, name) FROM stdin;
1234	15	2015-01-01 11:02:11.984	Onkosten voor Natuur project	Natuur onkosten
8787	14	2017-05-01 11:58:42.908	onkosten voor posten project	Posten onkosten
5621	33	2017-09-08 12:08:41.285	Onkosten voor Sky project	Sky onkosten
2324	56	2016-11-02 13:01:24.108	Onkosten voor Bank project	Bank onkosten
5462	43	2013-10-05 13:59:23.234	Onkosten voor Bedrijf	Bedrijf onkosten
\.


--
-- TOC entry 2849 (class 0 OID 0)
-- Dependencies: 206
-- Name: expense_expense_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.expense_expense_id_seq', 1, false);


--
-- TOC entry 2717 (class 2606 OID 41487)
-- Name: expenseId expense_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.expenseId
    ADD CONSTRAINT expense_pkey PRIMARY KEY (expense_id);


--
-- TOC entry 2846 (class 0 OID 0)
-- Dependencies: 207
-- Name: TABLE expenseId; Type: ACL; Schema: public; Owner: postgres
--

GRANT ALL ON TABLE public.expenseId TO albert WITH GRANT OPTION;


--
-- TOC entry 2848 (class 0 OID 0)
-- Dependencies: 206
-- Name: SEQUENCE expense_expense_id_seq; Type: ACL; Schema: public; Owner: postgres
--

GRANT ALL ON SEQUENCE public.expense_expense_id_seq TO albert WITH GRANT OPTION;


-- Completed on 2018-11-03 09:28:11

--
-- PostgreSQL database dump complete
--

