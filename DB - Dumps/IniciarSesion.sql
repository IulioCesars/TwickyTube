drop procedure if exists IniciarSesion;
delimiter $%
CREATE PROCEDURE IniciarSesion(IN _correo varchar(50),IN _contraseña varchar(50))
begin
	declare U_fk_usuario varchar(50);
    declare U_UsuarioIndefinido boolean;
    declare U_UsuarioBloqueado boolean;
    set U_fk_usuario = (select id_usuario from usuario WHERE correo = _correo); 
    
    set U_UsuarioBloqueado = exists(select fk_usuario from bloqueo where fk_tipoPost = 3 and bloqueado = 1);
    
    if U_UsuarioBloqueado then
		begin
			
            set U_UsuarioIndefinido = exists(select * from bloqueo where fk_usuario = U_fk_usuario and indefinido = 1);
			if  U_UsuarioIndefinido then	select 'Bloqueado indefinidamente' as result;
            else	
				select concat('Has sido bloqueado temporalmente hasta: ', fechaBloqueo) as result
				from bloqueo where fk_usuario = U_fk_usuario and bloqueado = 1;
            end if;
		end;
        else 
			begin
				declare U_contrasenia varchar(50);
				set U_contrasenia = (SHA(_contraseña));
				SELECT 	'OK' as result,
						id_usuario, 
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
	end if;
	
end 
$%