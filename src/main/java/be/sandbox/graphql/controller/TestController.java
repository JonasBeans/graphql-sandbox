package be.sandbox.graphql.controller;

import be.sandbox.graphql.service.TestService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("test")
@RestController
@AllArgsConstructor
public class TestController {

    private final TestService testService;

    @PostMapping
    public void makeTestItem() {
        testService.createTestItem();
    }
}
