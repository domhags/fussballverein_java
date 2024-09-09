import java.time.LocalDate;

public class Trainer extends Mitglied {
    private final int erfahrung;
    private final String spezialisierung;

    // Konstruktor
    public Trainer(String name, LocalDate geburtsdatum, String mitgliedsnummer, int erfahrung, String spezialisierung) {
        super(name, geburtsdatum, mitgliedsnummer);

        if (erfahrung < 0) {
            throw new IllegalArgumentException("Die Erfahrung darf nicht negativ sein.");
        }
        if (spezialisierung == null || spezialisierung.isEmpty()) {
            throw new IllegalArgumentException("Die Spezialisierung darf nicht leer sein.");
        }
        this.erfahrung = erfahrung;
        this.spezialisierung = spezialisierung;
    }

    // Getter für Erfahrung in Jahren
    public int getErfahrung() {
        return erfahrung;
    }

    // Getter für Spezialisierung
    public String getSpezialisierung() {
        return spezialisierung;
    }

    @Override
    public String toString() {
        return "Name: " + getName() + ", Geburtsdatum: " + getGeburtsdatum() + ", Mitgliedsnummer: " + getMitgliedsnummer() +
                ", Erfahrung: " + getErfahrung() + ", Spezialisierung: " + getSpezialisierung();
    }
}
