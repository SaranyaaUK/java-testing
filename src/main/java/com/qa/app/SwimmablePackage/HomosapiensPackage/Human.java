package SwimmablePackage.HomosapiensPackage;

import SwimmablePackage.Swimmable;

import SwimmablePackage.HomosapiensPackage.CantSwimException;

public class Human extends Homosapiens implements Swimmable {
    String name;

    public Human(String name) {
        this.name = name;
    }

    @Override
    public void think() {
        System.out.println("I'm using my brain!");
    }

    // Generate random either 1 or 0
    public void trySwimming() throws CantSwimException {
        int randomValue = (int) (Math.random() * 2);
        if (randomValue == 0) {
            throw new CantSwimException("Exception: I can't swim!");
        }
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
    public void swim() throws CantSwimException {
        trySwimming();
        System.out.println("I'm swimming!");
    }
}
