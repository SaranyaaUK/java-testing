package SwimmablePackage.FishPackage;
import java.awt.Color;

public class Clownfish extends Fish {
    public Clownfish(int length, float weight) {
        super(length, weight, Color.ORANGE);
    }

    @Override
    public void eat() {
        System.out.println("I eat algae, zooplankton (like copepods), small crustaceans, and leftover food from their host anemones.");
    }

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
