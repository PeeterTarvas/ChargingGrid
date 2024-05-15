/* ---------------------------------------------------- */
/*  Generated by Enterprise Architect Version 12.0 		*/
/*  Created On : 09-apr-2022 12:32:54 				*/
/*  DBMS       : PostgreSQL 						*/
/* ---------------------------------------------------- */




/* Drop Tables */

DROP TABLE IF EXISTS Riik  CASCADE
;

DROP TABLE IF EXISTS Tootaja_roll  CASCADE
;

DROP TABLE IF EXISTS Tootaja_seisundi_liik CASCADE
;

DROP TABLE IF EXISTS Laadimispunkti_seisundi_liik CASCADE
;

DROP TABLE IF EXISTS Laadimispunkti_kategooria_tyyp CASCADE
;

DROP TABLE IF EXISTS Kliendi_seisundi_liik CASCADE
;

DROP TABLE IF EXISTS Isiku_seisundi_liik CASCADE
;

DROP TABLE IF EXISTS Laadimispunkti_tyyp CASCADE
;

DROP TABLE IF EXISTS Laadimispunkti_kategooria CASCADE
;

DROP TABLE IF EXISTS Isik CASCADE
;

DROP TABLE IF EXISTS Kasutajakonto CASCADE
;

DROP TABLE IF EXISTS Tootaja CASCADE
;

DROP TABLE IF EXISTS Laadimispunkt CASCADE
;

DROP TABLE IF EXISTS Klient CASCADE
;

DROP TABLE IF EXISTS Laadimispunkti_kategooria_omamine CASCADE
;

DROP TABLE IF EXISTS Tootaja_rolli_omamine CASCADE
;

DROP DOMAIN IF EXISTS aeg CASCADE;

DROP DOMAIN IF EXISTS nimetus CASCADE;

DROP DOMAIN IF EXISTS aeg_default_infinity CASCADE;

DROP DOMAIN IF EXISTS isikukood CASCADE ;


CREATE DOMAIN aeg AS TIMESTAMP(0)WITHOUT TIME ZONE NOT NULL DEFAULT LOCALTIMESTAMP(0) CONSTRAINT CHK_aeg_on_maaratud_ajavahemikus CHECK ( VALUE BETWEEN To_Timestamp('01-01-2010 00:00:00', 'DD-MM-YYYY HH24:MI:SS')
    AND To_Timestamp('31.12.2100 23:59:59', 'DD-MM-YYYY HH24:MI:SS'));

CREATE DOMAIN aeg_default_infinity AS TIMESTAMP(0) NOT NULL DEFAULT 'infinity'::timestamp without time zone CONSTRAINT CHK_aeg_on_maaratud_ajavahemikus_default_infinity CHECK ( VALUE BETWEEN To_Timestamp('01-01-2010 00:00:00', 'DD-MM-YYYY HH24:MI:SS')
    AND To_Timestamp('31.12.2100 23:59:59', 'DD-MM-YYYY HH24:MI:SS'));

CREATE DOMAIN nimetus AS varchar(50) NOT NULL CONSTRAINT CHK_nimetus_ei_ole_tyhi CHECK ( VALUE !~ '^[[:space:]]*$');

CREATE DOMAIN isikukood AS varchar(255) NOT NULL CONSTRAINT CHK_isikukood_on_oige CHECK ( VALUE !~ '^[[:space:]]*$' AND VALUE ~ '^[[:alnum:] /+=-]+$');


/* Create Tables */

CREATE TABLE  Riik 
(
	 riik_kood  varchar(3) NOT NULL,
	 riik_nimetus  varchar(60) NOT NULL,
	CONSTRAINT  PK_Riik  PRIMARY KEY ( riik_kood ),
	CONSTRAINT CHK_Riik_kood_on_oige CHECK ( riik_kood ~ '[A-Z]{3}'),
     CONSTRAINT CHK_Riik_riik_nimetus_ei_ole_tyhi CHECK ( riik_nimetus !~ '^[[:space:]]*$'),
     CONSTRAINT AK_riik_nimetus UNIQUE(riik_nimetus)
)
;

