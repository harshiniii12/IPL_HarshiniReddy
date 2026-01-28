package com.edutech.progressive.service.impl;
 
import com.edutech.progressive.entity.TicketBooking;
import com.edutech.progressive.repository.TicketBookingRepository;
import com.edutech.progressive.service.TicketBookingService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
 
import java.util.List;
 
@Service
public class TicketBookingServiceImpl implements TicketBookingService {
 
    private final TicketBookingRepository repo;
 
    public TicketBookingServiceImpl(TicketBookingRepository repo) {
        this.repo = repo;
    }
 
    @Override
    public List<TicketBooking> getAllTicketBookings() {
        return repo.findAll();
    }
 
    @Override
    @Transactional
    public int createBooking(TicketBooking ticketBooking) {
        // Expecting match to be provided with an existing matchId. No cascade to persist Match.
        TicketBooking saved = repo.save(ticketBooking);
        return saved.getBookingId();
    }
 
    @Override
    @Transactional
    public void cancelBooking(int bookingId) {
        repo.deleteById(bookingId);
    }
 
    @Override
    public List<TicketBooking> getBookingsByUserEmail(String email) {
        return repo.findByEmail(email);
    }
}