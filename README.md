- Napisz aplikację, która będzie służyć jako pomoc dla restauracji
- Aplikacja powinna mieć dostępne REST API, przez które będzie można wchodzić z nią w interakcje
- Wszystkie dane powinny być zapisywane w bazie danych
- Aplikacja powinna przechowywać następujące dane:
    - Menu (wszystkie dostępne potrawy z ich nazwą, opisem, aktualną ceną oraz informacją czy są jeszcze w sprzedaży)
    - Karta napojów (nazwa, opis, aktualna cena, porcja w mililitrach, informacja czy jest jeszcze w sprzedaży)
    - Pracowników (imię, nazwisko, pesel, stanowisko, pensja oraz relacje szef-pracownik)
    - Klientów (imię, nazwisko, stała zniżka)
    - Stan magazynu (nazwa produktu, ilość w sztukach lub dowolnej innej jednostce, np. kg, litry)
    - Rachunki (wydane w ramach danego rachunku potrawy i napoje, łączna cena wraz ze zniżką, napiwek, obsługującego kelnera, klienta, datę wystawienia rachunku - to powinna zawsze być data dodania wpisu do bazy danych)
- Wszystkie powyższe dane powinny być dostępne w postaci zasobów REST'owych. 
- Aplikacja pozwala na wyświetlanie, usuwanie, modyfikowanie i dodawanie tychże zasobów
- Dane wyświetlane / wysyłane są w formacie JSON
- API zaprojektowane jest zgodnie z architekturą REST (tj. np. użyte odpowiednie metody HTTP)
- Model relacyjnej bazy danych zgodny z omawianymi na zajęciach zasadami (odpowiednie relacje, klucze główne, obce itp.)
- Wykorzystane technologie Spring, Spring Boot, Spring Data, Hibernate, Maven, Git, GitLab
- Projekt w katalogu resources powinien zawierać skrypt SQL inicjalizujący odpowiednią strukturę bazy danych
- Projekt grupowy
- Historia w Gicie zawierająca commity wszystkich osób w grupie
- Merge request na GitLabie
- Pamiętajmy o odpowiednim formatowaniu plików i usuwaniu niepotrzebnego kodu!
- Pamiętajmy o zwracaniu odpowiednich typów z poszczególnych klas i metod!