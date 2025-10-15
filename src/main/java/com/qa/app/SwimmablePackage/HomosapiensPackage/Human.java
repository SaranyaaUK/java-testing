package com.qa.app.SwimmablePackage.HomosapiensPackage;

import com.qa.app.SwimmablePackage.Swimmable;

import com.qa.app.SwimmablePackage.HomosapiensPackage.CantSwimException;

import java.awt.Point;

public class Human extends Homosapiens implements Swimmable {
    private String name;
    private Point location;
    private int stamina;

    public Human(String name) {
        this.name = name;
        this.location = new Point(0, 0);
        this.stamina = 100;
    }

    @Override
    public void think() {
        System.out.println("I'm using my brain!");
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
