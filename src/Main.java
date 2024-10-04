import java.util.Date;
import java.util.Scanner;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Main {
    private static List<Empleado> empleados = new ArrayList<>();
    private static JTextArea textArea;
    public static void main(String[] args) {

        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                JFrame frame = new JFrame("Gestión de Empleados");
                frame.setSize(600, 400);
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.setLocationRelativeTo(null);

                // Crear el panel principal
                JPanel panel = new JPanel(new BorderLayout());
                textArea = new JTextArea();
                textArea.setEditable(false);
                panel.add(new JScrollPane(textArea), BorderLayout.CENTER);

                // Crear el menú
                JMenuBar menuBar = new JMenuBar();
                JMenu menu = new JMenu("Empleados");
                JMenuItem crearItem = new JMenuItem("Crear Empleado");
                JMenuItem actualizarItem = new JMenuItem("Actualizar Empleado");
                JMenuItem eliminarItem = new JMenuItem("Eliminar Empleado");
                JMenuItem mostrarItem = new JMenuItem("Mostrar Empleados");

                // Agregar acciones a los ítems del menú
                crearItem.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        crearEmpleado();
                    }
                });

                actualizarItem.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        actualizarEmpleado();
                    }
                });

                eliminarItem.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        eliminarEmpleado();
                    }
                });

                mostrarItem.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        mostrarEmpleados();
                    }
                });

                menu.add(crearItem);
                menu.add(actualizarItem);
                menu.add(eliminarItem);
                menu.add(mostrarItem);
                menuBar.add(menu);
                frame.setJMenuBar(menuBar);

                frame.add(panel);
                frame.setVisible(true);
            }
        });
    }

    private static void crearEmpleado() {
        String[] opciones = {"Permanente", "Temporal"};
        String tipoEmpleado = (String) JOptionPane.showInputDialog(null, "Seleccione el tipo de empleado:", "Crear Empleado", JOptionPane.QUESTION_MESSAGE, null, opciones, opciones[0]);

        if (tipoEmpleado != null) {
            JPanel panel = new JPanel(new GridLayout(0, 2));
            panel.add(new JLabel("Nombre:"));
            JTextField nombreField = new JTextField();
            panel.add(nombreField);
            panel.add(new JLabel("Apellido:"));
            JTextField apellidoField = new JTextField();
            panel.add(apellidoField);
            panel.add(new JLabel("ID:"));
            JTextField idField = new JTextField();
            panel.add(idField);
            panel.add(new JLabel("Departamento:"));
            JTextField departamentoField = new JTextField();
            panel.add(departamentoField);

            int result = JOptionPane.showOptionDialog(null, panel, "Ingrese los datos del empleado", JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE, null, new Object[]{"Aceptar", "Cancelar"}, "Aceptar");
            if (result == JOptionPane.OK_OPTION) {
                String nombre = nombreField.getText();
                String apellido = apellidoField.getText();
                String id = idField.getText();
                String departamento = departamentoField.getText();

                if (tipoEmpleado.equals("Permanente")) {
                    EmpleadoPermanente empleado = new EmpleadoPermanente(nombre, apellido, id, departamento, "Permanente", new Date(), new ReporteDesempenio());
                    empleados.add(empleado);
                } else if (tipoEmpleado.equals("Temporal")) {
                    Date fechaFin = new Date(); // Puedes modificar esto para leer una fecha específica
                    EmpleadoTemporal empleado = new EmpleadoTemporal(nombre, apellido, id, departamento, "Temporal", new Date(), fechaFin, new ReporteDesempenio());
                    empleados.add(empleado);
                }
            }
        }
    }

    private static void actualizarEmpleado() {
        String id = JOptionPane.showInputDialog("Ingrese el ID del empleado a actualizar:");
        Empleado empleado = buscarEmpleadoPorId(id);

        if (empleado != null) {
            JPanel panel = new JPanel(new GridLayout(0, 2));
            panel.add(new JLabel("Nombre:"));
            JTextField nombreField = new JTextField(empleado.getNombre());
            panel.add(nombreField);
            panel.add(new JLabel("Apellido:"));
            JTextField apellidoField = new JTextField(empleado.getApellido());
            panel.add(apellidoField);
            panel.add(new JLabel("Departamento:"));
            JTextField departamentoField = new JTextField(empleado.getDepartamento());
            panel.add(departamentoField);

            int result = JOptionPane.showOptionDialog(null, panel, "Actualizar Empleado", JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE, null, new Object[]{"Aceptar", "Cancelar"}, "Aceptar");
            if (result == JOptionPane.OK_OPTION) {
                empleado.setNombre(nombreField.getText());
                empleado.setApellido(apellidoField.getText());
                empleado.setDepartamento(departamentoField.getText());
            }
        } else {
            JOptionPane.showMessageDialog(null, "Empleado no encontrado.");
        }
    }

    private static void eliminarEmpleado() {
        String id = JOptionPane.showInputDialog("Ingrese el ID del empleado a eliminar:");
        Empleado empleado = buscarEmpleadoPorId(id);

        if (empleado != null) {
            empleados.remove(empleado);
            JOptionPane.showMessageDialog(null, "Empleado eliminado.");
        } else {
            JOptionPane.showMessageDialog(null, "Empleado no encontrado.");
        }
    }

    /*private static void mostrarEmpleados() {
        StringBuilder sb = new StringBuilder();
        for (Empleado empleado : empleados) {
            sb.append(empleado.getNombre()).append(" ").append(empleado.getApellido()).append(" - ").append(empleado.getTipoEmpleado()).append("\n");
        }
        JOptionPane.showMessageDialog(null, sb.toString(), "Lista de Empleados", JOptionPane.INFORMATION_MESSAGE);
    }*/

    private static void mostrarEmpleados() {
        StringBuilder sb = new StringBuilder();
        for (Empleado empleado : empleados) {
            sb.append(empleado.getId()).append(" - ").append(empleado.getNombre()).append(" ").append(empleado.getApellido()).append(" - ").append(empleado.getDepartamento()).append(" - ").append(empleado.getTipoEmpleado()).append("\n");
        }
        textArea.setText(sb.toString());
    }

    private static Empleado buscarEmpleadoPorId(String id) {
        for (Empleado empleado : empleados) {
            if (empleado.getId().equals(id)) {
                return empleado;
            }
        }
        return null;
    }
}
