-- -----------------------------------------------------
-- Seed Data Loader MakeMyStay
-- -----------------------------------------------------
-- This a DB data loader for CMSC 495 6380 Group 5's final project.
-- 
-- Team members --
-- Deepak Galami 
-- Chris Kearney
-- Chris Ruark
-- Josh Seaton
-- 
-- The "Make My Stay" Product concept and software design is exclusively the work of this team and may not be reused/reformulated/refactored without unanimous consent of Group 5 in hardcopy writing. 

/* Loads 3x user types */
INSERT INTO
usertype
VALUES
(1,"Property Owner"),
(2,"Customer"),
(3,"SysAdmin"),
(4,"Test Engineer");

/* Loads 10X users */ 
INSERT INTO 
user
VALUES
(1,4,"TesterA","Test1234","test@mms.com","McTesty","Testy",DATE_ADD(NOW(), INTERVAL -10 DAY),0),
(2,1,"IronEagle","F16sRule","doug.mcmasters@gmail.com","Masters","Doug",DATE_ADD(NOW(), INTERVAL -9 DAY),0),
(3,1,"Maverick","F14Knucklehead","pete.mitchell@gmail.com","Mitchell","Pete",DATE_ADD(NOW(), INTERVAL -8 DAY),0),
(4,1,"Goose","F14RioGuru","nick.bradshaw@gmail.com","Bradshaw","Nick",DATE_ADD(NOW(), INTERVAL -7 DAY),0),
(5,2,"Iceman","F14Master","tom.kazansky@gmail.com","Kazansky","Tom",DATE_ADD(NOW(), INTERVAL -6 DAY),0),
(6,2,"Slider","F14Stink","ron.kerner@gmail.com","Kerner","Ron",DATE_ADD(NOW(), INTERVAL -5 DAY),0),
(7,2,"Viper","Viper","mike.metcalf@gmail.com","Metcalf","Michael",DATE_ADD(NOW(), INTERVAL -4 DAY),0),
(8,3,"Hollywood","Hollywood","mike.neven@gmail.com","Neven","Mike",DATE_ADD(NOW(), INTERVAL -3 DAY),0),
(9,3,"Stinger","RubberDogShtuff","tom.jardian@gmail.com","Jardian","Tom",DATE_ADD(NOW(), INTERVAL -2 DAY),0),
(10,3,"Charlie","TACREPsRule","charlotte.blackwood@gmail.com","Blackwood","Charlotte",DATE_ADD(NOW(), INTERVAL -1 DAY),0); 

/* Load 5X quality descriptors */
INSERT INTO qualitydescriptor
VALUES
(1,"Poor","Not Recommended",10),
(2,"Below Average","Some Imperfections to Be Expected",20),
(3,"Average", "Average",30),
(4,"Excellent","Recommended",40),
(5,"Exceptional","Highly-recommended",50);

/* Load 6X properties */
INSERT INTO property
VALUES
(1,2,"The America","A 100-room property renovated in 2009","Western US","10 Ring Road","San Dimas","CA","91173","1.800.123.1234",0),
(2,2,"The Dust Bowl","A spaceous resort filled with things for kids to do while parents relax","Western US","1 King Ridge Way","San Francisco","CA","91854","1.800.123.9658",0),
(3,3,"The Duldrums","A boring place to stay","Central US","23445 Industrial Stink Parkway","Chicago","IL","60605","1.800.858.6598",0),
(4,3,"The Capri Sun","Drink in the Sun with us!","Central US","6545 Shermann Ave","Cincinnati","OH","45858","1.800.787.4541",0),
(5,4,"The Lost Trail Ranch","Come stay with us buckaroos!","Central US","458 Why Not Way","Viola","IN","43258","1.808.965.5689",0),
(6,4,"The Flying W Ranch","Howdy Partner! Y'all should stay here","Soutern US","458 Shaq-Lebron Parkway","Miami","FL","33166","1.777.858.9632",0);

/* Loads 15X rooms */
INSERT INTO
room
VALUES
(1234,1,"",5,0),
(1235,1,"",5,0),
(1236,1,"",5,0),
(1237,1,"",5,0),
(1238,1,"",5,0),
(1134,3,"",5,0),
(1135,3,"",5,0),
(1136,3,"",5,0),
(1137,3,"",5,0),
(1138,3,"",5,0),
(834,5,"The Green Room with Garden P",5,0),
(835,5,"The Red Room with Roses",5,0),
(836,5,"The Purple Room with Purple Everything",5,0),
(837,5,"The Yellow Room with Paisley Carpet",5,0),
(838,5,"the White Room with Black Curtains",5,0);

/* Loads 15X price discount per-diem factors */ 
INSERT INTO
perdiemrate
VALUES
(1,1,1234,"2018",now(),0.98),
(2,1,1235,"2018",now(),0.97),
(3,1,1236,"2018",now(),0.96),
(4,1,1237,"2018",now(),0.95),
(5,1,1238,"2018",now(),0.98),
(6,3,1134,"2018",now(),0.97),
(7,3,1135,"2018",now(),0.96),
(8,3,1136,"2018",now(),0.95),
(9,3,1137,"2018",now(),0.98),
(10,3,1138,"2018",now(),0.97),
(11,5,834,"2018",now(),0.96),
(12,5,835,"2018",now(),0.95),
(13,5,836,"2018",now(),0.98),
(14,5,837,"2018",now(),0.97),
(15,5,838,"2018",now(),0.96);

/* Loads 7X resevation status codes */ 
INSERT INTO
reservationstatus
VALUES
(1,"Requested",""),
(2,"Pending",""),
(3,"Received",""),
(4,"Confirmed",""),
(5,"Checked-in",""),
(6,"Checked-out",""),
(7,"Cancelled","");

/* Loads 6X property quality ratings */ 
INSERT INTO 
descriptorselection
VALUES
(1,1,1,0),
(2,3,1,0),
(3,2,3,0),
(4,4,3,0),
(5,5,5,0),
(6,6,5,0);

/* Loads 5X reservations */ 

-- END OF THE STARTING DATABASE RECORDS. ANY DELTAS ARE NEW DATA.
