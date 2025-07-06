-- Only adding passenger and booking-related changes now

-- New columns for passenger
ALTER TABLE passenger
    ADD active_booking_id BIGINT NULL;

ALTER TABLE passenger
    ADD home_id BIGINT NULL;

ALTER TABLE passenger
    ADD last_known_location_id BIGINT NULL;

ALTER TABLE passenger
    ADD rating DOUBLE NULL;

-- New columns for booking
ALTER TABLE booking
    ADD drop_off_location_id BIGINT NULL;

ALTER TABLE booking
    ADD pickup_location_id BIGINT NULL;

-- Modify types
ALTER TABLE driver
    ADD is_available BIT(1) NULL;

ALTER TABLE driver
    MODIFY is_available BIT(1) NOT NULL;

ALTER TABLE passenger
    MODIFY rating DOUBLE NOT NULL;

ALTER TABLE driver
    MODIFY rating DOUBLE NOT NULL;

-- Add foreign keys
ALTER TABLE booking
    ADD CONSTRAINT FK_BOOKING_ON_DROPOFFLOCATION FOREIGN KEY (drop_off_location_id) REFERENCES exact_location (id);

ALTER TABLE booking
    ADD CONSTRAINT FK_BOOKING_ON_PICKUPLOCATION FOREIGN KEY (pickup_location_id) REFERENCES exact_location (id);

ALTER TABLE passenger
    ADD CONSTRAINT FK_PASSENGER_ON_ACTIVEBOOKING FOREIGN KEY (active_booking_id) REFERENCES booking (id);

ALTER TABLE passenger
    ADD CONSTRAINT FK_PASSENGER_ON_HOME FOREIGN KEY (home_id) REFERENCES exact_location (id);

ALTER TABLE passenger
    ADD CONSTRAINT FK_PASSENGER_ON_LASTKNOWNLOCATION FOREIGN KEY (last_known_location_id) REFERENCES exact_location (id);
