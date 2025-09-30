CREATE TABLE employees (
                           id INT AUTO_INCREMENT PRIMARY KEY,
                           first_name VARCHAR(50) NOT NULL,
                           last_name VARCHAR(50) NOT NULL,
                           email VARCHAR(100) NOT NULL UNIQUE,
                           department VARCHAR(50)
);

-- Insert sample data
INSERT INTO employees (first_name, last_name, email, department)
VALUES ('John', 'Doe', 'john.doe@example.com', 'IT');

INSERT INTO employees (first_name, last_name, email, department)
VALUES ('Jane', 'Smith', 'jane.smith@example.com', 'HR');

INSERT INTO employees (first_name, last_name, email, department)
VALUES ('Robert', 'Johnson', 'robert.johnson@example.com', 'Finance');