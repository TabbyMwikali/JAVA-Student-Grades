/*
 * This is a student class containing;
 * All the student Attributes,
 * Setter and Getter methods for all the Attributes and
 * Two constructors
 */

public class Student {
    public String regno;                //Student Registration number
    public String fname;                //Student First Name
    public String lname;                //Student Last Name
    public String dob;                  //Student Date of Birth
    public String sex;                  //Student Sex
    public String gradeLevel;           //Student class
    public Grade studentGrades;         //An object containing all subjects

    /*
     * Setter and Getter Methods for all the Student Class Attributes
     * Use getter methods when you want to display an attribute to the UI
     * Use setter methods when you want to edit an existing student Details
     */
    public void setRegno (String regno) { this.regno = regno;}
    public String getRegno() { return regno; }

    public String getFname() { return fname; }
    public void setFname(String fname) { this.fname = fname; }

    public String getLname() { return lname; }
    public void setLname(String lname) { this.lname = lname; }

    public String getGradeLevel() { return gradeLevel; }
    public void setGradeLevel(String gradeLevel) { this.gradeLevel = gradeLevel; }

    public String getDob() { return dob; }
    public void setDob(String dob) { this.dob = dob; }

    public void setSex(String sex) { this.sex = sex; }
    public String getSex() { return sex; }

    public Grade getStudentGrades() { return studentGrades; }
    public void setStudentGrades(Grade studentGrades) { this.studentGrades = studentGrades; }

    /*
     * This constructor does not have student grades as part of its parameter profile
     * Use this constructor to create students that do not have grades
     */
    public Student(String regno, String fname, String lname, String dob, String sex, String gradeLevel) {
        this.regno = regno;
        this.fname = fname;
        this.lname = lname;
        this.dob = dob;
        this.sex = sex;
        this.gradeLevel = gradeLevel;
    }

    /*
     * This constructor contains a StudentGrades object as part of its parameter profile
     * Use this constructor to create students who have grades
     */
    public Student(String regno, String fname, String lname, String dob, String sex, String gradeLevel, Grade studentGrades) {
        this.regno = regno;
        this.fname = fname;
        this.lname = lname;
        this.dob = dob;
        this.sex = sex;
        this.gradeLevel = gradeLevel;
        this.studentGrades = studentGrades;
    }
}