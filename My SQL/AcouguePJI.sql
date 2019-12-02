create database acougue;

use acougue;

create table tb_clientes(
idcli int primary key auto_increment,
nomeCli varchar(50) not null,
foneCli varchar(15) not null,
cep int(20) not null,
logradouro varchar(100) not null,
numero int(10) not null,
complemento varchar(20),
cidade varchar(30) not null,
estado varchar(30) not null
);

insert into tb_clientes (nomeCli,foneCli,cep,logradouro,numero,complemento,cidade,estado) values('T','911','000000','casa casa','234','casa 14','sao paulo','sao paulo');
insert into tb_clientes (nomeCli,foneCli,cep,logradouro,numero,complemento,cidade,estado) values('Z','2000','001245','casa ap','234','casa 50','Rio','Rioo');

select * from tb_clientes;

create table tb_produtos(
codigoProduto varchar(100) primary key,
animal varchar(50) not null,
corte varchar(100) not null,
valor decimal(10,2) not null, -- 2 casas decimais
estoque decimal(10,2),
dataNoEstoque timestamp default current_timestamp
);


insert into tb_produtos(codigoProduto,animal,corte,valor,estoque) values('1000','vaca','medalhao',65,6000);
insert into tb_produtos(codigoProduto,animal,corte,valor,estoque) values('1001','frango','peito',65,6000);


create table tb_pedidos(
notaFiscal int primary key auto_increment,
dataPedido timestamp default current_timestamp,
idCli int not null,
constraint cliente_pedidos 
foreign key (idCli)
references tb_clientes (idCli)
on delete no action);

insert into tb_pedidos (idcli)
values (1);

create table tb_carrinho(
notaFiscal int not null auto_increment,
codigoProduto varchar(100) not null,
quantidade int not null,
precoKilo decimal(10,2) not null,
idCli int not null,
total int not null,
horaPedido  timestamp default current_timestamp,
constraint pedidos_carrinho
foreign key(notaFiscal)
references tb_pedidos(notaFiscal)
on delete no action);

alter table tb_carrinho
add constraint produto_carrinho
foreign key(codigoProduto)
references tb_produtos(codigoProduto)
on delete no action;

insert into tb_carrinho 
(notaFiscal,codigoProduto,quantidade,precoKilo,idCli,total)
values (1,'1000',1000,0.065,1,65);

insert into tb_carrinho
(notaFiscal,codigoProduto,quantidade,precoKilo,idCli,total)
values (1,'1001',500,0.050,1,65);

select * from tb_carrinho;

select
Ped.notaFiscal as Nota, Ped.dataPedido as DataNota,
Cli.nomeCli as Nome, Cli.foneCli as Fone
from tb_pedidos as Ped
inner join tb_clientes as Cli
on (Ped.idCli = Cli.idCli);

select 
Itens.quantidade as quantidadeGrama, Itens.precoKilo,
Prod.animal, Prod.corte
from tb_carrinho as Itens
inner join tb_produtos as Prod 
on (Itens.codigoProduto = Prod.codigoProduto);

select sum(quantidade * precoKilo) as valorTotal from tb_carrinho;


select * from tb_carrinho;
select * from tb_produtos;

describe tb_carrinho;



