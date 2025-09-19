-- Script de creación de base de datos para Microservicios

-- ========================================
-- MICROSERVICIO CUSTOMER-PERSON-MSV
-- ========================================
create table public.customers (
                                  customer_id character varying(20) not null,
                                  password character varying(100) not null,
                                  status boolean not null,
                                  person_id character varying(255) primary key not null,
                                  foreign key (person_id) references public.persons (id)
                                      match simple on update no action on delete no action
);
create unique index ukn6axkf7qwn8r7s7ce5gso1xpr on customers using btree (customer_id);



create table public.persons (
                                id character varying(255) primary key not null,
                                address character varying(200) not null,
                                age integer not null,
                                gender character varying(10) not null,
                                identification character varying(20) not null,
                                name character varying(100) not null,
                                phone character varying(15) not null
);
create unique index ukq9hehhi7b6xsv7sp8cpb4mo21 on persons using btree (identification);


-- Datos de prueba Customer-Person
INSERT INTO persons (id, name, gender, age, identification, address, phone) VALUES
                                                                                ('person1', 'Jose Lema', 'Masculino', 35, '1234567890', 'Otavalo sn y principal', '098254785'),
                                                                                ('person2', 'Marianela Montalvo', 'Femenino', 28, '0987654321', 'Amazonas y NNUU', '097548965'),
                                                                                ('person3', 'Juan Osorio', 'Masculino', 42, '1357924680', '13 junio y Equinoccial', '098874587');

INSERT INTO customers (person_id, customer_id, password, status) VALUES
                                                                     ('person1', 'CLI001', '1234', TRUE),
                                                                     ('person2', 'CLI002', '5678', TRUE),
                                                                     ('person3', 'CLI003', '1245', TRUE);


-- ========================================
-- MICROSERVICIO ACCOUNT-MOVEMENT-MSV
-- ========================================

create table public.accounts (
                                 id character varying(255) primary key not null,
                                 account_number character varying(20) not null,
                                 account_type character varying(20) not null,
                                 current_balance numeric(15,2) not null,
                                 customer_id character varying(20) not null,
                                 initial_balance numeric(15,2) not null,
                                 status boolean not null
);
create unique index uk6kplolsdtr3slnvx97xsy2kc8 on accounts using btree (account_number);

create table public.movements (
                                  id character varying(255) primary key not null,
                                  balance numeric(15,2) not null,
                                  date timestamp(6) without time zone not null,
                                  movement_type character varying(20) not null,
                                  value numeric(15,2) not null,
                                  account_id character varying(255) not null,
                                  foreign key (account_id) references public.accounts (id)
                                      match simple on update no action on delete no action
);


INSERT INTO public.accounts (id, account_number, account_type, current_balance, customer_id, initial_balance, status) VALUES ('0f9d2974-ed45-40d7-8247-0c5a5eb9ef17', '585545', 'Corriente', 1000.00, 'JOSE001', 1000.00, true);
INSERT INTO public.accounts (id, account_number, account_type, current_balance, customer_id, initial_balance, status) VALUES ('010139e1-862d-4fb9-820d-b8fccae441b1', '478758', 'Ahorro', 1425.00, 'JOSE001', 2000.00, true);
INSERT INTO public.accounts (id, account_number, account_type, current_balance, customer_id, initial_balance, status) VALUES ('75650d0f-7189-48b5-919a-a24537650a60', '225487', 'Corriente', 700.00, 'MARIA001', 100.00, true);
INSERT INTO public.accounts (id, account_number, account_type, current_balance, customer_id, initial_balance, status) VALUES ('ee16677f-52ac-44cf-bf17-4913c97ccda4', '495878', 'Ahorros', 150.00, 'JUAN001', 0.00, true);
INSERT INTO public.accounts (id, account_number, account_type, current_balance, customer_id, initial_balance, status) VALUES ('23f2bf71-200e-4e55-b8db-3a193a73aa74', '496825', 'Ahorros', 0.00, 'MARIA001', 540.00, true);


INSERT INTO public.movements (id, balance, date, movement_type, value, account_id) VALUES ('32e36f24-dd42-4bc8-b382-780b950b8637', 1425.00, '2025-09-19 09:37:49.800851', 'Retiro', -575.00, '010139e1-862d-4fb9-820d-b8fccae441b1');
INSERT INTO public.movements (id, balance, date, movement_type, value, account_id) VALUES ('6fa83c39-2767-4cb5-8156-60b3a46d45ac', 700.00, '2025-09-19 09:37:56.058161', 'Depósito', 600.00, '75650d0f-7189-48b5-919a-a24537650a60');
INSERT INTO public.movements (id, balance, date, movement_type, value, account_id) VALUES ('4e9cf942-9446-415b-bc06-cc7cb44ff91a', 150.00, '2025-09-19 09:38:01.599249', 'Depósito', 150.00, 'ee16677f-52ac-44cf-bf17-4913c97ccda4');
INSERT INTO public.movements (id, balance, date, movement_type, value, account_id) VALUES ('d30f8009-ec8f-4d67-a4b1-0386afcd50ba', 0.00, '2025-09-19 09:38:07.974372', 'Retiro', -540.00, '23f2bf71-200e-4e55-b8db-3a193a73aa74');