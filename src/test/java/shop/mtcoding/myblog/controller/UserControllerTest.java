package shop.mtcoding.myblog.controller;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.transaction.annotation.Transactional;

@Transactional
@AutoConfigureMockMvc // 안 적어주면 MockMvc다 DI가 안 된다.
@SpringBootTest(webEnvironment = WebEnvironment.MOCK) // Mock라고 하면 실제환경과 별개로 가짜 환경이 존재한다. 포트도 랜덤으로 뜬다.
public class UserControllerTest {

    @Autowired
    private MockMvc mvc;

    @Test
    public void join_test() throws Exception {
        // given
        String requestBody = "username=carol&password=1234&email=carol@nate.com";

        // when
				// mvc.perform으로 컨트롤러를 때려볼 수 있다. content로 값을 넣으면 타입을 정해주어야 한다. -> content.Type
        ResultActions resultActions = mvc.perform(post("/join").content(requestBody).contentType(MediaType.APPLICATION_FORM_URLENCODED_VALUE));

        // then
        resultActions.andExpect(status().is3xxRedirection());
    }
}