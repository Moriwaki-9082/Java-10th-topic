package integrationtest;

import com.Moriwaki.Java10thtopic.Java10thTopicApplication;
import com.github.database.rider.core.api.dataset.DataSet;
import com.github.database.rider.spring.api.DBRider;
import org.junit.jupiter.api.Test;
import org.skyscreamer.jsonassert.JSONAssert;
import org.skyscreamer.jsonassert.JSONCompareMode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.transaction.annotation.Transactional;

import java.nio.charset.StandardCharsets;

@SpringBootTest(classes = Java10thTopicApplication.class)
@AutoConfigureMockMvc
@DBRider
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class FishRestApiIntegrationTest {

    @Autowired
    MockMvc mockMvc;

    @Test
    @DataSet(value = "datasets/fishes.yml")
    @Transactional
    void ユーザーが全件取得できること() throws Exception {
        String response = mockMvc.perform(MockMvcRequestBuilders.get("/fishes"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andReturn().getResponse().getContentAsString(StandardCharsets.UTF_8);
        JSONAssert.assertEquals("[" +
                " {" +
                " \"id\": 1," +
                " \"name\": \"タイ\"," +
                " \"weight\": \"2200g\"," +
                " \"price\": \"￥1400\"" +
                " }," +
                " {" +
                " \"id\": 2," +
                " \"name\": \"カニ\"," +
                " \"weight\": \"500g\"," +
                " \"price\": \"￥10000\"" +
                " }," +
                " {" +
                " \"id\": 3," +
                " \"name\": \"マグロ\"," +
                " \"weight\": \"30000g\"," +
                " \"price\": \"￥93510\"" +
                " }" +
                "]", response, JSONCompareMode.STRICT);
    }

}
