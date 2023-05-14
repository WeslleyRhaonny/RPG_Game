package com.rpg_game.rpg_game;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConectaBanco {
    private Connection conexao;

    public ConectaBanco() throws SQLException {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            this.conexao = DriverManager.getConnection("jdbc:mysql://localhost:3306/contamir4", "root", "Weslley13*");
        } catch (ClassNotFoundException ex) {
            System.out.println("Driver de banco de dados não encontrado");
        }
    }

    public Connection getConexao() {
        return conexao;
    }
}
