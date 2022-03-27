package in.reno.service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import in.reno.dao.CarDao;
import in.reno.model.CarDTO;

@Service
public class CarService {

	@Autowired
	CarDao carDao;

	/**
	 * This method get the date that need to inserted from the controller layer and
	 * pass it to the DAO layer for further operations,and pass the return value as
	 * vice versa
	 * 
	 * @param name
	 * @param status
	 * @return
	 */
	public CarDTO insert(String name, String status) {
		return carDao.insert(new CarDTO(name, status));
	}

	/**
	 * This method get all the car details from the dao layer and pass it to the
	 * controller layer
	 * 
	 * @return
	 */
	public ArrayList<CarDTO> getAllCarDetails() {
		return carDao.selectAll();
	}

	/**
	 * This method is pass the car data which need to be deleted from the controller
	 * to DAO for further operation
	 * 
	 * @param id
	 * @return
	 */
	public boolean deleteCar(int id) {
		carDao.Delete(id);
		return true;
	}

	/**
	 * This method is pass the car Data which need to updated from the Controller to
	 * DAO for further operations
	 * 
	 * @param carInfo
	 * @return
	 */
	public CarDTO updateOnlyCarInfo(CarDTO carInfo) {
		return carDao.updateOnlyCarInfo(carInfo);
	}

	/**
	 * this method pass the car data which need to updated to DAo layer from
	 * controller
	 * 
	 * @param carId
	 * @param saId
	 * @return
	 */
	public CarDTO update(int carId, int saId) {
		return carDao.update(carId, saId);
	}

	/**
	 * This method passed the status data which need to be updated to DAO layer from
	 * the controller layer
	 * 
	 * @param saId
	 * @param carId
	 * @return
	 */
	public CarDTO updateStatus(int saId, int carId) {
		return carDao.updateStatus(saId, carId);
	}
}
