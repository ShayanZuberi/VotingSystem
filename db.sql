select sysdate from dual;
select * from citizen;

--making a citizen table
CREATE TABLE citizen(
    cnic VARCHAR(50) NOT NULL,
    PRIMARY KEY(cnic));


CREATE TABLE party(
    party_id NUMBER(5) PRIMARY KEY NOT NULL,
    name VARCHAR (50));

CREATE TABLE vote(
    cnic VARCHAR(50) NOT NULL,
    party_id NUMBER(5) NOT NULL,
    FOREIGN KEY (cnic) REFERENCES citizen(cnic),
    FOREIGN KEY (party_id) REFERENCES party(party_id)
);

INSERT INTO party values (1, 'PTI');
INSERT INTO party values (2, 'PMLN');
INSERT INTO party values (3, 'PPP');
INSERT INTO party values (4, 'TLP');
