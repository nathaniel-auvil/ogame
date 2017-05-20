
DROP TABLE public.scores;

CREATE TABLE public.scores
(
    total bigint,
    totalRank bigint,
    economy bigint,
    economyRank bigint,
    research bigint,
    researchRank bigint,
    military bigint,
    militaryRank bigint,
    ships bigint,
    militaryBuilt bigint,
    militaryBuiltRank bigint,
    militaryDestroyed bigint,
    militaryDestroyedRank bigint,
    militaryLost bigint,
    militaryLostRank bigint,
    honor bigint,
    honorRank bigint,
    playerId integer NOT NULL,
    dayId integer NOT NULL,
    CONSTRAINT scores_pkey PRIMARY KEY (playerId, dayId)
)