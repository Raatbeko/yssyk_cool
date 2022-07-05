ALTER TABLE roles ALTER COLUMN id TYPE int8;

UPDATE roles
SET id = 1
WHERE id = 1;

UPDATE roles
SET id = 2
WHERE id = 2;

UPDATE roles
SET id = 3
WHERE id = 3;