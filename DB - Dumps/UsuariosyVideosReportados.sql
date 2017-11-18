drop procedure if exists UsuariosyVideosReportados;
delimiter $%
create procedure UsuariosyVideosReportados (U_orden varchar(10), U_limite1 int, U_limite2 int, U_campo varchar(100))
begin
	case U_orden 
		when 'ASC' then
			select 
				bl.id_bloqueo,
				bl.fk_usuario, 
				tp.descripcion, 
				bl.comentarioReporte,
				bl.fk_video, 
				vid.pathVideo
			from bloqueo as bl
			inner join video as vid on vid.id_video = bl.fk_video
			inner join usuario as us on us.id_usuario = bl.fk_usuario
			inner join tipoPost as tp on tp.idTipoPost = bl.fk_tipoPost
            where !bl.bloqueado
			order by
				case when U_campo = 'Para todo publico'		then bl.fk_usuario end asc,
				case when U_campo = 'Para mayores de 13' 	then bl.fk_usuario end asc,
				case when U_campo = 'Para mayores de 15'	then bl.fk_usuario end asc,
				case when U_campo = 'Para mayores de 18'	then bl.fk_usuario end asc
			limit U_limite1, U_limite2;
        when 'DESC' then
			select 
				bl.id_bloqueo,
				bl.fk_usuario, 
				tp.descripcion, 
				bl.comentarioReporte,
				bl.fk_video, 
				vid.pathVideo
			from bloqueo as bl
			inner join video as vid on vid.id_video = bl.fk_video
			inner join usuario as us on us.id_usuario = bl.fk_usuario
			inner join tipoPost as tp on tp.idTipoPost = bl.fk_tipoPost
            where !bl.bloqueado
			order by
				case when U_campo = 'Para todo publico'		then bl.fk_usuario end desc,
				case when U_campo = 'Para mayores de 13' 	then bl.fk_usuario end desc,
				case when U_campo = 'Para mayores de 15'	then bl.fk_usuario end desc,
				case when U_campo = 'Para mayores de 18'	then bl.fk_usuario end desc
			limit U_limite1, U_limite2;
	end case;
end;
$%