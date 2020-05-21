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

**Zadanie 3. : Ustawienia logów, logback - plik konfiguracyjny**

Zapoznaj się z poniższą tabelką poziomów logowania

![Import Maven](./img/logLevel.png)

SpringBoot dostarcza biblioteki potrzebne do używania loggerów, a Lombok skraca dodawanie logger do dodania adnotacji nad klasą.

`Logger log = LoggerFactory.getLogger(MainConfiguration.class);`

można zastąpić

`@Slf4j`

Aby zmienić poziom logowania z poziomu property wystarczy dodać wpis:
`logging.level.nazwa_logger=POZIOM_LOGOWANIA`

Poziom logowania można wybrać zgodnie z tabelką.

Użycie logów znajdziesz w klasie **MainConfiguration**

W pliku **application.properties** zmień poziom logowania
`logging.level.myLogger` na DEBUG i uruchom/zerestartuj aplikację. Obserwuj logi konsoli.

Odkomentuj linię `logging.config=classpath:./logging.xml` i zrestartuj aplikację.
Czy w projekcie pojawił się nowy plik o nazwie `logFile.log`?

Sprawdź zawartość pliku `logging.xml` w katalogu resources.

Pobierz branch **zadanie4**

**Zadanie 4. : Adnotacje springa, beany i kontener IoC**

Kontener IoC (eng. Inversion of Controll) pozwala na definiowanie klas i używanie ich obiektów bez myślenia o ich inicjalizacji.

W większości przypadków nie będziemy nigdzie korzystać ze słowa kluczowego **new**

**@Configuration** wskazuje klasę konfiguracji, która powinna definiować przynajmniej jeden bean.

Czym jest bean? To obiekt zarządzany przez Spring Framework. Jest to instancja klasy.

**@Bean** adnotacja nad metodą, która definiuje nowego beana.

**@Service, @Controller, @Repository** - adnotacje nad klasą, prototypy logiczne, spełniają tą samą funkcję, wskazują aby utworzyć bean-a na podstawie tej klasy

**@Autowired** - może być użyty nad polem, metodą (setter), konstruktorem (zalecane), wskazuje, gdzie należy wstrzyknąć bean-a.

**Do poczytania**:
 - zakresy beanów - bean scopes (singleton - domyślny, prototype) oraz (request, session)
 - zasady wstrzykiwania (po typie, po nazwie, po qualifier) - @Qualifier oraz @Bean(name="")
 
Ćwiczenie.

Używając adnotacji @Autowired i @Service zainicjalizuj klasę `OtherService` tak, aby w konsoli pojawiło się drukowanie imiona z klasy `UserService`

Używając adnotacji @Bean zainicjalizuj w klasie `MainConfiguration` drugą instancję serwisu `OtherService`.

Jeśli w logu konsoli posiadasz dwa razy wpis:
```
===== Printing name in UserService.
===== Name is: NAME FROM NOTE
```

pobierz branch **zadanie5**

**Zadanie 5. : @RestController, @RequestMapping, @GetMapping, parametry**

Adnotacja @RestController pochodzi z `spring-boot-starter-web`.
Biblioteka zawiera wbudowany serwer tomcat. Jest to serwer z kontenerem servletów.
Dodatkowo wprowadza wszystkie konfiguracje wymagane, do wystawienia kontrolera REST.

Klasa `ExampleServlet` pokazuje przykład inicjalizowania servletu java. 
Nie będzie on działać przy obecnej konfiguracji.
Ma zadanie zaprezentować implementację servletu od podstaw.

Ćwiczenie
Uruchom aplikację i w przeglądarce otwórz link:
http://localhost:8080/note
Teraz otwórz link
http://localhost:8080/note/TUTAJ_TWÓJ_PARAMETR

W klasie `UserController` dodaj odpowiednie adnotacje i 2 metody odpowiadające na żądania GET
- Pierwsza metoda ma odpowiadać pod URI `/user` i zwracać listę osób (jako typ zwracany ustaw List<String>)
- Druga metoda ma odpowiadać pod URI `/user/{PARAM_TEXT}/{PARAM_NUMBER}` i zwracać typ `ResponseEntity<String>`:
- Pierwszy parametr ma być typu String.
- Drugi parametr ma być typu Long.
- Po wywołaniu w logach konsoli ma pojawić się przesłany text i liczba.
- Log ma być wpisany z poziomem ERROR
- Odpowiedź HTTP ma mieć kod 201 (patrz metody klasy ResponseEntity)
- Wiadomośc w odpowiedzi ma zawierać słowo "PRINTED"

Jeśli ukończyłeś zadanie pobierz branch **zadanie6**