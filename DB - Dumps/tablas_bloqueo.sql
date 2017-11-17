drop table if exists clasificacion;
drop table if exists tipoPost;
drop table if exists razonBloqueo;
drop table if exists bloqueo;

create table clasificacion
(
	idClasificacion 	int not null primary key auto_increment,
    descripcion			text
);
create table tipoPost
(
	idTipoPost			int not null primary key auto_increment,
    descripcion			text
);
create table razonBloqueo
(
	idRazonBloqueo 		int not null primary key auto_increment,
    descripcion			text
);
create table bloqueo
(
	id_bloqueo 			int not null primary key auto_increment,
    fk_usuario 			varchar(50) not null,
    fk_video 			int not null,
    fk_tipoPost 		int not null default 1,
    fechaReporte 		timestamp default current_timestamp,
    fechaBloqueo		date,
    indefinido			boolean default false,
    fk_razonBloqueo		int not null default 1,
    comentarioReporte	text,
    comentarioBloqueo	text,
    
    constraint bloqueo_usuario 	foreign key (fk_usuario) 			references usuario(id_usuario),
    constraint bloqueo_video	foreign key (fk_video)				references video(id_video),
    constraint bloqueo_tipoPost	foreign key (fk_tipoPost)			references tipoPost(idTipoPost),
    constraint bloqueo_razonBloqueo foreign key (fk_razonBloqueo) 	references razonBloqueo(idRazonBloqueo)
);

insert into clasificacion values (null, 'Para todo publico');
insert into clasificacion values (null, 'Para mayores de 13');
insert into clasificacion values (null, 'Para mayores de 15');
insert into clasificacion values (null, 'Para mayores de 18');
insert into tipoPost values (null, 'Video');
insert into tipoPost values (null, 'Comentario');
insert into razonBloqueo values (null, 'Marcado con clasificacion incorrecta');
insert into razonBloqueo values (null, 'Lenguaje no apropiado');
insert into razonBloqueo values (null, 'Demasiada sangre');
insert into razonBloqueo values (null, 'Contenido para adultos');

select * from usuario;
insert into bloqueo (fk_usuario, fk_video, comentarioReporte) values ('crz7733', 7, 'No me gusto');
insert into bloqueo (fk_usuario, fk_video, comentarioReporte) values ('DamianDinamita', 8, 'No me gusto');
insert into bloqueo (fk_usuario, fk_video, comentarioReporte) values ('DamianDinamita', 9, 'No me gusto');
insert into bloqueo (fk_usuario, fk_video, comentarioReporte) values ('Donald', 7, 'No me gusto');
insert into bloqueo (fk_usuario, fk_video, comentarioReporte) values ('El Peje', 8, 'No me gusto');
insert into bloqueo (fk_usuario, fk_video, comentarioReporte) values ('hola', 7, 'No me gusto');
insert into bloqueo (fk_usuario, fk_video, comentarioReporte) values ('IulioCesar', 8, 'No me gusto');
insert into bloqueo (fk_usuario, fk_video, comentarioReporte) values ('esteban.xdcs', 9, 'No me gusto');
insert into bloqueo (fk_usuario, fk_video, comentarioReporte) values ('esteban.xdcs', 9, 'No me gusto');
insert into bloqueo (fk_usuario, fk_video, comentarioReporte) values ('esteban.xdcs', 7, 'No me gusto');
insert into bloqueo (fk_usuario, fk_video, comentarioReporte) values ('esteban.xdcs', 7, 'No me gusto');
insert into bloqueo (fk_usuario, fk_video, comentarioReporte) values ('esteban.xdcs', 8, 'No me gusto');
insert into bloqueo (fk_usuario, fk_video, comentarioReporte) values ('esteban.xdcs', 7, 'No me gusto');
insert into bloqueo (fk_usuario, fk_video, comentarioReporte) values ('esteban.xdcs', 7, 'No me gusto');
