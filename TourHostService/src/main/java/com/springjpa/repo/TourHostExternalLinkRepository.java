package com.springjpa.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.springjpa.model.TourHost;
import com.springjpa.model.TourHostExternalLink;

@Repository
public interface TourHostExternalLinkRepository extends JpaRepository<TourHostExternalLink, Integer> {
	public TourHostExternalLink findById(Integer id);
	public List<TourHostExternalLink> findByTourHost(TourHost tourHost);
	public TourHostExternalLink findByExternalLink(String link);
}
