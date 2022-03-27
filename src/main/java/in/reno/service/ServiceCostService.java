package in.reno.service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import in.reno.dao.CarDao;
import in.reno.dao.ServiceCostDAO;
import in.reno.model.CarDTO;
import in.reno.model.ServiceCostDTO;

@Service
public class ServiceCostService {

	@Autowired
	ServiceCostDAO serviceCostDAO;

	@Autowired
	CarDao carDao;

	/**
	 * This method passes the data from the Controller layer to DAO layer for
	 * Inserting purpose
	 * 
	 * @param name
	 * @param cost
	 * @return
	 */
	public ServiceCostDTO insert(String name, int cost) {
		return serviceCostDAO.insert(new ServiceCostDTO(name, cost));
	}

	/**
	 * This method get the all Cost details from the DAO layer and pass it to
	 * controller layer
	 * 
	 * @return
	 */
	public ArrayList<ServiceCostDTO> getAll() {
		return serviceCostDAO.getAll();
	}

	/**
	 * This method passed the data from the controller layer to DAO layer for
	 * Deleting layer
	 * 
	 * @param id
	 * @return
	 */
	public boolean delete(int id) {
		serviceCostDAO.delete(id);
		return true;
	}

	/**
	 * This method passes the data from the controller layer to DAO layer for
	 * updating purpose
	 * 
	 * @param costInfo
	 * @return
	 */
	public ServiceCostDTO update(ServiceCostDTO costInfo) {
		return serviceCostDAO.update(costInfo);
	}

	/**
	 * This method updates all the cost details against the car details one by one
	 * 
	 * @param carId
	 * @param costIds
	 * @return
	 */
	public boolean updateCost(int carId, Integer[] costIds) {

		for (int i = 0; i < costIds.length; i++) {
			carDao.updateCost(carId, costIds[i]);
		}
		return true;
	}
}