CREATE TABLE  Tootaja_roll 
(
    tootaja_roll_kood  smallint NOT NULL,
    kirjeldus  TEXT,
	 tootaja_roll_nimetus  nimetus,
	 CONSTRAINT  PK_Tootaja_roll  PRIMARY KEY ( tootaja_roll_kood ),
     CONSTRAINT CHK_Tootaja_roll_kirjeldus_ei_tohi_olla_tyhi CHECK ( kirjeldus !~ '^[[:space:]]*$'),
     CONSTRAINT AK_Tootaja_roll_tootaja_roll_nimetus UNIQUE(tootaja_roll_nimetus)



)
;

CREATE TABLE  Tootaja_seisundi_liik 
(
	 tootaja_seisundi_liik_kood  smallint  NOT NULL,
	 tootaja_seisundi_liik_nimetus  nimetus,
	CONSTRAINT  PK_Tootaja_seisundi_liik  PRIMARY KEY ( tootaja_seisundi_liik_kood ),
     CONSTRAINT AK_Tootaja_seisundi_liik_nimetus UNIQUE(tootaja_seisundi_liik_nimetus)


)
;

CREATE TABLE  Laadimispunkti_seisundi_liik 
(
	 laadimispunkti_seisundi_liik_kood  smallint NOT NULL,
	 laadimispunkti_seisundi_liik_nimetus  nimetus,
	CONSTRAINT  PK_Laadimispunkti_seisundi_liik  PRIMARY KEY ( laadimispunkti_seisundi_liik_kood ),
     CONSTRAINT AK_laadimispunkti_seisundi_liik_nimetus UNIQUE(laadimispunkti_seisundi_liik_nimetus)


)
;

CREATE TABLE  Laadimispunkti_kategooria_tyyp 
(
	 laadimispunkti_kategooria_tyyp_kood  smallint NOT NULL,
	 laadimispunkti_kategooria_tyyp_nimetus  nimetus,
	CONSTRAINT  PK_Laadimispunkti_kategooria_tyyp  PRIMARY KEY ( laadimispunkti_kategooria_tyyp_kood ),
     CONSTRAINT AK_Laadimispunkti_kategooiria_tyyp_nimetus UNIQUE(laadimispunkti_kategooria_tyyp_nimetus)

)
;

CREATE TABLE  Kliendi_seisundi_liik 
(
	 kliendi_seisundi_liik_kood  smallint NOT NULL,
	 kliendi_seisundi_liik_nimetus  nimetus,
	CONSTRAINT  PK_Kliendi_seisundi_liik  PRIMARY KEY ( kliendi_seisundi_liik_kood ),
     CONSTRAINT AK_Kliendi_seisundi_liik_nimetus UNIQUE(kliendi_seisundi_liik_nimetus)

)
;

CREATE TABLE  Isiku_seisundi_liik 
(
	 isiku_seisundi_liik_kood smallint NOT NULL,
	 isiku_seisundi_liik_nimetus  nimetus,
	CONSTRAINT  PK_Isiku_seisundi_liik  PRIMARY KEY ( isiku_seisundi_liik_kood ),
     CONSTRAINT AK_Isiku_seisundi_liik_nimetus UNIQUE(isiku_seisundi_liik_nimetus)


)
;

CREATE TABLE  Laadimispunkti_tyyp 
(
	 laadimispunkti_tyyp_kood  smallint NOT NULL,
	 nimetus nimetus,
	 kWh  smallint NOT NULL,
	CONSTRAINT  PK_Laadimispunkti_tyyp  PRIMARY KEY ( laadimispunkti_tyyp_kood ),
    CONSTRAINT CHK_Laadimispunkti_tyyp_kWh_on_oige_kogus CHECK (kWh BETWEEN 0 AND 200),
     CONSTRAINT AK_Laadimispunkti_tyyp_kWh UNIQUE(kWh)


)
;

