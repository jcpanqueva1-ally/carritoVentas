/*Usuarios*/
INSERT INTO usuarios (username,password,enabled,nombre,apellido,email) VALUES('user','$2a$10$CfyUhQLqkzfmbs9t6deIgO5x1UwB0WenIU2exMGAATXKQqyy4sNSa',1,'Juan','Panqueva','panqeuva763@gmail');
INSERT INTO usuarios (username,password,enabled,nombre,apellido,email) VALUES('admin','$2a$10$JadaL0.kM2X.sJGsQ56EB.7e1Wty.au8h250YPRSLQ5EPPOkuvOr6 ',1,'Sara','Panqueva','sarasofia2610@gmail.com');

INSERT INTO roles (nombre)VALUES('ROLE_USER');
INSERT INTO roles (nombre)VALUES('ROLE_ADMIN');

INSERT INTO usuarios_roles (usuario_id, role_id) VALUES (1,1);
INSERT INTO usuarios_roles (usuario_id, role_id) VALUES (2,2);
INSERT INTO usuarios_roles (usuario_id, role_id) VALUES (2,1);