import java.time.LocalDate;
import java.util.regex.Pattern;

public class Mitglied {
    private final String name;
    private final LocalDate geburtsdatum;
    private final String mitgliedsnummer;

    // Konstruktor
    public Mitglied(String name, LocalDate geburtsdatum, String mitgliedsnummer) {
        if (name == null || name.isEmpty()) {
            throw new IllegalArgumentException("Name darf nicht leer sein.");
        }
        this.name = name;

        if (geburtsdatum == null) {
            throw new IllegalArgumentException("Geburtsdatum darf nicht null sein.");
        }
        this.geburtsdatum = geburtsdatum;

        if (mitgliedsnummer == null || mitgliedsnummer.isEmpty() || !Pattern.matches("\\d{6}", mitgliedsnummer)) {
            throw new IllegalArgumentException("Mitgliedsnummer muss genau 6 Ziffern lang sein.");
        }
        this.mitgliedsnummer = mitgliedsnummer;
    }

    // Getter für Name
    public String getName() {
        return name;
    }

    // Getter für Geburtsdatum
    public LocalDate getGeburtsdatum() {
        return geburtsdatum;
    }

    // Getter für Mitgliedsnummer
    public String getMitgliedsnummer() {
        return mitgliedsnummer;
    }

    @Override
    public String toString() {
        return "Name: " + getName() + ", Geburtsdatum: " + getGeburtsdatum() + ", Mitgliedsnummer: " + getMitgliedsnummer();
    }
}
