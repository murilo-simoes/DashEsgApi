package DashEsgApi.DashEsgApi.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.hibernate.annotations.DynamicUpdate;

@Entity
@DynamicUpdate
public class Survey {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@Column(nullable = false)
	private Integer id_company;
	
	@Column(nullable = false)
	private Double ambiental;
	
	@Column(nullable = false)
	private Double social;
	
	@Column(nullable = false)
	private Double governamental;
	
	@Column(nullable = false)
	private Double total_geral;
	
	@Column(nullable = false)
	private Double ambiental_estrategico;

	@Column(nullable = false)
	private Double ambiental_planejamento;
	
	@Column(nullable = false)
	private Double ambiental_controle;
	
	@Column(nullable = false)
	private Double ambiental_acao;
	
	@Column(nullable = false)
	private Double social_estrategico;

	@Column(nullable = false)
	private Double social_planejamento;
	
	@Column(nullable = false)
	private Double social_controle;
	
	@Column(nullable = false)
	private Double social_acao;
	
	@Column(nullable = false)
	private Double governamental_estrategico;

	@Column(nullable = false)
	private Double governamental_planejamento;
	
	@Column(nullable = false)
	private Double governamental_controle;
	
	@Column(nullable = false)
	private Double governamental_acao;
	
	@Column(nullable = false)
	private Double total_estrategico;
	
	@Column(nullable = false)
	private Double total_planejamento;
	
	public Integer getId_company() {
		return id_company;
	}

	public void setId_company(Integer id_company) {
		this.id_company = id_company;
	}

	public Double getAmbiental() {
		return ambiental;
	}

	public void setAmbiental(Double ambiental) {
		this.ambiental = ambiental;
	}

	public Double getSocial() {
		return social;
	}

	public void setSocial(Double social) {
		this.social = social;
	}

	public Double getGovernamental() {
		return governamental;
	}

	public void setGovernamental(Double governamental) {
		this.governamental = governamental;
	}

	public Double getTotal_geral() {
		return total_geral;
	}

	public void setTotal_geral(Double total_geral) {
		this.total_geral = total_geral;
	}

	public Double getAmbiental_estrategico() {
		return ambiental_estrategico;
	}

	public void setAmbiental_estrategico(Double ambiental_estrategico) {
		this.ambiental_estrategico = ambiental_estrategico;
	}

	public Double getAmbiental_planejamento() {
		return ambiental_planejamento;
	}

	public void setAmbiental_planejamento(Double ambiental_planejamento) {
		this.ambiental_planejamento = ambiental_planejamento;
	}

	public Double getAmbiental_controle() {
		return ambiental_controle;
	}

	public void setAmbiental_controle(Double ambiental_controle) {
		this.ambiental_controle = ambiental_controle;
	}

	public Double getAmbiental_acao() {
		return ambiental_acao;
	}

	public void setAmbiental_acao(Double ambiental_acao) {
		this.ambiental_acao = ambiental_acao;
	}

	public Double getSocial_estrategico() {
		return social_estrategico;
	}

	public void setSocial_estrategico(Double social_estrategico) {
		this.social_estrategico = social_estrategico;
	}

	public Double getSocial_planejamento() {
		return social_planejamento;
	}

	public void setSocial_planejamento(Double social_planejamento) {
		this.social_planejamento = social_planejamento;
	}

	public Double getSocial_controle() {
		return social_controle;
	}

	public void setSocial_controle(Double social_controle) {
		this.social_controle = social_controle;
	}

	public Double getSocial_acao() {
		return social_acao;
	}

	public void setSocial_acao(Double social_acao) {
		this.social_acao = social_acao;
	}

	public Double getGovernamental_estrategico() {
		return governamental_estrategico;
	}

	public void setGovernamental_estrategico(Double governamental_estrategico) {
		this.governamental_estrategico = governamental_estrategico;
	}

	public Double getGovernamental_planejamento() {
		return governamental_planejamento;
	}

	public void setGovernamental_planejamento(Double governamental_planejamento) {
		this.governamental_planejamento = governamental_planejamento;
	}

	public Double getGovernamental_controle() {
		return governamental_controle;
	}

	public void setGovernamental_controle(Double governamental_controle) {
		this.governamental_controle = governamental_controle;
	}

	public Double getGovernamental_acao() {
		return governamental_acao;
	}

	public void setGovernamental_acao(Double governamental_acao) {
		this.governamental_acao = governamental_acao;
	}

	public Double getTotal_estrategico() {
		return total_estrategico;
	}

	public void setTotal_estrategico(Double total_estrategico) {
		this.total_estrategico = total_estrategico;
	}

	public Double getTotal_planejamento() {
		return total_planejamento;
	}

	public void setTotal_planejamento(Double total_planejamento) {
		this.total_planejamento = total_planejamento;
	}

	public Double getTotal_controle() {
		return total_controle;
	}

	public void setTotal_controle(Double total_controle) {
		this.total_controle = total_controle;
	}

	public Double getTotal_acao() {
		return total_acao;
	}

	public void setTotal_acao(Double total_acao) {
		this.total_acao = total_acao;
	}

	@Column(nullable = false)
	private Double total_controle;
	
	@Column(nullable = false)
	private Double total_acao;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}
	
}
