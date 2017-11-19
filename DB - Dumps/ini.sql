drop procedure if exists IniciarSesion;
delimiter $%
CREATE PROCEDURE IniciarSesion(IN _correo varchar(50),IN _contraseña varchar(50))
begin
declare U_contrasenia varchar(50);
				set U_contrasenia = (SHA(_contraseña));
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
						and contraseña = U_contrasenia;
end;