package org.sierou;

import org.sierou.aop.annotation.ControLog;
import org.sierou.aop.service.AopService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.*;

import javax.annotation.PostConstruct;

@SpringBootApplication
@RestController

public class SpringFamilyDemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringFamilyDemoApplication.class, args);
	}

	@Autowired
	private AopService aopService;

	@GetMapping(value = "/hello/{name}")
	@ResponseBody
	public String hello(@PathVariable(value = "name") String name){
		aopService.testControLog("name : " + name);
		return "hello world!" + name;
	}

	@PostConstruct
	void init(){
		System.out.println("**** init spring boot ****");
	}

	@ControLog
	public void annoTest(){
		System.out.println("SpringFamilyDemoApplication.annoTest");
	}
}
