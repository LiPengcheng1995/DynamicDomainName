PRAGMA foreign_keys=OFF;
BEGIN TRANSACTION;
CREATE TABLE mapping(
id integer primary key autoincrement not null,
ip text,
domainName text,
description text,
ifActive none);
INSERT INTO mapping VALUES(1,'127.0.0.1','lipengcheng.com','this is my website','true');
DELETE FROM sqlite_sequence;
INSERT INTO sqlite_sequence VALUES('mapping',1);
COMMIT;
