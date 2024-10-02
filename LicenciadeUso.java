package PaqueteMetodos.ProyectoParcial;

import javax.swing.*;
import java.awt.*;

public class LicenciadeUso extends JFrame {

    // Atributos
    private JLabel encabezado;
    private JTextArea areaDeTexto;
    private JScrollPane scrollPane;
    private JCheckBox aceptarCheckbox;
    private JButton aceptarButton;
    private JButton noAceptarButton;
    private JPanel panelFormulario;
    private JPanel panelBotones;
    private JPanel panelPrincipal;

    // Métodos
    public void mostrar(String nombre) {
        // Panel principal
        panelPrincipal = new JPanel(null); // Usando layout null para control absoluto

        // Panel del formulario
        panelFormulario = new JPanel(null); // Usando layout null para el panel
        panelFormulario.setBackground(Color.GRAY);
        panelFormulario.setBounds(0, 0, 800, 450); // Definir tamaño y posición del panel

        // Encabezado
        encabezado = new JLabel("Términos y Condiciones");
        encabezado.setForeground(Color.BLACK);
        encabezado.setFont(new Font("Arial", Font.BOLD, 18));
        encabezado.setBounds(150, 10, 250, 30); // Posicionar el encabezado

        // Área de texto con términos y condiciones
        areaDeTexto = new JTextArea(10, 40);
        areaDeTexto.setText("\n\n" +
                "          TÉRMINOS Y CONDICIONES\n\n" +
                "          A. PROHIBIDA SU VENTA O DISTRIBUCIÓN SIN AUTORIZACIÓN DE KEVIN GABRIEL.\n" +
                "          B. PROHIBIDA LA ALTERACIÓN DEL CÓDIGO FUENTE O DISEÑO DE LAS INTERFACES GRÁFICAS.\n" +
                "          C. KEVIN GABRIEL NO SE HACE RESPONSABLE DEL MAL USO DE ESTE SOFTWARE.\n\n" +
                "          LOS ACUERDOS LEGALES EXPUESTOS ACONTINUACIÓN RIGEN EL USO QUE USTED HAGA DE ESTE SOFTWARE.\n" +
                "          NO SE RESPONSABILIZAN DEL USO QUE USTED HAGA CON ESTE SOFTWARE Y SUS SERVICIOS.\n" +
                "          PARA ACEPTAR ESTOS TERMINOS HAGA CLIC EN (ACEPTO).\n" +
                "          SI USTED NO ACEPTA ESTOS TERMINOS, HAGA CLIC EN (NO ACEPTO) Y NO UTILICE ESTE SOFTWARE.");
        areaDeTexto.setFont(new Font("Arial", Font.PLAIN, 9));
        areaDeTexto.setLineWrap(true);
        areaDeTexto.setWrapStyleWord(true);
        areaDeTexto.setEditable(false);

        scrollPane = new JScrollPane(areaDeTexto);
        scrollPane.setBounds(30, 50, 550, 200); // Posicionar el scrollPane

        // Checkbox para aceptar términos
        aceptarCheckbox = new JCheckBox("Acepto los términos y condiciones (" + nombre + ")");
        aceptarCheckbox.setBounds(30, 260, 550, 20); // Posicionar el checkbox

        // Botones de aceptar y no aceptar
        aceptarButton = new JButton("Aceptar");
        aceptarButton.setEnabled(false);
        aceptarButton.setBounds(150, 290, 100, 30); // Posicionar botón de aceptar

        noAceptarButton = new JButton("No Aceptar");
        noAceptarButton.setBounds(300, 290, 120, 30); // Posicionar botón de no aceptar

        // Evento para habilitar el botón de aceptar
        aceptarCheckbox.addActionListener(e -> aceptarButton.setEnabled(aceptarCheckbox.isSelected()));

        // Acción al aceptar
        aceptarButton.addActionListener(e -> {
            JOptionPane.showMessageDialog(this, "Has aceptado los términos y condiciones.");
            dispose(); // Cerrar la ventana
            abrirVentanaVacaciones(nombre); // Abrir ventana de cálculo de vacaciones
        });

        // Acción al no aceptar
        noAceptarButton.addActionListener(e -> {
            JOptionPane.showMessageDialog(this, "No has aceptado los términos y condiciones.");
            dispose(); // Cerrar la ventana
        });

        // Añadir componentes al panel
        panelFormulario.add(encabezado);
        panelFormulario.add(scrollPane);
        panelFormulario.add(aceptarCheckbox);
        panelFormulario.add(aceptarButton);
        panelFormulario.add(noAceptarButton);

        // Añadir el panel del formulario al panel principal
        panelPrincipal.add(panelFormulario);
        add(panelPrincipal);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(610, 370);
    }

    // Método para abrir la ventana de cálculo de vacaciones
    private void abrirVentanaVacaciones(String nombre) {
        PanelPrincipal ventanaVacaciones = new PanelPrincipal();
        ventanaVacaciones.setBounds(400, 10, 650, 550);
        
        ventanaVacaciones.setLayout(null);  // Agrega el layout null como en el main de PanelPrincipal
        ventanaVacaciones.datos();  // Inicializa la ventana de vacaciones
        
        ventanaVacaciones.setVisible(true);
    }

    // Método para abrir la ventana de Licencia de Uso
    public static void abrirVentana(String nombre) {
        LicenciadeUso licencia = new LicenciadeUso();
        licencia.setBounds(400, 10, 350, 450);
        licencia.mostrar(nombre);
        licencia.setVisible(true);
    }
}
