CREATE TABLE laadimispunktid (
     id BIGSERIAL NOT NULL,
     laadimis_punkti_kood VARCHAR(255) NOT NULL ,
     voimsus_voltides BIGINT NOT NULL,
     asukoht VARCHAR(255) NOT NULL,
     viimati_hooldatud TIMESTAMP,
     paeva_kasutatud BIGINT NOT NULL,
     kasutamiste_arv BIGINT NOT NULL,
     CONSTRAINT pk_key PRIMARY KEY (id)
)