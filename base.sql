drop database Virtual_Baby;
create database if not exists Virtual_Baby;
use Virtual_Baby;

create table Usuario(
  idUsuario varchar(5) primary key,
  nombreUsuario varchar(25) not null,
  ap_paterno varchar(10) not null,
  ap_materno varchar(10) not null,
  email varchar(30),
  telefono varchar(10) not null, 
  password varchar(15) not null,
  tipo varchar(14) not null
);

create table Grupo(
  idGrupo varchar(5) primary key,
  idProfesor varchar(5) not null,
  constraint fk_grupoProfesor foreign key (idProfesor) references Usuario(idUsuario)
);

create table Niño (
  idNiño varchar(5) primary key,
  fechaNacimiento varchar(10) not null,
  nombreNiño varchar(25) not null,
  ap_paterno varchar(10) not null,
  ap_materno varchar(10) not null,
  idTutor varchar(5),
  grupo varchar(5) not null,
  constraint fk_niñoGrupo foreign key (grupo) references Grupo(idGrupo),
  constraint fk_niñoTutor foreign key (idTutor) references Usuario(idUsuario)
);

CREATE TABLE Reporte (
    idReporte VARCHAR(6) PRIMARY KEY,
    idNiño VARCHAR(5) NOT NULL,
    fecha varchar(10) NOT NULL,
    obsGenerales VARCHAR(280),
    CONSTRAINT fk_reporteNiño FOREIGN KEY (idNiño) REFERENCES Niño(idNIño)
);

CREATE TABLE Baño (
    idBaño VARCHAR(6),
    hora varchar(5) NOT NULL,
    tipo CHAR(1) NOT NULL,
    idReporte VARCHAR(6),
    obsBaño VARCHAR(280),
    CONSTRAINT baño_fk FOREIGN KEY (idReporte) REFERENCES Reporte(idReporte),
    CONSTRAINT baño_pk PRIMARY KEY (idBaño, idReporte),
    CONSTRAINT chk_baño_pk CHECK (tipo = 'Pipi' OR tipo = 'Popo' OR tipo = 'No aplica')
);

CREATE TABLE Sueño (
    idSueño VARCHAR(6),
    horaInicio varchar(10),
    horaFin varchar(10),
    obsSueño VARCHAR(280),
    idReporte VARCHAR(6),
    CONSTRAINT sueño_fk FOREIGN KEY (idReporte) REFERENCES Reporte(idReporte),
    CONSTRAINT sueño_pk PRIMARY KEY (idSueño, idReporte)
);

CREATE TABLE Comida (
    idComida VARCHAR(8),
    cantidad VARCHAR(15) NOT NULL,
    hora varchar(10) NOT NULL,
    idReporte VARCHAR(6) NOT NULL,
    obsComida VARCHAR(280),
    nombreComida VARCHAR(70),
	CONSTRAINT comida_pk PRIMARY KEY (idComida, idReporte),
    CONSTRAINT comida_fk_Reporte FOREIGN KEY (idReporte) REFERENCES Reporte(idReporte),
    CONSTRAINT chk_comida CHECK (cantidad = 'Comió todo' OR cantidad = 'Comió a medias' OR cantidad = 'No comió nada')
);

CREATE TABLE Administrador (
    idAdmin VARCHAR(6) PRIMARY KEY,
    contraseña VARCHAR(10) NOT NULL
);

