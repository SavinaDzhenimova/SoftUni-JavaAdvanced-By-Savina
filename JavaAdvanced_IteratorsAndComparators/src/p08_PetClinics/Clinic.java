package p08_PetClinics;

import java.util.HashMap;
import java.util.Map;

public class Clinic {
    private final String name;
    private int roomsCount;
    private final Map<Integer, Pet> rooms;

    public Clinic(String name, int roomsCount) throws Exception {
        this.name = name;
        setRoomsCount(roomsCount);
        rooms = new HashMap<>();

        for (int i = 1; i <= roomsCount; i++) {
            rooms.put(i, null);
        }
    }

    public String getName() {
        return this.name;
    }

    public void setRoomsCount(int roomsCount) throws Exception {
        if (roomsCount % 2 == 0) {
            throw new Exception("Invalid Operation!");
        }

        this.roomsCount = roomsCount;
    }

    public boolean addPet(Pet pet) {
        int middleRoom = roomsCount / 2 + 1;

        for (int i = 0; i < middleRoom; i++) {
            if (rooms.get(middleRoom - i) == null) {
                rooms.put(middleRoom - i, pet);
                return true;
            } else if (rooms.get(middleRoom + i) == null) {
                rooms.put(middleRoom + i, pet);
                return true;
            }
        }

        return false;
    }

    public boolean release(){
        int middleRoom = roomsCount / 2 + 1;

        for (int i = middleRoom; i <= roomsCount; i++) {
            if (rooms.get(i) != null) {
                rooms.put(i, null);
                return true;
            }
        }

        for (int i = middleRoom; i >= 1; i--) {
            if (rooms.get(i) != null) {
                rooms.put(i, null);
                return true;
            }
        }

        return false;
    }

    public boolean hasEmptyRooms() {
        final boolean[] hasNull = {false};

        rooms.forEach((key, value) -> {
            if (value == null) {
                hasNull[0] = true;
            }
        });

        return hasNull[0];
    }

    public void printRoom(int room) {
        rooms.entrySet()
                .stream()
                .filter(e -> e.getKey() == room)
                .forEach(e -> {
                    if (e.getValue() != null) {
                        System.out.println(e.getValue());
                    } else {
                        System.out.println("Room empty");
                    }
                });
    }

    public void printAllRooms() {
        rooms.forEach((key, value) -> {
                    if (value != null) {
                        System.out.println(value);
                    } else {
                        System.out.println("Room empty");
                    }
                });
    }
}