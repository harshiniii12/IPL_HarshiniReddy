// package com.edutech.progressive.entity;

// import javax.persistence.Column;
// import javax.persistence.Entity;
// import javax.persistence.GeneratedValue;
// import javax.persistence.GenerationType;
// import javax.persistence.Id;
// import javax.persistence.Table;

// import javax.persistence.*;
 
// @Entity
// @Table(name = "cricketer") 
// public class Cricketer implements Comparable<Cricketer> {
 
//     @Id
//     @GeneratedValue(strategy = GenerationType.IDENTITY)
//     @Column(name = "cricketer_id")
//     private int cricketerId;
 
//     @Column(name = "team_id")
//     private int teamId;
 
//     @Column(name = "cricketer_name", nullable = false)
//     private String cricketerName;
 
//     @Column(name = "age")
//     private int age;
 
//     @Column(name = "nationality")
//     private String nationality;
 
//     @Column(name = "experience")
//     private int experience;
 
    
//     @Column(name = "role", length = 50)
//     private String role;
 
//     @Column(name = "total_runs")
//     private int totalRuns;
 
//     @Column(name = "total_wickets")
//     private int totalWickets;
 
    
//     public Cricketer() { }
 
//     // All-args constructor
//     public Cricketer(int cricketerId, int teamId, String cricketerName, int age, String nationality,
//                      int experience, String role, int totalRuns, int totalWickets) {
//         this.cricketerId = cricketerId;
//         this.teamId = teamId;
//         this.cricketerName = cricketerName;
//         this.age = age;
//         this.nationality = nationality;
//         this.experience = experience;
//         this.role = role;
//         this.totalRuns = totalRuns;
//         this.totalWickets = totalWickets;
//     }
 
//     // Getters and setters
//     public int getCricketerId() { return cricketerId; }
//     public void setCricketerId(int cricketerId) { this.cricketerId = cricketerId; }
 
//     public int getTeamId() { return teamId; }
//     public void setTeamId(int teamId) { this.teamId = teamId; }
 
//     public String getCricketerName() { return cricketerName; }
//     public void setCricketerName(String cricketerName) { this.cricketerName = cricketerName; }
 
//     public int getAge() { return age; }
//     public void setAge(int age) { this.age = age; }
 
//     public String getNationality() { return nationality; }
//     public void setNationality(String nationality) { this.nationality = nationality; }
 
//     public int getExperience() { return experience; }
//     public void setExperience(int experience) { this.experience = experience; }
 
//     public String getRole() { return role; }
//     public void setRole(String role) { this.role = role; }
 
//     public int getTotalRuns() { return totalRuns; }
//     public void setTotalRuns(int totalRuns) { this.totalRuns = totalRuns; }
 
//     public int getTotalWickets() { return totalWickets; }
//     public void setTotalWickets(int totalWickets) { this.totalWickets = totalWickets; }
 
//     // Comparable by experience (ascending)
//     @Override
//     public int compareTo(Cricketer other) {
//         return Integer.compare(this.experience, other.experience);
//     }
// }



package com.edutech.progressive.entity;

import javax.persistence.*;

@Entity
@Table(name = "cricketer")
public class Cricketer implements Comparable<Cricketer> {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "cricketer_id")
    private int cricketerId;

    // Association for Day-7
    @ManyToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name = "team_id")
    private Team team;

    @Column(name = "cricketer_name", nullable = false)
    private String cricketerName;

    @Column(name = "age")
    private int age;

    @Column(name = "nationality")
    private String nationality;

    @Column(name = "experience")
    private int experience;

    @Column(name = "role", length = 50)
    private String role;

    @Column(name = "total_runs")
    private int totalRuns;

    @Column(name = "total_wickets")
    private int totalWickets;

    public Cricketer() { }

    // Convenience constructor (works with ID but sets association)
    public Cricketer(int cricketerId, int teamId, String cricketerName, int age, String nationality,
                     int experience, String role, int totalRuns, int totalWickets) {
        this.cricketerId = cricketerId;
        this.cricketerName = cricketerName;
        this.age = age;
        this.nationality = nationality;
        this.experience = experience;
        this.role = role;
        this.totalRuns = totalRuns;
        this.totalWickets = totalWickets;

        Team t = new Team();
        t.setTeamId(teamId);
        this.team = t;
    }

    public int getCricketerId() { return cricketerId; }
    public void setCricketerId(int cricketerId) { this.cricketerId = cricketerId; }

    public Team getTeam() { return team; }
    public void setTeam(Team team) { this.team = team; }

    public String getCricketerName() { return cricketerName; }
    public void setCricketerName(String cricketerName) { this.cricketerName = cricketerName; }

    public int getAge() { return age; }
    public void setAge(int age) { this.age = age; }

    public String getNationality() { return nationality; }
    public void setNationality(String nationality) { this.nationality = nationality; }

    public int getExperience() { return experience; }
    public void setExperience(int experience) { this.experience = experience; }

    public String getRole() { return role; }
    public void setRole(String role) { this.role = role; }

    public int getTotalRuns() { return totalRuns; }
    public void setTotalRuns(int totalRuns) { this.totalRuns = totalRuns; }

    public int getTotalWickets() { return totalWickets; }
    public void setTotalWickets(int totalWickets) { this.totalWickets = totalWickets; }

    // -------- Compatibility layer for old DAO code --------

    /**
     * Old code may call c.getTeamId(). Provide a transient proxy.
     */
    @Transient
    public Integer getTeamId() {
        return (team != null ? team.getTeamId() : null);
    }

    /**
     * Old code may call c.setTeamId(x). Map it to the association.
     */
    @Transient
    public void setTeamId(Integer teamId) {
        if (teamId == null) {
            this.team = null;
        } else {
            if (this.team == null) this.team = new Team();
            this.team.setTeamId(teamId);
        }
    }

    @Override
    public int compareTo(Cricketer other) {
        return Integer.compare(this.experience, other.experience);
    }
}
