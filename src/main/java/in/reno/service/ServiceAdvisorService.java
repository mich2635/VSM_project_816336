package in.reno.service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import in.reno.dao.ServiceAdvisorDAO;
import in.reno.model.ServiceAdvisorDTO;

@Service
public class ServiceAdvisorService {

	@Autowired
	ServiceAdvisorDAO serviceAdvisorDao;

	/**
	 * This method get all the service advisor date from the DAO layer and pass to
	 * the controller layer
	 * 
	 * @return
	 */
	public ArrayList<ServiceAdvisorDTO> getAll() {
		return serviceAdvisorDao.getAll();
	}

	/**
	 * This method pass the SA data that need to be installed to DAO layer from the
	 * controller
	 * 
	 * @param name
	 * @param status
	 * @param password
	 * @return
	 */
	public ServiceAdvisorDTO insert(String name, String status, String password) {
		return serviceAdvisorDao.insert(new ServiceAdvisorDTO(name, status, password));
	}

	/**
	 * This method pass the SA data that need to be delete from the controller to
	 * DAO layer
	 * 
	 * @param id
	 * @return
	 */
	public boolean deleteSA(int id) {
		serviceAdvisorDao.delete(id);
		return true;
	}

	/**
	 * This method is passes the SA data from the Controller to DAO layer for
	 * updating purpose
	 * 
	 * @param saInfo
	 * @return
	 */
	public ServiceAdvisorDTO update(ServiceAdvisorDTO saInfo) {
		return serviceAdvisorDao.update(saInfo);
	}

	/**
	 * This method Verifies the credentials is correct or not
	 * 
	 * @param id
	 * @param password
	 * @return
	 */
	public boolean verifylogin(int id, String password) {
		ServiceAdvisorDTO user = serviceAdvisorDao.find(id);
		boolean confirmation = false;
		if (user != null) {
			if (user.getPassword().equalsIgnoreCase(password)) {
				confirmation = true;
			}
		}
		return confirmation;
	}

	/**
	 * This method updates the password by passing the data from controller layer to
	 * DAO layer
	 * 
	 * @param user
	 * @param password
	 * @return
	 */
	public ServiceAdvisorDTO updatePassword(ServiceAdvisorDTO user, String password) {
		return serviceAdvisorDao.updatePassword(user, password);
	}
}
