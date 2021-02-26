package ru.stqa.ptf.sandbox;

public class MyFirst{
      
     public static void main(String[] args){

         Point a = new Point(3,4);
         Point b = new Point(5,6);

         System.out.println("Расстояние равно " + a.distance(a,b) + " см.");


   }
}