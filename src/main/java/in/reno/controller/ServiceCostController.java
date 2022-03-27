package in.reno.controller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import in.reno.model.ServiceCostDTO;
import in.reno.service.ServiceCostService;

@RestController
public class ServiceCostController {

	@Autowired
	ServiceCostService serviceCost;

	@PostMapping("insertCost")
	public ServiceCostDTO insertCost(@RequestParam("name") String name, @RequestParam("cost") int cost) {
		return serviceCost.insert(name, cost);
	}

	@GetMapping("getAllServiceCost")
	public ArrayList<ServiceCostDTO> getAllServiceCost() {

		return serviceCost.getAll();
	}

	@DeleteMapping("deleteCostInfo")
	public boolean delete(@RequestParam("id") int id) {
		return serviceCost.delete(id);
	}

	@PatchMapping("updateCostInfo")
	public ServiceCostDTO updateCostInfo(@RequestParam("id") int id, @RequestParam("name") String name,
			@RequestParam("cost") int cost) {
		return serviceCost.update(new ServiceCostDTO(id, name, cost));
	}

	@PostMapping("submitAllServiceCost")
	public String submitAllServiceCost(@RequestParam("checkedArr[]") Integer[] checkedArr,
			@RequestParam("carNo") int carNo) {
		System.out.println(serviceCost.updateCost(carNo, checkedArr));
		return "Succeeded";
	}

}
