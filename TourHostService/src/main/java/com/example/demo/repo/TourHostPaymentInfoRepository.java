package com.example.demo.repo;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.model.TourHost;
import com.example.demo.model.TourHostPaymentInfo;

@Repository
public interface TourHostPaymentInfoRepository extends JpaRepository<TourHostPaymentInfo, Integer> {
	public Optional<TourHostPaymentInfo> findById(Integer id);
	public TourHostPaymentInfo findByTourHost(TourHost tourHost);
}