# JavaFXGame
## Technologie ##
- JavaFX
- SQLite
## Autorzy ##
- Aleksandra Stawarz
- Agata Mazur
- Jagoda Kubacka
## Opis gry ##
Gra stworzona przy użyciu technologii JavaFX polegająca na łapaniu spadających elementów w różnych kształtach i kolorach. Gracz porusza koszykiem w dolnej częsci ekranu przy pomocy strzałek prawo-lewo nakierowując swój "koszyk" w odpowiednie miejsce na ekranie. Posiada dwa tryby rozgrywki:
- refleks 
- zbieranie </br>
Dodatkowo pozwala na stworzenie rankingu graczy - po podaniu imienia punkty z gry refleks są zapisywane i wyświetlane w osobnym oknie.

### Ekran główny ###
![Ekran główny](https://raw.githubusercontent.com/OlaStawarz/JavaFXGame/master/Images/mainstage.PNG) <br/>

### Zbieranie ###
W trybie zbieranie losowo generowane są warunki, które gracz musi spełnić, aby wygrać. Może być to np. zebranie 5 niebieskich kół, 5 zielonych trójkątów i 5 czerwonych kwadratów. Zebranie elementu nie spełniającego warunków gry lub przekroczenie liczby elementów do zebrania skutkuje przegraną. </br>
![Tryb rozgrywki - zbieranie](https://raw.githubusercontent.com/OlaStawarz/JavaFXGame/master/Images/collectgame.PNG) <br/>

### Refleks ###
W grze refleks użytkownik musi łapać wszystkie spadające elementy - w przypadku ominięcia jednego z nich gra kończy się. </br>
![Tryb rozgrywki - refleks](https://raw.githubusercontent.com/OlaStawarz/JavaFXGame/master/Images/reflex.PNG) <br/>

### Przegranie/wygranie
![Wygrana](https://raw.githubusercontent.com/OlaStawarz/JavaFXGame/master/Images/win.PNG) <br/>
![Przegrana](https://raw.githubusercontent.com/OlaStawarz/JavaFXGame/master/Images/lost.PNG) <br/>

### Ranking 
W budowie

## Zrealizowane zadania ##
- [x] Stworzenie planszy
- [x] Dodanie opcji poruszania się koszyka
- [x] Dodanie spadających elementów, losowe generowanie miejsca startu spadania
- [x] Utworzenie elementów w różnych kształtach i kolorach
- [x] Oprogramowanie dwóch trybów rozgrywki
- [x] Dodanie warunków pozwalających na wygranie oraz przegranie
- [x] Połączenie z bazą danych SQLite
- [ ] Wyświetlanie rankingu
- [ ] Wizualne uatrakcyjnienie poszczególnych ekranów
