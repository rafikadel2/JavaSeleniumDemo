package helpers;

public class Localization {


    private static Localization localization;
    private Locale locale;
    private Country country;

    public void setLocale(String locale) {

        switch (locale) {
            case "english" -> this.locale = Locale.EN;
            case "arabic" -> this.locale = Locale.AR;
            default -> this.locale = Locale.AR;
        }

    }

    public void setCountry(String country) {

        switch (country) {
            case "egypt" -> this.country = Country.EGYPT;
            case "uae" -> this.country = Country.UAE;
            case "algeria" -> this.country = Country.ALGERIA;
            case "djibouti" -> this.country = Country.DJIBOUTI;
            case "chad" -> this.country = Country.CHAD;
            case "iraq" -> this.country = Country.IRAQ;
            case "jordan" -> this.country = Country.JORDAN;
            case "lebanon" -> this.country = Country.LEBANON;
            case "morocco" -> this.country = Country.MOROCCO;
            case "oman" -> this.country = Country.OMAN;
            case "tunisia" -> this.country = Country.TUNISIA;
            case "yemen" -> this.country = Country.YEMEN;
            case "palestine" -> this.country = Country.PALESTINE;
            default -> this.country = Country.EGYPT;
        }

    }


    private Localization() {
    }

    public static Localization getInstance() {
        if (localization == null)
            localization = new Localization();
        return localization;
    }

    public Country getCountry() {
        return this.country;

    }

    public Locale getLocale() {
        return this.locale;
    }

    public enum Locale {
        AR("ar"),
        EN("en");

        public String value;

        Locale(String value) {
            this.value = value;
        }


    }

    public enum Country {
        EGYPT("eg"),
        UAE("ae"),
        ALGERIA("dz"),
        DJIBOUTI("dj"),
        CHAD("td"),
        IRAQ("iq"),
        JORDAN("jo"),
        LEBANON("lb"),
        MOROCCO("ma"),
        OMAN("om"),
        TUNISIA("tn"),
        YEMEN("ye"),
        PALESTINE("ps");

        public String value;

        Country(String value) {
            this.value = value;
        }
    }

}