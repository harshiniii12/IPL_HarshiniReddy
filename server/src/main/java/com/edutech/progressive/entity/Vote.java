package com.edutech.progressive.entity;
 
import javax.persistence.*;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
 
@Entity
@Table(name = "vote")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Vote {
 
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "vote_id")
    private Integer voteId;
 
    @Column(name = "email", nullable = false, length = 100)
    private String email;
 
   
    @Column(name = "category", nullable = false, length = 100)
    private String category;
 
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "cricketer_id")
    @JsonIgnore
    private Cricketer cricketer;
 
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "team_id")
    @JsonIgnore
    private Team team;
 
    public Vote() { }
 
    public Vote(Integer voteId, String email, String category, Cricketer cricketer, Team team) {
        this.voteId = voteId;
        this.email = email;
        this.category = category;
        this.cricketer = cricketer;
        this.team = team;
    }
 
    public Integer getVoteId() { return voteId; }
    public void setVoteId(Integer voteId) { this.voteId = voteId; }
 
    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }
 
    public String getCategory() { return category; }
    public void setCategory(String category) { this.category = category; }
 
    public Cricketer getCricketer() { return cricketer; }
    public void setCricketer(Cricketer cricketer) { this.cricketer = cricketer; }
 
    public Team getTeam() { return team; }
    public void setTeam(Team team) { this.team = team; }
}