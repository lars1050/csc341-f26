public class Main {

    public static void main(String[] args) {

        Trio trio1 = new Trio(3,8,5);		  //1,3,2
        Trio trio2 = new Trio(30,20,10);	  //3,2,1
        Trio trio3 = new Trio(200,100,300);   //2,1,3
        System.out.println("TRIO: "+trio1);
        System.out.println("TRIO: "+trio2);
        System.out.println("TRIO: "+trio3);


        /*

        // Test your code by creating an instance of Trio that stores integers
        Trio<Integer> integers = new Trio<>(3,1,2);

        // Test your code by creating an instance of Trio that stores Simple objects.
        Student s1 = new Student("lars1050",72);
        Student s2 = new Student("alim3271",86);
        Student s3 = new Student("diaz5436",93);
        Trio<Student> students = new Trio<>(s1,s2,s3);

        */
    }
}
