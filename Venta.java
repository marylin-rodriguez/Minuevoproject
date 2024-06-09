package org.marylin;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.marylin.entity.Venta01;
import org.marylin.util.Hibernateutil;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.util.ArrayList;
import java.util.List;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

public class Venta extends JInternalFrame {
    private JTextField fechaField;
    private JTextField productoField;
    private JTextField cantidadField;
    private JTextField precioUnitarioField;
    private JTextField idClienteField;
    private JTextField nombreClienteField;
    private List<Venta01> ventasRegistradas;

    public Venta() {
        super("Venta", true, true, true, true);
        ventasRegistradas = new ArrayList<>();
        iniciarVenta();
    }

    private void iniciarVenta() {
        setSize(400, 300);
        JPanel contentPane = new JPanel();
        contentPane.setBackground(Color.PINK);
        getContentPane().setBackground(new Color(235, 235, 235));

        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(9, 2, 5, 5));
        panel.setBackground(new Color(220, 220, 220));

        JLabel fechaLabel = new JLabel("Fecha:");
        panel.add(fechaLabel);
        fechaField = new JTextField();
        fechaField.setBackground(Color.LIGHT_GRAY);
        panel.add(fechaField);

        JLabel productoLabel = new JLabel("Producto:");
        panel.add(productoLabel);
        productoField = new JTextField();
        productoField.setBackground(Color.LIGHT_GRAY);
        panel.add(productoField);

        JLabel cantidadLabel = new JLabel("Cantidad:");
        panel.add(cantidadLabel);
        cantidadField = new JTextField();
        cantidadField.setBackground(Color.LIGHT_GRAY);
        panel.add(cantidadField);

        JLabel precioUnitarioLabel = new JLabel("Precio Unitario:");
        panel.add(precioUnitarioLabel);
        precioUnitarioField = new JTextField();
        precioUnitarioField.setBackground(Color.LIGHT_GRAY);
        panel.add(precioUnitarioField);

        JLabel idClienteLabel = new JLabel("ID Cliente:");
        panel.add(idClienteLabel);
        idClienteField = new JTextField();
        idClienteField.setBackground(Color.LIGHT_GRAY);
        panel.add(idClienteField);

        JLabel nombreClienteLabel = new JLabel("Nombre Cliente:");
        panel.add(nombreClienteLabel);
        nombreClienteField = new JTextField();
        nombreClienteField.setBackground(Color.LIGHT_GRAY);
        panel.add(nombreClienteField);

        JButton registrarButton = new JButton("Registrar Venta");
        registrarButton.setBackground(Color.MAGENTA);
        registrarButton.setForeground(Color.BLACK);
        registrarButton.addActionListener(e -> registrarVenta());
        panel.add(registrarButton);

        JButton mostrarVentasButton = new JButton("Mostrar Ventas");
        mostrarVentasButton.setBackground(Color.MAGENTA);
        mostrarVentasButton.setForeground(Color.BLACK);
        mostrarVentasButton.addActionListener(e -> mostrarVentas());
        panel.add(mostrarVentasButton);

        JButton editarButton = new JButton("Editar Venta");
        editarButton.setBackground(Color.MAGENTA);
        editarButton.setForeground(Color.BLACK);
        editarButton.addActionListener(e -> seleccionarVentaParaEditar());
        panel.add(editarButton);

        JButton eliminarButton = new JButton("Eliminar Venta");
        eliminarButton.setBackground(Color.MAGENTA);
        eliminarButton.setForeground(Color.BLACK);
        eliminarButton.addActionListener(e -> seleccionarVentaParaEliminar());
        panel.add(eliminarButton);

