package com.brunoaguiar.dscatalog.resources;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.brunoaguiar.dscatalog.dto.CategoryDTO;
import com.brunoaguiar.dscatalog.services.CategoryService;

//use rest controller to make this class a resource 
@RestController
@RequestMapping(value = "/categories")
public class CategoryResource {
	
	//let resource layer access service layer.
	@Autowired
	private CategoryService service;
	@GetMapping
	//create a list with all categories in it!
	public ResponseEntity<List<CategoryDTO>> findAll(){
		List<CategoryDTO> list = service.findAll();
		return ResponseEntity.ok().body(list);
	}	
	@GetMapping(value = "/{id}")
	//create a list with all categories in it!
	public ResponseEntity<CategoryDTO> findById(@PathVariable Long id){
		CategoryDTO dto = service.findById(id);
		//"ok" return http code 200
		return ResponseEntity.ok().body(dto);
	}	
	
	@PostMapping
	public ResponseEntity<CategoryDTO> insert(@RequestBody CategoryDTO dto){
		dto = service.insert(dto);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
		.buildAndExpand(dto.getId()).toUri();
		//created return http code 201
		return ResponseEntity.created(uri).body(dto);

	}
	
	
}
