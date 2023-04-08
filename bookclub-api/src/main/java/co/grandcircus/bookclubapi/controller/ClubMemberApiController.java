package co.grandcircus.bookclubapi.controller;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import co.grandcircus.bookclubapi.model.ClubMember;
import co.grandcircus.bookclubapi.repository.ClubMemberRepository;

@RestController
@CrossOrigin // Allow any website to access this API
public class ClubMemberApiController {

	@Autowired
	private ClubMemberRepository repo;
	
	// Status response for root URL path
	@RequestMapping("/")
	public Map<String, Object> home() {
		Map<String, Object> result = new LinkedHashMap<>();
		result.put("status", "OK");
		result.put("collections", new String[] { "/club-members" });
		return result;
	}
	
	// C(R)UD -- Read All
	@GetMapping("/club-members")
	public List<ClubMember> readAll() {
		return repo.findAll();
	}
	
	// C(R)UD -- Read One
	@GetMapping("/club-members/{id}")
	public ClubMember readOne(@PathVariable("id") Long id) {
		return repo.findById(id).orElseThrow(() -> new ClubMemberNotFoundException(id) );
	}
	
	// (C)RUD -- Create
	@PostMapping("/club-members")
	@ResponseStatus(HttpStatus.CREATED)
	public ClubMember create(@RequestBody ClubMember clubMember) {
		repo.save(clubMember);
		return clubMember;
	}
	
	// CRU(D) -- Delete
	@DeleteMapping("/club-members/{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void delete(@PathVariable("id") Long id) {
		repo.deleteById(id);
	}
	
	// CR(U)D -- Update
	@PutMapping("/club-members/{id}")
	public ClubMember update(@PathVariable("id") Long id,
			@RequestBody ClubMember clubMember) {
		clubMember.setId(id);
		return repo.save(clubMember);
	}
	
	@ResponseBody
	@ExceptionHandler(ClubMemberNotFoundException.class)
	@ResponseStatus(HttpStatus.NOT_FOUND)
	String characterNotFoundHandler(ClubMemberNotFoundException ex) {
		return ex.getMessage();
	}
	
}
