package parking.lot;

import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Stream;

/**
 * @author nalin.sharma on 06/07/21
 */
public class ParkingLot {

    static Map<Integer, Entrance> entranceMap;
    static Map<Integer, Exit> exitMap;

    static Map<String, Building> parkingSpace;

    static Map<SlotType, Double> ratePerHour = new HashMap<>();

    ParkingLot() {

    }

    List<Building> priorityParking() {
return null;
    }

    void addEntrance(int i) {
        if(entranceMap.containsKey(i)) {
            throw new RuntimeException("Entrance already present");
        }
        entranceMap.put(i, new Entrance(i));
    }

    void addExit(int i) {
        if(exitMap.containsKey(i)) {
            throw new RuntimeException("Exit already present");
        }
        exitMap.put(i, new Exit(i));
    }

    void addFloor(String buildingName, String number) {
        if(!parkingSpace.containsKey(buildingName)) {
            throw new RuntimeException("Building not present");
        }
        int maxFloor = Integer.parseInt(parkingSpace.get(buildingName)
                .floors.keySet().stream()
                .max((f1,f2) -> f1.compareTo(f2))
                .get());
        if(maxFloor != Integer.parseInt(number) + 1) {
            throw new RuntimeException("Floor number should be "+ (maxFloor+1) );
        }
        Floor f = new Floor();
        f.number = number;
        parkingSpace.get(buildingName).floors.put(number, f);
    }

    void addSlot(String buildingName, String floorNumber, SlotType slotType, String slotRow, String slotCol) {
        if(!parkingSpace.containsKey(buildingName)) {
            throw new RuntimeException("Building not present");
        }
        if(parkingSpace.get(buildingName).floors.keySet().stream().noneMatch(f -> f.equals(floorNumber))) {
            throw new RuntimeException("Floor Element present");
        }
        if(parkingSpace.get(buildingName).floors.get(floorNumber).slots.values().stream()
                .anyMatch(s-> s.row.equals(slotRow) && s.col.equals(slotCol))) {
            throw new RuntimeException("Slot already occupied");
        }
        Slot s = new Slot(slotRow, slotCol, slotType, floorNumber, buildingName);
        parkingSpace.get(buildingName).floors.get(floorNumber).slots.put(slotType, s);
        parkingSpace.get(buildingName).availableSlots.get(slotType).addAndGet(1);
    }

    static class Vehicle {
        String name;
        SlotType slotType;
        String numberPlate;
        Slot at;
        String nearBuilding;
    }

    static class Token {
        Slot slot;
        Vehicle vehicle;
        long startTime;
        long endTime;
    }

    static class Building {
        String name;
        String address;
        Map<SlotType, AtomicInteger> availableSlots = new HashMap<>();
        Map<String, Floor> floors;
    }
    static class Floor {
        String number;
        Map<SlotType, Slot> slots;
        Set<String> usedSlots;
    }
    static class Slot {
        String row;
        String col;
        String floor;
        String building;
        SlotType slotType;
        Set<Vehicle> vehicles;

        public Slot(String row, String col, SlotType slotType, String floor, String building) {
            this.row = row;
            this.col = col;
            this.slotType = slotType;
            this.building = building;
            this.floor = floor;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Slot slot = (Slot) o;
            return Objects.equals(row, slot.row) &&
                    Objects.equals(col, slot.col) &&
                    Objects.equals(floor, slot.floor) &&
                    Objects.equals(building, slot.building);
        }

        @Override
        public int hashCode() {
            return Objects.hash(row, col, floor, building);
        }
    }

    static class Entrance {
        int gate;
        Set<Vehicle> vehiclesPassed;

        Entrance(int i) {
            gate = i;
        }
        Slot allot(Vehicle v) {
            //check rates
            Stream.of(SlotType.values());
            int a[] = {};
            Stream.of(a);

            if(ratePerHour.size() == 0
                    ||
                    Arrays.stream(SlotType.values())
                            .anyMatch(s-> !ratePerHour.containsKey(s)
                                    || ratePerHour.get(s) < 0)) {
                throw new RuntimeException("Set the Rate first");
            }
            //parkingSpace.
            return null;
        }
    }

    static class Exit {
        int gate;
        Set<Vehicle> vehiclesPassed;

        Exit(int i) {
            gate = i;
        }
        double deduct(Vehicle v, Token t) throws Exception {
            if(t.slot != v.at) {
                throw new Exception("Token mismatch");
            }
            return (t.endTime - t.startTime) * ratePerHour.get(v.slotType);
        }
    }
}
