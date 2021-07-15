package com.raquelheredia.api.netflix.services;

import java.util.List;

import com.raquelheredia.api.netflix.dto.CategoriesRest;
import com.raquelheredia.api.netflix.exceptions.NetflixExceptions;

public interface CategoriesService {

	List<CategoriesRest> findAllCategories() throws NetflixExceptions;

	CategoriesRest findById(Long categoryId) throws NetflixExceptions;
}
