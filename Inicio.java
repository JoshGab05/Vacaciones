package PaqueteMetodos.ProyectoParcial;

import javax.swing.*;
import java.awt.*;

public class Inicio extends JFrame {

    // Atributos
    private JLabel encabezado;
    private JLabel nameuser;
    private JTextField nombreTextField;
    private JButton enviarButton;
    private JLabel namecompania;
    private JPanel panelFormulario;
    private JPanel panelPrincipal;
    private static String nombre;
    private JLabel logoLabel; // Nuevo atributo para el logotipo

    // Métodos
    public void ingresar() {
        // Panel principal
        panelPrincipal = new JPanel(null); // Usando null para layout absoluto

        // Panel del formulario
        panelFormulario = new JPanel(null); // Usando layout absoluto para el panel
        panelFormulario.setBackground(Color.GRAY);
        panelFormulario.setBounds(0, 0, 350, 450); // Definir tamaño y posición del panel

        // Cargar el logotipo
        ImageIcon logoIcon = new ImageIcon(getClass().getResource("/PaqueteMetodos/ProyectoParcial/LogoRedconn/logo.png"));

        // Redimensionar el logotipo
        Image logoImage = logoIcon.getImage(); // Obtener la imagen del icono
        Image resizedImage = logoImage.getScaledInstance(200, 200, Image.SCALE_SMOOTH); // Redimensionar a 200x200 píxeles
        ImageIcon resizedLogoIcon = new ImageIcon(resizedImage); // Crear un nuevo ImageIcon con la imagen redimensionada

        // Asignar el icono redimensionado al JLabel
        logoLabel = new JLabel(resizedLogoIcon);
        logoLabel.setBounds(75, 20, 200, 200); // Posicionar el logo

        // Encabezado
        encabezado = new JLabel("Sistema de Control Vacacional");
        encabezado.setForeground(Color.BLACK);
        encabezado.setFont(new Font("Arial", Font.ITALIC, 18));
        encabezado.setBounds(50, 180, 250, 30); // Posicionar el encabezado

        // Etiqueta para el nombre
        nameuser = new JLabel("Ingrese su nombre:");
        nameuser.setForeground(Color.BLACK);
        nameuser.setBounds(50, 230, 250, 20); // Posicionar la etiqueta

        // Campo de texto
        nombreTextField = new JTextField(15);
        nombreTextField.setBounds(50, 250, 250, 30); // Posicionar el campo de texto

        // Botón de enviar
        enviarButton = new JButton("INGRESAR");
        enviarButton.setForeground(Color.BLACK);
        enviarButton.setBounds(100, 300, 150, 30); // Posicionar el botón

        // Descripción
        namecompania = new JLabel("<html>REDCONN-SOLUTIONS<br/>"+"Kevin Gabriel<br/>"+"Programacion II D<html>");
        namecompania.setForeground(Color.black);
        namecompania.setBounds(100, 350, 150, 50); // Posicionar la descripción

        // Funcionalidad del botón
        enviarButton.addActionListener(e -> {
            nombre = nombreTextField.getText().trim(); // Guardar el nombre ingresado y eliminar espacios en blanco

            if (nombre.isEmpty()) {
                // Mostrar mensaje de advertencia si el nombre está vacío
                JOptionPane.showMessageDialog(this, "Por favor, ingrese su nombre.", "Advertencia", JOptionPane.WARNING_MESSAGE);
            } else {
                // Si el nombre no está vacío, proceder
                dispose(); // Cerrar la ventana actual
                abrirVentanaLicencia(nombre); // Pasar el nombre
            }
        });

        // Añadir componentes al panel
        panelFormulario.add(logoLabel);
        panelFormulario.add(encabezado);
        panelFormulario.add(nameuser);
        panelFormulario.add(nombreTextField);
        panelFormulario.add(enviarButton);
        panelFormulario.add(namecompania);

        // Añadir panel al frame
        panelPrincipal.add(panelFormulario);
        add(panelPrincipal);

        Image iconImage = logoIcon.getImage().getScaledInstance(32, 32, Image.SCALE_SMOOTH); 
        setIconImage(iconImage); 

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    // Método para abrir la ventana de términos y condiciones
    private void abrirVentanaLicencia(String nombre) {
        LicenciadeUso.abrirVentana(nombre);
    }

    // Método principal
    public static void main(String[] args) {
        Inicio frame = new Inicio();
        frame.setBounds(500, 10, 350, 450);
        frame.ingresar();
        frame.setVisible(true);
    }
}
