package sunrays;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.Line2D;
import static java.lang.Math.random;
import javax.swing.JPanel;
import java.util.Random; 

public class SunRaysPanel extends JPanel {
    // TO-DO: Experiment with different colors.
    public static int getNum() {
        return (int) ((Math.random() * (255 - 0)) + 0);
    }
    
    private static final Color BG_COLOR = new Color(getNum(), getNum(), getNum());
    private static final Color RAYS_0 = new Color(getNum(), getNum(), getNum());
    private static final Color RAYS_1 = new Color(getNum(), getNum(), getNum());

    public SunRaysPanel() {
        this.setBackground(BG_COLOR);
    } // SunRaysPanel()

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2D = (Graphics2D) g;

        // TO-DO: Experiment with other values
        // of dx and dy.
        double dx = 0.02;
        double dy = 0.01;

        Bounds world0 = new Bounds(-1.0, +1.0, -1.0, +1.0);
        Bounds world1 = new Bounds(-1.0 + dx, +1.0 + dx,
                -1.0 + dy, +1.0 + dy);

        // Retrieve the width and height of
        // the panel on which we are drawing
        // the picture.
        int w = this.getWidth();
        int h = this.getHeight();

        Bounds device = new Bounds(0.0, w, 0.0, h);

        CoordinateSystems cs0 = new CoordinateSystems(world0, device);
        CoordinateSystems cs1 = new CoordinateSystems(world1, device);

        // TO-DO: Experiment with other values
        // for numberOfRays.
        // The values should be positive.
        int numberOfRays = 350;
        // TO-DO: Experiment with other values
        // of minorRadius and majorRadius.
        // (Both values should lie between 0.0 and 1.0.
        // The minorRadius should be less than majorRadius.)
        double minorRadius = 0.4;
        double majorRadius = 0.9;
        SunBurst sunBurst = new SunBurst(numberOfRays, 
                minorRadius, majorRadius);

        // TO-DO: Experiment with other values
        // for the thickness of the lines.
        // The constructor for the BasicStroke
        // class calls for a parameter whose
        // type is float (not double!).
        // To write a float literal, follow
        // the number with the letter F.
        // 1.5 is a double precision floating point literal.
        // 1.5F is a single precision floating point literal.
        float thickness = 2.0F;
        g2D.setStroke(new BasicStroke(thickness));

        // Draw two copies of the rays.
        // TO-DO: Can you see a way to draw
        // more than two copies of the rays?
        // Hints: 
        // (0) Define a variable world2 that
        //     is like world0 and world1, but is offset
        //     slightly from both. 
        // (1) Define a variable cs2 that is like cs0 and cs1. 
        // (2) Define a constant RAYS_2 that is like RAYS_0
        //     and Rays_1.
        // (3) Add a third pair of statements to the for
        //     loop here. This pair of statements will look
        //     like the existing two pairs of statements.
        for (Line2D ray : sunBurst.getRays()) {
            g2D.setColor(RAYS_0);
            g2D.draw(cs0.mapLine(ray));
            
            g2D.setColor(RAYS_1);
            g2D.draw(cs1.mapLine(ray));
        } // for    
    } // paintComponent( Graphics )
} // SunRaysPanel