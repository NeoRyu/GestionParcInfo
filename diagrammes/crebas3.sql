/*==============================================================*/
/* Nom de SGBD :  MySQL 5.0                                     */
/* Date de cr�ation :  08/11/2016 10:43:41                      */
/*==============================================================*/


drop table if exists BATIMENT;

drop table if exists COMPOSANT;

drop table if exists COMPOSER;

drop table if exists DESIGNER;

drop table if exists FORMATION;

drop table if exists MACHINE;

drop table if exists PARTICIPER;

drop table if exists POSSEDER;

drop table if exists ROLE;

drop table if exists SALLE;

drop table if exists SITE;

drop table if exists UTILISATEUR;

drop table if exists UTILISER;

/*==============================================================*/
/* Table : BATIMENT                                             */
/*==============================================================*/
create table BATIMENT
(
   BAT_ID               int not null auto_increment,
   SITE_ID              int not null,
   BAT_NUMERO           varchar(10) not null,
   primary key (BAT_ID)
);

/*==============================================================*/
/* Table : COMPOSANT                                            */
/*==============================================================*/
create table COMPOSANT
(
   COMPO_ID             int not null auto_increment,
   COMPO_LIBELLE        varchar(100) not null,
   COMPO_REFERENCE      varchar(250) not null,
   COMPO_CONSTRUCTEUR   varchar(250) not null,
   COMPO_DETAILS        varchar(150),
   COMPO_FORMAT         varchar(3),
   COMPO_TYPE           varchar(10),
   COMPO_CAPACITE       int,
   COMPO_ARCHI          int,
   COMPO_NBCOEURS       int,
   COMPO_FREQUENCE      int,
   primary key (COMPO_ID)
);

/*==============================================================*/
/* Table : COMPOSER                                             */
/*==============================================================*/
create table COMPOSER
(
   MACHINE_ID           int not null,
   COMPO_ID             int not null,
   QUANTITE             int not null,
   primary key (MACHINE_ID, COMPO_ID)
);

/*==============================================================*/
/* Table : DESIGNER                                             */
/*==============================================================*/
create table DESIGNER
(
   UTIL_ID              int not null,
   ROLE_ID              int not null,
   primary key (UTIL_ID, ROLE_ID)
);

/*==============================================================*/
/* Table : FORMATION                                            */
/*==============================================================*/
create table FORMATION
(
   FORMA_ID             int not null auto_increment,
   FORMA_LIBELLE        varchar(100) not null,
   primary key (FORMA_ID)
);

/*==============================================================*/
/* Table : MACHINE                                              */
/*==============================================================*/
create table MACHINE
(
   MACHINE_ID           int not null auto_increment,
   LOCAL_ID             int not null,
   MACHINE_ID_UNIQUE    varchar(100) not null,
   MACHINE_ID_AFPA      varchar(100) not null,
   MACHINE_DATE_ACHAT   date,
   MACHINE_DUREE_GARANTIE int,
   MACHINE_TYPE         varchar(100),
   MACHINE_IP           varchar(100),
   PRET                 bool not null,
   LOCAL_ORIGINE        int,
   primary key (MACHINE_ID)
);

/*==============================================================*/
/* Table : PARTICIPER                                           */
/*==============================================================*/
create table PARTICIPER
(
   UTIL_ID              int not null,
   FORMA_ID             int not null,
   primary key (UTIL_ID, FORMA_ID)
);

/*==============================================================*/
/* Table : POSSEDER                                             */
/*==============================================================*/
create table POSSEDER
(
   FORMA_ID             int not null,
   MACHINE_ID           int not null,
   primary key (FORMA_ID, MACHINE_ID)
);

/*==============================================================*/
/* Table : ROLE                                                 */
/*==============================================================*/
create table ROLE
(
   ROLE_ID              int not null auto_increment,
   ROLE_LIBELLE         varchar(100) not null,
   primary key (ROLE_ID)
);

