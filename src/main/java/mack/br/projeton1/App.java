package mack.br.projeton1;
import mack.br.projeton1.persistencia.CidadeDaoMySQL;
import mack.br.projeton1.persistencia.JogoDaoMySQL;
import java.sql.*;
import java.util.Scanner;
public class App 
{
    public static void main( String[] args ){
        JogoDaoMySQL jmysqlDAO = new JogoDaoMySQL();
        InterfaceUsuarioJ j = new InterfaceUsuarioJ(jmysqlDAO);
        
        CidadeDaoMySQL dmysqlDAO = new CidadeDaoMySQL();
        InterfaceUsuarioC c = new InterfaceUsuarioC(dmysqlDAO);
        boolean end = false;
        while(end == false){
            Scanner input = new Scanner(System.in); 
            
            System.out.println("\n==============");
            System.out.println("==== Menu ====");
            System.out.println("==============");
            System.out.println("1. Manipular Tabela Cidade");
            System.out.println("2. Manipular Tabela Jogo");
            System.out.println("3. Sair");
            System.out.println("Escolha sua opção");
            int x = input.nextInt();
            switch(x){
                case 1:
                    c.iniciar();
                    
                    break;
                case 2:
                    j.iniciar();
                    
                    break;
                case 3:
                    end = true;
                    break;
                default:
                    System.out.println("Opção inválida");
                    break;
            }
            
        }

    }
}
