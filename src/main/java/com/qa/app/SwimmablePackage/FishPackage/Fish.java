package SwimmablePackage.FishPackage;
import SwimmablePackage.Swimmable;

import java.awt.*;

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

    public abstract void eat();

    public void swim() {
        System.out.println("I'm swimming!!");
    }

    public int getLength() {
        return length;
    }

    public void setLength(int length) {
        this.length = length;
    }

    public float getWeight() {
        return weight;
    }

    public void setWeight(float weight) {
        this.weight = weight;
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
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
