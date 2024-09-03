import java.time.LocalDate;

public class Spiel {
    private final LocalDate datum;
    private final String gegner;
    private String ergebnis;

    public Spiel(LocalDate datum, String gegner) throws UngueltigeEingabeException {
        if (datum == null) {
            throw new UngueltigeEingabeException("Datum darf nicht null sein.");
        }
        if (gegner == null || gegner.isEmpty()) {
            throw new UngueltigeEingabeException("Gegner darf nicht null oder leer sein.");
        }

        this.datum = datum;
        this.gegner = gegner;
        this.ergebnis = "Noch nicht gespielt";
    }

    public LocalDate getDatum() {
        return datum;
    }

    public String getGegner() {
        return gegner;
    }

    public String getErgebnis() {
        return ergebnis;
    }

    public void setErgebnis(String ergebnis) throws UngueltigeEingabeException {
        if (ergebnis == null || ergebnis.isEmpty()) {
            throw new UngueltigeEingabeException("Ergebnis darf nicht null oder leer sein.");
        }
        this.ergebnis = ergebnis;
    }
}
