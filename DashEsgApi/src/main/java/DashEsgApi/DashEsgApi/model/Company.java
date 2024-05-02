package DashEsgApi.DashEsgApi.model;

import java.sql.Date;
import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.DynamicUpdate;


@Entity
@DynamicUpdate
public class Company {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	@Column(nullable = false)
	private String name;
	
	@Column(nullable = false)
	private String employee_qty;

	@Column(nullable = false)
	private Double esg_goal;

	@Column(nullable = false)
	private String branch;

	@Column(unique = true, nullable = false)
	private String cnpj;

	@Column(nullable = false)
	private Integer id_survey;

    @CreationTimestamp
    @Column(updatable = false)
	private Timestamp created_at;
    
    @Column(nullable = false)
    private Integer user_id_creator;
    
    @Column(nullable = false)
    private String country;
    
	
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
    
    public Integer getUser_id_creator() {
		return user_id_creator;
	}
	public void setUser_id_creator(Integer user_id_creator) {
		this.user_id_creator = user_id_creator;
	}
	

	public Integer getId_survey() {
		return id_survey;
	}
	public void setId_survey(Integer id_survey) {
		this.id_survey = id_survey;
	}
	public Timestamp getCreated_at() {
		return created_at;
	}
	public void setCreated_at(Timestamp created_at) {
		this.created_at = created_at;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmployee_qty() {
		return employee_qty;
	}
	public void setEmployee_qty(String employee_qty) {
		this.employee_qty = employee_qty;
	}
	public Double getEsg_goal() {
		return esg_goal;
	}
	public void setEsg_goal(Double esg_goal) {
		this.esg_goal = esg_goal;
	}
	public String getBranch() {
		return branch;
	}
	public void setBranch(String branch) {
		this.branch = branch;
	}
	public String getCnpj() {
		return cnpj;
	}
	public void setCnpj(String cnpj) {
		this.cnpj = cnpj;
	}

	
}
