/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 * Author:  pc05
 * Created: 14/11/2017
 */
create table cliente (
id serial,
nome varchar(50),
sobrenome varchar(50),
cpf varchar(18),
rua varchar(100),
numeroRua int,
CONSTRAINT pkcliente PRIMARY key (id)
);

