package in.reno.controller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import in.reno.model.CarDTO;
import in.reno.service.CarService;

@RestController
public class CarController {

	@Autowired
	CarService carService;

	@PostMapping("insertCar")
	public CarDTO insert(@RequestParam("name") String name) {
		return carService.insert(name, "pending");
	}

	@GetMapping("getAllCarInfo")
	public ArrayList<CarDTO> getAllCarInfo() {
		return carService.getAllCarDetails();
	}

	@DeleteMapping("deleteCar")
	public Boolean deleteCar(@RequestParam("id") int carNo) {
		return carService.deleteCar(carNo);
	}

	@PatchMapping("updateOnlyCarInfo")
	public CarDTO updateOnlyCarInof(@RequestParam("carNo") int id, @RequestParam("carName") String name,
			@RequestParam("status") String status) {
		return carService.updateOnlyCarInfo(new CarDTO(id, name, status));
	}

	@PatchMapping("assignSa")
	public CarDTO assignSa(@RequestParam("carNo") int carNo, @RequestParam("saId") int saId) {
		return carService.update(carNo, saId);
	}

	@PatchMapping("updateStatus")
	public CarDTO updateStatus(@RequestParam("saId") int said, @RequestParam("carId") int carId) {
		return carService.updateStatus(said, carId);
	}
}
