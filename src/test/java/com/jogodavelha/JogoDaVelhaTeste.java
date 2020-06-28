package com.jogodavelha;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.jogodavelha.service.JogoDaVelhaService;

@SpringBootTest
public class JogoDaVelhaTeste {

	@Autowired
	private JogoDaVelhaService jogoDaVelhaService;

	@Test
	public void validarVencedor() throws Exception {
		String vencedor = jogoDaVelhaService.validarVencedor(montaMock());
		Assertions.assertEquals("Vencedor é 0", vencedor);
	}

	private String[][] montaMock() {
		String[][] valores = {{"X", "X", "0"}, {"0", "X", "0"}, {"X", "0", "X"}};
		return valores;
	}
}
