package com.abhinash.flightcheckin.integration;

import com.abhinash.flightcheckin.integration.dto.Reservation;
import com.abhinash.flightcheckin.integration.dto.ReservationUpdateRequest;

public interface ReservationRestClint {

	public Reservation findReservation(Long id);

	public Reservation updateReservation(ReservationUpdateRequest request);

}
