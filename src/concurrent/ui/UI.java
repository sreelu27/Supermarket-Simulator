package concurrent.ui;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import java.awt.Font;
import javax.swing.JPanel;

public class UI {

	private JFrame frame;
	private JTextField textField;
	private JTextField textField_1;
	
	

	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;
	private JTextField textField_6;
	private JTextField textField_7;
	private JTextField textField_8;
	private JTextField textField_9;
	private JTextField textField_10;
	private JTextField textField_11;
	private JTextField textField_12;
	private JTextField textField_13;
	private JTextField textField_14;
	private JTextField textField_15;
	private JTextField textField_16;
	private JTextField textField_17;
	private JTextField textField_18;
	private JTextField textField_19;
	private JTextField textField_20;
	private JTextField textField_21;
	private JTextField textField_22;
	private JTextField textField_23;
	private JTextField textField_24;
	private JLabel lblCustomers;
	private JLabel lblWaitingTime;
	private JLabel lblProducts;
	private JLabel lblTotalCustomersProcesses;
	private JTextField textField_25;
	private JLabel lblTotalProductsProcessed;
	private JTextField textField_26;
	private JTextField textField_27;
	private JLabel lblAvgUtilization;
	private JTextField textField_28;
	private JTextField textField_29;
	private JTextField textField_30;
	private JTextField textField_31;
	private JTextField textField_32;
	private JTextField textField_33;
	private JTextField textField_34;

	public UI() {
		initialize();
		frame.setVisible(true);
	}
  
	public JTextField getTextField() {
		return textField;
	}

	public JTextField getTextField_1() {
		return textField_1;
	}

	public JTextField getTextField_2() {
		return textField_2;
	}

	public JTextField getTextField_3() {
		return textField_3;
	}

	public JTextField getTextField_4() {
		return textField_4;
	}

	public JTextField getTextField_5() {
		return textField_5;
	}

	public JTextField getTextField_6() {
		return textField_6;
	}

	public JTextField getTextField_7() {
		return textField_7;
	}
	public JTextField getTextField_8() {
		return textField_8;
	}

	public JTextField getTextField_9() {
		return textField_9;
	}
	
	public JTextField getTextField_10() {
		return textField_10;
	}

	public JTextField getTextField_11() {
		return textField_11;
	}

	public JTextField getTextField_12() {
		return textField_12;
	}

	public JTextField getTextField_13() {
		return textField_13;
	}

	public JTextField getTextField_14() {
		return textField_14;
	}

	public JTextField getTextField_15() {
		return textField_15;
	}
	public JTextField getTextField_16() {
		return textField_16;
	}
	public JTextField getTextField_17() {
		return textField_17;
	}

	public JTextField getTextField_18() {
		return textField_18;
	}

	public JTextField getTextField_19() {
		return textField_19;
	}

	public JTextField getTextField_20() {
		return textField_20;
	}

	public JTextField getTextField_21() {
		return textField_21;
	}

	public JTextField getTextField_28() {
		return textField_28;
	}

	public JTextField getTextField_29() {
		return textField_29;
	}

	public JTextField getTextField_30() {
		return textField_30;
	}

	public JTextField getTextField_31() {
		return textField_31;
	}

	public JTextField getTextField_32() {
		return textField_32;
	}

	public JTextField getTextField_33() {
		return textField_33;
	}

	public JTextField getTextField_34() {
		return textField_34;
	}

	public JTextField getTextField_22() {
		return textField_22;
	}

	public JTextField getTextField_23() {
		return textField_23;
	}

	public JTextField getTextField_24() {
		return textField_24;
	}
	
	public JTextField getTextField_25() {
		return textField_25;
	}
	
	public JTextField getTextField_26() {
		return textField_26;
	}
	
