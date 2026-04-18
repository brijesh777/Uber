
INSERT INTO APP_USER(NAME, EMAIL, PASSWORD) VALUES
('Aarav Sharma', 'aarav@gmail.com', 'Aarav@123'),
('Vivaan Patel', 'vivaan@gmail.com', 'Vivaan#456'),
('Aditya Mehta', 'aditya@gmail.com', 'AdiMeh@789'),
('Krishna Reddy', 'krishna@gmail.com', 'KrisRed@321'),
('Ishaan Verma', 'ishaan@gmail.com', 'IshV!456'),
('Dhruv Shah', 'dhruv@gmail.com', 'Dhruv$111'),
('Aryan Joshi', 'aryan@gmail.com', 'AryJos@2024'),
('Anaya Singh', 'anaya@gmail.com', 'AnaS#202'),
('Myra Kapoor', 'myra@gmail.com', 'MyKap@444'),
('Diya Iyer', 'diya@gmail.com', 'Diya!007'),
('Kiara Nair', 'kiara@gmail.com', 'KiaN@808'),
('Aanya Das', 'aanya@gmail.com', 'AanDas#902'),
('Prisha Gupta', 'prisha@gmail.com', 'PriGup@301'),
('Riya Menon', 'riya@gmail.com', 'RiyMen$147'),
('Reyansh Roy', 'reyansh@gmail.com', 'ReyRoy@888'),
('Kabir Bhatia', 'kabir@gmail.com', 'KabBha@369'),
('Neil Malhotra', 'neil@gmail.com', 'NeilM@222'),
('Shaurya Kulkarni', 'shaurya@gmail.com', 'ShaKul@555'),
('Tanishq Saxena', 'tanishq@gmail.com', 'TanSax@010'),
('Avni Chatterjee', 'avni@gmail.com', 'AvnCha#303'),
('Meher Sinha', 'meher@gmail.com', 'MehSin$909');



INSERT INTO user_roles(user_id, roles) VALUES
(1, 'RIDER'),
(2, 'RIDER'),
(3, 'RIDER'),
(4, 'DRIVER'),
(5, 'RIDER'),
(6, 'RIDER'),
(7, 'DRIVER'),
(8, 'RIDER'),
(9, 'DRIVER'),
(10, 'RIDER'),
(11, 'DRIVER'),
(12, 'RIDER'),
(13, 'RIDER'),
(14, 'DRIVER'),
(15, 'DRIVER'),
(16, 'RIDER'),
(17, 'RIDER'),
(18, 'DRIVER'),
(19, 'RIDER'),
(20, 'DRIVER');



INSERT INTO rider (user_id, rating) values (1,4.9);


INSERT INTO driver(user_id, rating, available, current_location) VALUES
(4, 4.2, true, ST_GeomFromText('POINT(73.1914 22.2939)', 4326)),    -- Laxmi Vilas Palace
(5, 3.9, false, ST_GeomFromText('POINT(73.1887 22.3120)', 4326)),   -- Sardar Patel Planetarium
(6, 4.8, true, ST_GeomFromText('POINT(73.1880 22.3020)', 4326)),    -- Chimnabai Clock Tower
(7, 4.0, true, ST_GeomFromText('POINT(73.19766 22.29575)', 4326)),  -- Kirti Stambh
(8, 4.5, false, ST_GeomFromText('POINT(73.1887 22.3120)', 4326)),   -- Kala Bhavan
(9, 4.1, true, ST_GeomFromText('POINT(73.1880 22.3060)', 4326)),    -- Khanderao Market
(10, 4.6, false, ST_GeomFromText('POINT(73.1880 22.3080)', 4326)),  -- Nyay Mandir
(11, 3.8, true, ST_GeomFromText('POINT(73.1880 22.3070)', 4326)),  -- Hazira Maqbara
(12, 4.4, false, ST_GeomFromText('POINT(73.1914 22.2939)', 4326)),
(13, 4.9, true, ST_GeomFromText('POINT(73.1887 22.3120)', 4326)),
(14, 4.0, true, ST_GeomFromText('POINT(73.1880 22.3020)', 4326)),
(15, 4.3, false, ST_GeomFromText('POINT(73.19766 22.29575)', 4326)),
(16, 3.7, true, ST_GeomFromText('POINT(73.1887 22.3120)', 4326)),
(17, 4.2, true, ST_GeomFromText('POINT(73.1880 22.3060)', 4326)),
(18, 4.7, false, ST_GeomFromText('POINT(73.1880 22.3080)', 4326)),
(19, 3.9, true, ST_GeomFromText('POINT(73.1880 22.3070)', 4326)),
(20, 4.8, false, ST_GeomFromText('POINT(73.1914 22.2939)', 4326)),
(21, 4.6, true, ST_GeomFromText('POINT(73.1887 22.3120)', 4326));


INSERT INTO wallet (user_id, balance) VALUES
(1, 100),
(2, 500);