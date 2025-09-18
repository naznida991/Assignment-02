package pack4;

public class AreaCalculator {

    private double area;
    private final double pi = 3.14;


    public double area(double radius) {
        return pi * radius * radius;
    }

    public double area(double length, double width) {
        return length * width;
    }

    /*int side is used instead of double because it doesn't violate overloading rules and if use
    double side then argument in first and third function will become same which will give us error */


    public double area(int side) {
        return side * side;
    }



        public static void main(String[] args) {
            AreaCalculator a=new AreaCalculator();
            System.out.println("Area of Circle = "+a.area(5.9));
            System.out.println("Area of Rectangle = "+a.area(5.9,8.6));
            System.out.println("Area of square  = "+a.area(5));

        }


}

