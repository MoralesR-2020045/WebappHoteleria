
-- Drop database if exists DBHoteleria;
Create database DBHoteleria;

Use DBHoteleria;

create table Huespedes(
	idHuesped int auto_increment,
    nit varchar(60) not null, 
    dpi int, 
	nombreDelHuesped varchar(60) not null,
	apellidoDelHuesped varchar(60) not null, 
    email varchar(160) not null,
    telefono varchar(10) not null,
	contraseña varchar(30) not null,
    primary key PK_Huespedes (idHuesped)
);

create table Servicio(
	idServicio int auto_increment,
	nombreServicio varchar(60) not null,
	PrecioServicio decimal(10,2) not null,
    primary key PK_Servicio (idServicio)
);

create table MetodoDePago(
	idMetodoPago int auto_increment,
	nombreDelMetodo varchar(60) not null,
	primary key PK_MetodoDePago (idMetodoPago)
);

select * from MetodoDePago;

create table Empleados(
	idEmpleado int auto_increment, 
	nombreEmpleado varchar(60) not null,
    apellidoEmpleado varchar(60) not null, 
    contraseña varchar(30) not null,
    primary key PK_Empleados (idEmpleado)
);

create table TipoDeHabitacion(
	idTipoDeHabitacion int auto_increment,
	nombreTipoDeHabitacion varchar(60) not null, 
	descripción text not null , 
	capacidad int not null, 
	tamañoEnMetrosCuadrados varchar(15) not null, 
	numeroDeCamas int  not null, 
	precioBase decimal(10,2) not null,
    primary key PK_TipoDeHabitacion (idTipoDeHabitacion)
);

create table Habitaciones(
	idHabitacion int auto_increment,
	numeroHabitacion varchar(15) not null,
	PrecioPorNoche decimal(10,2),
    idTipoDeHabitacion int,
    primary key PK_Habitaciones (idHabitacion),
    constraint FK_Habitaciones_TipoDeHabitaciones
    foreign key (idTipoDeHabitacion) references TipoDeHabitacion(idTipoDeHabitacion)
);

create table Reservaciones(
	idReserva int auto_increment, 
	fechaDeIngreso date not null,
	fechaDeEgreso date not null,
    estadoDeDisponibilidad boolean, 
	precioTotal decimal(10,2), 
	idHuesped int,
	idHabitacion int, 
	idServicio	int,
	primary key  PK_Reservaciones (idReserva),
    constraint FK_Reservaciones_Huespedes
    foreign key (idHuesped) references Huespedes(idHuesped),
    constraint FK_Reservaciones_Habitaciones
    foreign key (idHabitacion) references Habitaciones(idHabitacion),
    constraint FK_Reservaciones_Servicio
    foreign key (idServicio) references  Servicio(idServicio)
);

create table Pago(
	idPago int auto_increment,
	pagoDeReservacion decimal(10,2) not null, 
	fechaDePago date not null, 
    saldoRestante  decimal(10,2) not null, 
	idMetodoPago int not null, 
	idReserva  int not null, 
	primary key PK_Pago  (idPago),
    constraint FK_Pago_MetodoDePago 
    foreign key (idMetodoPago) references MetodoDePago(idMetodoPago),
    constraint FK_Pago_Reservaciones
    foreign key (idReserva) references Reservaciones(idReserva)
);