package com.demo.app;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest
@AutoConfigureMockMvc
class MathControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    void testHealth() throws Exception {
        mockMvc.perform(get("/api/health"))
               .andExpect(status().isOk())
               .andExpect(jsonPath("$.status").value("ok"));
    }

    @Test
    void testDemo() throws Exception {
        mockMvc.perform(get("/api/demo"))
               .andExpect(status().isOk())
               .andExpect(jsonPath("$.greet").value("Hello, World!"))
               .andExpect(jsonPath("$.add").value(42));
    }

    @Test
    void testAdd() throws Exception {
        mockMvc.perform(get("/api/add?a=3&b=4"))
               .andExpect(status().isOk())
               .andExpect(jsonPath("$.result").value(7));
    }
}
