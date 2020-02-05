package io.mosip.preregistration.booking.service;


import org.springframework.stereotype.Service;

import io.mosip.preregistration.booking.dto.AvailabilityDto;
import io.mosip.preregistration.booking.dto.BookingRequestDTO;
import io.mosip.preregistration.booking.dto.BookingStatus;
import io.mosip.preregistration.booking.dto.BookingStatusDTO;
import io.mosip.preregistration.booking.dto.MultiBookingRequest;
import io.mosip.preregistration.core.common.dto.BookingRegistrationDTO;
import io.mosip.preregistration.core.common.dto.CancelBookingResponseDTO;
import io.mosip.preregistration.core.common.dto.DeleteBookingDTO;
import io.mosip.preregistration.core.common.dto.MainRequestDTO;
import io.mosip.preregistration.core.common.dto.MainResponseDTO;
import io.mosip.preregistration.core.common.dto.PreRegIdsByRegCenterIdResponseDTO;

@Service
public interface BookingServiceIntf {

	/**
	 * Gives the availability details
	 * 
	 * @param regID 
	 * @return ResponseDto<AvailabilityDto>
	 */
	MainResponseDTO<AvailabilityDto> getAvailability(String regID);


	/**
	 * This method will book the appointment.
	 * 
	 * @param bookingRequestDTO
	 * @return response with status code
	 */
	MainResponseDTO<BookingStatusDTO> bookAppointment(MainRequestDTO<BookingRequestDTO> bookingRequestDTOs,
			String preRegistrationId);

	/**
	 * This method will book the multiple appointments.
	 * 
	 * @param multiBookingRequestDTO
	 * @return response with status code
	 */
	MainResponseDTO<BookingStatus> bookMultiAppointment(MainRequestDTO<MultiBookingRequest> bookingRequestDTOs);

	/**
	 * This method is for getting appointment details.
	 * 
	 * @param preRegID
	 * @return MainResponseDTO
	 */
	MainResponseDTO<BookingRegistrationDTO> getAppointmentDetails(String preRegID);

	/**
	 * This method will cancel the appointment.
	 * 
	 * @param MainRequestDTO
	 * @return MainResponseDTO
	 */
	MainResponseDTO<CancelBookingResponseDTO> cancelAppointment(String preRegistrationId);

	/**
	 * This method will cancel the appointment.
	 *
	 * @param MainRequestDTO
	 * @return MainResponseDTO
	 */
	MainResponseDTO<CancelBookingResponseDTO> cancelAppointmentBatch(String preRegistrationId);

	/**
	 * 
	 * This booking API will be called by bookAppointment.
	 * 
	 * @param preRegistrationId
	 * @param bookingRegistrationDTO
	 * @return BookingStatusDTO
	 */
	BookingStatusDTO book(String preRegistrationId, BookingRequestDTO bookingRequestDTO);

	/**
	 * This cancel API will be called by cancelAppointment.
	 * 
	 * @param cancelBookingDTO
	 * @return response with status code
	 */
	CancelBookingResponseDTO cancelBooking(String preRegistrationId, boolean isBatchUser);

	/**
	 * This Method is used to delete the Individual Application and documents
	 * associated with it
	 * 
	 * @param preregId
	 *            pass the preregId of individual
	 * @return response
	 * 
	 */
	MainResponseDTO<DeleteBookingDTO> deleteBooking(String preregId);

	/**
	 * This Method is used to check the slot availability
	 * 
	 * @param bookingRequestDTO
	 *            pass the booking details
	 * 
	 */
	void checkSlotAvailability(BookingRequestDTO bookingRequestDTO);

	/**
	 * This Method is used to delete the old booking
	 * 
	 * @param preId
	 *            pass the PreRegistrationId
	 * 
	 */
	boolean deleteOldBooking(String preId);

	/**
	 * This Method is used to update the availability after cancel of booking
	 * 
	 * @param oldBooking
	 *            pass the old Booking details
	 * 
	 */
	boolean increaseAvailability(BookingRequestDTO oldBooking);

	/**
	 * This method is used to audit all the booking events
	 * 
	 * @param eventId
	 * @param eventName
	 * @param eventType
	 * @param description
	 * @param idType
	 */
	void setAuditValues(String eventId, String eventName, String eventType, String description, String idType,
			String userId, String userName, String ref_id);

	/**
	 * This Method is used to retrieve booked PreIds by date and regCenterId**
	 * 
	 * @param fromDate
	 *            pass fromDate*
	 * @param toDate
	 *            pass toDate*
	 * @param regCenterId        
	 * @return MainResponseDTO<PreRegIdsByRegCenterIdResponseDTO>    
	 ***/

	MainResponseDTO<PreRegIdsByRegCenterIdResponseDTO> getBookedPreRegistrationByDate(String fromDateStr,
			String toDateStr, String regCenterId);

}