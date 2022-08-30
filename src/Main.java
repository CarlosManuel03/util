
import static java.lang.String.format;
import static java.time.ZonedDateTime.ofInstant;
import static java.time.ZonedDateTime.now;
import static java.time.LocalDateTime.parse;
import static java.time.ZoneOffset.UTC;
import static java.time.Instant.ofEpochMilli;
import static java.time.format.DateTimeFormatter.ofPattern;

import java.time.LocalDateTime;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;

public class Main {

    private static final DateTimeFormatter DATE_FORMATTER_ES = ofPattern("dd/MM/yyy");

    private static final DateTimeFormatter DATETIME_FORMATTER_ES = ofPattern("dd/MM/yyy HH:mm:ss");

    private static final String DATE_START_PATTERN = "%s 00:00:00";

    private static final String DATE_END_PATTERN = "%s 23:59:59";

    public static void main(String[] args) {

        try {

            final long timeStamp = parse(
                                     format(
                                       DATE_START_PATTERN,
                                       "31/02/2022"),
                                     DATETIME_FORMATTER_ES)
                                            .atZone(UTC)
                                            .toInstant()
                                            .toEpochMilli();

            System.out.println(timeStamp);

             System.out.println(DATETIME_FORMATTER_ES.format(ofInstant(ofEpochMilli(timeStamp), UTC)));

        } catch (Exception e){

            System.out.println("Invalid date " + e.getMessage());

        }

        final ZonedDateTime now = now();

        final String dateStart = DATE_FORMATTER_ES.format(now().minusDays(50));

        final String dateEnd = DATE_FORMATTER_ES.format(now);

        final long timeStampStart = parse(
                                        format(
                                          DATE_START_PATTERN,
                                          dateStart),
                                        DATETIME_FORMATTER_ES)
                                      .atZone(UTC)
                                      .toInstant()
                                      .toEpochMilli();

        final long timeStampEnd = parse(
                                      format(
                                        DATE_END_PATTERN,
                                        dateEnd),
                                      DATETIME_FORMATTER_ES)
                                    .atZone(UTC)
                                    .toInstant()
                                    .toEpochMilli();

        System.out.println("start timestamp " + timeStampStart + " end timestamp " + timeStampEnd);

        System.out.println("start date " + DATETIME_FORMATTER_ES.format(ofInstant(ofEpochMilli(timeStampStart), UTC))
                + " end date " + DATETIME_FORMATTER_ES.format(ofInstant(ofEpochMilli(timeStampEnd), UTC)));

    }

}