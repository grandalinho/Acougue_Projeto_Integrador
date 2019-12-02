package br.com.acougue.frames;

import java.awt.BorderLayout;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import br.com.acougue.dal.ConnectionModule;


import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JComboBox;
import javax.swing.ImageIcon;



public class Loja extends JFrame {
	
	Connection con = ConnectionModule.conector();
	PreparedStatement pst = null;
	ResultSet rs = null;
	
	
	private JPanel contentPane;
	private JTable table;
	private JTextField txtValor;
	private JTextField txtProduto;
	private JLabel lblValorDoProduto;
	private JTextField txtGrama;
	private JLabel txtIdCli;
	DefaultTableModel modelo;
	JScrollPane scrollPane;
	private JComboBox cbCliente;
	private JButton btnCalcularTotal;
	private JTextField txtTotal;
	private JTextField txtCliente;
	private JTextField txtTroco;
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Loja frame = new Loja();
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
	public Loja() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 766, 449);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		scrollPane = new JScrollPane();
		scrollPane.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
			}
		});
		
		
		
		
		
		
		
		scrollPane.setBounds(10, 36, 730, 132);
		contentPane.add(scrollPane);
		
		
		String[] colunas = {"Codigo do produto","Animal","Corte","Valor","Estoque","Data no Estoque"};
		modelo = new DefaultTableModel(colunas,0);
		
		
		JLabel lblNewLabel = new JLabel("Quantidade em gramas:");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel.setBounds(10, 226, 177, 14);
		contentPane.add(lblNewLabel);
		
		txtValor = new JTextField();
		txtValor.setBounds(399, 225, 123, 20);
		contentPane.add(txtValor);
		txtValor.setColumns(10);
		
		JButton btnNewButton = new JButton("Finalizar Pedido");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				adicionar();
				troco();
			}
		});
		btnNewButton.setBounds(10, 348, 127, 22);
		contentPane.add(btnNewButton);
		
		JLabel lblQuan = new JLabel("Codigo do Produto:");
		lblQuan.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblQuan.setBounds(10, 201, 177, 14);
		contentPane.add(lblQuan);
		
		txtProduto = new JTextField();
		txtProduto.setBounds(149, 200, 80, 20);
		contentPane.add(txtProduto);
		txtProduto.setColumns(10);
		
		lblValorDoProduto = new JLabel("Valor do Produto:");
		lblValorDoProduto.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblValorDoProduto.setBounds(270, 226, 137, 14);
		contentPane.add(lblValorDoProduto);
		
		txtGrama = new JTextField();
		txtGrama.setBounds(180, 225, 80, 20);
		contentPane.add(txtGrama);
		txtGrama.setColumns(10);
		
		txtIdCli = new JLabel("ID Cliente:");
		txtIdCli.setFont(new Font("Tahoma", Font.BOLD, 14));
		txtIdCli.setBounds(10, 284, 80, 14);
		contentPane.add(txtIdCli);
		
		cbCliente = new JComboBox();
		cbCliente.setBounds(87, 282, 98, 22);
		contentPane.add(cbCliente);
		
		btnCalcularTotal = new JButton("Calcular Total");
		btnCalcularTotal.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				calcular();
			}
		});
		btnCalcularTotal.setBounds(10, 251, 127, 23);
		contentPane.add(btnCalcularTotal);
		
		txtTotal = new JTextField();
		txtTotal.setEnabled(false);
		txtTotal.setBounds(149, 251, 96, 20);
		contentPane.add(txtTotal);
		txtTotal.setColumns(10);
		
		JLabel lblProdutos = new JLabel("Catalogo de Produtos:");
		lblProdutos.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblProdutos.setBounds(10, 11, 177, 14);
		contentPane.add(lblProdutos);
		
		JLabel lblCaixa = new JLabel("Caixa:");
		lblCaixa.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblCaixa.setBounds(10, 179, 177, 20);
		contentPane.add(lblCaixa);
		
		txtCliente = new JTextField();
		txtCliente.setBounds(164, 322, 96, 20);
		contentPane.add(txtCliente);
		txtCliente.setColumns(10);
		
		JLabel lblValorDoCliente = new JLabel("Dinheiro do Cliente:");
		lblValorDoCliente.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblValorDoCliente.setBounds(10, 323, 144, 14);
		contentPane.add(lblValorDoCliente);
		
		txtTroco = new JTextField();
		txtTroco.setToolTipText("Troco");
		txtTroco.setBounds(20, 381, 96, 20);
		contentPane.add(txtTroco);
		txtTroco.setColumns(10);
		
		pesquisar();
		
		adicionar();
		
		exibirCliente();
	}
	
	private void limpar() {
		txtProduto.setText(null);
		txtGrama.setText(null);
		txtValor.setToolTipText(null);
		txtIdCli.setText(null);
	
		
	}
	
	private void pesquisar() {
        String read = "select * from tb_produtos";
        try {
            pst = con.prepareStatement(read);
            rs = pst.executeQuery();
            while(rs.next()) {
            	modelo.addRow(new Object[] {
            			rs.getString(1),
            			rs.getString(2),
            			rs.getString(3),
            			rs.getString(4),
            			rs.getString(5),
            			rs.getString(6)           			
            			
            	});
            }
        	table = new JTable(modelo);
    		scrollPane.setViewportView(table);
           
        } catch (Exception e) {
			System.out.println(e);
		}
    }
	
	
	
	private void exibirCliente() {
				
		String sql="select * from tb_clientes";
				
		try {
			pst = con.prepareStatement(sql);
			rs = pst.executeQuery();
	        
			while(rs.next() ) {
	        		cbCliente.addItem(rs.getString("idCli"));
	        	}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        
		
	}
	private void adicionar() {
		String create = "insert into tb_carrinho (codigoProduto,quantidade,precoKilo,idCli,total) values(?,?,?,?,?)";
		try {
			pst = (PreparedStatement) con.prepareStatement(create);
			
			pst.setString(1, txtProduto.getText());
			pst.setString(2, txtGrama.getText());
			pst.setString(3, txtValor.getText());
			pst.setString(4, cbCliente.getSelectedItem().toString());
			pst.setString(5, txtTotal.getText());
			
			int r = pst.executeUpdate();
			if (r > 0) {
				JOptionPane.showMessageDialog(null, " adicionado com sucesso");
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
		
	/**
	 * 
	 */
	private void calcular() {

		double grama , valor , total;
		
		grama = Double.parseDouble(txtGrama.getText());
		valor = Double.parseDouble(txtValor.getText());
		total = (grama *(0.001)) * valor;
		String s=Double.toString(total);  
		txtTotal.setText(s);

	}
	
	private void troco() {
		
		double cliente , produto , troco;
		
		cliente = Double.parseDouble(txtCliente.getText());
		produto = Double.parseDouble(txtTotal.getText());
		troco = cliente - produto;
		String t=Double.toString(troco);
		txtTroco.setText(t);
		
	}
}
	//String name =rs.getString("idCli");
	//cbCliente.addItem(name);

