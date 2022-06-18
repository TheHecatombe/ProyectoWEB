CREATE TABLE Cliente(
    idCliente int auto_increment primary key,
    nombreCliente varchar(50) not null,
    paternoCliente varchar(50) not null,
    maternoCliente varchar(50) not null,
    telefono varchar(10) not null
);

CREATE TABLE Procucto(
    idProducto int primary key auto_increment,
    nombreProducto varchar(50) not null,
    descripcionProducto varchar(150) not null,
    precioProducto double not null,
    stockProducto int not null
);

CREATE TABLE Usuario(
    idUsuario int primary key auto_increment,
    username varchar(30) not null,
    password varchar(50) not null,
    nombreUsuario varchar(50) not null,
    paternoUsuario varchar(50) not null,
    maternoUsuario varchar(50) not null,
    tipoUsuario varchar(20) not null
);

CREATE TABLE Servicio(
    idServicio int primary key auto_increment,
    precioServicio double not null,
    fechaServicio date not null,
    idCliente int not null,
    idUsuario int not null,
    foreign key (idCliente) references Cliente(idCliente),
    foreign key (idUsuario) references Usuario(idUsuario)
);

CREATE TABLE Venta(
    idVenta int primary key auto_increment,
    fechaVenta date not null,
    idUsuario int not null,
    foreign key (idUsuario) references Usuario(idUsuario) on update cascade on delete cascade
);

CREATE TABLE VentaProducto(
    idVenta int not null,
    idProducto int not null,
    primary key (idVenta, idProducto),
    foreign key (idVenta) references Venta(idVenta) on delete cascade on update cascade,
    foreign key (idProducto) references Procucto(idProducto) on delete cascade on update cascade
);