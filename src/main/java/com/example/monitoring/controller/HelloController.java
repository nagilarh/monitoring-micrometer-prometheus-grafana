package com.example.monitoring.controller;

import io.micrometer.core.annotation.Timed;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/test")
public class HelloController {

	@Timed(
			value = "techprimers.hello.request",
			histogram = true,
			percentiles = {0.95,0.99},
			extraTags = {"version", "1.0"}
	)
	@GetMapping("/hello")
	public String hello(){
		return "HELLO FROM DE OTHER SIDE!";
	}

	@Timed(
			value = "techprimers.hellou.request",
			histogram = true,
			percentiles = {0.95,0.99},
			extraTags = {"version", "1.0"}
	)
	@GetMapping("/hellou")
	public String hellou(){
		return "I MUST'VE CALLED A THOUSAND TIMES";
	}
}
