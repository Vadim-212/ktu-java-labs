package kz.ktu.lab2;

import java.util.ArrayList;
import java.util.Collection;

public class Abiturient {
    private String name;
    private String surname;
    private String patronymic;
    private String address;
    private ArrayList<Integer> marks;

    public Abiturient(String name, String surname, String patronymic, String address, Collection<Integer> marks) {
        this.name = name;
        this.surname = surname;
        this.patronymic = patronymic;
        this.address = address;
        this.marks = new ArrayList<>(marks);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) throws Exception {
        if(name.isEmpty())
            throw new Exception("Field \"name\" cannot be empty!");

        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) throws Exception {
        if(surname.isEmpty())
            throw new Exception("Field \"surname\" cannot be empty!");

        this.surname = surname;
    }

    public String getPatronymic() {
        return patronymic;
    }

    public void setPatronymic(String patronymic) throws Exception {
        if(patronymic.isEmpty())
            throw new Exception("Field \"patronymic\" cannot be empty!");

        this.patronymic = patronymic;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) throws Exception {
        if(address.isEmpty())
            throw new Exception("Field \"address\" cannot be empty!");

        this.address = address;
    }

    public void addMark(Integer mark) throws Exception {
        if(mark < 0)
            throw new Exception("\"mark\" cannot be negative!");

        marks.add(mark);
    }

    public ArrayList<Integer> getMarks() {
        return marks;
    }

    public void setMarks(Collection<Integer> marks) {
        this.marks.clear();
        this.marks.addAll(marks);
    }

    public Integer getMarksSum() {
        Integer sum = 0;

        for (Integer mark : marks) {
            sum += mark;
        }

        return sum;
    }

    public String getMarksString() {
        StringBuilder str = new StringBuilder("marks=[" + marks.get(0));

        for (int i = 1; i < marks.size(); i++) {
            str.append(", ").append(marks.get(i));
        }

        str.append("]");

        return str.toString();
    }

    @Override
    public String toString() {
        return "Abiturient{" +
                "name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", patronymic='" + patronymic + '\'' +
                ", address='" + address + '\'' +
                ", " + getMarksString() +
                '}';
    }
}
