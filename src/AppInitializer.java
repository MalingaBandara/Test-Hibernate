import entity.Address;
import entity.Student;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class AppInitializer {

    public static void main(String[] args) {

        Address residentailAddress = new Address( "Sri Lanka", "Colombo", 1500 ); // Residential Address

        Address premanetAddress = new Address( "Sri Lanka", "Kandy", 5030 ); // Permanent Address


        Student student1 = new Student( 1, "Sanath", residentailAddress, premanetAddress );

        saveStudnet( student1 );

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
