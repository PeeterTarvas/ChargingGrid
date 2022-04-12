INSERT INTO laadimispunkti_seisundi_liik(nimetus)
VALUES ('tavaline');


INSERT INTO riik(nimetus)
VALUES ('Eesti');

INSERT INTO tootaja_seisundi_liik(nimetus)
VALUES ('tööl');

INSERT INTO tootaja_roll(kirjeldus, nimetus) VALUES ('juhatab', 'Juhataja');

INSERT INTO laadimispunkti_tyyp(tootaja_seisundi_liik_kood, tootaja_roll_kood, riik_kood)
VALUES (1, 1, 1);

INSERT INTO laadimispunkt(laiuskraad, nimetus, pikkuskraad, reg_aeg, registreerija_id, laadimispunkti_seisundi_liik_kood, laadimispunkti_tyyp_id)
VALUES (1.1, 'Tauno', 1.1, default, )