package imc;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.JTextArea;

public class Creacion_Imc extends JFrame implements ActionListener{
 
		private JFrame frame;
		private JTextField etiResultado;
		private JTextField txtDocumento;
		private JTextField txtNombre;
		private JTextField txtEdad;
		private JTextField txtPeso;
		private JTextField txtTalla;
		JButton btnRegistrar,btnCalculcarPromedio,btnConsultarLista;
		JTextArea areaTexto;
		 Logica miLogica;
		/**
		 * Launch the application.
		 */
		public static void main(String[] args) {
			EventQueue.invokeLater(new Runnable() {
				public void run() {
					try {
						Creacion_Imc window = new Creacion_Imc();
						window.frame.setVisible(true);

					} catch (Exception e) {
						e.printStackTrace();
					}
					
				}
			});
		}

		/**
		 * Create the application.
		 */
		public Creacion_Imc() {
			initialize();
		}

		/**
		 * Initialize the contents of the frame.
		 */
		private void initialize() {
			frame = new JFrame();
			frame.setBounds(100, 100, 665, 447);
			frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			frame.getContentPane().setLayout(null);
			miLogica= new Logica();
			


			btnRegistrar = new JButton("registrar");
			btnRegistrar.setBounds(56, 359, 89, 23);
			btnRegistrar.addActionListener(this);
			frame.getContentPane().add(btnRegistrar);
			
			
			btnCalculcarPromedio = new JButton("consultar lista\r\n");
			btnCalculcarPromedio.setBounds(172, 359, 128, 23);
			btnCalculcarPromedio.addActionListener(this);
			frame.getContentPane().add(btnCalculcarPromedio);
			
			 btnConsultarLista = new JButton("calcular promedio IMC");
			btnConsultarLista.setBounds(330, 359, 173, 23);
			btnConsultarLista.addActionListener(this);
			frame.getContentPane().add(btnConsultarLista);
			
			txtDocumento = new JTextField();
			txtDocumento.setBounds(123, 97, 86, 20);
			frame.getContentPane().add(txtDocumento);
			txtDocumento.setColumns(10);
			
			txtNombre = new JTextField();
			txtNombre.setBounds(275, 97, 163, 20);
			frame.getContentPane().add(txtNombre); 
			txtNombre.setColumns(10);
			
			JLabel lblNewLabel = new JLabel("resultado");
			lblNewLabel.setBounds(43, 198, 46, 14);
			frame.getContentPane().add(lblNewLabel);
			
			JLabel lblNewLabel_1 = new JLabel("Edad");
			lblNewLabel_1.setBounds(448, 100, 46, 14);
			frame.getContentPane().add(lblNewLabel_1);
			
			JLabel lblNewLabel_2 = new JLabel("Nombre");
			lblNewLabel_2.setBounds(219, 100, 46, 14);
			frame.getContentPane().add(lblNewLabel_2);
			
			JLabel lblNewLabel_3 = new JLabel("documento");
			lblNewLabel_3.setBounds(43, 100, 70, 14);
			frame.getContentPane().add(lblNewLabel_3);
			
			JLabel lblNewLabel_4 = new JLabel("DATOS BASICOS");
			lblNewLabel_4.setBounds(28, 55, 128, 31);
			frame.getContentPane().add(lblNewLabel_4);
			
			txtEdad = new JTextField();
			txtEdad.setBounds(486, 97, 86, 20);
			frame.getContentPane().add(txtEdad);
			txtEdad.setColumns(10);
			
			txtPeso = new JTextField();
			txtPeso.setBounds(123, 165, 86, 20);
			frame.getContentPane().add(txtPeso);
			txtPeso.setColumns(10);
			
			txtTalla = new JTextField();
			txtTalla.setBounds(285, 165, 86, 20);
			frame.getContentPane().add(txtTalla);
			txtTalla.setColumns(10);
			
			JLabel lblNewLabel_4_1 = new JLabel("DATOS IMC");
			lblNewLabel_4_1.setBounds(17, 128, 128, 31);
			frame.getContentPane().add(lblNewLabel_4_1);
			
			JLabel lblNewLabel_5 = new JLabel("peso");
			lblNewLabel_5.setBounds(68, 168, 46, 14);
			frame.getContentPane().add(lblNewLabel_5);
			
			JLabel lblNewLabel_6 = new JLabel("talla");
			lblNewLabel_6.setBounds(234, 168, 46, 14);
			frame.getContentPane().add(lblNewLabel_6);
		 	
			areaTexto = new JTextArea();
			areaTexto.setLineWrap(true);
			areaTexto.setText("informacion");
			
			JScrollPane scrollArea= new JScrollPane();
			scrollArea.setViewportView(areaTexto);
			scrollArea.setBounds(43, 223, 460, 125); 
			frame.getContentPane().add(scrollArea);
		}

		@Override
		public void actionPerformed(ActionEvent e) {


			if (btnRegistrar==e.getSource()) {
				PersonaVO miPersona = new PersonaVO();
				miPersona.setDocumento(txtDocumento.getText());
				miPersona.setNombre(txtNombre.getText());
				miPersona.setEdad(Integer.parseInt(txtEdad.getText()));
				miPersona.setTalla(Double.parseDouble(txtTalla.getText()));
				miPersona.setTalla(Double.parseDouble(txtTalla.getText()));
				miPersona.setPeso(Double.parseDouble(txtPeso.getText()));
				String res= miLogica.registrarPersona(miPersona);
				areaTexto.setText(res);
			}
			
			if (btnConsultarLista==e.getSource()) {
				String res= miLogica.consultarLista();
				areaTexto.setText(res);
			}
			
		}
}
