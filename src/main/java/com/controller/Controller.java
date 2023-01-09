package com.controller;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.model.Client;
import com.model.Resources;
import com.service.Service;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/client")
public class Controller {

	@Autowired
	Service service;
	
	@PostMapping("/insertClient")
	public Map<String,Object> insertClient(@RequestBody Client client)
	{
		return service.insertClient(client);
	}
	
	@PostMapping("/insertResource")
	public Map<String,Object> insertResource(@RequestBody Resources resources)
	{
		return service.insertResource(resources);
	}
	@CrossOrigin()
	@PostMapping("/getAllClientResources")
	public Map<String,Object> getAllClients(@RequestBody Client client ){
		return service.getClientresources(client);
	}
	
	@PutMapping("/updateClient")
	public Map<String,Object> updateClient(@RequestBody Client client){
	   return 	service.updateClient(client);
	}
	
	@PutMapping("/updateResource")
	public Map<String,Object> updateResource(@RequestBody Resources resources){
	   return 	service.updateResource(resources);
	}
	
	@DeleteMapping("/deleteClient/{id}")
	public Map<String,Object> deleteClient(@PathVariable int id){
		 return  service.deleteClient(id);
	}
	
	@DeleteMapping("/deleteResource/{id}")
	public Map<String,Object> deleteResource(@PathVariable int id){
		 return  service.deleteResource(id);
	}
	
	@GetMapping("/getAllResources")
	public List getAllResources() {
		return service.getAllResources();
	}
}
