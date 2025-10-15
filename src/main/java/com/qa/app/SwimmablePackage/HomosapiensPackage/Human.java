package com.qa.app.SwimmablePackage.HomosapiensPackage;

import com.qa.app.SwimmablePackage.Swimmable;

import com.qa.app.SwimmablePackage.HomosapiensPackage.CantSwimException;

import java.awt.Point;

public class Human extends Homosapiens implements Swimmable {
    String name;
    Point location;

    public Human(String name) {
        this.name = name;
        this.location = new Point(0, 0);
    }

    @Override
    public void think() {
        System.out.println("I'm using my brain!");
    }

    // Generate random either 1 or 0
    public void trySwimming() throws CantSwimException {
        int randomValue = (int) (Math.random() * 2);
        if (randomValue == 0) {
            throw new CantSwimException("Exception: I can't swim!");
        }
    }

    // Override to string method
    @Override
    public String toString() {
        // use string builder
        StringBuilder sb = new StringBuilder();
        sb.append("Human: ");
        sb.append("Name: ").append(name);
        return sb.toString();  
    }

    @Override
    public Point swim(int direction) throws CantSwimException {
        trySwimming();

        switch (direction) {
            case 0: // up
                location.translate(0, 1);
                break;
            case 1: // down
                location.translate(0, -1);
                break;
            case 2: // left
                location.translate(-1, 0);
                break;
            case 3: // right
                location.translate(1, 0);
                break;
        }
        return location;
    }
}
