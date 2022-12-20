CREATE DATABASE gestionavion;
\c gestionavion;

create table utilisateur(
    id serial primary key not null,
    pseudo char(20),
    mdp text
);
insert into utilisateur(pseudo,mdp)values
('mianta','123456');

SELECT*from utilisateur;

create table token(
    id serial primary key not null,
    token text,
    expire date,
    idutilisateur int
);
create table avion(
    idavion serial primary key not null,
    nomAvion varchar(30),
    capacite int,
    envergue int,
    hauteur int,
    masseDecollage int,
    vitesseCroisiere int,
    vitessemax int,
    rayonmax int,
    capaciteKerosene int,
    photo text default 'vide.png'
);
insert into avion(nomAvion,capacite,envergue,hauteur,masseDecollage,vitesseCroisiere,vitessemax,rayonmax,capaciteKerosene)values
('Air bus 360',300,1500,6,2000,1000,3600,1000,40);
insert into avion(nomAvion,capacite,envergue,hauteur,masseDecollage,vitesseCroisiere,vitessemax,rayonmax,capaciteKerosene)values
('Air bus 400',301,1600,6,2000,1000,3600,1000,50);

SELECT*from avion;


create table kilometrage(
    idkilometrage serial primary key not null,
    debutkm int,
    finkm int,
    dateAvion date,
    idavion int references avion(idavion)
);
insert into kilometrage(debutkm,finkm,dateAvion,idavion)values(1200, 3600,'2022-12-19', 1);
insert into kilometrage(debutkm,finkm,dateAvion,idavion)values(2300, 5000,'2022-10-09', 2);

SELECT*from kilometrage;


create table destination(
    iddestination serial primary key not null,
    destination varchar(30),
    lieudapart varchar(30)
);
insert into destination(destination,lieudapart)values('Hawai', 'CDG');
insert into destination(destination,lieudapart)values('Canada', 'CDG');

SELECT*from destination;


create table mouvement(
    idmouvement serial primary key not null,
    numeroVol varchar(30),
    iddestination int references destination(iddestination),
    datedepart date,
    datearrive date,
    dureeVol int,
    idavion int references avion(idavion)
);
insert into mouvement(numeroVol,iddestination,datedepart,datearrive,dureeVol,idavion)values('001', 1,'2022-02-20','2022-02-21',10, 1);
insert into mouvement(numeroVol,iddestination,datedepart,datearrive,dureeVol,idavion)values('002', 2,'2022-03-02','2022-03-03',10, 1);

SELECT*from mouvement;



create table type_entretien(
    idtype_entretien serial primary key not null,
    type_entretien_avion varchar(30)
);
insert into type_entretien(type_entretien_avion)values('Lavage');
insert into type_entretien(type_entretien_avion)values('Vidange');

SELECT*from type_entretien;


create table entretien(
    identretion serial primary key not null,
    idtype_entretien int references type_entretien(idtype_entretien),
    dateEntretient date,
    idavion int references avion(idavion)
);
insert into entretien(idtype_entretien,dateEntretient,idassurance)values(2,'2022-02-19', 2);
insert into entretien(idtype_entretien,dateEntretient,idassurance)values(1,'2022-03-01', 1);

SELECT*from entretien;


create table assurance(
    idassurance serial primary key not null,
    datedebut date,
    datefin date,
    nomAssurance varchar(30),
    idavion int references avion(idavion)
);
insert into assurance(datedebut,datefin,nomAssurance,idavion)values('2022-01-20','2023-01-20','Aro',1);
insert into assurance(datedebut,datefin,nomAssurance,idavion)values('2022-03-20','2023-03-20','Aro',2);

SELECT*from assurance;

