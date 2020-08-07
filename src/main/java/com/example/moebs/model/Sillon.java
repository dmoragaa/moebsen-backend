package com.example.moebs.model;

import org.hibernate.annotations.SQLDelete;

import javax.persistence.*;

@Entity
@Table
@SQLDelete(sql = "UPDATE Sillon SET activo=false WHERE id = ?")
public class Sillon {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
	@Column
	private String codigo;
    @Column
	private String tipo;
    @Column
    private Boolean activo;

    //@Column
	//private Long id_sala;

	/*public Long getId_sala() {
		return id_sala;
	}
	public void setId_sala(Long id_sala) {
		this.id_sala = id_sala;
	}*/
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getTipo() {
		return tipo;
	}
	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
	public Boolean getActivo() {
		return activo;
	}
	public void setActivo(Boolean activo) {
		this.activo = activo;
	}

	public String getCodigo() {
		return codigo;
	}
	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}
}