USE transferCompany;

INSERT INTO Countries(name) 
VALUES ('Argentina'),('Brasil'),('Uruguay');

INSERT INTO Cities(name, country_id) 
VALUES ('Buenos Aires',1),('Sao Paulo', 2),
('Montevideo',3),('Córdoba',1),
('Rio de Janeiro',2),('Bahia Blanca', 1);

INSERT INTO Users(name, phone_number, city_id) 
VALUES ('Juan Costa',4357676,3),('Maria Lopez', 5566567,4),
('Jair Bonato',9899743,5),('Patricia Jimenez', 4449976,1),
('Valentino Arrimada',5664455,6),('Mia Carolo',77757461,2);

INSERT INTO Sizes(size_type, fare) 
VALUES ('Small',50),('Medium',75),('Large', 100);

INSERT INTO Baggages(owner_id, size_id, weight) 
VALUES (1,3,30),(5,2,21),(3,1,15),(4,2,20),(2,1,18);

INSERT INTO Terminals(address) 
VALUES ('Sao Paulo International Airport'),('Bahia Blanca Port'),
('Córdoba National Airport'),('Montevideo Port');

INSERT INTO Routes(from_id, to_id)
VALUES (1,2),(2,1),(3,1),(1,3),(5,3),(3,5),(6,4),(5,1),(1,5),(4,6);

INSERT INTO TransportationTypes(type) 
VALUES ('Persons'),('Luggage'),('Both');

INSERT INTO TransportationMediums(name,type_id) 
VALUES 
('Cruise',3),('Truck', 2),
('Bus', 3),('Airplane', 3),('Car', 1);

INSERT INTO Transfers(route_id, transportation_id) 
VALUES (1,3),(2,2),(3,1),(4,1),(5,2),(6,3),(7,4),(8,5),(9,1),(10,2);

INSERT INTO BaggageTransfers(terminal_id) 
VALUES (3),(4),(2),(1),(2);

INSERT INTO PassengerTransfers(passenger_id) 
VALUES (3),(4),(1),(2),(5);