-- Tabla usuario
INSERT INTO Usuario (idUsuario, nombreUsuario, ap_paterno, ap_materno, email, telefono, password, tipo)
VALUES ('U0001', 'Maria', 'Rodriguez', 'Garcia', 'maria.rodriguez@mail.com', '5551234567', 'contraseña1', 'Tutor'),
('U0002', 'Juan', 'Lopez', 'Perez', 'juan.lopez@mail.com', '5559876543', 'contraseña2', 'Tutor'),
('U0003', 'Ana', 'Garcia', 'Hernandez', 'ana.garcia@mail.com', '5555555555', 'contraseña3', 'Tutor'),
('U0004', 'Pedro', 'Martinez', 'Lopez', 'pedro.martinez@mail.com', '5551112233', 'contraseña4', 'Tutor'),
('U0005', 'Carmen', 'Gutierrez', 'Perez', 'carmen.gutierrez@mail.com', '5554443322', 'contraseña5', 'Tutor'),
('U0006', 'Carlos', 'Gonzalez', 'Sanchez', 'carlos.gonzalez@mail.com', '5551237890', 'contraseña6', 'Tutor'),
('U0007', 'Luisa', 'Perez', 'Hernandez', 'luisa.perez@mail.com', '5555678901', 'contraseña7', 'Tutor'),
('U0008', 'Fernando', 'Ramirez', 'Garcia', 'fernando.ramirez@mail.com', '5557778889', 'contraseña8', 'Tutor'),
('U0009', 'Maria', 'Gonzalez', 'Sanchez', 'maria.gonzalez@mail.com', '5552221111', 'contraseña9', 'Tutor'),
('U0010', 'Javier', 'Diaz', 'Perez', 'javier.diaz@mail.com', '5557776666', 'contraseña10', 'Tutor');


-- Insertar profesor en grupo 1
INSERT INTO Usuario (idUsuario, nombreUsuario, ap_paterno, ap_materno, email, telefono, password, tipo) VALUES ('P001', 'Juan', 'Lopez', 'Garcia', 'juan.lopez@gmail.com', '1234567890', 'pass123', 'Profesor');
INSERT INTO Grupo (idGrupo, idProfesor) VALUES ('G001', 'P001');
    
-- Insertar profesor en grupo 2
INSERT INTO Usuario (idUsuario, nombreUsuario, ap_paterno, ap_materno, email, telefono, password, tipo) VALUES ('P002', 'Maria', 'Hernandez', 'Perez', 'maria.hernandez@gmail.com', '0987654321', '123456', 'Profesor');
INSERT INTO Grupo (idGrupo, idProfesor) VALUES ('G002', 'P002');
    
-- Insertar profesor en grupo 3
INSERT INTO Usuario (idUsuario, nombreUsuario, ap_paterno, ap_materno, email, telefono, password, tipo) VALUES ('P003', 'Pedro', 'Gonzalez', 'Rios', 'pedro.gonzalez@gmail.com', '55555555', 'abc123', 'Profesor');
INSERT INTO Grupo (idGrupo, idProfesor) VALUES ('G003', 'P003');


-- Tabla niños
INSERT INTO Niño VALUES ('N0001', '2022-12-02', 'Pedro', 'Lopez', 'Garcia', 'U0001', 'G001');
INSERT INTO Niño VALUES ('N0002', '2022-12-24', 'Maria', 'Perez', 'Gonzalez', 'U0002', 'G001');
INSERT INTO Niño VALUES ('N0003', '2022-05-25', 'Juan', 'Rodriguez', 'Sanchez', 'U0003', 'G001');
INSERT INTO Niño VALUES ('N0004', '2021-05-20', 'Carla', 'Fernandez', 'Gutierrez', 'U0004', 'G002');
INSERT INTO Niño VALUES ('N0005', '2021-11-17', 'Jorge', 'Gomez', 'Mendez', 'U0005', 'G002');
INSERT INTO Niño VALUES ('N0006', '2022-01-10', 'Lucia', 'Hernandez', 'Flores', 'U0006', 'G002');
INSERT INTO Niño VALUES ('N0007', '2019-02-28', 'Diego', 'Ruiz', 'Navarro', 'U0007', 'G002');
INSERT INTO Niño VALUES ('N0008', '2018-09-05', 'Laura', 'Diaz', 'Romero', 'U0008', 'G002');
INSERT INTO Niño VALUES ('N0009', '2017-10-10', 'Miguel', 'Sanchez', 'Garcia', 'U0009', 'G002');
INSERT INTO Niño VALUES ('N0010', '2020-12-25', 'Ana', 'Torres', 'Lopez', 'U0010', 'G002');

