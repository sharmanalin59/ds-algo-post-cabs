package hotel.reservation;

import java.util.*;

public class Api {

    /**
     * 
     * req
     * {
     * hotel: {hotel-id}
     * from:
     * to:
     * num_rooms:[premium,2,oridanry,3]
     * }
     * 
     * resp
     * {success}
     */

    Hotel h = new Hotel(1,"Hyatt","Hyatt","M G road");
    List<Hotel> hotels = new ArrayList<>();
    Map<Integer,List<Reservation>> reservationListForHotel = new HashMap<>();

    {
        hotels.add(h);
        h.addRoom(new Room(1,1,RoomType.ordinary,500));
        h.addRoom(new Room(2,1,RoomType.ordinary,500));
        h.addRoom(new Room(3,1,RoomType.premium,500));
        h.addRoom(new Room(4,1,RoomType.premium,500));
    }

    boolean bookHotelRoom(int hotelId, int from, int to, int [] roomsByRoomType, int userId) {

        List<Reservation> revList = reservationListForHotel.get(hotelId);
        int premiumRooms = roomsByRoomType[1];
        int ordRooms = roomsByRoomType[3];
        if (to >= from) {
            Set<Room> premiumRoomSet = new HashSet<>();
            Set<Room> ordRoomSet = new HashSet<>();
            for (Reservation res : revList) {
                /**
                 *
                 *        2   6
                 *   1(from)       5(to)
                 *
                 */
                for(Room room : res.getRooms()) {
                    if ((res.getEndTime() < from || res.getFromTime() > to)) {
                        if (room.type == RoomType.ordinary)
                            ordRoomSet.add(room);
                        if (room.type == RoomType.premium)
                            premiumRoomSet.add(room);
                    }
                }
            }

            if(premiumRooms > premiumRoomSet.size() || ordRooms > ordRoomSet.size()) {
                List<Room> rooms = h.getRooms();

                for(Room room : rooms) {
                    if(!ordRoomSet.contains(room) && !premiumRoomSet.contains(room)) {
                        if (premiumRooms > premiumRoomSet.size() && room.getType() == RoomType.premium) {
                            premiumRoomSet.add(room);
                        } else if (ordRooms > ordRoomSet.size() && room.getType() == RoomType.ordinary) {
                            ordRoomSet.add(room);
                        }
                    }
                }
            }

            if(premiumRooms == premiumRoomSet.size() && ordRooms == ordRoomSet.size()) {
                List<Room> reserveRooms = new ArrayList<>(premiumRoomSet);
                reserveRooms.addAll(ordRoomSet);
                reservationListForHotel.get(hotelId).add(new Reservation(from, to, reserveRooms, hotelId,userId));
                return true;
            }
            return false;
        }
        return false;
    }
}
