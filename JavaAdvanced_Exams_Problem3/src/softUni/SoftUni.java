package softUni;

import java.util.ArrayList;
import java.util.List;

public class SoftUni {
    private int capacity;
    private List<Student> data;

    public SoftUni(int capacity) {
        this.capacity = capacity;
        this.data = new ArrayList<>();
    }

    public int getCapacity() {
        return capacity;
    }

    public List<Student> getData() {
        return data;
    }

    public int getCount(){
        return this.data.size();
    }

    public String insert(Student student) {
        String result;

        if (this.data.size() < this.capacity) {
            if (this.data.contains(student)) {
                result = "Student is already in the hall.";
            } else {
                this.data.add(student);
                result = String.format("Added student %s %s.", student.getFirstName(), student.getLastName());
            }
        } else {
            result = "The hall is full.";
        }

        return result;
    }

    public String remove(Student student) {
        String result;

        if (this.data.contains(student)) {
            this.data.remove(student);
            result = String.format("Removed student %s %s.", student.getFirstName(), student.getLastName());
        } else {
            result = "Student not found.";
        }

        return result;
    }

    public Student getStudent(String firstName, String lastName) {
        Student student = null;

        for (Student student1 : this.data) {
            if (student1.getFirstName().equals(firstName) && student1.getLastName().equals(lastName)) {
                student = student1;
            }
        }

        return student;
    }

    public String getStatistics() {
        StringBuilder sb = new StringBuilder();
        sb.append("Hall size: ").append(this.data.size()).append(System.lineSeparator());

        for (Student student : this.data) {
            sb.append(student.toString()).append(System.lineSeparator());
        }

        return sb.toString();
    }
}