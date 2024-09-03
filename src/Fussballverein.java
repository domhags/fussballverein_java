import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;


public class Fussballverein {
    private final String name;
    private final int gruendungsjahr;
    private final List<Mitglied> mitgliedschaften;
    private final List<Spieler> spieler;
    private final List<Trainer> trainer;
    private final List<Spiel> spiele;

    public Fussballverein(String name, int gruendungsjahr) throws UngueltigeEingabeException {
        if (name == null || name.isEmpty()) {
            throw new UngueltigeEingabeException("Der Name des Vereins darf nicht leer sein.");
        }
        if (gruendungsjahr <= 0) {
            throw new UngueltigeEingabeException("Das Gründungsjahr muss eine positive Zahl sein.");
        }

        this.name = name;
        this.gruendungsjahr = gruendungsjahr;
        this.mitgliedschaften = new ArrayList<>();
        this.spieler = new ArrayList<>();
        this.trainer = new ArrayList<>();
        this.spiele = new ArrayList<>();
    }

    public void mitgliedHinzufuegen(Mitglied mitglied) throws UngueltigeEingabeException {
        if (mitglied == null) {
            throw new UngueltigeEingabeException("Mitglied darf nicht null sein.");
        }
        for (Mitglied m : mitgliedschaften) {
            if (m != null && m.getMitgliedsnummer().equals(mitglied.getMitgliedsnummer())) {
                throw new UngueltigeEingabeException("Mitgliedsnummer muss eindeutig sein.");
            }
        }
        mitgliedschaften.add(mitglied);
    }

    public void mitgliedEntfernen(Mitglied mitglied) throws NoSuchElementException {
        if (mitglied == null || !mitgliedschaften.remove(mitglied)) {
            throw new NoSuchElementException("Mitglied wurde nicht gefunden oder ist null.");
        }
    }

    public void spielerHinzufuegen(Spieler spieler) throws UngueltigeEingabeException {
        if (spieler == null) {
            throw new UngueltigeEingabeException("Spieler darf nicht null sein.");
        }
        this.spieler.add(spieler);
    }

    public void spielerEntfernen(Spieler spieler) throws NoSuchElementException {
        if (spieler == null || !this.spieler.remove(spieler)) {
            throw new NoSuchElementException("Spieler wurde nicht gefunden oder ist null.");
        }
    }

    public void trainerHinzufuegen(Trainer trainer) throws UngueltigeEingabeException {
        if (trainer == null) {
            throw new UngueltigeEingabeException("Trainer darf nicht null sein.");
        }
        this.trainer.add(trainer);
    }

    public void trainerEntfernen(Trainer trainer) throws NoSuchElementException {
        if (trainer == null || !this.trainer.remove(trainer)) {
            throw new NoSuchElementException("Trainer wurde nicht gefunden oder ist null.");
        }
    }

    public void spielHinzufuegen(Spiel spiel) throws UngueltigeEingabeException {
        if (spiel == null) {
            throw new UngueltigeEingabeException("Spiel darf nicht null sein.");
        }
        spiele.add(spiel);
    }

    public void spielEntfernen(Spiel spiel) throws NoSuchElementException {
        if (spiel == null || !spiele.remove(spiel)) {
            throw new NoSuchElementException("Spiel wurde nicht gefunden oder ist null.");
        }
    }

    public List<Mitglied> getMitglieder() {
        return new ArrayList<>(mitgliedschaften);
    }

    public List<Spieler> getSpieler() {
        return new ArrayList<>(spieler);
    }

    public List<Trainer> getTrainer() {
        return new ArrayList<>(trainer);
    }

    public List<Spiel> getSpiele() {
        return new ArrayList<>(spiele);
    }

    public String getName() {
        return name;
    }

    public int getGruendungsjahr() {
        return gruendungsjahr;
    }
}
