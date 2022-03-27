package in.reno.dao;

import java.util.ArrayList;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import in.reno.model.ServiceAdvisorDTO;

@Repository
@Transactional
public class ServiceAdvisorDAO {

	@Autowired
	EntityManager entityManager;

	/**
	 * This method is used to insert Service advisor details
	 * 
	 * @param serviceAdvisor
	 * @return
	 */
	public ServiceAdvisorDTO insert(ServiceAdvisorDTO serviceAdvisor) {
		return entityManager.merge(serviceAdvisor);
	}

	/**
	 * This method is used to get all the service advisor details
	 * 
	 * @return
	 */
	public ArrayList<ServiceAdvisorDTO> getAll() {
		return (ArrayList<ServiceAdvisorDTO>) entityManager.createNamedQuery("select_all_SA").getResultList();
	}

	/**
	 * This method is used to delete the service advisor details
	 * 
	 * @param id
	 */
	public void delete(int id) {
		ServiceAdvisorDTO SAInfo = entityManager.find(ServiceAdvisorDTO.class, id);
		entityManager.remove(SAInfo);
	}

	/**
	 * This method is used to update service advisor detail
	 * 
	 * @param SAInfo
	 * @return
	 */
	public ServiceAdvisorDTO update(ServiceAdvisorDTO SAInfo) {
		return entityManager.merge(SAInfo);

	}

	/**
	 * This method is used to find the specific Service advisor detail
	 * 
	 * @param id
	 * @return
	 */
	public ServiceAdvisorDTO find(int id) {
		return entityManager.find(ServiceAdvisorDTO.class, id);

	}

	/**
	 * This method updates the password
	 * 
	 * @param user
	 * @param newPaword
	 * @return
	 */
	public ServiceAdvisorDTO updatePassword(ServiceAdvisorDTO user, String newPaword) {
		Query query = entityManager.createNativeQuery("SELECT  id FROM service_advisor WHERE name=? AND password =?");
		query.setParameter(1, user.getName());
		query.setParameter(2, user.getPassword());
		Object info = query.getSingleResult();
		ServiceAdvisorDTO userInfo = entityManager.find(ServiceAdvisorDTO.class, Integer.parseInt(info.toString()));
		userInfo.setPassword(newPaword);
		return userInfo;
	}
}
