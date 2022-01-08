package Lesson3.LAB3;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class Main {
    private static SessionFactory sessionFactory;
    public static void main(String[] args) {

        sessionFactory = new Configuration()
                .configure("hib.xml")
                .buildSessionFactory();

        Person person1 = new Person();
        person1.setName("John");
        person1.setAge(25);
        person1.setGender("Male");
        addPerson(person1);

        Person person2 = new Person();
        person2.setName("Jenn");
        person2.setAge(22);
        person2.setGender("Female");
        addPerson(person2);
    }

    public static void addPerson(Person person) {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();

        session.save(person);
        transaction.commit();
        session.close();
    }
}
