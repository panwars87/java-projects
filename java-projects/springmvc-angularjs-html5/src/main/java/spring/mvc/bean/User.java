package spring.mvc.bean;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotEmpty;

@Entity
@Table(name="USER")
public class User {

	@Id
	@GeneratedValue
	@Column(name="IDUSER")	
	private int idUser;
	
	@NotEmpty
    @Size(min=5, max=20)
	@Column(name="USERNAME")	
	private String username;
	
	@NotEmpty
    @Size(min=5, max=20)
	@Column(name="PASSWORD")	
	private String password;
	
	@Column(name="ENABLED")
	private boolean enabled;
	
	public String getUsername() {
		return username;
	}	
	public void setUsername(String username) {
		this.username = username;
	}	
	public String getPassword() {
		return password;
	}	
	public void setPassword(String password) {
		this.password = password;
	}	
	public boolean getEnabled() {
		return enabled;
	}
	public void setEnabled(boolean enabled) {
		this.enabled = enabled;
	}
	public int getIdUser() {
		return idUser;
	}
	public void setIdUser(int idUser) {
		this.idUser = idUser;
	}
}