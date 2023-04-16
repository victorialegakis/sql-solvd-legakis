Use transferCompany;

SELECT Baggages.id AS 'BAGGAGE NUMBER', Users.name AS 'OWNER', Sizes.size_type AS 'SIZE' , Baggages.weight AS 'WEIGHT'
FROM Baggages
LEFT JOIN Users ON Baggages.owner_id = Users.id
LEFT JOIN Sizes ON Baggages.size_id = Sizes.id
ORDER BY Baggages.weight ASC;

SELECT Routes.id AS 'ROUTE NUMBER', c1.name AS 'DEPARTURE', c2.name AS 'DESTINATION'
FROM Routes
INNER JOIN Cities c1 ON Routes.from_id = c1.id
INNER JOIN Cities c2 ON Routes.to_id = c2.id
ORDER BY Routes.id ASC;


SELECT BaggageTransfers.id AS ' BAGGAGE TRANSFER NUMBER', Users.name AS 'OWNER', 
Sizes.size_type AS 'SIZE', Terminals.address AS 'LOCATION', Terminals.gate AS 'GATE OF DESTINATION',
c1.name AS 'DEPARTURE CITY',c2.name AS 'DESTINATION CITY', TransportationMediums.name AS 'TRANSPORT',
Transfers.price AS 'PRICE'
FROM BaggageTransfers
LEFT JOIN Baggages ON BaggageTransfers.baggage_id = Baggages.id
LEFT JOIN Users ON Baggages.owner_id = Users.id
LEFT JOIN Sizes ON Baggages.size_id= Sizes.id
LEFT JOIN Terminals ON BaggageTransfers.terminal_id = Terminals.id
LEFT JOIN Transfers ON BaggageTransfers.transfer_id = Transfers.id
LEFT JOIN Routes ON  Transfers.route_id = Routes.id
LEFT JOIN Cities c1 ON Routes.from_id = c1.id
LEFT JOIN Cities c2 ON Routes.to_id = c2.id
LEFT JOIN TransportationMediums ON Transfers.transportation_id= TransportationMediums.id;

