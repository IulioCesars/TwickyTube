CREATE FUNCTION `fn_validarCorreo`(U_correoElectronico varchar(50)) RETURNS tinyint(1)
begin
	declare U_existeCorreo boolean;
    
    set U_existeCorreo = (exists(select correo from usuario where correo = U_correoElectronico));
    
    return U_existeCorreo;
end