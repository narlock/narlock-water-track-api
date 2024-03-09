# USE <your_database_name>

CREATE TABLE WaterEntry(
    date DATE PRIMARY KEY NOT NULL,
    profileId INT NOT NULL,
    entry INT NOT NULL
);

CREATE TABLE WaterSetting(
    profileId INT PRIMARY KEY NOT NULL,
    goal INT NOT NULL,
    unit VARCHAR(10) NOT NULL
);