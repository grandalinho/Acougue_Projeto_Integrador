package br.com.acougue.frames;

import java.awt.BorderLayout;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;



import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import java.awt.Font;

public class Central extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Central frame = new Central();
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
	public Central() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 643, 229);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnNewButton = new JButton("");
		btnNewButton.setIcon(new ImageIcon(Central.class.getResource("/br/com/acougue/icons/iconfinder_box_172576.png")));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Principal principal = new Principal();
				principal.setVisible(true);
			}
		});
		btnNewButton.setBounds(25, 21, 135, 135);
		contentPane.add(btnNewButton);
		
		JButton btnLoja = new JButton("");
		btnLoja.setIcon(new ImageIcon(Central.class.getResource("/br/com/acougue/icons/iconfinder_thefreeforty_shop_1243706.png")));
		btnLoja.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Loja loja = new Loja();
				loja.setVisible(true);
			}
		});
		btnLoja.setBounds(170, 21, 135, 135);
		contentPane.add(btnLoja);
		
		JButton btnClientes = new JButton("");
		btnClientes.setIcon(new ImageIcon(Central.class.getResource("/br/com/acougue/icons/iconfinder_00-ELASTOFONT-STORE-READY_user_2703063.png")));
		btnClientes.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CadastroCliente cliente = new CadastroCliente();
				cliente.setVisible(true);
			}
			
		});
		btnClientes.setBounds(326, 21, 135, 135);
		contentPane.add(btnClientes);
		
		JButton btnNewButton_1 = new JButton("");
		btnNewButton_1.setIcon(new ImageIcon(Central.class.getResource("/br/com/acougue/icons/folder.png")));
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Pedidos pedidos = new Pedidos();
				pedidos.setVisible(true);
			}
		});
		btnNewButton_1.setBounds(471, 21, 135, 135);
		contentPane.add(btnNewButton_1);
		
		JLabel lblNewLabel = new JLabel("Estoque");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel.setBounds(64, 167, 88, 14);
		contentPane.add(lblNewLabel);
		
		JLabel lblLoja = new JLabel("Loja");
		lblLoja.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblLoja.setBounds(227, 167, 88, 14);
		contentPane.add(lblLoja);
		
		JLabel lblUsuario = new JLabel("Usuario");
		lblUsuario.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblUsuario.setBounds(364, 167, 88, 14);
		contentPane.add(lblUsuario);
		
		JLabel lblPedidos = new JLabel("Pedidos");
		lblPedidos.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblPedidos.setBounds(513, 167, 88, 14);
		contentPane.add(lblPedidos);
	}
}
