// package com.edutech.progressive.entity;
// import java.util.Date;

// import javax.persistence.Entity;
// import javax.persistence.GeneratedValue;
// import javax.persistence.GenerationType;
// import javax.persistence.Id;
// import javax.persistence.Table;


// import javax.persistence.*;
// import java.util.Date;
 
// @Entity
// @Table(name = "matches") 
// public class Match {
 
//     @Id
//     @GeneratedValue(strategy = GenerationType.IDENTITY)
//     @Column(name = "match_id")
//     private int matchId;
 
//     @Column(name = "first_team_id", nullable = false)
//     private int firstTeamId;
 
//     @Column(name = "second_team_id", nullable = false)
//     private int secondTeamId;
 
 
//     @Temporal(TemporalType.DATE)
//     @Column(name = "match_date", nullable = false)
//     private Date matchDate;
 
//     @Column(name = "venue")
//     private String venue;
 
//     @Column(name = "result")
//     private String result;
 
   
//     @Column(name = "status")
//     private String status;
 
//     @Column(name = "winner_team_id")
//     private int winnerTeamId;
 
//     public Match() { }
 
//     public Match(int matchId, int firstTeamId, int secondTeamId, Date matchDate,
//                  String venue, String result, String status, int winnerTeamId) {
//         this.matchId = matchId;
//         this.firstTeamId = firstTeamId;
//         this.secondTeamId = secondTeamId;
//         this.matchDate = matchDate;
//         this.venue = venue;
//         this.result = result;
//         this.status = status;
//         this.winnerTeamId = winnerTeamId;
//     }
 
//     public int getMatchId() { return matchId; }
//     public void setMatchId(int matchId) { this.matchId = matchId; }
 
//     public int getFirstTeamId() { return firstTeamId; }
//     public void setFirstTeamId(int firstTeamId) { this.firstTeamId = firstTeamId; }
 
//     public int getSecondTeamId() { return secondTeamId; }
//     public void setSecondTeamId(int secondTeamId) { this.secondTeamId = secondTeamId; }
 
//     public Date getMatchDate() { return matchDate; }
//     public void setMatchDate(Date matchDate) { this.matchDate = matchDate; }
 
//     public String getVenue() { return venue; }
//     public void setVenue(String venue) { this.venue = venue; }
 
//     public String getResult() { return result; }
//     public void setResult(String result) { this.result = result; }
 
//     public String getStatus() { return status; }
//     public void setStatus(String status) { this.status = status; }
 
//     public int getWinnerTeamId() { return winnerTeamId; }
//     public void setWinnerTeamId(int winnerTeamId) { this.winnerTeamId = winnerTeamId; }
// }



package com.edutech.progressive.entity;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "matches")
public class Match {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "match_id")
    private int matchId;

    // Day-7 associations
    @ManyToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name = "first_team_id", nullable = false)
    private Team firstTeam;

    @ManyToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name = "second_team_id", nullable = false)
    private Team secondTeam;

    @Temporal(TemporalType.DATE)
    @Column(name = "match_date", nullable = false)
    private Date matchDate;

    @Column(name = "venue")
    private String venue;

    @Column(name = "result")
    private String result;

    @Column(name = "status")
    private String status;

    @ManyToOne
    @JoinColumn(name = "winner_team_id")
    private Team winnerTeam;

    public Match() { }

    // Convenience constructor using IDs (sets associations)
    public Match(int matchId, int firstTeamId, int secondTeamId, Date matchDate,
                 String venue, String result, String status, Integer winnerTeamId) {
        this.matchId = matchId;
        this.matchDate = matchDate;
        this.venue = venue;
        this.result = result;
        this.status = status;

        Team ft = new Team(); ft.setTeamId(firstTeamId);  this.firstTeam = ft;
        Team st = new Team(); st.setTeamId(secondTeamId); this.secondTeam = st;

        if (winnerTeamId != null) {
            Team wt = new Team(); wt.setTeamId(winnerTeamId); this.winnerTeam = wt;
        } else {
            this.winnerTeam = null;
        }
    }

    public int getMatchId() { return matchId; }
    public void setMatchId(int matchId) { this.matchId = matchId; }

    public Team getFirstTeam() { return firstTeam; }
    public void setFirstTeam(Team firstTeam) { this.firstTeam = firstTeam; }

    public Team getSecondTeam() { return secondTeam; }
    public void setSecondTeam(Team secondTeam) { this.secondTeam = secondTeam; }

    public Date getMatchDate() { return matchDate; }
    public void setMatchDate(Date matchDate) { this.matchDate = matchDate; }

    public String getVenue() { return venue; }
    public void setVenue(String venue) { this.venue = venue; }

    public String getResult() { return result; }
    public void setResult(String result) { this.result = result; }

    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }

    public Team getWinnerTeam() { return winnerTeam; }
    public void setWinnerTeam(Team winnerTeam) { this.winnerTeam = winnerTeam; }

    // -------- Compatibility layer for old DAO code --------

    @Transient
    public Integer getFirstTeamId() {
        return firstTeam != null ? firstTeam.getTeamId() : null;
    }

    @Transient
    public void setFirstTeamId(Integer id) {
        if (id == null) {
            this.firstTeam = null;
        } else {
            if (this.firstTeam == null) this.firstTeam = new Team();
            this.firstTeam.setTeamId(id);
        }
    }

    @Transient
    public Integer getSecondTeamId() {
        return secondTeam != null ? secondTeam.getTeamId() : null;
    }

    @Transient
    public void setSecondTeamId(Integer id) {
        if (id == null) {
            this.secondTeam = null;
        } else {
            if (this.secondTeam == null) this.secondTeam = new Team();
            this.secondTeam.setTeamId(id);
        }
    }

    @Transient
    public Integer getWinnerTeamId() {
        return winnerTeam != null ? winnerTeam.getTeamId() : null;
    }

    @Transient
    public void setWinnerTeamId(Integer id) {
        if (id == null) {
            this.winnerTeam = null;
        } else {
            if (this.winnerTeam == null) this.winnerTeam = new Team();
            this.winnerTeam.setTeamId(id);
        }
    }
}
