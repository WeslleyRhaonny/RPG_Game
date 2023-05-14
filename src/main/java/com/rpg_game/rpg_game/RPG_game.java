package com.rpg_game.rpg_game;

import java.sql.SQLException;
import java.util.Scanner;

public class RPG_game {

    public static void main(String[] args) throws SQLException {
        Scanner input = new Scanner(System.in);
        boolean continua = true;
        MenuEntrada menu = new MenuEntrada();
        
        while (continua) {
            System.out.println("Menu:");
            System.out.println("1 - Criar nova conta");
            System.out.println("2 - Sair");
            System.out.print("Escolha uma opção: ");
            int opcao = input.nextInt();

            switch (opcao) {
                case 1:
                    menu.registro();
                    break;
                case 2:
                    continua = false;
                    System.out.println("Aplicativo encerrado");
                    break;
                default:
                    System.out.println("Opção inválida!");
                    break;
            }
        }
        input.close();
    }
}