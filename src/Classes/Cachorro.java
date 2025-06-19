package src.Classes;

import java.util.Date;
import java.text.SimpleDateFormat;
import com.j256.ormlite.table.DatabaseTable;
import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.field.DataType;

@DatabaseTable(tableName = "cachorro")
public class Cachorro
{
    @DatabaseField(generatedId = true)
    private int id;

    @DatabaseField
    private String nome;

    @DatabaseField
    private int idade;

    @DatabaseField
    public double peso;
    @DatabaseField
    private  String alimentacao;
    @DatabaseField
    private String raca;
    @DatabaseField
    private String comportamento;

    public void setIdade(int idade) {
        this.idade = idade;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setAlimentacao(String alimentacao) {
        this.alimentacao = alimentacao;
    }

    public void setComportamento(String comportamento) {
        this.comportamento = comportamento;
    }

    public void setPeso(double peso) {
        this.peso = peso;
    }

    public void setRaca(String raca) {
        this.raca = raca;
    }

    public int getIdade() {
        return idade;
    }

    public String getNome() {
        return nome;
    }

    public double getPeso() {
        return peso;
    }

    public String getAlimentacao() {
        return alimentacao;
    }

    public String getComportamento() {
        return comportamento;
    }

    public String getRaca() {
        return raca;
    }
}
