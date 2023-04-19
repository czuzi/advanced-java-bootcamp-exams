CREATE TABLE routes (
    id BIGINT NOT NULL AUTO_INCREMENT PRIMARY KEY,
    departure_city VARCHAR(255) NOT NULL,
    arrival_city VARCHAR(255) NOT NULL,
    date_of_flight DATE NOT NULL,
    airplane_id BIGINT,
    CONSTRAINT fk_airplane_id FOREIGN KEY (airplane_id) REFERENCES airplanes (id)
);