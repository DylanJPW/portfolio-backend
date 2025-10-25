
-- Mock Project Data --

INSERT INTO projects (name, description, repo_link, image_url, alt_text) VALUES ('Test Project 1', 'Some description', 'https://github.com/example', 'https://picsum.photos/id/1/300/200', 'Test Image');

INSERT INTO project_tags (project_id, tags) VALUES (1, 'Java');
INSERT INTO project_tags (project_id, tags) VALUES (1, 'Spring Boot');

INSERT INTO projects (name, description, repo_link, image_url, alt_text) VALUES ('Test Project 2', 'Some description', 'https://github.com/example', 'https://picsum.photos/id/2/300/200', 'Test Image');

INSERT INTO project_tags (project_id, tags) VALUES (2, 'Java');
INSERT INTO project_tags (project_id, tags) VALUES (2, 'Spring Boot');

INSERT INTO projects (name, description, repo_link, image_url, alt_text) VALUES ('Test Project 3', 'Some description', 'https://github.com/example', 'https://picsum.photos/id/3/300/200', 'Test Image');

INSERT INTO project_tags (project_id, tags) VALUES (3, 'Java');
INSERT INTO project_tags (project_id, tags) VALUES (3, 'Spring Boot');

-- Mock CV Data --

-- Insert CV (ID fixed to 1 so we can reference it)
INSERT INTO cv (summary, upload_date) VALUES ('Lorem ipsum dolor sit amet, consectetur adipiscing elit. Proin mollis, dolor id vehicula euismod, purus metus semper dolor, a tristique tortor nunc nec neque. Nam bibendum nulla in convallis hendrerit.', '2025-01-01 12:00:00');

-- Insert experiences (auto-generate IDs)
INSERT INTO experience (cv_id, company_name, start_date, end_date, position, description, image) VALUES (1, 'MOCK COMPANY 1', '2024-01-01', NULL, 'MOCK POSITION 1', 'Lorem ipsum dolor sit amet, consectetur adipiscing elit. Proin mollis, dolor id vehicula euismod, purus metus semper dolor, a tristique tortor nunc nec neque. Nam bibendum nulla in convallis hendrerit. Aenean nec ante et nisl mollis volutpat.', 'https://picsum.photos/id/1/300/200');
INSERT INTO experience (cv_id, company_name, start_date, end_date, position, description, image) VALUES (1, 'MOCK COMPANY 2', '2023-01-01', '2023-12-31', 'MOCK POSITION 2', 'Lorem ipsum dolor sit amet, consectetur adipiscing elit. Proin mollis, dolor id vehicula euismod, purus metus semper dolor, a tristique tortor nunc nec neque. Nam bibendum nulla in convallis hendrerit. Aenean nec ante et nisl mollis volutpat.', 'https://picsum.photos/id/1/300/200');
INSERT INTO experience (cv_id, company_name, start_date, end_date, position, description, image) VALUES (1, 'MOCK COMPANY 3', '2022-01-01', '2022-12-31', 'MOCK POSITION 3', 'Lorem ipsum dolor sit amet, consectetur adipiscing elit. Proin mollis, dolor id vehicula euismod, purus metus semper dolor, a tristique tortor nunc nec neque. Nam bibendum nulla in convallis hendrerit. Aenean nec ante et nisl mollis volutpat.', 'https://picsum.photos/id/1/300/200');
INSERT INTO experience (cv_id, company_name, start_date, end_date, position, description, image) VALUES (1, 'MOCK COMPANY 4', '2021-01-01', '2021-12-31', 'MOCK POSITION 4', 'Lorem ipsum dolor sit amet, consectetur adipiscing elit. Proin mollis, dolor id vehicula euismod, purus metus semper dolor, a tristique tortor nunc nec neque. Nam bibendum nulla in convallis hendrerit. Aenean nec ante et nisl mollis volutpat.', 'https://picsum.photos/id/1/300/200');

-- Insert skills (auto-generate IDs)
INSERT INTO skills (cv_id, name, type, years_experience, description) VALUES (1, 'Mock tech skill 1', 'HARD', 1, 'Lorem ipsum dolor sit amet, consectetur adipiscing elit.', 'https://picsum.photos/id/1/300/200');
INSERT INTO skills (cv_id, name, type, years_experience, description) VALUES (1, 'Mock tech skill 2', 'HARD', 2, 'Lorem ipsum dolor sit amet, consectetur adipiscing elit.', 'https://picsum.photos/id/1/300/200');
INSERT INTO skills (cv_id, name, type, years_experience, description) VALUES (1, 'Mock tech skill 3', 'HARD', 3, 'Lorem ipsum dolor sit amet, consectetur adipiscing elit.', 'https://picsum.photos/id/1/300/200');
INSERT INTO skills (cv_id, name, type, years_experience, description) VALUES (1, 'Mock tech skill 4', 'HARD', 4, 'Lorem ipsum dolor sit amet, consectetur adipiscing elit.', 'https://picsum.photos/id/1/300/200');
INSERT INTO skills (cv_id, name, type, years_experience, description) VALUES (1, 'Mock tech skill 5', 'HARD', 5, 'Lorem ipsum dolor sit amet, consectetur adipiscing elit.', 'https://picsum.photos/id/1/300/200');
INSERT INTO skills (cv_id, name, type, years_experience, description) VALUES (1, 'Mock soft skill 1', 'SOFT', 0, 'Lorem ipsum dolor sit amet, consectetur adipiscing elit.', 'https://picsum.photos/id/1/300/200');
INSERT INTO skills (cv_id, name, type, years_experience, description) VALUES (1, 'Mock soft skill 2', 'SOFT', 0, 'Lorem ipsum dolor sit amet, consectetur adipiscing elit.', 'https://picsum.photos/id/1/300/200');
INSERT INTO skills (cv_id, name, type, years_experience, description) VALUES (1, 'Mock soft skill 3', 'SOFT', 0, 'Lorem ipsum dolor sit amet, consectetur adipiscing elit.', 'https://picsum.photos/id/1/300/200');
INSERT INTO skills (cv_id, name, type, years_experience, description) VALUES (1, 'Mock soft skill 4', 'SOFT', 0, 'Lorem ipsum dolor sit amet, consectetur adipiscing elit.', 'https://picsum.photos/id/1/300/200');
INSERT INTO skills (cv_id, name, type, years_experience, description) VALUES (1, 'Mock soft skill 5', 'SOFT', 0, 'Lorem ipsum dolor sit amet, consectetur adipiscing elit.', 'https://picsum.photos/id/1/300/200');
