package meow.pasyagitka.findtrainingvideos;

import junit.framework.TestCase;
import meow.pasyagitka.findtrainingvideos.controller.AdminController;
import org.jmock.Mockery;
import org.jmock.Expectations;
import org.jmock.integration.junit4.JUnit4Mockery;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.test.web.servlet.MockMvc;

import static org.hamcrest.core.StringContains.containsString;
import static org.mockito.ArgumentMatchers.contains;
import static org.springframework.test.web.client.match.MockRestRequestMatchers.content;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class ControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void shouldReturnError() throws Exception {
        this.mockMvc.perform(delete("/adminmain/deletevideo/4")).andExpect(status().isInternalServerError());
    }

    @Test
    public void shouldReturnDeleteOk() throws Exception {
        this.mockMvc.perform(delete("/adminmain/deletevideo/12")).andExpect(status().isNoContent());
    }
}
