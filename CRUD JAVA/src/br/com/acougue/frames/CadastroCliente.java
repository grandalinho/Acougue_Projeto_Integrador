package br.com.acougue.frames;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import java.awt.Color;
import javax.swing.border.LineBorder;

import br.com.acougue.dal.ConnectionModule;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;

public class CadastroCliente extends JFrame {
	
	Connection con = ConnectionModule.conector();
	PreparedStatement pst = null;
	ResultSet rs = null;
	
	private JPanel contentPane;
	private JTextField txtNome;
	private JTextField txtCep;
	private JTextField txtLog;
	private JTextField txtNumero;
	private JTextField txtComplemento;
	private JTextField txtCidade;
	private JTextField txtEstado;
	private JTextField txtFone;
	private JTextField txtId;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CadastroCliente frame = new CadastroCliente();
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
	public CadastroCliente() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 605, 295);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Nome:");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNewLabel.setBounds(10, 11, 58, 14);
		contentPane.add(lblNewLabel);
		
		JLabel lblTelefone = new JLabel("Telefone:");
		lblTelefone.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblTelefone.setBounds(298, 11, 73, 14);
		contentPane.add(lblTelefone);
		
		txtNome = new JTextField();
		txtNome.setBounds(78, 9, 210, 20);
		contentPane.add(txtNome);
		txtNome.setColumns(10);
		
		JPanel panel = new JPanel();
		panel.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel.setForeground(Color.GRAY);
		panel.setBounds(10, 36, 569, 135);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblLogradouro = new JLabel("Logradouro:");
		lblLogradouro.setBounds(10, 44, 87, 14);
		panel.add(lblLogradouro);
		lblLogradouro.setFont(new Font("Tahoma", Font.BOLD, 13));
		
		txtCep = new JTextField();
		txtCep.setBounds(46, 13, 109, 20);
		panel.add(txtCep);
		txtCep.setColumns(10);
		
		JLabel lblNumero = new JLabel("Numero:");
		lblNumero.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNumero.setBounds(393, 44, 58, 14);
		panel.add(lblNumero);
		
		JLabel lblCep = new JLabel("Cep:");
		lblCep.setBounds(10, 15, 58, 14);
		panel.add(lblCep);
		lblCep.setFont(new Font("Tahoma", Font.BOLD, 13));
		
		txtLog = new JTextField();
		txtLog.setBounds(95, 42, 288, 20);
		panel.add(txtLog);
		txtLog.setColumns(10);
		
		txtNumero = new JTextField();
		txtNumero.setBounds(461, 42, 96, 20);
		panel.add(txtNumero);
		txtNumero.setColumns(10);
		
		JLabel lblComplemento = new JLabel("Complemento:");
		lblComplemento.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblComplemento.setBounds(10, 69, 109, 14);
		panel.add(lblComplemento);
		
		txtComplemento = new JTextField();
		txtComplemento.setBounds(129, 67, 124, 20);
		panel.add(txtComplemento);
		txtComplemento.setColumns(10);
		
		JLabel lblEstado = new JLabel("Estado:");
		lblEstado.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblEstado.setBounds(10, 94, 65, 14);
		panel.add(lblEstado);
		
		txtEstado = new JTextField();
		txtEstado.setBounds(63, 94, 116, 20);
		panel.add(txtEstado);
		txtEstado.setColumns(10);
		
		JLabel lblIdcliente = new JLabel("IdCliente:");
		lblIdcliente.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblIdcliente.setBounds(381, 73, 70, 14);
		panel.add(lblIdcliente);
		
		JLabel lblCidade = new JLabel("Cidade:");
		lblCidade.setBounds(189, 98, 109, 14);
		panel.add(lblCidade);
		lblCidade.setFont(new Font("Tahoma", Font.BOLD, 13));
		
		txtCidade = new JTextField();
		txtCidade.setBounds(242, 92, 131, 20);
		panel.add(txtCidade);
		txtCidade.setColumns(10);
		
		txtId = new JTextField();
		txtId.setBounds(381, 92, 96, 20);
		panel.add(txtId);
		txtId.setColumns(10);
		
		txtFone = new JTextField();
		txtFone.setBounds(368, 9, 129, 20);
		contentPane.add(txtFone);
		txtFone.setColumns(10);
		
		JButton btnNewButton = new JButton("");
		btnNewButton.setIcon(new ImageIcon(CadastroCliente.class.getResource("/br/com/acougue/icons/add48.png")));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				adicionar();
			}
		});
		btnNewButton.setBounds(20, 182, 64, 64);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("");
		btnNewButton_1.setIcon(new ImageIcon(CadastroCliente.class.getResource("/br/com/acougue/icons/update48.png")));
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				atualizar();
			}
		});
		btnNewButton_1.setBounds(119, 182, 64, 64);
		contentPane.add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("");
		btnNewButton_2.setIcon(new ImageIcon(CadastroCliente.class.getResource("/br/com/acougue/icons/remover48.png")));
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				remover();
			}
		});
		btnNewButton_2.setBounds(399, 182, 64, 64);
		contentPane.add(btnNewButton_2);
		
		JButton btnNewButton_3 = new JButton("");
		btnNewButton_3.setIcon(new ImageIcon(CadastroCliente.class.getResource("/br/com/acougue/icons/lupa48.png")));
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				pesquisar();
			}
		});
		btnNewButton_3.setBounds(501, 182, 64, 64);
		contentPane.add(btnNewButton_3);
	}
	
	private void limpar() {
		txtNome.setText(null);
		txtFone.setText(null);
		txtCep.setToolTipText(null);
		txtLog.setText(null);
		txtNumero.setText(null);
		txtComplemento.setText(null);
		txtEstado.setText(null);
		txtCidade.setText(null);
	}
	
	private void adicionar() {
		String create = "insert into tb_clientes (nomeCli,foneCli,cep,logradouro,numero,complemento,estado,cidade) values(?,?,?,?,?,?,?,?)";
		try {
			pst = (PreparedStatement) con.prepareStatement(create);
			
			pst.setString(1, txtNome.getText());
			pst.setString(2, txtFone.getText());
			pst.setString(3, txtCep.getText());
			pst.setString(4, txtLog.getText());
			pst.setString(5, txtNumero.getText());
			pst.setString(6, txtComplemento.getText());
			pst.setString(7, txtEstado.getText());
			pst.setString(8, txtCidade.getText());
			
			
			int r = pst.executeUpdate();
			if (r > 0) {
				JOptionPane.showMessageDialog(null, "adicionado com sucesso");
				limpar();
			}
			else {
				JOptionPane.showMessageDialog(null, "Não foi possivel adicionar");
			} 
		} 
		catch (Exception e) {
			System.out.println(e);
		}
	}	
	
	private void pesquisar() {
		String read = "select * from tb_clientes where nomeCli =?";
		try {
			pst = (PreparedStatement) con.prepareStatement(read);
			pst.setString(1, txtNome.getText());
			rs = pst.executeQuery();
			
			if (rs.next()) {
				txtId.setText(rs.getString(1));
				txtFone.setText(rs.getString(3));
				txtCep.setText(rs.getString(4));
				txtLog.setText(rs.getString(5));
				txtNumero.setText(rs.getString(6));
				txtComplemento.setText(rs.getString(7));
				txtEstado.setText(rs.getString(8));
				txtCidade.setText(rs.getString(9));
			
			

			} else {
				JOptionPane.showMessageDialog(null, "inexistente");
				limpar();
			}
		} catch (Exception e) {
			System.out.println(e);
		}
		
	}
	
	private void atualizar() {
		String update = "update tb_clientes set nomeCli=?, foneCli=?, cep=? , logradouro=?, numero=?, complemento=?, estado=?, cidade=? where idCli=?";
		try {
			pst = (PreparedStatement) con.prepareStatement(update);
			
			pst.setString(1, txtNome.getText());
			pst.setString(2, txtFone.getText());
			pst.setString(3, txtCep.getText());
			pst.setString(4, txtLog.getText());
			pst.setString(5, txtNumero.getText());
			pst.setString(6, txtComplemento.getText());
			pst.setString(7, txtEstado.getText());
			pst.setString(8, txtCidade.getText());
			pst.setString(9, txtId.getText());
			
			int r = pst.executeUpdate();
			if (r > 0) {
				JOptionPane.showMessageDialog(null, "alterado com sucesso");
				limpar();
			} 
			else {
				JOptionPane.showMessageDialog(null, "Não foi possivel alterar");
			} 
		} 
		catch (Exception e) {
			System.out.println(e);
		} 
	
}
	
	private void remover() {
		// criar uma caixa de diálogo para confirmar a exclusão
		int confirma = JOptionPane.showConfirmDialog(null, "Confirma a exclusão deste contato ?", "Atenção",
				JOptionPane.YES_NO_OPTION);
		if (confirma == JOptionPane.YES_NO_OPTION) {
			String delete = "delete from tb_clientes where nomeCli=?";

			try {

				pst = (PreparedStatement) con.prepareStatement(delete);
				pst.setString(1, txtNome.getText());
				int r = pst.executeUpdate();
				if (r > 0) {
					limpar();
					JOptionPane.showMessageDialog(null, "deletado com sucesso");

				} else {
					JOptionPane.showMessageDialog(null, "Não foi possivel remover");
				}
			} catch (Exception e) {
				System.out.println(e);
			}

		}
}
}
