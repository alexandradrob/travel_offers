create schema if not exists travels;
use travels;

create table travels.countries
(
    country_id   int         not null auto_increment,
    country_name varchar(25) not null,
    primary key (country_id)
);

create table travels.cities
(
    city_id          int           not null auto_increment,
    city_name        varchar(25)   not null,
    country_id       int           not null,
    city_description varchar(2000) not null,
    primary key (city_id),
    constraint foreign key (country_id) references travels.countries (country_id)
);

create table travels.attractions
(
    attraction_id   int         not null auto_increment,
    attraction_name varchar(40) not null,
    city_id         int         not null,
    primary key (attraction_id),
    constraint foreign key (city_id) references travels.cities (city_id)
);

create table travels.activities
(
    activity_id   int not null auto_increment,
    activity_name varchar(30),
    primary key (activity_id)
);

create table travels.hotels
(
    hotel_id   int         not null auto_increment,
    hotel_name varchar(40) not null,
    primary key (hotel_id)
);
create table travels.offers
(
    offer_id    int          not null auto_increment,
    start_date  date         not null,
    end_date    date         not null,
    price       int          not null,
    city_id     int          not null,
    hotel_id    int          not null,
    activity_id int          not null,
    description varchar(200) not null,
    primary key (offer_id),
    constraint foreign key (city_id)
        references travels.cities (city_id),
    constraint foreign key (hotel_id)
        references travels.hotels (hotel_id),
    constraint foreign key (activity_id)
        references travels.activities (activity_id)
);



insert into travels.countries (country_id, country_name)
values (1, 'Japan'),
       (2, 'Sweden'),
       (3, 'Thailand'),
       (4, 'Italy'),
       (5, 'USA');
insert into travels.cities (city_id, city_name, city_description, country_id)
values (1, 'Bologna',
        'The gastronomic capital of Italy, the gourmets will be delighted by the multitude of treats in Bologna - you can burn the calories by climbing in the towers of Bologna or visiting the local museums and galleries.',
        4),
       (2, 'Phuket',
        'Phuket is among the world’s finest beach destinations, with fine white sands, nodding palm trees, glittering seas and lively towns.It has something for any taste and budget, with hundreds of hotels to choose from, a wide choice of dining and partying options.',
        3),
       (3, 'Stockholm',
        'You might know that Stockholm is the second most prolific tech and start up hub in the world, second only to Silicon Valley. Stockholm attracts the most innovative people from all corners of the world and what meets them is a capital known for its beauty and closeness to nature.',
        2),
       (4, 'New York',
        'New York City is an iconic vacation destination — but it can also be overwhelming to visit. Whether you want to spend a week or just a couple of days, planning your trip is important. Let us explore the best the city has to offer, learn a few travel tips, and find out how to make the most of your trip.',
        5),
       (5, 'Tokyo',
        'A Tokyo vacation means you’ll discover incredible technology in a place that also promotes rich traditions. Go shopping at high-end designer stores or explore local vendors. Spend the day people-watching and witness the street fashion culture. Explore traditional temples or wander through forests during cherry blossom season.',
        1);
insert into travels.activities (activity_id, activity_name)
values (1, 'Beach'),
       (2, 'Sports'),
       (3, 'Romance'),
       (4, 'Entertainment'),
       (5, 'Adventure');
insert into travels.attractions(attraction_id, attraction_name, city_id)
values (1, 'Basilica de San Petronio', 1),
       (2, 'Neptune Fountain', 1),
       (3, 'Big Buddha', 2),
       (4, 'Karon Beach', 2),
       (5, 'Phi Phi Islands', 3),
       (6, 'The Grand Palace', 3),
       (7, 'Statue of Liberty', 4),
       (8, 'Central Park', 4),
       (9, 'Tokyo Skytree', 5),
       (10, 'Meiji Jingu', 5);
insert into travels.hotels (hotel_id, hotel_name)
values (1, 'Intercontinental'),
       (2, 'Marigold'),
       (3, 'Holiday Inn'),
       (4, 'ANA');
insert into travels.offers (offer_id, start_date, end_date, price,
                            city_id, hotel_id, activity_id, description)
values (1, '2019-03-22 00:00:00', '2019-03-27 00:00:00', 1700, 5, 4, 4, 'Lush vacation in Tokyo'),
       (2, '2019-07-10 00:00:00', '2019-07-15 00:00:00', 500, 3, 1, 2, 'Exciting adventure in Stockholm'),
       (3, '2019-05-23 00:00:00', '2019-06-01 00:00:00', 1234, 2, 2, 1, 'Super fun in Phuket'),
       (4, '2019-12-22 00:00:00', '2019-12-29 00:00:00', 766, 2, 2, 1, 'Ultra fun in Phuket'),
       (5, '2019-11-22 00:00:00', '2019-12-05 00:00:00', 564, 2, 2, 1, 'Italian fun in Bologna'),
       (6, '2019-05-22 00:00:00', '2019-05-29 00:00:00', 1000, 1, 2, 1, 'Taste the cofffee in Bologna');
