package PaqueteMetodos.ProyectoParcial;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class PanelPrincipal extends JFrame {
    // Atributos
    private JLabel Titulo;
    private JLabel Descripcion;
    private JLabel txtNombre;
    private JTextField dNombre;
    private JLabel txtApellidos;
    private JTextField dApellidos;
    private JLabel namecompania;

    // Selección de Departamento
    private JLabel txtDepartamento;
    private JPopupMenu menuDepartamento;  
    private JMenuItem Tecnico;
    private JMenuItem Oficina;
    private JMenuItem Gerencia;
    private JButton botonDepartamento;

    // Selección de Antigüedad
    private JLabel txtAntiguedad;
    private JButton botonAntiguedad;

    // Vacaciones
    private JPopupMenu menuAntiguedad;
    private JMenuItem uno;
    private JMenuItem dos;
    private JMenuItem siete;
    private JLabel totalVacaciones;

    // Botón para cambiar el fondo
    private JButton cambiarFondoButton;

    // Botón Info Creador
    private JButton botonCreador;

    // Métodos
    public void datos() {
        // Título
        Titulo = new JLabel("Bienvenido: ");
        Titulo.setBounds(250, 40, 500, 36);
        Titulo.setForeground(Color.BLACK);
        Titulo.setFont(new Font("Arial", Font.BOLD, 30));
        add(Titulo);

        Descripcion = new JLabel("Ingrese los datos del trabajador para el cálculo vacacional");
        Descripcion.setBounds(100, 120, 500, 20);
        Descripcion.setForeground(Color.BLACK);
        Descripcion.setFont(new Font("Arial", Font.BOLD, 16));
        add(Descripcion);

        // Nombres título / área de texto
        txtNombre = new JLabel("Nombres");
        txtNombre.setBounds(30, 200, 100, 20);
        add(txtNombre);

        dNombre = new JTextField();
        dNombre.setBounds(30, 220, 120, 30);
        add(dNombre);

        // Apellidos título / área de texto
        txtApellidos = new JLabel("Apellidos");
        txtApellidos.setBounds(30, 260, 100, 20);
        add(txtApellidos);
        
        dApellidos = new JTextField();
        dApellidos.setBounds(30, 280, 120, 30);
        add(dApellidos);

        // Título menú Selección de Departamento
        txtDepartamento = new JLabel("Selecciona el Departamento");
        txtDepartamento.setBounds(250, 200, 200, 20);
        add(txtDepartamento);

        // Botón para mostrar el departamento seleccionado
        botonDepartamento = new JButton();
        botonDepartamento.setBounds(250, 220, 200, 30);
        add(botonDepartamento);

        // Botón para mostrar el Creador
        botonCreador = new JButton("Creador");
        botonCreador.setBounds(30, 400, 150, 30);
        botonCreador.addActionListener(e -> {
            showDialog("Creador", "<html>Kevin Josué Gabriel Otzoy<br/>"+"Version Beta<html>" ); // Mostrar el diálogo
        });
        add(botonCreador);
        namecompania = new JLabel("<html>REDCONN-SOLUTIONS<br/>"+"Kevin Gabriel<br/>"+"Programacion II D<html>");
        namecompania.setForeground(Color.black);
        namecompania.setBounds(100, 450 , 150, 50); // Posicionar la descripción
        add(namecompania);

        // Menú Selección de Departamento
        menuDepartamento = new JPopupMenu();
        Tecnico = new JMenuItem("Técnico");
        Oficina = new JMenuItem("Oficina");
        Gerencia = new JMenuItem("Gerencia");

        menuDepartamento.add(Tecnico);
        menuDepartamento.add(Oficina);
        menuDepartamento.add(Gerencia);

        // Acción para el menú
        Tecnico.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                botonDepartamento.setText("Técnico");
                configurarAntiguedadMenu("Técnico");
            }
        });

        Oficina.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                botonDepartamento.setText("Oficina");
                configurarAntiguedadMenu("Oficina");
            }
        });

        Gerencia.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                botonDepartamento.setText("Gerencia");
                configurarAntiguedadMenu("Gerencia");
            }
        });

        // Listener para desplegar el menú al hacer clic en el botón
        botonDepartamento.addMouseListener(new MouseAdapter() {
            public void mousePressed(MouseEvent e) {
                menuDepartamento.setPopupSize(botonDepartamento.getWidth(), menuDepartamento.getPreferredSize().height);
                menuDepartamento.show(botonDepartamento, 0, botonDepartamento.getHeight());
            }
        });

        // Título menú Selección de Antigüedad
        txtAntiguedad = new JLabel("Selecciona la Antigüedad");
        txtAntiguedad.setBounds(250, 260, 200, 20);
        add(txtAntiguedad);

        // Botón para antigüedad
        botonAntiguedad = new JButton();
        botonAntiguedad.setBounds(250, 280, 200, 30);
        add(botonAntiguedad);

        // Listener para desplegar el menú de antigüedad
        botonAntiguedad.addMouseListener(new MouseAdapter() {
            public void mousePressed(MouseEvent e) {
                if (menuAntiguedad != null) {
                    menuAntiguedad.setPopupSize(botonAntiguedad.getWidth(), menuAntiguedad.getPreferredSize().height);
                    menuAntiguedad.show(botonAntiguedad, 0, botonAntiguedad.getHeight());
                }
            }
        });

        // Label para mostrar las vacaciones calculadas
        totalVacaciones = new JLabel();
        totalVacaciones.setBounds(250, 320, 300, 60);
        add(totalVacaciones);

        // Botón para cambiar el fondo
        cambiarFondoButton = new JButton("Cambiar fondo");
        cambiarFondoButton.setBounds(30, 350, 150, 30);
        add(cambiarFondoButton);

        // Acción para cambiar el color del fondo
        cambiarFondoButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                Color nuevoColor = JColorChooser.showDialog(null, "Seleccionar color de fondo", getContentPane().getBackground());
                if (nuevoColor != null) {
                    getContentPane().setBackground(nuevoColor);
                }
            }
        });

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    private void showDialog(String title, String message) {
        JOptionPane.showMessageDialog(this, message, title, JOptionPane.INFORMATION_MESSAGE);
    }

    private void configurarAntiguedadMenu(String departamento) {
        // Crear o limpiar el menú de antigüedad
        if (menuAntiguedad == null) {
            menuAntiguedad = new JPopupMenu();
        } else {
            menuAntiguedad.removeAll();
        }

        // Crear opciones de antigüedad
        uno = new JMenuItem("1 año de Servicio");
        dos = new JMenuItem("2-6 años de Servicio");
        siete = new JMenuItem("7 o más años de Servicio");

        menuAntiguedad.add(uno);
        menuAntiguedad.add(dos);
        menuAntiguedad.add(siete);

        // Acción para cada opción según el departamento
        uno.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                mostrarVacaciones(departamento, 1);
            }
        });

        dos.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                mostrarVacaciones(departamento, 2);
            }
        });

        siete.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                mostrarVacaciones(departamento, 7);
            }
        });
    }

    private void mostrarVacaciones(String departamento, int antiguedad) {
        String nombre = dNombre.getText();
        String apellidos = dApellidos.getText();
        String vacaciones = "";
        String tiempoServicio = "";

        // Determina el texto para el tiempo de servicio
        if (antiguedad == 1) {
            tiempoServicio = "1 año de servicio";
        } else if (antiguedad == 2) {
            tiempoServicio = "2-6 años de servicio";
        } else {
            tiempoServicio = "7 o más años de servicio";
        }

        // Determina los días de vacaciones según el departamento y antigüedad
        if (departamento.equals("Técnico")) {
            if (antiguedad == 1) {
                vacaciones = "6 días de vacaciones";
            } else if (antiguedad == 2) {
                vacaciones = "14 días de vacaciones";
            } else {
                vacaciones = "20 días de vacaciones";
            }
        } else if (departamento.equals("Oficina")) {
            if (antiguedad == 1) {
                vacaciones = "7 días de vacaciones";
            } else if (antiguedad == 2) {
                vacaciones = "15 días de vacaciones";
            } else {
                vacaciones = "22 días de vacaciones";
            }
        } else if (departamento.equals("Gerencia")) {
            if (antiguedad == 1) {
                vacaciones = "10 días de vacaciones";
            } else if (antiguedad == 2) {
                vacaciones = "18 días de vacaciones";
            } else {
                vacaciones = "30 días de vacaciones";
            }
        }

        // Mostrar las vacaciones calculadas junto con el nombre, apellidos y tiempo de servicio
        totalVacaciones.setText("<html>El trabajador: " + nombre + " " + apellidos + "<br/>" +
            "con " + tiempoServicio + "<br/>" + " Tiene derecho a " + vacaciones + ".</html>");

    }

    

    public static void main(String[] args) {
        PanelPrincipal vacaciones = new PanelPrincipal();
        vacaciones.setBounds(400, 10, 650, 550);
        vacaciones.setLayout(null);
        vacaciones.datos();
        vacaciones.setVisible(true);
    }
}
