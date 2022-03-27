package in.reno.dao;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import in.reno.model.AdminDTO;

@Repository
@Transactional
public class AdminDao {

	@Autowired
	EntityManager entityManager;

	/**
	 * This method is used to insert Admin id details
	 * 
	 * @param adminInfo
	 * @return
	 */
	public AdminDTO insert(AdminDTO adminInfo) {
		return entityManager.merge(adminInfo);
	}

	/**
	 * This method updates password
	 * 
	 * @param admin
	 * @param newPassword
	 * @return
	 */
	public AdminDTO update(AdminDTO admin, String newPassword) throws Exception{
		Query query = entityManager.createNativeQuery("SELECT id FROM Admin_info WHERE user_name=? AND password =?");
		query.setParameter(1, admin.getUserName());
		query.setParameter(2, admin.getPassword());
		int id = Integer.parseInt(query.getSingleResult().toString());
		AdminDTO adminInfo = entityManager.find(AdminDTO.class, id);
		adminInfo.setPassword(newPassword);
		return adminInfo;
	}

	/**
	 * This method is used to check weather the user credentials is present or not
	 * 
	 * @param id
	 * @return
	 */
	public Object find(String name, String password) throws Exception {

		Query query = entityManager
				.createNativeQuery("SELECT user_name FROM admin_info WHERE user_name =? AND password =?");
		query.setParameter(1, name);
		query.setParameter(2, password);
		return query.getSingleResult();

	}
}
