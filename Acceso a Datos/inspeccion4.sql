--
-- PostgreSQL database dump
--

-- Dumped from database version 9.3.9
-- Dumped by pg_dump version 9.3.9
-- Started on 2017-02-07 14:06:58

SET statement_timeout = 0;
SET lock_timeout = 0;
SET client_encoding = 'UTF8';
SET standard_conforming_strings = on;
SET check_function_bodies = false;
SET client_min_messages = warning;

DROP DATABASE "Inspeccion";
--
-- TOC entry 1983 (class 1262 OID 42303)
-- Name: Inspeccion; Type: DATABASE; Schema: -; Owner: postgres
--

CREATE DATABASE "Inspeccion" WITH TEMPLATE = template0 ENCODING = 'UTF8' LC_COLLATE = 'Spanish_Spain.1252' LC_CTYPE = 'Spanish_Spain.1252';


ALTER DATABASE "Inspeccion" OWNER TO postgres;

\connect "Inspeccion"

SET statement_timeout = 0;
SET lock_timeout = 0;
SET client_encoding = 'UTF8';
SET standard_conforming_strings = on;
SET check_function_bodies = false;
SET client_min_messages = warning;

--
-- TOC entry 5 (class 2615 OID 2200)
-- Name: public; Type: SCHEMA; Schema: -; Owner: postgres
--

CREATE SCHEMA public;


ALTER SCHEMA public OWNER TO postgres;

--
-- TOC entry 1984 (class 0 OID 0)
-- Dependencies: 5
-- Name: SCHEMA public; Type: COMMENT; Schema: -; Owner: postgres
--

COMMENT ON SCHEMA public IS 'standard public schema';


--
-- TOC entry 178 (class 3079 OID 11750)
-- Name: plpgsql; Type: EXTENSION; Schema: -; Owner: 
--

CREATE EXTENSION IF NOT EXISTS plpgsql WITH SCHEMA pg_catalog;


--
-- TOC entry 1986 (class 0 OID 0)
-- Dependencies: 178
-- Name: EXTENSION plpgsql; Type: COMMENT; Schema: -; Owner: 
--

COMMENT ON EXTENSION plpgsql IS 'PL/pgSQL procedural language';


SET search_path = public, pg_catalog;

SET default_tablespace = '';

SET default_with_oids = false;

--
-- TOC entry 176 (class 1259 OID 42404)
-- Name: ASOCIA; Type: TABLE; Schema: public; Owner: postgres; Tablespace: 
--

CREATE TABLE "ASOCIA" (
    id_inspector integer NOT NULL,
    id_centro integer NOT NULL,
    anho numeric(4,0) NOT NULL
);


ALTER TABLE public."ASOCIA" OWNER TO postgres;

--
-- TOC entry 173 (class 1259 OID 42343)
-- Name: secuencia_id_centro; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE secuencia_id_centro
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.secuencia_id_centro OWNER TO postgres;

--
-- TOC entry 172 (class 1259 OID 42337)
-- Name: CENTRO; Type: TABLE; Schema: public; Owner: postgres; Tablespace: 
--

CREATE TABLE "CENTRO" (
    id integer DEFAULT nextval('secuencia_id_centro'::regclass) NOT NULL,
    nombre character(40) NOT NULL,
    oferta text,
    notas text,
    localidad character(40) NOT NULL
);


ALTER TABLE public."CENTRO" OWNER TO postgres;

--
-- TOC entry 177 (class 1259 OID 42449)
-- Name: secuencia_id_miembro; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE secuencia_id_miembro
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.secuencia_id_miembro OWNER TO postgres;

--
-- TOC entry 174 (class 1259 OID 42374)
-- Name: MIEMBRO; Type: TABLE; Schema: public; Owner: postgres; Tablespace: 
--

CREATE TABLE "MIEMBRO" (
    id integer DEFAULT nextval('secuencia_id_miembro'::regclass) NOT NULL,
    nombre character(40) NOT NULL,
    cargo character(40) NOT NULL,
    telefono numeric(9,0),
    correo character(40),
    notas text,
    anho numeric(4,0) NOT NULL,
    id_centro integer NOT NULL
);


ALTER TABLE public."MIEMBRO" OWNER TO postgres;

--
-- TOC entry 170 (class 1259 OID 42326)
-- Name: secuencia_id_usuario; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE secuencia_id_usuario
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.secuencia_id_usuario OWNER TO postgres;

--
-- TOC entry 171 (class 1259 OID 42331)
-- Name: USUARIO; Type: TABLE; Schema: public; Owner: postgres; Tablespace: 
--

