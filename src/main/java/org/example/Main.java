package org.example;

import org.hibernate.Session;
import org.hibernate.Transaction;

public class Main {
    public static void main(String[] args) {

        Transaction transaction = null;
        Session session = HibernateConfig.getSessionFactory().openSession();
        try {
            transaction = session.beginTransaction();

            User user = new User("Radib");
            session.save(user);
            User fetchEdUser = session.get(User.class, 1L);
            System.out.println(fetchEdUser);
            transaction.commit();
        } catch (Exception exception) {
            if(transaction !=null) {
                transaction.rollback();
            }
            exception.printStackTrace();
        } finally {
            session.close();
            HibernateConfig.shutdown();
        }

    }
}