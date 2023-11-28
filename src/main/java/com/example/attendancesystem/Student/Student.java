//package com.example.attendancesystem.Student;
//
//import javafx.beans.property.SimpleIntegerProperty;
//import javafx.beans.property.SimpleObjectProperty;
//import javafx.beans.property.SimpleStringProperty;
//
//import java.time.LocalDate;
//
//public class StudentData {
//    private final SimpleStringProperty list_name = new SimpleStringProperty("");
//    private final SimpleIntegerProperty list_id = new SimpleIntegerProperty(0);
//    private final SimpleStringProperty list_department = new SimpleStringProperty("");
//    private final SimpleStringProperty list_course = new SimpleStringProperty("");
//    private final SimpleObjectProperty<LocalDate> list_date = new SimpleObjectProperty<>(LocalDate.now());
//    public StudentData() {
//        this("",0,"","",LocalDate.now());
//    }
//    public StudentData(String list_name, int list_id, String list_department, String list_course , LocalDate list_date){
//        setList_name(list_name);
//        setList_id(list_id);
//        setList_department(list_department);
//        setList_course(list_course);
//        setList_date(list_date);
//    }
//
//    public String getList_name() {
//        return list_name.get();
//    }
//
//    public SimpleStringProperty list_nameProperty() {
//        return list_name;
//    }
//
//    public void setList_name(String list_name) {
//        this.list_name.set(list_name);
//    }
//
//    public int getList_id() {
//        return list_id.get();
//    }
//
//    public SimpleIntegerProperty list_idProperty() {
//        return list_id;
//    }
//
//    public void setList_id(int list_id) {
//        this.list_id.set(list_id);
//    }
//
//    public String getList_department() {
//        return list_department.get();
//    }
//
//    public SimpleStringProperty list_departmentProperty() {
//        return list_department;
//    }
//
//    public void setList_department(String list_department) {
//        this.list_department.set(list_department);
//    }
//
//    public String getList_course() {
//        return list_course.get();
//    }
//
//    public SimpleStringProperty list_courseProperty() {
//        return list_course;
//    }
//
//    public void setList_course(String list_course) {
//        this.list_course.set(list_course);
//    }
//
//    public LocalDate getList_date() {
//        return list_date.get();
//    }
//
//    public SimpleObjectProperty<LocalDate> list_dateProperty() {
//        return list_date;
//    }
//
//    public void setList_date(LocalDate list_date) {
//        this.list_date.set(list_date);
//    }
//
//}



package com.example.attendancesystem.Student;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class Student {
    private StringProperty name;
    private StringProperty id;
    private StringProperty course;
    private StringProperty time;
    private StringProperty date;
    private StringProperty attendance;

    public Student(String name, String id, String course, String time, String date,String attendance) {
        this.name = new SimpleStringProperty(name);
        this.id = new SimpleStringProperty(id);
        this.course = new SimpleStringProperty(course);
        this.time = new SimpleStringProperty(time);
        this.date = new SimpleStringProperty(date);
        this.attendance = new SimpleStringProperty(attendance);
    }

    public StringProperty courseProperty() {
        return course;
    }

    public String getCourse() {
        return course.get();
    }

    public void setCourse(String course) {
        this.course.set(course);
    }

    public StringProperty nameProperty() {
        return name;
    }

    public String getName() {
        return name.get();
    }

    // Getter and setter for time
    public StringProperty timeProperty() {
        return time;
    }

    public String getTime() {
        return time.get();
    }

    public StringProperty dateProperty() {
        return date;
    }

    public String getDate() {
        return date.get();
    }

    public StringProperty attendanceProperty() {
        return attendance;
    }

    public String getAttendance() {
        return attendance.get();
    }

    public void setAttendance(String attendance) {
        this.attendance.set(attendance);
    }
}
