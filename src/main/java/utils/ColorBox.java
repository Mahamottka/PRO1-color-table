package utils;

import javax.swing.*;
import java.awt.*;

public class ColorBox extends JPanel {
    private String hexCode;

    public ColorBox(String hexCode) {
        this.hexCode = hexCode;
        setPreferredSize(new Dimension(50, 50)); // Set the preferred size of the color box
    }

    public void setHexCode(String hexCode) {
        this.hexCode = hexCode;
        repaint(); // Repaint the component to reflect the new color
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        if (hexCode == null){
            hexCode = "#FFFFFF";
        }

        Color color = Color.decode(hexCode); // Decode the hexadecimal code into a Color object
        g.setColor(color); // Set the color to be painted

        // Fill a rectangle with the color
        g.fillRect(0, 0, getWidth(), getHeight());
    }
}
