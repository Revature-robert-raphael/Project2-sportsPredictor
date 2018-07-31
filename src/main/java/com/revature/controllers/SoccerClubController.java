package com.revature.controllers;

import com.revature.models.SoccerClubs;
import com.revature.services.SoccerClubService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;


@Controller
@RequestMapping("/soccer")
@ResponseBody
public class SoccerClubController {

    SoccerClubService service;

    @Autowired
    public void setService(SoccerClubService service){
        this.service = service;
    }

    @GetMapping(path = "/all", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<SoccerClubs>> getAllSoccerClubs(){
        List<SoccerClubs> clubs = service.listSoccerClubs();
        System.out.println();
        return new ResponseEntity<>(clubs, HttpStatus.OK);
    }

    @GetMapping(path = "/club", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<SoccerClubs>> getSoccerClubsByName(@RequestParam("name") String name){
        //"Real Madrid"
        List<SoccerClubs> clubs = service.listSoccerClubsByName(name);
        System.out.println();
        return new ResponseEntity<>(clubs, HttpStatus.OK);
    }

    @GetMapping(path = "/league", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<SoccerClubs>> getSoccerClubsByLeague(@RequestParam("league") String league){
        //"Spanish Primera Division"
        List<SoccerClubs> clubs = service.listSoccerClubsByLeague(league);
        System.out.println();
        return new ResponseEntity<>(clubs, HttpStatus.OK);
    }

}
