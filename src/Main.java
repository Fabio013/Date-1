import java.time.OffsetDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;

public class Main {
    public static void main(String[] args) {

        // Creo un oggetto OffsetDateTime da stringa della traccia
        OffsetDateTime data = OffsetDateTime.parse("2002-03-01T13:00:00Z");

        /* Per evitare i problemi con il fuso, avrei potuto usare dei pattern equivalenti a FULL, MEDIUM e SHORT
        ad esempio x FULL: EEEE d MMMM yyyy HH:mm:ss zzzz
        ma ho voluto provare a risolvere mantenendo i Formatstyle */
        // Ricavo l'ID del fuso orario di sistema
        ZoneId fusoOrarioSistema = ZoneId.systemDefault();
        // Converto OffsetDateTime in ZonedDateTime usando il fuso orario di sistema
        ZonedDateTime zonedDateTime = data.atZoneSameInstant(fusoOrarioSistema);


        // Formatto la data in FULL, MEDIUM e SHORT
        DateTimeFormatter formatFull = DateTimeFormatter.ofLocalizedDateTime(FormatStyle.FULL);
        String dataFull = zonedDateTime.format(formatFull);
        DateTimeFormatter formatMedium = DateTimeFormatter.ofLocalizedDate(FormatStyle.MEDIUM);
        String dataMedium = zonedDateTime.format(formatMedium);
        DateTimeFormatter formatShort = DateTimeFormatter.ofLocalizedDate(FormatStyle.SHORT);
        String dataShort = zonedDateTime.format(formatShort);

        // Stampo le varie versioni
        System.out.println(dataFull);
        System.out.println(dataMedium);
        System.out.println(dataShort);
    }
}