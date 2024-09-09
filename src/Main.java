import java.time.LocalDate;
import java.time.format.DateTimeParseException;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    private static Fussballverein verein;
    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        System.out.println("Geben Sie den Vereinsnamen ein:");
        String name = scanner.nextLine().trim();
        if (name.isEmpty()) {
            System.out.println("Die Eingabe darf nicht leer sein!");
            return;
        }

        int gruendungsjahr = 0;
        boolean gueltigeEingabe = false;
        while (!gueltigeEingabe) {
            System.out.println("Geben Sie das Gründungsjahr des Vereins ein:");
            try {
                gruendungsjahr = scanner.nextInt();
                scanner.nextLine(); // Konsumieren der verbleibenden Zeile
                gueltigeEingabe = true; // Eingabe war gültig
            } catch (InputMismatchException e) {
                System.out.println("Bitte geben Sie eine gültige Zahl ein.");
                scanner.next(); // Scanner in den Fehlerzustand zurückversetzen
            }
        }
        verein = new Fussballverein(name, gruendungsjahr);

        boolean running = true;
        while (running) {
            System.out.println("\n--- Menü ---");
            System.out.println("1. Mitglied hinzufügen");
            System.out.println("2. Mitglied entfernen");
            System.out.println("3. Spieler hinzufügen");
            System.out.println("4. Spieler entfernen");
            System.out.println("5. Trainer hinzufügen");
            System.out.println("6. Trainer entfernen");
            System.out.println("7. Spiel hinzufügen");
            System.out.println("8. Spiel entfernen");
            System.out.println("9. Mitglieder anzeigen");
            System.out.println("10. Spieler anzeigen");
            System.out.println("11. Trainer anzeigen");
            System.out.println("12. Spiele anzeigen");
            System.out.println("13. Beenden");

            int auswahl = getAuswahl();
            switch (auswahl) {
                case 1:
                    mitgliedHinzufuegen();
                    break;
                case 2:
                    mitgliedEntfernen();
                    break;
                case 3:
                    spielerHinzufuegen();
                    break;
                case 4:
                    spielerEntfernen();
                    break;
                case 5:
                    trainerHinzufuegen();
                    break;
                case 6:
                    trainerEntfernen();
                    break;
                case 7:
                    spielHinzufuegen();
                    break;
                case 8:
                    spielEntfernen();
                    break;
                case 9:
                    mitgliederAnzeigen();
                    break;
                case 10:
                    spielerAnzeigen();
                    break;
                case 11:
                    trainerAnzeigen();
                    break;
                case 12:
                    spieleAnzeigen();
                    break;
                case 13:
                    running = false;
                    System.out.println("Programm beendet.");
                    break;
                default:
                    System.out.println("Ungültige Auswahl. Bitte versuchen Sie es erneut.");
                    break;
            }
        }
    }

    private static int getAuswahl() {
        System.out.print("Bitte wählen Sie eine Option: ");
        try {
            int auswahl = scanner.nextInt();
            scanner.nextLine();
            return auswahl;
        } catch (InputMismatchException e) {
            scanner.nextLine(); // Eingabe wird gelöscht
            return -1;
        }
    }

    private static void mitgliedHinzufuegen() {
        System.out.print("Name des Mitglieds: ");
        String name = scanner.nextLine().trim();
        if (name.isEmpty()) {
            System.out.println("Name darf nicht leer sein!");
            return;
        }

        LocalDate geburtsdatum = null;
        boolean gueltigesDatum = false;
        while (!gueltigesDatum) {
            System.out.print("Geburtsdatum (yyyy-mm-dd): ");
            try {
                geburtsdatum = LocalDate.parse(scanner.nextLine().trim());
                gueltigesDatum = true;
            } catch (DateTimeParseException e) {
                System.out.println("Bitte geben Sie das Datum im Format yyyy-mm-dd ein.");
            }
        }

        String mitgliedsnummer = "";
        boolean gueltigeNummer = false;
        while (!gueltigeNummer) {
            System.out.print("Mitgliedsnummer (6 Ziffern): ");
            mitgliedsnummer = scanner.nextLine().trim();
            if (mitgliedsnummer.matches("\\d{6}")) {
                gueltigeNummer = true;
            } else {
                System.out.println("Bitte geben Sie eine gültige Mitgliedsnummer mit 6 Ziffern ein.");
            }
        }

        Mitglied mitglied = new Mitglied(name, geburtsdatum, mitgliedsnummer);
        verein.mitgliedHinzufuegen(mitglied);
        System.out.println("Mitglied hinzugefügt.");
    }

    private static void mitgliedEntfernen() {
        System.out.print("Mitgliedsnummer des zu entfernenden Mitglieds: ");
        String mitgliedsnummer = scanner.nextLine().trim();
        boolean gefunden = false;
        for (Mitglied mitglied : verein.getMitglieder()) {
            if (mitglied.getMitgliedsnummer().equals(mitgliedsnummer)) {
                verein.mitgliedEntfernen(mitglied);
                System.out.println("Mitglied entfernt.");
                gefunden = true;
                break;
            }
        }
        if (!gefunden) {
            System.out.println("Mitglied nicht gefunden.");
        }
    }

    private static void spielerHinzufuegen() {
        System.out.print("Name des Spielers: ");
        String name = scanner.nextLine().trim();
        System.out.print("Geburtsdatum (yyyy-mm-dd): ");
        LocalDate geburtsdatum = null;
        while (geburtsdatum == null) {
            try {
                geburtsdatum = LocalDate.parse(scanner.nextLine().trim());
            } catch (DateTimeParseException e) {
                System.out.println("Bitte geben Sie das Datum im Format yyyy-mm-dd ein.");
            }
        }

        System.out.print("Mitgliedsnummer (6 Ziffern): ");
        String mitgliedsnummer = scanner.nextLine().trim();
        System.out.print("Position: ");
        String position = scanner.nextLine().trim();
        int trikotnummer = 0;
        boolean gueltigeTrikotnummer = false;
        while (!gueltigeTrikotnummer) {
            System.out.print("Trikotnummer (1-99): ");
            try {
                trikotnummer = scanner.nextInt();
                scanner.nextLine();
                if (trikotnummer >= 1 && trikotnummer <= 99) {
                    gueltigeTrikotnummer = true;
                } else {
                    System.out.println("Bitte geben Sie eine Trikotnummer zwischen 1 und 99 ein.");
                }
            } catch (InputMismatchException e) {
                System.out.println("Bitte geben Sie eine gültige Zahl ein.");
                scanner.next();  // Eingabe wird gelöscht
            }
        }

        Spieler spieler = new Spieler(name, geburtsdatum, mitgliedsnummer, position, trikotnummer);
        verein.spielerHinzufuegen(spieler);
        System.out.println("Spieler hinzugefügt.");
    }

    private static void spielerEntfernen() {
        System.out.print("Trikotnummer des zu entfernenden Spielers: ");
        int trikotnummer;
        boolean gefunden = false;
        while (!gefunden) {
            try {
                trikotnummer = scanner.nextInt();
                scanner.nextLine(); // Konsumieren der verbleibenden Zeile
                for (Spieler spieler : verein.getSpieler()) {
                    if (spieler.getTrikotnummer() == trikotnummer) {
                        verein.spielerEntfernen(spieler);
                        System.out.println("Spieler entfernt.");
                        gefunden = true;
                        break;
                    }
                }
                if (!gefunden) {
                    System.out.println("Spieler nicht gefunden.");
                }
            } catch (InputMismatchException e) {
                System.out.println("Bitte geben Sie eine gültige Zahl ein.");
                scanner.next(); // Eingabe wird gelöscht
            }
        }
    }

    private static void trainerHinzufuegen() {
        System.out.print("Name des Trainers: ");
        String name = scanner.nextLine().trim();
        System.out.print("Geburtsdatum (yyyy-mm-dd): ");
        LocalDate geburtsdatum = null;
        while (geburtsdatum == null) {
            try {
                geburtsdatum = LocalDate.parse(scanner.nextLine().trim());
            } catch (DateTimeParseException e) {
                System.out.println("Bitte geben Sie das Datum im Format yyyy-mm-dd ein.");
            }
        }

        System.out.print("Mitgliedsnummer (6 Ziffern): ");
        String mitgliedsnummer = scanner.nextLine().trim();
        int erfahrung = 0;
        boolean gueltigeErfahrung = false;
        while (!gueltigeErfahrung) {
            System.out.print("Erfahrung (Jahre): ");
            try {
                erfahrung = scanner.nextInt();
                scanner.nextLine(); // Konsumieren der verbleibenden Zeile
                if (erfahrung >= 0) {
                    gueltigeErfahrung = true;
                } else {
                    System.out.println("Bitte geben Sie eine gültige Anzahl von Jahren ein.");
                }
            } catch (InputMismatchException e) {
                System.out.println("Bitte geben Sie eine gültige Zahl ein.");
                scanner.next(); // Scanner in den Fehlerzustand zurückversetzen
            }
        }

        System.out.print("Spezialisierung: ");
        String spezialisierung = scanner.nextLine().trim();
        Trainer trainer = new Trainer(name, geburtsdatum, mitgliedsnummer, erfahrung, spezialisierung);
        verein.trainerHinzufuegen(trainer);
        System.out.println("Trainer hinzugefügt.");
    }

    private static void trainerEntfernen() {
        System.out.print("Mitgliedsnummer des zu entfernenden Trainers: ");
        String mitgliedsnummer = scanner.nextLine().trim();
        boolean gefunden = false;
        for (Trainer trainer : verein.getTrainer()) {
            if (trainer.getMitgliedsnummer().equals(mitgliedsnummer)) {
                verein.trainerEntfernen(trainer);
                System.out.println("Trainer entfernt.");
                gefunden = true;
                break;
            }
        }
        if (!gefunden) {
            System.out.println("Trainer nicht gefunden.");
        }
    }

    private static void spielHinzufuegen() {
        System.out.print("Datum des Spiels (yyyy-mm-dd): ");
        LocalDate datum = null;
        while (datum == null) {
            try {
                datum = LocalDate.parse(scanner.nextLine().trim());
            } catch (DateTimeParseException e) {
                System.out.println("Bitte geben Sie das Datum im Format yyyy-mm-dd ein.");
            }
        }

        System.out.print("Gegner: ");
        String gegner = scanner.nextLine().trim();

        System.out.print("Ergebnis (z.B. 2:1): ");
        String ergebnis = scanner.nextLine().trim();

        Spiel spiel = new Spiel(datum, gegner, ergebnis);
        verein.spielHinzufuegen(spiel);
        System.out.println("Spiel hinzugefügt.");
    }

    private static void spielEntfernen() {
        System.out.print("Datum des zu entfernenden Spiels (yyyy-mm-dd): ");
        LocalDate datum = null;
        while (datum == null) {
            try {
                datum = LocalDate.parse(scanner.nextLine().trim());
            } catch (DateTimeParseException e) {
                System.out.println("Bitte geben Sie das Datum im Format yyyy-mm-dd ein.");
            }
        }

        boolean gefunden = false;
        for (Spiel spiel : verein.getSpiele()) {
            if (spiel.getDatum().equals(datum)) {
                verein.spielEntfernen(spiel);
                System.out.println("Spiel entfernt.");
                gefunden = true;
                break;
            }
        }
        if (!gefunden) {
            System.out.println("Spiel nicht gefunden.");
        }
    }

    private static void mitgliederAnzeigen() {
        System.out.println("\n--- Mitglieder ---");
        for (Mitglied mitglied : verein.getMitglieder()) {
            System.out.println(mitglied);
        }
    }

    private static void spielerAnzeigen() {
        System.out.println("\n--- Spieler ---");
        for (Spieler spieler : verein.getSpieler()) {
            System.out.println(spieler);
        }
    }

    private static void trainerAnzeigen() {
        System.out.println("\n--- Trainer ---");
        for (Trainer trainer : verein.getTrainer()) {
            System.out.println(trainer);
        }
    }

    private static void spieleAnzeigen() {
        System.out.println("\n--- Spiele ---");
        for (Spiel spiel : verein.getSpiele()) {
            System.out.println(spiel);
        }
    }
}
