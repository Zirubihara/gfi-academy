**Witaj w repozytorium Akademii GFI**

Aby pobrać to repozytorium wpisz komendę

`git clone https://mmaksymiuk@bitbucket.org/mmaksymiuk/gfi-academy.git`

Linki wykorzystywane podczas szkolenia

- https://projectlombok.org/
- https://mvnrepository.com/
- https://start.spring.io/


**Zadanie 1. : Import i uruchomienie projektu**
 
Pierwszym zadaniem jest otwarcie projektu w IDE Intellij IDEA.
Plik pom.xml powinien zostać rozpoznany przez IDE i powinno rozpocząć się pobieranie bibliotek.
Jeśli do tego nie doszło. Kliknij na plik pom.xml PPM i wybierz opcję: *Add as Maven Project*

![Import Maven](./img/import_maven.png)

Po prawej stronie zostanie dodana zakładka Maven.
W każdej chwili, aby ręcznie wymusić odświeżenie projektu (w tym pobranie bibliotek) kliknij na przycisk nr 1.
Zaznaczenie nr 2, pokazuje jaki projekt został zaimportowany.
Klikając w nazwę (nr 3) zakładki możemy ją zwinąć lub rozwinąć.

Po imporcie projektu uruchom projekt.
W tym celu przejdź do klasy **MyNoteApp.java** i uruchom metodę **main**.

Zadanie jest zaliczone w momencie wyświetlenia w consoli logów informacji:
`Started MyNoteApp in 3.69 seconds (JVM running for 4.459)`
oraz otwarciu w przeglądarce linku

 - http://localhost:8080/actuator/health
 
Jeśli przeglądarka wyświetla wiadomość w formacie JSON o treści:

`{"status":"UP"}`

Zatrzymaj aplikację `MyNoteApp`.
Możesz przejść do kolejnego zadania.
Pobierz branch **zadanie2**.

**Zadanie 2. : Zmiana property, definiowanie własnych property, odczyt wartości przez adnotacje @Value**

Domyślnym plikiem wczytywanym przez framework SpringBoot jest **application.properties** z katalogu resources.
Więcej o kolejności ładowania konfiguracji znajdziesz pod linkiem: https://docs.spring.io/spring-boot/docs/2.1.13.RELEASE/reference/html/boot-features-external-config.html

Wyłącz logo spring które wyświetlane jest w konsoli logów.

Property `spring.main.banner-mode` musi mieć wartość `off`

Uruchom aplikację i sprawdź czy banner spring został wyłączony.

Zmień wartości custom properties, które są wyświetlane w konsoli jak poniżej:

`+++++ Custom String value = [default] +++++`

`+++++ Custom Long value = [0] +++++`
 
Ustaw wartości property w pliku application.properties:
 - `custom.string`
 - `custom.long`
 
Twoje wartości powinny pojawić się w konsoli.

Sprawdź co się stanie jeśli pod wartość liczbową podstawisz wartość, która nie jest liczbą całkowitą.

Sprawdź co się stanie jeśli property nie będzie ustawione w pliku application.properties oraz w pliku **MainConfiguration**
wartość adnotacji `@Value("${custom.string:default}")` zmienisz do `@Value("${custom.string}")`

Pobierz branch **zadanie3**