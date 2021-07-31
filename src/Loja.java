import java.util.Scanner; //leitura de dados
import java.util.ArrayList;
public class Loja {
    public static void main(String[] args) {
        int escolha;
        int x;  //variavel auxiliar
        int escolhaUser;
        Scanner lerInt = new Scanner(System.in);
        Scanner lerStr = new Scanner(System.in);
        ArrayList <Cliente> listaCliente = new ArrayList<>();
        Cliente cliente = new Cliente();
        ArrayList <Produto> listaProduto = new ArrayList<>();
        Produto produto = new Produto();   
        
        //gerando clientes aleatórios
        for(x = 0;x<10; x++){
            listaCliente.add(new Cliente());
            cliente = listaCliente.get(listaCliente.size()-1);
            cliente.setNome("Cliente " + x);
            cliente.setEndereco("rua " + x*2);
            cliente.setTelefone("5253325123");
        }
        //gerando produtos aleatórios
        for(x = 0;x<10; x++){
            listaProduto.add(new Produto());
            produto = listaProduto.get(listaProduto.size()-1);
            produto.setNomeProduto("Produto "+ x);
            produto.setDescricao("produto genérico "+ x);
            produto.setValor(100+2*x);
            produto.setPorcentagem(1+x);
            produto.setEstoque(3*x);

        }
        do{
            menu();
            escolha = lerInt.nextInt();
            switch(escolha){
                case 1:
                    System.out.println("Quantos clientes deseja cadastrar:");
                    escolhaUser = lerInt.nextInt();
                    for(x = 0;x<escolhaUser; x++){
                        listaCliente.add(new Cliente());
                        cliente = listaCliente.get(listaCliente.size()-1);
                        cliente.cadastro();
                    }
                    break;
                    
                case 2:
                    String buscaNome;               
                    System.out.print("Qual o nome que deseja buscar:");
                    buscaNome = lerStr.nextLine();
                    validaBusca(buscaNome,listaCliente);
                    break;
                case 3:
                    System.out.println("Quantos produtos deseja cadastrar:");
                    escolhaUser = lerInt.nextInt();
                    for(x = 0;x<escolhaUser; x++){
                        listaProduto.add(new Produto());
                        produto = listaProduto.get(listaProduto.size()-1);
                        produto.cadastroProduto();
                    }
                    
                    break;
                case 4:
                    String buscaProduto;
                    System.out.print("Qual o nome do produto que deseja buscar:");
                    buscaProduto = lerStr.nextLine(); 
                    validaBuscaProduto(buscaProduto, listaProduto);
                    break;
                case 5:
                    do{
                        for(Cliente client : listaCliente){
                            System.out.println((listaCliente.indexOf(client)+1) + " - " + client.getNome());
                        }
                        System.out.println("Selecione o Cliente: ");
                        escolhaUser = lerInt.nextInt();
                        if(escolhaUser> listaCliente.size() || escolhaUser<1){
                            System.out.println("Opção inválida tente novamente");
                        }
                    }while(escolhaUser> listaCliente.size() || escolhaUser<1);
                    verificaVenda(listaProduto);
                    break;
                case 6:
                    verificaEstoque(listaProduto);
                    break;
                case 7:
                    System.out.println("Obrigado, Volte Sempre");
                    break;
                default:
                    System.out.println("Opção inválida, tente novamente\n\n");
                    break;
            }
        }while(escolha!= 7);
    }

    static void menu(){
        System.out.println("1 - Cadastro de Cliente \n"+
        "2- Busca por cliente \n" +
        "3- Cadastro de novo produto\n"+
        "4- Busca por produto\n" +
        "5- Cadastro de venda \n"+
        "6- Mostrar Produtos em estoque\n"+ 
        "7-sair ");
    }

    static void validaBusca(String buscaNome, ArrayList<Cliente> listaCliente){
        int altera;
        boolean cadastrado = false;
        Scanner lerStr = new Scanner(System.in);
        for(Cliente cliente: listaCliente){
            if(buscaNome.equals(cliente.getNome())){
                System.out.println("1 - Nome: "+cliente.getNome()+"\n"+"2 - Endereço: "+cliente.getEndereco()+"\n"+"3  - Telefone: "+cliente.getTelefone());
                do{                        
                    System.out.println("Deseja fazer alguma alteração (S/N): ");
                    altera = Character.toUpperCase(lerStr.nextLine().charAt(0));
                    if(altera == 'S'){
                        alteraCliente(cliente);
                    }  
                }while(altera != 'S' && altera!= 'N');
                cadastrado = true;
            }
        }
        if(!cadastrado){
            System.out.println("Cliente não encontrado!\n ");
        }    
    }

