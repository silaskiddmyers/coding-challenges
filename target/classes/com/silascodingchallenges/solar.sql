create table if not exists planets_around_sun
(
	id integer,
	planet_name character(12),
	has_rings boolean
);

insert into planets_around_sun values (1,'Mercury',false);
insert into planets_around_sun values (2,'Venus',false);
insert into planets_around_sun values (3,'Earth',false);
insert into planets_around_sun values (4,'Mars',false);
insert into planets_around_sun values (5,'Jupiter',true);
insert into planets_around_sun values (6,'Saturn',true);
insert into planets_around_sun values (7,'Uranus',true);
insert into planets_around_sun values (8,'Neptune',true);

create table if not exists moons_around_planets
(
	id integer,
	moon_name character(12),
	planet_name character(12)
);

insert into moons_around_planets values (0, 'Moon', 'Earth');
insert into moons_around_planets values (1, 'Titan', 'Saturn');
insert into moons_around_planets values (2, 'Ganymede', 'Jupiter');
insert into moons_around_planets values (3, 'Europa', 'Jupiter');
insert into moons_around_planets values (4, 'Io', 'Jupiter');
insert into moons_around_planets values (5, 'Callisto', 'Jupiter');
insert into moons_around_planets values (6, 'Tethys', 'Saturn');
insert into moons_around_planets values (7, 'Hyperion', 'Saturn');
insert into moons_around_planets values (8, 'Rhea', 'Saturn');
insert into moons_around_planets values (9, 'Phobos', 'Mars');
