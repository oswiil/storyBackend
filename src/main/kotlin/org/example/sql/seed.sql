-- Primero insertamos los datos básicos
INSERT INTO Language (name) VALUES ('English'), ('Spanish');
INSERT INTO Profile (plan) VALUES ('free'), ('premium');

-- Insertamos usuarios con sus preferencias
INSERT INTO UserAccount (language_id, profile_id) VALUES (1, 2);

-- Creamos la historia base
INSERT INTO Story (name) VALUES ('The Magical Forest');

-- Ahora creamos los capítulos
INSERT INTO chapter (title, solution, story_id, number)
VALUES
    ('Choose your path', 'Choose the correct path', 1, 1),
    ('Collect the items', 'Find all the hidden objects', 1, 2);

-- Creamos los niveles
INSERT INTO Level (story_id, chapter_id) VALUES (1, 1);

-- Insertamos el progreso
INSERT INTO Progress (user_id, story_id, level_id) VALUES (1, 1, 1);


-- Insertamos tipos de solución
INSERT INTO SolutionType (name) VALUES
                                    ('unique_solution'),
                                    ('select_combination'),
                                    ('select_sortable_combination'),
                                    ('hold_pressed'),
                                    ('drag_and_drop'),
                                    ('tap_once'),
                                    ('tap_twice'),
                                    ('resize'),
                                    ('write_word'),
                                    ('speak_word');


-- Finalmente insertamos las soluciones
INSERT INTO Solution (chapter_id, solution_type_id) VALUES
                                                        (1, 5), -- select_correct
                                                        (2, 1); -- drag_and_drop

-- Resto de las inserciones...
INSERT INTO Coordinates (x, y, z) VALUES (0.0, 0.0, 0.0);
INSERT INTO AssetType (type) VALUES ('narrator'), ('npc'), ('prop'), ('landscape');
INSERT INTO Asset (coordinates_id, image_id, audio_id, level_id, asset_type_id)
VALUES
    (1, 'forest.png', NULL, 1, 1),
    (1, NULL, 'intro.mp3', 1, 2);

INSERT INTO translation (language_id, text)
VALUES
    (1, 'Welcome to the magical forest!'),
    (2, '¡Bienvenido al bosque mágico!');

-- Luego puedes usar:
select * from asset a
    INSERT INTO script   (
    asset_id, text, isSolution, isButton, sortOrderSolution,
    solutionType_id, translation_id, sqlRaw
) VALUES (
    1, 'This is the image of the path', true, false, 1, 5, 1, NULL
    ),
    (
    2, 'Intro audio to explain the chapter', false, false, NULL, NULL, 2, NULL
    );