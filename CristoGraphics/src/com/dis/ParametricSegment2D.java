package com.dis;

public class ParametricSegment2D {

    double x0, y0;
    double dx, dy;

    public ParametricSegment2D(double x0, double y0, double x1, double y1) {
        this.x0 = x0;
        this.y0 = y0;
        this.dx = x1 - x0;
        this.dy = y1 - y0;
    }

    public double xEquation(ParametricSegment2D eq, double t) {
        return eq.x0 + t * eq.dx;
    }

    public double yEquation(ParametricSegment2D eq, double t) {
        return eq.y0 + t * eq.dy;
    }

    @Override
    public String toString() {
        return ("x = " + this.x0 + "+t(" + this.dx + ")\n")
                + ("y = " + this.y0 + "+t(" + this.dy + ")\n");
    }
}
