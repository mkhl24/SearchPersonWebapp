CREATE TABLE IF NOT EXISTS public.users
(
    _id bigint NOT NULL DEFAULT nextval('users__id_seq'::regclass),
    username text COLLATE pg_catalog."default",
    password text COLLATE pg_catalog."default",
    CONSTRAINT users_pkey PRIMARY KEY (_id)
)

TABLESPACE pg_default;

ALTER TABLE IF EXISTS public.users
    OWNER to postgres;


INSERT INTO public.users(
	username, password)
	VALUES 
	('user1', 'pwd1'),
	('user2', 'pwd2'),
	('user3', 'pwd3');