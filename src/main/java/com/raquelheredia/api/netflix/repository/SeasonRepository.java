package com.raquelheredia.api.netflix.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.raquelheredia.api.netflix.model.Season;

@Repository
public interface SeasonRepository extends JpaRepository <Season, Long> {

}