CREATE TABLE "USUARIO" (
    id integer DEFAULT nextval('secuencia_id_usuario'::regclass) NOT NULL,
    nombre character(40) NOT NULL,
    correo character(40),
    telefono integer,
    tipo character(1) NOT NULL,
    password character(40)
);


ALTER TABLE public."USUARIO" OWNER TO postgres;

--
-- TOC entry 175 (class 1259 OID 42393)
-- Name: VISITA; Type: TABLE; Schema: public; Owner: postgres; Tablespace: 
--

CREATE TABLE "VISITA" (
    id_inspector integer NOT NULL,
    id_centro integer NOT NULL,
    fecha date NOT NULL,
    motivo text,
    resolucion text
);


ALTER TABLE public."VISITA" OWNER TO postgres;

--
-- TOC entry 1977 (class 0 OID 42404)
-- Dependencies: 176
-- Data for Name: ASOCIA; Type: TABLE DATA; Schema: public; Owner: postgres
--

INSERT INTO "ASOCIA" (id_inspector, id_centro, anho) VALUES (6, 1, 2015);
INSERT INTO "ASOCIA" (id_inspector, id_centro, anho) VALUES (6, 1, 2016);
INSERT INTO "ASOCIA" (id_inspector, id_centro, anho) VALUES (6, 2, 2015);
INSERT INTO "ASOCIA" (id_inspector, id_centro, anho) VALUES (6, 3, 2015);
INSERT INTO "ASOCIA" (id_inspector, id_centro, anho) VALUES (7, 2, 2016);
INSERT INTO "ASOCIA" (id_inspector, id_centro, anho) VALUES (7, 4, 2015);
INSERT INTO "ASOCIA" (id_inspector, id_centro, anho) VALUES (7, 5, 2015);
INSERT INTO "ASOCIA" (id_inspector, id_centro, anho) VALUES (8, 1, 2015);
INSERT INTO "ASOCIA" (id_inspector, id_centro, anho) VALUES (8, 3, 2015);
INSERT INTO "ASOCIA" (id_inspector, id_centro, anho) VALUES (8, 3, 2016);
INSERT INTO "ASOCIA" (id_inspector, id_centro, anho) VALUES (9, 4, 2016);
INSERT INTO "ASOCIA" (id_inspector, id_centro, anho) VALUES (9, 5, 2013);
INSERT INTO "ASOCIA" (id_inspector, id_centro, anho) VALUES (10, 3, 2014);
INSERT INTO "ASOCIA" (id_inspector, id_centro, anho) VALUES (10, 5, 2014);
INSERT INTO "ASOCIA" (id_inspector, id_centro, anho) VALUES (10, 5, 2016);


--
-- TOC entry 1973 (class 0 OID 42337)
-- Dependencies: 172
-- Data for Name: CENTRO; Type: TABLE DATA; Schema: public; Owner: postgres
--

INSERT INTO "CENTRO" (id, nombre, oferta, notas, localidad) VALUES (1, 'CEIP San Bernardo                       ', 'EducacionInfantil publico diurno. Primaria publico diurno', NULL, 'Algeciras                               ');
INSERT INTO "CENTRO" (id, nombre, oferta, notas, localidad) VALUES (2, 'Los Pinos                               ', 'Primaria concertado diurno.Secundaria concertado diurno. Bachillerato privado diurno. CFSuperior privado diurno', NULL, 'Los Barrios                             ');
INSERT INTO "CENTRO" (id, nombre, oferta, notas, localidad) VALUES (3, 'El patio de mi casa                     ', 'EducacionInfantil privado diurno', NULL, 'Los Barrios                             ');
INSERT INTO "CENTRO" (id, nombre, oferta, notas, localidad) VALUES (4, 'IES Kursaal                             ', 'Secundaria publico diurno. Secundaria publico nocturno. Bachillerato publico diurno. Bachillerato publico nocturno. FPBasica publico diurno. FPMedio publico diurno. FPSuperior publico nocturno.', NULL, 'Algeciras                               ');
INSERT INTO "CENTRO" (id, nombre, oferta, notas, localidad) VALUES (5, 'IES Saladillo                           ', 'Secundaria publico diurno. Bachillerato publico diurno. FPBasica publico diurno. FPMedio publico diurno. FPSuperior publico diurno.', NULL, 'Algeciras                               ');


--
-- TOC entry 1975 (class 0 OID 42374)
-- Dependencies: 174
-- Data for Name: MIEMBRO; Type: TABLE DATA; Schema: public; Owner: postgres
--

