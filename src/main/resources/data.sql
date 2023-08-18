/*DROP TABLE IF EXISTS usersapp;
DROP TABLE IF EXISTS investment;

CREATE TABLE UsersApp (
    id INT AUTO_INCREMENT PRIMARY KEY,
    username VARCHAR(255) NOT NULL,
    password VARCHAR(255) NOT NULL,
    creationDate DATETIME NOT NULL
);

CREATE TABLE Investment (
    id INT AUTO_INCREMENT PRIMARY KEY,
    company VARCHAR(255) NOT NULL,
    amount DECIMAL(10,2) NOT NULL,
    term INT NOT NULL,
    maturityDate DATE NOT NULL,
    monthlyReturn BIT NOT NULL
);
*/
INSERT INTO UsersApp (username, password, creationDate) VALUES
('user1', 'pass1', CURRENT_TIMESTAMP()),
('user2', 'pass2', CURRENT_TIMESTAMP()),
('user3', 'pass3', CURRENT_TIMESTAMP()),
('user4', 'pass4', CURRENT_TIMESTAMP()),
('user5', 'pass5', CURRENT_TIMESTAMP()),
('user6', 'pass6', CURRENT_TIMESTAMP()),
('user7', 'pass7', CURRENT_TIMESTAMP()),
('user8', 'pass8', CURRENT_TIMESTAMP()),
('user9', 'pass9', CURRENT_TIMESTAMP()),
('user10', 'pass10', CURRENT_TIMESTAMP());

INSERT INTO Investment (company, amount, term, maturityDate, monthlyReturn) VALUES
('Company A', 10000.00, 12, '2023-07-31', 1),
('Company B', 5000.00, 6, '2023-08-15', 0),
('Company C', 25000.00, 24, '2023-12-31', 1),
('Company D', 15000.00, 18, '2023-10-31', 1),
('Company E', 2000.00, 3, '2023-07-20', 0),
('Company F', 8000.00, 9, '2023-09-30', 1),
('Company G', 35000.00, 36, '2024-06-30', 1),
('Company H', 6000.00, 6, '2023-08-31', 1),
('Company I', 1000.00, 1, '2023-07-07', 0),
('Company J', 40000.00, 48, '2025-12-31', 1);
