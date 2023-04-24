import entity.Student;
import org.hibernate.Session;

public class AppInitializer {

    public static void main(String[] args) {

        Student sanath = new Student( 1, "Sanath");

        saveStudnet( sanath );

    }

    private static void saveStudnet(Student sanath) {

        try ( Session session = HibernateUtill.getSessionFactory().openSession() ) {

            long saveId = (long) session.save( sanath );
            System.out.println( "Saved Student Primary Key : "  + saveId );

        }

    }

}
