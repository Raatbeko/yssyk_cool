INSERT INTO common_reference_type(id, create_time, code_type, title)
VALUES (3, now(), 3, 'Типы комплексов');

INSERT INTO common_reference(create_time, code_type, type_id, title)
VALUES (now(), 3, 3, 'Отель'),
       (now(), 3, 3, 'Пансионат'),
       (now(), 3, 3, 'Курорт');