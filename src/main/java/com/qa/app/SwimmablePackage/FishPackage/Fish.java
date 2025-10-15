package SwimmablePackage.FishPackage;
import SwimmablePackage.Swimmable;

import java.awt.*;
import java.util.ArrayList;

public abstract class Fish implements Swimmable {
    private int length;
    private float weight;
    private Color color;
    protected static Boolean hasGills = true;

    public Fish(int length, float weight, Color color){
        this.length = length;
        this.weight = weight;
        this.color = color;
    }

    public Fish(int length, float weight){
        this(length, weight, Color.GRAY);
    }

    public abstract ArrayList<String> eat();

    public void swim() {
        System.out.println("I'm swimming!!");
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

    public static Boolean getHasGills() {
        return hasGills;
    }

    public static void setHasGills(Boolean hasGills) {
        Fish.hasGills = hasGills;
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
