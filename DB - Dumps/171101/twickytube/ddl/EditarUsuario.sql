CREATE PROCEDURE `EditarUsuario` 
(
	_id_usuario varchar(50),
	_correo varchar(50) ,
	_contraseña varchar(50), 
	_fecha_nacimiento date, 
	_genero enum('F','M','N'), 
	_ciudad varchar(50), 
	_pais varchar(50) ,
	_avatar mediumblob ,
	_formato_avatar varchar(50) ,
	_portada mediumblob ,
	_formato_portada varchar(50) ,
	_perfil enum('Admin','Usuario') ,
	_fecha_registro timestamp
)
BEGIN
update usuario 
set 
	fecha_nacimiento = _fecha_nacimiento, 
	genero = _genero,
	ciudad = _ciudad, 
	pais = _pais,
	avatar = _avatar,
	formato_avatar = _formato_avatar,
	portada = _portada,
	formato_portada = _formato_portada,
	perfil = _perfil,
	fecha_registro = _fecha_registro
where id_usuario = _id_usuario;
END