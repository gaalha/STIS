create database Votacion2018;
use Votacion2018;

create table Usuario(
id_usuario int primary key not null,
usuario varchar(25) not null,
clave varchar(25) not null,
tipo_usuario varchar(10) not null,
activo int not null
);

create table Departamento(
id_departamento int primary key not null,
nombre varchar(30) not null,
activo int not null
);

create table Municipio(
id_municipio int primary key not null,
nombre varchar(30) not null,
id_Departamento int not null,
activo int not null
);

create table Votante(
id_votante int primary key not null,
nombre varchar(30) not null,
dui varchar(15) not null,
nombre_madre varchar(50) not null,
nombre_padre varchar(50) not null,
fecha_nac datetime not null,
estado_civil varchar(15) not null,
direccion varchar(40) not null,
id_Usuario int not null,
id_Municipio int not null,
activo int not null
);

create table delegadoInternacional(
id_delgadointernacional int primary key not null,
nombre varchar(30) not null,
apellido varchar(30) not null,
cargo varchar(35) not null,
id_Usuario int not null,
activo int not null
);

create table Encargado(
id_encargado int primary key not null,
nombre varchar(50) not null,
estado_civil varchar(25) not null,
activo int not null
);

create table detalleJRV (
id_detJRV int primary key not null,
numeroJRV int not null,
id_Encargado int not null,
activo int not null
);

create table JRV(
id_JRV int primary key not null,
id_DetJRV int not null,
activo int not null
);

create table Periodo(
id_periodo int primary key not null,
anio int not null,
tipoVotacion varchar(20) not null,
activo int not null
);

create table PresidentePP(
id_presidentePP int primary key not null,
nombre varchar(50) not null,
id_Usuario int not null,
activo int not null
);

create table partidoPolitico(
id_partidoPolitico int primary key not null,
nombre varchar(40) not null,
id_PresidentePP int not null,
activo int not null
);

create table detalleCandidato(
id_detCandidato int primary key not null,
tipoCandidato varchar(20) not null,
activo int not null
);

create table Candidato(
id_candidato int primary key not null,
nombre varchar(60) not null,
titulo varchar(50) not null,
id_PartidoPolitico int not null,
id_DetCandidato int not null,
activo int not null
);

create table centroVotacion(
id_centroVotacion int primary key not null,
nombre varchar(60) not null,
id_Municipio int not null,
id_Periodo int not null,
id_JRV int not null,
activo int not null
);

create table Voto(
id_voto int primary key not null,
id_CentroVotacion int not null,
id_Votante int not null,
id_Candidato int not null,
acumulativo int not null
);

alter table Municipio add constraint foreign key (id_Departamento) references Departamento(id_departamento);
alter table Votante add constraint foreign key (id_Usuario) references Usuario(id_usuario);
alter table Votante add constraint foreign key (id_Municipio) references Municipio(id_municipio);
alter table delegadoInternacional add constraint foreign key (id_Usuario) references Usuario(id_usuario);
alter table detalleJRV add constraint foreign key (id_Encargado) references Encargado(id_encargado);
alter table JRV add constraint foreign key (id_DetJRV) references detalleJRV(id_detJRV);
alter table PresidentePP add constraint foreign key (id_Usuario) references Usuario(id_usuario);
alter table partidoPolitico add constraint foreign key (id_PresidentePP) references PresidentePP(id_presidentePP);
alter table Candidato add constraint foreign key (id_DetCandidato) references detalleCandidato(id_detcandidato);
alter table Candidato add constraint foreign key (id_PartidoPolitico) references partidoPolitico(id_partidoPolitico);
alter table centroVotacion add constraint foreign key (id_Municipio) references Municipio(id_municipio);
alter table centroVotacion add constraint foreign key (id_Periodo) references Periodo(id_periodo);
alter table centroVotacion add constraint foreign key (id_JRV) references JRV(id_JRV);
alter table Voto add constraint foreign key (id_CentroVotacion) references centroVotacion(id_centroVotacion);
alter table Voto add constraint foreign key (id_Votante) references Votante(id_votante);
alter table Voto add constraint foreign key (id_Candidato) references Candidato(id_candidato);
