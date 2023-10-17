-- Esta BBDD va a estar basada en el trabajo de H.P.Lovecraft
-- Call of Cthulhu
DROP DATABASE IF EXISTS Cthulhu;
CREATE DATABASE Cthulhu;
USE Cthulhu;

-- Esta tabla contiene a todos los mitos conocidos
CREATE TABLE Mythos (
Id int unsigned auto_increment primary key,
Nombre varchar(50),
Tipo enum('Primigenio', 'Dios Exterior', 'Monstruo'),
Genero enum('Masculino', 'Femenino', 'Otro'),
Origen varchar(50),
Bio varchar(1000),
Imagen varchar(60)
);
INSERT INTO Mythos VALUES 
(1, "Cthulhu", "Primigenio","Masculino","Vhoorl","",""),
(2, "Nyarlathotep", "Dios Exterior","Otro","Desconocido","",""),
(3, "Azathoth", "Dios Exterior","Otro","Corte de Azathoth","","");

