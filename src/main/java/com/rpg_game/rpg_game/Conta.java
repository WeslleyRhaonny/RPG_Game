package com.rpg_game.rpg_game;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Conta {
	public String nome;
	public String senha;
	public String email;
    private ConectaBanco banco;

    public Conta() throws SQLException {
        this.banco = new ConectaBanco();
    }

    public void registrar() throws SQLException {
        Connection conexao = banco.getConexao();

        // Crie uma instrução SQL INSERT para inserir os dados na tabela de contas
        String sql = "INSERT INTO usuario (username, email, password) VALUES (?, ?, ?)";
        PreparedStatement statement = conexao.prepareStatement(sql);
        statement.setString(1, this.nome);
        statement.setString(2, this.email);
        statement.setString(3, this.senha);

        // Execute a instrução SQL INSERT
        int linhasAfetadas = statement.executeUpdate();

        // Verifique se a instrução foi executada com sucesso
        if (linhasAfetadas > 0) {
            System.out.println("A conta foi criada com sucesso.");
        } else {
            System.out.println("Erro ao criar a conta.");
        }
    }

 }
