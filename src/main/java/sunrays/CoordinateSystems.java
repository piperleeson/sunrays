package sunrays;

import java.awt.geom.Line2D;
import java.awt.geom.Point2D;

public class CoordinateSystems {
    private final Bounds world;
    private final Bounds device;
    
    public CoordinateSystems( Bounds world, Bounds device ) {
        this.world = world;
        this.device = device;
    } // CoordinateSystems( Bounds, Bounds )
    
    public Point2D mapPoint( Point2D p ) {
        double x = p.getX();
        double y = p.getY();
        
        double xMin = world.getxMin();
        double xMax = world.getxMax();
        
        double yMin = world.getyMin();
        double yMax = world.getyMax();
        
        double uMin = device.getxMin();
        double uMax = device.getxMax();
        
        double vMin = device.getyMin();
        double vMax = device.getyMax();
        
        x = uMin + (x - xMin)/(xMax - xMin) * (uMax - uMin);
        y = vMin + (y - yMin)/(yMax - yMin) * (vMax - vMin);
        
        return new Point2D.Double( x, y );
    } // mapPoint( Point2D )
    
    public Line2D mapLine( Line2D line ) {
        Point2D p1 = line.getP1();
        Point2D p2 = line.getP2();
        
        p1 = this.mapPoint( p1 );
        p2 = this.mapPoint( p2);
        
        return new Line2D.Double( p1, p2 );
    } // Line2D( Line2D )
} // CoordinateSystems

