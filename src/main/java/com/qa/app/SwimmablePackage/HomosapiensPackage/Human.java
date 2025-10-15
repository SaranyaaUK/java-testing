package com.qa.app.SwimmablePackage.HomosapiensPackage;

import com.qa.app.SwimmablePackage.Swimmable;

import com.qa.app.SwimmablePackage.HomosapiensPackage.CantSwimException;

import java.awt.Point;

import java.util.ArrayList;

public class Human extends Homosapiens implements Swimmable {
    private String name;
    private Point location;
    private int stamina;

    public Human(String name) {
        super();
        this.name = name;
        this.location = new Point(0, 0);
        this.stamina = 100;
    }

    @Override
    public Boolean think() {
        return iq > 60;
    }

    public void trySwimming() throws CantSwimException {
        if (stamina <= 0) {
            throw new CantSwimException("Exception: I'm too tired to swim!");
        }
        stamina -= 10; // Decrease stamina with each swim attempt
    }

    // getters and setters for swimmable attributes
    public int getStamina() {
        return stamina;
    }

    public void setStamina(int stamina) {
        this.stamina = stamina;
    }

    // Override to string method
    @Override
    public String toString() {
        // use string builder
        StringBuilder sb = new StringBuilder();
        sb.append("Human: ");
        sb.append("Name: ").append(name);
        sb.append(", IQ: ").append(iq);
        sb.append(", Stamina: ").append(stamina);
        sb.append(", Location: (").append(location.x).append(", ").append(location.y).append(")");
        return sb.toString();  
    }

    @Override
    public Point swim(Swimmable.Direction direction) throws CantSwimException {
        trySwimming();

        switch (direction) {
            case UP: // up
                location.translate(0, 1);
                break;
            case DOWN: // down
                location.translate(0, -1);
                break;
            case LEFT: // left
                location.translate(-1, 0);
                break;
            case RIGHT: // right
                location.translate(1, 0);
                break;
        }
        return location;
    }

    // filter Humans from list of Objects
    public static <T> ArrayList<Human> filterHumans(ArrayList<T> swimmables) {
        ArrayList<Human> humans = new ArrayList<>();
        for (T swimmable : swimmables) {
            if (swimmable instanceof Human) {
                humans.add((Human) swimmable);
            }
        }
        return humans;
    }
}
