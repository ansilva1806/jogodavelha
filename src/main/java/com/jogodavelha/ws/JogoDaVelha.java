package com.jogodavelha.ws;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jogodavelha.bean.Jogo;
import com.jogodavelha.service.JogoDaVelhaService;

@RestController
@RequestMapping("/jogodavelha")
public class JogoDaVelha {

	@Autowired
	private JogoDaVelhaService jogoDaVelhaService;
	
	@GetMapping
	public String validarJogo(@RequestBody Jogo jogo) {
		try {
			String[][] valor = montaMatriz(jogo);
			return jogoDaVelhaService.validarVencedor(valor);
		} catch (Exception ex) {
			return "Erro na validação: " + ex.getMessage();
		}
	}
	
	private String[][] montaMatriz(Jogo jogo) throws Exception {
		String[] split = jogo.getValores().split(";");
		if(split.length < 9 || split.length > 9) {
			throw new Exception("A Matriz tem que ter 9 itens separados por ';'.");
		}
		String[][] valores = {{split[0].trim(), split[1].trim(), split[2].trim()}, {split[3].trim(), split[4].trim(), split[5].trim()}, {split[6].trim(), split[7].trim(), split[8].trim()}};
		return valores;
	}
}
