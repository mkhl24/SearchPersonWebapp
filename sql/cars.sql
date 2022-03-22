CREATE TABLE IF NOT EXISTS public.cars
(
    person_id bigint NOT NULL,
    registration_number text COLLATE pg_catalog."default" NOT NULL
)

TABLESPACE pg_default;

ALTER TABLE IF EXISTS public.cars
    OWNER to postgres;

INSERT INTO public.cars(
	person_id, registration_number)
	VALUES (1, 'г123ва96'),
	(1, 'а543кя96'),
	(2, 'к123тт77'),
	(3, 'н521ка74'),
	(4, 'п634вр77'),
	(5, 'г268ук96'),
	(5, 'о678ма66'),
	(6, 'д222дт78'),
	(7, 'р472ур96'),
	(8, 'у545вз96'), 
	(9, 'е753уж62'),
	(3, 'т89гм91'),
	(10, 'в713хк62'),;