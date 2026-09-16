package com.design.elevator;

import java.util.List;
import java.util.ArrayList;

public class Building {

    List<Floor> floors = new ArrayList<>();

    public Building(int totalFloors, ExternalDispatcher externalDispatcher) {

        for (int i = 1; i <= totalFloors; i++) {

            ExternalButton upButton =
                    new ExternalButton(externalDispatcher);

            ExternalButton downButton =
                    new ExternalButton(externalDispatcher);

            floors.add(new Floor(i, upButton, downButton));
        }
    }

    public Floor getFloor(int floor) {
        return floors.get(floor - 1);
    }
}