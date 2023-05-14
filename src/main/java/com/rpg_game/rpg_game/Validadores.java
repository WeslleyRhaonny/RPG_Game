package com.rpg_game.rpg_game;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Validadores {
	
	private ConectaBanco banco;
	
	public Validadores() throws SQLException {
        this.banco = new ConectaBanco();
    }
	
	public boolean validaEmail(String email) {
	    String regex = "^[A-Za-z0-9._%+-]+@[A-Za-z0-9.-]+\\.[A-Z]{2,}$";
	    Pattern pattern = Pattern.compile(regex, Pattern.CASE_INSENSITIVE);
	    Matcher matcher = pattern.matcher(email);
	    return matcher.matches();
	}
	
	public boolean emailJaRegistrado(String email) throws SQLException {
	    
		Connection conexao = banco.getConexao();

        // Crie uma instrução SQL INSERT para pesquisar o email no banco de dados
		String sql = "SELECT * FROM usuario WHERE email = ?";
        PreparedStatement statement = conexao.prepareStatement(sql);
        statement.setString(1, email);
	    ResultSet rs = null;
	    rs = statement.executeQuery();
	    return rs.next(); // retorna true se houver resultado

	}
	
public boolean usuariolJaRegistrado(String username) throws SQLException {
	    
		Connection conexao = banco.getConexao();

        // Crie uma instrução SQL INSERT para pesquisar o email no banco de dados
		String sql = "SELECT * FROM usuario WHERE username = ?";
        PreparedStatement statement = conexao.prepareStatement(sql);
        statement.setString(1, username);
	    ResultSet rs = null;
	    rs = statement.executeQuery();
	    return rs.next(); // retorna true se houver resultado

	}

}
