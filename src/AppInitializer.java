import entity.Address;
import entity.Student;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.Arrays;

public class AppInitializer {

    public static void main(String[] args) {

        /*Address address1 = new Address( "Sri Lanka", "Colombo", 1500 ); //  Address 1
        Address address2 = new Address( "USA", "South Carolina", 44530 ); //  Address 2
        Address address3 = new Address( "Sri Lanka", "Kandy", 5030 ); //    Address 3

        Student student1 = new Student();

        student1.setName( "Nimal" );
        student1.setAddressList(Arrays.asList( address1, address2, address3 ) ); // student1.setAddressList( list )

        saveStudnet( student1 );*/

       findStudent( 1 );

    }

    private static void findStudent ( long id) {

        Student selectdStudent = null;

        try (Session session = HibernateUtill.getSessionFactory().openSession()) {
            selectdStudent = session.find(Student.class, id);
            System.out.println( selectdStudent );
        }

        System.out.println( "=============" );
        selectdStudent.getAddressList().stream().forEach( e-> System.out.println(e.toString()) );
        System.out.println( "=============" );

    }


    private static void saveStudnet(Student sanath) {

        try (Session session = HibernateUtill.getSessionFactory().openSession()) {

            Transaction transaction = session.beginTransaction();

            long saveId = (long) session.save(sanath);

            transaction.commit();

            System.out.println("Saved Student Primary Key : " + saveId);

        }

    }
}