/*==============================================================*/
/* Table : SALLE                                                */
/*==============================================================*/
create table SALLE
(
   LOCAL_ID             int not null auto_increment,
   BAT_ID               int not null,
   LOCAL_NUMERO         int not null,
   primary key (LOCAL_ID)
);

/*==============================================================*/
/* Table : SITE                                                 */
/*==============================================================*/
create table SITE
(
   SITE_ID              int not null auto_increment,
   SITE_LIBELLE         varchar(250) not null,
   SITE_ADRESSE         varchar(250),
   SITE_CP              int,
   SITE_VILLE           varchar(100),
   primary key (SITE_ID)
);

/*==============================================================*/
/* Table : UTILISATEUR                                          */
/*==============================================================*/
create table UTILISATEUR
(
   UTIL_ID              int not null auto_increment,
   UTIL_NOM             varchar(50) not null,
   UTIL_PRENOM          varchar(50) not null,
   UTIL_ID_AFPA         varchar(30) not null,
   UTIL_ADRESSE         varchar(256) not null,
   UTIL_CP              varchar(5) not null,
   UTIL_VILLE           varchar(30) not null,
   UTIL_TELEPHONE       varchar(10) not null,
   primary key (UTIL_ID)
);

/*==============================================================*/
/* Table : UTILISER                                             */
/*==============================================================*/
create table UTILISER
(
   UTIL_ID              int not null,
   MACHINE_ID           int not null,
   primary key (UTIL_ID, MACHINE_ID)
);

alter table BATIMENT add constraint FK_ETRE foreign key (SITE_ID)
      references SITE (SITE_ID) on delete restrict on update restrict;

alter table COMPOSER add constraint FK_COMPOSER foreign key (MACHINE_ID)
      references MACHINE (MACHINE_ID) on delete restrict on update restrict;

alter table COMPOSER add constraint FK_COMPOSER2 foreign key (COMPO_ID)
      references COMPOSANT (COMPO_ID) on delete restrict on update restrict;

alter table DESIGNER add constraint FK_DESIGNER foreign key (UTIL_ID)
      references UTILISATEUR (UTIL_ID) on delete restrict on update restrict;

alter table DESIGNER add constraint FK_DESIGNER2 foreign key (ROLE_ID)
      references ROLE (ROLE_ID) on delete restrict on update restrict;

alter table MACHINE add constraint FK_STOCKER foreign key (LOCAL_ID)
      references SALLE (LOCAL_ID) on delete restrict on update restrict;

alter table MACHINE add constraint FK_SALLE_ORIGINE foreign key (LOCAL_ORIGINE)
      references SALLE (LOCAL_ID) on delete restrict on update restrict;

alter table PARTICIPER add constraint FK_PARTICIPER foreign key (UTIL_ID)
      references UTILISATEUR (UTIL_ID) on delete restrict on update restrict;

alter table PARTICIPER add constraint FK_PARTICIPER2 foreign key (FORMA_ID)
      references FORMATION (FORMA_ID) on delete restrict on update restrict;

alter table POSSEDER add constraint FK_POSSEDER foreign key (FORMA_ID)
      references FORMATION (FORMA_ID) on delete restrict on update restrict;

alter table POSSEDER add constraint FK_POSSEDER2 foreign key (MACHINE_ID)
      references MACHINE (MACHINE_ID) on delete restrict on update restrict;

alter table SALLE add constraint FK_AVOIR foreign key (BAT_ID)
      references BATIMENT (BAT_ID) on delete restrict on update restrict;

alter table UTILISER add constraint FK_UTILISER foreign key (UTIL_ID)
      references UTILISATEUR (UTIL_ID) on delete restrict on update restrict;

alter table UTILISER add constraint FK_UTILISER2 foreign key (MACHINE_ID)
      references MACHINE (MACHINE_ID) on delete restrict on update restrict;

      alter table COMPOSANT add constraint FK_CONTENIR foreign key (MACHINE_ID)
      references MACHINE (MACHINE_ID) on delete restrict on update restrict;

