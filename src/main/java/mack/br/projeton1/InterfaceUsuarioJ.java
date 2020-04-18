package mack.br.projeton1;

import mack.br.projeton1.entidades.Jogo;
import mack.br.projeton1.persistencia.JogoDAO;

import java.util.List;
import java.util.Scanner;

public class InterfaceUsuarioJ {

    JogoDAO daoJ;
    Scanner in;

    public InterfaceUsuarioJ(JogoDAO daoJ) {
        this.daoJ = daoJ;
        this.in = new Scanner (System.in);
    }

    public void iniciar(){
        imprimirMenu();
    }

    private void imprimirMenu(){
        int opc = 0;

        do{
            System.out.println("\n==============");
            System.out.println("==== Menu ====");
            System.out.println("==============");
            System.out.println("1. Criar Tabela");
            System.out.println("2. Ler Tabela");
            System.out.println("3. Modificar Tabela");
            System.out.println("4. Deletar Tabela");
            System.out.println("5. Sair");
            System.out.print("Escolha uma opção: ");
            opc = in.nextInt();

            in.nextLine();

            switch (opc) {
                case 1:
                    this.createJ();
                    break;
                case 2:
                    this.readJ();
                    break;
                case 3:
                    this.updateJ();
                    break;
                case 4:
                    this.deleteJ();
                    break;
                case 5:
                    System.out.println("tchau :)");
                    break;
                default:
                    System.out.println("Opção Inválida");
                    break;
            }
        }while(opc !=5);

    }
    private void createJ(){
        Jogo jogo = new Jogo();
        System.out.println("\n******************");
        System.out.println("*** Novo Jogo ***");
        System.out.println("******************");

        System.out.println("\nInforme o id do Jogo: ");
        jogo.setIdjogo(in.nextLine());

        System.out.println("\nInforme o nome do Time A: ");
        jogo.setNomeA(in.nextLine());

        System.out.println("\nInforme o nome do time B: ");
        jogo.setNomeB(in.nextLine());

        System.out.println("\nInforme o numero de gols do Time A: ");
        jogo.setGolsA(in.nextInt());

        System.out.println("\nInforme o numero de gols do Time B: ");
        jogo.setGolsB(in.nextInt());

        if(daoJ.create(jogo)){
            System.out.println("Jogo adicionada com sucesso");
        } else{
            System.out.println("Problema ao adicionar jogo ao banco de dados");
        }
    }
    private void readJ(){
        List<Jogo> jogoL = daoJ.read();
        System.out.println("\n***********************************");
        System.out.println("*** Lista de Jogos Cadastrados ***");
        System.out.println("***********************************");
        for(Jogo jogo :  jogoL){
            System.out.println(jogo);
        }
    }
    private void updateJ(){
        List<Jogo> jogoL = daoJ.read();
        while(true){
            System.out.println("\n***********************************");
            System.out.println("*** Lista de Jogos Cadastrados ***");
            System.out.println("***********************************");
            int i =0;
            for(Jogo jogo: jogoL){
                System.out.println("Id: "+i+" - "+ jogo);
                i++;
            }
            System.out.println("ID: "+i+ " - Cancelar operação" );
            System.out.println("Escolha o id do jogo que deseja atualizar. ");
            int opc = in.nextInt();
            in.nextLine();
            if (opc ==i){
                break;
            }
            System.out.print("Informe o novo nome do time A: ");
            jogoL.get(opc).setNomeA(in.nextLine());
            System.out.print("Informe o novo nome do time B: ");
            jogoL.get(opc).setNomeB(in.nextLine());
            System.out.print("Informe o novo numero de gols do time A: ");
            jogoL.get(opc).setGolsA(in.nextInt());
            System.out.print("Informe o novo numero de gols do time B: ");
            jogoL.get(opc).setGolsB(in.nextInt());

            if(opc>= jogoL.size() || opc < 0){
                System.out.println("Esta opção não é válida");
            } else{
                if(daoJ.update(jogoL.get(opc))){
                    System.out.println("Jogo "+ jogoL.get(opc).getIdjogo() +
                            " atualizado com sucesso");
                } else{
                    System.out.println("OPS: falha ao tentar atualizar");
                }
                break;
            }
        }
    }
    private void deleteJ(){
        List<Jogo> jogoL = daoJ.read();
        while(true){
            System.out.println("\n***********************************");
            System.out.println("*** Lista de Jogos Cadastrados ***");
            System.out.println("***********************************");
            int i =0;
            for(Jogo jogo: jogoL){
                System.out.println("ID: "+i+" - "+ jogo);
                i++;
            }
            System.out.println("ID: "+i+ " - Cancelar operação" );
            System.out.println("Digite o ID do jogo que deseja remover");
            int opc = in.nextInt();
            in.nextLine();

            if (opc ==i){
                break;
            }
            if(opc>= jogoL.size() || opc < 0){
                System.out.println("Esta opção não é válida");
            } else{
                if(daoJ.delete(jogoL.get(opc))){
                    System.out.println("Jogo "+ jogoL.get(opc).getIdjogo() +
                            " removido com sucesso");
                } else{
                    System.out.println("OPS: falha ao tentar remover");
                }
                break;
            }
        }
    }
}
