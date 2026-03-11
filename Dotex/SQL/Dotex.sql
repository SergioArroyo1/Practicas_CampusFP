DROP TABLE Usuario, Categoria, Producto, Talla, Producto_Talla, Pedido, Detalle_Pedido, Pago;

-- =====================================
-- Tabla Usuario
-- =====================================

CREATE TABLE Usuario (
                         id_usuario SERIAL PRIMARY KEY,
                         nombre VARCHAR(100) NOT NULL,
                         apellidos VARCHAR(100) NOT NULL,
                         email VARCHAR(150) UNIQUE NOT NULL,
                         password VARCHAR(255) NOT NULL,
                         telefono VARCHAR(20),
                         direccion VARCHAR(255)
);

-- =====================================
-- Tabla Roles
-- =====================================

CREATE TABLE Roles (
                       id_rol SERIAL PRIMARY KEY,
                       nombre_rol VARCHAR(50) UNIQUE NOT NULL
);

-- =====================================
-- Tabla Intermedia Roles-Usuario
-- =====================================

CREATE TABLE Roles_Usuario (
                               id_roles_usuario SERIAL PRIMARY KEY,
                               id_usuario INT NOT NULL,
                               id_rol INT NOT NULL,

                               CONSTRAINT fk_roles_usuario_usuario
                                   FOREIGN KEY (id_usuario)
                                       REFERENCES Usuario(id_usuario)
                                       ON DELETE CASCADE,

                               CONSTRAINT fk_roles_usuario_rol
                                   FOREIGN KEY (id_rol)
                                       REFERENCES Roles(id_rol)
                                       ON DELETE CASCADE
);

-- =====================================
-- Tabla Categoria
-- =====================================

CREATE TABLE Categoria (
                           id_categoria SERIAL PRIMARY KEY,
                           nombre_categoria VARCHAR(50) NOT NULL
);

-- =====================================
-- Tabla Producto
-- =====================================

CREATE TABLE Producto (
                          id_producto SERIAL PRIMARY KEY,
                          nombre VARCHAR(150) NOT NULL,
                          tipo_prenda VARCHAR(50),
                          color VARCHAR(50),
                          precio DECIMAL(10,2) NOT NULL,
                          stock INT DEFAULT 0,
                          id_categoria INT NOT NULL,

                          CONSTRAINT fk_producto_categoria
                              FOREIGN KEY(id_categoria)
                                  REFERENCES Categoria(id_categoria)
                                  ON DELETE RESTRICT
);

-- =====================================
-- Tabla Talla
-- =====================================

CREATE TABLE Talla (
                       id_talla SERIAL PRIMARY KEY,
                       nombre VARCHAR(20) NOT NULL
);

-- =====================================
-- Tabla Producto_Talla
-- =====================================

CREATE TABLE Producto_Talla (
                                id_producto INT NOT NULL,
                                id_talla INT NOT NULL,
                                stock INT DEFAULT 0,

                                PRIMARY KEY(id_producto, id_talla),

                                CONSTRAINT fk_producto_talla_producto
                                    FOREIGN KEY(id_producto)
                                        REFERENCES Producto(id_producto)
                                        ON DELETE CASCADE,

                                CONSTRAINT fk_producto_talla_talla
                                    FOREIGN KEY(id_talla)
                                        REFERENCES Talla(id_talla)
                                        ON DELETE CASCADE
);

-- =====================================
-- Tabla Pedido
-- =====================================

CREATE TABLE Pedido (
                        id_pedido SERIAL PRIMARY KEY,
                        fecha DATE NOT NULL,
                        total DECIMAL(12,2) NOT NULL,
                        estado VARCHAR(50) NOT NULL,
                        id_usuario INT NOT NULL,

                        CONSTRAINT fk_pedido_usuario
                            FOREIGN KEY(id_usuario)
                                REFERENCES Usuario(id_usuario)
                                ON DELETE CASCADE
);

-- =====================================
-- Tabla Detalle Pedido
-- =====================================

CREATE TABLE Detalle_Pedido (
                                id_detalle SERIAL PRIMARY KEY,
                                cantidad INT NOT NULL,
                                precio_unitario DECIMAL(10,2) NOT NULL,
                                id_pedido INT NOT NULL,
                                id_producto INT NOT NULL,

                                CONSTRAINT fk_detalle_pedido
                                    FOREIGN KEY(id_pedido)
                                        REFERENCES Pedido(id_pedido)
                                        ON DELETE CASCADE,

                                CONSTRAINT fk_detalle_producto
                                    FOREIGN KEY(id_producto)
                                        REFERENCES Producto(id_producto)
                                        ON DELETE RESTRICT
);

-- =====================================
-- Tabla Pago
-- =====================================

CREATE TABLE Pago (
                      id_pago SERIAL PRIMARY KEY,
                      metodo_pago VARCHAR(50) NOT NULL,
                      fecha_pago DATE NOT NULL,
                      monto DECIMAL(12,2) NOT NULL,
                      estado VARCHAR(50) NOT NULL,
                      id_pedido INT NOT NULL,

                      CONSTRAINT fk_pago_pedido
                          FOREIGN KEY(id_pedido)
                              REFERENCES Pedido(id_pedido)
                              ON DELETE CASCADE
);

-- =============================================
-- DATOS DE PRUEBA
-- =============================================

-- ROLES
INSERT INTO Roles(nombre_rol) VALUES
                                  ('admin'),
                                  ('cliente');

