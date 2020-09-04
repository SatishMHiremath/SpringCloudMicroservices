package com.test.couponservice.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.test.couponservice.model.Coupon;	

@Repository
public interface CouponRepo extends JpaRepository<Coupon, Long> {

	public Coupon findByCode(String couponCode);
	
}
