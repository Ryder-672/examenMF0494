package uf2179;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import net.miginfocom.swing.MigLayout;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Color;
import javax.swing.JRadioButton;
import javax.swing.ButtonGroup;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JTextArea;
import javax.swing.JList;
import javax.swing.JScrollBar;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class VentanaMultas extends JFrame {

	private JPanel contentPane;
	private final ButtonGroup buttonGroupPago = new ButtonGroup();
	private JTextField textMatricula;
	private JTextField textNombre;
	private JTextField textApellidos;
	private JButton btnAceptar;
	private JLabel lblImporteDato;
	private JRadioButton rdbtnPagoNormal;
	private JRadioButton rdbtnProntoPago;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VentanaMultas frame = new VentanaMultas();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public VentanaMultas() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(new MigLayout("", "[grow][grow][][][grow]", "[][][][][][][][grow]"));
		
		JLabel lblNewLabel = new JLabel("DGT - Infracciones");
		lblNewLabel.setOpaque(true);
		lblNewLabel.setBackground(new Color(0, 0, 0));
		lblNewLabel.setForeground(new Color(255, 255, 255));
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 14));
		contentPane.add(lblNewLabel, "cell 0 0 4 1");
		
		JLabel lblNewLabel_1 = new JLabel("Matricula:");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		contentPane.add(lblNewLabel_1, "cell 0 1,alignx trailing");
		
		textMatricula = new JTextField();
		contentPane.add(textMatricula, "cell 1 1,growx");
		textMatricula.setColumns(10);
		
		JLabel lblNewLabel_1_1 = new JLabel("Nombre:");
		lblNewLabel_1_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		contentPane.add(lblNewLabel_1_1, "cell 3 1,alignx trailing");
		
		textNombre = new JTextField();
		textNombre.setColumns(10);
		contentPane.add(textNombre, "cell 4 1,growx");
		
		JLabel lblNewLabel_1_1_1 = new JLabel("Apellidos:");
		lblNewLabel_1_1_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		contentPane.add(lblNewLabel_1_1_1, "cell 0 2,alignx trailing");
		
		textApellidos = new JTextField();
		textApellidos.setColumns(10);
		contentPane.add(textApellidos, "cell 1 2 4 1,growx");
		
		JLabel lblNewLabel_1_1_2 = new JLabel("Sanción:");
		lblNewLabel_1_1_2.setFont(new Font("Tahoma", Font.PLAIN, 14));
		contentPane.add(lblNewLabel_1_1_2, "cell 0 3,alignx trailing");
		
		JComboBox comboBoxSancion = new JComboBox();
		comboBoxSancion.setModel(new DefaultComboBoxModel(new String[] {"No llevar casco", "Conduccion temeraria"}));
			
		comboBoxSancion.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String operacion = (String) comboBoxSancion.getSelectedItem();
				if (operacion.equals("No llevar casco")) {
					lblImporteDato.setText("200" );

				}else {
					lblImporteDato.setText("500" );

				}
				
				
			}
		});
			
			
	
		contentPane.add(comboBoxSancion, "cell 1 3 4 1,growx");
		
		JLabel lblNewLabel_1_1_3 = new JLabel("Importe:");
		lblNewLabel_1_1_3.setFont(new Font("Tahoma", Font.PLAIN, 14));
		contentPane.add(lblNewLabel_1_1_3, "cell 0 4");
		
		lblImporteDato = new JLabel("");
		contentPane.add(lblImporteDato, "cell 1 4");
		
		rdbtnPagoNormal = new JRadioButton("Pago Normal");
		buttonGroupPago.add(rdbtnPagoNormal);
		rdbtnPagoNormal.setSelected(true);
		contentPane.add(rdbtnPagoNormal, "cell 1 5");
		
		rdbtnProntoPago = new JRadioButton("Pronto Pago");
		buttonGroupPago.add(rdbtnProntoPago);
		contentPane.add(rdbtnProntoPago, "cell 3 5");
		
	
		
		JTextArea textArea = new JTextArea();
		
		contentPane.add(textArea, "flowx,cell 0 7 5 1,grow");
		
		btnAceptar = new JButton("Aceptar");
		btnAceptar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			String nombre = textNombre.getText();
			String apelli = textApellidos.getText();
			String infrac = textApellidos.getText();

			
			int sancion;
			double sancionFin;

			String operacion = (String) comboBoxSancion.getSelectedItem();
			if (operacion.equals("No llevar casco")) {
				sancion = 200;
				infrac = "No llevar casco";
			}else {
				sancion=500;
				infrac = "Conduccion temeraria";

			}

			if (rdbtnProntoPago.isSelected()) {
				sancionFin= sancion/2;
			}else {
				sancionFin= sancion;
			}
			
			textArea.setText("conductor: "+ nombre +"  "+ apelli+
					"\nInfraccion:" +infrac+
					"\nImporte:" + sancion+
					"\nPronto pago"+ sancionFin);
				
				
			}
		});
		contentPane.add(btnAceptar, "cell 0 6 5 1,alignx center");
	}

}
