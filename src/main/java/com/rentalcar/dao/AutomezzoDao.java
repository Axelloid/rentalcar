package com.rentalcar.dao;

import com.rentalcar.entity.Automezzo;
import com.rentalcar.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;

public class AutomezzoDao {
    public List<Automezzo> getAllAutomezzi() {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            return session.createQuery("FROM Automezzo", Automezzo.class).list();
        }
    }

    public void upsertAutomezzo(Automezzo automezzo) {
        Transaction transaction = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            // start a transaction
            transaction = session.beginTransaction();
            // update the customer object
            session.saveOrUpdate(automezzo);
            // commit transaction
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
    }
}
