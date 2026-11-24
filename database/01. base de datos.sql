
# -----------------------------
# CREACION DE LA BASE DE DATOS
# -----------------------------

DROP DATABASE IF EXISTS gamecenter;
CREATE DATABASE gamecenter;
USE gamecenter;

# -----------------------
# CREACION DE LAS TABLAS
# -----------------------

DROP TABLE IF EXISTS Cliente;
CREATE TABLE Cliente(
    id_cliente VARCHAR(10) NOT NULL PRIMARY KEY,
    dni CHAR(8) NOT NULL,
    nombre_cliente VARCHAR(120) NOT NULL,
    telefono CHAR(9) NULL,
    nametag VARCHAR(30) NULL,

    CONSTRAINT uq_cliente_dni UNIQUE(dni)
);

DROP TABLE IF EXISTS TipoMaquina;
CREATE TABLE TipoMaquina(
    id_tipo VARCHAR(10) NOT NULL PRIMARY KEY,
    nombre_tipo VARCHAR(20) NOT NULL,
    tarifa_hora DECIMAL(10,2) NOT NULL,

    CONSTRAINT uq_tipomaquina_nombre UNIQUE(nombre_tipo),
    CONSTRAINT chk_tipomaquina_tarifa CHECK(tarifa_hora>0)
);

DROP TABLE IF EXISTS Maquina;
CREATE TABLE Maquina(
    id_maquina VARCHAR(10) NOT NULL PRIMARY KEY,
    id_tipo VARCHAR(10) NOT NULL,
    nombre_maquina VARCHAR(50) NOT NULL,
    estado_maquina VARCHAR(20) NOT NULL DEFAULT 'Habilitada',

    CONSTRAINT fk_maquina_tipo FOREIGN KEY(id_tipo) REFERENCES TipoMaquina(id_tipo),
    CONSTRAINT chk_maquina_estado CHECK(estado_maquina IN('Habilitada', 'Mantenimiento', 'Retirada'))
);

DROP TABLE IF EXISTS Alquiler;
CREATE TABLE Alquiler(
    id_alquiler VARCHAR(10) NOT NULL PRIMARY KEY,
    id_cliente VARCHAR(10) NOT NULL,
    id_maquina VARCHAR(10) NOT NULL,
    fecha_hora_inicio DATETIME NOT NULL,
    duracion INT NOT NULL,
    importe_pagado DECIMAL(10,2) NOT NULL,
    estado_alquiler VARCHAR(10) NOT NULL DEFAULT 'Activo',

    CONSTRAINT fk_alquiler_cliente FOREIGN KEY(id_cliente) REFERENCES Cliente(id_cliente),
    CONSTRAINT fk_alquiler_maquina FOREIGN KEY(id_maquina) REFERENCES Maquina(id_maquina),
    CONSTRAINT chk_alquiler_duracion CHECK(duracion IN(30, 60, 120, 180, 240, 300, 360, 420, 480)),
    CONSTRAINT chk_alquiler_importe CHECK(importe_pagado>0),
    CONSTRAINT chk_alquiler_estado CHECK(estado_alquiler IN('Activo', 'Concluido'))
);

DROP TABLE IF EXISTS Equipo;
CREATE TABLE Equipo(
    id_equipo VARCHAR(10) NOT NULL PRIMARY KEY,
    nombre_equipo VARCHAR(60) NOT NULL
);

DROP TABLE IF EXISTS MiembroEquipo;
CREATE TABLE MiembroEquipo(
    id_equipo VARCHAR(10) NOT NULL,
    id_cliente VARCHAR(10) NOT NULL,

    CONSTRAINT pk_miembroequipo PRIMARY KEY (id_equipo, id_cliente),
    CONSTRAINT fk_miembroequipo_equipo FOREIGN KEY(id_equipo) REFERENCES Equipo(id_equipo),
    CONSTRAINT fk_miembroequipo_cliente FOREIGN KEY(id_cliente) REFERENCES Cliente(id_cliente)
);

