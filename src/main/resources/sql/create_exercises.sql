CREATE TABLE public.exercises
(
    id SERIAL PRIMARY KEY,
    name character varying(250)  NOT NULL,
    reps integer NOT NULL,
    sets integer,
    rest integer,
    category character varying(250),
    subcategory character varying(250),
	intensity character varying(250),
	type character varying(250)
);

CREATE TABLE public.activity_type
(
    id SERIAL PRIMARY KEY,
    name character varying(250)  NOT NULL,
	category character varying(250),
	subcategory character varying(250),
	intensity character varying(250),
	type character varying(250)
);

CREATE TABLE public.activity
(
    id SERIAL PRIMARY KEY,
    person character varying(250)  NOT NULL,
	activity_type character varying(250),
	created_date timestamp DEFAULT CURRENT_TIMESTAMP
);