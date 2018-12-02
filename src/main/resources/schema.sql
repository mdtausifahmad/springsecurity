drop table if exists users;

create table users (
   username varchar(50) not null primary key ,
   password varchar(500) not null ,
   enable boolean not null

);

drop table if exists authorities;

create table authorities(
  username varchar(255) not null ,
  authority varchar(50) not null ,
  constraint fk_authorities_users foreign key (username) references users (username)
);

create unique index ix_auth_username on authorities(username, authority);