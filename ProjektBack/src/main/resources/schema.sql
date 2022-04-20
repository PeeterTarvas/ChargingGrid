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

DROP DOMAIN IF EXISTS email CASCADE;

/* Create Tables */



CREATE TABLE  Riik 
(
	 riik_kood  varchar(3) NOT NULL,
	 nimetus  varchar(60) UNIQUE  NOT NULL,
	CONSTRAINT  PK_Riik  PRIMARY KEY ( riik_kood ),
	CONSTRAINT CHK_riik_kood_on_oige CHECK ( riik_kood <> '' AND riik_kood ~* '[A-Z]' AND LENGTH(riik_kood) = 3)
)
;

CREATE TABLE  Tootaja_roll 
(
	 kirjeldus  TEXT	NOT NULL,
	 tootaja_roll_kood  smallserial NOT NULL,
	 nimetus  varchar(255) UNIQUE NOT NULL,
	CONSTRAINT  PK_Tootaja_roll  PRIMARY KEY ( tootaja_roll_kood )
)
;

CREATE TABLE  Tootaja_seisundi_liik 
(
	 tootaja_seisundi_liik_kood  smallserial NOT NULL,
	 nimetus  varchar(255) UNIQUE NOT NULL,
	CONSTRAINT  PK_Tootaja_seisundi_liik  PRIMARY KEY ( tootaja_seisundi_liik_kood )
)
;

CREATE TABLE  Laadimispunkti_seisundi_liik 
(
	 laadimispunkti_seisundi_liik_kood  smallserial NOT NULL,
	 nimetus  varchar(255) UNIQUE NOT NULL,
	CONSTRAINT  PK_Laadimispunkti_seisundi_liik  PRIMARY KEY ( laadimispunkti_seisundi_liik_kood )
)
;

CREATE TABLE  Laadimispunkti_kategooria_tyyp 
(
	 laadimispunkti_kategooria_tyyp_kood  smallserial NOT NULL,
	 nimetus  varchar(255) UNIQUE NOT NULL,
	CONSTRAINT  PK_Laadimispunkti_kategooria_tyyp  PRIMARY KEY ( laadimispunkti_kategooria_tyyp_kood )
)
;

CREATE TABLE  Kliendi_seisundi_liik 
(
	 kliendi_seisundi_liik_kood  smallserial NOT NULL,
	 nimetus  varchar(255) UNIQUE NOT NULL,
	CONSTRAINT  PK_Kliendi_seisundi_liik  PRIMARY KEY ( kliendi_seisundi_liik_kood )
)
;

CREATE TABLE  Isiku_seisundi_liik 
(
	 isiku_seisundi_liik_kood  smallserial NOT NULL,
	 nimetus  varchar(255) UNIQUE NOT NULL,
	CONSTRAINT  PK_Isiku_seisundi_liik  PRIMARY KEY ( isiku_seisundi_liik_kood )
)
;

CREATE TABLE  Laadimispunkti_tyyp 
(
	 laadimispunkti_tyyp_kood  smallserial NOT NULL,
	 kWh  bigint UNIQUE NOT NULL,
	CONSTRAINT  PK_Laadimispunkti_tyyp  PRIMARY KEY ( laadimispunkti_tyyp_kood ),
    CONSTRAINT CHK_kWh_is_correct CHECK (kWh BETWEEN 0 AND 200)

)
;

CREATE TABLE  Laadimispunkti_kategooria 
(
	 laadimispunkti_kategooria_kood  smallserial UNIQUE NOT NULL,
	 nimetus  varchar(255) UNIQUE NOT NULL,
	 laadimispunkti_kategooria_tyyp_kood  bigint NOT NULL,
	CONSTRAINT  PK_Laadimispunkti_kategooria  PRIMARY KEY ( laadimispunkti_kategooria_kood, nimetus ),
	CONSTRAINT  FK_Laadimispunkti_kategooria_tyyp_kood  FOREIGN KEY ( laadimispunkti_kategooria_tyyp_kood ) REFERENCES  Laadimispunkti_kategooria_tyyp  ( laadimispunkti_kategooria_tyyp_kood ) ON DELETE No Action ON UPDATE CASCADE
)
;

