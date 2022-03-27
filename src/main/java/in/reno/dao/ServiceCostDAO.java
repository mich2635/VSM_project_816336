package in.reno.dao;

import java.util.ArrayList;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import in.reno.model.ServiceCostDTO;

@Repository
@Transactional
public class ServiceCostDAO {

	@Autowired
	EntityManager entityManager;

	/**
	 * This method id used to get all the cost details
	 * 
	 * @return
	 */
	public ArrayList<ServiceCostDTO> getAll() {
		return (ArrayList<ServiceCostDTO>) entityManager.createNamedQuery("select_all_sCost").getResultList();
	}

	/**
	 * This method is used to insert service cost details
	 * 
	 * @param cost
	 * @return
	 */
	public ServiceCostDTO insert(ServiceCostDTO cost) {
		return entityManager.merge(cost);
	}

	/**
	 * This method is used to delete specific service cost details
	 * 
	 * @param id
	 */
	public void delete(int id) {
		ServiceCostDTO costInfo = entityManager.find(ServiceCostDTO.class, id);
		entityManager.remove(costInfo);
	}

	/**
	 * This method is used to update service cost details
	 * 
	 * @param costInfo
	 * @return
	 */
	public ServiceCostDTO update(ServiceCostDTO costInfo) {
		return entityManager.merge(costInfo);
	}

}
