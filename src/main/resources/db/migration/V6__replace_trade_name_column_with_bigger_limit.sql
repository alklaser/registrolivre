BEGIN;
LOCK companies;
ALTER TABLE companies ADD COLUMN new_trade_name varchar(150) DEFAULT NULL;
UPDATE companies SET new_trade_name = trade_name;
ALTER TABLE companies DROP trade_name;
ALTER TABLE companies RENAME new_trade_name TO trade_name;
END;