-- Tabla de reportes
INSERT INTO Reporte (idReporte, idNiño, fecha, obsGenerales) VALUES
('R00001', 'N0001', '2023-03-02', 'El bebé estuvo un poco inquieto durante el día.'),
('R00002', 'N0002', '2023-03-02', 'El bebé lloró bastante cuando llegó, pero se tranquilizó después.'),
('R00003', 'N0003', '2023-03-02', 'El bebé estuvo muy tranquilo durante el día (:'),
('R00004', 'N0004', '2023-03-02', 'El niño estuvo un poco cansado hoy y se mostró un poco irritable.'),
('R00005', 'N0005', '2023-03-02', 'El niño participó activamente en todas las actividades hoy.'),
('R00006', 'N0006', '2023-03-02', 'El niño estuvo concentrado y participativo en las actividades hoy.'),
 ('R00007', 'N0007', '2023-03-02', 'El niño se mostró un poco tímido hoy pero se integró bien a las actividades.'),
('R00008', 'N0008', '2023-03-02', 'El niño estuvo un poco distraído hoy durante las actividades.'),
('R00009', 'N0009', '2023-03-02', 'El niño estuvo muy activo hoy y participó en todas las actividades.'),
('R00010', 'N0010', '2023-03-02', 'El niño estuvo concentrado en las actividades de matemáticas hoy.'),
('R00011', 'N0001', '2023-03-03', 'El bebé lloró mucho después de desprenderlo de los brazos de su tutor.'),
('R00012', 'N0002', '2023-03-03', 'El bebé tuvo un cambio de pañal y no presentó novedades.'),
('R00013', 'N0003', '2023-03-03', 'El bebé presentó un poco de congestión nasal, se le aplicaron gotas y mejoró su respiración.'),
('R00014', 'N0004', '2023-03-03', 'El niño estuvo jugando con bloques por la mañana.'),
('R00015', 'N0005', '2023-03-03', 'El niño se mostró un poco irritable durante la actividad física.'),
('R00016', 'N0006', '2023-03-03', 'El niño disfrutó de un juego de pelota en el patio.'),
('R00017', 'N0007', '2023-03-03', 'Hoy el niño estuvo muy participativo en las actividades grupales.'),
('R00018', 'N0008', '2023-03-03', 'El niño se mostró un poco tímido al principio, pero luego se integró bien.'),
('R00019', 'N0009', '2023-03-03', 'El niño tuvo un poco de tos por la mañana.'),
('R00020', 'N0010', '2023-03-03', 'El niño se divirtió mucho jugando con sus amigos en el parque.');