    static void validaBuscaProduto(String buscaProduto, ArrayList<Produto> listaProduto){
        int altera;
        boolean cadastrado = false;
        Scanner lerStr = new Scanner(System.in);
        for (Produto produto: listaProduto){
            if(buscaProduto.equals(produto.getNomeProduto())){
                System.out.println("1 - Nome: "+produto.getNomeProduto());
                System.out.println("2 - Descrição: "+produto.getDescricao());
                System.out.println("3 - Valor: "+produto.getValor());
                System.out.println("4 - Porcentagem: "+produto.getPorcentagem());
                System.out.println("5 - Quant. Estoque: "+produto.getEstoque());
                do{                        
                    System.out.println("Deseja fazer alguma alteração (S/N): ");
                    altera = Character.toUpperCase(lerStr.nextLine().charAt(0));
                    if(altera == 'S'){
                        alteraProduto(produto);
                    }  
                }while(altera != 'S' && altera!= 'N');
                cadastrado = true;
            }
        }
        if(!cadastrado){
            System.out.println("Produto não encontrado!\n ");
        }
    }

    //metódo para alterar algum atributo de um cliente
    static void alteraCliente(Cliente cliente){
        int escolha;
        Scanner ler = new Scanner(System.in);
        System.out.println("indique o número do dado que deseja alterar: ");
        escolha = ler.nextInt();
        ler.nextLine();
        switch(escolha){
            case 1:
                String nome;
                System.out.println("Digite o novo nome: ");
                nome = ler.nextLine();
                cliente.setNome(nome);
            break;
            case 2:
                String endereco;
                System.out.println("DIgite o novo endereço: ");
                endereco = ler.nextLine();
                cliente.setEndereco(endereco);
            break;
            case 3:
                String telefone;
                System.out.println("Digite o novo telefone: ");
                telefone = ler.nextLine();
                cliente.setTelefone(telefone);
            break;
            default:
                System.out.println("opção inválida ");
            break;
        }
    }

    //método para alterar algum atributo de um produto
    static void alteraProduto(Produto produto){
        int escolha;
        Scanner ler = new Scanner(System.in);
        System.out.println("indique o número do dado que deseja alterar: ");
        escolha = ler.nextInt();
        ler.nextLine();
        switch(escolha){
            case 1:
                String nome;
                System.out.println("Digite o novo nome do Produto: ");
                nome = ler.nextLine();
                produto.setNomeProduto(nome);
            break;
            case 2:
                String descricao;
                System.out.println("Insira a nova descrição do produto: ");
                descricao = ler.nextLine();
                produto.setDescricao(descricao);
            break;
            case 3:
                int valor;
                System.out.println("insira o novo valor do produto: ");
                valor = ler.nextInt();
                produto.setValor(valor);
            break;
            case 4:
                int porcentagem;
                System.out.println("insira a nova porcentagem de lucro do produto: ");
                porcentagem = ler.nextInt();
                produto.setPorcentagem(porcentagem);  
            case 5: 
                int estoque;
                System.out.println("insira o novo estoque do produto: ");
                estoque = ler.nextInt();
                produto.setEstoque(estoque);
            default:
                System.out.println("opção inválida ");
            break;
        }
    }

    static void verificaVenda(ArrayList<Produto> listaProduto){
        int i;
        int unidade;
        char continuar;
        Produto produto = new Produto();
        Scanner lerStr = new Scanner(System.in);
        Scanner lerInt = new Scanner(System.in);

        if(!listaProduto.isEmpty()){
            do{
                System.out.println("Selecione o Produto: ");
                for( Produto p : listaProduto){
                    System.out.println((listaProduto.indexOf(p)+1) + " - " + p.getNomeProduto());
                }
                i = lerInt.nextInt();
                if(i<= listaProduto.size() && i>0){
                    System.out.println("Quantas unidades foram vendidas para : ");
                    unidade = lerInt.nextInt();
                    i--;
                    produto = listaProduto.get(i);
                    if(produto.getEstoque()>=unidade){
                        produto.setEstoque(produto.getEstoque()-unidade);
                    }else{
                        System.out.println("Não há quantidade suficiente do produto para realizar uma venda deste tamanho!");
                    }
                    do{
                        System.out.println("Deseja cadastrar outra venda: S/N");
                        continuar = Character.toUpperCase(lerStr.nextLine().charAt(0));
                    }while(continuar != 'S' && continuar!= 'N');
                }else{
                    System.out.println("Opção inválida tente novamente");
                    continuar = 'S';
                }
            }while(continuar != 'N');
        }else{
            System.out.println("Nenhum produto cadastrado");
        }
    }

    static void verificaEstoque(ArrayList<Produto> listaProduto){
        if(!listaProduto.isEmpty()){
            System.out.println("--------------ESTOQUE--------------");
            for(Produto P : listaProduto){
                System.out.println("Nome: "+ P.getNomeProduto() +"  | Quantidade em estoque: " + P.getEstoque());
            }
            System.out.println("-----------------------------------\n\n");
        }else{
            System.out.println("Não há produtos cadastrados ainda\n\n");
        }
    }
}
