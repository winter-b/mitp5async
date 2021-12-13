# MIPT praktikos darbas #5

XML/JSON (pasirinktinai) formato duomenų nuskaitymas ir apdorojimas iš interneto svetainės
Naudojant „Android Studio“ integruotą programavimo aplinką (IDE), sukurti programėlę, kuri nuskaitytų valiutų kursus iš pasirinkto puslapio (pvz. ECB) ir pateiktų juos vartotojui. Programėlė turi tenkinti šiuos reikalavimus.
## Bendroji dalis:
1)	Kintamųjų, metodų, klasių pavadinimai turi būti rašomi anglų kalba;
2)	Elementai turi turėti prasmingus pavadinimus (pvz. txtName vs EditText1);
3)	Kodas rašomas naudojant Java programavimo kalbos standartus e.g.
•	Kintamieji pradedami rašyti mažąja raide (pvz. txtUserName);
•	Konstantos rašomos didžiosiomis raidėmis atskiriant tarpais (pvz. OPT_CHARS);
•	Metodai rašomi pradedant mažąja raide (pvz. getWordsCount(String option));
4)	Visi metodai turi išvedinėti pranešimus apie jų iškvietimą į konsolės (console) langą; 
5)	Klaidų valdymo blokai (catch) turi išvedinėti pranešimus į konsolės (console) langą; 
## Specialioji dalis:
1)	Programėlėje turi būti šios klasės: 
•	MainActivity (Activity) – atvaizduoja nuskaitytus duomenis. Duomenų atvaizdavimui naudojamas ListView elementas (kiekvienam valiutos kurso įrašui yra sukuriamas atskiras ListViewItem elementas). Šiame elemente turi būti rodomas valiutos kursas ir kodas pvz. „USD – 1.235“.
•	DataLoader –  klasė skirta asinchroniniam duomenų nuskaitymui iš interneto svetainės/API (pvz. AsyncTask / Bound Service/ Started Service).
•	Parser – klasė skirta XML/JSON srauto nuskaitymui ir reikiamos informacijos išgavimui. XML srauto nuskaitymui naudoti DOM/SAX būdus pasirinktinai.
