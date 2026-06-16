package entidades;

// classe para os planos
public class Plano {            // atributos especificos da classe Plano
    private int id;
    private String nomePlano;
    private Double valorMensalidade;
    private Double desconto;
    private String beneficios;
    
    public Plano(int id, String nomePlano, Double valorMensalidade, Double desconto, 
        String beneficios) {

        this.id = id;
        this.nomePlano = nomePlano;
        this.valorMensalidade = valorMensalidade;
        this.desconto = desconto;      // AJUSTADO: Alinhado com a ordem dos parâmetros
        this.beneficios = beneficios;  // AJUSTADO: Alinhado com a ordem dos parâmetros
    }

     // métodos da classe, getters e setters 

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNomePlano() {
        return nomePlano;
    }

    public void setNomePlano(String nomePlano) {
        this.nomePlano = nomePlano;
    }

    public Double getValorMensalidade() {
        return valorMensalidade;
    }

    public void setValorMensalidade(Double valorMensalidade) {
        this.valorMensalidade = valorMensalidade;
    }

    public Double getDesconto() {
        return desconto;
    }

    public void setDesconto(Double desconto) {
        this.desconto = desconto;
    }
    
    public String getBeneficios() {
        return beneficios;
    }

    public void setBeneficios(String beneficios) {
        this.beneficios = beneficios;
    }

     // exibição dos dados do plano
    @Override
    public String toString() {
        return "Plano [id=" + id + ", nomePlano=" + nomePlano + ", valorMensalidade=" + valorMensalidade
                + ", beneficios=" + beneficios + "]";
    } 
}