CREATE TABLE employees (
    id INT PRIMARY KEY AUTO_INCREMENT,
    name VARCHAR(50)
    -- Other employee attributes
);

CREATE TABLE attendance (
    id INT PRIMARY KEY AUTO_INCREMENT,
    employee_id INT,
    date DATE,
    present BOOLEAN
    -- Other attendance attributes
);

CREATE TABLE managers (
    username VARCHAR(50) PRIMARY KEY,
    password VARCHAR(50)
);

CREATE TABLE access_control (
    username VARCHAR(50) PRIMARY KEY,
    has_access BOOLEAN
);
