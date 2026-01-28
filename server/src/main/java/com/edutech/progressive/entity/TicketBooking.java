package com.edutech.progressive.entity;
 
import javax.persistence.*;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
 
@Entity
@Table(name = "ticket_booking")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class TicketBooking {
 
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "booking_id")
    private Integer bookingId;
 
    @Column(name = "email", nullable = false, length = 100)
    private String email;
 
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "match_id", nullable = false)
    @JsonIgnore 
    private Match match;
 
    @Column(name = "number_of_tickets", nullable = false)
    private int numberOfTickets;
 
    public TicketBooking() { }
 
    public TicketBooking(Integer bookingId, String email, Match match, int numberOfTickets) {
        this.bookingId = bookingId;
        this.email = email;
        this.match = match;
        this.numberOfTickets = numberOfTickets;
    }
 
    public Integer getBookingId() { return bookingId; }
    public void setBookingId(Integer bookingId) { this.bookingId = bookingId; }
 
    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }
 
    public Match getMatch() { return match; }
    public void setMatch(Match match) { this.match = match; }
 
    public int getNumberOfTickets() { return numberOfTickets; }
    public void setNumberOfTickets(int numberOfTickets) { this.numberOfTickets = numberOfTickets; }
 
    
 
    @JsonProperty("matchId")
    public void setMatchIdForJson(Integer matchId) {
        if (matchId != null) {
            Match m = new Match();
            m.setMatchId(matchId);
            this.match = m;
        }
    }
 
   
    @JsonProperty("matchId")
    public Integer getMatchIdForJson() {
        return (this.match != null ? this.match.getMatchId() : null);
    }
}