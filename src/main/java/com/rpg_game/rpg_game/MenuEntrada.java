package com.rpg_game.rpg_game;

import java.sql.SQLException;
import java.util.Scanner;

public class MenuEntrada {
	
	Scanner input = new Scanner(System.in);
	
	public void registro() throws SQLException {
		Conta novaConta = new Conta();
		Validadores validador = new Validadores();
		boolean result = false, result2 = false, resultUsuario = true;
        System.out.print("Digite o nome de usuário: ");
        while(resultUsuario == true) {
        	novaConta.nome = input.next();
        	resultUsuario = validador.usuariolJaRegistrado(novaConta.nome);
        	if(resultUsuario == true) {
        		System.out.println("Nome de usuario em uso, escolha outro: ");
        	}
        }
        System.out.print("Digite o e-mail: ");
        while (true) {
            novaConta.email = input.next();
            result = validador.validaEmail(novaConta.email);
            if (!result) {
                System.out.print("Email inválido, digite o e-mail novamente: ");
                continue;
            }
            result2 = validador.emailJaRegistrado(novaConta.email);
            if (result2) {
                System.out.print("E-mail em uso, digite outro e-mail: ");
                continue;
            }
            break;
        }
        System.out.print("Digite a senha: ");
        novaConta.senha = input.next();
        
        novaConta.registrar();
	}
}
