drop procedure if exists AdminReporta;
delimiter $&
create procedure AdminReporta(U_idBloqueo int, U_fk_razonBloqueo int, U_fechaBloqueo date, U_comentarioBloqueo text, U_indefinido boolean)
begin
	update bloqueo set 
		fechaBloqueo = U_fechaBloqueo,
        fk_razonBloqueo = U_fk_razonBloqueo,
		comentarioBloqueo = U_comentarioBloqueo,
        indefinido = U_indefinido,
        bloqueado = 1,
        fk_tipoPost = 3
	where id_bloqueo = U_idBloqueo
	;
    if row_count() > 0 then select 'ACTUALIZADO' as result;
    else 					select 'NO ACTUALIZADO' as result;
	end if;
end;
$&