create database quizz;
use quizz;

CREATE TABLE comp(
	QID INT NOT NULL primary key AUTO_INCREMENT, 
    QT CHAR(255),
    optA CHAR(255),
    optB CHAR(255),
    optC CHAR(255),
    optD CHAR(255)
);

CREATE TABLE math(
	QID INT NOT NULL primary key AUTO_INCREMENT, 
    QT CHAR(255),
    optA CHAR(255),
    optB CHAR(255),
    optC CHAR(255),
    optD CHAR(255)
);

INSERT INTO comp
(QID, QT, optA, optB, optC, optD) values
(1, 'What is smallest unit of the information?','A bit', 'A byte', 'A block', 'A Nibble'),
(2, 'A process is a ?', 'single thread of execution', 'program in the execution', 'program in the memory', 'task'),
(3, 'BIOS is used?', 'By operating system', 'By compiler', 'By interpreter', 'By application software'),
(4, 'Which one of the following is the best fire extinguisher for IT equipment?', 'Dry powder', 'Bromo chloride', 'CO2', 'Water'),
(5, 'Which of the following is not a Java keyword?', 'static', 'try', 'Integer', 'new');


INSERT INTO math
(QID, QT, optA, optB, optC, optD) values
(1, 'What is the sum of 130+125+191?','335', '456', '446', '426'),
(2, '20+(90÷2) is equal to?', '50', '55', '65', '60'),
(3, 'Which of the following triangles have the same side lengths?', 'Scalene', 'Isosceles', 'Equilateral', 'None of these'),
(4, 'The value of tan 60°/cot 30° is equal to?', '0', '1', '2', '3'),
(5, 'The probability of event equal to zero is called?', 'Unsure event', 'Sure Event', 'Impossible event', 'Independent event');

CREATE TABLE compAns(
	AID INT NOT NULL, 
    Ans CHAR(255),
    QID int,
    primary key(AID),
    FOREIGN KEY (QID) REFERENCES comp(QID)
);

INSERT INTO compAns
(AID, Ans) values
(1, 'A bit'),
(2, 'program in the execution'),
(3, 'By operating system'),
(4, 'CO2'),
(5, 'Integer');


CREATE TABLE mathAns(
	AID INT NOT NULL, 
    Ans CHAR(255),
    QID int,
    primary key(AID),
    FOREIGN KEY (QID) REFERENCES math(QID)
);

INSERT INTO mathAns
(AID, Ans) values
(1, '446'),
(2, '65'),
(3, 'Equilateral'),
(4, '1'),
(5, 'Impossible event');
