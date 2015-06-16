package Model;

import org.bson.types.ObjectId;

/**
 *
 * @author maykon
 */
public class Pessoa
{

    private ObjectId id;

    private String nome;

    private Integer idade;

    private String endereco;

    public ObjectId getId()
    {
        return id;
    }

    public void setId(ObjectId id)
    {
        this.id = id;
    }

    public String getNome()
    {
        return nome;
    }

    public void setNome(String nome)
    {
        this.nome = nome;
    }

    public Integer getIdade()
    {
        return idade;
    }

    public void setIdade(Integer idade)
    {
        this.idade = idade;
    }

    public String getEndereco()
    {
        return endereco;
    }

    public void setEndereco(String endereco)
    {
        this.endereco = endereco;
    }

    @Override
    public String toString()
    {
        return "Pessoa{" + "id=" + id + ", nome=" + nome + ", idade=" + idade + ", endereco=" + endereco + '}';
    }

}
