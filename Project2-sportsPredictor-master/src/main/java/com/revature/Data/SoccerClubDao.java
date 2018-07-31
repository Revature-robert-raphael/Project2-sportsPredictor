package com.revature.Data;

import com.revature.models.SoccerClubs;

import java.io.Serializable;
import java.util.Collection;

public interface SoccerClubDao {

    Collection<SoccerClubs> all();
    SoccerClubs find(Serializable id);
    Collection<SoccerClubs> findByName(String name);
    Collection<SoccerClubs> findByLeague(String league);
}
