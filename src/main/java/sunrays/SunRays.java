package sunrays;

import java.awt.Container;
import javax.swing.JFrame;

public class SunRays extends JFrame {

    // TO-DO: Experiment with different values
    // for FRAME_WIDTH and FRAME_HEIGHT.
    private static final int FRAME_WIDTH = 768;
    private static final int FRAME_HEIGHT = 768;
    private static final String FRAME_TITLE = "Sun Rays";

    public SunRays() {
        this.setSize(FRAME_WIDTH, FRAME_HEIGHT);
        this.setTitle(FRAME_TITLE);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Container pane = this.getContentPane();
        pane.add( new SunRaysPanel() );
        this.setVisible(true);
    } // SunRays()

    public static void main(String[] args) {
        SunRays sunRays = new SunRays();
    } // main( String [] )

} //
