drop view if exists vBloqueados;
create view vBloqueados
as
select 
	bl.id_bloqueo,
	bl.fk_usuario,
	ifnull(vid.pathVideo, '') as pathVideo,
	ifnull(tp.descripcion, '') as descripcionTipoPost,
	ifnull(rb.descripcion, '') as descripcionRazonBloqueo,
	ifnull(convert(bl.fechaReporte, date),'Sin reportar') as fechaReporte,
	ifnull(convert(bl.fechaBloqueo, date),'No bloqueado') as fechaBloqueo,
	(case bl.indefinido when 0 then 'NO' when 1 then 'INDEFININDO' end) as indefinido,
	ifnull(bl.comentarioReporte, '') as comentarioReporte,
	ifnull(bl.comentarioBloqueo, '') as comentarioBloqueo
from
	bloqueo as bl
inner join razonBloqueo as rb on bl.fk_RazonBloqueo = rb.idRazonBloqueo
inner join tipoPost as tp	on bl.fk_TipoPost = tp.idTipoPost
inner join video as vid on vid.id_video = bl.fk_video
;