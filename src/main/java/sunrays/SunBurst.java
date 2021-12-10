package sunrays;

import java.awt.geom.Line2D;
import java.awt.geom.Point2D;
import java.util.ArrayList;
import java.util.List;

public class SunBurst {
    private final List<Line2D> rays;
    
    public SunBurst( int numberOfRays, 
            double minorRadius, double majorRadius ) {
        this.rays = new ArrayList<>();
                
        for( int i = 0; i < numberOfRays; i++ ) {
            double fraction = ((double) i)/numberOfRays;
            double angle = fraction * 2.0 * Math.PI;
            double x0 = minorRadius * Math.cos( angle );
            double y0 = minorRadius * Math.sin( angle );
            double x1 = majorRadius * Math.cos( angle );
            double y1 = majorRadius * Math.sin( angle );
            Point2D p0 = new Point2D.Double( x0, y0);
            Point2D p1 = new Point2D.Double( x1, y1);
            Line2D ray = new Line2D.Double( p0, p1 );
            this.rays.add( ray );
        } // for
    } // SunBurst( int )
    
    public List<Line2D> getRays() {
        return this.rays;
    } // getRays()
} // SunBurst