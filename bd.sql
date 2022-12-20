CREATE DATABASE gestionavion;
\c gestionavion;

create table utilisateur(
    id serial primary key not null,
    pseudo char(20),
    mdp text
);
insert into utilisateur(pseudo,mdp)values('mianta','123456');

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
insert into avion(nomAvion,capacite,envergue,hauteur,masseDecollage,vitesseCroisiere,vitessemax,rayonmax,capaciteKerosene)values('Air bus 360',300,1500,6,2000,1000,3600,1000);


create table kilometrage(
    idkilometrage serial primary key not null,
    debutkm int,
    finkm int,
    dateAvion date,
    idavion int references avion(idavion)
);


create table destination(
    iddestination serial primary key not null,
    destination varchar(30),
    lieudapart varchar(30)
);

create table mouvement(
    idmouvement serial primary key not null,
    numeroVol varchar(30),
    iddestination int references destination(iddestination),
    datedepart timestamp,
    datearrive timestamp,
    dureeVol timestamp,
    idavion int references avion(idavion)
);

create table type_entretien(
    idtype_entretien serial primary key not null,
    type_entretien_avion varchar(30)
);

create table entretien(
    identretion serial primary key not null,
    idtype_entretien int references type_entretien(idtype_entretien),
    dateEntretient date,
    idassurance int references avion(idavion)
);

create table assurance(
    idassurance serial primary key not null,
    datedebut date,
    datefin date,
    nomAssurance varchar(30),
    idavion int references avion(idavion)
);


