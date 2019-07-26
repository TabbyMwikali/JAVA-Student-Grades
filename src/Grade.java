/*
 * This is a student grades class containing;
 * The student's Registration number,
 * All the marks for all subjects,
 * Setter and getter methods for each subject's marks,
 * A constructor and
 * A method that generates the grade of a student given some marks
 */
public class Grade {
    String studentReg;
    String english;
    String maths;
    String kiswahili;
    String science;
    String ssre;

    /*
     * Setter and getter methods for the grades class
     * Use Setter methods when you want to edit the marks
     * Use Getter methods when you want to display marks to the UI
     */
    public String getStudentReg() { return studentReg; }
    public void setStudentReg(String studentReg) { this.studentReg = studentReg; }

    public String getEnglish() { return english; }
    public void setEnglish(String english) { this.english = english; }

    public String getMaths() { return maths; }
    public void setMaths(String maths) { this.maths = maths; }

    public String getKiswahili() { return kiswahili; }
    public void setKiswahili(String kiswahili) { this.kiswahili = kiswahili; }

    public String getScience() { return science; }
    public void setScience(String science) { this.science = science; }

    public String getSsre() { return ssre; }
    public void setSsre(String ssre) { this.ssre = ssre; }

    //Constructor for the grades class
    public Grade(String studentReg, String english, String maths, String kiswahili, String science, String ssre) {
        this.studentReg = studentReg;
        this.english = english;
        this.maths = maths;
        this.kiswahili = kiswahili;
        this.science = science;
        this.ssre = ssre;
    }

    //Method to generate a grade given some marks
    public static String genGrade(String marks) {
        double mark = Double.parseDouble(marks);
        if (mark < 40) {
            return  "E";
        }else if (mark < 50) {
            return  "D";
        }else if (mark < 60) {
            return "C";
        }else if (mark < 80) {
            return "B";
        }else return "A";
    }

    public int calculateTotal() {
        int totals = Integer.parseInt(this.getMaths()) + Integer.parseInt(this.getEnglish()) + Integer.parseInt(this.getKiswahili())
                + Integer.parseInt(this.getScience()) + Integer.parseInt(this.getSsre());
        return totals;
    }
}
