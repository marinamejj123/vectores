import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Arrays;
import prueba.OrdenamientoStrategy;
import prueba.concreta1;
import prueba.concreta2;

public class OrdenamientoGUI extends JFrame {

    private JTextField textField;
    private JComboBox<String> comboBox;
    private JButton button;
    private JTextArea textArea;
//estamos tomando al ordenamientoStrategy como nuestrO SETESTRATEGIA
    private OrdenamientoStrategy ordenamientoStrategy;

    public OrdenamientoGUI() {
        // Configuración básica de la ventana
        setTitle("Ordenamiento en Tiempo de Ejecución");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new FlowLayout());

        // Crear componentes
        textField = new JTextField(20);
        comboBox = new JComboBox<>(new String[]{"Bubble Sort", "Insertion Sort"});
        button = new JButton("Ordenar");
        textArea = new JTextArea(10, 30);
        textArea.setEditable(false);

        // Agregar componentes a la ventana
        add(textField);
        add(comboBox);
        add(button);
        add(new JScrollPane(textArea));
        // Escuchar el evento del botón para realizar el ordenamiento
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setEstrategia();
            }
        });

        // Configurar la ventana
        pack();
        setLocationRelativeTo(null); // Centrar ventana en la pantalla
        setVisible(true);
    }

    private void setEstrategia() {
        String input = textField.getText();
        String[] elementos = input.split("\\s+");
        int[] vector = new int[elementos.length];
        for (int i = 0; i < elementos.length; i++) {
            vector[i] = Integer.parseInt(elementos[i]);
        }

        String metodo = (String) comboBox.getSelectedItem();

        switch (metodo) {
            case "Bubble Sort":
                ordenamientoStrategy = new concreta1();
                break;
           case "Insertion Sort":
                ordenamientoStrategy = new concreta2();
                break;
            /*case "Quick Sort":
                ordenamientoStrategy = new QuickSort();
                break;*/
            default:
                // En caso de no seleccionar un método válido, no hacemos nada
                return;
        }

        // Aplicamos el método de ordenamiento seleccionado
        ordenamientoStrategy.ordenar(vector);

        // Mostrar el vector ordenado en consola (puedes mostrarlo en la interfaz gráfica si lo deseas)
        //System.out.println("Vector ordenado: " + Arrays.toString(vector));
        textArea.setText("Vector original: " + Arrays.toString(vector) + "\nVector ordenado: " + Arrays.toString(vector));

    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new OrdenamientoGUI();
            }
        });
    }
}
