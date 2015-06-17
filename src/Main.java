
import DAO.PessoaDAO;
import Model.Pessoa;
import com.mongodb.*;

/**
 *
 * @author maykon
 */
public class Main
{
    public static void main(String[] args)
    {
//        insertTeste();
//        updateTeste();
//        findByTeste();
        deleteTeste();
        findAllTeste();
    }

    static void insertTeste()
    {
        Pessoa pessoa = new Pessoa();
        pessoa.setNome("maykon");
        pessoa.setIdade(34);
        pessoa.setEndereco("Tv Ivar Saldanha");

        PessoaDAO dao = new PessoaDAO();
        dao.insert(pessoa);

    }

    static void findAllTeste()
    {
        PessoaDAO dao = new PessoaDAO();
        DBCursor cursor = dao.findAll();

        while (cursor.hasNext()) {
            System.out.println(cursor.next());
        }
    }

    static void findByTeste()
    {
        PessoaDAO dao = new PessoaDAO();

        BasicDBObject searchQuery = new BasicDBObject();
        searchQuery.put("nome", "maykon");

        Pessoa p = dao.findBy(searchQuery);

        System.out.println(p);

    }

    static void updateTeste()
    {
        PessoaDAO dao = new PessoaDAO();

        BasicDBObject searchQuery = new BasicDBObject();
        searchQuery.put("nome", "maykon");

        Pessoa p = dao.findBy(searchQuery);
        p.setNome("Maykon Deykon");

        dao.update(p);

    }

    static void deleteTeste()
    {
        PessoaDAO dao = new PessoaDAO();

        BasicDBObject searchQuery = new BasicDBObject();
        searchQuery.put("nome", "Maykon Deykon");

        Pessoa p = dao.findBy(searchQuery);

        dao.delete(p);

    }

}
