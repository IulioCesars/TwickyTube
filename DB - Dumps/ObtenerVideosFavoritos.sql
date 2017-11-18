drop procedure if exists ObtenerVideosFavoritos;
delimiter $%
CREATE PROCEDURE `ObtenerVideosFavoritos`(
	in usuario varchar(50),
    in top int
)
BEGIN
	select v.* from video v
		inner join favorito f on f.fk_video = v.id_video
		inner join usuario u on u.id_usuario = f.fk_usuario
	where u.id_usuario = usuario and v.id_video > 0
	order by fecha desc limit top;
END
$%