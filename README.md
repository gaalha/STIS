<h2 align="center">STIS PROJECT</h2>

<p align="center">
  <img src="https://img.shields.io/github/issues/edgarMejia/STIS.svg?maxAge=3600&style=flat-square">&nbsp;<img src="https://img.shields.io/github/forks/edgarMejia/STIS.svg?maxAge=3600&style=flat-square">&nbsp;<img src="https://img.shields.io/github/stars/edgarMejia/STIS.svg?maxAge=3600&style=flat-square"</a>&nbsp;<img src="https://img.shields.io/github/license/edgarMejia/STIS.svg?maxAge=3600&style=flat-square">
</p>

## Procedimientos almacenados: ##

The screenshot above shows next options in action:

MUNICIPIO:
```
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

```js
// Settings
"draw_white_space": "all",
"fade_fold_buttons": false,
"font_face": "Fira Code Light",
"font_size": 11,
"theme_accent_numix": true,
"theme_autocomplete_item_selected_colored": true,
"theme_dropdown_atomized": true,
"theme_find_panel_materialized": true,
"theme_grid_border_size_xs": true,
"theme_popup_border_visible": true,
"theme_quick_panel_border_visible": true,
"theme_quick_panel_item_selected_colored": true,
"theme_scrollbar_colored": true,
"theme_scrollbar_line": true,
"theme_sidebar_disclosure": true,
"theme_tab_selected_transparent": true,
"theme_tab_selected_underlined": true,
"theme_tab_size_lg": true,
"theme_unified": true,
```

El sistema debe gestionar todo un proceso de elecciones de presidente de la república,
Alcaldes y diputados cuando estos se encuentren en el tiempo.

Copyright (c) 2018 ITCA-FEPADE
