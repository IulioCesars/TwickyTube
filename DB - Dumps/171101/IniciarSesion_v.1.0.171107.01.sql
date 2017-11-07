DROP PROCEDURE IF EXISTS IniciarSesion;
DELIMITER //
CREATE PROCEDURE `IniciarSesion`(IN _correo varchar(50),IN _contraseña varchar(50))
BEGIN

	SELECT id_usuario, 
			correo, 
            contraseña, 
            fecha_nacimiento, 
            genero,
            ciudad,
            pais,
            avatar, 
            portada, 
            perfil 
	FROM usuario
    WHERE correo = _correo
			and contraseña = _contraseña;
    

END;