CREATE TABLE  Laadimispunkti_kategooria 
(
	 laadimispunkti_kategooria_kood  smallint NOT NULL,
	 laadimispunkti_kategooria_nimetus  nimetus,
	 laadimispunkti_kategooria_tyyp_kood  smallint NOT NULL,
	CONSTRAINT  PK_Laadimispunkti_kategooria  PRIMARY KEY ( laadimispunkti_kategooria_kood ),
	CONSTRAINT  FK_Laadimispunkti_kategooria_tyyp_kood  FOREIGN KEY ( laadimispunkti_kategooria_tyyp_kood ) REFERENCES  Laadimispunkti_kategooria_tyyp  ( laadimispunkti_kategooria_tyyp_kood ) ON DELETE No Action ON UPDATE CASCADE ,
     CONSTRAINT AK_Laadimispunkti_kategooria_kood_nimetus UNIQUE(laadimispunkti_kategooria_tyyp_kood, laadimispunkti_kategooria_nimetus)


)
;

CREATE TABLE  Isik 
(
     isik_id  BIGSERIAL UNIQUE NOT NULL,
	 isikukood  isikukood,
	 synni_kp  date NOT NULL,
	 reg_aeg  aeg,
	 eesnimi  varchar(1024),
	 perenimi  varchar(1024),
	 elukoht  varchar(1024),
	 e_meil  varchar(254) NOT NULL,
     riik_kood  varchar(3) NOT NULL,
	 isiku_seisundi_liik_kood  smallint NOT NULL DEFAULT 0,
	CONSTRAINT  PK_Isik  PRIMARY KEY ( isik_id ),
	CONSTRAINT  FK_Isik_Isiku_seisundi_liik  FOREIGN KEY ( isiku_seisundi_liik_kood ) REFERENCES  Isiku_seisundi_liik  ( isiku_seisundi_liik_kood ) ON DELETE No Action  ON UPDATE CASCADE ,
	CONSTRAINT  FK_Isik_isikukoodi_riik  FOREIGN KEY ( riik_kood ) REFERENCES  Riik  ( riik_kood ) ON DELETE No Action ON UPDATE Cascade,
    CONSTRAINT AK_Isik_id_riik UNIQUE (isikukood, riik_kood),
    CONSTRAINT CHK_Isik_on_oige_email CHECK (e_meil ~* '^[A-Za-z0-9._%-]+@[A-Za-z0-9.-]+[.][A-Za-z]+$'),
    CONSTRAINT CHK_Isik_pere_voi_eesnimi_not_null CHECK ( perenimi IS NOT NULL OR eesnimi IS NOT NULL ),
    CONSTRAINT CHK_Isik_nimi_ei_ole_tyhi_strting CHECK (perenimi !~ '^[[:space:]]*$' AND eesnimi !~ '^[[:space:]]*$'),
    CONSTRAINT CHK_Isik_synni_kp CHECK ( (synni_kp BETWEEN To_DATE('01-01-1900', 'DD-MM-YYYY') AND To_DATE('31-12-2100', 'DD-MM-YYYY'))),
    CONSTRAINT CHK_Isik_synnikp_ei_ole_suurem_reg_ajast CHECK ( reg_aeg::date >= synni_kp  ),
    CONSTRAINT CHK_Isik_elukoht_ei_tohi_olla_tyhi_ega_ainult_numbrid CHECK ( elukoht !~ '^[[:space:]]*$' AND elukoht !~ '^[0-9]+$')
)
;

CREATE TABLE  Kasutajakonto 
(
    isik_id  bigint NOT NULL,
    parool  varchar(50)	 NOT NULL,
	 on_aktiivne  boolean DEFAULT TRUE NOT NULL,
	CONSTRAINT  PK_Kasutajakonto  PRIMARY KEY ( isik_id ),
	CONSTRAINT  FK_Kasutajakonto_Isik  FOREIGN KEY ( isik_id ) REFERENCES  Isik  ( isik_id ) ON DELETE CASCADE ON UPDATE NO ACTION ,
	CONSTRAINT CHK_Kasutajakonto_parool_ei_ole_tyhi CHECK ( parool !~ '^[[:space:]]*$')
)
;