-- USUARIOS
INSERT INTO Usuario(nombre,apellidos,email,password,telefono,direccion) VALUES
                                                                            ('Juan','Perez','juan@dotex.com','1234','600111111','Madrid'),
                                                                            ('Ana','Gomez','ana@dotex.com','1234','600222222','Barcelona'),
                                                                            ('Carlos','Lopez','carlos@dotex.com','1234','600333333','Valencia'),
                                                                            ('Maria','Sanchez','maria@dotex.com','1234','600444444','Sevilla');

-- ASIGNAR ROLES
INSERT INTO Roles_Usuario(id_usuario,id_rol) VALUES
                                                 (1,2),
                                                 (2,1),
                                                 (3,2),
                                                 (4,2);

-- CATEGORIAS
INSERT INTO Categoria(nombre_categoria) VALUES
                                            ('Proteccion Civil'),
                                            ('Tecnicos Emergencias'),
                                            ('Sanidad');

-- TALLAS ROPA
INSERT INTO Talla(nombre) VALUES
                              ('S'),('M'),('L'),('XL');

-- TALLAS CALZADO
INSERT INTO Talla(nombre) VALUES
                              ('36'),('37'),('38'),('39'),('40'),
                              ('41'),('42'),('43'),('44'),('45');

-- PRODUCTOS
INSERT INTO Producto(nombre,tipo_prenda,color,precio,stock,id_categoria) VALUES

                                                                             ('Chaqueta Proteccion Civil','Chaqueta','Rojo',50,100,1),
                                                                             ('Camiseta Proteccion Civil','Camiseta','Azul',20,120,1),
                                                                             ('Pantalon Proteccion Civil','Pantalon','Azul',30,90,1),
                                                                             ('Botas Proteccion Civil','Calzado','Negro',65,50,1),

                                                                             ('Chaqueta Tecnico Emergencias','Chaqueta','Naranja',55,100,2),
                                                                             ('Camiseta Tecnico Emergencias','Camiseta','Verde',22,110,2),
                                                                             ('Pantalon Tecnico Emergencias','Pantalon','Verde',32,95,2),
                                                                             ('Botas Tecnico Emergencias','Calzado','Negro',70,50,2),

                                                                             ('Parte superior Sanidad','Parte superior','Blanco',28,100,3),
                                                                             ('Pantalon Sanidad','Pantalon','Blanco',25,100,3),
                                                                             ('Crocs Sanidad','Calzado','Blanco',35,60,3);

-- STOCK POR TALLA (ejemplos)
INSERT INTO Producto_Talla VALUES
                               (1,1,20),(1,2,20),(1,3,20),(1,4,20),
                               (2,1,25),(2,2,25),(2,3,25),(2,4,25),
                               (3,1,20),(3,2,20),(3,3,20),(3,4,20),
                               (9,1,25),(9,2,25),(9,3,25),(9,4,25);

-- PEDIDOS
INSERT INTO Pedido(fecha,total,estado,id_usuario) VALUES
                                                      ('2026-03-01',70,'Enviado',1),
                                                      ('2026-03-02',55,'Pendiente',3),
                                                      ('2026-03-03',35,'Completado',4);

-- DETALLE PEDIDO
INSERT INTO Detalle_Pedido(cantidad,precio_unitario,id_pedido,id_producto) VALUES
                                                                               (1,50,1,1),
                                                                               (1,20,1,2),
                                                                               (1,55,2,5),
                                                                               (1,35,3,11);

-- PAGOS
INSERT INTO Pago(metodo_pago,fecha_pago,monto,estado,id_pedido) VALUES
                                                                    ('Tarjeta','2026-03-01',70,'Completado',1),
                                                                    ('Paypal','2026-03-02',55,'Pendiente',2),
                                                                    ('Tarjeta','2026-03-03',35,'Completado',3);

SELECT
    u.nombre,
    u.apellidos,
    r.nombre_rol
FROM Usuario u
         JOIN Roles_Usuario ru ON u.id_usuario = ru.id_usuario
         JOIN Roles r ON ru.id_rol = r.id_rol;

SELECT
    p.nombre,
    p.tipo_prenda,
    c.nombre_categoria
FROM Producto p
         JOIN Categoria c ON p.id_categoria = c.id_categoria;

SELECT
    p.nombre,
    t.nombre AS talla,
    pt.stock
FROM Producto_Talla pt
         JOIN Producto p ON pt.id_producto = p.id_producto
         JOIN Talla t ON pt.id_talla = t.id_talla;

SELECT
    ped.id_pedido,
    u.nombre,
    ped.fecha,
    ped.total,
    ped.estado
FROM Pedido ped
         JOIN Usuario u ON ped.id_usuario = u.id_usuario;

SELECT
    ped.id_pedido,
    p.nombre AS producto,
    dp.cantidad,
    dp.precio_unitario
FROM Detalle_Pedido dp
         JOIN Pedido ped ON dp.id_pedido = ped.id_pedido
         JOIN Producto p ON dp.id_producto = p.id_producto;

SELECT
    pago.id_pago,
    ped.id_pedido,
    pago.metodo_pago,
    pago.monto,
    pago.estado
FROM Pago pago
         JOIN Pedido ped ON pago.id_pedido = ped.id_pedido;


SELECT
    u.nombre AS cliente,
    c.nombre_categoria,
    p.nombre AS producto,
    dp.cantidad,
    ped.fecha,
    pago.metodo_pago
FROM Detalle_Pedido dp
         JOIN Pedido ped ON dp.id_pedido = ped.id_pedido
         JOIN Usuario u ON ped.id_usuario = u.id_usuario
         JOIN Producto p ON dp.id_producto = p.id_producto
         JOIN Categoria c ON p.id_categoria = c.id_categoria
         LEFT JOIN Pago pago ON ped.id_pedido = pago.id_pedido;