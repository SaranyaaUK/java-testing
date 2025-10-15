package SwimmablePackage.FishPackage;
import java.awt.Color;

import java.util.ArrayList;

public class Blobfish extends Fish {
    
    private static boolean isUgly = true;

    public Blobfish(int length, float weight, Color color) {
        super(length, weight, color);
    }

    public static boolean getIsUgly() {
        return isUgly;
    }

    @Override
    public ArrayList<String> eat() {
        ArrayList<String> food = new ArrayList<>();
        food.add("small invertebrates");
        food.add("carrion that float around me");
        return food;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Blobfish: ");
        sb.append("length=").append(getLength());
        sb.append(", weight=").append(getWeight());
        sb.append(", color=").append(getColor().getRed()).append(",").append(getColor().getGreen()).append(",").append(getColor().getBlue());
        sb.append(", hasGills=").append(hasGills);
        return sb.toString();
    }
}