CREATE TABLE  Tootaja 
(
    isik_id  bigint NOT NULL,
    tootaja_seisundi_liik_kood  smallint NOT NULL DEFAULT 0,
	 Mentor  bigint,
	CONSTRAINT  PK_Tootaja  PRIMARY KEY ( isik_id ),
	CONSTRAINT  FK_Tootaja_Tootaja_seisundi_liik  FOREIGN KEY ( tootaja_seisundi_liik_kood ) REFERENCES  Tootaja_seisundi_liik  ( tootaja_seisundi_liik_kood ) ON DELETE No Action ON UPDATE CASCADE,
	CONSTRAINT  FK_Tootaja_Isik  FOREIGN KEY ( isik_id ) REFERENCES  Isik  ( isik_id ) ON DELETE CASCADE ON UPDATE NO ACTION ,
	CONSTRAINT  FK_Tootaja_Mentor  FOREIGN KEY ( Mentor ) REFERENCES  Tootaja  ( isik_id ) ON DELETE SET NULL ON UPDATE No Action,
    CONSTRAINT CHK_Tootaja_isik_ja_mentor_ei_ole_samad CHECK( isik_id != mentor )
)
;

CREATE TABLE  Laadimispunkt
(

     Laadimispunkti_kood  bigint NOT NULL,
     laiuskraad  decimal(10,4) NOT NULL,
	 laadimispunkti_nimetus  nimetus,
	 pikkuskraad  decimal(10,4) NOT NULL,
	 reg_aeg  aeg,
	 registreerija_id  bigint NOT NULL,
	 laadimispunkti_seisundi_liik_kood  smallint NOT NULL DEFAULT 0,
     laadimispunkti_tyyp_kood  smallint NOT NULL DEFAULT 0,
	CONSTRAINT  PK_Laadimispunkt  PRIMARY KEY ( Laadimispunkti_kood ),
	CONSTRAINT  CHK_Laadimispunkt_kehtiv_laiuskraad  CHECK (laiuskraad BETWEEN -180 AND 180),
	CONSTRAINT  CHK_Laadimispunkt_kehtiv_pikkuskraad  CHECK (pikkuskraad BETWEEN -90 AND 90),
	CONSTRAINT  FK_Laadimispunkt_Laadimispunkti_tyyp  FOREIGN KEY ( laadimispunkti_tyyp_kood ) REFERENCES  Laadimispunkti_tyyp  ( laadimispunkti_tyyp_kood ) ON DELETE No Action ON UPDATE CASCADE ,
    CONSTRAINT FK_Laadimispunkt_registreerija_id FOREIGN KEY (registreerija_id) REFERENCES tootaja(isik_id),
    CONSTRAINT FK_Laadimispunkt_laadiimis_seisundi_liik_kood FOREIGN KEY (laadimispunkti_seisundi_liik_kood) REFERENCES laadimispunkti_seisundi_liik(laadimispunkti_seisundi_liik_kood)  ON UPDATE CASCADE,
    CONSTRAINT AK_Laadimispunkt_laadimimispunkkti_nimi UNIQUE(laadimispunkti_nimetus)
)
;

CREATE TABLE  Klient 
(
    isik_id  bigint NOT NULL,
    on_nous_tylitamisega  boolean DEFAULT FALSE NOT NULL,
     kliendi_seisundi_liik_kood  smallint NOT NULL DEFAULT 0,
	CONSTRAINT  PK_Klient  PRIMARY KEY ( isik_id ),
	CONSTRAINT  FK_Klient_Kliendi_seisundi_liik  FOREIGN KEY ( kliendi_seisundi_liik_kood ) REFERENCES  Kliendi_seisundi_liik  ( kliendi_seisundi_liik_kood ) ON DELETE No Action ON UPDATE CASCADE ,
	CONSTRAINT  FK_Klient_Isik  FOREIGN KEY ( isik_id ) REFERENCES  Isik  ( isik_id ) ON DELETE CASCADE  ON UPDATE NO ACTION
)
;

