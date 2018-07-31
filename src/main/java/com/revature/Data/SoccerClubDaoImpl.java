package com.revature.Data;

import com.revature.models.SoccerClubs;
import org.apache.commons.math3.distribution.PoissonDistribution;
import org.apache.commons.math3.util.Precision;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.io.Serializable;
import java.util.Collection;

@SuppressWarnings("ALL")
@Repository
public class SoccerClubDaoImpl implements SoccerClubDao{

    private SessionFactory sessionFactory;
    private static PoissonDistribution p;
    private static PoissonDistribution q;
    private double team1Attack;
    private double team1defense;

    private double team2Attack;
    private double team2defense;

    private static double p0;
    private static double p1;
    private static double p2;
    private static double p3;
    private static double p4;
    private static double p5;

    private static double q0;
    private static double q1;
    private static double q2;
    private static double q3;
    private static double q4;
    private static double q5;

    //public static PoissonDistribution p = new PoissonDistribution(1.623, 5);

    public static void main(String[] args) {
//        probabilitySetUp("Bayern Munich", "Real Madrid");
        probabilitySetUp(1.623, 0.824);
        System.out.println(winProbability());
        System.out.println(loseProbability());
        System.out.println(tieProbability());
//        SoccerClubDaoImpl d = new SoccerClubDaoImpl();
//        d.findByName("Real Madrid");
    }

    public static void probabilitySetUp(double team1, double team2){
        //SoccerClubDaoImpl dat = new SoccerClubDaoImpl();
//        p = new PoissonDistribution(dat.teamScoreChance(team1, team2), 5);
//        q = new PoissonDistribution(dat.teamScoreChance(team2, team1), 5);

        p = new PoissonDistribution(team1, team2, 5);
        q = new PoissonDistribution(team2, team1, 5);

        p0 = p.probability(0);
        p1 = p.probability(1);
        p2 = p.probability(2);
        p3 = p.probability(3);
        p4 = p.probability(4);
        p5 = p.probability(5);

        q0 = q.probability(0);
        q1 = q.probability(1);
        q2 = q.probability(2);
        q3 = q.probability(3);
        q4 = q.probability(4);
        q5 = q.probability(5);
    }

    public double teamScoreChance(String team1Name, String team2Name){
//        Collection<SoccerClubs> t1 = findByName(team1Name);
//        Collection<SoccerClubs> t2 = findByName(team2Name);
//
//        return t1* t2.getDefenseRating();
        return 0;
    }

    public static double winProbability() {
        //probabilitySetUp(1.623, 0.824);
        double win1 = p1 * q0;
        double win2 = p2 * q0;
        double win3 = p3 * q0;
        double win4 = p4 * q0;
        double win5 = p5 * q0;
        double win6 = p2 * q1;
        double win7 = p3 * q1;
        double win8 = p4 * q1;
        double win9 = p5 * q1;
        double win10 = p3 * q2;
        double win11 = p4 * q2;
        double win12 = p5 * q2;
        double win13 = p4 * q3;
        double win14 = p5 * q3;
        double win15 = p5 * p4;

        return Precision.round((win1 + win2 + win3 + win4 + win5 + win6 + win7 + win8
                + win9 + win10 + win11 + win12 + win13 + win14 + win15) * 100, 2);
    }

    public static double loseProbability() {
        //probabilitySetUp(1.623, 0.824);
        double lose1 = q1 * p0;
        double lose2 = q2 * p0;
        double lose3 = q3 * p0;
        double lose4 = q4 * p0;
        double lose5 = q5 * p0;
        double lose6 = q2 * p1;
        double lose7 = q3 * p1;
        double lose8 = q4 * p1;
        double lose9 = q5 * p1;
        double lose10 = q3 * p2;
        double lose11 = q4 * p2;
        double lose12 = q5 * p2;
        double lose13 = q4 * p3;
        double lose14 = q5 * p3;
        double lose15 = q5 * p4;

        return Precision.round((lose1 + lose2 + lose3 + lose4 + lose5 + lose6 + lose7 + lose8
                + lose9 + lose10 + lose11 + lose12 + lose13 + lose14 + lose15) * 100, 2);
    }

    public static double tieProbability() {
        //probabilitySetUp(1.623, 0.824);
        double tie1 = p0 * q0;
        double tie2 = p1 * q1;
        double tie3 = p2 * q2;
        double tie4 = p3 * q3;
        double tie5 = p4 * q4;
        double tie6 = p5 * q5;

        return Precision.round((tie1 + tie2 + tie3 + tie4 + tie5 + tie6) * 100, 2);
    }

    @Autowired
    public void setSessionFactory(SessionFactory sessionFactory){
        this.sessionFactory = sessionFactory;
    }


    @Override
    public Collection<SoccerClubs> all() {
        String hql = "from SoccerClubs";
        Query query = sessionFactory.getCurrentSession().createQuery(hql);
        return query.list();
    }

    @Override
    public SoccerClubs find(Serializable id) {
        return null;
    }

    @Override
    public Collection<SoccerClubs> findByName(String name) {
        String hql = "from SoccerClubs where clubName = :name";
        Query query = sessionFactory.getCurrentSession().createQuery(hql);
        query.setString("name", name);
        return query.list();
    }

    @Override
    public Collection<SoccerClubs> findByLeague(String league) {
        String hql = "from SoccerClubs where league = :league";
        Query query = sessionFactory.getCurrentSession().createQuery(hql);
        query.setString("league", league);
        return query.list();
    }
}
