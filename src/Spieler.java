import java.time.LocalDate;

public class Spieler extends Mitglied {
    private final String position;
    private final int trikotnummer;

    // Konstruktor
    public Spieler(String name, LocalDate geburtsdatum, String mitgliedsnummer, String position, int trikotnummer) {
        super(name, geburtsdatum, mitgliedsnummer);

        if (position == null || position.isEmpty()) {
            throw new IllegalArgumentException("Die Position darf nicht leer sein.");
        }
        if (trikotnummer <= 0 || trikotnummer > 99) {
            throw new IllegalArgumentException("Die Trikotnummer muss zwischen 1 und 99 liegen.");
        }
        this.position = position;
        this.trikotnummer = trikotnummer;
    }

    // Getter für Position
    public String getPosition() {
        return position;
    }

    // Getter für Trikotnummer
    public int getTrikotnummer() {
        return trikotnummer;
    }

    @Override
    public String toString() {
        return "Name: " + getName() + ", Geburtsdatum: " + getGeburtsdatum() + ", Mitgliedsnummer: " + getMitgliedsnummer() +
                ", Position: " + getPosition() + ", Trikotnummer: " + getTrikotnummer();
    }
}
