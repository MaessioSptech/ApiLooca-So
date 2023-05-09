package com.github.britooo.looca.api.teste;

import com.github.britooo.looca.api.core.Looca;
import com.github.britooo.looca.api.group.discos.Disco;
import com.github.britooo.looca.api.group.discos.DiscoGrupo;
import com.github.britooo.looca.api.group.memoria.Memoria;
import com.github.britooo.looca.api.group.processador.Processador;
import com.github.britooo.looca.api.group.processos.ProcessoGrupo;
import com.github.britooo.looca.api.group.sistema.Sistema;
import com.github.britooo.looca.api.group.temperatura.Temperatura;
import com.mycompany.exemplobanco.Conexao;
import com.mycompany.exemplobanco.ConexaoMysql;
import com.mycompany.exemplobanco.Empresa;
import com.mycompany.exemplobanco.Totem;

import java.util.List;
import java.util.Timer;
import java.util.TimerTask;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

public class TesteApi {
    
    public TesteApi() {
        initComponents();
    }

    private static void AtualizaDados() {          
        Conexao conexao = new Conexao();
        JdbcTemplate con = conexao.getConexaoDoBanco();
        
        
        
        new Timer().scheduleAtFixedRate(new TimerTask() {
            @Override
            public void run() {
                
                Looca looca = new Looca();
    
    Sistema sistema = new Sistema();
    Memoria memoria = new Memoria();
    Processador processador = new Processador();
    Temperatura temperatura = new Temperatura();
    
                
    Totem tot = con.queryForObject("select fkEmpresa from Totem where NumIdenti = ?", new BeanPropertyRowMapper<>(Totem.class), processador.getId());
    
    con.update("insert into MonitoramentoDeRecursos (UsoDeCpu, UsoDeMemoriaRam, Temperatura, fkTotem, fkEmpresa) values (?, ?, ?, ?, ?)", processador.getUso(), memoria.getEmUso(), temperatura.getTemperatura(), processador.getId(), tot.getFkEmpresa());
    System.out.println("Dados inseridos no banco...");

    System.out.println("Sistema");
    System.out.println("-------------------------------------------------------------------");
    
    System.out.println(sistema);
    System.out.println("-------------------------------------------------------------------");
   
    System.out.println("Memoria");
    System.out.println("-------------------------------------------------------------------");
    System.out.println(memoria);
    System.out.println("-------------------------------------------------------------------");
    
    System.out.println("Processador");
    System.out.println("-------------------------------------------------------------------");
    System.out.println(processador.getUso());
    System.out.println("-------------------------------------------------------------------");
    
    System.out.println("Temperatura");
    System.out.println("-------------------------------------------------------------------");
    System.out.println(temperatura);
    System.out.println("-------------------------------------------------------------------");
//    DiscoGrupo grupoDeDiscos = new DiscoGrupo();
//    System.out.println("Disco Grupos");
//    System.out.println("-------------------------------------------------------------------");
//      System.out.println(grupoDeDiscos);
//    List<Disco> discos = grupoDeDiscos.getDiscos();
//    for (Disco disco : discos) {
//      System.out.println(disco.getBytesDeEscritas());
//      System.out.println(disco.getBytesDeLeitura());
//      System.out.println(disco.getEscritas());
//      System.out.println(disco.getLeituras());
//      System.out.println(disco.getModelo());
//      System.out.println(disco.getNome());
//      System.out.println(disco.getSerial());
//      System.out.println(disco.getTamanho());
//      System.out.println(disco.getTamanhoAtualDaFila());
//      System.out.println(disco.getTamanhoAtualDaFila());
//      System.out.println(disco.getTempoDeTransferencia());
//    } 
//    System.out.println("-------------------------------------------------------------------");
//    System.out.println("Grupo de serviços");
//    System.out.println(looca.getGrupoDeServicos().getServicos());
//    System.out.println("Todos");
//    System.out.println("Ativos:");
//    System.out.println(looca.getGrupoDeServicos().getServicosAtivos());
//    System.out.println("Inativos:");
//    System.out.println(looca.getGrupoDeServicos().getServicosInativos());
//    System.out.println(String.format("Total serviços ativos: %d", looca.getGrupoDeServicos().getTotalServicosAtivos()));
//    System.out.println(String.format("Total serviços inativos: %d", looca.getGrupoDeServicos().getTotalServicosInativos()));
//    System.out.println(String.format("Total serviços: %d", looca.getGrupoDeServicos().getTotalDeServicos()));

//    ProcessoGrupo grupoDeProcessos = new ProcessoGrupo();
//    System.out.println("-------------------------------------------------------------------");
//    System.out.println("Grupo de processos");
//    System.out.println(grupoDeProcessos);
//    System.out.println("-------------------------------------------------------------------");
    
    
//    System.out.println("Rede");
//    System.out.println("-------------------------------------------------------------------");
//    System.out.println("Interfaces");
//    System.out.println(looca.getRede().getGrupoDeInterfaces().getInterfaces());
//    System.out.println(looca.getRede().getParametros().getHostName());
//    System.out.println(looca.getRede().getParametros().getNomeDeDominio());
//    System.out.println(looca.getRede().getParametros().getServidoresDns()); 
    
            } 
        }, 0 , 30000);
    }
    public static void main(String args[]) {
        new Runnable() {
            public void run() {
                new TesteApi().setVisible(true);
            }  
        };
        AtualizaDados();
    }

    private void setVisible(boolean b) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    private void initComponents() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}

