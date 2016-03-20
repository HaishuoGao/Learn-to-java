public class Course {
    public static void main(String[] args) {
        if (args.length == 0) {
            Student student = new Student();
            student.Output();
        } else if (args.length == 1) {
            Student student = new Student(args[0]);
            student.Output();
        } else if (args.length == 2) {
            Student student = new Student(args[0], args[1]);
            student.Output();
        } else if (args.length == 3) {
            Student student = new Student(args[0], args[1], args[2]);
            student.Output();
        }
    }
}