INSERT INTO "MIEMBRO" (id, nombre, cargo, telefono, correo, notas, anho, id_centro) VALUES (1, 'MariaJosé                               ', 'Director/a                              ', 111111111, 'mj@gmail.com                            ', NULL, 2015, 1);
INSERT INTO "MIEMBRO" (id, nombre, cargo, telefono, correo, notas, anho, id_centro) VALUES (2, 'Jose                                    ', 'Vicedirector/a                          ', 222222222, 'jose@gmail.com                          ', NULL, 2015, 1);
INSERT INTO "MIEMBRO" (id, nombre, cargo, telefono, correo, notas, anho, id_centro) VALUES (4, 'Alejandro                               ', 'Director/a                              ', 444444444, 'alex@gmail.com                          ', NULL, 2016, 1);
INSERT INTO "MIEMBRO" (id, nombre, cargo, telefono, correo, notas, anho, id_centro) VALUES (5, 'Javier                                  ', 'Director/a                              ', 555555555, 'javier@gmail.com                        ', NULL, 2016, 2);
INSERT INTO "MIEMBRO" (id, nombre, cargo, telefono, correo, notas, anho, id_centro) VALUES (6, 'Isabel                                  ', 'Vicedirector/a                          ', 666666666, 'isabel@gmail.com                        ', NULL, 2016, 2);
INSERT INTO "MIEMBRO" (id, nombre, cargo, telefono, correo, notas, anho, id_centro) VALUES (7, 'Hayone                                  ', 'Jefe/a de Estudios                      ', 777777777, 'hayone@gmail.com                        ', NULL, 2016, 2);
INSERT INTO "MIEMBRO" (id, nombre, cargo, telefono, correo, notas, anho, id_centro) VALUES (9, 'Margarita                               ', 'Director/a                              ', 999999999, 'margarita@gmail.com                     ', NULL, 2016, 3);
INSERT INTO "MIEMBRO" (id, nombre, cargo, telefono, correo, notas, anho, id_centro) VALUES (10, 'Rocío                                   ', 'Director/a                              ', 121212121, 'rocio@gmail.com                         ', NULL, 2014, 4);
INSERT INTO "MIEMBRO" (id, nombre, cargo, telefono, correo, notas, anho, id_centro) VALUES (11, 'Edurne                                  ', 'Director/a                              ', 123123123, 'edurne@gmail.com                        ', NULL, 2016, 4);
INSERT INTO "MIEMBRO" (id, nombre, cargo, telefono, correo, notas, anho, id_centro) VALUES (12, 'Anacleto                                ', 'Vicedirector/a                          ', 456456456, 'anacleto@gmail.com                      ', NULL, 2016, 4);
INSERT INTO "MIEMBRO" (id, nombre, cargo, telefono, correo, notas, anho, id_centro) VALUES (13, 'Paco                                    ', 'Jefe/a de Estudios                      ', 789789789, 'paco@gmail.com                          ', NULL, 2016, 4);
INSERT INTO "MIEMBRO" (id, nombre, cargo, telefono, correo, notas, anho, id_centro) VALUES (14, 'Inmaculada                              ', 'Director/a                              ', 412412412, 'inma@gmail.com                          ', NULL, 2016, 5);
INSERT INTO "MIEMBRO" (id, nombre, cargo, telefono, correo, notas, anho, id_centro) VALUES (15, 'Antonia                                 ', 'Jefe/a de Estudios                      ', 512512512, 'toñi@gmail.com                          ', NULL, 2016, 5);
INSERT INTO "MIEMBRO" (id, nombre, cargo, telefono, correo, notas, anho, id_centro) VALUES (16, 'Manolo                                  ', 'Jefe/a de Estudios                      ', 541541544, 'manolo@gmail.com                        ', NULL, 2014, 5);
INSERT INTO "MIEMBRO" (id, nombre, cargo, telefono, correo, notas, anho, id_centro) VALUES (17, 'Pilar                                   ', 'Vicedirector/a                          ', 654654654, 'pilar@gmail.com                         ', NULL, 2016, 5);
INSERT INTO "MIEMBRO" (id, nombre, cargo, telefono, correo, notas, anho, id_centro) VALUES (18, 'Ana                                     ', 'FEIE                                    ', 778977897, 'ana@gmail.com                           ', NULL, 2016, 5);
INSERT INTO "MIEMBRO" (id, nombre, cargo, telefono, correo, notas, anho, id_centro) VALUES (19, 'Jose Manuel                             ', 'Extraescolares                          ', 998799874, 'josem@gmail.com                         ', NULL, 2016, 5);
INSERT INTO "MIEMBRO" (id, nombre, cargo, telefono, correo, notas, anho, id_centro) VALUES (20, 'Pedro                                   ', 'TIC                                     ', 898878864, 'pedro@gmail.com                         ', NULL, 2016, 5);
INSERT INTO "MIEMBRO" (id, nombre, cargo, telefono, correo, notas, anho, id_centro) VALUES (3, 'Laura                                   ', 'Jefe/a de Estudios                      ', 333333333, 'laura@gmail.com                         ', NULL, 2016, 1);
INSERT INTO "MIEMBRO" (id, nombre, cargo, telefono, correo, notas, anho, id_centro) VALUES (8, 'Raul                                    ', 'Vicedirector/a                          ', 888888888, 'raul@gmail.com                          ', NULL, 2016, 3);


