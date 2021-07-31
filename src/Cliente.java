import java.util.Scanner; //leitura de dados

public class Cliente {
   private String nome;
   private String endereco;
   private String telefone;
    Scanner ler = new Scanner(System.in);
    /*public Cliente(String nome,String endereco,String telefone ){
        this.nome = nome;
        this.endereco = endereco;
        this.telefone = telefone;
    }
    */
    public void cadastro(){
        System.out.println("Qual o nome do cliente:");
        this.nome = ler.nextLine();
        System.out.println("Qual o endereço do cliente:");
        this.endereco = ler.nextLine();
        System.out.println("Qual o telefone do cliente:");
        this.telefone = ler.nextLine();
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }


}
