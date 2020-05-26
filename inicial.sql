CREATE TABLE administradora
( id number(5) NOT NULL,
  codigo varchar2(20) NOT NULL,
  nombre varchar2(200) NOT NULL,
  cod_tp_id varchar2(2) NOT NULL,
  nro_id varchar2(50) NOT NULL,
  naturaleza varchar2(20) NOT NULL,
  multiple_arp number(1) NOT NULL,
  fsp number(1) NOT NULL,
  fusionada number(1) NOT NULL,
  fecha_fusion date null,
  CONSTRAINT aministradora_pk PRIMARY KEY (id)
);

CREATE SEQUENCE SEQ_ID_ADMINISTRADORA MINVALUE 1 START WITH 1
    INCREMENT BY 1 NOCACHE;
    
grant select on dparejadev.SEQ_ID_ADMINISTRADORA to dparejadev;