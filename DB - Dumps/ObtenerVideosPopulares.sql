drop procedure if exists ObtenerVideosPopulares;
delimiter $%
CREATE DEFINER=`twickytube`@`%` PROCEDURE `ObtenerVideosPopulares`(
	in top int
)
BEGIN
	select * from video 
    where id_video > 0
    order by vistas desc limit top;
END
$%