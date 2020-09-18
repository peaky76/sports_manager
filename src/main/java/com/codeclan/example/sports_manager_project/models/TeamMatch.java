package com.codeclan.example.sports_manager_project.models;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.hibernate.annotations.Cascade;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "team_matches")
public class TeamMatch {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "team_id_1", referencedColumnName = "id")
    private Team team1;

    @ManyToOne
    @JoinColumn(name = "team_id_2", referencedColumnName = "id")
    private Team team2;

    @Column
    private int score1;

    @Column
    private int score2;

    @ManyToOne
    @JoinColumn(name = "venue_id")
    private Venue venue;

    @OneToMany(mappedBy = "teamMatch", fetch = FetchType.LAZY)
    @Cascade(org.hibernate.annotations.CascadeType.DELETE)
    private List<ScoreEvent> scoreEvents;

    @ManyToOne
    @JoinColumn(name = "tournament_id")
    @JsonIgnoreProperties({"team_matches"})
    private Tournament tournament;


    public TeamMatch(Team team1, Team team2, int score1, int score2, Venue venue, Tournament tournament) {
        this.team1 = team1;
        this.team2 = team2;
        this.score1 = score1;
        this.score2 = score2;
        this.venue = venue;
        this.scoreEvents = new ArrayList<>();
        this.tournament = tournament;
    }

    public TeamMatch() {
    }



    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Team getTeam1() {
        return team1;
    }

    public void setTeam1(Team team1) {
        this.team1 = team1;
    }

    public Team getTeam2() {
        return team2;
    }

    public void setTeam2(Team team2) {
        this.team2 = team2;
    }

    public int getScore1() {
        return score1;
    }

    public void setScore1(int score1) {
        this.score1 = score1;
    }

    public int getScore2() {
        return score2;
    }

    public void setScore2(int score2) {
        this.score2 = score2;
    }

    public Venue getVenue() {
        return venue;
    }

    public void setVenue(Venue venue) {
        this.venue = venue;
    }

    public List<ScoreEvent> getScoreEvents() {
        return scoreEvents;
    }

    public void setScoreEvents(List<ScoreEvent> scoreEvents) {
        this.scoreEvents = scoreEvents;
    }

    public Tournament getTournament() {
        return tournament;
    }

    public void setTournament(Tournament tournament) {
        this.tournament = tournament;
    }
}