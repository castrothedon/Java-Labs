

public class Car {
    String brand;
    int year, mileage;


void display () {
    System.out.println("Brand: " + brand + ", Year: " + year + ", Mileage: " + mileage );
}
 boolean isAntique() {
    return(2026 - year)>25;

 }
public static void main(String[]args){

    Car a = new Car();
    a.brand = "Toyota";
    a.year = 2000;
    a.mileage = 85000;

    Car b = new Car();
    b.brand = "Madza";
    b.year = 2023;
    b.mileage = 120000;

    Car c = new Car();
    c.brand = "BMW";
    c.year = 1995;
    c.mileage = 65000;

    a.display();
    b.display();
    c.display();
    System.out.println("a antique: " + a.isAntique());
    System.out.println("b antique: " + b.isAntique());
    System.out.println("c antique: " + c.isAntique());
    
}
}
 

