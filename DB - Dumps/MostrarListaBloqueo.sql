-- SELECT * FROM DB_TWICKYTUBE.bloqueo;
-- alter table bloqueo add column bloqueado boolean default false;
drop procedure if exists MostrarListaBloqueo;
delimiter %&
create procedure MostrarListaBloqueo (U_orden varchar(10), U_limite1 int, U_limite2 int, U_campo varchar(100))
begin
	case U_orden 
		when 'ASC' then
			select * from vBloqueados 
			where fechaBloqueo <> 'No bloqueado'
			order by
				case when U_campo = 'fechaReporte'			then fechaReporte end asc,
				case when U_campo = 'Fecha de bloqueo' 		then fechaBloqueo end asc,
				case when U_campo = 'descripcionTipoPost'	then descripcionTipoPost end asc,
				case when U_campo = 'Usuario'				then fk_usuario end asc,
				case when U_campo = 'Normal'				then id_bloqueo end asc
			limit U_limite1, U_limite2;
		when 'DESC' then
			select * from vBloqueados 
			where fechaBloqueo <> 'No bloqueado'
			order by
				case when U_campo = 'fechaReporte'			then fechaReporte end desc,
				case when U_campo = 'Fecha de bloqueo'		then fechaBloqueo end desc,
				case when U_campo = 'descripcionTipoPost'	then descripcionTipoPost end desc,
				case when U_campo = 'Usuario'				then fk_usuario end desc,
				case when U_campo = 'Normal'				then id_bloqueo end desc
			limit U_limite1, U_limite2;
		end case;
end
%&