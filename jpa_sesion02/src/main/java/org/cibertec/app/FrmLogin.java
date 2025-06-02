package org.cibertec.app;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import org.cibertec.controlador.UsuarioJpaController;

public class FrmLogin extends JFrame{

	private static final long serialVersionUID = 1L;

	private JPanel contentPane;
	private JTextField txtUsuario;
	private JTextField txtClave;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FrmLogin frame = new FrmLogin();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public FrmLogin() {
		setTitle("");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 150);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JButton btnRegistrar = new JButton("Ingresar");
		btnRegistrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				ingresar();
			}
		});
		btnRegistrar.setBounds(324, 29, 89, 23);
		contentPane.add(btnRegistrar);

		JLabel lblUsuario = new JLabel("Usuario: ");
		lblUsuario.setBounds(10, 14, 102, 20);
		contentPane.add(lblUsuario);

		txtUsuario = new JTextField();
		txtUsuario.setBounds(122, 14, 144, 20);
		txtUsuario.setColumns(10);
		contentPane.add(txtUsuario);
		
		JLabel lblClave = new JLabel("Clave: ");
		lblClave.setBounds(10, 50, 102, 20);
		contentPane.add(lblClave);

		txtClave = new JTextField();
		txtClave.setColumns(10);
		txtClave.setBounds(122, 50, 144, 20);
		contentPane.add(txtClave);
	}

	 void ingresar() {
		
	}
	
}
