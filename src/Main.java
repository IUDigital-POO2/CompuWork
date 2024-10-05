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
    private static List<Departamento> departamentos = new ArrayList<>();
    private static JTextArea textArea;

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                JFrame frame = new JFrame("Gestión de Empleados y Departamentos");
                frame.setSize(800, 600);
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.setLocationRelativeTo(null);

                JPanel panel = new JPanel(new BorderLayout());
                textArea = new JTextArea();
                textArea.setEditable(false);
                panel.add(new JScrollPane(textArea), BorderLayout.CENTER);

                JMenuBar menuBar = new JMenuBar();
                JMenu menuEmpleados = new JMenu("Empleados");
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

                menuEmpleados.add(crearItem);
                menuEmpleados.add(actualizarItem);
                menuEmpleados.add(eliminarItem);
                menuEmpleados.add(mostrarItem);
                menuBar.add(menuEmpleados);

                JMenu menuDepartamentos = new JMenu("Departamentos");
                JMenuItem crearDepartamentoItem = new JMenuItem("Crear Departamento");
                JMenuItem actualizarDepartamentoItem = new JMenuItem("Actualizar Departamento");
                JMenuItem eliminarDepartamentoItem = new JMenuItem("Eliminar Departamento");
                JMenuItem asignarEmpleadoItem = new JMenuItem("Asignar Empleado a Departamento");
                JMenuItem mostrarDepartamentosItem = new JMenuItem("Mostrar Departamentos");

                crearDepartamentoItem.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        crearDepartamento();
                    }
                });

                actualizarDepartamentoItem.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        actualizarDepartamento();
                    }
                });

                eliminarDepartamentoItem.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        eliminarDepartamento();
                    }
                });

                asignarEmpleadoItem.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        asignarEmpleadoADepartamento();
                    }
                });

                mostrarDepartamentosItem.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        mostrarDepartamentos();
                    }
                });

                menuDepartamentos.add(crearDepartamentoItem);
                menuDepartamentos.add(actualizarDepartamentoItem);
                menuDepartamentos.add(eliminarDepartamentoItem);
                menuDepartamentos.add(asignarEmpleadoItem);
                menuDepartamentos.add(mostrarDepartamentosItem);
                menuBar.add(menuDepartamentos);

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

            int result = JOptionPane.showOptionDialog(null, panel, "Ingrese los datos del empleado", JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE, null, new Object[]{"Aceptar", "Cancelar"}, "Aceptar");
            if (result == JOptionPane.OK_OPTION) {
                String nombre = nombreField.getText();
                String apellido = apellidoField.getText();
                String id = idField.getText();


                if (tipoEmpleado.equals("Permanente")) {
                    EmpleadoPermanente empleado = new EmpleadoPermanente(nombre, apellido, id, "Permanente", new Date(), new ReporteDesempenio());
                    empleados.add(empleado);
                } else if (tipoEmpleado.equals("Temporal")) {
                    Date fechaFin = new Date(); // Puedes modificar esto para leer una fecha específica
                    EmpleadoTemporal empleado = new EmpleadoTemporal(nombre, apellido, id, "Temporal", new Date(), fechaFin, new ReporteDesempenio());
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



            int result = JOptionPane.showOptionDialog(null, panel, "Actualizar Empleado", JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE, null, new Object[]{"Aceptar", "Cancelar"}, "Aceptar");
            if (result == JOptionPane.OK_OPTION) {
                empleado.setNombre(nombreField.getText());
                empleado.setApellido(apellidoField.getText());

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



    private static void mostrarEmpleados() {
        StringBuilder sb = new StringBuilder();
        for (Empleado empleado : empleados) {
            sb.append(empleado.getId()).append(" - ").append(empleado.getNombre()).append(" ").append(empleado.getApellido()).append(" - ").append(" - ").append(empleado.getTipoEmpleado()).append("\n");
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

    private static void crearDepartamento() {

        JPanel panel = new JPanel(new GridLayout(0, 2));
        panel.add(new JLabel("ID:"));
        JTextField idField = new JTextField();
        panel.add(idField);
        panel.add(new JLabel("Nombre:"));
        JTextField nombreField = new JTextField();
        panel.add(nombreField);
        panel.add(new JLabel("Descripción:"));
        JTextField descripcionField = new JTextField();
        panel.add(descripcionField);
        panel.add(new JLabel("Jefe:"));
        JTextField jefeField = new JTextField();
        panel.add(jefeField);

        int result = JOptionPane.showOptionDialog(null, panel, "Ingrese los datos del departamento", JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE, null, new Object[]{"Aceptar", "Cancelar"}, "Aceptar");
        if (result == JOptionPane.OK_OPTION) {
            String idDepartamento = idField.getText();
            String nombre = nombreField.getText();
            String descripcion = descripcionField.getText();
            String jefe = jefeField.getText();
            Departamento departamento = new Departamento(idDepartamento, nombre, descripcion, jefe);
            departamentos.add(departamento);
        }
    }

    private static void actualizarDepartamento() {
        String idDepartamento = JOptionPane.showInputDialog("Ingrese el id del departamento a actualizar:");
        Departamento departamento = buscarDepartamentoPorID(idDepartamento);

        if (departamento != null) {
            JPanel panel = new JPanel(new GridLayout(0, 2));
            panel.add(new JLabel("Nombre:"));
            JTextField nombreField = new JTextField(departamento.getNombreDepartamento());
            panel.add(nombreField);
            panel.add(new JLabel("Descripción:"));
            JTextField descripcionField = new JTextField(departamento.getDescripcion());
            panel.add(descripcionField);
            panel.add(new JLabel("Jefe:"));
            JTextField jefeField = new JTextField(departamento.getJefe());
            panel.add(jefeField);

            int result = JOptionPane.showOptionDialog(null, panel, "Actualizar Departamento", JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE, null, new Object[]{"Aceptar", "Cancelar"}, "Aceptar");
            if (result == JOptionPane.OK_OPTION) {
                departamento.setNombreDepartamento(nombreField.getText());
                departamento.setDescripcion(descripcionField.getText());
                departamento.setJefe(jefeField.getText());
            }
        } else {
            JOptionPane.showMessageDialog(null, "Departamento no encontrado.");
        }
    }

    private static void eliminarDepartamento() {
        String idDepartamento = JOptionPane.showInputDialog("Ingrese el id del departamento a eliminar:");
        Departamento departamento = buscarDepartamentoPorID(idDepartamento);

        if (departamento != null) {
            departamentos.remove(departamento);
            JOptionPane.showMessageDialog(null, "Departamento eliminado.");
        } else {
            JOptionPane.showMessageDialog(null, "Departamento no encontrado.");
        }
    }

    private static void asignarEmpleadoADepartamento() {
        String idEmpleado = JOptionPane.showInputDialog("Ingrese el ID del empleado:");
        Empleado empleado = buscarEmpleadoPorId(idEmpleado);

        if (empleado != null) {
            String idDepartamento = JOptionPane.showInputDialog("Ingrese el id del departamento:");
            Departamento departamento = buscarDepartamentoPorID(idDepartamento);

            if (departamento != null) {
                departamento.agregarEmpleado(empleado);
                JOptionPane.showMessageDialog(null, "Empleado asignado al departamento.");
            } else {
                JOptionPane.showMessageDialog(null, "Departamento no encontrado.");
            }
        } else {
            JOptionPane.showMessageDialog(null, "Empleado no encontrado.");
        }
    }

    private static void mostrarDepartamentos() {
        StringBuilder sb = new StringBuilder();
        for (Departamento departamento : departamentos) {
            sb.append(departamento.getId()).append(" - ").append(departamento.getNombreDepartamento()).append(" - ").append(departamento.getDescripcion()).append(" - ").append(departamento.getJefe()).append("\n");
            sb.append("Empleados:\n");
            for (Empleado empleado : departamento.getEmpleados()) {
                sb.append("  ").append(empleado.getId()).append(" - ").append(empleado.getNombre()).append(" ").append(empleado.getApellido()).append("\n");
            }
        }
        textArea.setText(sb.toString());
    }

    private static Departamento buscarDepartamentoPorID(String idDepartamento) {
        for (Departamento departamento : departamentos) {
            if (departamento.getId().equals(idDepartamento)) {
                return departamento;
            }
        }
        return null;
    }


}
