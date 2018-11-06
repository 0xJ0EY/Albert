--
-- PostgreSQL database dump
--

-- Dumped from database version 10.1
-- Dumped by pg_dump version 10.4

-- Started on 2018-11-03 09:29:05

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
-- TOC entry 197 (class 1259 OID 41429)
-- Name: project; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.project (
    project_id bigint NOT NULL,
    name character varying,
    invoice_id integer,
    contact_id integer,
    expense_id integer,
    quotation_id integer,
    created_at timestamp without time zone,
    done boolean DEFAULT false
);


ALTER TABLE public.project OWNER TO postgres;

--
-- TOC entry 196 (class 1259 OID 41427)
-- Name: project_project_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.project_project_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.project_project_id_seq OWNER TO postgres;

--
-- TOC entry 2848 (class 0 OID 0)
-- Dependencies: 196
-- Name: project_project_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.project_project_id_seq OWNED BY public.project.project_id;


--
-- TOC entry 2715 (class 2604 OID 41432)
-- Name: project project_id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.project ALTER COLUMN project_id SET DEFAULT nextval('public.project_project_id_seq'::regclass);


--
-- TOC entry 2841 (class 0 OID 41429)
-- Dependencies: 197
-- Data for Name: project; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.project (project_id, name, invoice_id, contact_id, expense_id, quotation_id, created_at, done) FROM stdin;
3	Sky	545	3453	5621	53565	2017-11-02 12:07:42.4	f
4	Drive	453	1234	5435	45343	2014-11-02 12:21:28.493	f
2	Posten	234	2345	8787	23456	2016-05-03 11:51:05.265	t
1	Natuur 	123	1234	1234	12345	2018-11-02 10:56:27.07	t
5	Bank	365	8678	2324	95865	2013-11-05 12:41:23.149	f
6	Bedrijf	768	2344	5462	23564	2011-07-02 13:49:09.56	f
7	Auto	536	6743	3655	93786	2015-07-07 14:17:35.348	f
\.


--
-- TOC entry 2850 (class 0 OID 0)
-- Dependencies: 196
-- Name: project_project_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.project_project_id_seq', 1, false);


--
-- TOC entry 2718 (class 2606 OID 41438)
-- Name: project project_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.project
    ADD CONSTRAINT project_pkey PRIMARY KEY (project_id);


--
-- TOC entry 2847 (class 0 OID 0)
-- Dependencies: 197
-- Name: TABLE project; Type: ACL; Schema: public; Owner: postgres
--

GRANT ALL ON TABLE public.project TO albert WITH GRANT OPTION;


--
-- TOC entry 2849 (class 0 OID 0)
-- Dependencies: 196
-- Name: SEQUENCE project_project_id_seq; Type: ACL; Schema: public; Owner: postgres
--

GRANT ALL ON SEQUENCE public.project_project_id_seq TO albert WITH GRANT OPTION;


-- Completed on 2018-11-03 09:29:05

--
-- PostgreSQL database dump complete
--

