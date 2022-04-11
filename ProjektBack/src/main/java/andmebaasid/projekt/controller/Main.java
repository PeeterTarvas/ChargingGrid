package andmebaasid.projekt.controller;


import andmebaasid.projekt.repositories.LaadimispunktiSeisundiLiikRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping(path = "/")
public class Main {

    @Autowired
    private LaadimispunktiSeisundiLiikRepository test;


    @GetMapping(path = "/test")
    public String testConnection() {
        return "Korras!";
    }

    @GetMapping(path = "/testConn")
    public Integer testModel() {
        return test.findBylaadimispunkti_seisundi_liik_kood(1);
    }

}
