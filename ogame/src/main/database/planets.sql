
DROP TABLE public.planets;
CREATE TABLE public.planets
(
	id integer NOT NULL,
    dayid integer NOT NULL,
    playerid integer not null,
    name character varying(64) COLLATE pg_catalog."default" NOT NULL,
    coords character varying(16) COLLATE pg_catalog."default" NOT NULL,
    galaxy integer not NULL,
    solarsystem integer not null,
    planet integer not null,
    
    CONSTRAINT planets_pkey PRIMARY KEY (id,dayid)
)


select * from players where name = 'Eeyore'


select galaxy, count(1) from planets group by galaxy order by galaxy