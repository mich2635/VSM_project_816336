package in.reno.controller;

import java.util.ArrayList;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import in.reno.model.ServiceAdvisorDTO;
import in.reno.service.ServiceAdvisorService;

@RestController
public class ServiceAdvisorController {
	@Autowired
	ServiceAdvisorService serviceAdvisorService;

	@PostMapping("insertSa")
	public ServiceAdvisorDTO insertSa(@RequestParam("name") String name, @RequestParam("password") String password) {
		return serviceAdvisorService.insert(name, "idle", password);
	}

	@GetMapping("getAllSA")
	public ArrayList<ServiceAdvisorDTO> getAll() {
		return serviceAdvisorService.getAll();
	}

	@DeleteMapping("deleteServiceAdvisor")
	public boolean delete(@RequestParam("id") int idSA) {
		return serviceAdvisorService.deleteSA(idSA);
	}

	@PatchMapping("updateSA")
	public ServiceAdvisorDTO updateSA(@RequestParam("id") int id, @RequestParam("name") String name,
			@RequestParam("status") String status) {
		return serviceAdvisorService.update(new ServiceAdvisorDTO(id, name, status));
	}

	@PutMapping("verifySaLogin")
	public boolean verifySaLogin(@RequestParam("id") int id, @RequestParam("password") String password,
			HttpSession session) {

		boolean confirmation = false;
		if (serviceAdvisorService.verifylogin(id, password)) {
			confirmation = true;
			session.setAttribute("IS_LOGGEDIN_SA", id);
		}
		return confirmation;
	}

	@PutMapping("updateSPassword")
	public ServiceAdvisorDTO updateCredentials(@RequestParam("id") int id, @RequestParam("password") String password,
			@RequestParam("newPassword") String newPassword) {

		return serviceAdvisorService.updatePassword(new ServiceAdvisorDTO(id, password), newPassword);
	}
}
