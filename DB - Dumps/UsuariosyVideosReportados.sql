-- show columns from bloqueo;
drop procedure if exists UsuariosyVideosReportados;
delimiter $%
create procedure UsuariosyVideosReportados (U_orden varchar(10), U_limite1 int, U_limite2 int, U_tipo varchar(100))
begin
	select 
		bl.fk_usuario, 
        tp.descripcion, 
		bl.comentarioReporte,
		bl.fk_video, 
        vid.pathVideo
	from bloqueo as bl
    inner join video as vid on vid.id_video = bl.fk_video
    inner join usuario as us on us.id_usuario = bl.fk_usuario
    inner join tipoPost as tp on tp.idTipoPost = bl.fk_tipoPost
    
    limit U_limite1, U_limite2
    ;
end;
