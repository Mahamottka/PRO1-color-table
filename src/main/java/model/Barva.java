package model;

public class Barva {

    private int red;
    private int green;
    private int blue;
    private String hexa;

    public Barva(int red, int green, int blue) {
        this.red = red;
        this.green = green;
        this.blue = blue;
        rgbToHex();
    }

    public String getHexa() {
        return hexa;
    }

    public void setHexa(String hexa) {
        this.hexa = hexa;
    }

    public int getRed() {
        return red;
    }

    public void setRed(int red) {
        this.red = red;
    }

    public int getGreen() {
        return green;
    }

    public void setGreen(int green) {
        this.green = green;
    }

    public int getBlue() {
        return blue;
    }

    public void setBlue(int blue) {
        this.blue = blue;
    }

    public void rgbToHex() {
        String hexCode = String.format("#%02X%02X%02X", red, green, blue);
        hexa = hexCode;
    }
}
