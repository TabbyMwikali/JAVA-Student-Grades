/*
 * This is the class that does the Input and Output Operations including;
 * Reading the JSON file containing student objects and storing them in the ArrayList,
 * Creating/Saving the contents of the ArrayList to a JSON file,
 * Searching a student in the ArrayList,
 * Deleting a student from the ArrayList,
 * Replacing a student in the ArrayList with a new Student (Editing)
 */

import com.google.gson.Gson;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

import javax.swing.*;

public class Application {
    /*
     * This method saves all the students to the JSON file
     * Use this method after making any changes in the ArrayList
     * NB: It has already been used after the Delete and Edit methods
     */
    public static void saveStudents(List<Student> listOfStudents) {

        String json = new Gson().toJson(listOfStudents);

        try {
            BufferedWriter br =new BufferedWriter(new FileWriter("students.json", false));
            br.write(json);
            br.close();
            JOptionPane.showMessageDialog(null, "Saved to File Successfully!");
        } catch(IOException e) {
            JOptionPane.showMessageDialog(null, "Error! "+ e);
        }
    }

    /*
     * This method Reads the JSON file containing students and stores them in the ArrayList of students
     * Use this method every time the application is started and
     * before Adding, Editing or Deleting a student in order to get the most current state of the data
     */
    public static void readStudents() {
        Main.listOfStudents = new ArrayList<Student>();

        //Check whether the file exists and whether it is empty
        File file = new File("students.json");
        if (file.length()==0) {
            return;
        }

        //If the file is not empty it proceeds to get Student objects from the file and adds them to the list of students
        Reader read = null;
        try {
            read = new FileReader("students.json");

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        JSONParser parser = new JSONParser();

        JSONArray jsonArray = null;
        try {
            jsonArray = (JSONArray) parser.parse(read);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ParseException e) {
            e.printStackTrace();
        }

        for (Object studentObject : jsonArray) {            //Fetch student details from the array one at a time
            JSONObject student = (JSONObject) studentObject;
            String regno = (String) student.get("regno");
            String fname = (String) student.get("fname");
            String lname = (String) student.get("lname");
            String dob = (String) student.get("dob");
            String sex = (String) student.get("sex");
            String gradeLevel = (String) student.get("gradeLevel");
            Student s;

            if (student.containsKey("studentGrades")) {
                JSONObject gradeObject = (JSONObject) student.get("studentGrades");
                String studentReg = (String) gradeObject.get("studentReg");
                String english = (String) gradeObject.get("english");
                String maths = (String) gradeObject.get("maths");
                String kiswahili = (String) gradeObject.get("kiswahili");
                String science = (String) gradeObject.get("science");
                String ssre = (String) gradeObject.get("ssre");

                Grade g = new Grade(studentReg, english, maths, kiswahili, science, ssre);
                s = new Student(regno, fname, lname, dob, sex, gradeLevel, g);
            }else {
                s = new Student(regno, fname, lname, dob, sex, gradeLevel);
            }

            Main.listOfStudents.add(s);
        }

        if (!Main.listOfStudents.isEmpty()) {
            Student e = Main.listOfStudents.get(Main.listOfStudents.size() - 1);          //Get the last student in the list
            Main.students = Integer.parseInt(e.regno);                               //Set the reg number of the last student as the total number of students created
        }
    }

    /*
     * This method Searches a given Registration number in the Array List Containig students
     * and returns its position index in the array (as an int)
     * Use this method when you want to search a student in the ArrayList and
     * When populating the UI for a user to make edits
     */
    public static int searchStudent(String regNo) {
        for (Student s : Main.listOfStudents) {
            if (s.regno.contentEquals(regNo)) {
                return Main.listOfStudents.indexOf(s);
            }
        }
        return Integer.MAX_VALUE;
    }

    /*
     * This method Deletes a student with the given Registration number from the ArrayList
     * Use this method when you want to completely delete a student
     */
    public static void deleteStudent(String regno) {
        int index = searchStudent(regno);
        if (index == Integer.MAX_VALUE) {
            return;
        }
        Main.listOfStudents.remove(index);
        JOptionPane.showMessageDialog(null, "Deleted Successfully!");
        saveStudents(Main.listOfStudents);
    }

    /*
     * This method Replaces a student in the ArrayList given the Registration Number and a new student object to replace with
     * How to use it When Editing a student:
     * After edits are made to a student, create a student object with the new changes
     * Use this method by passing the reg no and the new student object to replace the old object in the ArrayList
     */
    public static void editStudent(String regno, Student edit) {
        int index = searchStudent(regno);
        if (index == Integer.MAX_VALUE) {
            return;
        }
        Main.listOfStudents.set(index,edit);
        JOptionPane.showMessageDialog(null, "Added Successfully!");
        saveStudents(Main.listOfStudents);
    }

}