CREATE TABLE  Isik 
(
     isik_id  BIGSERIAL UNIQUE NOT NULL,
	 isikukood  varchar(255) NOT NULL,
	 synni_kp  date NOT NULL,
	 reg_aeg  timestamp(6) with time zone NOT NULL DEFAULT CURRENT_TIMESTAMP(0),
	 eesnimi  varchar(1024),
	 perenimi  varchar(1024),
	 elukoht  varchar(1024) NOT NULL,
	 e_meil  varchar(254) NOT NULL,
	 isikukoodi_riik  varchar(3) NOT NULL,
	 isiku_seisundi_liik_kood  bigint NOT NULL,
	CONSTRAINT  PK_Isik  PRIMARY KEY ( isik_id ),
	CONSTRAINT  FK_Isik_Isiku_seisundi_liik  FOREIGN KEY ( isiku_seisundi_liik_kood ) REFERENCES  Isiku_seisundi_liik  ( isiku_seisundi_liik_kood ) ON DELETE No Action  ON UPDATE CASCADE,
	CONSTRAINT  FK_isikukoodi_riik  FOREIGN KEY ( isikukoodi_riik ) REFERENCES  Riik  ( riik_kood ) ON DELETE No Action ON UPDATE Cascade,
    CONSTRAINT AK_id_riik UNIQUE (isikukood, isikukoodi_riik),
    CONSTRAINT CHK_on_oige_email CHECK (e_meil ~* '^[A-Za-z0-9._%-]+@[A-Za-z0-9.-]+[.][A-Za-z]+$'),
    CONSTRAINT CHK_on_pere_voi_eesnimi CHECK ( eesnimi <> '' OR perenimi <> ''),
    CONSTRAINT CHK_elukoht CHECK (elukoht <> '' AND elukoht NOT LIKE '^\d+\.?\d+$')
)
;

CREATE TABLE  Kasutajakonto 
(
	 parool  varchar(50)	 NOT NULL,
	 on_aktiivne  boolean DEFAULT TRUE NOT NULL,
	 isik_id  bigint UNIQUE NOT NULL,
	 kasutajakonto_id  BIGSERIAL NOT NULL,
	CONSTRAINT  PK_Kasutajakonto  PRIMARY KEY ( kasutajakonto_id ),
	CONSTRAINT  FK_Kasutajakonto_Isik  FOREIGN KEY ( isik_id ) REFERENCES  Isik  ( isik_id ) ON DELETE CASCADE ON UPDATE CASCADE,
	CONSTRAINT CHK_parool CHECK ( parool <> '')
)
;

CREATE TABLE  Tootaja 
(
	 tootaja_klassifikaatori_kood  bigint NOT NULL,
	 isik_id  bigint NOT NULL,
	 Mentor  bigint,
	CONSTRAINT  PK_Tootaja  PRIMARY KEY ( isik_id ),
	CONSTRAINT  FK_Tootaja_Tootaja_seisundi_liik  FOREIGN KEY ( tootaja_klassifikaatori_kood ) REFERENCES  Tootaja_seisundi_liik  ( tootaja_seisundi_liik_kood ) ON DELETE No Action ON UPDATE Cascade,
	CONSTRAINT  FK_Tootaja_Isik  FOREIGN KEY ( isik_id ) REFERENCES  Isik  ( isik_id ) ON DELETE No Action ON UPDATE No Action,
	CONSTRAINT  FK_Mentor  FOREIGN KEY ( Mentor ) REFERENCES  Tootaja  ( isik_id ) ON DELETE SET NULL ON UPDATE CASCADE,
    CONSTRAINT CHK_check_if_mentor_and_id_dont_match CHECK( isik_id != mentor )
)
;

