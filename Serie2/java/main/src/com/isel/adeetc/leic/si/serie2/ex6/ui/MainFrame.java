package com.isel.adeetc.leic.si.serie2.ex6.ui;

import java.awt.EventQueue;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.isel.adeetc.leic.si.serie2.ex6.ui.action.ExitAction;
import com.isel.adeetc.leic.si.serie2.ex6.ui.action.OpenSubMenuAction;

public class MainFrame extends JFrame {

	private static final long serialVersionUID = -7926919317155178305L;
	private JPanel contentPane;
	private SettingsFrame settings = new SettingsFrame(this);
	private ConnectFrame connect = new ConnectFrame(this);
	private ImportFrame importf = new ImportFrame(this);
	private ExportFrame export = new ExportFrame(this);

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainFrame frame = new MainFrame();
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
	public MainFrame() {
		setTitle("Github - GTasks");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 299, 311);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnExit = new JButton("Exit");
		btnExit.addActionListener(new ExitAction());
		btnExit.setBounds(181, 242, 89, 23);
		contentPane.add(btnExit);
		
		JButton btnAutenticao = new JButton("Autentication");
		btnAutenticao.addActionListener(new OpenSubMenuAction(this, connect));
		btnAutenticao.setBounds(84, 42, 116, 49);
		contentPane.add(btnAutenticao);
		
		JButton btnVisualizaoIssues = new JButton("Import Issues");
		btnVisualizaoIssues.addActionListener(new OpenSubMenuAction(this, importf));
		btnVisualizaoIssues.setBounds(84, 102, 116, 49);
		contentPane.add(btnVisualizaoIssues);
		
		JButton btnConversoParaTasks = new JButton("Export Tasks");
		btnConversoParaTasks.addActionListener(new OpenSubMenuAction(this, export));
		btnConversoParaTasks.setBounds(84, 162, 116, 49);
		contentPane.add(btnConversoParaTasks);
		
		JButton btnSettings = new JButton("Settings");
		btnSettings.addActionListener(new OpenSubMenuAction(this, settings));
		btnSettings.setBounds(26, 242, 89, 23);
		contentPane.add(btnSettings);
	}
}