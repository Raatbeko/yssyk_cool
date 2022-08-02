ALTER TABLE common_reference_type ALTER COLUMN id TYPE int8;

INSERT INTO common_reference_type(id,create_time,code_type,title)
VALUES
       (1,now(),1,'Город'),
       (2,now(),2,'Район');

INSERT INTO common_reference(create_time,code_type,type_id,title)
VALUES
       (now(),1,1,'Каракол'),
       (now(),1,1,'Балыкчы '),
       (now(),1,1,'Чолпон-Ата'),

       (now(),2,2,'Тюпский район'),
       (now(),2,2,'Ак-Суйский район'),
       (now(),2,2,'Тонский район'),
       (now(),2,2,'Джети-Огузский район'),
       (now(),2,2,'Иссык-Кульский район');

INSERT INTO common_reference_type(id, create_time, code_type, title)
VALUES (3, now(), 3, 'Типы комплексов');

INSERT INTO common_reference(create_time, code_type, type_id, title)
VALUES (now(), 3, 3, 'Отель'),
       (now(), 3, 3, 'Пансионат'),
       (now(), 3, 3, 'Курорт');