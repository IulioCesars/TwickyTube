use twickytube;
alter table video add column pathVideo varchar(100);
alter table video add column contentTypeVideo varchar(10);
alter table video add column pathVistaPrevia varchar(100);
alter table video add column contentTypeVistaPrevia varchar(10);

delimiter //
create procedure sp_publicar
(
	_titulo varchar(50), _descripcion varchar(50), clasificacion varchar(50), 
    _pathVideo varchar(100), 		_contentTypeVideo varchar(10), 
    _pathVistaPrevia varchar(100), 	_contentTypeVistaPrevia varchar(10)
)
begin
	insert into video (
    titulo, descripcion, clasificacion, pathVideo, contentTypeVideo, pathVistaPrevia, contentTypeVistaPrevia, fecha)
    values (
    _titulo, _descripcion, _clasificacion, _pathVideo, _contentTypeVideo, _pathVistaPrevia, _contentTypeVistaPrevia, now());
    
    if row_count() > 0 then select 'INSERTADO' as result; 
    else					select 'NO INSERTADO' as result;
    end if;
end;
delimiter ;