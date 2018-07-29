package com.revature.services;

import com.revature.Data.SoccerClubDao;
import com.revature.models.SoccerClubs;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
public class SoccerClubService {

    SoccerClubDao soccerClubDao;

    @Autowired
    public void setSoccerClubDao(SoccerClubDao soccerClubDao){
        this.soccerClubDao = soccerClubDao;
    }

    @Transactional(readOnly = true)
    public List<SoccerClubs> listSoccerClubs(){
        return (ArrayList<SoccerClubs>) soccerClubDao.all();
    }

    @Transactional(readOnly = true)
    public List<SoccerClubs> listSoccerClubsByName(String name){
        return (ArrayList<SoccerClubs>) soccerClubDao.findByName(name);
    }

    @Transactional(readOnly = true)
    public List<SoccerClubs> listSoccerClubsByLeague(String league){
        return (ArrayList<SoccerClubs>) soccerClubDao.findByLeague(league);
    }
}
