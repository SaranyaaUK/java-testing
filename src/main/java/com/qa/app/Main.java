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

        ArrayList<Swimmable> swimmables = new ArrayList<>();
        swimmables.add(nemo);
        swimmables.add(panya);
        swimmables.add(new Human("Ranya"));

        for (Swimmable swimmable : swimmables) {
            System.out.println(swimmable.toString());
            try {
                swimmable.swim(1);
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
            System.out.println(" ");
        }
    }
}