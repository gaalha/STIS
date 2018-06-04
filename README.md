<h2 align="center">STIS PROJECT</h2>

<p align="center">
  <img src="https://img.shields.io/github/issues/edgarMejia/STIS.svg?maxAge=3600&style=flat-square">&nbsp;<img src="https://img.shields.io/github/forks/edgarMejia/STIS.svg?maxAge=3600&style=flat-square">&nbsp;<img src="https://img.shields.io/github/stars/edgarMejia/STIS.svg?maxAge=3600&style=flat-square"</a>&nbsp;<img src="https://img.shields.io/github/license/edgarMejia/STIS.svg?maxAge=3600&style=flat-square">
</p>

## Procedimientos almacenados: ##

```sql
/* DEPARTAMENTO: */
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
```

```sql
/* MUNICIPIO: */
CREATE PROCEDURE `mostrarMunicipio` ()
BEGIN
	SELECT * FROM Municipio
    	WHERE activo = 1;
END

CREATE PROCEDURE `insertarMunicipio` (
	IN nombre_mun VARCHAR(50),
	IN cod_dep INTEGER
)
BEGIN
	INSERT INTO Municipio(id_municipio, nombre_municipio, idDepartamento, activo)
	VALUES(null, nombre_mun, cod_dep, 1);
END

CREATE PROCEDURE `innerMunicipio` ()
BEGIN
	SELECT id_municipio, nombre_municipio, idDepartamento, mu.activo AS activo, dep.nombre_departamento AS departamento
	FROM Municipio AS mu
	INNER JOIN Departamento AS dep
	ON mu.idDepartamento = dep.id_departamento
	AND mu.activo = 1;
END


```

El sistema debe gestionar todo un proceso de elecciones de presidente de la república,
Alcaldes y diputados cuando estos se encuentren en el tiempo.

Copyright (c) 2018 ITCA-FEPADE
