# Android

Ma numesc Stefan C. Alexandru-Ioan din grupa IIIA7. 

Pe data de 18.03 am postat laboratorul 4.
  Am implementat functionalitatile pentru meniul creeat in laboratul 3. Avem un meniu cu mai multe optiuni.  
  Pe pagina 'Cos' daca dam click ne va duce intr-o noua pagina, cu un Intent am comunicat ultimul produs care a fost selectat in
  activitatea Main.
  Noua activitate "AddNewActivity" primeste prin Intent id-ul ultimului produs selectat. Aici ne este afisat un mesaj. Apoi ne apare un     AlertDialog care ne intreaba daca dorim sa cumparam un produs. Daca apasam pe "DA" ne va fi afisat in pagina raspunsul potrivit,
  daca apasam pe "NU" ne va fi afisat in pagina un alt raspuns. Dupa ce apasam pe "DA" sau "NU" Dialog-ul dispare.
  
Pe data de 25.03 am postat laboratorul 5
  Am creeat o noua activitate "Settings", intram din meniu in aceasta. De aici putem seta username-ul aplicatiei si sa-l stocam cu ajutorul SharedPreferences. Avem un textBox in care putem vedea numele actual din aplicatie. Am pus un editBox si un buton de submit. Completam numele user-ului si dam submit. Acesta va fi setat prin Shared Preferences. Va fi updatat numele actual din aplicatie si din textBox.
  Pentru partea a2a. Am creeat o baza de date cu Room. Am introdus in gradle.build dependentele. Am creeat clasa Product,
 ProductDAO si AppDatabase. In activitatea Main, produsele sunt acum luate din baza de date. Am creeate o functie "CreateDatabase" care 
 instantiaza baza de date( tot de aici am inserat produsele) si imi returneaza toate produsele din baza de date.
 
 
 Pe data de 30.03 am postat laboratorul 6
  Am creeat o noua activitate numita Sensors(care apare si in meniu ca si senzori), am accesat sensorii telefonului si am afisat o lista toti senzorii din SensorManager. Pt al 2 lea punct, am creeat o activitate de tip Google Maps, am luat API KEY de pe site-ul google. Activitatea se numeste Location(in tab-ul Map al meniului) si ni se afiseaza harta cu un marker in Iasi(am pus coordonatele din Iasi 47.151726, 27.587914).
