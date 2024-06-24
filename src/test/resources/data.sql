INSERT INTO ecommerce.tb_categories(id, name, category_root_id) 
VALUES
(1, 'ALIMENTOS', NULL),
(2, 'BEBIDAS', NULL),
(3, 'LIMPEZA', NULL),
(4, 'HIGIENE PESSOAL', NULL),
(5, 'PADARIA', NULL),
(6, 'ELETRÔNICOS', NULL);

-- Add subcategorias de ALIMENTOS
INSERT INTO ecommerce.tb_categories(name, category_root_id) 
VALUES
('FRUTAS', 1),
('VERDURAS', 1),
('CARNES', 1),
('LATICÍNIOS', 1);

-- Add subcategorias de BEBIDAS
INSERT INTO ecommerce.tb_categories(name, category_root_id) 
VALUES
('REFRIGERANTES', 2),
('SUCOS', 2),
('CERVEJAS', 2);

-- Add subcategorias de LIMPEZA
INSERT INTO ecommerce.tb_categories(name, category_root_id) 
VALUES
('LIMPEZA DOMÉSTICA', 3),
('PRODUTOS DE LAVANDERIA', 3);

-- Add subcategorias de HIGIENE PESSOAL
INSERT INTO ecommerce.tb_categories(name, category_root_id) 
VALUES
('HIGIENE BUCAL', 4),
('CUIDADOS COM A PELE', 4),
('PRODUTOS DE HIGIENE ÍNTIMA', 4);

-- Add subcategorias de PADARIA
INSERT INTO ecommerce.tb_categories(name, category_root_id) 
VALUES
('PÃES', 5),
('BOLOS', 5);

-- Add subcategorias de ELETRÔNICOS
INSERT INTO ecommerce.tb_categories(name, category_root_id) 
VALUES
('TVS', 6),
('CELULARES', 6),
('COMPUTADORES', 6);


-- PRODUCTS
INSERT INTO ecommerce.tb_products(name, brand, details, price, category_id)
VALUES
('IMAC', 'APPLE', '500GB 8GB RAM 4GHz 4CORE', 6999.99, 23),
('IMAC', 'APPLE', '1TB 16GB RAM 4.5GHz 8CORE', 16999.99, 23),
('IMAC', 'APPLE', '5TB 128GB RAM 6GHz 12CORE', 99999.99, 23);


-- STOCKS
INSERT INTO ecommerce.tb_stocks(product_id, amount, type, registred_at)
VALUES
(1, 100, 'ENTRY', '2024-04-01'),
(1, 100, 'ENTRY', '2024-04-10'),
(1, 100, 'ENTRY', '2024-04-20'),
(1, 100, 'OUTPUT', '2024-05-01');