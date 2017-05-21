
DROP TABLE public.players;
CREATE TABLE public.players
(
    id integer NOT NULL,
    name character varying(32) COLLATE pg_catalog."default" NOT NULL,
    status character varying(8) COLLATE pg_catalog."default",
    alliance integer,
    dayid integer NOT NULL,
    CONSTRAINT players_pkey PRIMARY KEY (dayid,id)
)


select * from players where name = 'Eeyore'