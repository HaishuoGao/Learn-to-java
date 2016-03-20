//Student has at least three overloaded constructors with different parameter list;
//Student also has some members of Book.

public class Student extends Book{
    private String student;
    private String output;
    
    Student() {
        output = "Nothing input!";
    }
    Student(String input) {
        student = input;
        output = student + " has no course choosed!";
    }
    Student(String input, String course) {
        student = input;
        if (isBook(course)) 
            output = student + " choose " + course;
        else
            output = "Course not find!";
    }
    Student(String input, String course1, String course2) {
        student = input;
        if (isBook(course1) & isBook(course2))
            output = student + " choose " + course1 + " and " + course2;
        else
            output = "Course not find!";
    }
    
    public void Output() {
        System.out.println(output);
    }
}
