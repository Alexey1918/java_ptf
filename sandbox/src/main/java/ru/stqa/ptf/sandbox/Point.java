package ru.stqa.ptf.sandbox;

public class Point {

    double x;
    double y;

    public Point(double x,double y){
        this.x = x;
        this.y = y;
    }

    public double distance(Point a,Point b){

        return  Math.sqrt((b.x - a.x)*(b.x - a.x) + (b.y - a.y)*(b.y - a.y));
    }

}
