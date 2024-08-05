import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class InterfazEsfera extends JFrame {
    private JTextField campoMasaEsferaX;
    private JTextField campoMasaEsferaY;
    private JTextField campoMasaEsferaZ;
    private JLabel etiquetaResultado;

    public InterfazEsfera() {
        setTitle("Comparador de Esferas");
        setSize(350, 250);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new GridLayout(5, 2, 5, 5));

        JLabel etiquetaX = new JLabel("Masa Esfera X:");
        campoMasaEsferaX = new JTextField();
        JLabel etiquetaY = new JLabel("Masa Esfera Y:");
        campoMasaEsferaY = new JTextField();
        JLabel etiquetaZ = new JLabel("Masa Esfera Z:");
        campoMasaEsferaZ = new JTextField();
        JButton botonComparar = new JButton("Determinar");
        etiquetaResultado = new JLabel("", SwingConstants.CENTER);
        etiquetaResultado.setForeground(Color.BLUE);

        botonComparar.setFont(new Font("Arial", Font.BOLD, 14));
        botonComparar.setPreferredSize(new Dimension(150, 40));

        botonComparar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    double esferaX = Double.parseDouble(campoMasaEsferaX.getText());
                    double esferaY = Double.parseDouble(campoMasaEsferaY.getText());
                    double esferaZ = Double.parseDouble(campoMasaEsferaZ.getText());

                    Esfera esferitaX = new Esfera(esferaX);
                    Esfera esferitaY = new Esfera(esferaY);
                    Esfera esferitaZ = new Esfera(esferaZ);

                    Esfera masPesada = Esfera.determinarEsferaMasPesada(esferitaX, esferitaY, esferitaZ);

                    if (masPesada.equals(esferitaX)) {
                        etiquetaResultado.setText("La Esfera X es la más pesada.");
                    } else if (masPesada.equals(esferitaY)) {
                        etiquetaResultado.setText("La Esfera Y es la más pesada.");
                    } else {
                        etiquetaResultado.setText("La Esfera Z es la más pesada.");
                    }
                } catch (NumberFormatException ex) {
                    etiquetaResultado.setText("Introduce valores válidos.");
                }
            }
        });

        add(etiquetaX);
        add(campoMasaEsferaX);
        add(etiquetaY);
        add(campoMasaEsferaY);
        add(etiquetaZ);
        add(campoMasaEsferaZ);
        add(new JLabel()); // Espacio en blanco
        add(botonComparar);
        add(new JLabel()); // Espacio en blanco
        add(etiquetaResultado);

        setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new InterfazEsfera());
    }
}