--
-- TOC entry 1972 (class 0 OID 42331)
-- Dependencies: 171
-- Data for Name: USUARIO; Type: TABLE DATA; Schema: public; Owner: postgres
--

INSERT INTO "USUARIO" (id, nombre, correo, telefono, tipo, password) VALUES (2, 'Rocio Salas                             ', 'roc@gmail.com                           ', 222222222, 'C', '123                                     ');
INSERT INTO "USUARIO" (id, nombre, correo, telefono, tipo, password) VALUES (1, 'Ramiro Souto                            ', 'ram@gmail.com                           ', 111111111, 'C', '123                                     ');
INSERT INTO "USUARIO" (id, nombre, correo, telefono, tipo, password) VALUES (3, 'Esther Seijas                           ', 'est@gmail.com                           ', 333333333, 'C', '123                                     ');
INSERT INTO "USUARIO" (id, nombre, correo, telefono, tipo, password) VALUES (4, 'Dina Casas                              ', 'dina@gmail.com                          ', 444444444, 'C', '123                                     ');
INSERT INTO "USUARIO" (id, nombre, correo, telefono, tipo, password) VALUES (5, 'Luis Peña                               ', 'luis@gmail.com                          ', 555555555, 'C', '123                                     ');
INSERT INTO "USUARIO" (id, nombre, correo, telefono, tipo, password) VALUES (6, 'Sofía Castro                            ', 'sofi@gmail.com                          ', 666666666, 'I', '123                                     ');
INSERT INTO "USUARIO" (id, nombre, correo, telefono, tipo, password) VALUES (7, 'Ada Castro                              ', 'ada@gmail.com                           ', 777777777, 'I', '123                                     ');
INSERT INTO "USUARIO" (id, nombre, correo, telefono, tipo, password) VALUES (8, 'Santiago Salgado                        ', 'santi@gmail.com                         ', 888888888, 'I', '123                                     ');
INSERT INTO "USUARIO" (id, nombre, correo, telefono, tipo, password) VALUES (9, 'Mercedes Platas                         ', 'merchy@gmail.com                        ', 999999999, 'I', '123                                     ');
INSERT INTO "USUARIO" (id, nombre, correo, telefono, tipo, password) VALUES (10, 'Manolo Ventoso                          ', 'manolo@gmail.com                        ', 121212121, 'I', '123                                     ');


--
-- TOC entry 1976 (class 0 OID 42393)
-- Dependencies: 175
-- Data for Name: VISITA; Type: TABLE DATA; Schema: public; Owner: postgres
--

INSERT INTO "VISITA" (id_inspector, id_centro, fecha, motivo, resolucion) VALUES (6, 1, '2015-09-01', 'rutina', 'ok');
INSERT INTO "VISITA" (id_inspector, id_centro, fecha, motivo, resolucion) VALUES (6, 1, '2015-12-01', 'programaciones', 'ok');
INSERT INTO "VISITA" (id_inspector, id_centro, fecha, motivo, resolucion) VALUES (6, 1, '2016-09-01', 'rutina', 'ok');
INSERT INTO "VISITA" (id_inspector, id_centro, fecha, motivo, resolucion) VALUES (6, 1, '2017-02-15', 'horario', 'ok');
INSERT INTO "VISITA" (id_inspector, id_centro, fecha, motivo, resolucion) VALUES (6, 1, '2017-03-01', 'finanzas', 'errores -> nueva visita');
INSERT INTO "VISITA" (id_inspector, id_centro, fecha, motivo, resolucion) VALUES (6, 1, '2017-03-11', 'finanzas', 'ok');
INSERT INTO "VISITA" (id_inspector, id_centro, fecha, motivo, resolucion) VALUES (7, 2, '2017-02-20', 'finanzas', 'ok');
INSERT INTO "VISITA" (id_inspector, id_centro, fecha, motivo, resolucion) VALUES (7, 2, '2017-02-25', 'rutina', 'errores horarios');
INSERT INTO "VISITA" (id_inspector, id_centro, fecha, motivo, resolucion) VALUES (8, 3, '2016-09-15', 'horario', 'ok');
INSERT INTO "VISITA" (id_inspector, id_centro, fecha, motivo, resolucion) VALUES (8, 3, '2017-02-25', 'rutina', 'ok');


