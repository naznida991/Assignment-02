package pack4;

public class Main_of_Pizza_Billing_System {
    public static void main(String[] args) {
        AreaCalculator a=new AreaCalculator();
        System.out.println("Area of Circle = "+a.area(5.9));
        System.out.println("Area of Rectangle = "+a.area(5.9,8.6));
        System.out.println("Area of square  = "+a.area(5));

    }
}

