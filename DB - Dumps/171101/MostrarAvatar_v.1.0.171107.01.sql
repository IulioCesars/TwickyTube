CREATE PROCEDURE `MostrarAvatar`(
	IN idUsuario varchar(50)
)
BEGIN
	select avatar, formato_avatar from usuario where id_usuario = idUsuario;
END