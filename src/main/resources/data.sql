DROP TABLE IF EXISTS customer;

DROP TABLE IF EXISTS account;

create table account (
    account_number bigserial not null,
    account_type varchar(255),
    branch_address varchar(255),
    created_date date,
    customer_id bigint,
    primary key (account_number)
                     );

create table customer (
    customer_id bigserial not null,
    created_date date,
    email varchar(255),
    mobile_number varchar(255),
    name varchar(255),
    primary key (customer_id)
                      );

INSERT INTO customer (name,email,mobile_number,created_date)
VALUES ('Boxy','boxy@boxy.com','9876548337',NOW());

INSERT INTO account (customer_id, account_type, branch_address, created_date)
VALUES (1, 'Savings', '123 Main Street, New York', NOW());