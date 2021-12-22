package meow.pasyagitka.findtrainingvideos.integration;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class AdminControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void shouldReturnError() throws Exception {
        this.mockMvc.perform(delete("/adminmain/deletevideo/4")).andExpect(status().isInternalServerError());
    }

    @Test
    public void shouldReturnDeleteOk() throws Exception {
        this.mockMvc.perform(delete("/adminmain/deletevideo/12")).andExpect(status().isInternalServerError());
    }

    @org.junit.Test
    public void accessDeniedTest() throws Exception {
        this.mockMvc.perform(get("/adminmain/load")).andDo(print()).andExpect(status().isForbidden());
    }
}
