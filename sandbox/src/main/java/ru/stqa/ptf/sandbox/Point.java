package ru.stqa.ptf.sandbox;

public class Point {

    double x;
    double y;

    public Point(double x,double y){
        this.x = x;
        this.y = y;
    }

    public double distance(Point b){

        return  Math.sqrt((b.x - this.x)*(b.x - this.x) + (b.y - this.y)*(b.y - this.y));
    }

}
