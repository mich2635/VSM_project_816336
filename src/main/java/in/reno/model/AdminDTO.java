package in.reno.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="Admin_info")
public class AdminDTO {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	@Column(name="user_name",nullable=false)
	private String userName;
	
	@Column(name="password",nullable = false)
	private String password;

	public AdminDTO() {

	}

	
	public AdminDTO(String userName, String password) {
		super();
		this.userName = userName;
		this.password = password;
	}


	public AdminDTO(int id, String userName, String password) {

		this.id = id;
		this.userName = userName;
		this.password = password;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

}
