package com.qa.app.SwimmablePackage.FishPackage;
import com.qa.app.SwimmablePackage.Swimmable;

import java.awt.*;
import java.util.ArrayList;

import com.qa.app.SwimmablePackage.HomosapiensPackage.CantSwimException;

public abstract class Fish implements Swimmable {
    private int length;
    private float weight;
    private Color color;
    protected Boolean hasGills = true;
    private Point location;

    public Fish(int length, float weight, Color color){
        this.length = length;
        this.weight = weight;
        this.color = color;
        this.location = new Point(0, 0);
    }

    public Fish(int length, float weight){
        this(length, weight, Color.GRAY);
    }

    public abstract ArrayList<String> eat();

    @Override
    public Point swim(int direction) throws CantSwimException {
        if (!hasGills) {
            throw new CantSwimException("Exception: I can't swim without gills!");
        }
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

    public int getLength() throws IllegalArgumentException {
        if (length <= 0) {
            throw new IllegalArgumentException("Length must be positive");
        }
        return length;
    }

    public void setLength(int length) throws IllegalArgumentException {
        if (length <= 0) {
            throw new IllegalArgumentException("Length must be positive");
        }
        this.length = length;
    }

    public float getWeight() throws IllegalArgumentException {
        if (weight <= 0) {
            throw new IllegalArgumentException("Weight must be positive");
        }
        return weight;
    }

    public void setWeight(float weight) throws IllegalArgumentException {
        if (weight <= 0) {
            throw new IllegalArgumentException("Weight must be positive");
        }
        this.weight = weight;
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) throws IllegalArgumentException {
        if (color == null) {
            throw new IllegalArgumentException("Color cannot be null");
        }
        this.color = color;
    }

    public Boolean getHasGills() {
        return hasGills;
    }

    public void setHasGills(Boolean hasGills) {
        this.hasGills = hasGills;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Fish: ");
        sb.append("length=").append(length);
        sb.append(", weight=").append(weight);
        sb.append(", color=").append(color.getRed()).append(",").append(color.getGreen()).append(",").append(color.getBlue());
        sb.append(", hasGills=").append(hasGills);
        return sb.toString();
    }


}
