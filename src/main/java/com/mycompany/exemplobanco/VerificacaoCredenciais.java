package com.mycompany.exemplobanco;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

public class VerificacaoCredenciais {

    public Boolean verCre(String login, String senha) {
        Conexao conexao = new Conexao();
        JdbcTemplate con = conexao.getConexaoDoBanco();
        
        Boolean verficacaoFinal = false;

        Empresa user = con.queryForObject("IF NOT EXISTS (select idEmpresa from Empresa where idEmpresa = ?)"
                + " BEGIN"
                + " SELECT -9 AS mensagem"
                + " END"
                + " ELSE"
                + " BEGIN"
                + "  select idEmpresa from Empresa where idEmpresa = ? "
                + "END ", new BeanPropertyRowMapper<>(Empresa.class), login, login);
        
        System.out.println("TESTE-------------------");
        System.out.println(user.getIdEmpresa());
        
        Funcionario senhaUser = con.queryForObject("IF NOT EXISTS (select fkEmpresa from Funcionário where Senha = ?)"
                + " BEGIN"
                + "  SELECT 'Erro' AS mensagem"
                + " END"
                + " ELSE"
                + " BEGIN"
                + "  select fkEmpresa from Funcionário where Senha = ? "
                + "END ", new BeanPropertyRowMapper<>(Funcionario.class), senha, senha);
            
                System.out.println("SENHA-------------------");
                System.out.println(senhaUser.getSenha());
                System.out.println(senhaUser.getFkEmpresa());
        
          
        if(senhaUser.getFkEmpresa()!= null){
            if (user.getIdEmpresa().equals(senhaUser.getFkEmpresa())) {
            verficacaoFinal = true;
            }
        } else {
            System.out.println("Está empresa não possui funcionários cadastrados");
        }
        
        return verficacaoFinal;
    }
}
