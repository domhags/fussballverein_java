import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {
        try {
            // Erstellen eines Fußballvereins mithilfe von Beispieldaten
            Fussballverein verein = new Fussballverein("FC Beispiel", 1920);

            // Erstellen von Mitgliedern
            Mitglied mitglied1 = new Mitglied("Max Mustermann", LocalDate.of(1990, 5, 10), "M001");
            Mitglied mitglied2 = new Mitglied("Erika Mustermann", LocalDate.of(1992, 7, 15), "M002");

            // Erstellen von Spielern
            Spieler spieler1 = new Spieler("John Doe", LocalDate.of(2000, 1, 20), "S001", "Stürmer", 9);
            Spieler spieler2 = new Spieler("Jane Doe", LocalDate.of(1998, 3, 22), "S002", "Torwart", 1);

            // Erstellen von Trainern
            Trainer trainer1 = new Trainer("Peter Müller", LocalDate.of(1980, 11, 5), "T001", 10, "Fitness");
            Trainer trainer2 = new Trainer("Anna Schmidt", LocalDate.of(1985, 8, 18), "T002", 8, "Taktik");

            // Erstellen von Spielen
            Spiel spiel1 = new Spiel(LocalDate.of(2024, 9, 10), "Gegnerverein A");
            Spiel spiel2 = new Spiel(LocalDate.of(2024, 10, 5), "Gegnerverein B");

            // Hinzufügen von Objekten zum Verein
            addMitglied(verein, mitglied1);
            addMitglied(verein, mitglied2);
            addSpieler(verein, spieler1);
            addSpieler(verein, spieler2);
            addTrainer(verein, trainer1);
            addTrainer(verein, trainer2);
            addSpiel(verein, spiel1);
            addSpiel(verein, spiel2);

            // Anzeigen der Informationen über den Verein
            printVereinsInfo(verein);

            // Setzen des Ergebnisses für ein Spiel
            spiel1.setErgebnis("3:1 Sieg");
            System.out.println("Ergebnis des Spiels gegen " + spiel1.getGegner() + ": " + spiel1.getErgebnis());

            // Entfernen von Objekten
            removeMitglied(verein, mitglied2);
            removeSpieler(verein, spieler2);
            removeTrainer(verein, trainer2);
            removeSpiel(verein, spiel2);

            // Anzeigen der aktualisierten Informationen
            printVereinsInfo(verein);

        } catch (UngueltigeEingabeException e) {
            System.out.println("Fehler: " + e.getMessage());
        }
    }

    private static void addMitglied(Fussballverein verein, Mitglied mitglied) {
        try {
            verein.mitgliedHinzufuegen(mitglied);
        } catch (Exception e) {
            System.out.println("Fehler beim Hinzufügen des Mitglieds: " + e.getMessage());
        }
    }

    private static void addSpieler(Fussballverein verein, Spieler spieler) {
        try {
            verein.spielerHinzufuegen(spieler);
        } catch (Exception e) {
            System.out.println("Fehler beim Hinzufügen des Spielers: " + e.getMessage());
        }
    }

    private static void addTrainer(Fussballverein verein, Trainer trainer) {
        try {
            verein.trainerHinzufuegen(trainer);
        } catch (Exception e) {
            System.out.println("Fehler beim Hinzufügen des Trainers: " + e.getMessage());
        }
    }

    private static void addSpiel(Fussballverein verein, Spiel spiel) {
        try {
            verein.spielHinzufuegen(spiel);
        } catch (Exception e) {
            System.out.println("Fehler beim Hinzufügen des Spiels: " + e.getMessage());
        }
    }

    private static void removeMitglied(Fussballverein verein, Mitglied mitglied) {
        if (!verein.getMitglieder().remove(mitglied)) {
            System.out.println("Mitglied konnte nicht entfernt werden.");
        }
    }

    private static void removeSpieler(Fussballverein verein, Spieler spieler) {
        if (!verein.getSpieler().remove(spieler)) {
            System.out.println("Spieler konnte nicht entfernt werden.");
        }
    }

    private static void removeTrainer(Fussballverein verein, Trainer trainer) {
        if (!verein.getTrainer().remove(trainer)) {
            System.out.println("Trainer konnte nicht entfernt werden.");
        }
    }

    private static void removeSpiel(Fussballverein verein, Spiel spiel) {
        if (!verein.getSpiele().remove(spiel)) {
            System.out.println("Spiel konnte nicht entfernt werden.");
        }
    }

    private static void printVereinsInfo(Fussballverein verein) {
        System.out.println("Name: " + verein.getName());
        System.out.println("Gründungsjahr: " + verein.getGruendungsjahr());
        System.out.println("Mitglieder: " + verein.getMitglieder().size());
        System.out.println("Spieler: " + verein.getSpieler().size());
        System.out.println("Trainer: " + verein.getTrainer().size());
        System.out.println("Spiele: " + verein.getSpiele().size());
    }
}
