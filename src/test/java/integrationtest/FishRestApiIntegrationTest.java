package integrationtest;

import com.moriwaki.java10thtopic.Java10thTopicApplication;
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
                " \"priceInYen\": \"1036\"," +
                " \"inventoryQuantity\": \"5\"" +
                " }," +
                " {" +
                " \"id\": 2," +
                " \"name\": \"カニ\"," +
                " \"priceInYen\": \"1026\"," +
                " \"inventoryQuantity\": \"7\"" +
                " }," +
                " {" +
                " \"id\": 3," +
                " \"name\": \"マグロ\"," +
                " \"priceInYen\": \"4333\"," +
                " \"inventoryQuantity\": \"10\"" +
                " }" +
                "]", response, JSONCompareMode.STRICT);
    }

}
