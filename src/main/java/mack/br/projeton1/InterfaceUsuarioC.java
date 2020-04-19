package mack.br.projeton1;
import mack.br.projeton1.entidades.Cidade;
import mack.br.projeton1.persistencia.CidadeDAO;

import java.util.List;
import java.util.Scanner;

public class InterfaceUsuarioC {
    CidadeDAO daoC;
    Scanner in;
    
    public InterfaceUsuarioC(CidadeDAO daoC) {
        this.daoC = daoC;
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
                System.out.println("1. Create");
                System.out.println("2. Read");
                System.out.println("3. Update");
                System.out.println("4. Delete");
                System.out.println("5. Sair");
                System.out.print("Escolha uma opção: ");
                opc = in.nextInt();

                in.nextLine();

                switch (opc) {
                    case 1:
                        this.createC();
                        break;
                    case 2:
                        this.readC();
                        break;
                    case 3:
                        this.updateC();
                        break;
                    case 4:
                        this.deleteC();
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
    private void createC(){
        Cidade cidade = new Cidade();
        System.out.println("\n******************");
        System.out.println("*** Nova Cidade ***");
        System.out.println("******************");
        
        System.out.println("\nInforme o id da Cidade: ");
        cidade.setIdCidade(in.nextLine());
        
        System.out.println("\nInforme o nome da Cidade: ");
        cidade.setNome(in.nextLine());
        
        System.out.println("\nInforme o Estado: ");
        cidade.setEstado(in.nextLine());
        
        System.out.println("\nInforme o País: ");
        cidade.setPais(in.nextLine());
        
        System.out.println("\nInforme a população: ");
        cidade.setPopulacao(in.nextLine());
        
        if(daoC.create(cidade)){
            System.out.println("Cidade adicionada com sucesso");
        } else{
            System.out.println("Problema ao adicionar cidade ao banco de dados");
        }
    }
    private void readC(){
        List<Cidade> cidadeL = daoC.read();
        System.out.println("\n***********************************");
        System.out.println("*** Lista de Cidades Cadastradas ***");
        System.out.println("***********************************");
        for(Cidade cidade :  cidadeL){
            System.out.println(cidade);
        }
    }
    private void updateC(){
        List<Cidade> cidadeL = daoC.read();
        while(true){
        System.out.println("\n***********************************");
        System.out.println("*** Lista de Cidades Cadastradas ***");
        System.out.println("***********************************");
        int i =0;
        for(Cidade cidade: cidadeL){
                System.out.println("Id: "+i+" - "+ cidade);
                i++;
        }
        System.out.println("ID: "+i+ " - Cancelar operação" );
        System.out.println("Escolha o id da Cidade que deseja atualizar. ");
        int opc = in.nextInt();
        in.nextLine();
        if (opc ==i){
                break;
        }
        System.out.print("Informe o novo nome: ");
        cidadeL.get(opc).setNome(in.nextLine());
        
        System.out.print("Informe o novo Estado: ");
        cidadeL.get(opc).setEstado(in.nextLine());
        System.out.print("Informe o novo País: ");
        cidadeL.get(opc).setPais(in.nextLine());
        System.out.print("Informe a nova população: ");
        cidadeL.get(opc).setPopulacao(in.nextLine());
        
        
        if(opc>= cidadeL.size() || opc < 0){
                System.out.println("Esta opção não é válida");
            } else{
                if(daoC.update(cidadeL.get(opc))){
                    System.out.println("Cidade "+ cidadeL.get(opc).getIdCidade() + 
                            " atualizada com sucesso");
                } else{
                    System.out.println("OPS: falha ao tentar atualizar");
                }
                break;
            }
    }
    }
    private void deleteC(){
        List<Cidade> cidadeL = daoC.read();
        while(true){
            System.out.println("\n***********************************");
            System.out.println("*** Lista de Cidades Cadastradas ***");
            System.out.println("***********************************");
            int i =0;
            for(Cidade cidade: cidadeL){
                System.out.println("ID: "+i+" - "+ cidade);
                i++;
            }
            System.out.println("ID: "+i+ " - Cancelar operação" );
            System.out.println("Digite o ID da cidade que deseja remover");
            int opc = in.nextInt();
            in.nextLine();
            
            if (opc ==i){
                break;
            }
            if(opc>= cidadeL.size() || opc < 0){
                System.out.println("Esta opção não é válida");
            } else{
                if(daoC.delete(cidadeL.get(opc))){
                    System.out.println("Cidade "+ cidadeL.get(opc).getIdCidade() + 
                            " removida com sucesso");
                } else{
                    System.out.println("OPS: falha ao tentar remover");
                }
                break;
            }
        }
    }
    
}
