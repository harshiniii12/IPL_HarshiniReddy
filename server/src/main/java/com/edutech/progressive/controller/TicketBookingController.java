package com.edutech.progressive.controller;

import com.edutech.progressive.entity.TicketBooking;
import com.edutech.progressive.service.TicketBookingService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/ticket")
public class TicketBookingController {

    private final TicketBookingService service;

    public TicketBookingController(TicketBookingService service) {
        this.service = service;
    }

    // GET /ticket  -> Test 44
    @GetMapping
    public ResponseEntity<List<TicketBooking>> getAllBookings() {
        try {
            return ResponseEntity.ok(service.getAllTicketBookings());
        } catch (Exception ex) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @PostMapping
    public ResponseEntity<Integer> createBooking(@RequestBody TicketBooking ticketBooking) {
        try {
            int id = service.createBooking(ticketBooking);
            return ResponseEntity.status(HttpStatus.CREATED).body(id);
        } catch (Exception ex) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

   
    @DeleteMapping("/{bookingId}")
    public ResponseEntity<Void> cancelBooking(@PathVariable int bookingId) {
        try {
            service.cancelBooking(bookingId);
            return ResponseEntity.noContent().build();
        } catch (Exception ex) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @GetMapping("/user/{email}")
    public ResponseEntity<List<TicketBooking>> getBookingsByUserEmail(@PathVariable String email) {
        try {
            return ResponseEntity.ok(service.getBookingsByUserEmail(email));
        } catch (Exception ex) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }
}