DROP TABLE IF EXISTS Torneo;
CREATE TABLE Torneo(
    id_torneo VARCHAR(10) NOT NULL PRIMARY KEY,
    nombre_torneo VARCHAR(100) NOT NULL,
    fecha_inicio DATETIME NOT NULL,
    cupos INT NOT NULL,
    costo DECIMAL(10,2) NOT NULL,
    premio DECIMAL(10,2) NOT NULL,
    estado_torneo VARCHAR(25) NOT NULL DEFAULT 'Inscripciones abiertas',

    CONSTRAINT chk_torneo_cupos CHECK(cupos>=4 AND cupos IN(4, 8, 16)),
    CONSTRAINT chk_torneo_premio CHECK(premio>0),
    CONSTRAINT chk_torneo_estado CHECK(estado_torneo IN('Inscripciones abiertas', 'Preparado', 'En curso', 'Finalizado'))
);

DROP TABLE IF EXISTS Inscripcion;
CREATE TABLE Inscripcion(
    id_inscripcion VARCHAR(10) NOT NULL PRIMARY KEY,
    id_equipo VARCHAR(10) NOT NULL,
    id_torneo VARCHAR(10) NOT NULL,
    fecha_inscripcion DATETIME NOT NULL,
    importe_pagado DECIMAL(10,2) NOT NULL,

    CONSTRAINT fk_inscripcion_equipo FOREIGN KEY(id_equipo) REFERENCES Equipo(id_equipo),
    CONSTRAINT fk_inscripcion_torneo FOREIGN KEY(id_torneo) REFERENCES Torneo(id_torneo),
    CONSTRAINT uq_inscripcion_equipo_torneo UNIQUE(id_equipo, id_torneo),
    CONSTRAINT chk_inscripcion_importe CHECK(importe_pagado>0)
);

DROP TABLE IF EXISTS IntegranteInscripcion;
CREATE TABLE IntegranteInscripcion(
    id_inscripcion VARCHAR(10) NOT NULL,
    id_cliente VARCHAR(10) NOT NULL,

    CONSTRAINT pk_integranteinscripcion PRIMARY KEY(id_inscripcion, id_cliente),
    CONSTRAINT fk_integranteinscripcion_inscripcion FOREIGN KEY(id_inscripcion) REFERENCES Inscripcion(id_inscripcion),
    CONSTRAINT fk_integranteinscripcion_cliente FOREIGN KEY(id_cliente) REFERENCES Cliente(id_cliente)
);

DROP TABLE IF EXISTS Partida;
CREATE TABLE Partida(
    id_partida VARCHAR(10) NOT NULL PRIMARY KEY,
    id_torneo VARCHAR(10) NOT NULL,
    id_inscripcion_a VARCHAR(10) NULL,
    id_inscripcion_b VARCHAR(10) NULL,
    id_inscripcion_ganador VARCHAR(10) NULL,
    nro_partida INT NOT NULL,
    ronda INT NOT NULL,

    CONSTRAINT fk_partida_torneo FOREIGN KEY(id_torneo) REFERENCES Torneo(id_torneo),
    CONSTRAINT fk_partida_inscripcion_a FOREIGN KEY(id_inscripcion_a) REFERENCES Inscripcion(id_inscripcion),
    CONSTRAINT fk_partida_inscripcion_b FOREIGN KEY(id_inscripcion_b) REFERENCES Inscripcion(id_inscripcion),
    CONSTRAINT fk_partida_inscripcion_ganador FOREIGN KEY(id_inscripcion_ganador) REFERENCES Inscripcion(id_inscripcion),
    CONSTRAINT uq_partida_posicion UNIQUE (id_torneo, ronda, nro_partida),
    CONSTRAINT chk_partida_numero CHECK(nro_partida>0),
    CONSTRAINT chk_partida_ronda CHECK(ronda>0)
);

# ------------------------
# MOSTRAR TODAS LAS TABLAS
# ------------------------

SHOW TABLES FROM gamecenter;