package com.service;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import com.model.Client;
import com.model.Resources;

@org.springframework.stereotype.Service
public class Service {

	private static final Logger logger = LoggerFactory.getLogger(Service.class);

	@Autowired
	JdbcTemplate jdbcTemplate;

	public Map<String, Object> insertClient(Client client) {
		logger.info("Entered into insertClient method of Service");
		Map<String, Object> response = new HashMap<>();

		int result = 0;
		int id = client.getId();
		String name = client.getClientname();
		String category = client.getCategory();
		String location = client.getLocation();
		String email = client.getEmail();
		String password = client.getPassword();
		String confirmpassword = client.getConfirmpassword();

		try {

			String insertquerry = "insert into client(ID,clientname,category,location,email,password,confirmpassword) values(?,?,?,?,?,?,?)";
			result = jdbcTemplate.update(insertquerry, id, name, category, location, email, password, confirmpassword);
			if (result > 0)
				response.put("message", "Client registered successfully");
			else
				response.put("message", "Oops something went wrong!");

		} catch (Exception e) {

			logger.error("Error has occured in insertClient {}", e.getMessage());
		}

		logger.info("insertClient method ended");
		return response;
	}

	public Map<String, Object> insertResource(Resources resources) {
		logger.info("Entered into insertResource method of Service");
		Map<String, Object> response = new HashMap<>();

		int result = 0;
		int id = resources.getId();
		String name = resources.getName();
		String location = resources.getLocation();
		String email = resources.getCorporateemail();
		String skills = resources.getSkills();
		String status = resources.getStatus();

		try {

			String insertquerry = "insert into Resources(id,corporateemail,name,status,skills) values(?,?,?,?,?)";
			result = jdbcTemplate.update(insertquerry, id, email, name, status, skills);
			if (result > 0)
				response.put("message", "Resources registered successfully");
			else
				response.put("message", "Oops something went wrong!");

		} catch (Exception e) {

			logger.error("Error has occured in insertResource {}", e.getMessage());
		}

		logger.info("insertResource method ended");
		return response;
	}

	public Map<String, Object> getAllClients(Client client) {
		logger.info("Entered into getAllClients method of Service");
		String email = client.getEmail();
		String pwd = client.getPassword();
		List<Map<String, Object>> dataList = new ArrayList<>();
		Map<String, Object> response = new HashMap<>();
		Map<String, Object> dataMap = null;
		try {

			if (!client.getPassword().isEmpty() && client.getPassword() != null && !"".equals(client.getEmail())) {
				String queryString = "SELECT client.clientname, client.email,client.password,Resources.id,Resources.name,Resources.status,Resources.skills FROM client,Resources where client.email=? and  Resources.corporateemail=? ";
				List<Map<String, Object>> searchList = jdbcTemplate.queryForList(queryString, email, email);

				for (Map<String, Object> row : searchList) {
					dataMap = new HashMap<>();
					dataMap.put("clientname", row.get("clientname"));
					dataMap.put("email", row.get("email"));
					dataMap.put("password", row.get("password"));
					dataMap.put("id", row.get("id"));
					dataMap.put("name", row.get("name"));
					dataMap.put("status", row.get("status"));
					dataMap.put("skills", row.get("skills"));
					dataList.add(dataMap);
				}
				response.put("data", dataList);
			}
		} catch (Exception e) {

			logger.error("Error has occured in getAllClients {}", e.getMessage());
		}
		logger.info("getAllClients method ended");
		return response;
	}

	public Map<String, Object> updateClient(Client client) {
		logger.info("Entered into updateClient method of Service");
		int result = 0;
		String category = client.getCategory();
		String location = client.getLocation();
		String pwd = client.getPassword();
		String confirm = client.getConfirmpassword();
		int id = client.getId();
		Map<String, Object> response = new HashMap<String, Object>();
		try {
			String updatequerry = "update client set category=?,location=?,password=?, confirmpassword=? where id=?";
			result = jdbcTemplate.update(updatequerry, category, location, pwd, confirm, id);
			if (result > 0)
				response.put("message", "updated successfully");
			else
				response.put("message", "not updated");
		} catch (Exception e) {
			logger.error("Error has occured in updateClient {}", e.getMessage());
		}
		logger.info("updateClient method ended");
		return response;
	}

	public Map<String, Object> updateResource(Resources resources) {

		logger.info("Entered into updateResource method of Service");
		int result = 0;
		String status = resources.getStatus();
		String skills = resources.getSkills();
		int id = resources.getId();
		Map<String, Object> response = new HashMap<String, Object>();
		try {
			String updatequerry = "update resources set status=?,skills=? where id=?";
			result = jdbcTemplate.update(updatequerry, status, skills, id);
			if (result > 0)
				response.put("message", "updated successfully");
			else
				response.put("message", "not updated");
		} catch (Exception e) {
			logger.error("Error has occured in updateResource{}", e.getMessage());
		}
		logger.info("updateResource method ended");
		return response;
	}

	public Map<String, Object> deleteClient(int id) {
		logger.info("Entered into deleteClient method of Service");
		int result = 0;
		Map<String, Object> response = new HashMap<String, Object>();
		try {
			String deleteQuery = "delete from client where id=?";
			result = jdbcTemplate.update(deleteQuery, id);
			if (result > 0)
				response.put("message", "deleted successfully");
			else
				response.put("message", "not deleted");
		} catch (Exception e) {
			logger.error("Error has occured in deleteClient{}", e.getMessage());
		}
		logger.info("deleteClient method ended");
		return response;
	}

	public Map<String, Object> deleteResource(int id) {
		logger.info("Entered into deleteResource method of Service");
		int result = 0;
		Map<String, Object> response = new HashMap<String, Object>();
		try {
			String deleteQuery = "delete from resources where id=?";
			result = jdbcTemplate.update(deleteQuery, id);
			if (result > 0)
				response.put("message", "deleted successfully");
			else
				response.put("message", "not deleted");
		} catch (Exception e) {
			logger.error("Error has occured in deleteResource{}", e.getMessage());
		}
		logger.info("deleteResource method ended");
		return response;
	}

	public List getAllResources() {
		logger.info("Entered into getAllResources method of Service");
		List response = null;
		try {
			String fetchQuery = "select * from resources";
			response = jdbcTemplate.queryForList(fetchQuery);
		} catch (Exception e) {
			logger.error("Error has occured in getAllResources{}", e.getMessage());
		}
		logger.info("getAllResources method ended");
		return response;
	}

}
