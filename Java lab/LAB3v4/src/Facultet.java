import java.util.ArrayList;

public class Facultet {
    private ArrayList<String> listOfCourse;
    private ArrayList<String> listOfTeacher;
    private ArrayList<String> listOfStudent;

    public Facultet() {
        init();
    }

    public void init() {
        listOfCourse = new ArrayList<String>();
        listOfTeacher = new ArrayList<String>();
        listOfStudent = new ArrayList<String>();

        for (int i = 0; i < 3; i++) {
            listOfCourse.add("Название_Курса: " + (i+1));
            listOfTeacher.add("Имя_Преподавателя: " + (i+1));
            listOfStudent.add("Имя_Студента: " + (i+1));
        }
    }

    public ArrayList<String> getListOfTeacher() {
        return listOfTeacher;
    }

    public ArrayList<String> getListOfCourse() {
        return listOfCourse;
    }

    public ArrayList<String> getListOfStudent() {
        return listOfStudent;
    }
}