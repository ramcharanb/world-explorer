package com.explorer.fetchcountryattractionservice.repository;


import com.explorer.fetchcountryattractionservice.model.FetchCountry;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.explorer.fetchcountryattractionservice.model.*;

@Repository
public interface FetchCountryRepository extends JpaRepository<FetchCountry, Integer> {
	
	List<FetchCountry> findByUserId(String userId);
	FetchCountry findByNameAndUserId(String name, String userId);
	//FetchCountry save(FetchCountry result, FetchCountry description);

}
