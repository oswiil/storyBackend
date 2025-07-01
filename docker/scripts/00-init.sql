--DROP DATABASE IF EXISTS storydb;

--CREATE DATABASE storydb;-- IF NOT EXISTS;

DROP USER IF EXISTS diana;
CREATE USER diana  WITH encrypted PASSWORD 'd1@n4';
--GRANT ALL PRIVILEGES ON storydb.* TO diana;
GRANT ALL PRIVILEGES ON database storydb TO diana;

--CREATE USER myuser  WITH PASSWORD 'password';
--GRANT ALL PRIVILEGES ON ALL  storydb.* TO `user`;
GRANT ALL PRIVILEGES ON database storydb TO myuser;

--FLUSH PRIVILEGES;




DROP TABLE IF EXISTS Script, Asset, Translation, AssetType, Coordinates, Solution,
    SolutionType, Progress, Level, Chapter, Story, UserAccount, Profile, Language CASCADE;

CREATE TABLE Language (
                          id SERIAL PRIMARY KEY,
                          name VARCHAR NOT NULL
);

CREATE TABLE Profile (
                         id SERIAL PRIMARY KEY,
                         plan TEXT NOT NULL
);

CREATE TABLE UserAccount (
                             id SERIAL PRIMARY KEY,
                             language_id INT REFERENCES Language(id),
                             profile_id INT REFERENCES Profile(id)
);

CREATE TABLE Story (
                       id SERIAL PRIMARY KEY,
                       name VARCHAR NOT NULL
);

CREATE TABLE Chapter (
                         id SERIAL PRIMARY KEY,
                         title VARCHAR NOT NULL,
                         solution VARCHAR,
                         story_id INT REFERENCES Story(id),
                         number INT
);

CREATE TABLE Level (
                       id SERIAL PRIMARY KEY,
                       story_id INT REFERENCES Story(id),
                       number_chapter INT REFERENCES Chapter(id)
);

CREATE TABLE Progress (
                          id SERIAL PRIMARY KEY,
                          user_id INT REFERENCES UserAccount(id),
                          story_id INT REFERENCES Story(id),
                          level_id INT REFERENCES Level(id)
);

CREATE TABLE SolutionType (
                              id SERIAL PRIMARY KEY,
                              name VARCHAR NOT NULL
);

CREATE TABLE Solution (
                          id SERIAL PRIMARY KEY,
                          chapter_id INT REFERENCES Chapter(id),
                          solution_type_id INT REFERENCES SolutionType(id)
);

CREATE TABLE Coordinates (
                             id SERIAL PRIMARY KEY,
                             x FLOAT,
                             y FLOAT,
                             z FLOAT
);

CREATE TABLE AssetType (
                           id SERIAL PRIMARY KEY,
                           type VARCHAR NOT NULL
);

CREATE TABLE Asset (
                       id SERIAL PRIMARY KEY,
                       coordinates_id INT REFERENCES Coordinates(id),
                       image_id VARCHAR,
                       audio_id VARCHAR,
                       level_id INT REFERENCES Level(id),
                       asset_type_id INT REFERENCES AssetType(id)
);

CREATE TABLE Translation (
                             id SERIAL PRIMARY KEY,
                             language_id INT REFERENCES Language(id),
                             text TEXT NOT NULL
);

CREATE TABLE Script (
                        id SERIAL PRIMARY KEY,
                        asset_id INT REFERENCES Asset(id),
                        text TEXT,
                        isSolution BOOLEAN,
                        isButton BOOLEAN,
                        sortOrderSolution INT,
                        solutionType_id INT REFERENCES SolutionType(id),
                        translation_id INT REFERENCES Translation(id),
                        sqlRaw TEXT
);