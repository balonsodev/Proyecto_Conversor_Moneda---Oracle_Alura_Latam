package Conversor.views;

import java.awt.EventQueue;

//import conversorTemperatura.functionTemperatura;

import javax.swing.*;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JRadioButton;
import javax.swing.JButton;
import java.awt.Toolkit;
import java.awt.CardLayout;
import javax.swing.UIManager;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.JComboBox;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JTextField;
import javax.swing.JList;
import javax.swing.JOptionPane;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JScrollPane;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JTabbedPane;
import javax.swing.JDesktopPane;
import java.awt.Color;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.event.ItemListener;
import java.awt.event.ItemEvent;

public class Home extends JFrame {

	private JPanel contentPane;
	public double dolar = 547.99;
	public double euro = 601.72;
	public double yenJapones = 3.94;
	public double wonSulCoreano = 0.43;
	public double libraEsterlina = 700.92;
	public double cordobaNicaraguense = 14.77;
	private JTextField impValorMontoInicial;
	private JLabel displayGrandeCalc;
	private JLabel displayPeqCalc;
	private String cadenaNumeros = "";
	private String operacion = "nula";
	private double primerNumero, resultado;
	private boolean activado = true;
	private boolean punto = true;
	public String seleccionada;
	private JLabel lblResultado;
	private JComboBox cbOpcionesMoneda;
	private JButton btnCalcular;
	private JTextField tempInicial;
	private JLabel lblTempFinal;
	private JComboBox cbTempSelection;
	private JButton btnCalcPosONeg;



	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {

		// function <Temperatura> temperatura = new functionTemperatura();

		try {
			UIManager.setLookAndFeel("com.apple.laf.AquaLookAndFeel");
		} catch (Throwable e) {
			e.printStackTrace();
		}
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Home frame = new Home();
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
	public Home() {

		initComponents();
		createEvents();

	}

	/////////////////////////////////////////////////////////////////
	//// Este metodo contiene todo el codigo
	//// para crear e inicializar components
	////
	//// This method contains all of the code
	//// for creating and initializing components.
	/////////////////////////////////////////////////////////////////

	/**
	 * 
	 */
	private void initComponents() {
		// TODO Auto-generated method stub
		
		try {
			// here you can put the selected theme class name in JTattoo
			UIManager.setLookAndFeel("com.jtattoo.plaf.aluminium.AluminiumLookAndFeel");
			
		} catch (ClassNotFoundException ex) {
			java.util.logging.Logger.getLogger(Home.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
		} catch (InstantiationException ex) {
			java.util.logging.Logger.getLogger(Home.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
		} catch (IllegalAccessException ex) {
			java.util.logging.Logger.getLogger(Home.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
		} catch (javax.swing.UnsupportedLookAndFeelException ex) {
			java.util.logging.Logger.getLogger(Home.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
		}
		
		
		cbOpcionesMoneda = new JComboBox();
		cbOpcionesMoneda.setModel(new DefaultComboBoxModel(new String[] {"Seleccione una moneda a cambiar", "Colones a Dolar", "Colones a Euros", "Colones a Libras Esterlinas", "Colones a Yen Japones", "Colones a Won Sul Coreano", "Colones a Cordoba Nicaraguense", "Dolares a Colones", "Euros a Colones", "Libras Esterlinas a Colones", "Yen Japones a Colones", "Won Sul Coreano a Colones", "Cordoba Nicaraguese a Colones"}));
		cbOpcionesMoneda.setToolTipText("");
		cbOpcionesMoneda.setSelectedIndex(0);
		cbOpcionesMoneda.addItemListener(new ItemListener() {

			public void itemStateChanged(ItemEvent e) {
						if(e.getSource() == cbOpcionesMoneda) {
							
							seleccionada = cbOpcionesMoneda.getSelectedItem().toString();
							
						}
				
			}
		});
	
	
		setTitle("Calculadora de Divisas ");
		setIconImage(Toolkit.getDefaultToolkit().getImage(Home.class.getResource("/Conversor/resources/logo modif.png")));
		
		//String opciones = (JOptionPane.showInputDialog(null, "Seleccione una opción de conversión ", "Menu", JOptionPane.QUESTION_MESSAGE, null, new Object[] {"Conversor de Moneda", "Conversor de Temperatura"}, "Seleccion")).toString();
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(200, 100, 341, 478);
		contentPane = new JPanel();
		contentPane.setForeground(new Color(255, 255, 255));
		contentPane.setBackground(new Color(238, 238, 238));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		
		JComboBox comboBox_1 = new JComboBox();
		
		JList list = new JList();
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		
		JPanel panel = new JPanel();
		tabbedPane.addTab("Divisas", null, panel, null);
		
		btnCalcular = new JButton("Calcular");
		btnCalcular.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String montoInicial = impValorMontoInicial.getText();  //capturo el valor introducido en la etiqueta Monto inicial
				double montoACalcular = Double.parseDouble(montoInicial); //convierto el valor String de montoInicial a un Double
				
				switch (cbOpcionesMoneda.getSelectedIndex()) {
				
					case 1: //"De Colones a Dólar":
						
						double monedaDolar = montoACalcular / dolar;
						monedaDolar = (double) Math.round(monedaDolar *100d)/100;
						lblResultado.setText("Tienes $ " +monedaDolar+ " Dolares");
						break;
					
					case 2: //"De Colones a Euro":
						double monedaEuro = montoACalcular / euro;
						monedaEuro = (double) Math.round(monedaEuro *100d)/100;
						lblResultado.setText( "Tienes $ " +monedaEuro+ " Euros");
						break;
					case 3: //"De Colones a Libras":
						double monedaLibra = montoACalcular / libraEsterlina;
				        monedaLibra = (double) Math.round(monedaLibra *100d)/100;
				        lblResultado.setText( "Tienes $ " +monedaLibra+ " Libras Esterlinas");
						break;
					case 4:  //"De Colones a Yen":
						double monedaYen = montoACalcular / yenJapones;
				        monedaYen = (double) Math.round(monedaYen *100d)/100;
				        lblResultado.setText( "Tienes $ " +monedaYen+ " Yuanes");
						break;
					case 5: //"De Colones a Won Coreano":
						double monedaWon = montoACalcular / wonSulCoreano;
				        monedaWon = (double) Math.round(monedaWon *100d)/100;
				        lblResultado.setText( "Tienes $ " +monedaWon+ " Wons");
				        break; 
					case 6:  //"De Colones a Cordobas Nicaraguenses":
						double monedaCordoba1 = montoACalcular / cordobaNicaraguense;
				        monedaCordoba1 = (double) Math.round(monedaCordoba1 *100d)/100;
				        lblResultado.setText( "Tienes $ " +monedaCordoba1+ " Cordobas");
				        break;
				        
					case 7:  //"De Dólar a Colones":
						double monedaDolar2 = montoACalcular * dolar;
						monedaDolar = (double) Math.round(monedaDolar2 *100d)/100;
						lblResultado.setText( "Tienes c " +monedaDolar2+ " Colones");
						break;
					case 8:  //"De Euro a Colones":
						double monedaEuro2 = montoACalcular * euro;
						monedaEuro2 = (double) Math.round(monedaEuro2 *100d)/100;
						lblResultado.setText("Tienes c " +monedaEuro2+ " Colones");
						break;
					case 9:  //"De Libras a Colones":
						double monedaLibra2 = montoACalcular * libraEsterlina;
				        monedaLibra2 = (double) Math.round(monedaLibra2 *100d)/100;
				        lblResultado.setText( "Tienes c " +monedaLibra2+ " Colones");
						break;
					case 10:  //"De Yen a Colones":
						double monedaYen2 = montoACalcular * yenJapones;
				        monedaYen2 = (double) Math.round(monedaYen2 *100d)/100;
				        lblResultado.setText( "Tienes c " +monedaYen2+ " Colones");
						break;
					case 11:  //"De Won Coreano a Colones":
						double monedaWon2 = montoACalcular * wonSulCoreano;
				        monedaWon2 = (double) Math.round(monedaWon2 *100d)/100;
				        lblResultado.setText( "Tienes c " +monedaWon2+ " Colones");
						break;
						
					case 12: //"DE Cordoba Nicaraguense a Colones"
						double monedaCordoba2 = montoACalcular * cordobaNicaraguense;
						monedaCordoba2 = (double) Math.round(monedaCordoba2 *100d)/100;
						lblResultado.setText( "Tienes c " +monedaCordoba2+ " Colones");
						break;
	
				}	
						
			}
		});	        					
	
	
			
		
		
		
		JLabel lblConvertiaA = new JLabel("Convertir:");
		
		JLabel lblMonto = new JLabel("Monto:");
		
		impValorMontoInicial = new JTextField();
		impValorMontoInicial.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("Conversor de Monedas");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		
		lblResultado = new JLabel("Resultado");
		lblResultado.setFont(new Font("Lucida Grande", Font.PLAIN, 14));
		
		lblResultado.setHorizontalAlignment(SwingConstants.CENTER);
		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addContainerGap(78, Short.MAX_VALUE)
					.addComponent(impValorMontoInicial, GroupLayout.PREFERRED_SIZE, 141, GroupLayout.PREFERRED_SIZE)
					.addGap(84))
				.addGroup(gl_panel.createSequentialGroup()
					.addContainerGap(117, Short.MAX_VALUE)
					.addComponent(lblConvertiaA)
					.addGap(124))
				.addGroup(gl_panel.createSequentialGroup()
					.addContainerGap()
					.addComponent(lblNewLabel, GroupLayout.DEFAULT_SIZE, 291, Short.MAX_VALUE)
					.addContainerGap())
				.addGroup(gl_panel.createSequentialGroup()
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel.createSequentialGroup()
							.addContainerGap()
							.addComponent(cbOpcionesMoneda, 0, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
						.addGroup(gl_panel.createSequentialGroup()
							.addGap(126)
							.addComponent(lblMonto)))
					.addGap(12))
				.addGroup(gl_panel.createSequentialGroup()
					.addGap(38)
					.addComponent(lblResultado, GroupLayout.PREFERRED_SIZE, 220, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(45, Short.MAX_VALUE))
				.addGroup(gl_panel.createSequentialGroup()
					.addGap(100)
					.addComponent(btnCalcular)
					.addContainerGap(108, Short.MAX_VALUE))
		);
		gl_panel.setVerticalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addGap(29)
					.addComponent(lblNewLabel)
					.addGap(46)
					.addComponent(lblMonto)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(impValorMontoInicial, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(lblConvertiaA)
					.addGap(12)
					.addComponent(cbOpcionesMoneda, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addGap(28)
					.addComponent(btnCalcular)
					.addGap(18)
					.addComponent(lblResultado, GroupLayout.PREFERRED_SIZE, 55, GroupLayout.PREFERRED_SIZE)
					.addGap(24))
		);
		panel.setLayout(gl_panel);
		
		
/////////////////////////////////////////////////////////////////
////Esta parte contiene todo el codigo
////para crear e inicializar la calculadora de Temperaturas
////
////This method contains all of the code
////for creating and initializing the Temperature Calculator.
/////////////////////////////////////////////////////////////////	
		
		
		
		
		
		
		JPanel panel_1 = new JPanel();
		tabbedPane.addTab("Temperaturas", null, panel_1, null);
		
		JLabel lblTempConvertiaA = new JLabel("Convertia a:");
		
		cbTempSelection = new JComboBox();
		cbTempSelection.setModel(new DefaultComboBoxModel(new String[] {"Seleccione una opcion...", "Celcius a Farenheith", "Celcius a Kelvin", "Farenheith a Celcius", "Farenheith a Kelvin", "Kelvin a Celcius", "Kelvin a Farenheith"}));
		cbTempSelection.setSelectedIndex(0);
		

		tempInicial = new JTextField();
		tempInicial.setColumns(10);
		
		
		JButton btnCalcularTemp = new JButton("Calcular");
		
		JLabel lbltempInicial = new JLabel("Temperatura");
		
		lblTempFinal = new JLabel("Resultado aqui!!!");
		lblTempFinal.setHorizontalAlignment(SwingConstants.CENTER);
		lblTempFinal.setFont(new Font("Lucida Grande", Font.PLAIN, 14));
		GroupLayout gl_panel_1 = new GroupLayout(panel_1);
		gl_panel_1.setHorizontalGroup(
			gl_panel_1.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_panel_1.createSequentialGroup()
					.addContainerGap(104, Short.MAX_VALUE)
					.addComponent(lblTempConvertiaA)
					.addGap(124))
				.addGroup(gl_panel_1.createSequentialGroup()
					.addGap(36)
					.addComponent(lbltempInicial)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(tempInicial, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(52, Short.MAX_VALUE))
				.addGroup(gl_panel_1.createSequentialGroup()
					.addGap(99)
					.addComponent(btnCalcularTemp)
					.addContainerGap(109, Short.MAX_VALUE))
				.addGroup(gl_panel_1.createSequentialGroup()
					.addGroup(gl_panel_1.createParallelGroup(Alignment.TRAILING)
						.addGroup(gl_panel_1.createSequentialGroup()
							.addContainerGap()
							.addComponent(lblTempFinal, GroupLayout.PREFERRED_SIZE, 259, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_panel_1.createSequentialGroup()
							.addGap(25)
							.addComponent(cbTempSelection, 0, 251, Short.MAX_VALUE)))
					.addGap(27))
		);
		gl_panel_1.setVerticalGroup(
			gl_panel_1.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_1.createSequentialGroup()
					.addGap(71)
					.addGroup(gl_panel_1.createParallelGroup(Alignment.BASELINE)
						.addComponent(lbltempInicial)
						.addComponent(tempInicial, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(40)
					.addComponent(lblTempConvertiaA)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(cbTempSelection, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(btnCalcularTemp)
					.addGap(38)
					.addComponent(lblTempFinal, GroupLayout.PREFERRED_SIZE, 64, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(31, Short.MAX_VALUE))
		);
		
		
		
		
		btnCalcularTemp.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				
				String tempInicial2 = tempInicial.getText();  //capturo el valor introducido en la etiqueta Monto inicial
				double tempACalcular = Double.parseDouble(tempInicial2); //convierto el valor String de montoInicial a un Double
				
				switch (cbTempSelection.getSelectedIndex()) {
				
					case 1: //"De Celcius a Farenheith":
						
						double celciusToFarenheith = (tempACalcular * 9/5) + 32;
						celciusToFarenheith = (double) Math.round(celciusToFarenheith *100d)/100;
						lblTempFinal.setText("Corresponde a: " +celciusToFarenheith+ " Farenheith");
						break;
					
					case 2: //"De Celcius a Kelvin":
						double celciusToKelvin = tempACalcular + 273.15;
						celciusToKelvin = (double) Math.round(celciusToKelvin *100d)/100;
						lblTempFinal.setText( "Corresponde a: " +celciusToKelvin+ " Kelvin");
						break;
					case 3: //"Farenheith a Celcius":
						double farenheithToCelcius = (tempACalcular - 32) * 5/9;
						farenheithToCelcius = (double) Math.round(farenheithToCelcius *100d)/100;
						lblTempFinal.setText( "Corresponde a: " +farenheithToCelcius+ " Celcius");
						break;
					case 4: //"Farenheith a Kelvin":
						double farenheithToKelvin = (tempACalcular - 32) * 5/9 + 273.15;
						farenheithToKelvin = (double) Math.round(farenheithToKelvin *100d)/100;
						lblTempFinal.setText( "Corresponde a: " +farenheithToKelvin+ " Kelvin");
						break;
						
					case 5: //"De Kelvin Celcius":
						double kelvinToCelcius = tempACalcular - 273.15;
						kelvinToCelcius = (double) Math.round(kelvinToCelcius *100d)/100;
						lblTempFinal.setText( "Corresponde a: " +kelvinToCelcius+ " Celcius");
						break;	
					case 6: //"De Kelvin Celcius":
						double kelvinToFarenheith = (tempACalcular - 273.15) * (9/5) + 32;
						kelvinToFarenheith = (double) Math.round(kelvinToFarenheith *100d)/100;
						lblTempFinal.setText( "Corresponde a: " +kelvinToFarenheith+ " Celcius");
						break;		
			
	
				}	
				
				
			}
		});
		
		
/////////////////////////////////////////////////////////////////
//// Esta parte contiene todo el codigo
//// para crear e inicializar la calculadora
////
//// This method contains all of the code
//// for creating and initializing components.
/////////////////////////////////////////////////////////////////
		
		
		
		panel_1.setLayout(gl_panel_1);
		
		JPanel panel_2 = new JPanel();
		tabbedPane.addTab("Calculadora", null, panel_2, null);
		
	
		displayGrandeCalc = new JLabel(  );
		displayGrandeCalc.setFont(new Font("Lucida Grande", Font.PLAIN, 36));
		displayGrandeCalc.setText("0");
		displayGrandeCalc.setForeground(new Color(116, 75, 43));
		displayGrandeCalc.setHorizontalAlignment(SwingConstants.RIGHT);
		displayGrandeCalc.setBackground(new Color(121, 116, 89));
	
		btnCalcPosONeg = new JButton("+/-");
		btnCalcPosONeg.setFont(new Font("Lucida Grande", Font.BOLD, 12));
		btnCalcPosONeg.addActionListener(new ActionListener() {
		
			public void actionPerformed(ActionEvent e) {
				String negativo = cadenaNumeros.substring(0,1);
				
				if( negativo != "-") {
					cadenaNumeros = "-" + cadenaNumeros;
					} else {
						cadenaNumeros = cadenaNumeros.substring(1 , cadenaNumeros.length());
						
					}
					displayGrandeCalc.setText(cadenaNumeros);	 
				}
		});
		
	
		JButton btnCalcCero = new JButton("0");
		btnCalcCero.setBackground(new Color(143, 143, 129));
		btnCalcCero.setFont(new Font("Lucida Grande", Font.BOLD, 14));
		btnCalcCero.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (displayGrandeCalc.getText().equals("0")) {
					cadenaNumeros="0";
				}else {
					cadenaNumeros += "0";
				}
				displayGrandeCalc.setText(cadenaNumeros);
				activado = true;
				
			}
		});
		
		
		JButton btnCalc1 = new JButton("1");
		btnCalc1.setBackground(new Color(143, 143, 129));
		btnCalc1.setFont(new Font("Lucida Grande", Font.BOLD, 14));
		btnCalc1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (displayGrandeCalc.getText().equals("0")) {
					cadenaNumeros="1";
				}else {
					cadenaNumeros += "1";
				}
				displayGrandeCalc.setText(cadenaNumeros);
				activado = true;
				
			}
		});
		
		
		JButton btnCalc2 = new JButton("2");
		btnCalc2.setBackground(new Color(143, 143, 129));
		btnCalc2.setFont(new Font("Lucida Grande", Font.BOLD, 14));
		btnCalc2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (displayGrandeCalc.getText().equals("0")) {
					cadenaNumeros="2";
				}else {
					cadenaNumeros += "2";
				}
				displayGrandeCalc.setText(cadenaNumeros);
				activado = true;
				
			}
		});
		
		
		JButton btnCalc3 = new JButton("3");
		btnCalc3.setBackground(new Color(143, 143, 129));
		btnCalc3.setFont(new Font("Lucida Grande", Font.BOLD, 14));
		btnCalc3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (displayGrandeCalc.getText().equals("0")) {
					cadenaNumeros="3";
				}else {
					cadenaNumeros += "3";
				}
				displayGrandeCalc.setText(cadenaNumeros);
				activado = true;
				
			}
		});
				
		
		JButton btnCalc4 = new JButton("4");
		btnCalc4.setBackground(new Color(143, 143, 129));
		btnCalc4.setFont(new Font("Lucida Grande", Font.BOLD, 14));
		btnCalc4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (displayGrandeCalc.getText().equals("0")) {
					cadenaNumeros="4";
				}else {
					cadenaNumeros += "4";
				}
				displayGrandeCalc.setText(cadenaNumeros);
				activado = true;
			
			}
		});
		
		
		JButton btnCalc5 = new JButton("5");
		btnCalc5.setBackground(new Color(143, 143, 129));
		btnCalc5.setFont(new Font("Lucida Grande", Font.BOLD, 14));
		btnCalc5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (displayGrandeCalc.getText().equals("0")) {
					cadenaNumeros="5";
				}else {
					cadenaNumeros += "5";
				}
				displayGrandeCalc.setText(cadenaNumeros);
				activado = true;
				
			}
		});
		
		
		JButton btnCalc6 = new JButton("6");
		btnCalc6.setBackground(new Color(143, 143, 129));
		btnCalc6.setFont(new Font("Lucida Grande", Font.BOLD, 14));
		btnCalc6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			
				if (displayGrandeCalc.getText().equals("0")) {
					cadenaNumeros="6";
				}else {
					cadenaNumeros += "6";
				}
				displayGrandeCalc.setText(cadenaNumeros);
				activado = true;
				
				}
		});
		
		
		JButton btnCalc7 = new JButton("7");
		btnCalc7.setBackground(new Color(143, 143, 129));
		btnCalc7.setFont(new Font("Lucida Grande", Font.BOLD, 14));
		btnCalc7.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (displayGrandeCalc.getText().equals("0")) {
					cadenaNumeros="7";
				}else {
					cadenaNumeros += "7";
				}
				displayGrandeCalc.setText(cadenaNumeros);
				activado = true;
				
			}
		});
		
		
		JButton btnCalc8 = new JButton("8");
		btnCalc8.setBackground(new Color(143, 143, 129));
		btnCalc8.setFont(new Font("Lucida Grande", Font.BOLD, 14));
		btnCalc8.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (displayGrandeCalc.getText().equals("0")) {
					cadenaNumeros="8";
				}else {
					cadenaNumeros += "8";
				}
				displayGrandeCalc.setText(cadenaNumeros);
				activado = true;
			
			}
		});
		
		
		JButton btnCalc9 = new JButton("9");
		btnCalc9.setBackground(new Color(143, 143, 129));
		btnCalc9.setFont(new Font("Lucida Grande", Font.BOLD, 14));
		btnCalc9.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (displayGrandeCalc.getText().equals("0")) {
					cadenaNumeros="9";
				}else {
					cadenaNumeros += "9";
				}
				displayGrandeCalc.setText(cadenaNumeros);
				activado = true;
				
			}
		});
		
		
		JButton btnCalcPunto = new JButton(".");
		btnCalcPunto.setFont(new Font("Lucida Grande", Font.BOLD, 14));
		btnCalcPunto.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			
			if(punto == true) {
				if(cadenaNumeros.equals("")) {
					cadenaNumeros = "0.";
				}else {
					cadenaNumeros += ".";
				}
				
			}
			punto = false;
			
			}
		});
		
		
		JButton btnCalcMult = new JButton("X");
		btnCalcMult.setFont(new Font("Lucida Grande", Font.BOLD, 15));
		btnCalcMult.setBackground(new Color(114, 109, 84));
		btnCalcMult.setForeground(new Color(0, 0, 0));
		btnCalcMult.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(activado=true) {
					primerNumero = Double.parseDouble(cadenaNumeros);
					displayPeqCalc.setText(cadenaNumeros + " X ");
					cadenaNumeros = "";
					operacion = "multiplicar";
					activado = false;
					
			
					}	
				}
			});
		
		
		JButton btnCalcDiv = new JButton("/");
		btnCalcDiv.setFont(new Font("Lucida Grande", Font.BOLD, 15));
		btnCalcDiv.setBackground(new Color(114, 109, 84));
		btnCalcDiv.setForeground(new Color(0, 0, 0));
		btnCalcDiv.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				if(activado=true) {
					primerNumero = Double.parseDouble(cadenaNumeros);
					displayPeqCalc.setText(cadenaNumeros + " / ");
					cadenaNumeros = "";
					operacion = "dividir";
					activado = false;
					
					}
				}
			});
		
		
		JButton btnCalcRest = new JButton("-");
		btnCalcRest.setFont(new Font("Lucida Grande", Font.BOLD, 15));
		btnCalcRest.setBackground(new Color(114, 109, 84));
		btnCalcRest.setForeground(new Color(0, 0, 0));
		btnCalcRest.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(activado=true) {
					primerNumero = Double.parseDouble(cadenaNumeros);
					displayPeqCalc.setText(cadenaNumeros + " - ");
					cadenaNumeros = "";
					operacion = "restar";
					activado = false;
					
			
					}
				}
			});
		
		
		JButton btnCalcSuma = new JButton("+");
		btnCalcSuma.setFont(new Font("Lucida Grande", Font.BOLD, 15));
		btnCalcSuma.setBackground(new Color(114, 109, 84));
		btnCalcSuma.setForeground(new Color(0, 0, 0));
		btnCalcSuma.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				if(activado == true) {
					primerNumero = Double.parseDouble(cadenaNumeros);
					displayPeqCalc.setText(cadenaNumeros + " + ");
					cadenaNumeros = "";
					operacion = "sumar";
					activado = false;
					
				}
			}
		});
		
		
		JButton btnCalcIgual = new JButton("=");
		btnCalcIgual.setFont(new Font("Lucida Grande", Font.BOLD, 15));
		btnCalcIgual.setBackground(new Color(114, 109, 84));
		btnCalcIgual.setForeground(new Color(0, 0, 0));
		btnCalcIgual.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				double segundoNumero;
				
				if(operacion.equals("nula")) {
					displayGrandeCalc.setText(cadenaNumeros);
				}
				
				else if(operacion.equals("sumar")) {
				segundoNumero = Double.parseDouble(cadenaNumeros);
				resultado = primerNumero + segundoNumero;
				displayGrandeCalc.setText(String.format("% .2f", resultado));
				cadenaNumeros = String.valueOf(resultado);
				operacion = "nula";
				
				}
				
				else if(operacion.equals("restar")) {
					segundoNumero = Double.parseDouble(cadenaNumeros);
					resultado = primerNumero - segundoNumero;
					displayGrandeCalc.setText(String.format("% .2f", resultado));
					cadenaNumeros = String.valueOf(resultado);
					operacion = "nula";
					
				}
				else if(operacion.equals("dividir")) {
					segundoNumero = Double.parseDouble(cadenaNumeros);
					if (segundoNumero == 0) {
						displayGrandeCalc.setText("Error: div/cero");
					}else {
						resultado = primerNumero / segundoNumero;
						displayGrandeCalc.setText(String.format("% .2f", resultado));
						cadenaNumeros = String.valueOf(resultado);
						operacion = "nula";
								
					}
					
				}
				else if(operacion.equals("multiplicar")) {
					segundoNumero = Double.parseDouble(cadenaNumeros);
					resultado = primerNumero * segundoNumero;
					displayGrandeCalc.setText(String.format("% .2f", resultado));
					cadenaNumeros = String.valueOf(resultado);
					operacion = "nula";
					
				}
				displayPeqCalc.setText("");
				activado = true;
			
			
			}
		});
		
		
		
		JButton btnCalcC = new JButton("C");
		btnCalcC.setFont(new Font("Lucida Grande", Font.BOLD, 15));
		btnCalcC.setBackground(new Color(114, 109, 84));
		btnCalcC.setForeground(new Color(0, 0, 0));
		btnCalcC.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			
			displayPeqCalc.setText("");
			displayGrandeCalc.setText("0");
			operacion = "nula";
			cadenaNumeros = ""; 
			activado = true;
			punto = true;
			}
			
			
		});
				
		JButton btnCalcDel = new JButton("CE");
		btnCalcDel.setFont(new Font("Lucida Grande", Font.BOLD, 15));
		btnCalcDel.setBackground(new Color(114, 109, 84));
		btnCalcDel.setForeground(new Color(0, 0, 0));
		btnCalcDel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				int tamano = cadenaNumeros.length();
				if(tamano > 0) { 
					if(tamano ==1) {
						cadenaNumeros = "0";
					}else {
						cadenaNumeros = cadenaNumeros.substring(0,cadenaNumeros.length() - 1);
				}
				displayGrandeCalc.setText(cadenaNumeros);	
			}
		  }
		});
		
		
		
		
		
		displayPeqCalc = new JLabel("");
		displayPeqCalc.setForeground(new Color(156, 100, 59));
		displayPeqCalc.setBackground(new Color(121, 116, 89));
		displayPeqCalc.setHorizontalAlignment(SwingConstants.RIGHT);
		GroupLayout gl_panel_2 = new GroupLayout(panel_2);
		gl_panel_2.setHorizontalGroup(
			gl_panel_2.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_2.createSequentialGroup()
					.addContainerGap()
					.addComponent(displayPeqCalc, GroupLayout.PREFERRED_SIZE, 291, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
				.addGroup(Alignment.TRAILING, gl_panel_2.createSequentialGroup()
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
					.addComponent(displayGrandeCalc, GroupLayout.PREFERRED_SIZE, 291, GroupLayout.PREFERRED_SIZE)
					.addContainerGap())
				.addGroup(gl_panel_2.createSequentialGroup()
					.addGap(32)
					.addGroup(gl_panel_2.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel_2.createSequentialGroup()
							.addComponent(btnCalcC, GroupLayout.PREFERRED_SIZE, 50, GroupLayout.PREFERRED_SIZE)
							.addGap(14)
							.addComponent(btnCalcDiv, GroupLayout.PREFERRED_SIZE, 50, GroupLayout.PREFERRED_SIZE)
							.addGap(12)
							.addComponent(btnCalcMult, GroupLayout.PREFERRED_SIZE, 50, GroupLayout.PREFERRED_SIZE)
							.addGap(12)
							.addComponent(btnCalcDel, GroupLayout.PREFERRED_SIZE, 50, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_panel_2.createSequentialGroup()
							.addComponent(btnCalc7, GroupLayout.PREFERRED_SIZE, 50, GroupLayout.PREFERRED_SIZE)
							.addGap(14)
							.addComponent(btnCalc8, GroupLayout.PREFERRED_SIZE, 50, GroupLayout.PREFERRED_SIZE)
							.addGap(12)
							.addComponent(btnCalc9, GroupLayout.PREFERRED_SIZE, 50, GroupLayout.PREFERRED_SIZE)
							.addGap(12)
							.addComponent(btnCalcRest, GroupLayout.PREFERRED_SIZE, 50, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_panel_2.createSequentialGroup()
							.addComponent(btnCalc4, GroupLayout.PREFERRED_SIZE, 50, GroupLayout.PREFERRED_SIZE)
							.addGap(14)
							.addComponent(btnCalc5, GroupLayout.PREFERRED_SIZE, 50, GroupLayout.PREFERRED_SIZE)
							.addGap(12)
							.addComponent(btnCalc6, GroupLayout.PREFERRED_SIZE, 50, GroupLayout.PREFERRED_SIZE)
							.addGap(12)
							.addComponent(btnCalcSuma, GroupLayout.PREFERRED_SIZE, 50, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_panel_2.createSequentialGroup()
							.addGroup(gl_panel_2.createParallelGroup(Alignment.LEADING)
								.addComponent(btnCalc1, GroupLayout.PREFERRED_SIZE, 50, GroupLayout.PREFERRED_SIZE)
								.addComponent(btnCalcPosONeg, GroupLayout.PREFERRED_SIZE, 50, GroupLayout.PREFERRED_SIZE))
							.addGap(14)
							.addGroup(gl_panel_2.createParallelGroup(Alignment.LEADING)
								.addComponent(btnCalc2, GroupLayout.PREFERRED_SIZE, 50, GroupLayout.PREFERRED_SIZE)
								.addComponent(btnCalcCero, GroupLayout.PREFERRED_SIZE, 50, GroupLayout.PREFERRED_SIZE))
							.addGap(12)
							.addGroup(gl_panel_2.createParallelGroup(Alignment.LEADING)
								.addComponent(btnCalc3, GroupLayout.PREFERRED_SIZE, 50, GroupLayout.PREFERRED_SIZE)
								.addComponent(btnCalcPunto, GroupLayout.PREFERRED_SIZE, 50, GroupLayout.PREFERRED_SIZE))
							.addGap(12)
							.addComponent(btnCalcIgual, GroupLayout.PREFERRED_SIZE, 50, GroupLayout.PREFERRED_SIZE)))
					.addContainerGap(33, Short.MAX_VALUE))
		);
		gl_panel_2.setVerticalGroup(
			gl_panel_2.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_2.createSequentialGroup()
					.addGap(20)
					.addComponent(displayPeqCalc, GroupLayout.PREFERRED_SIZE, 26, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(displayGrandeCalc, GroupLayout.PREFERRED_SIZE, 50, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_panel_2.createParallelGroup(Alignment.LEADING)
						.addComponent(btnCalcC, GroupLayout.PREFERRED_SIZE, 43, GroupLayout.PREFERRED_SIZE)
						.addComponent(btnCalcDiv, GroupLayout.PREFERRED_SIZE, 43, GroupLayout.PREFERRED_SIZE)
						.addComponent(btnCalcMult, GroupLayout.PREFERRED_SIZE, 43, GroupLayout.PREFERRED_SIZE)
						.addComponent(btnCalcDel, GroupLayout.PREFERRED_SIZE, 43, GroupLayout.PREFERRED_SIZE))
					.addGap(6)
					.addGroup(gl_panel_2.createParallelGroup(Alignment.LEADING)
						.addComponent(btnCalc7, GroupLayout.PREFERRED_SIZE, 43, GroupLayout.PREFERRED_SIZE)
						.addComponent(btnCalc8, GroupLayout.PREFERRED_SIZE, 43, GroupLayout.PREFERRED_SIZE)
						.addComponent(btnCalc9, GroupLayout.PREFERRED_SIZE, 43, GroupLayout.PREFERRED_SIZE)
						.addComponent(btnCalcRest, GroupLayout.PREFERRED_SIZE, 43, GroupLayout.PREFERRED_SIZE))
					.addGap(6)
					.addGroup(gl_panel_2.createParallelGroup(Alignment.LEADING)
						.addComponent(btnCalc4, GroupLayout.PREFERRED_SIZE, 43, GroupLayout.PREFERRED_SIZE)
						.addComponent(btnCalc5, GroupLayout.PREFERRED_SIZE, 43, GroupLayout.PREFERRED_SIZE)
						.addComponent(btnCalc6, GroupLayout.PREFERRED_SIZE, 43, GroupLayout.PREFERRED_SIZE)
						.addComponent(btnCalcSuma, GroupLayout.PREFERRED_SIZE, 43, GroupLayout.PREFERRED_SIZE))
					.addGap(6)
					.addGroup(gl_panel_2.createParallelGroup(Alignment.LEADING, false)
						.addGroup(gl_panel_2.createSequentialGroup()
							.addComponent(btnCalc1, GroupLayout.PREFERRED_SIZE, 43, GroupLayout.PREFERRED_SIZE)
							.addGap(6)
							.addComponent(btnCalcPosONeg, GroupLayout.PREFERRED_SIZE, 43, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_panel_2.createSequentialGroup()
							.addComponent(btnCalc2, GroupLayout.PREFERRED_SIZE, 43, GroupLayout.PREFERRED_SIZE)
							.addGap(6)
							.addComponent(btnCalcCero, GroupLayout.PREFERRED_SIZE, 43, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_panel_2.createSequentialGroup()
							.addComponent(btnCalc3, GroupLayout.PREFERRED_SIZE, 43, GroupLayout.PREFERRED_SIZE)
							.addGap(6)
							.addComponent(btnCalcPunto, GroupLayout.PREFERRED_SIZE, 43, GroupLayout.PREFERRED_SIZE))
						.addComponent(btnCalcIgual, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
					.addGap(23))
		);
		panel_2.setLayout(gl_panel_2);
		
		JButton btnExit = new JButton("Salir / Exit");
		btnExit.setForeground(new Color(0, 0, 0));
		btnExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
				
			}
		});
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(175)
							.addComponent(list, GroupLayout.PREFERRED_SIZE, 1, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(1)
							.addComponent(tabbedPane, GroupLayout.PREFERRED_SIZE, 324, GroupLayout.PREFERRED_SIZE))
						.addComponent(btnExit, Alignment.TRAILING))
					.addContainerGap())
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(55)
							.addComponent(list, GroupLayout.PREFERRED_SIZE, 1, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(1)
							.addComponent(tabbedPane, GroupLayout.PREFERRED_SIZE, 400, GroupLayout.PREFERRED_SIZE)))
					.addPreferredGap(ComponentPlacement.RELATED, 10, Short.MAX_VALUE)
					.addComponent(btnExit)
					.addContainerGap())
		);
		contentPane.setLayout(gl_contentPane);
		
		
	}

	/////////////////////////////////////////////////////////////////
	//// Este metodo contiene todo el codigo
	//// para crear eventos
	////
	//// This method contains all of the code
	//// for creating events.
	/////////////////////////////////////////////////////////////////

	private void createEvents() {
	}
}
