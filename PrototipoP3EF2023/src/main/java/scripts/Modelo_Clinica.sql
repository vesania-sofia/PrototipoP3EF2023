/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 * Author:  Sofi
 * Created: 9/06/2023
 */
create database if not exists LabClinico;
Use LabClinico;
#--------------------------------------
create table if not exists tbl_login(
	pk_idUser 	int not null,
    usuario 	varchar(45),
    contraseña 	varchar(45),
    estado		int
);

create table if not exists tbl_empleados(
	pk_idEmpleado 	int not null,#PK
    Nombre			varchar(20),
    Apellido		varchar(20),
    Telefono		int,
    DPI				int,
    Direccion		varchar(50),
    FechaNacimiento	date,
    fk_idUser		int	#FK
);

create table if not exists tbl_bitacora(
	pk_RegistroB	int not null, #PK
    fk_idUser		int,#FK
    regIngreso		datetime
);

create table if not exists tbl_movBitacora(
	pk_Registro		int not null,
    fk_RegistroB	int not null,
    fk_idEncabezado	int
);

#-------LLaves Primarias---------------
alter table tbl_login add primary key(pk_idUser);
alter table tbl_empleados add primary key(pk_idEmpleado);
alter table tbl_bitacora add primary key(pk_RegistroB);
alter table tbl_movBitacora add primary key(pk_registro);

#------Relaciones Llaves Foraneas---------
alter table tbl_empleados add constraint fk_user_emple foreign key(fk_idUser) references tbl_login (pk_idUser);
alter table tbl_bitacora add constraint fk_bita_user foreign key(fk_idUser) references tbl_login (pk_idUser);
alter table tbl_movBitacora add constraint fk_movB_Bita foreign key(fk_RegistroB) references tbl_bitacora (pk_RegistroB);
#------------------------------------------------------
create table if not exists tbl_paciente(
	pk_idPaciente	int not null,
    nombrePaci		varchar(50),
    apellidoPaci	varchar(50),
    FechaNacimiento	date,
    Genero			int,
    direccionPAci	varchar(30),
    Telefono		int,
    estadoPaci		int,
    fk_idReferencia	int not null
);

create table if not exists tbl_referencias(
	pk_idReferencia	int not null,
    Descripcion		varchar(50)
);

Create table if not exists tbl_encabezadofactura(
	pk_idEncabezado	int not null,
    serieFactura	varchar(30),
    numFactura		int,
    fk_idPaciente	int,#fk
    fechaOrden		datetime,
    total			double,
    fk_idTipoPago	int
);

create table if not exists tbl_detallefactura(
	pk_idDetallefac	int not null,
    fk_idEncabezado	int,
    fk_idExamen		int,
    subtotal		double
);

create table if not exists tbl_examen(
	pk_idExamen		int not null,
    fk_codtipoExam	int,
    nombreExam		varchar(30),
    precio			double
);

create table if not exists tbl_pago(
	pk_idPago		int not null,
    tipoPago		varchar(50)
);
create table if not exists tbl_tipoexamen(
	pk_codtipoExam	int,
    nom_tipExam		varchar(35),
    descripcion		varchar(35)
);

#-----Llavez Primarias-----------------
alter table tbl_paciente add primary key (pk_idPaciente);
alter table tbl_referencias add primary key (pk_idReferencia);
alter table tbl_encabezadofactura add primary key(pk_idEncabezado);
alter table tbl_detallefactura add primary key(pk_idDetallefac);
alter table tbl_examen add primary key (pk_idExamen);
alter table tbl_pago add primary key (pk_idPago);
alter table tbl_tipoexamen add primary key (pk_codtipoExam);

#-----Llaves foraneas--------------
alter table tbl_paciente add constraint fk_paci_ref foreign key(fk_idReferencia) references tbl_referencias (pk_idReferencia);
alter table tbl_encabezadofactura add constraint fk_enf_paci foreign key (fk_idPaciente) references tbl_paciente (pk_idPaciente);
alter table tbl_encabezadofactura add constraint fk_enf_tpag foreign key (fk_idTipoPago) references tbl_pago (pk_idPago);
alter table tbl_detallefactura add constraint fk_dfac_efac foreign key (fk_idEncabezado) references tbl_encabezadofactura (pk_idEncabezado);
alter table tbl_detallefactura add constraint fk_dfac_exam foreign key (fk_idExamen) references tbl_examen (pk_idExamen);
alter table tbl_examen add constraint fk_exam_texam foreign key(fk_codtipoExam) references tbl_tipoexamen(pk_codtipoExam);

alter table tbl_movBitacora add constraint fk_mBita_efac foreign key (fk_idEncabezado) references tbl_encabezadofactura (pk_idEncabezado);
