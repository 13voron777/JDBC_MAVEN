package Lesson3.HW3;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class Main {
    private static SessionFactory sessionFactory;

    public static void main(String[] args) {
        sessionFactory = new Configuration()
                .configure("hibhw3.xml")
                .buildSessionFactory();

        Animal animal1 = new Animal(5, "Barsik", true);
        Animal animal2 = new Animal(7, "Som", false);

        addAnimal(animal1);
        addAnimal(animal2);
    }

    public static void addAnimal(Animal animal) {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();

        session.save(animal);
        transaction.commit();
        session.close();
    }
}