--
-- TOC entry 1987 (class 0 OID 0)
-- Dependencies: 173
-- Name: secuencia_id_centro; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('secuencia_id_centro', 5, true);


--
-- TOC entry 1988 (class 0 OID 0)
-- Dependencies: 177
-- Name: secuencia_id_miembro; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('secuencia_id_miembro', 20, true);


--
-- TOC entry 1989 (class 0 OID 0)
-- Dependencies: 170
-- Name: secuencia_id_usuario; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('secuencia_id_usuario', 10, true);


--
-- TOC entry 1858 (class 2606 OID 42408)
-- Name: pk_asocia; Type: CONSTRAINT; Schema: public; Owner: postgres; Tablespace: 
--

ALTER TABLE ONLY "ASOCIA"
    ADD CONSTRAINT pk_asocia PRIMARY KEY (id_inspector, id_centro, anho);


--
-- TOC entry 1854 (class 2606 OID 42392)
-- Name: pk_equipo; Type: CONSTRAINT; Schema: public; Owner: postgres; Tablespace: 
--

ALTER TABLE ONLY "MIEMBRO"
    ADD CONSTRAINT pk_equipo PRIMARY KEY (id, id_centro, anho);


--
-- TOC entry 1852 (class 2606 OID 42403)
-- Name: pk_id; Type: CONSTRAINT; Schema: public; Owner: postgres; Tablespace: 
--

ALTER TABLE ONLY "CENTRO"
    ADD CONSTRAINT pk_id PRIMARY KEY (id);


--
-- TOC entry 1850 (class 2606 OID 42350)
-- Name: pk_id_usuario; Type: CONSTRAINT; Schema: public; Owner: postgres; Tablespace: 
--

ALTER TABLE ONLY "USUARIO"
    ADD CONSTRAINT pk_id_usuario PRIMARY KEY (id);


--
-- TOC entry 1856 (class 2606 OID 42400)
-- Name: pk_visita; Type: CONSTRAINT; Schema: public; Owner: postgres; Tablespace: 
--

ALTER TABLE ONLY "VISITA"
    ADD CONSTRAINT pk_visita PRIMARY KEY (id_inspector, id_centro, fecha);


--
-- TOC entry 1863 (class 2606 OID 42414)
-- Name: fk_centro; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY "ASOCIA"
    ADD CONSTRAINT fk_centro FOREIGN KEY (id_centro) REFERENCES "CENTRO"(id);


--
-- TOC entry 1861 (class 2606 OID 42424)
-- Name: fk_centro; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY "VISITA"
    ADD CONSTRAINT fk_centro FOREIGN KEY (id_centro) REFERENCES "CENTRO"(id);


--
-- TOC entry 1859 (class 2606 OID 42429)
-- Name: fk_centro; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY "MIEMBRO"
    ADD CONSTRAINT fk_centro FOREIGN KEY (id_centro) REFERENCES "CENTRO"(id);


--
-- TOC entry 1862 (class 2606 OID 42409)
-- Name: fk_inspector; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY "ASOCIA"
    ADD CONSTRAINT fk_inspector FOREIGN KEY (id_inspector) REFERENCES "USUARIO"(id);


--
-- TOC entry 1860 (class 2606 OID 42419)
-- Name: fk_inspector; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY "VISITA"
    ADD CONSTRAINT fk_inspector FOREIGN KEY (id_inspector) REFERENCES "USUARIO"(id);


--
-- TOC entry 1985 (class 0 OID 0)
-- Dependencies: 5
-- Name: public; Type: ACL; Schema: -; Owner: postgres
--

REVOKE ALL ON SCHEMA public FROM PUBLIC;
REVOKE ALL ON SCHEMA public FROM postgres;
GRANT ALL ON SCHEMA public TO postgres;
GRANT ALL ON SCHEMA public TO PUBLIC;


-- Completed on 2017-02-07 14:06:59

--
-- PostgreSQL database dump complete
--

