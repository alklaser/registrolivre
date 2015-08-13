CREATE TABLE IF NOT EXISTS documents (
    id   SERIAL PRIMARY KEY,
    company_id INT NOT NULL REFERENCES companies(id),
    cnpj VARCHAR(18) UNIQUE NOT NULL,
    s3_etag VARCHAR(255)
)