package andmebaasid.projekt.controller;


import andmebaasid.projekt.repositories.TestRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.jdbc.core.JdbcTemplate;


@RestController
@RequestMapping(path = "/")
public class Main {

    @Autowired
    private TestRepo test;


    @GetMapping(path = "/test")
    public String testConnection() {
        return "Korras!";
    }

    @GetMapping(path = "/testConn")
    public TestRepo testModel() {
        return test;
    }

}
