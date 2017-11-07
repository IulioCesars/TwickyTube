DROP PROCEDURE IF EXISTS CrearUsuario;
delimiter //
CREATE PROCEDURE CrearUsuario(
	IN _id_usuario VARCHAR(50),
	IN _correo VARCHAR(50),
	IN _contraseña VARCHAR(50),
	IN _fecha_nacimiento DATE,
	IN _genero ENUM('M','F'),
    IN _ciudad varchar(50),
    in _pais varchar(50),	
	IN _avatar mediumblob,
	IN _portada mediumblob
)
BEGIN
if(!fn_validarCorreo(_correo) or !fn_ValidarAlias(_id_usuario)) then
	/*Faltan Validaciones */
	INSERT INTO usuario(
				id_usuario, 
				correo, 
				contraseña, 
				fecha_nacimiento, 
				genero, 
                ciudad,
                pais,
				avatar, 
				portada)
		VALUES(
				_id_usuario, 
				_correo, 
				_contraseña, 
				_fecha_nacimiento, 
				_genero, 
                _ciudad,
                _pais,
				_avatar, 
				_portada
		);
        if row_count() > 0 then	select 'OK' as result;
		else 					select 'ERROR 01' as result;
        end if;
        else
			select 'ERROR 02' as result;
	end if;
END;
//
delimiter ;