package hotel.reservation;

import java.util.List;

public class Hotel {

    public Hotel(int id, String name, String des, String adress) {
        this.id = id;
        this.name = name;
        this.des = des;
        this.adress = adress;
    }

    private int id;
    private String name;
    private String des;
    private String adress;
    private List<Room> rooms;

    void addRoom(Room room) {
        rooms.add(room);
    }

    boolean removeRoom(Room room) {
        return rooms.remove(room);
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getDes() {
        return des;
    }

    public String getAdress() {
        return adress;
    }

    public List<Room> getRooms() {
        return rooms;
    }
}
