package com.dis;

public class ParametricSegment3D {

    double x0, y0, z0;
    double dx, dy, dz;

    public ParametricSegment3D(double x0, double y0, double z0, double x1, double y1, double z1) {
        this.x0 = x0;
        this.y0 = y0;
        this.z0 = z0;
        this.dx = x1 - x0;
        this.dy = y1 - y0;
        this.dz = z1 - z0;
    }

    public double xEquation(ParametricSegment3D eq, double t) {
        return eq.x0 + t * eq.dx;
    }

    public double yEquation(ParametricSegment3D eq, double t) {
        return eq.y0 + t * eq.dy;
    }

    public double zEquation(ParametricSegment3D eq, double t) {
        return eq.z0 + t * eq.dz;
    }

    @Override
    public String toString() {
        return ("x = " + this.x0 + "+t(" + this.dx + ")\n")
                + ("y = " + this.y0 + "+t(" + this.dy + ")\n")
                + ("z = " + this.z0 + "+t(" + this.dz + ")\n");
    }
}
