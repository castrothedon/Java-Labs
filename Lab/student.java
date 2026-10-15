public class student {
    String name;
    int rollNo;
    double gpa;

    void display(){
        System.out.println("Name: " + name + ", Roll No: " + rollNo + ", GPA: " + gpa);
        
    }

    boolean isHonours() {
        return gpa >= 3.5;

    }
    public static void main(String[]Args) {
        student s1 = new student();
        s1.name = "Castro";
        s1.rollNo = 101;
        s1.gpa = 3.8;

         student s2 = new student();
        s2.name = "Gwiri";
        s2.rollNo = 102;
        s2.gpa = 3.1;

        s1.display();
        s2.display();
        System.out.println(s1.name  + "honours?" + s1.isHonours());
         System.out.println(s2.name  + "honours?" + s2.isHonours());


    }
    
}
