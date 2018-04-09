package com.springjpa.repo;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.springjpa.model.TourHost;
import com.springjpa.model.TourHostPaymentInfo;

@Repository
public interface TourHostPaymentInfoRepository extends JpaRepository<TourHostPaymentInfo, Integer> {
	public Optional<TourHostPaymentInfo> findById(Integer id);
	public TourHostPaymentInfo findByTourHost(TourHost tourHost);
}
