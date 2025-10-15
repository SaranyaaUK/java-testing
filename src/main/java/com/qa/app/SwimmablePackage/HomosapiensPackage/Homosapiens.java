package com.qa.app.SwimmablePackage.HomosapiensPackage;

public abstract class Homosapiens {
    protected int iq;

    public Homosapiens() {
        this.iq = 30 + (int)(Math.random() * ((130 - 30) + 1));
    }

    public int getIq() {
        return iq;
    }

    public void setIq(int iq) {
        this.iq = iq;
    }

    public abstract Boolean think();
}
