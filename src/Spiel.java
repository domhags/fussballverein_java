import java.time.LocalDate;

public class Spiel {
    private final LocalDate datum;
    private final String gegner;
    private final String ergebnis;

    // Konstruktor
    public Spiel(LocalDate datum, String gegner, String ergebnis) {
        if (datum == null) {
            throw new IllegalArgumentException("Datum darf nicht null sein.");
        }
        if (gegner == null || gegner.isEmpty()) {
            throw new IllegalArgumentException("Gegner darf nicht leer oder null sein.");
        }
        if (ergebnis == null || ergebnis.isEmpty()) {
            throw new IllegalArgumentException("Ergebnis darf nicht leer oder null sein.");
        }
        this.datum = datum;
        this.gegner = gegner;
        this.ergebnis = ergebnis;
    }

    // Getter für Datum
    public LocalDate getDatum() {
        return datum;
    }

    // Getter für Gegner
    public String getGegner() {
        return gegner;
    }

    // Getter für Ergebnis
    public String getErgebnis() {
        return ergebnis;
    }

    @Override
    public String toString() {
        return "Spiel vom: " + getDatum() + ", Gegner: " + getGegner() + ", Ergebnis: " + getErgebnis();
    }
}
