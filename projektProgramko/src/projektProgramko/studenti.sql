CREATE TABLE IF NOT EXISTS studenti(
	ID INTEGER PRIMARY KEY AUTOINCREMENT,
	
	jmeno NVARCHAR NOT NULL,
	prijmeni NVARCHAR NOT NULL,
	rokNarozeni INTEGER NOT NULL,
	
	skupina_id INTEGER,
	FOREIGN KEY (skupina_id) REFERENCES skupina(ID)
);