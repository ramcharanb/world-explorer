package com.explorer.fetchcountryattractionservice.service;


import com.explorer.fetchcountryattractionservice.exceptions.FetchedCountryAlreadyExistsException;
import com.explorer.fetchcountryattractionservice.exceptions.FetchedCountryNotFoundException;
import com.explorer.fetchcountryattractionservice.model.FetchCountry;
import java.util.List;

import com.explorer.fetchcountryattractionservice.exceptions.*;
import com.explorer.fetchcountryattractionservice.model.*;

public interface FetchCountryService {
	
	public boolean saveCountry(final FetchCountry country) throws FetchedCountryAlreadyExistsException;
	
	public FetchCountry fetchCountry(final FetchCountry country) throws FetchedCountryNotFoundException;
	
	
	public  FetchCountry getCountryById(final int id) throws FetchedCountryNotFoundException;
	
	public List<FetchCountry> getAllCountries(String userId);

}
