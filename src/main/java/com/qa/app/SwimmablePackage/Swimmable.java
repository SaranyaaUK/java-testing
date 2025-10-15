package com.qa.app.SwimmablePackage;

import com.qa.app.SwimmablePackage.HomosapiensPackage.CantSwimException;

import java.awt.Point;




public interface Swimmable {
    // Return set of coordinates where the object 
    // is located after swimming in random direction
    public abstract Point swim(Direction direction) throws CantSwimException;

    enum Direction {
        UP,
        DOWN,
        LEFT,
        RIGHT
    }
}
