
# Test-Hibernate

## Project Overview

This project is part of my learning journey to understand and apply Hibernate, a powerful ORM framework for Java. The repository demonstrates the implementation of fundamental CRUD operations (Create, Read, Update, Delete) using Hibernate with a relational database. This project showcases my understanding of Java, Hibernate, and database management principles.

## Key Features

- Basic CRUD operations with Hibernate.
- Entity mapping and session management.
- Configurable database connection via `hibernate.cfg.xml`.
- Clean code structure with well-commented explanations.

## Technologies Used

- **Java**
- **Hibernate**
- **MySQL**
- **Maven**

## Project Structure and Code Explanation

1. **Entity Classes (`Student.java`)**:
   - The `Student` entity represents the `student` table in the database with attributes like `id`, `firstName`, `lastName`, and `email`.
   - Hibernate annotations like `@Entity`, `@Table`, and `@Column` are used to map the Java class to the database table.

   ```java
   @Entity
   @Table(name = "student")
   public class Student {
       @Id
       @GeneratedValue(strategy = GenerationType.IDENTITY)
       private int id;
       @Column(name = "first_name")
       private String firstName;
       // Other fields, constructors, and methods...
   }
   ```

2. **DAO Layer (`StudentDAO.java`)**:
   - Contains methods to perform CRUD operations. For example, the `saveStudent` method handles inserting a `Student` object into the database.

   ```java
   public void saveStudent(Student student) {
       Session session = HibernateUtil.getSessionFactory().openSession();
       Transaction transaction = null;
       try {
           transaction = session.beginTransaction();
           session.save(student); // Save student to database
           transaction.commit();  // Commit transaction
       } catch (Exception e) {
           if (transaction != null) transaction.rollback(); // Rollback if error occurs
           e.printStackTrace();
       } finally {
           session.close(); // Close session
       }
   }
   ```

3. **Hibernate Configuration (`hibernate.cfg.xml`)**:
   - Manages database connection settings and other Hibernate configurations.

   ```xml
   <hibernate-configuration>
       <session-factory>
           <property name="hibernate.connection.url">jdbc:mysql://localhost:3306/your_database</property>
           <property name="hibernate.connection.username">root</property>
           <property name="hibernate.connection.password">password</property>
           <!-- Other settings -->
       </session-factory>
   </hibernate-configuration>
   ```

## Commits and Project Evolution

1. **Initial Setup**: Added basic project structure, including the Hibernate configuration and the first entity class (`Student`).
2. **CRUD Implementation**: Introduced DAO classes and implemented basic CRUD operations.
3. **Error Handling and Optimization**: Enhanced session management, exception handling, and code cleanup.

## How to Run the Project

1. Clone the repository:
   ```bash
   git clone https://github.com/MalingaBandara/Test-Hibernate.git
   ```
2. Import the project into your preferred IDE.
3. Update the database connection settings in `hibernate.cfg.xml`.
4. Run the application.

## Purpose and Future Enhancements

This project serves as a foundation for understanding Hibernate’s capabilities. Potential enhancements could include more complex entity relationships (e.g., One-to-Many), integration with Spring, and implementing advanced query techniques using Hibernate Criteria and HQL.

## License

This project is licensed under the MIT License.
