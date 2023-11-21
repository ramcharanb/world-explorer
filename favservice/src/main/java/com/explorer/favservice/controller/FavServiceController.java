package com.explorer.favservice.controller;

import com.explorer.favservice.exceptions.CountryAlreadyExistsException;
import com.explorer.favservice.exceptions.CountryNotFoundException;
import com.explorer.favservice.model.Country;
import com.explorer.favservice.service.FavService;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.explorer.favservice.exceptions.*;
import com.explorer.favservice.model.*;
import com.explorer.favservice.service.*;

import io.jsonwebtoken.Jwts;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@CrossOrigin
@RequestMapping("api/v1/favservice")
@Api(value="worldexplorer", description="For managing CRUD operations for a country database")
public class FavServiceController {
	
	private FavService countryService;
	
	@Autowired
	public FavServiceController(FavService countryService){
		this.countryService=countryService;
	}

	@PostMapping("/countryinfo")
	@ApiOperation(value = "Add a new country")
	public ResponseEntity<?> saveCountry(@RequestBody final Country country,
			final HttpServletRequest request, final HttpServletResponse response){
		ResponseEntity<?> responseEntity;
		
		final String header=request.getHeader("authorization");
		final String token=header.substring(7);
		
		String userId=Jwts.parser().setSigningKey("secretkey").parseClaimsJws(token).getBody().getSubject();
		
		try {
			country.setUserId(userId);
			countryService.saveFavCountry(country);
			responseEntity=new ResponseEntity<String>("Country saved successfully!", HttpStatus.CREATED);
			
		} catch (CountryAlreadyExistsException e) {
			responseEntity=new ResponseEntity<String>("{\"message\" : \""+e.getMessage()+"\"}",HttpStatus.CONFLICT);
		}
		return responseEntity;
	}
	
	
	
	@DeleteMapping("/countryinfo/{id}")
	@ApiOperation(value = "Delete an existing country or throw exception")
	public ResponseEntity<?> deleteCountry(@PathVariable( "id" ) final int id){
		ResponseEntity<?> responseEntity;
		try {
			countryService.deleteFavCountryById(id);
		} catch (CountryNotFoundException e) {
			responseEntity=new ResponseEntity<String>("{\"message\" : \""+e.getMessage()+"\"}", HttpStatus.NOT_FOUND);
		}

		responseEntity=new ResponseEntity<String>("Country deleted successfully", HttpStatus.OK);
		return responseEntity;
	}
	
	@GetMapping("/countryinfo/{id}")
	@ApiOperation(value = "Get country using id")
	public ResponseEntity<?> getCountry(@PathVariable( "id" ) final int id){
		ResponseEntity<?> responseEntity;
		try {
			Country country=countryService.getFavCountryById(id);
			responseEntity=new ResponseEntity<Country>(country, HttpStatus.OK);
		} catch (CountryNotFoundException e) {
			responseEntity=new ResponseEntity<String>("{\"message\" : \""+e.getMessage()+"\"}", HttpStatus.NOT_FOUND);
		}		
		return responseEntity;
	}
	//GetAllCountries... optional 
	@GetMapping("/countryinfo")
	@ApiOperation(value = "Fetch list of all the countries added to a users fav list")
	public ResponseEntity<List<Country>> getAll(final HttpServletRequest request,
			final HttpServletResponse response){
		
		final String header=request.getHeader("authorization");
		final String token=header.substring(7);
		
		String userId=Jwts.parser().setSigningKey("secretkey").parseClaimsJws(token).getBody().getSubject();
		
		return new ResponseEntity<List<Country>>(countryService.getAllCountries(userId),HttpStatus.OK);
	}
}
