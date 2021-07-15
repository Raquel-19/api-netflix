package com.raquelheredia.api.netflix.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.raquelheredia.api.netflix.model.TVShows;

@Repository
public interface TVShowsRepository extends JpaRepository<TVShows, Long> {

	List<TVShows> findByCategoryId(Long categoryId);

}
