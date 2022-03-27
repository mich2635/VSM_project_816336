package in.reno.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

@Entity
@NamedQuery(name="select_all_sCost", query="Select p From ServiceCostDTO p")
@Table(name = "service_cost")
public class ServiceCostDTO {

	@Id
	@GeneratedValue
	private int id;
	
	private String name;
	
	private int cost;
	
	
	
	public ServiceCostDTO() {
		super();
	}


	public ServiceCostDTO(int id, String name, int cost) {
		super();
		this.id = id;
		this.name = name;
		this.cost = cost;
	}
	
	
	public ServiceCostDTO(String name, int cost) {
		super();
		this.name = name;
		this.cost = cost;
	}


	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getCost() {
		return cost;
	}
	public void setCost(int cost) {
		this.cost = cost;
	}
	
	
}
