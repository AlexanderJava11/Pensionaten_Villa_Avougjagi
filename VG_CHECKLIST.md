# Villa Avougjagi – VG-checklista

Detta projekt är uppdaterat för att tydligare sikta på VG i Backend 1-uppgiften.

## Uppfyllda huvudkrav

- Spring Boot + Hibernate, Code First.
- Thymeleaf-site för kunder, rum och bokningar.
- Controller-lager servar Thymeleaf-mallar.
- Entity, DTO, Repository, Service och Controller är separerade.
- Controller-klasser använder DTO:er och service-klasser, inte repositories direkt.
- Service-klasser håller affärslogik och konverterar Entity <-> DTO.
- Kunder kan skapas, ändras och tas bort endast om de saknar bokningar.
- Rum kan hanteras som enkelrum eller dubbelrum.
- Dubbelrum kan ha 1–2 extrasängar.
- Bokningar kan skapas, ändras och avbokas.
- Dubbelbokning stoppas med överlappande datumkontroll.
- Lediga rum kan sökas via datumintervall och antal gäster.
- Valideringsannoteringar finns i DTO/entity-klasser.
- Service-tester finns i `src/test/java/Pensionaten/service`.

## Layoutförbättring

Layouten är omgjord till boutique-hotell-känsla inspirerad av moderna hotellsidor:

- ny startsida med hero-sektion,
- tydligare navigation,
- premiumfärger,
- kort för rum,
- tydligare bokningsflöde i två steg,
- bättre feedback och bekräftelser.

## Viktigt inför redovisning

Visa gärna följande flöde:

1. Skapa en kund.
2. Skapa/visa rum med enkelrum/dubbelrum och extrasängar.
3. Sök ledigt rum på datum + antal personer.
4. Skapa bokning.
5. Försök skapa överlappande bokning på samma rum och visa att systemet stoppar den.
6. Ändra bokning.
7. Avboka bokning.
8. Försök ta bort kund med bokning och visa felmeddelande.
