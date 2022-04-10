package andmebaasid.projekt.controller;


import andmebaasid.projekt.model.LaadimispunktiSeisundiLiik;
import andmebaasid.projekt.repositories.LaadimispunktRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Query;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;


@RestController
@RequestMapping(path = "/")
public class Main {

    private JdbcTemplate jdbc;

    @Autowired
    LaadimispunktRepo laadimispunktRepo;

    @GetMapping(path = "/test")
    public String testConnection() {
        return "Korras!";
    }

    @GetMapping(path = "/data")
    public LaadimispunktiSeisundiLiik testConnectionDatabase() {

        return laadimispunktRepo.findLaadimispunktiSeisundiLiikBylaadimispunkti_seisundi_liik_kood(1);
    }
}
