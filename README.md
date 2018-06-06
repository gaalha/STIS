<h2 align="center">STIS PROJECT</h2>

<p align="center">
  <img src="https://img.shields.io/github/issues/edgarMejia/STIS.svg?maxAge=3600&style=flat-square">&nbsp;<img src="https://img.shields.io/github/forks/edgarMejia/STIS.svg?maxAge=3600&style=flat-square">&nbsp;<img src="https://img.shields.io/github/stars/edgarMejia/STIS.svg?maxAge=3600&style=flat-square"</a>&nbsp;<img src="https://img.shields.io/github/license/edgarMejia/STIS.svg?maxAge=3600&style=flat-square">
</p>

## Procedimientos almacenados: ##

```sql
/*============================================================
			DEPARTAMENTO:
============================================================*/

CREATE PROCEDURE `mostrarDepartamento` ()
BEGIN
	SELECT *
	FROM Departamento
	WHERE activo = 1;
END

CREATE PROCEDURE `insertarDepartamento` (IN nombre VARCHAR(50))
BEGIN
	INSERT INTO Departamento(id_departamento, nombre_departamento, activo)
	VALUES(null, nombre, 1);
END

CREATE PROCEDURE `eliminarDepartamento` (id_dep INTEGER)
BEGIN
	UPDATE Departamento
	SET activo = 0
	WHERE id_departamento = id_dep;
END

CREATE PROCEDURE `modificarDepartamento` (
	IN id_dep INTEGER,
	IN nombre_dep VARCHAR(50),
	IN act INTEGER
)
BEGIN
	UPDATE Departamento
	SET nombre_departamento = nombre_dep, activo = act
	WHERE id_departamento = id_dep;
END

/*============================================================
			MUNICIPIO
============================================================*/

CREATE PROCEDURE `innerMunicipio` ()
BEGIN
	SELECT id_municipio, nombre_municipio, idDepartamento, mu.activo AS activo, dep.nombre_departamento AS departamento
	FROM Municipio AS mu
	INNER JOIN Departamento AS dep
	ON mu.idDepartamento = dep.id_departamento
	AND mu.activo = 1;
END

CREATE PROCEDURE `insertarMunicipio` (
	IN nombre_mun VARCHAR(50),
	IN cod_dep INTEGER
)
BEGIN
	INSERT INTO Municipio(id_municipio, nombre_municipio, idDepartamento, activo)
	VALUES(null, nombre_mun, cod_dep, 1);
END

CREATE PROCEDURE `modificarMunicipio` (
	IN nombre_mun VARCHAR(50),
	IN id_dep INTEGER,
	IN id_mun INTEGER
)
BEGIN
	UPDATE Municipio
	SET nombre_municipio = nombre_mun, idDepartamento = id_dep, activo = 1
	WHERE id_municipio = id_mun;
END

CREATE PROCEDURE `eliminarMunicipio` (
	IN cod_mun INTEGER
)
BEGIN
	UPDATE Municipio
	SET activo = 0
    	WHERE id_municipio = cod_mun;
END

/*============================================================
			VOTANTE
============================================================*/

CREATE PROCEDURE `mostrarVotante` ()
BEGIN
	SELECT id_votante, nombre_votante, dui, nombreMadre, nombrePadre, fechaNac, estadoCivil, direccion, idMunicipio, nombre_municipio, vt.activo AS activo
	FROM Votante vt
	INNER JOIN Municipio
	ON id_municipio = idMunicipio
	WHERE vt.activo = 1;
END

CREATE PROCEDURE `insertarVotante` (
	IN nom_vot VARCHAR(50),
	IN duii VARCHAR(20),
	IN nombre_madre VARCHAR(50),
	IN nombre_padre VARCHAR(50),
	IN fecha_nacimiento VARCHAR(30),
	IN estado_civil VARCHAR(50),
	IN direcc VARCHAR(100),
	IN id_municipio INTEGER
	
)
BEGIN
	INSERT INTO Votante(id_votante, nombre_votante, dui, nombreMadre, nombrePadre, fechaNac, estadoCivil, direccion, idMunicipio, activo)
	VALUES(null, nom_vot, duii, nombre_madre, nombre_padre, fecha_nacimiento, estado_civil, direcc, id_municipio, 1);
END

CREATE PROCEDURE `modificarVotante` (
	IN id_vot INTEGER,
	IN nom_vot VARCHAR(50),
	IN duii VARCHAR(20),
	IN nombre_madre VARCHAR(50),
	IN nombre_padre VARCHAR(50),
	IN fecha_nacimiento VARCHAR(30),
	IN estado_civil VARCHAR(50),
	IN direcc VARCHAR(100),
	IN id_municipio INTEGER	
)
BEGIN
	UPDATE Votante
	SET nombre_votante=nom_vot, dui=duii, nombreMadre=nombre_madre, nombrePadre=nombre_padre, fechaNac=fecha_nacimiento, estadoCivil=estado_civil, direccion=direcc, idMunicipio=id_municipio, activo=1
	WHERE id_votante=id_vot;
END

CREATE PROCEDURE `eliminarVotante` (IN cod_vot INTEGER)
BEGIN
	UPDATE Votante
    	SET Activo = 0
	WHERE id_votante = cod_vot;
END
```

El sistema debe gestionar todo un proceso de elecciones de presidente de la república,
Alcaldes y diputados cuando estos se encuentren en el tiempo.

Copyright (c) 2018 ITCA-FEPADE
