import java.time.LocalDate;
import java.util.regex.Pattern;

public class Mitglied {
    private final String name;
    private final LocalDate geburtsdatum;
    private final String mitgliedsnummer;

    public Mitglied(String name, LocalDate geburtsdatum, String mitgliedsnummer) throws UngueltigeEingabeException {
        if (name == null || name.isEmpty()) {
            throw new UngueltigeEingabeException("Name darf nicht leer sein.");
        }
        if (geburtsdatum == null) {
            throw new UngueltigeEingabeException("Geburtsdatum darf nicht null sein.");
        }
        if (mitgliedsnummer == null || mitgliedsnummer.isEmpty()) {
            throw new UngueltigeEingabeException("Mitgliedsnummer darf nicht leer sein.");
        }
        // Beispiel für eine einfache Mitgliedsnummer-Validierung
        if (!Pattern.matches("\\d{6}", mitgliedsnummer)) { // Mitgliedsnummer muss 6 Ziffern lang sein
            throw new UngueltigeEingabeException("Mitgliedsnummer muss genau 6 Ziffern lang sein.");
        }

        this.name = name;
        this.geburtsdatum = geburtsdatum;
        this.mitgliedsnummer = mitgliedsnummer;
    }

    public String getName() {
        return name;
    }

    public LocalDate getGeburtsdatum() {
        return geburtsdatum;
    }

    public String getMitgliedsnummer() {
        return mitgliedsnummer;
    }
}
