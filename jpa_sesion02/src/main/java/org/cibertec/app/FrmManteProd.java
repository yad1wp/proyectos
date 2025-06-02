package org.cibertec.app;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import org.cibertec.controlador.CategoriaJpaController;
import org.cibertec.controlador.ProductoJpaController;
import org.cibertec.controlador.ProveedorJpaController;
import org.cibertec.model.Categoria;
import org.cibertec.model.Producto;
import org.cibertec.model.Proveedor;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.List;
import java.awt.event.ActionEvent;
import javax.swing.JTextArea;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JComboBox;

public class FrmManteProd extends JFrame {

	private static final long serialVersionUID = 1L;

	private JPanel contentPane;

	private JTextArea txtSalida;
	private JTextField txtCodigo;
	private JComboBox<String> cboCategorias;
	private JComboBox<String> cboProveedores;
	private JTextField txtDescripcion;
	private JTextField txtStock;
	private JTextField txtPrecio;

	private ProductoJpaController jpaProducto=new ProductoJpaController();
	private CategoriaJpaController jpaCategoria=new CategoriaJpaController();
	private ProveedorJpaController jpaProveedor=new ProveedorJpaController();
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FrmManteProd frame = new FrmManteProd();
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
	public FrmManteProd() {
		setTitle("Mantenimiento de Productos");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 390);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JButton btnRegistrar = new JButton("Registrar");
		btnRegistrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				registrar();
			}
		});
		btnRegistrar.setBounds(324, 29, 89, 23);
		contentPane.add(btnRegistrar);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 171, 414, 143);
		contentPane.add(scrollPane);

		txtSalida = new JTextArea();
		scrollPane.setViewportView(txtSalida);

		JButton btnListado = new JButton("Listado");
		btnListado.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				listado();
			}
		});
		btnListado.setBounds(177, 322, 89, 23);
		contentPane.add(btnListado);

		txtCodigo = new JTextField();
		txtCodigo.setBounds(122, 11, 86, 20);
		contentPane.add(txtCodigo);
		txtCodigo.setColumns(10);

		JLabel lblCodigo = new JLabel("Id. Producto :");
		lblCodigo.setBounds(10, 14, 102, 14);
		contentPane.add(lblCodigo);

		cboCategorias = new JComboBox<String>();
		cboCategorias.setBounds(122, 70, 140, 22);
		contentPane.add(cboCategorias);

		JLabel lblCategora = new JLabel("Categor\u00EDa");
		lblCategora.setBounds(10, 74, 102, 14);
		contentPane.add(lblCategora);

		JLabel lblNomProducto = new JLabel("Nom. Producto :");
		lblNomProducto.setBounds(10, 45, 102, 14);
		contentPane.add(lblNomProducto);

		txtDescripcion = new JTextField();
		txtDescripcion.setColumns(10);
		txtDescripcion.setBounds(122, 42, 144, 20);
		contentPane.add(txtDescripcion);

		JLabel lblStock = new JLabel("Stock:");
		lblStock.setBounds(10, 106, 102, 14);
		contentPane.add(lblStock);

		txtStock = new JTextField();
		txtStock.setColumns(10);
		txtStock.setBounds(122, 103, 77, 20);
		contentPane.add(txtStock);

		JLabel lblPrecio = new JLabel("Precio:");
		lblPrecio.setBounds(10, 134, 102, 14);
		contentPane.add(lblPrecio);

		txtPrecio = new JTextField();
		txtPrecio.setColumns(10);
		txtPrecio.setBounds(122, 131, 77, 20);
		contentPane.add(txtPrecio);

		JLabel lblProveedores = new JLabel("Proveedor:");
		lblProveedores.setBounds(230, 106, 102, 14);
		contentPane.add(lblProveedores);

		cboProveedores = new JComboBox<String>();
		cboProveedores.setBounds(300, 104, 140, 22);
		contentPane.add(cboProveedores);

		JButton btnBuscar = new JButton("Buscar");
		btnBuscar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				buscar();
			}
		});
		btnBuscar.setBounds(324, 63, 89, 23);
		contentPane.add(btnBuscar);

		llenaCombo();
	}

	void llenaCombo() {
		
	}

	void registrar() {
		
	}

	void listado() {
		txtSalida.setText("");
		
		List<Producto> lista=jpaProducto.findAll();
		
		for (Producto item : lista) {
			txtSalida.append("Id Producto: " +  String.valueOf(item.getIdProd()));
			txtSalida.append("\n");
			txtSalida.append("Descripcion: " +  String.valueOf(item.getDesProd()));
			txtSalida.append("\n");
			txtSalida.append("Precio: " +  String.valueOf(item.getPreProd()));
			txtSalida.append("\n");
			txtSalida.append("Stock: " +  String.valueOf(item.getStkProd()));
			txtSalida.append("\n");
	
			txtSalida.append("Categoria: " +   String.valueOf(item.getIdCategoria())+ "-"
			+ String.valueOf(jpaCategoria.buscarById(item.getIdCategoria()).getDescripcion()));
			txtSalida.append("\n");
			txtSalida.append("Proveedor: " +   String.valueOf(item.getIdProveedor())+"-"
			+ String.valueOf(jpaProveedor.buscarById(item.getIdProveedor()).getNombreRs()));
			
			txtSalida.append("\n");
			
			txtSalida.append("***************************************");
			txtSalida.append("\n");			
		}
	}
	
	void buscar() {
		Producto objProd=jpaProducto.buscarById(Integer.parseInt(txtCodigo.getText()));		
		if (objProd==null) {
			txtDescripcion.setText("");
			txtPrecio.setText("");
			txtStock.setText("");
			JOptionPane.showMessageDialog(null, "Producto no encontrado");			
		}else {
			txtDescripcion.setText(objProd.getDesProd());
			txtPrecio.setText(String.valueOf(objProd.getPreProd()));
			txtStock.setText(String.valueOf(objProd.getStkProd()));
		}		
	}
}
