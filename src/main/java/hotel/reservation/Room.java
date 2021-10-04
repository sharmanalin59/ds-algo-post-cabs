package hotel.reservation;

import java.util.Objects;

public class Room {

    public Room(int id, int hotelId, RoomType type, float ratePerHour) {
        this.id = id;
        this.hotelId = hotelId;
        this.type = type;
        this.ratePerHour = ratePerHour;
    }

    private int id;
    private int hotelId;
    RoomType type;
    float ratePerHour;

    public int getId() {
        return id;
    }

    public int getHotelId() {
        return hotelId;
    }

    public RoomType getType() {
        return type;
    }

    public float getRatePerHour() {
        return ratePerHour;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Room room = (Room) o;
        return id == room.id &&
                hotelId == room.hotelId &&
                Float.compare(room.ratePerHour, ratePerHour) == 0 &&
                type == room.type;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, hotelId, type, ratePerHour);
    }
}
