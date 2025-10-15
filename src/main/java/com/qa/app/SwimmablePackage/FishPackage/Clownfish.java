package com.qa.app.SwimmablePackage.FishPackage;
import java.awt.Color;
import java.util.ArrayList;

public class Clownfish extends Fish {
    public Clownfish(int length, float weight) {
        super(length, weight, Color.ORANGE);
    }

    @Override
    public ArrayList<String> eat() {
        ArrayList<String> food = new ArrayList<>();
        food.add("algae");
        food.add("zooplankton (like copepods)");
        food.add("small crustaceans");
        food.add("leftover food from their host anemones");
        return food;
    }

    // generics examplem method
    

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Clownfish: ");
        sb.append("length=").append(getLength());
        sb.append(", weight=").append(getWeight());
        sb.append(", color=").append(getColor().getRed()).append(",").append(getColor().getGreen()).append(",").append(getColor().getBlue());
        sb.append(", hasGills=").append(hasGills);
        return sb.toString();
    }
}
