import entity.Student;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class AppInitializer {

    public static void main(String[] args) {


        // saveStudnet( student1 );

       //findStudent( 1 );

    }

    private static void findStudent ( long id) {

        try (Session session = HibernateUtill.getSessionFactory().openSession()) {
            Student selectdStudent = session.find(Student.class, id);
            System.out.println( selectdStudent );
        }

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
