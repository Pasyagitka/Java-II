package meow.pasyagitka.findtrainingvideos.integration;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.hamcrest.Matchers.containsString;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class GeneralControllerTest {
    @Autowired
    private MockMvc mockMvc;

    @Test
    public void shouldReturnAuthorsOk() throws Exception {
        this.mockMvc.perform(get("/general/getAuthors")).andExpect(status().isForbidden());
    }

    @org.junit.Test
    public void contextLoads() throws Exception {
        this.mockMvc.perform(get("/")).andDo(print()).andExpect(status().isOk()) .andExpect(content().string(containsString("Sign In")));
    }
}
