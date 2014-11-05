package com.isel.adeetc.leic.si.serie1.ex7;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import javax.swing.JTextArea;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.DefaultComboBoxModel;

import com.isel.adeetc.leic.si.serie1.ex7.actions.ExitAction;
import com.isel.adeetc.leic.si.serie1.ex7.model.SignAlgorithmEnum;
import com.isel.adeetc.leic.si.serie1.ex7.model.KeyAlgorithmEnum;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class JWKDigitalSignature extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					JWKDigitalSignature frame = new JWKDigitalSignature();
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
	public JWKDigitalSignature() {
		setResizable(false);
		setTitle("JWK Signer");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 349);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnExit = new JButton("Exit");
		btnExit.addActionListener(new ExitAction());
		btnExit.setBounds(373, 280, 51, 23);
		contentPane.add(btnExit);
		
		JButton btnSign = new JButton("Sign");
		btnSign.setBounds(43, 187, 89, 23);
		contentPane.add(btnSign);
		
		JButton btnValidate = new JButton("Validate");
		btnValidate.setBounds(185, 187, 89, 23);
		contentPane.add(btnValidate);
		
		JTextArea txtrMessage = new JTextArea();
		txtrMessage.setText("Message");
		txtrMessage.setBounds(10, 11, 298, 77);
		contentPane.add(txtrMessage);
		
		JTextArea txtrKey = new JTextArea();
		txtrKey.setText("Key");
		txtrKey.setBounds(10, 99, 298, 77);
		contentPane.add(txtrKey);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setModel(new DefaultComboBoxModel(SignAlgorithmEnum.values()));
		comboBox.setBounds(335, 41, 89, 20);
		contentPane.add(comboBox);
		
		JComboBox comboBox_1 = new JComboBox();
		comboBox_1.setModel(new DefaultComboBoxModel(KeyAlgorithmEnum.values()));
		comboBox_1.setBounds(335, 132, 89, 20);
		contentPane.add(comboBox_1);
		
		JLabel lblSignAlgorithm = new JLabel("Sign Algorithm");
		lblSignAlgorithm.setBounds(353, 16, 71, 14);
		contentPane.add(lblSignAlgorithm);
		
		JLabel lblKeyAlgorithm = new JLabel("Key Algorithm");
		lblKeyAlgorithm.setBounds(353, 102, 71, 19);
		contentPane.add(lblKeyAlgorithm);
		
		JTextArea txtrResult = new JTextArea();
		txtrResult.setText("Result");
		txtrResult.setBounds(0, 232, 298, 77);
		contentPane.add(txtrResult);
	}
}
