CREATE TABLE laadimispunktid (
     id BIGSERIAL NOT NULL,
     laadimispunkti_kood VARCHAR(255) NOT NULL UNIQUE,
     voimsus_voltides BIGINT NOT NULL,
     asukoht_x_koordinaat NUMERIC NOT NULL,
     asukoht_y_koordinaat NUMERIC NOT NULL,
     viimati_hooldatud TIMESTAMP,
     paeva_kasutatud BIGINT NOT NULL,
     kasutamiste_arv BIGINT NOT NULL,
     olek VARCHAR(10) NOT NULL,
     registreerimise_aeg TIMESTAMP DEFAULT LOCALTIMESTAMP,
     CONSTRAINT pk_key PRIMARY KEY (id),

)