package in.reno.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import in.reno.model.AdminDTO;
import in.reno.service.AdminService;

@RestController
public class AdminController {

	@Autowired
	AdminService adminService;

	@PutMapping("verifyUser")
	public boolean verifyUser(@RequestParam("name") String name, @RequestParam("password") String password,
			HttpSession session) {
		boolean confirmation = false;
		if (adminService.verifyUser(name, password)) {
			session.setAttribute("IS_LOGGEDIN", true);
			confirmation = true;
		} else {
			confirmation = false;
		}
		return confirmation;
	}

	@PutMapping("updateAdminPassword")
	public boolean update(@RequestParam("name") String name, @RequestParam("password") String password,
			@RequestParam("newPassword") String newPassword) {
		return adminService.update(new AdminDTO(name, password), newPassword);
	}

}
