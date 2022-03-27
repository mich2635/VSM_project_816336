package in.reno.dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import in.reno.model.CarDTO;
import in.reno.model.ServiceAdvisorDTO;
import in.reno.model.ServiceCostDTO;

@Repository
@Transactional
public class CarDao {

	@Autowired
	EntityManager entityManager;

	/**
	 * This method is used to insert Car Details
	 * 
	 * @param carInfo
	 * @return
	 */
	public CarDTO insert(CarDTO carInfo) {
		return entityManager.merge(carInfo);

	}

	/**
	 * This method is used to update car Details and also the table which are
	 * related to car tables Details
	 * 
	 * @param carId
	 * @param serviceAdvisorId
	 * @return
	 */
	public CarDTO update(int carId, int serviceAdvisorId) {
		CarDTO carDetail = entityManager.find(CarDTO.class, carId);
		ServiceAdvisorDTO serviceAdvisorInfo = entityManager.find(ServiceAdvisorDTO.class, serviceAdvisorId);
		carDetail.setServiceAdvisor(serviceAdvisorInfo);
		carDetail.setStatus("on progress");
		serviceAdvisorInfo.setStatus("working");
		return carDetail;
	}

	/**
	 * This method is used to delete a specific car Detail
	 * 
	 * @param id
	 */
	public void Delete(int id) {
		CarDTO carInfo = entityManager.find(CarDTO.class, id);
		entityManager.remove(carInfo);
	}

	/**
	 * This method id used to update only the car table, This method wont update the
	 * tables related to the car table
	 * 
	 * @param carInfo
	 * @return
	 */
	public CarDTO updateOnlyCarInfo(CarDTO carInfo) {
		return entityManager.merge(carInfo);
	}

	/**
	 * This method is used to update the car status and Service Advisor status
	 * 
	 * @param saId
	 * @param carId
	 * @return
	 */
	public CarDTO updateStatus(int saId, int carId) {
		CarDTO carInfo = entityManager.find(CarDTO.class, carId);
		ServiceAdvisorDTO saInfo = entityManager.find(ServiceAdvisorDTO.class, saId);
		saInfo.setStatus("idle");
		carInfo.setStatus("Done");
		return carInfo;
	}

	/**
	 * This method is used to get all the details from the database including
	 * service advisor details and service cost details because it is related to car
	 * details
	 * 
	 * @return
	 */
	public ArrayList<CarDTO> selectAll() {
		return (ArrayList<CarDTO>) entityManager.createNamedQuery("select_all").getResultList();
	}

	/**
	 * This method is used to update the cost info the service cost
	 * 
	 * @param carId
	 * @param costId
	 * @return
	 */
	public CarDTO updateCost(int carId, int costId) {
		CarDTO carInfo = entityManager.find(CarDTO.class, carId);
		List<ServiceCostDTO> allCost = carInfo.getCost();
		ServiceCostDTO costInfo = entityManager.find(ServiceCostDTO.class, costId);
		allCost.add(costInfo);
		carInfo.setCost(allCost);
		return carInfo;
	}
}
