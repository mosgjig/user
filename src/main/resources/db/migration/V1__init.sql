create table public.users(
	username varchar(50) not null primary key,
	password varchar(50) not null,
	enabled boolean not null
);

create table public.authorities (
	username varchar(50) not null,
	authority varchar(50) not null,
	constraint fk_authorities_users foreign key(username) references users(username)
);
create unique index ix_auth_username on authorities (username,authority);

INSERT INTO public.users(username,password,enabled) VALUES ('mod','mod', true);
INSERT INTO public.authorities (username, authority) VALUES ('mod', 'ROLE_USER');

CREATE  TABLE public.user_preferences (
  id SERIAL PRIMARY KEY,
  first_name VARCHAR(45) NOT NULL ,
  last_name VARCHAR(45) NOT NULL ,
  season VARCHAR(45) NOT NULL);

INSERT INTO public.user_preferences (first_name, last_name, season) VALUES ('Modest', 'Syla', 'winter');