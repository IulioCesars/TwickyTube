drop procedure if exists ObtenerVideosRecientes;
delimiter $%
CREATE PROCEDURE `ObtenerVideosRecientes`(
	in top int
)
BEGIN
	select * from video 
    where id_video > 0
    order by fecha desc limit top;
END
$%