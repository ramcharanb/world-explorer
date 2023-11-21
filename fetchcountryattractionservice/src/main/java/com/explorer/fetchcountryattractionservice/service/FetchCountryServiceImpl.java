package com.explorer.fetchcountryattractionservice.service;


import com.explorer.fetchcountryattractionservice.exceptions.FetchedCountryAlreadyExistsException;
import com.explorer.fetchcountryattractionservice.exceptions.FetchedCountryNotFoundException;
import com.explorer.fetchcountryattractionservice.model.FetchCountry;
import com.explorer.fetchcountryattractionservice.repository.FetchCountryRepository;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.explorer.fetchcountryattractionservice.exceptions.*;
import com.explorer.fetchcountryattractionservice.model.*;
import com.explorer.fetchcountryattractionservice.repository.*;


@Service
public class FetchCountryServiceImpl implements FetchCountryService {
	
	private FetchCountryRepository fetchedCountryRepo;
	
	@Autowired
	public FetchCountryServiceImpl(final FetchCountryRepository fetchedCountryRepo) {
		this.fetchedCountryRepo=fetchedCountryRepo;
	}

	@Override
	public boolean saveCountry(final FetchCountry country) throws FetchedCountryAlreadyExistsException {
		FetchCountry getCountry=fetchedCountryRepo.findByNameAndUserId(country.getName(),country.getUserId());
		if(getCountry!=null)
		{
			throw new FetchedCountryAlreadyExistsException("Cannot add to your favorites, Country Already Exists!");
		}
		fetchedCountryRepo.save(country);
		return true;
	}
	

	@Override
	public FetchCountry fetchCountry(final FetchCountry country) throws FetchedCountryNotFoundException {
		
		Optional<FetchCountry> getCountry=fetchedCountryRepo.findById(country.getId());
		if(!getCountry.isPresent())
		{
			throw new FetchedCountryNotFoundException("Cannot update your favorites, Country Not Exists!");
		}
		FetchCountry result=getCountry.get();
		fetchedCountryRepo.save(result);
		return result;
	}
	


	@Override
	public List<FetchCountry> getAllCountries(String userId) {
		
		return fetchedCountryRepo.findByUserId(userId);
	}


	@Override
	public FetchCountry getCountryById(final int id) throws FetchedCountryNotFoundException {

		Optional<FetchCountry> getCountry=fetchedCountryRepo.findById(id);
		if(!getCountry.isPresent())
		{
			throw new FetchedCountryNotFoundException("Cannot fetch country from your favorites, Country Not Exists!");
		}
		return getCountry.get();
	}


}
