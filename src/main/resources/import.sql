
INSERT INTO pessoa(nome) VALUES ('Maria');
INSERT INTO pessoafisica(id, cpf, email, data_nascimento) VALUES (1, '47652930090', 'maria@gmail', '2002-10-10');
INSERT INTO usuario(login, senha, id_pessoa_fisica, ativo) VALUES ('maria', 'TRwn0XU29Gwl2sagG00bvjrNJvLuYo+dbOBJ7R3xFpU4m/FAUc5q8OoGbVNwPF7F5713RaYkN4qyufNCDHm/mA==', 1, true);

INSERT INTO  perfis (id_usuario, perfil) VALUES (1, 1);
INSERT INTO  perfis (id_usuario, perfil) VALUES (1, 3);

INSERT INTO pessoa(nome) VALUES ('João');
INSERT INTO pessoafisica(id, cpf, email, data_nascimento) VALUES (2, '05319824165', 'joaao@gmail', '2002-10-05');
INSERT INTO usuario(login, senha, id_pessoa_fisica, ativo) VALUES ('joao', 'TRwn0XU29Gwl2sagG00bvjrNJvLuYo+dbOBJ7R3xFpU4m/FAUc5q8OoGbVNwPF7F5713RaYkN4qyufNCDHm/mA==', 2, true);

INSERT INTO perfis (id_usuario, perfil) VALUES (2, 2);
INSERT INTO perfis (id_usuario, perfil) VALUES (2, 1);

insert into metododerecebimento(id) values (default);
insert into metododerecebimento(id) values (default);
insert into metododerecebimento(id) values (default);
insert into metododerecebimento(id) values (default);
insert into metododerecebimento(id) values (default);
insert into metododerecebimento(id) values (default);
insert into metododerecebimento(id) values (default);
insert into metododerecebimento(id) values (default);

insert into pixrecebimento(id, chave, tipo_chave, ativo) values (1, '63984883349', 4, true);
insert into pixrecebimento(id, chave, tipo_chave, ativo) values (2, 'petisco@gmail.com', 3, false);
insert into pixrecebimento(id, chave, tipo_chave, ativo) values (3, '000000213233', 2, false);
insert into pixrecebimento(id, chave, tipo_chave, ativo) values (4, 'petiscopetisco', 1, false);

insert into boletorecebimento(id, banco, nome, cnpj, agencia, conta, ativo) values (5, '123', 'Pet Isco Comércio e Participações S/A', '111233232231', '12345', '1234', true);
insert into boletorecebimento(id, banco, nome, cnpj, agencia, conta, ativo) values (6, '123', 'Pet Isco LTDA', '111233232231', '12345', '1234', false);
insert into boletorecebimento(id, banco, nome, cnpj, agencia, conta, ativo) values (7, '001', 'Pet Isco LTDA', '111233232231', '53412', '3412', false);
insert into boletorecebimento(id, banco, nome, cnpj, agencia, conta, ativo) values (8, '001', 'Pet Isco LTDA - S/A', '111233232231', '53412', '3412', false);

INSERT INTO Estado (dataInclusao, dataAlteracao, sigla, nome)
VALUES ('2023-12-07 08:35:00', '2023-12-07 08:40:00', 'TO', 'Tocantins');

INSERT INTO Municipio (dataInclusao, dataAlteracao, nome, id_estado)
VALUES ('2023-12-07 08:45:00', '2023-12-07 08:50:00', 'Palmas', 1);

INSERT INTO Endereco (dataInclusao, dataAlteracao, principal, logradouro, bairro, numero, complemento, cep, titulo, id_municipio, id_usuario)
VALUES ('2023-12-07 09:00:00', '2023-12-07 09:05:00', true, 'Rua das Flores', 'Centro', '123', 'Apartamento 101', '77000000', 'Casa', 1, 1);

INSERT INTO Endereco (dataInclusao, dataAlteracao, principal, logradouro, bairro, numero, complemento, cep, titulo, id_municipio, id_usuario)
VALUES ('2023-12-07 09:00:00', '2023-12-07 09:05:00', false, 'Rua Floresta', 'AurenyII', '135', null , '77603170', 'Casa', 1, 1);

INSERT INTO Telefone (dataInclusao, dataAlteracao, codigoArea, numero)
VALUES ('2023-12-07 09:10:00', '2023-12-07 09:15:00', '63', '912345678');

INSERT INTO usuario_telefone (id_telefone, id_usuario) VALUES (1,1);

