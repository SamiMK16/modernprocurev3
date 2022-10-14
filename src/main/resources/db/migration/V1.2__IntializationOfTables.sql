CREATE SEQUENCE if not exists hibernate_sequence START 1;
INSERT INTO team (web_id, version, date_created, date_updated, active, age, email, first_name, gender, last_name,
                  phone_number, role, address,
                  password)
VALUES (1, 0, now(), now(), true, 18, 'admin@TEST01.com', 'Support', 'male', 'User', '034994994', 'Admin',
        'testAddress', 'password');
INSERT INTO tracker (web_id, version, date_created, date_updated, title, amount, participant, start_time,
                     end_time)
VALUES (1, 0, now(), now(), 'Support Title', 10, 'Test', '02:20', '04:40');
INSERT INTO project (web_id, version, date_created, date_updated, amount, client, project_name)
VALUES (1, 0, now(), now(), 10, 'test Client', 'Mobile App Development');
INSERT INTO client (web_id, version, date_created, date_updated, clientName, client_number, description, active,
                    address, email)
VALUES (0, 0, now(), now(), 'TEST', 'TEST', 'Test', true, 'Test Address', 'test@client.com');
INSERT INTO role (web_id, version, date_created, date_updated, external_key, role_code, title,
                  description, use, active)
VALUES (1, 0, '2022-04-28 20:52:46.889390', '2022-04-28 20:52:46.889390', 'ROLE_SUPER_ADMIN', null, 'Super Admin',
        'Super Admin', 'STAFF', true);
INSERT INTO role (web_id, version, date_created, date_updated, external_key, role_code, title,
                  description, use, active)
VALUES (2, 0, '2022-04-28 20:52:46.889390', '2022-04-28 20:52:46.889390', 'ROLE_SUPPORT_USER', null, 'Support User',
        'Support User', 'STAFF', true);
INSERT INTO permission (web_id, version, date_created, date_updated, permission_code, title,
                        description, permission_group_id, use, active)
VALUES (1, 0, '2022-04-28 15:52:46.889390 +00:00', '2022-04-28 15:52:46.889390 +00:00', 'APP:TRACKER:CREATE',
        'APP:TRACKER:CREATE', 'Create permission for the user in the app', 1, 'STAFF', true);
INSERT INTO permission (web_id, version, date_created, date_updated, permission_code, title,
                        description, permission_group_id, use, active)
VALUES (2, 0, '2022-04-28 15:52:46.889390 +00:00', '2022-04-28 15:52:46.889390 +00:00', 'APP:SHEET:CREATE',
        'APP:SHEET:CREATE', 'User can create customer', 1, 'STAFF', true);
INSERT INTO permission (web_id, version, date_created, date_updated, permission_code, title,
                        description, permission_group_id, use, active)
VALUES (3, 0, '2022-04-28 15:52:46.889390 +00:00', '2022-04-28 15:52:46.889390 +00:00', 'APP:CALENDER:CREATE',
        'APP:CALENDER:CREATE', 'View permission for the user in the app', 1, 'STAFF', true);
INSERT INTO permission (web_id, version, date_created, date_updated, permission_code, title,
                        description, permission_group_id, use, active)
VALUES (4, 0, '2022-04-28 15:52:46.889390 +00:00', '2022-04-28 15:52:46.889390 +00:00', 'APP:USER:CREATE',
        'APP:USER:CREATE', 'Update permission for the user in the app', 1, 'STAFF', true);
INSERT INTO permission (web_id, version, date_created, date_updated, permission_code, title,
                        description, permission_group_id, use, active)
VALUES (5, 0, '2022-06-01 07:34:06.833000 +00:00', '2022-06-01 07:34:06.833000 +00:00', 'APP:DASHBOARD:CREATE',
        'APP:DASHBOARD:CREATE', 'Dashboard permissions for user', 1, 'STAFF', true);
INSERT INTO permission (web_id, version, date_created, date_updated, permission_code, title,
                        description, permission_group_id, use, active)
VALUES (6, 0, '2022-05-22 08:08:42.182000 +00:00', '2022-05-22 08:08:42.182000 +00:00', 'APP:INVOICES:CREATE',
        'APP:INVOICES:CREATE', 'Customer can create an appointment', 1, 'CUSTOMER', true);
INSERT INTO permission (web_id, version, date_created, date_updated, permission_code, title,
                        description, permission_group_id, use, active)
VALUES (7, 0, '2022-06-01 08:03:42.440000 +00:00', '2022-06-01 08:03:42.440000 +00:00', 'APP:PROJECT:CREATE',
        'APP:PROJECT:CREATE', 'User can create location', 1, 'STAFF', true);
INSERT INTO role_permission (web_id, version, date_created, date_updated, role_id, permission_id)
VALUES (1, 0, '2022-05-21 12:22:54.692000 +00:00', '2022-05-21 12:22:54.692000 +00:00', 1, 1);
INSERT INTO role_permission (web_id, version, date_created, date_updated, role_id, permission_id)
VALUES (2, 0, '2022-05-21 12:23:05.388000 +00:00', '2022-05-21 12:23:05.388000 +00:00', 1, 2);
INSERT INTO role_permission (web_id, version, date_created, date_updated, role_id, permission_id)
VALUES (3, 0, '2022-05-21 12:23:09.052000 +00:00', '2022-05-21 12:23:09.052000 +00:00', 1, 3);
INSERT INTO role_permission (web_id, version, date_created, date_updated, role_id, permission_id)
VALUES (4, 0, '2022-05-21 12:23:13.452000 +00:00', '2022-05-21 12:23:13.452000 +00:00', 1, 4);
INSERT INTO role_permission (web_id, version, date_created, date_updated, role_id, permission_id)
VALUES (5, 0, '2022-05-22 08:09:00.052000 +00:00', '2022-05-22 08:09:00.052000 +00:00', 1, 5);
INSERT INTO role_permission (web_id, version, date_created, date_updated, role_id, permission_id)
VALUES (6, 0, '2022-05-21 12:23:05.388000 +00:00', '2022-05-21 12:23:05.388000 +00:00', 1, 6);
INSERT INTO role_permission (web_id, version, date_created, date_updated, role_id, permission_id)
VALUES (7, 0, '2022-05-21 12:23:05.388000 +00:00', '2022-05-21 12:23:05.388000 +00:00', 1, 7);
INSERT INTO role_permission (web_id, version, date_created, date_updated, role_id, permission_id)
VALUES (8, 0, '2022-05-21 12:23:05.388000 +00:00', '2022-05-21 12:23:05.388000 +00:00', 2, 1);
INSERT INTO web_user (web_id, date_created, date_updated, version, active, dob, email, first_name, gender,
                      last_name, password, phone, status)
VALUES (1, '2022-06-01 21:16:29.861000 +00:00', '2022-06-01 21:16:30.816000 +00:00', 0, true, null,
        'admin@admin.com', 'admin', null, 'user', '$2a$10$CkQY8PpSb2tvPHnAnXb3ju00RZec4ivvrfSilQLywJFs2PYqWqAu6',
        '3030123204', 0);
INSERT INTO web_user_role (web_id, version, date_created, date_updated, web_user_id, role_id, active)
VALUES (2, 0, '2022-04-28 15:52:46.889390 +00:00', '2022-04-28 15:52:46.889390 +00:00', 1, 1, true);
