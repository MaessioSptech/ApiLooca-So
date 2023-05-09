
package com.mycompany.exemplobanco;

import org.apache.commons.dbcp2.BasicDataSource;
import org.springframework.jdbc.core.JdbcTemplate;

/**
 *
 * @author Maecio
 */
public class ConexaoMysql {
    private JdbcTemplate conexaoDoBancoMysql;
    system.out.print("Teste 1");
     public ConexaoMysql() {
        BasicDataSource dataSource = new BasicDataSource();
         system.out.print("Teste 2");
        dataSource.setDriverClassName("com.mysql.jdbc.Driver");
         system.out.print("Teste 3");
        dataSource.setUrl("jdbc:mysql://localhost:3306/credencialBd");
        dataSource.setUsername("root");
        dataSource.setPassword("urubu100");
        
        this.conexaoDoBancoMysql = new JdbcTemplate(dataSource);
    }

    //Getters and Setters
    public JdbcTemplate getConexaoDoBanco() {
        return conexaoDoBancoMysql;
    } 
}
