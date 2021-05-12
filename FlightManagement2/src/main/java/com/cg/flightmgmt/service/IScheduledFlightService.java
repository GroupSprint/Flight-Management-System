package com.cg.flightmgmt.service;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import com.cg.flightmgmt.dto.Airport;
import com.cg.flightmgmt.dto.ScheduledFlight;
import com.cg.flightmgmt.exception.FlightScheduleNotFoundException;

//creating scheduled flight service interface
public interface IScheduledFlightService {
	
	public ScheduledFlight addFlightSchedule(ScheduledFlight scheduledFlight);
	public ScheduledFlight viewFlightSchedule(int id) throws FlightScheduleNotFoundException;
	public ScheduledFlight removeFlightSchedule(int id) throws FlightScheduleNotFoundException;
	public ScheduledFlight updateFlightSchedule(ScheduledFlight flight) throws FlightScheduleNotFoundException;
	public List<ScheduledFlight> viewAllScheduledFlights();
	public List<ScheduledFlight> viewAllScheduledFlights(LocalDateTime arrivaldate);
	public List<ScheduledFlight> viewAllScheduledFlightsbyAirport(Airport sAirport, Airport dAirport, LocalDate date);
}
