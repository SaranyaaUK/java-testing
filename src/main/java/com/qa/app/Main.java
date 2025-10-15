import java.awt.*;
import java.util.ArrayList;

import SwimmablePackage.FishPackage.Blobfish;
import SwimmablePackage.FishPackage.Clownfish;
import SwimmablePackage.HomosapiensPackage.Human;
import SwimmablePackage.Swimmable;

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
                swimmable.swim();
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
            System.out.println(" ");
        }
    }
}