CREATE TABLE  Laadimispunkti_kategooria_omamine 
(
	Laadimispunkti_kood  bigint NOT NULL,
    laadimispunkti_kategooria_kood  smallint NOT NULL,
	CONSTRAINT  PK_Laadimispunkti_kategooria_omamine  PRIMARY KEY ( Laadimispunkti_kood , laadimispunkti_kategooria_kood ),
	CONSTRAINT FK_Laadimispunkti_kategooria_omamine_Laadimispunkti_kood FOREIGN KEY (Laadimispunkti_kood) REFERENCES laadimispunkt(laadimispunkti_kood) ON UPDATE CASCADE ,
	CONSTRAINT FK_Laadimispunkti_kategooria_omamine_kategooria_kood FOREIGN KEY (laadimispunkti_kategooria_kood) REFERENCES laadimispunkti_kategooria(laadimispunkti_kategooria_kood) ON UPDATE CASCADE
)
;

CREATE TABLE  Tootaja_rolli_omamine 
(
    tootaja_rolli_omamine_id  bigserial NOT NULL,
    alguse_aeg  aeg,
	 lopu_aeg  aeg_default_infinity,
    tootaja_roll_kood  smallint NOT NULL,
	 isik_id  bigint NOT NULL,
	CONSTRAINT  PK_Tootaja_rolli_omamine_id  PRIMARY KEY ( tootaja_rolli_omamine_id ),
	CONSTRAINT  FK_Tootaja_rolli_omamine_Tootaja_roll  FOREIGN KEY ( tootaja_roll_kood ) REFERENCES  Tootaja_roll  ( tootaja_roll_kood ) ON DELETE No Action ON UPDATE CASCADE,
	CONSTRAINT  FK_Tootaja_rolli_omamine_Tootaja  FOREIGN KEY ( isik_id ) REFERENCES  Tootaja  ( isik_id ) ON DELETE CASCADE ON UPDATE NO ACTION ,
	CONSTRAINT CHK_Tootaja_rolli_omamine_lopp_on_suurem_algusest CHECK ( lopu_aeg > alguse_aeg ),
	CONSTRAINT AK_Tootaja_rolli_omamine_ei_saa_sama_algatada UNIQUE (isik_id, tootaja_roll_kood, alguse_aeg)



)
;

/* Create Primary Keys, Indexes, Uniques, Checks */

CREATE INDEX  IXFK_Laadimispunkti_tyyp_kWh ON  Laadimispunkti_tyyp  ( kWh  ASC)
;

CREATE INDEX  IXFK_Laadimispunkti_kategooria_Laadimispunkti_kategooria_tyyp  ON  Laadimispunkti_kategooria  ( laadimispunkti_kategooria_tyyp_kood  ASC)
;

CREATE INDEX  IXFK_Isik_Isiku_seisundi_liik  ON  Isik  ( isiku_seisundi_liik_kood  ASC)
;

CREATE INDEX  IXFK_Laadimispunkt_Laadimispunkti_seisundi_liik  ON  Laadimispunkt  ( laadimispunkti_seisundi_liik_kood  ASC)
;

CREATE INDEX  IXFK_Laadimispunkt_Tootaja  ON  Laadimispunkt  ( registreerija_id  ASC)
;

CREATE INDEX  IXFK_Laadimispunkti_kategooria_omamine_Laadimispunkt  ON  Laadimispunkti_kategooria_omamine  ( Laadimispunkti_kood  ASC)
;

CREATE UNIQUE INDEX IXFK_Isik_email_unq_idx ON isik (lower(e_meil))
;