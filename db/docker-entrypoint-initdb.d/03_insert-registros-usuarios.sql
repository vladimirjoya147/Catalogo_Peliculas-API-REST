INSERT INTO
    usuarios (
        nombre,
        apellidos,
        correo_electronico,
        nombre_usuario,
        contrasena,
        telefono
    )
VALUES
    (
        'Lysandra',
        'Martinez',
        'commodo.ipsum@outlook.ca',
        'lysandra1980',
        '$2y$10$JQI6KDNNJ6yl/gP1QyN8Ae1WLOzI/UF8HL7j5On5riHiZmDyxkOTG',
        '31098764567'
    ),
    (
        'Kirk',
        'Morrison',
        'mollis.phasellus@hotmail.ca',
        'morrison2000',
        '$2y$10$ngpSPW9X8cqpG6iJe9RzwuiYUKo1R/CxwdlbodElXYNh.AukCZSIq',
        '3116734567'
    );

INSERT INTO roles_usuario (usuario_id, rol)
SELECT id, 'ROLE_ADMIN'
FROM usuarios
WHERE nombre_usuario IN ('lysandra1980', 'morrison2000');
