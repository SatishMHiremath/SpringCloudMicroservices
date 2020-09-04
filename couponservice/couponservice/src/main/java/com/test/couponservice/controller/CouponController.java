package com.test.couponservice.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.test.couponservice.model.Coupon;
import com.test.couponservice.repo.CouponRepo;

@RestController
@RequestMapping("/couponapi")
public class CouponController {
	
	@Autowired
	CouponRepo couponRepo;
	
	@RequestMapping(value="/coupons", method=RequestMethod.POST)
	public Coupon createCoupon(@RequestBody Coupon coupon) {
		return couponRepo.save(coupon);
	}
	
	@RequestMapping(value="/allcoupons", method=RequestMethod.GET)
	public List<Coupon> getAllCoupons() {
		return couponRepo.findAll();
	}
	
	@RequestMapping(value="/coupons/{code}", method=RequestMethod.GET)
	public Coupon getCoupon(@PathVariable("code") String code) {
		System.out.println("Coupon Controller Server 1");
		return couponRepo.findByCode(code);
	}
	
	
	
}
