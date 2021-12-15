DROP DATABASE rev_reimburse;

CREATE DATABASE rev_reimburse;

\c rev_reimburse

CREATE TYPE request_statuses AS ENUM ('PENDING', 'DENIED', 'APPROVED');
CREATE TYPE user_roles AS ENUM ('ADMIN', 'MANAGER', 'EMPLOYEE');

CREATE TABLE users (
    user_id SERIAL PRIMARY KEY,
    username VARCHAR(50) NOT NULL,
    user_password VARCHAR(50) NOT NULL,
    first_name VARCHAR(50) NOT NULL,
    last_name VARCHAR(50) NOT NULL,
    date_created TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    user_email VARCHAR(50) NOT NULL,
    user_type user_roles NOT NULL,
    user_address VARCHAR(75),
    profile_pic VARCHAR(255),
    user_removed boolean DEFAULT false
);

CREATE TABLE requests (
    req_id SERIAL PRIMARY KEY,
    emp_id INT,
    description VARCHAR(255),
    cost DECIMAL(100, 2) NOT NULL,
    purchase_date VARCHAR(50) NOT NULL,
    request_date TIMESTAMP DEFAULT CURRENT_DATE,
    status request_statuses NOT NULL,
    receipt_pic VARCHAR(255),
    request_removed boolean DEFAULT false,
    FOREIGN KEY (emp_id) REFERENCES users(user_id)
);

INSERT INTO users (username, user_password,
                   first_name, last_name, date_created,
                   user_email, user_type, user_address,
                   profile_pic)
VALUES ('TheBoss', 'admin', 'Big', 'Boss', current_timestamp,
        'TheBoss@gmail.com', 'ADMIN', '007 Fancy Drive',
        'https://nuptdfy.media.bublupcdn.com/-CMA3iv0nhW8BiGgTDCi5w/images/full_007-im-83fe849c-0fab-4159-871e-6ae74d43921e.jpg')
;

INSERT INTO users (username, user_password,
                   first_name, last_name, date_created,
                   user_email, user_type, user_address,
                   profile_pic)
VALUES ('Manager', 'user', 'some', 'manager', current_timestamp,
        'manager@gmail.com', 'MANAGER', '123 neighborhood ave',
        'https://nuptdfy.media.bublupcdn.com/rI9L33MWvfwP49D_fcCuFQ/images/full_007-im-e0a242df-ddc6-4325-9ba3-cb3930e3470f.jpg')
;

INSERT INTO users (username, user_password,
                   first_name, last_name, date_created,
                   user_email, user_type, user_address,
                   profile_pic)
VALUES ('Employee', 'user', 'an', 'employee', current_timestamp,
        'random@gmail.com', 'EMPLOYEE', '442 random street apt.67',
        'https://nuptdfy.media.bublupcdn.com/qABSCCBPMSopGMFUNRkbQw/images/full_007-im-6cc7c478-4008-49a8-97bb-81ed1201cdac.jpg')
;

INSERT INTO requests (emp_id, description, cost, purchase_date, request_date, status, receipt_pic)
VALUES (3, 'Gas', 29.95, current_timestamp, '12/07/2021', 'PENDING', 'PLACE_HOLDER');

INSERT INTO requests (emp_id, description, cost, purchase_date, request_date, status, receipt_pic)
VALUES (3, 'Dinner', 100.95, current_timestamp, '12/05/2021', 'DENIED', 'PLACE_HOLDER');

INSERT INTO requests (emp_id, description, cost, purchase_date, request_date, status, receipt_pic)
VALUES (3, 'Stamps', 10.27, current_timestamp, '12/01/2021', 'APPROVED', 'PLACE_HOLDER');