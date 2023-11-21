package com.explorer.favservice.service;


import com.explorer.favservice.exceptions.CountryAlreadyExistsException;
import com.explorer.favservice.exceptions.CountryNotFoundException;
import com.explorer.favservice.model.Country;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.explorer.favservice.exceptions.*;
import com.explorer.favservice.model.*;
import com.explorer.favservice.repository.*;

@Service

public class FavServiceImpl implements FavService {
	
	private FavServiceRepository countryFavRepository;
	
	@Autowired
	public FavServiceImpl(final FavServiceRepository countryFavRepository) {
		this.countryFavRepository=countryFavRepository;
	}
	


	@Override
	public boolean saveFavCountry(final Country country) throws CountryAlreadyExistsException {
		Country getCountry=countryFavRepository.findByNameAndUserId(country.getName(),country.getUserId());
		if(getCountry!=null)
		{
			throw new CountryAlreadyExistsException("Cannot add to your favorites, Country Already Exists!");
		}
		countryFavRepository.save(country);
		return true;
	}


	@Override
	public boolean deleteFavCountryById(final int id) throws CountryNotFoundException {
		Optional<Country> getCountry=countryFavRepository.findById(id);
		if(!getCountry.isPresent())
		{
			throw new CountryNotFoundException("Cannot delete from your favorites, Country Not Exists!");
		}
		countryFavRepository.deleteById(id);
		return true;
	}
	

	@Override
	public List<Country> getAllCountries(String userId) {
		
		return countryFavRepository.findByUserId(userId);
	}


	@Override
	public Country getFavCountryById(final int id) throws CountryNotFoundException {

		Optional<Country> getCountry=countryFavRepository.findById(id);
		if(!getCountry.isPresent())
		{
			throw new CountryNotFoundException("Cannot fetch country from your favorites, Country Not Exists!");
		}
		return getCountry.get();
	}


}
