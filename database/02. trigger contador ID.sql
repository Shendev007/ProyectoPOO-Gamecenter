
USE gamecenter;

# --------------------
# TABLA DE CONTADORES
# --------------------

DROP TABLE IF EXISTS ContadorId;
CREATE TABLE ContadorId(
    tabla VARCHAR(30) NOT NULL PRIMARY KEY,
    ultimo_numero INT NOT NULL
) ENGINE = InnoDB;

INSERT INTO ContadorId(tabla, ultimo_numero) VALUES ('Cliente',0), ('TipoMaquina', 0), ('Maquina', 0), ('Alquiler', 0), 
('Equipo', 0), ('Torneo', 0), ('Inscripcion', 0), ('Partida', 0);

# ------------------------------
# TRIGGERS PARA GENERAR LOS IDS
# ------------------------------

DELIMITER @@

DROP TRIGGER IF EXISTS generar_id_cliente @@
CREATE TRIGGER generar_id_cliente
BEFORE INSERT ON Cliente
FOR EACH ROW
BEGIN
    UPDATE ContadorId
    SET ultimo_numero = LAST_INSERT_ID(ultimo_numero +1)
    Where tabla = 'Cliente';

    SET NEW.id_cliente = CONCAT('C', LPAD(LAST_INSERT_ID(),GREATEST(4, CHAR_LENGTH(LAST_INSERT_ID())),'0'));
END @@

DROP TRIGGER IF EXISTS generar_id_tipo @@
CREATE TRIGGER generar_id_tipo
BEFORE INSERT ON TipoMaquina
FOR EACH ROW
BEGIN
    UPDATE ContadorId
    SET ultimo_numero = LAST_INSERT_ID(ultimo_numero +1)
    Where tabla = 'TipoMaquina';

    SET NEW.id_tipo = CONCAT('TM', LPAD(LAST_INSERT_ID(),GREATEST(4, CHAR_LENGTH(LAST_INSERT_ID())),'0'));
END @@

DROP TRIGGER IF EXISTS generar_id_maquina @@
CREATE TRIGGER generar_id_maquina
BEFORE INSERT ON Maquina
FOR EACH ROW
BEGIN
    UPDATE ContadorId
    SET ultimo_numero = LAST_INSERT_ID(ultimo_numero +1)
    Where tabla = 'Maquina';

    SET NEW.id_maquina = CONCAT('M', LPAD(LAST_INSERT_ID(),GREATEST(4, CHAR_LENGTH(LAST_INSERT_ID())),'0'));
END @@

DROP TRIGGER IF EXISTS generar_id_alquiler @@
CREATE TRIGGER generar_id_alquiler
BEFORE INSERT ON Alquiler
FOR EACH ROW
BEGIN
    UPDATE ContadorId
    SET ultimo_numero = LAST_INSERT_ID(ultimo_numero +1)
    Where tabla = 'Alquiler';

    SET NEW.id_alquiler = CONCAT('A', LPAD(LAST_INSERT_ID(),GREATEST(4, CHAR_LENGTH(LAST_INSERT_ID())),'0'));
END @@

DROP TRIGGER IF EXISTS generar_id_equipo @@
CREATE TRIGGER generar_id_equipo
BEFORE INSERT ON Equipo
FOR EACH ROW
BEGIN
    UPDATE ContadorId
    SET ultimo_numero = LAST_INSERT_ID(ultimo_numero +1)
    Where tabla = 'Equipo';

    SET NEW.id_equipo = CONCAT('E', LPAD(LAST_INSERT_ID(),GREATEST(4, CHAR_LENGTH(LAST_INSERT_ID())),'0'));
END @@

DROP TRIGGER IF EXISTS generar_id_torneo @@
CREATE TRIGGER generar_id_torneo
BEFORE INSERT ON Torneo
FOR EACH ROW
BEGIN
    UPDATE ContadorId
    SET ultimo_numero = LAST_INSERT_ID(ultimo_numero +1)
    Where tabla = 'Torneo';

    SET NEW.id_torneo = CONCAT('T', LPAD(LAST_INSERT_ID(),GREATEST(4, CHAR_LENGTH(LAST_INSERT_ID())),'0'));
END @@

DROP TRIGGER IF EXISTS generar_id_inscripcion @@
CREATE TRIGGER generar_id_inscripcion
BEFORE INSERT ON Inscripcion
FOR EACH ROW
BEGIN
    UPDATE ContadorId
    SET ultimo_numero = LAST_INSERT_ID(ultimo_numero +1)
    Where tabla = 'Inscripcion';

    SET NEW.id_inscripcion = CONCAT('I', LPAD(LAST_INSERT_ID(),GREATEST(4, CHAR_LENGTH(LAST_INSERT_ID())),'0'));
END @@

DROP TRIGGER IF EXISTS generar_id_partida @@
CREATE TRIGGER generar_id_partida
BEFORE INSERT ON Partida
FOR EACH ROW
BEGIN
    UPDATE ContadorId
    SET ultimo_numero = LAST_INSERT_ID(ultimo_numero +1)
    Where tabla = 'Partida';

    SET NEW.id_partida = CONCAT('P', LPAD(LAST_INSERT_ID(),GREATEST(4, CHAR_LENGTH(LAST_INSERT_ID())),'0'));
END @@

DELIMITER ;

# --------------------------
# MOSTRAR TODOS LOS TRIGGERS
# --------------------------

SHOW TRIGGERS FROM gamecenter;