package com.abhinash.flightcheckin.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.abhinash.flightcheckin.integration.ReservationRestClint;
import com.abhinash.flightcheckin.integration.dto.Reservation;
import com.abhinash.flightcheckin.integration.dto.ReservationUpdateRequest;

@Controller
public class CheckinController {
	
	@Autowired
	ReservationRestClint restClint;
	
	@RequestMapping("/showStartCheckin")
	public String showStartCheckIn() {
		return "startCheckIn";
	}

	@RequestMapping("/startCheckIn")
	public String startCheckIn(@RequestParam("reservationId") Long reservationId,ModelMap modelMap) {
		Reservation reservation = restClint.findReservation(reservationId);
		modelMap.addAttribute("reservation", reservation);
		return "displayReservationDetails";
	}
	
	@RequestMapping("/completeCheckIn")
	public String completeCheckIn(@RequestParam("reservationId") Long reservationId,@RequestParam("noOfBags") int noOfBags) {
		ReservationUpdateRequest updateReq = new ReservationUpdateRequest();
		updateReq.setId(reservationId);
		updateReq.setNoOfBags(noOfBags);
		updateReq.setCheckedIn(true);
		restClint.updateReservation(updateReq);
		return "checkInConfirmation";
	}
	
}
