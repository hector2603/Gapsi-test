CREATE TABLE articles (
    id CHAR(10) PRIMARY KEY,
    name VARCHAR(100) NOT NULL,
    description TEXT,
    price DECIMAL(10, 2) NOT NULL,
    model VARCHAR(255) NOT NULL    
);


INSERT INTO articles (id, name, description, price, model) VALUES
('A12345B678', 'Laptop', 'A high-performance laptop for coding and gaming.', 1200.50, 'Model-X1'),
('B23456C789', 'Smartphone', 'A modern smartphone with the latest features.', 850.00, 'Model-S1'),
('C34567D890', 'Headphones', 'Noise-cancelling headphones with great sound quality.', 150.75, 'Model-H2'),
('D45678E901', 'Smartwatch', 'A smartwatch with fitness tracking features.', 299.99, 'Model-Watch2'),
('E56789F012', 'Keyboard', 'Mechanical keyboard with RGB lighting.', 120.00, 'Model-K5'),
('F67890G123', 'Gaming Mouse', 'Ergonomic gaming mouse with adjustable DPI.', 75.50, 'Model-M3'),
('G78901H234', 'Monitor', '27-inch monitor with 4K resolution.', 350.00, 'Model-Mon2'),
('H89012I345', 'Tablet', '10-inch tablet with high-resolution display.', 600.00, 'Model-TAB3'),
('I90123J456', 'External SSD', '1TB external SSD with high transfer speeds.', 200.00, 'Model-SSD1'),
('J01234K567', 'Portable Charger', '10,000mAh portable charger for smartphones.', 30.00, 'Model-PC4'),
('K12345L678', 'Bluetooth Speaker', 'Portable Bluetooth speaker with long battery life.', 80.00, 'Model-SPK7'),
('L23456M789', 'Wireless Earbuds', 'Compact wireless earbuds with noise cancellation.', 180.00, 'Model-EAR2'),
('M34567N890', 'Smart TV', '55-inch Smart TV with HDR support.', 1200.00, 'Model-TV5'),
('N45678O901', 'Soundbar', 'Soundbar with subwoofer for home theaters.', 250.00, 'Model-SB3'),
('O56789P012', 'Laptop Stand', 'Adjustable laptop stand with cooling fan.', 45.99, 'Model-LS3'),
('P67890Q123', 'Wireless Charger', 'Fast wireless charger for smartphones.', 35.50, 'Model-WC2'),
('Q78901R234', 'Drone', 'Camera drone with 4K video capture.', 900.00, 'Model-DR4'),
('R89012S345', 'Action Camera', 'Action camera with waterproof casing.', 400.00, 'Model-AC2'),
('S90123T456', 'VR Headset', 'Virtual reality headset with motion controllers.', 500.00, 'Model-VR5'),
('T01234U567', 'Fitness Tracker', 'Fitness tracker with heart rate monitor.', 110.00, 'Model-FT6');