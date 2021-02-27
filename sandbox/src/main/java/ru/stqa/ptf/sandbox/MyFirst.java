package ru.stqa.ptf.sandbox;

public class MyFirst{
      
     public static void main(String[] args){

         Point a = new Point(2,2);
         Point b = new Point(8,8);

         System.out.println("Расстояние равно " + a.distance(a,b) + " см.");

         Square c = new Square(5);
         System.out.println("Площадь равна " + c.area());




   }
}