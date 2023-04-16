ALTER TABLE BaggageTransfers
MODIFY COLUMN transfer_id INT NULL;

ALTER TABLE PassengerTransfers
MODIFY COLUMN transfer_id INT NULL;

ALTER TABLE BaggageTransfers
MODIFY COLUMN baggage_id INT NULL;

-- missing updates for baggage transfers and passenger transfers 