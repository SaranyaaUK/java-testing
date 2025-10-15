import java.awt.*;
import java.util.ArrayList;

import com.qa.app.SwimmablePackage.FishPackage.Blobfish;
import com.qa.app.SwimmablePackage.FishPackage.Clownfish;
import com.qa.app.SwimmablePackage.HomosapiensPackage.Human;
import com.qa.app.SwimmablePackage.Swimmable;

public class Main {
    public static void main(String[] args) {

        Clownfish nemo = new Clownfish(5, 1.0f);

        Blobfish panya = new Blobfish(15, 8.0f, Color.PINK);

        System.out.println("Is Blob Fish ugly?");
        if(panya.getIsUgly().isPresent()){
            System.out.println(panya.getIsUgly().get() ? "Is Ugly" : "Is Not Ugly");
        } else {
            System.out.println("Not sure!");
        }

        ArrayList<Swimmable> swimmables = new ArrayList<>();
        swimmables.add(nemo);
        swimmables.add(panya);
        swimmables.add(new Human("Ranya"));


        // Filter humans that can think from swimmables list
        ArrayList<Human> thinkers = Human.filterHumans(swimmables);
        System.out.println("Humans that can think:");
        for (Human thinker : thinkers) {
            System.out.println(thinker.toString());
        }
        System.out.println(" ");

        for (Swimmable swimmable : swimmables) {
            System.out.println(swimmable.toString());
            try {
                swimmable.swim(Swimmable.Direction.UP);
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
            System.out.println(" ");
        }
    }
}