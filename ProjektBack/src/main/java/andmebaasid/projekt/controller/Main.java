package andmebaasid.projekt.controller;


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

    @GetMapping(path = "/test")
    public String testConnection() {
        return "Korras!";
    }

    @GetMapping(path = "/data")
    public String testConnectionDatabase() {

    }
}
