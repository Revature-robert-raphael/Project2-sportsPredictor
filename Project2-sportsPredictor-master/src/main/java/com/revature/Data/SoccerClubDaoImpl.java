package com.revature.Data;

import com.revature.models.SoccerClubs;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.io.Serializable;
import java.util.Collection;

@Repository
public class SoccerClubDaoImpl implements SoccerClubDao{

    private SessionFactory sessionFactory;

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
