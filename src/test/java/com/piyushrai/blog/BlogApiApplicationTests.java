package com.piyushrai.blog;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.piyushrai.blog.repositories.UserRepo;

@SpringBootTest
class BlogApiApplicationTests {
	
	@Autowired
	private UserRepo userRepo;
	
	@Test
	void contextLoads() {
	}
	
	@Test
	public void repoTest() {
	}
	

}
