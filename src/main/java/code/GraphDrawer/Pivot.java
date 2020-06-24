package code.GraphDrawer;

public class Pivot {
    int height;
    int width;
    int xAxis;
    int yAxis;
    double scale;

    public Pivot(int height, int width, int xAxis, int yAxis, double scale) {
        this.height = height;
        this.width = width;
        this.xAxis = xAxis;
        this.yAxis = yAxis;
        this.scale = scale;
    }

    public double pixelsToX(int pixels) {
        return (pixels - yAxis)/scale;
    }

    public int xToPixels(double x) {
        return (int) (x*scale + yAxis);
    }

    public double pixelsToY(int pixels) {
        return (xAxis - pixels)/scale;
    }

    public int yToPixels(double y) {
        return (int) (xAxis - y * scale);
    }

}
