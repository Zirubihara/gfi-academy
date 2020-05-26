INSERT INTO USER_TABLE (ID, USER_LOGIN, FULLNAME)
VALUES (user_seq.nextval, 'armn', 'NeilArmstrong');
INSERT INTO NOTE (ID, TITLE, IMPORTANCE, TEXT, CREATION_DATE, MODIFICATION_DATE, USER_ID)
VALUES (note_seq.nextval, 'Sterowanie lądownikiem', 'HIGH',
        'Rozdział 8 w podręczniku pilota zawiera informacje na temat sterowania lądownikiem', CURRENT_TIMESTAMP,
        CURRENT_TIMESTAMP, USER_SEQ.currval);

INSERT INTO NOTE (ID, TITLE, IMPORTANCE, TEXT, CREATION_DATE, MODIFICATION_DATE, USER_ID)
VALUES (note_seq.nextval, 'Wskaźniki tlenu', 'NORMAL',
        'Wskaźniki te są bardzo ważne. Pokazują procentową zawartość tlenu w powietrzu wewnątrz statku',
        CURRENT_TIMESTAMP, CURRENT_TIMESTAMP, USER_SEQ.currval);

INSERT INTO USER_TABLE (ID, USER_LOGIN, FULLNAME)
VALUES (user_seq.nextval, 'alde', 'Edwin Aldrin');
INSERT INTO NOTE (ID, TITLE, IMPORTANCE, TEXT, CREATION_DATE, MODIFICATION_DATE, USER_ID)
VALUES (note_seq.nextval, 'Nawigacja bez przyżądów', 'LOW',
        'Do nawigacji po awarii przyżądów należy wykorzystać pozycję księżyca, słońca i ziemi', CURRENT_TIMESTAMP,
        CURRENT_TIMESTAMP, USER_SEQ.currval);

INSERT INTO USER_TABLE (ID, USER_LOGIN, FULLNAME)
VALUES (user_seq.nextval, 'colm', 'Michael Colling');
INSERT INTO NOTE (ID, TITLE, IMPORTANCE, TEXT, CREATION_DATE, MODIFICATION_DATE, USER_ID)
VALUES (note_seq.nextval, 'Koordynaty lądowania', 'HIGH',
        'Należy wybrać teren płaski pozwalający na stabilne ustawienie lądownik na powierzchni księżyca',
        CURRENT_TIMESTAMP,
        CURRENT_TIMESTAMP, USER_SEQ.currval);
