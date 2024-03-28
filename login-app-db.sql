-- Create the database
CREATE DATABASE IF NOT EXISTS login_app_db;

-- Switch to the database
USE login_app_db;

-- Create the tables
CREATE TABLE IF NOT EXISTS user (

    user_id INT AUTO_INCREMENT,
    first_name VARCHAR(50) NOT NULL,
    last_name VARCHAR(50) NOT NULL,
    date_of_birth DATE NOT NULL,
    gender VARCHAR(6) NOT NULL,
    country VARCHAR(50) NOT NULL,
	
	CONSTRAINT pk__user__user_id PRIMARY KEY (user_id)
);

CREATE TABLE IF NOT EXISTS user_credential (

	user_id INT NOT NULL,
	username VARCHAR(50) UNIQUE NOT NULL,
	email VARCHAR(50) UNIQUE NOT NULL,
	password VARCHAR(255) NOT NULL,
	
	CONSTRAINT fk__user_credential__user_id__user__user_id FOREIGN KEY (user_id) REFERENCES user (user_id) ON DELETE CASCADE ON UPDATE CASCADE,
	CONSTRAINT pk__user_credential__user_id PRIMARY KEY (user_id)
);