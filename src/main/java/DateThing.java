/*


import org.joda.time.DateTime;
import org.joda.time.DateTimeZone;

import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.*;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;
import java.util.TimeZone;

public class DateThing {
    public static void main(String[] args) throws ParseException{
        Long l = 1596220199999L;
        LocalDateTime local = new Timestamp(l).toLocalDateTime();
        //ZoneId zone = ZoneId.of( "Australia/Melbourne" );

        final ZoneId zone = ZoneId.of("Australia/Melbourne");
        LocalDateTime localDateTime = local;
        ZoneOffset zoneOffSet = zone.getRules().getOffset(localDateTime);
        OffsetDateTime offsetDateTime = localDateTime.atOffset(zoneOffSet);
        System.out.println(offsetDateTime.toLocalDateTime().toString());

        ZoneId zoneAu = ZoneId.of( "Asia/Calcutta" );
        ZonedDateTime aus = offsetDateTime.atZoneSameInstant( zoneAu );
        //Timestamp t = Timestamp.from(aus.toInstant());
        System.out.println( aus.toLocalDateTime().toEpochSecond(zoneOffSet) * 1000);
        //1596236399000

        DateTime date = new DateTime(1596220199999L, DateTimeZone.forID("Australia/Melbourne"));
        date.toString("dd-MMM-yyyy");

        //a();

       System.out.println(convertTimezone1("2020-07-31 23:59:59"));
    }

    public static String convertTimezone(String input) {
        try {
            DateFormat dateFirstZone = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.ROOT);
            dateFirstZone.setTimeZone(TimeZone.getTimeZone("Europe/London"));
            DateFormat dateSecondZone = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.ROOT);
            dateSecondZone.setTimeZone(TimeZone.getTimeZone("Asia/Calcutta"));

            Calendar calendar = Calendar.getInstance(TimeZone.getTimeZone("Europe/London"), Locale.ROOT);
            calendar.setTimeInMillis(1596220199999L);
            dateFirstZone.setCalendar(calendar);
            System.out.println(dateFirstZone.format(calendar.getTime()));

            //System.out.println(dateFirstZone.parse(input).getTime());
            //System.out.println(calendar.getTime().getTime());
            //return dateSecondZone.format(calendar.getTime());
            return dateSecondZone.format(dateFirstZone.parse(input));
        } catch (Exception e) {
            return null;
        }
    }

    public static String convertTimezone1(String input) {
        try {
            DateFormat dateFirstZone = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.ROOT);
            dateFirstZone.setTimeZone(TimeZone.getTimeZone("Asia/Calcutta"));
            DateFormat dateSecondZone = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.ROOT);
            dateSecondZone.setTimeZone(TimeZone.getTimeZone("Europe/London"));

            Calendar calendar = Calendar.getInstance(TimeZone.getTimeZone("Asia/Calcutta"), Locale.ROOT);
            calendar.setTimeInMillis(1596220199999L);
            dateFirstZone.setCalendar(calendar);
            System.out.println(dateFirstZone.format(calendar.getTime()));

            //System.out.println(dateFirstZone.parse(input).getTime());
            //System.out.println(calendar.getTime().getTime());
            //return dateSecondZone.format(calendar.getTime());
            return dateSecondZone.format(dateFirstZone.parse(input));
        } catch (Exception e) {
            return null;
        }
    }

    static void a() throws ParseException {
        Long l = 1596220199999L;
        Date d = new Date(l);
         SimpleDateFormat FORMATTER = new SimpleDateFormat("MM/dd/yyyy 'at' hh:mma z");

            TimeZone istTimeZone = TimeZone.getTimeZone("Asia/Calcutta");    //Source timezone
            TimeZone etTimeZone = TimeZone.getTimeZone("Australia/Melbourne"); //Target timezone

            Calendar today = Calendar.getInstance(istTimeZone);

            today.setTime(d);
            long fromTime = today.getTime().getTime();
            System.out.println(FORMATTER.format(today.getTime()));  //07/15/2018 at 12:35AM IST

            //Change timezone in formatter
            FORMATTER.setTimeZone(etTimeZone);

            long toTime = FORMATTER.parse(FORMATTER.format(today.getTime())).getTime();

            if(toTime > fromTime) {
                fromTime += (toTime - fromTime);
                System.out.println(fromTime);
            }
            else {
                fromTime += (fromTime - toTime);
                System.out.println(fromTime);
            }

            System.out.println(FORMATTER.format(today.getTime()));  //07/14/2018 at 03:05PM EDT
            System.out.println(FORMATTER.format(today.getTime()));

    }
}*/
