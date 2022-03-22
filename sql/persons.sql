CREATE TABLE IF NOT EXISTS public.persons
(
    _id bigint NOT NULL,
    name text COLLATE pg_catalog."default",
    patronymic text COLLATE pg_catalog."default",
    surname text COLLATE pg_catalog."default",
    city text COLLATE pg_catalog."default",
    CONSTRAINT persons_pkey PRIMARY KEY (_id)
)

TABLESPACE pg_default;

ALTER TABLE IF EXISTS public.persons
    OWNER to postgres;

INSERT INTO public.persons(
	_id, name, patronymic, surname, city)
	VALUES 
	(1, 'Петр', 'Андреевич', 'Иванов', 'Москва'),
	(2, 'Андрей', 'Василиевич', 'Петров', 'Новосибирск'),
	(3, 'Иван', 'Павлович', 'Чехов', 'Брянск'),
	(4, 'Кирилл', 'Олегович', 'Андреев', 'Алапаевск'),
	(5, 'Петр', 'Василиевич', 'Иванов', 'Екатеринбург'),
	(6, 'Андрей', 'Иванович', 'Васильев', 'Санкт-Петербург'),
	(7, 'Василий', 'Андреевич', 'Васильев', 'Орёл'),
	(8, 'Михаил', 'Петрович', 'Иванов', 'Волгоград'),
	(9, 'Кирилл', 'Павлович', 'Петров', 'Камышлов'),
	(10, 'Андрей', 'Андреевич', 'Андреев', 'Владивосток');