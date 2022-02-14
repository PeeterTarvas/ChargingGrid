
CREATE TABLE laadimispunkt (
     laadimispunkti_kood VARCHAR(255) NOT NULL UNIQUE,
     voimsus_voltides SMALLINT NOT NULL,
     asukoht_x_koordinaat NUMERIC NOT NULL,
     asukoht_y_koordinaat NUMERIC NOT NULL,
     viimati_hooldatud TIMESTAMP,
     paeva_kasutatud BIGINT NOT NULL,
     kasutamiste_arv BIGINT NOT NULL,
     olek SMALLINT NOT NULL,
     registreerimise_aeg TIMESTAMP DEFAULT LOCALTIMESTAMP,
     CONSTRAINT pk_key PRIMARY KEY (laadimispunkti_kood),
)

ALTER TABLE laadimispunktid
    ADD CONSTRAINT CHECK (olek BETWEEN 0 AND 2)

laadimispark
seisundil kasutada koodi nt 1, 2, 3
moleda kuidas laadimispunkt laadimispargiga seotud on