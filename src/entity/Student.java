package entity;

import javax.persistence.*;


@Entity ( name = "student_table" )
public class Student {

    @Id
    @GeneratedValue ( strategy = GenerationType.SEQUENCE ) /* default */
    @Column ( name = "id" )
    private long studentId;


    @Column ( name = "student_name", length = 50, nullable = false )
    private String name;


    @Column ( length = 45, nullable = false)
    private String country;

    @Column ( length = 45, nullable = false)
    private String city;

    private int postal;

    public Student(long studentId, String name, String country, String city, int postal) {
        this.studentId = studentId;
        this.name = name;
        this.country = country;
        this.city = city;
        this.postal = postal;
    }

    public Student() {
    }

    public long getStudentId() {
        return studentId;
    }

    public void setStudentId(long studentId) {
        this.studentId = studentId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public int getPostal() {
        return postal;
    }

    public void setPostal(int postal) {
        this.postal = postal;
    }
}
