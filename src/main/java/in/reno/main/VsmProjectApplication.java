package in.reno.main;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.ComponentScan;

import in.reno.dao.AdminDao;
import in.reno.dao.CarDao;
import in.reno.dao.ServiceAdvisorDAO;
import in.reno.dao.ServiceCostDAO;
import in.reno.model.AdminDTO;
import in.reno.model.CarDTO;
import in.reno.model.ServiceAdvisorDTO;
import in.reno.model.ServiceCostDTO;

@ComponentScan("in.reno.controller")
@ComponentScan("in.reno.service")
@ComponentScan("in.reno.dao")
@EntityScan("in.reno.model")
@SpringBootApplication
public class VsmProjectApplication {

	public static void main(String[] args) {
		ConfigurableApplicationContext allBeans = SpringApplication.run(VsmProjectApplication.class, args);

		AdminDao adminDao = allBeans.getBean(AdminDao.class);
		CarDao carDao = allBeans.getBean(CarDao.class);
		ServiceAdvisorDAO sa = allBeans.getBean(ServiceAdvisorDAO.class);
		ServiceCostDAO sc = allBeans.getBean(ServiceCostDAO.class);

		adminDao.insert(new AdminDTO("admin", "admin"));
		

		carDao.insert(new CarDTO("Hyundai", "pending"));
		carDao.insert(new CarDTO("Suzuki", "pending"));
		carDao.insert(new CarDTO("TVS", "pending"));

		sa.insert(new ServiceAdvisorDTO("micheal", "idle", "prime@123"));
		sa.insert(new ServiceAdvisorDTO("reno", "idle", "prime@123"));
		sa.insert(new ServiceAdvisorDTO("winstone", "idle", "prime@123"));

		
		
		sc.insert(new ServiceCostDTO("Oil change", 100));
		sc.insert(new ServiceCostDTO("Wheel alignment", 200));
		sc.insert(new ServiceCostDTO("engine service", 1000));
		sc.insert(new ServiceCostDTO("water wash", 50));

		carDao.update(1, 1);

	}

}