        setContentPane(panel);
        setVisible(true);
    }

    private void registrarVenta() {
        String fecha = fechaField.getText();
        String producto = productoField.getText();
        String cantidad = cantidadField.getText();
        String precioUnitario = precioUnitarioField.getText();
        String idCliente = idClienteField.getText();
        String nombreCliente = nombreClienteField.getText();

        System.out.println("Ventas guardado:");
        System.out.println("Fecha: " + fecha);
        System.out.println("Producto: " + producto);
        System.out.println("Cantidad: " + cantidad);
        System.out.println("PrecioUnitario: " + precioUnitario);
        System.out.println("Idcliente: " + idCliente);
        System.out.println("NombreCliente: " + nombreCliente);


        if (fecha.isEmpty() || producto.isEmpty() || cantidad.isEmpty() ||
                precioUnitario.isEmpty() || idCliente.isEmpty() || nombreCliente.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Por favor, complete todos los campos.");
            return;
        }

        Venta01 nuevaVenta = new Venta01(fecha, producto, cantidad, precioUnitario, idCliente, nombreCliente);
        ventasRegistradas.add(nuevaVenta);

        mostrarVentas();

        limpiarCampos();
    }

    private void mostrarVentas() {
        StringBuilder ventasText = new StringBuilder();
        for (Venta01 venta : ventasRegistradas) {
            ventasText.append("Fecha: ").append(venta.getFecha()).append(", Producto: ").append(venta.getProducto())
                    .append(", Cantidad: ").append(venta.getCantidad()).append(", Precio Unitario: ").append(venta.getPrecioUnitario())
                    .append(", ID Cliente: ").append(venta.getIdCliente()).append(", Nombre Cliente: ").append(venta.getNombreCliente())
                    .append("\n");
        }
        JOptionPane.showMessageDialog(null, ventasText.toString(), "Ventas Registradas", JOptionPane.INFORMATION_MESSAGE);
    }


    private void seleccionarVentaParaEditar() {
        String idCliente = JOptionPane.showInputDialog("Ingrese el ID del Cliente de la venta que desea editar:");
        Venta01 venta = buscarVentaPorIdCliente(idCliente);
        if (venta != null) {
            fechaField.setText(venta.getFecha());
            productoField.setText(venta.getProducto());
            cantidadField.setText(venta.getCantidad());
            precioUnitarioField.setText(venta.getPrecioUnitario());
            idClienteField.setText(venta.getIdCliente());
            nombreClienteField.setText(venta.getNombreCliente());

            JButton actualizarButton = new JButton("Actualizar Venta");
            actualizarButton.setBackground(Color.GREEN);
            actualizarButton.setForeground(Color.BLACK);
            actualizarButton.addActionListener(e -> actualizarVenta(venta));
            getContentPane().add(actualizarButton);
            revalidate();
            repaint();
        } else {
        }
    }

    private void actualizarVenta(Venta01 venta) {
        venta.setFecha(fechaField.getText());
        venta.setProducto(productoField.getText());
        venta.setCantidad(cantidadField.getText());
        venta.setPrecioUnitario(precioUnitarioField.getText());
        venta.setIdCliente(idClienteField.getText());
        venta.setNombreCliente(nombreClienteField.getText());

        // Imprimir en la terminal que la venta ha sido actualizada correctamente
        System.out.println("Venta editada correctamente:");
        System.out.println("Fecha: " + venta.getFecha());
        System.out.println("Producto: " + venta.getProducto());
        System.out.println("Cantidad: " + venta.getCantidad());
        System.out.println("Precio Unitario: " + venta.getPrecioUnitario());
        System.out.println("ID Cliente: " + venta.getIdCliente());
        System.out.println("Nombre Cliente: " + venta.getNombreCliente());

        // Mostrar todas las ventas en la interfaz gráfica
        mostrarVentas();

        JOptionPane.showMessageDialog(null, "Venta editada correctamente.");
        limpiarCampos();
    }

    private void seleccionarVentaParaEliminar() {
        String idClienteStr = JOptionPane.showInputDialog("Ingrese el ID del Cliente de la venta que desea eliminar:");
        int idCliente = Integer.parseInt(idClienteStr);
        Venta01 venta = buscarVentaPorIdCliente(String.valueOf(idCliente));
        if (venta!= null) {
            Session session = Hibernateutil.getSessionFactory().getCurrentSession();
            Transaction transaction = session.beginTransaction();
            try {
                session.delete(venta);
                transaction.commit();
                System.out.println("Venta eliminada correctamente para ID Cliente: " + idCliente);
            } catch (Exception e) {
                transaction.rollback();
                System.out.println("Error al eliminar la venta: " + e.getMessage());
            }
        } else {
            System.out.println("Venta no encontrada para ID Cliente: " + idCliente);
        }
    }

    private Venta01 buscarVentaPorIdCliente(String idCliente) {
        for (Venta01 venta : ventasRegistradas) {
            if (venta.getIdCliente().equals(idCliente)) {
                return venta;
            }
        }
        return null;
    }

    private void limpiarCampos() {
        fechaField.setText("");
        productoField.setText("");
        cantidadField.setText("");
        precioUnitarioField.setText("");
        idClienteField.setText("");
        nombreClienteField.setText("");
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            Venta ventaFrame = new Venta();
            ventaFrame.setVisible(true);
        });
    }

    private class Venta01 {
        private String fecha;
        private String producto;
        private String cantidad;
        private String precioUnitario;
        private String idCliente;
        private String nombreCliente;

        public Venta01(String fecha, String producto, String cantidad, String precioUnitario, String idCliente, String nombreCliente) {
            this.fecha = fecha;
            this.producto = producto;
            this.cantidad = cantidad;
            this.precioUnitario = precioUnitario;
            this.idCliente = idCliente;
            this.nombreCliente = nombreCliente;
        }

        public String getFecha() {
            return fecha;
        }

        public String getProducto() {
            return producto;
        }

        public String getCantidad() {
            return cantidad;
        }

        public String getPrecioUnitario() { return precioUnitario;}

        public String getIdCliente() {
            return idCliente;
        }

        public String getNombreCliente() {
            return nombreCliente;
        }

        public void setFecha(String fecha) {
            this.fecha = fecha;
        }

        public void setProducto(String producto) {
            this.producto = producto;
        }

        public void setCantidad(String cantidad) {
            this.cantidad = cantidad;
        }

        public void setPrecioUnitario(String precioUnitario) {
            this.precioUnitario = precioUnitario;
        }

        public void setIdCliente(String idCliente) {
            this.idCliente = idCliente;
        }

        public void setNombreCliente(String nombreCliente) {
            this.nombreCliente = nombreCliente;
        }
    }
}
