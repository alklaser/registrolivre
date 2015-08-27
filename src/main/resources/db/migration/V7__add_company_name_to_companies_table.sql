BEGIN;
LOCK companies;
ALTER TABLE companies ADD COLUMN company_name varchar(150) DEFAULT NULL;
END;