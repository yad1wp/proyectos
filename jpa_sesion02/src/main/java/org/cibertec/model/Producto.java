package org.cibertec.model;

import java.io.Serializable;

import javax.persistence.*;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name="tb_productos")
public class Producto implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="idprod")
	private int idProd;

	@Column(name="des_prod")
	private String desProd;
	
	@Column(name="stk_prod")
	private int stkProd;
	
	@Column(name="pre_prod")
	private double preProd;
	
	@Column(name="idcategoria")
	private int idCategoria;
	
	@Column(name="est_prod")
	private int estProd;
	
	@Column(name="idproveedor")
	private int idProveedor;

}
