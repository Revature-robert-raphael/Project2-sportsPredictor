package com.revature.models;

import javax.persistence.*;

@Entity
@Table(name = "soccer", schema = "public")
//@NamedQueries({
//        @NamedQuery(
//                name = "getClubById",
//                query = "FROM soccer WHERE id = :id"
//        )
//})
//@NamedNativeQueries({
//        @NamedNativeQuery(
//                name = "getClubByLeague",
//                query = "SELECT * FROM soccer WHERE league = ?"
//        )
//})
public class SoccerClubs {

        private int id;

        private String clubName;

        private String league;

        private double offenseRating;

        private double defenseRating;

        private double spi;

        public SoccerClubs() {
        }

        @Id
        @Column(name = "club_id")
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        public int getId() {
                return id;
        }

        public void setId(int id) {
                this.id = id;
        }

        @Column(name = "club_name")
        public String getClubName() {
                return clubName;
        }

        public void setClubName(String clubName) {
                this.clubName = clubName;
        }

        @Column(name = "league")
        public String getLeague() {
                return league;
        }

        public void setLeague(String league) {
                this.league = league;
        }

        @Column(name = "offense_rating")
        public double getOffenseRating() {
                return offenseRating;
        }

        public void setOffenseRating(double offenseRating) {
                this.offenseRating = offenseRating;
        }

        @Column(name = "defense_rating")
        public double getDefenseRating() {
                return defenseRating;
        }

        public void setDefenseRating(double defenseRating) {
                this.defenseRating = defenseRating;
        }

        @Column(name = "spi")
        public double getSpi() {
                return spi;
        }

        public void setSpi(double spi) {
                this.spi = spi;
        }

        @Override
        public String toString() {
                return "SoccerClubs{" +
                        "id=" + id +
                        ", clubName='" + clubName + '\'' +
                        ", league='" + league + '\'' +
                        ", offenseRating=" + offenseRating +
                        ", defenseRating=" + defenseRating +
                        ", spi=" + spi +
                        '}';
        }
}
