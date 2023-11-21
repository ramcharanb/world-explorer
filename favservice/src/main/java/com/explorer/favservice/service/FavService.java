package com.explorer.favservice.service;


import com.explorer.favservice.exceptions.CountryAlreadyExistsException;
import com.explorer.favservice.exceptions.CountryNotFoundException;
import com.explorer.favservice.model.Country;
import java.util.List;

import com.explorer.favservice.exceptions.*;
import com.explorer.favservice.model.*;

public interface FavService {
	
	public boolean saveFavCountry(final Country country) throws CountryAlreadyExistsException;
	
	
	public boolean deleteFavCountryById(final int id) throws CountryNotFoundException;
	
	public  Country getFavCountryById(final int id) throws CountryNotFoundException;
	
	public List<Country> getAllCountries(String userId);

}
