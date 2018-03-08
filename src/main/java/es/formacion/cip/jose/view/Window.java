package es.formacion.cip.jose.view;

import es.formacion.cip.jose.controller.HibernateUtil;
import es.formacion.cip.jose.model.Lista;
import org.hibernate.Session;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.util.List;

public class Window extends JFrame {

    private JButton bRegister;
    private JButton bObtener;
    private JButton bDeleteRegister;
    private JPanel panelMain;

    public Window() {

        setContentPane(panelMain);

        bRegister.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Window_Register wr = new Window_Register();
                wr.setVisible(true);
                wr.setLocation(400, 250);
                wr.pack();
            }
        });


        bObtener.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                Session session = null;
                try {

//                    Table.addTable();
                    session = HibernateUtil.getSession();
                    List<Lista> listacompra = session.createQuery("from Lista ").list();
                    System.out.println("Tabla Lista: ");
                    for (Lista r : listacompra) {
                        System.out.println("Id: " + r.getID() + " | Producto: " + r.getProducto() +
                                " | Cantidad: " + r.getCantidad() + " | Unidad: " + r.getUnidad()
                        );
                    }


                } catch (Exception e1) {
                    e1.printStackTrace();
                }
                session.close();
            }
        });

        bDeleteRegister.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Window_Delete wd = new Window_Delete();
                wd.setVisible(true);
                wd.pack();
                wd.setLocation(400, 250);
            }
        });
    }
}


