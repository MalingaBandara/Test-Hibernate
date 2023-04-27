package entity;

import javax.persistence.*;

@Entity ( name = "student_table" )
public class Student {

    @Id
    @GeneratedValue ( strategy = GenerationType.IDENTITY ) /* default */
    @Column ( name = "id" )
    private long studentId;


    @Column ( name = "student_name", length = 50, nullable = false )
    private String name;


    @OneToOne ( cascade = CascadeType.ALL )
    @JoinColumn( name = "laptop_id" )
    private Laptop laptop;



    public Student() {
    }

    public Student(long studentId, String name, Laptop laptop) {
        this.studentId = studentId;
        this.name = name;
        this.laptop = laptop;
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

    public Laptop getLaptop() {
        return laptop;
    }

    public void setLaptop(Laptop laptop) {
        this.laptop = laptop;
    }

    @Override
    public String toString() {
        return "Student{" +
                "studentId=" + studentId +
                ", name='" + name + '\'' +
                ", laptop=" + laptop +
                '}';
    }
}
