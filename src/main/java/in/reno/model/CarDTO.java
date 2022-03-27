package in.reno.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@NamedQuery(name = "select_all", query = "Select c From CarDTO c")
@Table(name = "car_info")
public class CarDTO {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int carNo;

	@Column(name = "car_name", nullable = false)
	private String carName;
	@Column(name = "status", nullable = false)
	private String status;

	@ManyToMany(targetEntity = ServiceCostDTO.class)
	private List<ServiceCostDTO> cost;

	@OneToOne
	private ServiceAdvisorDTO serviceAdvisor;

	public CarDTO() {

	}

	public CarDTO(String carName, String status) {
		super();
		this.carName = carName;
		this.status = status;
	}

	public CarDTO(int carNo, String carName, String status) {
		this.carNo = carNo;
		this.carName = carName;
		this.status = status;
	}

	public int getCarNo() {
		return carNo;
	}

	public void setCarNo(int carNo) {
		this.carNo = carNo;
	}

	public String getCarName() {
		return carName;
	}

	public void setCarName(String carName) {
		this.carName = carName;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public ServiceAdvisorDTO getServiceAdvisor() {
		return serviceAdvisor;
	}

	public void setServiceAdvisor(ServiceAdvisorDTO serviceAdvisor) {
		this.serviceAdvisor = serviceAdvisor;
	}

	public List<ServiceCostDTO> getCost() {
		return cost;
	}

	public void setCost(List<ServiceCostDTO> cost) {
		this.cost = cost;
	}

}
