CREATE DATABASE ecommerce;


SELECT SUM(CASE WHEN s.type = 'ENTRY' THEN s.amount ELSE s.amount * -1 END) 
FROM ecommerce.tb_stocks as s 
WHERE s.product_id = 3;