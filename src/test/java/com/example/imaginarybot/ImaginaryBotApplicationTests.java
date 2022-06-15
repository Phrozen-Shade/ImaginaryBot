package com.example.imaginarybot;

import com.example.imaginarybot.service.ImaginaryBotService;
import static org.assertj.core.api.Assertions.*;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class ImaginaryBotApplicationTests {

    @Autowired
    private ImaginaryBotService service;

    @Test
    void contextLoads() {
        assertThat(service).isNotNull();
    }

}
