package br.com.acougue.frames;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import br.com.acougue.dal.ConnectionModule;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.awt.event.ActionEvent;
import javax.swing.border.LineBorder;
import java.awt.Color;
import javax.swing.ImageIcon;

public class Principal extends JFrame {
	
	Connection con = ConnectionModule.conector();
	PreparedStatement pst = null;
	ResultSet rs = null;

	private JPanel contentPane;
	private JTextField txtEstoque;
	private JTextField txtValor;
	private JTextField txtAnimal;
	private JTextField txtCorte;
	private JTextField txtId;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Principal frame = new Principal();
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
	public Principal() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 505, 256);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnNewButton = new JButton("");
		btnNewButton.setIcon(new ImageIcon(Principal.class.getResource("/br/com/acougue/icons/add48.png")));
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				adicionar();
			}
		});
		btnNewButton.setBounds(93, 118, 64, 64);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("");
		btnNewButton_1.setIcon(new ImageIcon(Principal.class.getResource("/br/com/acougue/icons/lupa48.png")));
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				pesquisar();
			}
		});
		btnNewButton_1.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnNewButton_1.setBounds(167, 118, 64, 64);
		contentPane.add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("");
		btnNewButton_2.setIcon(new ImageIcon(Principal.class.getResource("/br/com/acougue/icons/update48.png")));
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				atualizar();
			}
		});
		btnNewButton_2.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnNewButton_2.setBounds(334, 118, 64, 64);
		contentPane.add(btnNewButton_2);
		
		JLabel lblId = new JLabel("ID:");
		lblId.setFont(new Font("Tahoma", Font.BOLD, 17));
		lblId.setBounds(10, 11, 70, 19);
		contentPane.add(lblId);
		
		txtId = new JTextField();
		txtId.setBounds(42, 13, 96, 20);
		contentPane.add(txtId);
		txtId.setColumns(10);
		
		JPanel panel = new JPanel();
		panel.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel.setBounds(10, 41, 468, 71);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel label_2 = new JLabel("Estoque:");
		label_2.setBounds(10, 36, 91, 19);
		panel.add(label_2);
		label_2.setFont(new Font("Tahoma", Font.BOLD, 17));
		
		txtEstoque = new JTextField();
		txtEstoque.setBounds(88, 38, 139, 20);
		panel.add(txtEstoque);
		txtEstoque.setColumns(10);
		
		JLabel lblAnimal = new JLabel("Animal:");
		lblAnimal.setBounds(10, 11, 70, 19);
		panel.add(lblAnimal);
		lblAnimal.setFont(new Font("Tahoma", Font.BOLD, 17));
		
		txtAnimal = new JTextField();
		txtAnimal.setBounds(78, 11, 151, 20);
		panel.add(txtAnimal);
		txtAnimal.setColumns(10);
		
		JLabel label = new JLabel("Corte:");
		label.setBounds(239, 11, 70, 19);
		panel.add(label);
		label.setFont(new Font("Tahoma", Font.BOLD, 17));
		
		txtCorte = new JTextField();
		txtCorte.setBounds(297, 13, 116, 20);
		panel.add(txtCorte);
		txtCorte.setColumns(10);
		
		JLabel label_1 = new JLabel("Valor:");
		label_1.setBounds(237, 36, 70, 19);
		panel.add(label_1);
		label_1.setFont(new Font("Tahoma", Font.BOLD, 17));
		
		txtValor = new JTextField();
		txtValor.setBounds(297, 38, 116, 20);
		panel.add(txtValor);
		txtValor.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("Adicionar");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNewLabel.setBounds(103, 193, 64, 14);
		contentPane.add(lblNewLabel);
		
		JLabel lblProcurar = new JLabel("Procurar");
		lblProcurar.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblProcurar.setBounds(177, 193, 54, 14);
		contentPane.add(lblProcurar);
		
		JLabel lblLimpar = new JLabel("Excluir");
		lblLimpar.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblLimpar.setBounds(270, 193, 54, 14);
		contentPane.add(lblLimpar);
		
		JLabel lblEditar = new JLabel("Editar");
		lblEditar.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblEditar.setBounds(344, 193, 45, 14);
		contentPane.add(lblEditar);
		
		JButton btnNewButton_3 = new JButton("");
		btnNewButton_3.setIcon(new ImageIcon(Principal.class.getResource("/br/com/acougue/icons/remover48.png")));
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				remover();
			}
		});
		btnNewButton_3.setBounds(260, 118, 64, 64);
		contentPane.add(btnNewButton_3);
	}
	
	private void limpar() {
		txtId.setText(null);
		txtAnimal.setText(null);
		txtCorte.setToolTipText(null);
		txtEstoque.setText(null);
		txtValor.setText(null);
		
	}
	
	private void adicionar() {
		String create = "insert into tb_produtos (codigoProduto,animal,corte,valor,estoque) values(?,?,?,?,?)";
		try {
			pst = (PreparedStatement) con.prepareStatement(create);
			
			pst.setString(1, txtId.getText());
			pst.setString(2, txtAnimal.getText());
			pst.setString(3, txtCorte.getText());
			pst.setString(4, txtEstoque.getText());
			pst.setString(5, txtValor.getText());
			
			
			int r = pst.executeUpdate();
			if (r > 0) {
				JOptionPane.showMessageDialog(null, "Corte adicionado com sucesso");
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
		String read = "select * from tb_produtos where codigoProduto =?";
		try {
			pst = (PreparedStatement) con.prepareStatement(read);
			pst.setString(1, txtId.getText());
			rs = pst.executeQuery();
			
			if (rs.next()) {
				txtAnimal.setText(rs.getString(2));
				txtCorte.setText(rs.getString(3));
				txtEstoque.setText(rs.getString(4));
				txtValor.setText(rs.getString(5));
			
			

			} else {
				JOptionPane.showMessageDialog(null, "inexistente");
				limpar();
			}
		} catch (Exception e) {
			System.out.println(e);
		}
		
	}
	
	private void atualizar() {
		String update = "update tb_produtos set animal=?, corte=?, valor=? , estoque=? where codigoProduto=?";
		try {
			pst = (PreparedStatement) con.prepareStatement(update);
			// passagem de parâmetros
			// o id é o ultimo parâmetro
			pst.setString(1, txtAnimal.getText());
			pst.setString(2, txtCorte.getText());
			pst.setString(3, txtEstoque.getText());
			pst.setString(4, txtValor.getText());
			pst.setString(5, txtId.getText());
			
			int r = pst.executeUpdate();
			if (r > 0) {
				JOptionPane.showMessageDialog(null, "alterado com sucesso");
				limpar();
			} // fim do if
			else {
				JOptionPane.showMessageDialog(null, "Não foi possivel alterar");
			} // fim do else
		} // fim do try
		catch (Exception e) {
			System.out.println(e);
		} // fim
	
}
	private void remover() {
		// criar uma caixa de diálogo para confirmar a exclusão
		int confirma = JOptionPane.showConfirmDialog(null, "Confirma a exclusão deste contato ?", "Atenção",
				JOptionPane.YES_NO_OPTION);
		if (confirma == JOptionPane.YES_NO_OPTION) {
			String delete = "delete from tb_produtos where id=?";

			try {

				pst = (PreparedStatement) con.prepareStatement(delete);
				pst.setString(1, txtId.getText());
				int r = pst.executeUpdate();
				if (r > 0) {
					limpar();
					JOptionPane.showMessageDialog(null, " deletado com sucesso");

				} else {
					JOptionPane.showMessageDialog(null, "Não foi possivel remover");
				}
			} catch (Exception e) {
				System.out.println(e);
			}

		}
}
}


