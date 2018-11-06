--
-- PostgreSQL database dump
--

-- Dumped from database version 10.1
-- Dumped by pg_dump version 10.4

-- Started on 2018-11-03 09:31:56

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
-- TOC entry 205 (class 1259 OID 41471)
-- Name: report; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.report (
    report_id bigint NOT NULL,
    end_date timestamp without time zone,
    start_date timestamp without time zone
);


ALTER TABLE public.report OWNER TO postgres;

--
-- TOC entry 204 (class 1259 OID 41469)
-- Name: report_report_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.report_report_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.report_report_id_seq OWNER TO postgres;

--
-- TOC entry 2847 (class 0 OID 0)
-- Dependencies: 204
-- Name: report_report_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.report_report_id_seq OWNED BY public.report.report_id;


--
-- TOC entry 2715 (class 2604 OID 41474)
-- Name: report report_id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.report ALTER COLUMN report_id SET DEFAULT nextval('public.report_report_id_seq'::regclass);


--
-- TOC entry 2840 (class 0 OID 41471)
-- Dependencies: 205
-- Data for Name: report; Type: TABLE DATA; Schema: public; Owner: postgres
--

INSERT INTO public.report (report_id, end_date, start_date) VALUES (95, '2017-09-09 11:21:08.233', '2017-06-03 11:21:26.483');
INSERT INTO public.report (report_id, end_date, start_date) VALUES (56, '2018-11-02 12:03:21.118', '2017-11-02 12:03:24.43');
INSERT INTO public.report (report_id, end_date, start_date) VALUES (64, '2016-05-02 12:13:27.629', '2015-11-02 12:13:37.939');
INSERT INTO public.report (report_id, end_date, start_date) VALUES (45, '2014-11-02 14:04:44.323', '2013-11-02 14:04:54.1');
INSERT INTO public.report (report_id, end_date, start_date) VALUES (423, '2018-11-04 14:08:50.882', '2017-11-02 14:08:55.765');


--
-- TOC entry 2849 (class 0 OID 0)
-- Dependencies: 204
-- Name: report_report_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.report_report_id_seq', 1, false);


--
-- TOC entry 2717 (class 2606 OID 41476)
-- Name: report report_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.report
    ADD CONSTRAINT report_pkey PRIMARY KEY (report_id);


--
-- TOC entry 2846 (class 0 OID 0)
-- Dependencies: 205
-- Name: TABLE report; Type: ACL; Schema: public; Owner: postgres
--

GRANT ALL ON TABLE public.report TO albert WITH GRANT OPTION;


--
-- TOC entry 2848 (class 0 OID 0)
-- Dependencies: 204
-- Name: SEQUENCE report_report_id_seq; Type: ACL; Schema: public; Owner: postgres
--

GRANT ALL ON SEQUENCE public.report_report_id_seq TO albert WITH GRANT OPTION;


-- Completed on 2018-11-03 09:31:57

--
-- PostgreSQL database dump complete
--

