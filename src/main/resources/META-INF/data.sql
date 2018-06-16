

insert into proyecto (estado,fechaInicio,fechaPresentacion,montoAprobado,montoRestante,nombre,perfilduracion,tiempovigencia,tipofinanciamiento) values('1','2018-06-05','2019-06-06',34,56,'edeher','34','45','ex')
insert into proyecto (estado,fechaInicio,fechaPresentacion,montoAprobado,montoRestante,nombre,perfilduracion,tiempovigencia,tipofinanciamiento) values('1','2018-06-05','2019-06-06',34,56,'rossetti','34','45','ex')
insert into proyecto (estado,fechaInicio,fechaPresentacion,montoAprobado,montoRestante,nombre,perfilduracion,tiempovigencia,tipofinanciamiento) values('1','2018-06-05','2019-06-06',34,56,'dekinha','34','45','ex')

insert into objetivo (estado,descripcion,idProyecto) values('in','objetivo 1',1)
insert into objetivo (estado,descripcion,idProyecto) values('in','objetivo 2',2)
insert into objetivo (estado,descripcion,idProyecto) values('in','objetivo 3',3)

insert into componente (estado,nombre,idObjetivo) values('in','componente 1',1)
insert into componente (estado,nombre,idObjetivo) values('in','componente 2',2)
insert into componente (estado,nombre,idObjetivo) values('in','componente 3',3)

insert into actividad (estado,nombre,idComponente) values('in','acctividad 1',1)
insert into actividad (estado,nombre,idComponente) values('in','acctividad 2',2)
insert into actividad (estado,nombre,idComponente) values('in','acctividad 3',3)


insert into autor(apellidos,categoria,direccion,email, escuela,estado,facultad,nombres,sexo,telefono) values ('1apellido 1','1categoria 1','1direcion 1','1email 1','e1','1','f1','1nombres 1','M','1telefono 1')
insert into autor(apellidos,categoria,direccion,email, escuela,estado,facultad,nombres,sexo,telefono) values ('2apellido 2','2categoria 2','2direcion 2','2email 2','e2','1','f1','2nombres 2','M','2telefono 2')
insert into autor(apellidos,categoria,direccion,email, escuela,estado,facultad,nombres,sexo,telefono) values ('3apellido 3','3categoria 3','3direcion 3','3email 3','e1','1','f2','3nombres 3','M','3telefono 3')


insert into fuente(descripcion) values ('1fuente 1')
insert into fuente(descripcion) values ('2fuente 2')
insert into fuente(descripcion) values ('3fuente 3')
