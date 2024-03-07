package part9._interfaces;

import java.time.DateTimeException;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.LocalDateTime;

public interface Readable {
    // an interface is a contract of behaviour
    // interfaces define behaviour through method names and return types
    // methods in interfaces are public by default (unless made private)

    // methods in interfaces may or may not have method bodies
    String read();

    static ZoneId getZoneId (String zoneString) {
        try {
            return ZoneId.of(zoneString);
        } catch (DateTimeException e) {
            System.err.println("Invalid time zone: " + zoneString +"; using default time zone instead.");
            return ZoneId.systemDefault();
        }
    }

    default ZonedDateTime getZonedDateTime(String zoneString) {
        return ZonedDateTime.of(LocalDateTime.now(), getZoneId(zoneString));
    }
}