CREATE TABLE  Laadimispunkt
(
     Laadimispunkti_kood  bigint NOT NULL,
     laiuskraad  decimal(10,4) NOT NULL,
	 nimetus  varchar(255) UNIQUE NOT NULL,
	 pikkuskraad  decimal(10,4) NOT NULL,
	 reg_aeg  timestamp(6)  WITHOUT TIME ZONE NOT NULL DEFAULT CURRENT_TIMESTAMP(0),
	 registreerija_id  bigint NOT NULL,
	 laadimispunkti_seisundi_liik_kood  bigint NOT NULL,
	 laadimispunkti_tyyp_id  bigint NOT NULL,
	CONSTRAINT  PK_Laadimispunkt  PRIMARY KEY ( Laadimispunkti_kood ),
	CONSTRAINT  CHK_kehtiv_laiuskraad  CHECK (laiuskraad BETWEEN -180 AND 180),
	CONSTRAINT  CHK_kehtiv_pikkuskraad  CHECK (pikkuskraad BETWEEN -90 AND 90),
	CONSTRAINT  FK_Laadimispunkt_Laadimispunkti_tyyp  FOREIGN KEY ( laadimispunkti_tyyp_id ) REFERENCES  Laadimispunkti_tyyp  ( laadimispunkti_tyyp_kood ) ON DELETE No Action ON UPDATE No Action,
    CONSTRAINT FK_registreerija_id FOREIGN KEY (registreerija_id) REFERENCES tootaja(isik_id)
)
;

CREATE TABLE  Klient 
(
	 on_nous_tylitamisega  boolean DEFAULT FALSE,
	 klassifikaatori_kood_kliendi_seisund  bigint NOT NULL,
	 isik_id  bigint NOT NULL,
	CONSTRAINT  PK_Klient  PRIMARY KEY ( isik_id ),
	CONSTRAINT  FK_Klient_Kliendi_seisundi_liik  FOREIGN KEY ( klassifikaatori_kood_kliendi_seisund ) REFERENCES  Kliendi_seisundi_liik  ( kliendi_seisundi_liik_kood ) ON DELETE No Action ON UPDATE Cascade,
	CONSTRAINT  FK_Klient_Isik  FOREIGN KEY ( isik_id ) REFERENCES  Isik  ( isik_id ) ON DELETE No Action  ON UPDATE CASCADE
)
;

CREATE TABLE  Laadimispunkti_kategooria_omamine 
(
	 Laadimispunkti_kood  smallint NOT NULL,
     laadimispunkti_kategooria_kood  smallint NOT NULL,
	CONSTRAINT  PK_Laadimispunkti_kategooria_omamine  PRIMARY KEY ( Laadimispunkti_kood , laadimispunkti_kategooria_kood ),
	CONSTRAINT FK_laadimispunkti_kood FOREIGN KEY (Laadimispunkti_kood) REFERENCES laadimispunkt(laadimispunkti_kood),
	CONSTRAINT FK_laadimispunkti_kategooria FOREIGN KEY (laadimispunkti_kategooria_kood) REFERENCES laadimispunkti_kategooria(laadimispunkti_kategooria_kood)
)
;

CREATE TABLE  Tootaja_rolli_omamine 
(
	 alguse_aeg  date NOT NULL,
	 lopu_aeg  date NULL,
	 tootaja_rolli_klassifikaatori_kood  bigint NOT NULL,
	 isik_id  bigint NOT NULL,
	 tootaja_rolli_omamine_id  bigint NOT NULL,
	CONSTRAINT  PK_Tootaja_rolli_omamine  PRIMARY KEY ( tootaja_rolli_omamine_id ),
	CONSTRAINT  FK_Tootaja_rolli_omamine_Tootaja_roll  FOREIGN KEY ( tootaja_rolli_klassifikaatori_kood ) REFERENCES  Tootaja_roll  ( tootaja_roll_kood ) ON DELETE No Action ON UPDATE Cascade,
	CONSTRAINT  FK_Tootaja_rolli_omamine_Tootaja  FOREIGN KEY ( isik_id ) REFERENCES  Tootaja  ( isik_id ) ON DELETE No Action ON UPDATE No Action
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

CREATE UNIQUE INDEX email_unq_idx ON isik (lower(e_meil))
;

CREATE UNIQUE INDEX laadimispunkt_uniq_indx ON laadimispunkt(Laadimispunkti_kood)
;