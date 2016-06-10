package it.clinica.model;


import java.util.List;

import javax.persistence.*;

@Entity
@Table(name = "RisultatiProposti")
@NamedQuery(name = "trovaTuttiIRisultatiProposti", query = "SELECT r FROM RisultatiProposti r")
public class RisultatoProposto {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long codice;
	@Column(nullable=false)
	private String nome;
	@ManyToMany (mappedBy="risultatiProposti")
	private List<TipologiaEsame> tipologieEsamePerQuestiRisultatiProposti;

	public RisultatoProposto(){}

	public RisultatoProposto(Long codice, String nome) {
		this.codice = codice;
		this.nome = nome;
	}

	public Long getCodice() {
		return codice;
	}
	public void setCodice(Long codice) {
		this.codice = codice;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}


}
