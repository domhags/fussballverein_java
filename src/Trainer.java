import java.time.LocalDate;

public class Trainer extends Mitglied {
    private final int erfahrung;
    private final String spezialisierung;

    public Trainer(String name, LocalDate geburtsdatum, String mitgliedsnummer, int erfahrung, String spezialisierung) throws UngueltigeEingabeException {
        super(name, geburtsdatum, mitgliedsnummer);

        if (erfahrung < 0) {
            throw new UngueltigeEingabeException("Die Erfahrung darf nicht negativ sein.");
        }
        if (spezialisierung == null || spezialisierung.isEmpty()) {
            throw new UngueltigeEingabeException("Die Spezialisierung darf nicht leer sein.");
        }

        this.erfahrung = erfahrung;
        this.spezialisierung = spezialisierung;
    }

    public int getErfahrung() {
        return erfahrung;
    }

    public String getSpezialisierung() {
        return spezialisierung;
    }
}
