CREATE PROCEDURE `MostrarPortada`(
	in idUsuario varchar(50)
)
BEGIN
	select portada, formato_portada from usuario where id_usuario =  idUsuario;
END