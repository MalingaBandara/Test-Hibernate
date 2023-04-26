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


    @Embedded
    @AttributeOverrides(  value = {

                        @AttributeOverride( column = @Column (name = "residentail_country"), name = "country" ),
                        @AttributeOverride( column = @Column (name = "residentail_city"), name = "city" ),
                        @AttributeOverride( column = @Column (name = "residentail_postal"), name = "postal" )

    })
    private Address residentailAddress;

    @Embedded
    @AttributeOverrides(  value = {

            @AttributeOverride( column = @Column (name = "premanet_country"), name = "country" ),
            @AttributeOverride( column = @Column (name = "premanet_city"), name = "city" ),
            @AttributeOverride( column = @Column (name = "premanet_postal"), name = "postal" )

    } )
    private Address premanetAddress;


    public Student(long studentId, String name, Address residentailAddress, Address premanetAddress) {
        this.studentId = studentId;
        this.name = name;
        this.residentailAddress = residentailAddress;
        this.premanetAddress = premanetAddress;
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

    public Address getResidentailAddress() {
        return residentailAddress;
    }

    public void setResidentailAddress(Address residentailAddress) {
        this.residentailAddress = residentailAddress;
    }

    public Address getPremanetAddress() {
        return premanetAddress;
    }

    public void setPremanetAddress(Address premanetAddress) {
        this.premanetAddress = premanetAddress;
    }
}