-- Tabla comidas
INSERT INTO Comida (idReporte, cantidad, nombreComida, hora, idComida, obsComida) 
VALUES ('R00001', 'Comió todo', 'Avena y leche en fórmula', '08:00', 'C0000001', 'Sin observaciones'),
('R00002', 'Comió a medias', 'Avena y leche en fórmula', '08:00', 'C0000002', 'No quiso la avena'),
('R00003', 'Comió todo', 'Avena y leche en fórmula', '08:00', 'C0000003', 'Sin observaciones'),
('R00004', 'Comió todo', 'Avena con plátano y leche', '08:00', 'C0000004', 'Sin observaciones'),
('R00005', 'Comió todo', 'Avena con plátano y leche', '08:00', 'C0000005', 'Sin observaciones'),
('R00006', 'Comió todo', 'Avena con plátano y leche', '08:00', 'C0000006', 'Sin observaciones'),
('R00007', 'Comió todo', 'Arroz con leche, pan y fruta', '08:00', 'C0000007', 'Sin observaciones'),
('R00008', 'Comió todo', 'Arroz con leche, pan y fruta', '08:00', 'C0000008', 'Sin observaciones'),
('R00009', 'Comió todo', 'Arroz con leche, pan y fruta', '08:00', 'C0000009', 'Sin observaciones'),
('R00010', 'Comió todo', 'Arroz con leche, pan y fruta', '08:00', 'C0000010', 'Sin observaciones'),
('R00001', 'Comió todo', 'Puré de zanahoria', '12:00', 'C0000011', 'Sin observaciones'),
('R00002', 'Comió todo', 'Puré de zanahoria', '12:00', 'C0000012', 'Sin observaciones'),
('R00003', 'Comió todo', 'Puré de zanahoria', '12:00', 'C0000013', 'Sin observaciones'),
('R00004', 'Comió todo', 'Pollo con arroz y zanahoria', '12:00', 'C0000014', 'Sin observaciones'),
('R00005', 'Comió todo', 'Pollo con arroz y zanahoria', '12:00', 'C0000015', 'Sin observaciones'),
('R00006', 'Comió todo', 'Pollo con arroz y zanahoria', '12:00', 'C0000016', 'Sin observaciones'),
('R00007', 'Comió todo', 'Pescado y ensalada rusa', '12:00', 'C0000017', 'Sin observaciones'),
('R00008', 'Comió todo', 'Pescado y ensalada rusa', '12:00', 'C0000018', 'Sin observaciones'),
('R00009', 'Comió todo', 'Pescado y ensalada rusa', '12:00', 'C0000019', 'Sin observaciones'),
('R00010', 'Comió todo', 'Pescado y ensalada rusa', '12:00', 'C0000020', 'Sin observaciones'),
('R00001', 'Comió todo', 'Jugo de manzana y pera', '15:00', 'C0000021', 'Sin observaciones'),
('R00002', 'Comió a medias', 'Jugo de manzana y pera', '15:00', 'C0000022', 'No se acabó la pera'),
('R00003', 'Comió todo', 'Jugo de manzana y pera', '15:00', 'C0000023', 'Sin observaciones'),
('R00004', 'No comió nada', 'Sopa de verduras con huevo', '15:00', 'C0000024', 'Comentó que no le gustaba la comida'),
('R00005', 'Comió todo', 'Sopa de verduras con huevo', '15:00', 'C0000025', 'Sin observaciones'),
('R00006', 'Comió a medias', 'Sopa de verduras con huevo', '15:00', 'C0000026', 'Sin observaciones'),
('R00007', 'Comió todo', 'Sándwich y melón', '15:00', 'C0000027', 'Sin observaciones'),
('R00008', 'No comió nada', 'Sándwich y melón', '15:00', 'C0000028', 'Comentó que estaba satisfecho'),
('R00009', 'Comió todo', 'Sándwich y melón', '15:00', 'C0000029', 'Sin observaciones'),
('R00010', 'Comió a medias', 'Sándwich y melón', '15:00', 'C0000030', 'No le gustó que tuviera jitomate el sándwich'),
-- -----------------------------------------
('R00011', 'Comió todo', 'Cereal de arroz y leche en fórmula', '08:00', 'C0000031', 'Sin observaciones'),
('R00012', 'No comió nada', 'Cereal de arroz y leche en fórmula', '08:00', 'C0000032', 'Lloró y evitó toda la comida'),
('R00013', 'No comió nada', 'Cereal de arroz y leche en fórmula', '08:00', 'C0000033', 'No permitió que se le diera de comer'),
('R00014', 'Comió todo', 'Cereal con leche y plátano', '08:00', 'C0000034', 'Sin observaciones'),
('R00015', 'Comió a medias', 'Cereal con leche y plátano', '08:00', 'C0000035', 'Dejó la mitad del cereal'),
('R00016', 'No comió nada', 'Cereal con leche y plátano', '08:00', 'C0000036', 'Comentó que sentía inflamado el estómago, por lo que acudió al médico'),
('R00017', 'No comió nada', 'Cuernito y te de canela', '08:00', 'C0000037', 'Comentó que no le gustaba la comida'),
('R00018', 'Comió todo', 'Cuernito y te de canela', '08:00', 'C0000038', 'Sin observaciones'),
('R00019', 'Comió a medias', 'Cuernito y te de canela', '08:00', 'C0000039', 'Sin observaciones'),
('R00020', 'No comió nada', 'Cuernito y te de canela', '08:00', 'C0000040', 'Se enojó porque no era la cantidad que él quería y se rehusó a comer'),
('R00011', 'Comió a medias', 'Puré de espinaca', '12:00', 'C0000041', 'Dejó la mitad del puré'),
('R00012', 'Comió todo', 'Puré de espinaca', '12:00', 'C0000042', 'Sin observaciones'),
('R00013', 'Comió a medias', 'Puré de espinaca', '12:00', 'C0000043', 'Comentó que no le gusta la lechuga'),
('R00014', 'Comió todo', 'Pescado con arroz y ensalada', '12:00', 'C0000044', 'Sin observaciones'),
('R00015', 'No comió nada', 'Pescado con arroz y ensalada', '12:00', 'C0000045', 'Comentó que no le gusta la combinación'),
('R00016', 'Comió a medias', 'Pescado con arroz y ensalada', '12:00', 'C0000046', 'Comentó que no le gustó el pescado'),
('R00017', 'Comió a medias', 'Croquetas de papa y agua de limón', '12:00', 'C0000047', 'Dejó una croqueta'),
('R00018', 'Comió todo', 'Croquetas de papa y agua de limón', '12:00', 'C0000048', 'Sin observaciones'),
('R00019', 'No comió nada', 'Croquetas de papa y agua de limón', '12:00', 'C0000049', 'Comentó que se sentía satisfecho'),
('R00020', 'Comió a medias', 'Croquetas de papa y agua de limón', '12:00', 'C0000050', 'Comentó que no le gustó del todo la comida'),
('R00011', 'Comió todo', 'Jugo de naranja y manzana', '15:00', 'C0000051', 'Sin observaciones'),
('R00012', 'Comió a medias', 'Jugo de naranja y manzana', '15:00', 'C0000052', 'No le gusta la manzana'),
('R00013', 'Comió a medias', 'Jugo de naranja y manzana', '15:00', 'C0000053', 'No le gustó mucho el jugo de naranja'),
('R00014', 'Comió todo', 'Sopa de pollo con vegetales', '15:00', 'C0000054', 'Sin observaciones'),
('R00015', 'Comió a medias', 'Sopa de pollo con vegetales', '15:00', 'C0000055', 'No le gustan las verduras'),
('R00016', 'Comió todo', 'Sopa de pollo con vegetales', '15:00', 'C0000056', 'Sin observaciones'),
('R00017', 'Comió a medias', 'Gelatina, leche y pan tostado', '15:00', 'C0000057', 'Dejó el pan tostado'),
('R00018', 'Comió todo', 'Gelatina, leche y pan tostado', '15:00', 'C0000058', 'Sin observaciones'),
('R00019', 'Comió a medias', 'Gelatina, leche y pan tostado', '15:00', 'C0000059', 'No le gustó la gelatina'),
('R00020', 'Comió todo', 'Gelatina, leche y pan tostado', '15:00', 'C0000060', 'Sin observaciones');

-- Tabla Sueño
INSERT INTO Sueño (idSueño, horaInicio, horaFin, obsSueño, idReporte)
VALUES
('S00001', '09:00', '09:45', 'El niño durmió bien', 'R00001'),
('S00002', '09:00', '09:45', 'El niño durmió profundamente', 'R00013'),
('S00003', '09:15', '10:30', 'El niño se despertó varias veces durante la siesta', 'R00002'),
('S00004', '09:20', '10:00', 'El niño se durmió fácilmente', 'R00011'),
('S00005', '09:30', '10:00', 'El niño tuvo un sueño tranquilo', 'R00003'),
('S00006', '09:45', '10:30', 'El niño tuvo un sueño interrumpido', 'R00012');





