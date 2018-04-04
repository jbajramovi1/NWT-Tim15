package com.example.demo.repo;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.model.TourHost;
import com.example.demo.model.TourHostExternalLink;

@Repository
public interface TourHostExternalLinkRepository extends JpaRepository<TourHostExternalLink, Integer> {
	public Optional<TourHostExternalLink> findById(Integer id);
	public List<TourHostExternalLink> findByTourHost(TourHost tourHost);
	public TourHostExternalLink findByExternalLink(String link);
}
