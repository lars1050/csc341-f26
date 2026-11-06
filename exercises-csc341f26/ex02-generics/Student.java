public class Student {
    String username;
    int percent;
    
    @Override
    public String toString() {
    	return username + "(" + percent +"%)";
    }

    public Student(String username, int percent) {
        this.username = username;
        this.percent = percent;
    }
    
    // TODO: write the compareTo method
    /*
    @Override
    public int compareTo(Student other) {
    	// base comparison on username (which should be unique -- no ties)
    	return 0;
    }
    */
}