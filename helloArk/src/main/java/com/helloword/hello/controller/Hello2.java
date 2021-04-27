package com.helloword.hello.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/hello2")
public class Hello2 {
	
	@GetMapping
	public String hello() {
		return "Peristência\n"
				+ "Mentalidade de Crescimento\n"
				+ "Orientação ao Futuro\n"
				+ "Comunicação\n"
				+ "Trabalho em Equipe\n"
				+ "Atenção aos Detalhes";
	}

}