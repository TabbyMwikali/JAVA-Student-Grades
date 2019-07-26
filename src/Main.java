import java.util.List;

public class Main {
    public static int students = 0;                 //Variable to keep count of all students
    public static List<Student> listOfStudents;     //Universal ArrayList that stores all created students

    public static void main(String[] args) {
        Application.readStudents();
        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() { new Dashboard().setVisible(true); }
        });
    }
}
