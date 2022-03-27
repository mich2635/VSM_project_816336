package in.reno.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import in.reno.dao.AdminDao;
import in.reno.model.AdminDTO;

@Service
public class AdminService {

	@Autowired
	AdminDao adminDao;

	/**
	 * This method passes the data from the controller layer to dAO layer for
	 * credential updating purpose
	 * 
	 * @param adminInfo
	 * @param newPassword
	 * @return
	 */
	public boolean update(AdminDTO adminInfo, String newPassword) {
		boolean confirmation = false;
		try {
			adminDao.update(adminInfo, newPassword);
			confirmation = true;
		} catch (Exception e) {
			confirmation = false;
		}
		return confirmation;
	}

	/**
	 * This method is used to verify weather the credential is correct or not
	 * 
	 * @param id
	 * @param password
	 * @return
	 */
	public boolean verifyUser(String name, String password) {
		boolean confirmation = false;
		try {
			Object user = adminDao.find(name, password);
			if (user.toString().equalsIgnoreCase(name)) {
				confirmation = true;
			}
		} catch (Exception e) {
			confirmation = false;

		}
		return confirmation;
	}
}
