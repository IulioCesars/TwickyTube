drop procedure ObtenerVideosCanal;
delimiter $%
CREATE DEFINER=`twickytube`@`%` PROCEDURE `ObtenerVideosCanal`(
	in usuario varchar(50),
    in top int
)
BEGIN
	select * from video 
    where fk_usuario = usuario 
    and id_video > 0
    limit top;
END
$%