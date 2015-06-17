package DAO;

import Model.Pessoa;
import com.mongodb.BasicDBObject;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.DBCursor;
import com.mongodb.DBObject;
import com.mongodb.MongoClient;
import org.bson.types.ObjectId;

/**
 *
 * @author maykon
 */
public class PessoaDAO
{

    private MongoClient mongo;
    private DB db;
    private DBCollection table;
    private BasicDBObject document;

    public PessoaDAO()
    {
        mongo = new MongoClient("localhost", 27017);
        db = mongo.getDB("pessoa");
        table = db.getCollection("pessoa");
    }

    public void insert(Pessoa p)
    {
        try {
            document = new BasicDBObject();
            document.put("nome", p.getNome());
            document.put("idade", p.getIdade());
            document.put("endereco", p.getEndereco());

            table.insert(document);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

    }

    public DBCursor findAll()
    {
        DBCursor cursor = null;
        try {
            cursor = table.find();
        } catch (Exception e) {
        }

        return cursor;
    }

    public Pessoa findBy(BasicDBObject params)
    {
        Pessoa p = null;
        try {
            DBCursor cursor = table.find(params);

            while (cursor.hasNext()) {
                DBObject doc = cursor.next();

                p = new Pessoa();
                p.setId((ObjectId) doc.get("_id"));
                p.setNome((String) doc.get("nome"));
                p.setIdade((Integer) doc.get("idade"));
                p.setEndereco((String) doc.get("endereco"));
            }

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return p;
    }

    public void update(Pessoa p)
    {
        try {
            BasicDBObject query = new BasicDBObject();
            query.put("_id", p.getId());

            document = new BasicDBObject();
            document.put("nome", p.getNome());
            document.put("idade", p.getIdade());
            document.put("endereco", p.getEndereco());

            table.update(query, document);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public void delete(Pessoa p)
    {
        try {
            BasicDBObject query = new BasicDBObject();
            query.put("_id", p.getId());
            table.remove(query);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

}
