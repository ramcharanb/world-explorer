package com.explorer.fetchcountryattractionservice.controller;


import com.explorer.fetchcountryattractionservice.model.FetchCountry;
import com.explorer.fetchcountryattractionservice.service.FetchCountryService;
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

import com.explorer.fetchcountryattractionservice.exceptions.*;
import com.explorer.fetchcountryattractionservice.model.*;
import com.explorer.fetchcountryattractionservice.service.*;

import io.jsonwebtoken.Jwts;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@CrossOrigin
@RequestMapping("api/v1/fetchservice")
@Api(value="worldexplorer", description="For managing CRUD operations for a country database")
public class FetchCountryController {
	
	private FetchCountryService countryService;
	
	@Autowired
	public FetchCountryController(FetchCountryService countryService){
		this.countryService=countryService;
	}
//	Optional
//	@PostMapping("/countryinfo")
//	@ApiOperation(value = "Fetch country")
//	public ResponseEntity<?> saveCountry(@RequestBody final FetchCountry country,
//			final HttpServletRequest request, final HttpServletResponse response){
//		ResponseEntity<?> responseEntity;
//		
//		final String header=request.getHeader("authorization");
//		final String token=header.substring(7);
//		
//		String userId=Jwts.parser().setSigningKey("secretkey").parseClaimsJws(token).getBody().getSubject();
//		
//		try {
//			country.setUserId(userId);
//			countryService.saveCountry(country);
//			responseEntity=new ResponseEntity<String>("Country saved successfully!", HttpStatus.CREATED);
//			
//		} catch (FetchedCountryAlreadyExistsException e) {
//			responseEntity=new ResponseEntity<String>("{\"message\" : \""+e.getMessage()+"\"}",HttpStatus.CONFLICT);
//		}
//		return responseEntity;
//	}
//	


	@GetMapping("/countryinfo")
	@ApiOperation(value = "Fetch countries in fav list")
	public ResponseEntity<List<FetchCountry>> getAll(final HttpServletRequest request,
			final HttpServletResponse response){
		
		final String header=request.getHeader("authorization");
		final String token=header.substring(7);
		
		String userId=Jwts.parser().setSigningKey("secretkey").parseClaimsJws(token).getBody().getSubject();
		
		return new ResponseEntity<List<FetchCountry>>(countryService.getAllCountries(userId),HttpStatus.OK);
	}
}
