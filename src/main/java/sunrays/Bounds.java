package sunrays;

public class Bounds {
    private final double xMin;
    private final double xMax;
    private final double yMin;
    private final double yMax;
    
    public Bounds( double xMin, double xMax, 
            double yMin, double yMax ) {
        this.xMin = xMin;
        this.xMax = xMax;
        this.yMin = yMin;
        this.yMax = yMax;
    } // Bounds( double, double, double, double )

    public double getxMin() {
        return this.xMin;
    } // getxMin()

    public double getxMax() {
        return this.xMax;
    } // getxMax()

    public double getyMin() {
        return this.yMin;
    } // getyMin()

    public double getyMax() {
        return this.yMax;
    } // getyMax()
} // Bounds
        

