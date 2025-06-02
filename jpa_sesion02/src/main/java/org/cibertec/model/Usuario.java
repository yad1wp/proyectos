package org.cibertec.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name="tb_usuarios")
public class Usuario implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="cod_usua")
	private int codUsua;

	@Column(name="nom_usua")
	private String nomUsua;
	
	@Column(name="ape_usua")
	private String apeUsua;
	
	@Column(name="usr_usua")
	private String usrUsua;
	
	@Column(name="cla_usua")
	private String claUsua;
	
	@Column(name="fna_usua")
	private String fnaUsua;
	
	@Column(name="idtipo")
	private int idTipo;
	
	@Column(name="est_usua")
	private int estUsua;
	

}
