package com.onthemoment.practice;

import com.onthemoment.practice.web.HelloController;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


/**
 * @RunWith : SpringRunner 로 실행시키겠다.
 * @WebMvcTest : 스프링 어노테이션중 MVC에 집중 할수있는 어노테이션
 * @Controller, @ControllerAdvice 사용가능
 * 단, @Service, @Component , @Repository 등은 사용불가
 *
 */
@RunWith(SpringRunner.class)
@WebMvcTest(controllers = HelloController.class,secure = false)
public class HelloControllerTest {

    /*
     *  웹 API를 테스트 = 웹에서 요청이 들어온것처럼 테스트
     *  = HTTP GET, POST 등에 대한 API 테스트
     */
    @Autowired
    private MockMvc mvc;

    @Test
    public void sayHello() throws Exception {
        String hello = "hello";

        mvc.perform(get("/hello"))
                .andExpect(status().isOk())
                .andExpect(content().string(hello));

    }
}
