
import DAO.PessoaDAO;
import Model.Pessoa;
import com.mongodb.*;
import java.util.Date;
import java.util.List;

/**
 *
 * @author maykon
 */
public class Main
{

    private MongoClient mongo;
    private DB db;
    private DBCollection table;

    public static void main(String[] args)
    {
//        insertTeste();
//        updateTeste();
//        findByTeste();

        findAllTeste();
    }

    static void teste()
    {
        MongoClient mongo = new MongoClient("localhost", 27017);

        DB db = mongo.getDB("pessoa");
        DBCollection table = db.getCollection("pessoa");

//	BasicDBObject document = new BasicDBObject();
//	document.put("name", "mkyong");
//	document.put("age", 30);
//	document.put("createdDate", new Date());
//	table.insert(document);
//        BasicDBObject searchQuery = new BasicDBObject();
//	searchQuery.put("name", "mkyong");
        DBCursor cursor = table.find();

        while (cursor.hasNext()) {
            System.out.println(cursor.next());
        }

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

}
