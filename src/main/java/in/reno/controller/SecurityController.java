package in.reno.controller;

import javax.servlet.http.HttpSession;

import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SecurityController {

	@PutMapping("AdminSecurity")
	public boolean AdminSecurity(HttpSession session) {
		boolean confirmation = false;
		if (session.getAttribute("IS_LOGGEDIN") != null) {
			confirmation = true;
		}
		return confirmation;
	}

	@PutMapping("saSecurity")
	public int saSecurity(HttpSession session) {
		int id = 0;
		if (session.getAttribute("IS_LOGGEDIN_SA") != null) {
			id = (int) session.getAttribute("IS_LOGGEDIN_SA");
		}
		return id;
	}

	@PutMapping("logOut")
	public boolean logOut(HttpSession session) {
		session.invalidate();
		return true;
	}
}
