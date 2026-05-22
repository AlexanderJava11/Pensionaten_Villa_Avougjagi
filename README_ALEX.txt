Pensionaten – Villa Avougjagi VG version

Detta är en uppdaterad version av ditt Pensionaten-projekt.
Den behåller Spring Boot/Thymeleaf/JPA-strukturen men har fått samma typ av hotell-layout och VG-funktioner som Villa Avougjagi-versionen.

Starta projektet:
1. Skapa databasen i MySQL:
   CREATE DATABASE Pensionatendb;

2. Kontrollera src/main/resources/application.properties
   Standard är:
   username=root
   password=Plbsopalex11
   Vill du ändra lösenord kan du ändra där.

3. Kör projektet i IntelliJ:
   Öppna pom.xml som Maven-projekt och starta PensionatenApplication.

4. Gå till:
   http://localhost:8080/

Viktigt för redovisning:
- Startsidan är omgjord till Villa Avougjagi-layout.
- Rum har kapacitet/pris/extrasängar.
- Bokning kan söka lediga rum på datum och antal gäster.
- Systemet stoppar dubbelbokningar.
- Kund kan inte tas bort om den har bokningar.
- Service-tester finns i src/test/java/Pensionaten/service.
