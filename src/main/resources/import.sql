insert into estado (nome, sigla) values( 'Tocantins', 'TO');
insert into estado (nome, sigla) values( 'Goiás', 'GO');
insert into estado (nome, sigla) values( 'São Paulo', 'SP');
insert into estado (nome, sigla) values( 'Rio de Janeiro', 'RJ');
insert into estado (nome, sigla) values( 'Pará', 'PA');

insert into cidade (nome, id_estado) values( 'Palmas', 1);
insert into cidade (nome, id_estado) values( 'Paraíso', 1);
insert into cidade (nome, id_estado) values( 'Gurupi', 1);
insert into cidade (nome, id_estado) values( 'Goiânia', 2);
insert into cidade (nome, id_estado) values( 'Anápolis', 2);

insert into sabor (sabor) values ('mint');
insert into sabor (sabor) values ('kiwi');

insert into cor (cor) values ('blue-royal');
insert into cor (cor) values ('black');

insert into puff (quantidade) values ('7000');
insert into puff (quantidade) values ('2500');

insert into marca (nome, descricao) values ('ignite', 'a melhor do mercado');
insert into marca (nome, descricao) values ('elfbar', 'a mais antiga do mercado');

insert into resistencia (ohms) values ('2.1');
insert into resistencia (ohms) values ('1.2');

INSERT INTO pessoa(nome) VALUES ('kaue');
INSERT INTO pessoafisica(id, cpf, email, data_nascimento) VALUES (1, '78836786120', 'kaue@gmail', '2002-02-03');
INSERT INTO usuario(login, senha, id_pessoa_fisica, ativo) VALUES ('kaue', 'TRwn0XU29Gwl2sagG00bvjrNJvLuYo+dbOBJ7R3xFpU4m/FAUc5q8OoGbVNwPF7F5713RaYkN4qyufNCDHm/mA==', 1, true);

INSERT INTO  perfis (id_usuario, perfil) VALUES (1, 1);
INSERT INTO  perfis (id_usuario, perfil) VALUES (1, 3);




