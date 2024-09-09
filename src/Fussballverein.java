import java.util.HashSet;
import java.util.Set;

public class Fussballverein {
    private final String name;
    private final int gruendungsjahr;
    private final Set<Mitglied> mitgliedschaften;
    private final Set<Spieler> spieler;
    private final Set<Trainer> trainer;
    private final Set<Spiel> spiele;

    // Konstruktor
    public Fussballverein(String name, int gruendungsjahr) {
        this.name = name;
        this.gruendungsjahr = gruendungsjahr;
        this.mitgliedschaften = new HashSet<>();
        this.spieler = new HashSet<>();
        this.trainer = new HashSet<>();
        this.spiele = new HashSet<>();
    }

    // Fügt ein Mitglied hinzu
    public void mitgliedHinzufuegen(Mitglied mitglied) {
        if (mitglied == null) {
            throw new IllegalArgumentException("Mitglied darf nicht null sein.");
        }
        if (mitgliedschaften.contains(mitglied)) {
            throw new IllegalArgumentException("Mitglied ist bereits im Verein.");
        }
        mitgliedschaften.add(mitglied);
    }

    // Entfernt ein Mitglied
    public void mitgliedEntfernen(Mitglied mitglied) {
        if (mitglied == null || !mitgliedschaften.contains(mitglied)) {
            throw new IllegalArgumentException("Mitglied existiert nicht.");
        }
        mitgliedschaften.remove(mitglied);
    }

    // Fügt einen Spieler hinzu
    public void spielerHinzufuegen(Spieler spieler) {
        if (spieler == null) {
            throw new IllegalArgumentException("Spieler darf nicht null sein.");
        }
        if (this.spieler.contains(spieler)) {
            throw new IllegalArgumentException("Spieler ist bereits im Verein.");
        }
        this.spieler.add(spieler);
    }

    //Entfernt einen Spieler
    public void spielerEntfernen(Spieler spieler) {
        if (spieler == null || !this.spieler.contains(spieler)) {
            throw new IllegalArgumentException("Spieler existiert nicht.");
        }
        this.spieler.remove(spieler);
    }

    // Fügt einen Trainer hinzu
    public void trainerHinzufuegen(Trainer trainer) {
        if (trainer == null) {
            throw new IllegalArgumentException("Trainer darf nicht null sein.");
        }
        if (this.trainer.contains(trainer)) {
            throw new IllegalArgumentException("Trainer ist bereits im Verein.");
        }
        this.trainer.add(trainer);
    }

    // Entfernt einen Trainer
    public void trainerEntfernen(Trainer trainer) {
        if (trainer == null || !this.trainer.contains(trainer)) {
            throw new IllegalArgumentException("Trainer existiert nicht.");
        }
        this.trainer.remove(trainer);
    }

    // Fügt ein Spiel hinzu
    public void spielHinzufuegen(Spiel spiel) {
        if (spiel == null) {
            throw new IllegalArgumentException("Spiel darf nicht null sein.");
        }
        spiele.add(spiel);
    }

    // Entfernt ein Spiel
    public void spielEntfernen(Spiel spiel) {
        if (spiel == null || !spiele.contains(spiel)) {
            throw new IllegalArgumentException("Spiel existiert nicht.");
        }
        spiele.remove(spiel);
    }

    // Getter für die Spiele
    public Set<Spiel> getSpiele() {
        return spiele;
    }

    // Getter für die Trainer
    public Set<Trainer> getTrainer() {
        return trainer;
    }

    // Getter für die Spieler
    public Set<Spieler> getSpieler() {
        return spieler;
    }

    // Getter für die Mitglieder
    public Set<Mitglied> getMitglieder() {
        return mitgliedschaften;
    }

    // Getter für Name
    public String getName() {
        return name;
    }

    // Getter für Gründungsjahr
    public int getGruendungsjahr() {
        return gruendungsjahr;
    }

    @Override
    public String toString() {
        return "Fussballverein{" +
                "name='" + getName() + '\'' +
                ", gruendungsjahr=" + getGruendungsjahr() +
                '}';
    }
}
