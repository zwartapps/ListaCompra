package es.formacion.cip.jose.view;

import es.formacion.cip.jose.controller.HibernateUtil;
import es.formacion.cip.jose.model.Lista;
import org.hibernate.Session;
import org.hibernate.Transaction;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Window_Delete extends JFrame {

    private JTextField textField1;
    private JButton borrarRegistroButton;
    private JButton cancelarButton;
    private JPanel panelDelete;


    public Window_Delete() {

        setContentPane(panelDelete);
        borrarRegistroButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                try {
                    Session session = HibernateUtil.getSession();
                    Transaction tx = session.beginTransaction();
                    String b = textField1.getText();
                    Integer c = Integer.parseInt(b);
                    Lista a = new Lista(c, "", 1.0, "");
                    session.delete(a);
                    tx.commit();
                    JOptionPane.showMessageDialog(null, "Producto borrado correctamente");

                } catch (Exception e1) {
                    e1.printStackTrace();
                } finally {
                    HibernateUtil.getSession().close();
                }
                dispose();
            }
        });

        cancelarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
            }
        });
    }
}
