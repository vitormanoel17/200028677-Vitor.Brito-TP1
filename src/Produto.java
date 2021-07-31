import java.util.Scanner; //leitura de dados
public class Produto {
    private String nomeProduto;
    private String descricao;
    private float valor;
    private int porcentagem;
    private int estoque;
    Scanner ler = new Scanner(System.in);

    public void cadastroProduto(){
        System.out.println("Qual o nome do Produto:");
        this.nomeProduto = ler.nextLine();
        System.out.println("Qual a descrição do Produto:");
        this.descricao = ler.nextLine();
        System.out.println("Qual o valor do Produto:");
        this.valor = ler.nextInt();
        System.out.println("Qual a porcentagem de lucro do Produto:");
        this.porcentagem = ler.nextInt();
        System.out.println("Qual a quantidade no estoque: ");
        this.estoque = ler.nextInt();
        ler.nextLine();
    }
    public String getNomeProduto() {
        return nomeProduto;
    }
    public void setNomeProduto(String nomeProduto) {
        this.nomeProduto = nomeProduto;
    }
    public String getDescricao() {
        return descricao;
    }
    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }
    public float getValor() {
        return valor;
    }
    public void setValor(float valor) {
        this.valor = valor;
    }
    public int getPorcentagem() {
        return porcentagem;
    }
    public void setPorcentagem(int porcentagem) {
        this.porcentagem = porcentagem;
    }
    public int getEstoque() {
        return estoque;
    }
    public void setEstoque(int estoque) {
        this.estoque = estoque;
    }

}
