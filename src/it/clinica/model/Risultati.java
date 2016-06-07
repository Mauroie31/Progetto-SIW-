package it.clinica.model;

import javax.persistence.*;

@Entity
@Table(name = "risultati")
public class Risultati {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	@Column(nullable = false)
	private String chiave;
	@Column(nullable = false)
	private String valore;

	public Risultati(String chiave, String valore) {
		this.chiave=chiave;
		this.valore=valore;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getChiave() {
		return chiave;
	}

	public void setChiave(String chiave) {
		this.chiave = chiave;
	}

	public String getValore() {
		return valore;
	}

	public void setValore(String valore) {
		this.valore = valore;
	}

	
}
