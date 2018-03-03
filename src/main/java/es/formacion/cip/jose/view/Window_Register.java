package es.formacion.cip.jose.view;

import es.formacion.cip.jose.controller.HibernateUtil;
import es.formacion.cip.jose.model.Lista;
import org.hibernate.Session;
import org.hibernate.Transaction;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Window_Register extends JFrame {

    private JTextField textFieldProducto;
    private JTextField jTextFieldCantidad;
    private JComboBox jComboBoxUnidad;
    private JButton aceptarButton;
    private JButton cancelarButton;
    private JPanel panelRegister;

    public Window_Register() {
        setContentPane(panelRegister);
        aceptarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                try {
                    Session session = HibernateUtil.getSession();
                    Transaction tx = session.beginTransaction();
                    Lista a = new Lista(
                            1,
                            textFieldProducto.getText(),
                            Double.parseDouble(jTextFieldCantidad.getText()),
                            jComboBoxUnidad.getSelectedItem().toString());
                    session.save(a);
                    tx.commit();
                    JOptionPane.showMessageDialog(null, "Producto añadido correctamente");
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
