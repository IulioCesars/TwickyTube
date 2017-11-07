CREATE FUNCTION `fn_validarAlias`(U_alias varchar(50)) RETURNS tinyint(1)
begin
	declare U_existe boolean;
    
    set U_existe = (exists(select id_usuario from usuario where id_usuario = U_alias));
    
    return U_existe;
end