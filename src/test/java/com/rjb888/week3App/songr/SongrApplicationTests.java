package com.rjb888.week3App.songr;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.hamcrest.CoreMatchers.containsString;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class SongrApplicationTests {

	@Autowired
	MockMvc mockMvc;

	@Test
	public void contextLoads() {
	}

	@Test
	public void test_helloWorldRoute() throws Exception {
		mockMvc.perform(get("/home")).andExpect(content().string(containsString("Hello World")));
	}

	@Test
	public void test_capitalizeRoute() throws Exception {
		mockMvc.perform(get("/capitalize/bob")).andExpect(content().string(containsString("BOB")));
	}

	@Test
	public void test_capitalizeRouteWithSentence() throws Exception {
		mockMvc.perform(get("/capitalize/rats live on no evil star")).andExpect(content().string(containsString("RATS LIVE ON NO EVIL STAR")));
	}

	@Test
	public void test_reverseRoute() throws Exception{
		mockMvc.perform(get("/reverse?phrase=tom jones")).andExpect(content().string(containsString("jones tom")));

	}

}
