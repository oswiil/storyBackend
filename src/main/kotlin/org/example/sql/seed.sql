TRUNCATE TABLE
    Script,
    Translation,
    Asset,
    AssetType,
    Coordinates,
    Solution,
    SolutionType,
    Chapter,
    Level,
    Progress,
    Story,
    UserAccount,
    Profile,
    Language
RESTART IDENTITY CASCADE;


-- Idiomas
INSERT INTO Language (name) VALUES ('English'), ('Spanish');

-- Perfiles
INSERT INTO Profile (plan) VALUES ('free'), ('premium');

-- Usuario de prueba (Inglés, perfil premium)
INSERT INTO UserAccount (language_id, profile_id) VALUES (1, 2);

-- Historia
INSERT INTO Story (name) VALUES ('The Magical Forest');

-- Capítulos
INSERT INTO Chapter (title, solution, story_id, number)
VALUES
    ('Choose your path', 'Choose the correct path', 1, 1),
    ('Collect the items', 'Find all the hidden objects', 1, 2);

-- Nivel
INSERT INTO Level (story_id, number_chapter) VALUES (1, 1);

-- Progreso de usuario
INSERT INTO Progress (user_id, story_id, level_id) VALUES (1, 1, 1);

-- Tipos de solución (Solution Catalog)
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

-- Soluciones asociadas a los capítulos
INSERT INTO Solution (chapter_id, solution_type_id) VALUES
                                                        (1, 5), -- select_correct
                                                        (2, 1); -- drag_and_drop

-- Coordenadas y tipos de asset
INSERT INTO Coordinates (x, y, z) VALUES (0.0, 0.0, 0.0);
INSERT INTO AssetType (type) VALUES ('narrator'), ('npc'),  ('prop'), ('landscape');

-- Assets
INSERT INTO Asset (coordinates_id, image_id, audio_id, level_id, asset_type_id)
VALUES
    (1, 'forest.png', NULL, 1, 1),
    (1, NULL, 'intro.mp3', 1, 2);

-- Traducciones
INSERT INTO Translation (language_id, text)
VALUES
    (1, 'Welcome to the magical forest!'),
    (2, '¡Bienvenido al bosque mágico!');

-- Scripts relacionados a los assets
INSERT INTO Script (
    asset_id, text, isSolution, isButton, sortOrderSolution,
    solutionType_id, translation_id, sqlRaw
) VALUES
      (
          1, 'This is the image of the path', true, false, 1, 5, 1, NULL
      ),
      (
          2, 'Intro audio to explain the chapter', false, false, NULL, NULL, 2, NULL
      );
