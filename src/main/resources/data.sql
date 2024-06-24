-- Insert categories
INSERT INTO ecommerce.tb_categories(id, name, category_root_id) 
VALUES
(1, 'FOOD', NULL),
(2, 'DRINKS', NULL),
(3, 'CLEANING', NULL),
(4, 'PERSONAL HYGIENE', NULL),
(5, 'BAKERY', NULL),
(6, 'ELECTRONICS', NULL);

-- Add subcategories of FOOD
INSERT INTO ecommerce.tb_categories(name, category_root_id) 
VALUES
('FRUITS', 1),
('VEGETABLES', 1),
('MEATS', 1),
('DAIRY PRODUCTS', 1);

-- Add subcategories of DRINKS
INSERT INTO ecommerce.tb_categories(name, category_root_id) 
VALUES
('SOFT DRINKS', 2),
('JUICES', 2),
('BEERS', 2);

-- Add subcategories of CLEANING
INSERT INTO ecommerce.tb_categories(name, category_root_id) 
VALUES
('HOUSEHOLD CLEANING', 3),
('LAUNDRY PRODUCTS', 3);

-- Add subcategories of PERSONAL HYGIENE
INSERT INTO ecommerce.tb_categories(name, category_root_id) 
VALUES
('ORAL HYGIENE', 4),
('SKIN CARE', 4),
('INTIMATE HYGIENE PRODUCTS', 4);

-- Add subcategories of BAKERY
INSERT INTO ecommerce.tb_categories(name, category_root_id) 
VALUES
('BREADS', 5),
('CAKES', 5);

-- Add subcategories of ELECTRONICS
INSERT INTO ecommerce.tb_categories(name, category_root_id) 
VALUES
('TVS', 6),
('CELL PHONES', 6),
('COMPUTERS', 6);

-- PRODUCTS
INSERT INTO ecommerce.tb_products(name, brand, details, price, category_id)
VALUES
('IMAC', 'APPLE', '500GB 8GB RAM 4GHz 4CORE', 6999.99, 23),
('IMAC', 'APPLE', '1TB 16GB RAM 4.5GHz 8CORE', 16999.99, 23),
('IMAC', 'APPLE', '5TB 128GB RAM 6GHz 12CORE', 99999.99, 23);

-- STOCKS
INSERT INTO ecommerce.tb_stocks(product_id, amount, type, registered_at)
VALUES
(1, 100, 'ENTRY', '2024-04-01'),
(1, 100, 'ENTRY', '2024-04-10'),
(1, 100, 'ENTRY', '2024-04-20'),
(1, 100, 'OUTPUT', '2024-05-01');
