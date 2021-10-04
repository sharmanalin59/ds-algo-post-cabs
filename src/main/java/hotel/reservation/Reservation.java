package hotel.reservation;

import java.util.Date;
import java.util.List;

public class Reservation {

    public Reservation(int fromTime, int endTime, List<Room> rooms, int hotelId, int userId) {
        this.fromTime = fromTime;
        this.endTime = endTime;
        this.rooms = rooms;
        this.hotelId = hotelId;
        this.userId = userId;
    }

    private int fromTime;
    private int endTime;
    private List<Room> rooms;
    private int hotelId;
    private int userId;

    public int getFromTime() {
        return fromTime;
    }

    public int getEndTime() {
        return endTime;
    }

    public List<Room> getRooms() {
        return rooms;
    }

    public int getHotelId() {
        return hotelId;
    }

    public int getUserId() {
        return userId;
    }
}
