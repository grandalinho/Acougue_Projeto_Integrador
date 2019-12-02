package br.com.acougue.frames;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import br.com.acougue.dal.ConnectionModule;

import javax.swing.JScrollPane;
import javax.swing.JTable;

public class Pedidos extends JFrame {
	
	Connection con = ConnectionModule.conector();
	PreparedStatement pst = null;
	ResultSet rs = null;
	
	private JPanel contentPane;
	private JTable table;
	DefaultTableModel modelo;
	JScrollPane scrollPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Pedidos frame = new Pedidos();
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
	public Pedidos() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 879, 302);
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
		
		
		scrollPane.setBounds(10, 11, 843, 241);
		contentPane.add(scrollPane);
		
		String[] colunas = {"nota Fiscal","Codigo do Produto","quantidade","Valor Kilo","Id do Cliente","Total","dataPedido"};
		modelo = new DefaultTableModel(colunas,0);
		
		pesquisar();
		
	}
	
	private void pesquisar() {
        /*String read = "select tb_carrinho.*,tb_pedidos.datapedido from tb_carrinho inner join tb_pedidos on tb_carrinho.notaFiscal=tb_pedidos.notaFiscal";*/
		String read = "select * from tb_carrinho";

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
            			rs.getString(6),
            			rs.getString(7)
            			
            			
            	});
            }
        	table = new JTable(modelo);
        	scrollPane.setViewportView(table);
           
        } catch (Exception e) {
			System.out.println(e);
		}
    }

}
