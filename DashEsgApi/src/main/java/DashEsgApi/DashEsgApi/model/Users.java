package DashEsgApi.DashEsgApi.model;

import java.sql.Date;
import java.sql.Timestamp;
import java.util.Collection;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.DynamicUpdate;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import antlr.collections.List;


@Entity
@DynamicUpdate(true)
public class Users{
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(nullable = false)
	private Integer id;

	@Column(nullable = false)
	private String name;

	@Column(unique = true, length = 100, nullable = false)
	private String email;

	@Column(nullable = false)
	private String password;
	
	public Integer id_company;
	
    @CreationTimestamp
    @Column(updatable = false)
	public Timestamp created_at;
	

	public Integer getId_company() {
		return id_company;
	}
	public void setId_company(Integer id_company) {
		this.id_company = id_company;
	}
	public Timestamp getCreated_at() {
		return created_at;
	}
	public void setCreated_at(Timestamp created_at) {
		this.created_at = created_at;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	
	
	 public Users copy() {
		 Users copy = new Users();
	        copy.id = this.id;
	        copy.name = this.name;
	        copy.email = this.email;
	        copy.password = this.password;
	        copy.created_at = this.created_at;
	        return copy;
	  }
	 
		@Override
		public boolean equals(Object obj) {
	        if (this == obj) return true;
	        if (obj == null || getClass() != obj.getClass()) return false;
	        Users u = (Users) obj;
	        return id == u.id &&
	                Objects.equals(email, u.email); 
		}


}