	public JTextField getTextField_27() {
		return textField_27;
	}
	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 958, 524);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel Counter1 = new JLabel("Express Counter");
		Counter1.setBounds(9, 64, 103, 13);
		frame.getContentPane().add(Counter1);
		
		textField = new JTextField();
		textField.setBounds(122, 61, 47, 19);
		frame.getContentPane().add(textField);
		textField.setColumns(10);
		
		JLabel Counter2 = new JLabel("Checkout 1");
		Counter2.setBounds(30, 119, 73, 13);
		frame.getContentPane().add(Counter2);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(122, 116, 47, 19);
		frame.getContentPane().add(textField_1);
		
		JLabel Counter3 = new JLabel("Checkout 2");
		Counter3.setBounds(30, 173, 73, 13);
		frame.getContentPane().add(Counter3);
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(122, 170, 47, 19);
		frame.getContentPane().add(textField_2);
		
		textField_3 = new JTextField();
		textField_3.setColumns(10);
		textField_3.setBounds(122, 226, 47, 19);
		frame.getContentPane().add(textField_3);
		
		textField_4 = new JTextField();
		textField_4.setColumns(10);
		textField_4.setBounds(122, 279, 47, 19);
		frame.getContentPane().add(textField_4);
		
		textField_5 = new JTextField();
		textField_5.setColumns(10);
		textField_5.setBounds(122, 329, 47, 19);
		frame.getContentPane().add(textField_5);
		
		textField_6 = new JTextField();
		textField_6.setColumns(10);
		textField_6.setBounds(122, 381, 47, 19);
		frame.getContentPane().add(textField_6);
		
		textField_7 = new JTextField();
		textField_7.setColumns(10);
		textField_7.setBounds(122, 427, 47, 19);
		frame.getContentPane().add(textField_7);
		
		JLabel Counter4 = new JLabel("Checkout 3");
		Counter4.setBounds(30, 229, 73, 13);
		frame.getContentPane().add(Counter4);
		
		JLabel Counter5 = new JLabel("Checkout 4");
		Counter5.setBounds(30, 282, 73, 13);
		frame.getContentPane().add(Counter5);
		
		JLabel Counter6 = new JLabel("Checkout 5");
		Counter6.setBounds(30, 332, 73, 13);
		frame.getContentPane().add(Counter6);
		
		JLabel Counter7 = new JLabel("Checkout 6");
		Counter7.setBounds(30, 384, 73, 13);
		frame.getContentPane().add(Counter7);
		
		JLabel Counter8 = new JLabel("Checkout 7");
		Counter8.setBounds(30, 430, 73, 13);
		frame.getContentPane().add(Counter8);
		
		textField_8 = new JTextField();
		textField_8.setColumns(10);
		textField_8.setBounds(189, 116, 173, 19);
		frame.getContentPane().add(textField_8);
		
		textField_9 = new JTextField();
		textField_9.setColumns(10);
		textField_9.setBounds(189, 61, 173, 19);
		frame.getContentPane().add(textField_9);
		
		textField_10 = new JTextField();
		textField_10.setColumns(10);
		textField_10.setBounds(189, 170, 173, 19);
		frame.getContentPane().add(textField_10);
		
		textField_11 = new JTextField();
		textField_11.setColumns(10);
		textField_11.setBounds(189, 226, 173, 19);
		frame.getContentPane().add(textField_11);
		
		textField_12 = new JTextField();
		textField_12.setColumns(10);
		textField_12.setBounds(189, 279, 173, 19);
		frame.getContentPane().add(textField_12);
		
		textField_13 = new JTextField();
		textField_13.setColumns(10);
		textField_13.setBounds(189, 329, 173, 19);
		frame.getContentPane().add(textField_13);
		
		textField_14 = new JTextField();
		textField_14.setColumns(10);
		textField_14.setBounds(189, 381, 173, 19);
		frame.getContentPane().add(textField_14);
		
		textField_15 = new JTextField();
		textField_15.setColumns(10);
		textField_15.setBounds(189, 427, 173, 19);
		frame.getContentPane().add(textField_15);
		
		JLabel lblTotalCustomers = new JLabel("Total customers");
		lblTotalCustomers.setFont(new Font("Tahoma", Font.BOLD, 10));
		lblTotalCustomers.setBounds(617, 64, 103, 13);
		frame.getContentPane().add(lblTotalCustomers);
		
		textField_16 = new JTextField();
		textField_16.setColumns(10);
		textField_16.setBounds(800, 61, 89, 19);
		frame.getContentPane().add(textField_16);
		
		textField_17 = new JTextField();
		textField_17.setColumns(10);
		textField_17.setBounds(382, 61, 53, 19);
		frame.getContentPane().add(textField_17);
		
		textField_18 = new JTextField();
		textField_18.setColumns(10);
		textField_18.setBounds(382, 116, 53, 19);
		frame.getContentPane().add(textField_18);
		
		textField_19 = new JTextField();
		textField_19.setColumns(10);
		textField_19.setBounds(382, 170, 53, 19);
		frame.getContentPane().add(textField_19);
		
		textField_20 = new JTextField();
		textField_20.setColumns(10);
		textField_20.setBounds(382, 226, 53, 19);
		frame.getContentPane().add(textField_20);
		
		textField_21 = new JTextField();
		textField_21.setColumns(10);
		textField_21.setBounds(382, 279, 53, 19);
		frame.getContentPane().add(textField_21);
		
		textField_22 = new JTextField();
		textField_22.setColumns(10);
		textField_22.setBounds(382, 329, 53, 19);
		frame.getContentPane().add(textField_22);
		
		textField_23 = new JTextField();
		textField_23.setColumns(10);
		textField_23.setBounds(382, 381, 53, 19);
		frame.getContentPane().add(textField_23);
		
		textField_24 = new JTextField();
		textField_24.setColumns(10);
		textField_24.setBounds(382, 427, 53, 19);
		frame.getContentPane().add(textField_24);
		
		lblCustomers = new JLabel("Customer count");
		lblCustomers.setBounds(87, 38, 109, 13);
		frame.getContentPane().add(lblCustomers);
		
		lblWaitingTime = new JLabel("Waiting Time");
		lblWaitingTime.setBounds(234, 38, 80, 13);
		frame.getContentPane().add(lblWaitingTime);
		
		lblProducts = new JLabel("Product count");
		lblProducts.setBounds(376, 38, 80, 13);
		frame.getContentPane().add(lblProducts);
		
		lblTotalCustomersProcesses = new JLabel("Total customers processed");
		lblTotalCustomersProcesses.setFont(new Font("Tahoma", Font.BOLD, 10));
		lblTotalCustomersProcesses.setBounds(617, 106, 173, 13);
		frame.getContentPane().add(lblTotalCustomersProcesses);
		
		textField_25 = new JTextField();
		textField_25.setColumns(10);
		textField_25.setBounds(800, 103, 89, 19);
		frame.getContentPane().add(textField_25);
		
		lblTotalProductsProcessed = new JLabel("Total products processed");
		lblTotalProductsProcessed.setFont(new Font("Tahoma", Font.BOLD, 10));
		lblTotalProductsProcessed.setBounds(617, 140, 173, 13);
		frame.getContentPane().add(lblTotalProductsProcessed);
		
		textField_26 = new JTextField();
		textField_26.setColumns(10);
		textField_26.setBounds(800, 140, 89, 19);
		frame.getContentPane().add(textField_26);
		
		textField_27 = new JTextField();
		textField_27.setColumns(10);
		textField_27.setBounds(466, 61, 73, 19);
		frame.getContentPane().add(textField_27);
		
		lblAvgUtilization = new JLabel("Avg utilization");
		lblAvgUtilization.setBounds(466, 38, 80, 13);
		frame.getContentPane().add(lblAvgUtilization);
		
		textField_28 = new JTextField();
		textField_28.setColumns(10);
		textField_28.setBounds(466, 116, 73, 19);
		frame.getContentPane().add(textField_28);
		
		textField_29 = new JTextField();
		textField_29.setColumns(10);
		textField_29.setBounds(466, 170, 73, 19);
		frame.getContentPane().add(textField_29);
		
		textField_30 = new JTextField();
		textField_30.setColumns(10);
		textField_30.setBounds(466, 226, 73, 19);
		frame.getContentPane().add(textField_30);
		
		textField_31 = new JTextField();
		textField_31.setColumns(10);
		textField_31.setBounds(466, 279, 73, 19);
		frame.getContentPane().add(textField_31);
		
		textField_32 = new JTextField();
		textField_32.setColumns(10);
		textField_32.setBounds(466, 329, 73, 19);
		frame.getContentPane().add(textField_32);
		
		textField_33 = new JTextField();
		textField_33.setColumns(10);
		textField_33.setBounds(466, 381, 73, 19);
		frame.getContentPane().add(textField_33);
		
		textField_34 = new JTextField();
		textField_34.setColumns(10);
		textField_34.setBounds(466, 427, 73, 19);
		frame.getContentPane().add(textField_34);
		
		JLabel lblNewLabel = new JLabel("New label");
		
	}

	
}