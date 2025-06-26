public class MVCTest {
    public static void main(String[] args) {
        Student student = new Student("Gopika", "S101", "A");
        StudentView view = new StudentView();
        StudentController controller = new StudentController(student, view);
        controller.updateView();
        System.out.println();
        controller.setStudentName("Gopika Senthil");
        controller.setStudentGrade("A+");
        controller.updateView();
    }
}
