package es.formacion.cip.jose.controller;

import es.formacion.cip.jose.model.Lista;
import es.formacion.cip.jose.view.Window;
import org.hibernate.Session;
import org.hibernate.Transaction;

import javax.swing.*;

public class MySQL_Test {

    public static void main(String[] args) {

        Window w = new Window();
        w.pack();
        w.setTitle("Lista de Compras by Zwart Apps");
        w.setLocation(400, 200);
        w.setSize(400, 400);
        w.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        w.setVisible(true);

        Session session = HibernateUtil.getSession();
        Transaction tx = session.beginTransaction();
        Lista a = new Lista(1, "Lechita", (double) 3, "litros");
        session.save(a);
        session.flush();
        tx.commit();

    }
}
¡ERROR INTRODUCIDO!

