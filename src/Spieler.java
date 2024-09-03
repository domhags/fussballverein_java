import java.time.LocalDate;

public class Spieler extends Mitglied {
    private final String position;
    private final int trikotnummer;

    public Spieler(String name, LocalDate geburtsdatum, String mitgliedsnummer, String position, int trikotnummer) throws UngueltigeEingabeException {
        super(name, geburtsdatum, mitgliedsnummer);

        if (position == null || position.isEmpty()) {
            throw new UngueltigeEingabeException("Die Position darf nicht leer sein.");
        }
        if (trikotnummer <= 0 || trikotnummer > 99) { // Gültiger Bereich: 1-99
            throw new UngueltigeEingabeException("Die Trikotnummer muss zwischen 1 und 99 liegen.");
        }

        this.position = position;
        this.trikotnummer = trikotnummer;
    }

    public String getPosition() {
        return position;
    }

    public int getTrikotnummer() {
        return trikotnummer;
    }
}
