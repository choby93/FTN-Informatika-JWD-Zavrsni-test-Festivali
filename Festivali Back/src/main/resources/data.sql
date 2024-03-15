INSERT INTO korisnik (id, e_mail, korisnicko_ime, lozinka, ime, prezime, uloga)
              VALUES (1,'miroslav@maildrop.cc','miroslav','$2y$12$NH2KM2BJaBl.ik90Z1YqAOjoPgSd0ns/bF.7WedMxZ54OhWQNNnh6','Miroslav','Simic','ADMIN');
INSERT INTO korisnik (id, e_mail, korisnicko_ime, lozinka, ime, prezime, uloga)
              VALUES (2,'tamara@maildrop.cc','tamara','$2y$12$DRhCpltZygkA7EZ2WeWIbewWBjLE0KYiUO.tHDUaJNMpsHxXEw9Ky','Tamara','Milosavljevic','KORISNIK');
INSERT INTO korisnik (id, e_mail, korisnicko_ime, lozinka, ime, prezime, uloga)
              VALUES (3,'petar@maildrop.cc','petar','$2y$12$i6/mU4w0HhG8RQRXHjNCa.tG2OwGSVXb0GYUnf8MZUdeadE4voHbC','Petar','Jovic','KORISNIK');


INSERT INTO festival (id, naziv) VALUE (1, "EXIT Festival");
INSERT INTO festival (id, naziv) VALUE (2, "SZiGET Festival");
INSERT INTO festival (id, naziv) VALUE (3, "Ohrid Summer Festival");
INSERT INTO festival (id, naziv) VALUE (4, "Sonus festival");
INSERT INTO festival (id, naziv) VALUE (5, "Refresh Festival");

INSERT INTO izvodjac (id, ime, zanr, drzava, broj_clanova) VALUES (1, "Skrillex", "Dubstep", "USA", 1); 
INSERT INTO izvodjac (id, ime, zanr, drzava, broj_clanova) VALUES (2, "Metallica","Heavy metal, Hard Rock", "USA", 4);
INSERT INTO izvodjac (id, ime, zanr, drzava, broj_clanova) VALUES (3, "SLipknot", "Heavy metal", "USA", 7);
INSERT INTO izvodjac (id, ime, zanr, drzava, broj_clanova) VALUES (4, "David Guetta", "Electro  house", "France", 1);
INSERT INTO izvodjac (id, ime, zanr, drzava, broj_clanova) VALUES (5, "Martin Garrix", "Electro  house", "Netherlands", 1);


INSERT INTO nastup (id, festival_id, izvodjac_id) VALUE (1, 1, 3);
INSERT INTO nastup (id, festival_id, izvodjac_id) VALUE (2, 4, 4);
INSERT INTO nastup (id, festival_id, izvodjac_id) VALUE (3, 5, 2);
INSERT INTO nastup (id, festival_id, izvodjac_id) VALUE (4, 2, 1);
INSERT INTO nastup (id, festival_id, izvodjac_id) VALUE (5, 3, 2);