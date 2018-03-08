package es.formacion.cip.jose.view;

import es.formacion.cip.jose.controller.HibernateUtil;
import es.formacion.cip.jose.model.Lista;
import org.hibernate.Session;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.util.List;

public class Table {
    private JPanel panel1;
    private JTable table1;

    public static void addTable() {
        Session session = null;
        try {
            session = HibernateUtil.getSession();
            List<Lista> listacompra = session.createQuery("from Lista ").list();
            System.out.println("Tabla Lista: ");
            for (Lista r : listacompra) {
                System.out.println("Id: " + r.getID() + " | Producto: " + r.getProducto() +
                        " | Cantidad: " + r.getCantidad() + " | Unidad: " + r.getUnidad()
                );
                String[] columnNames = {"id", "Nome", "Sobrenome", "Email"};

                Object[][] data = new Object[listacompra.size()][4];

                int index = 0;
                for (Lista s : listacompra) {
                    data[index][0] = s.getID();
                    data[index][1] = s.getProducto();
                    data[index][2] = s.getCantidad();
                    data[index][3] = s.getUnidad();
                    index++;
                }
                DefaultTableModel model = new DefaultTableModel(data, columnNames);

            }

            } catch(Exception e1){
                e1.printStackTrace();
                session.close();
            }
        }
    }



