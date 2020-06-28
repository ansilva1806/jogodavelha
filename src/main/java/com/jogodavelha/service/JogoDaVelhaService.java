package com.jogodavelha.service;

import org.springframework.stereotype.Component;

@Component
public class JogoDaVelhaService {
	
	public String validarVencedor(String[][] jogo) {
		String[] pattern = {"X", "0"};
		for(int i = 0; i < pattern.length; i++) {
			if(validarHorizontal(jogo, pattern[i])) {
				return "Vencedor é " + pattern[i];
			}
			if(validarVertical(jogo, pattern[i])) {
				return "Vencedor é " + pattern[i];
			}
			if(validarDiagonal(jogo, pattern[i])) {
				return "Vencedor é " + pattern[i];
			}
		} 
		return "Não houve vencedor";
	}
	
	private boolean validarHorizontal(String[][] jogo, String pattern) {
		for(int i = 0; i < 3; i++) {
			if((jogo[i][0]).equals(pattern) && (jogo[i][1]).equals(pattern) && (jogo[i][2]).equals(pattern)) {
				return true;
			}
		} 
		return false;
	}

	private boolean validarVertical(String[][] jogo, String pattern) {
		for(int i = 0; i < 3; i++) {
			if((jogo[0][i]).equals(pattern) && (jogo[1][i]).equals(pattern) && (jogo[2][i]).equals(pattern)) {
				return true;
			}
		} 
		return false;
	}

	private boolean validarDiagonal(String[][] jogo, String pattern) {
		if((jogo[0][0]).equals(pattern) && (jogo[1][1]).equals(pattern) && (jogo[2][2]).equals(pattern)) {
			return true;
		}
		if((jogo[0][2]).equals(pattern) && (jogo[1][1]).equals(pattern) && (jogo[2][0]).equals(pattern)) {
			return true;
		}

		return false;
	}

}
