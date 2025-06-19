package src.Classes;

import com.j256.ormlite.dao.DaoManager;
import com.j256.ormlite.dao.Dao;
import java.sql.SQLException;
import com.j256.ormlite.table.TableUtils;

import java.util.List;
import java.util.ArrayList;

public class RepositorioCachorro
{
    private static Database database;
    private static Dao<Cachorro, Integer> dao;
    private List<Cachorro> loadedCachorros;
    private Cachorro loadedCachorro;

    public RepositorioCachorro(Database database) {
        RepositorioCachorro.setDatabase(database);
        loadedCachorros = new ArrayList<Cachorro>();
    }

    public static void setDatabase(Database database) {
        RepositorioCachorro.database = database;
        try {
            dao = DaoManager.createDao(database.getConnection(), Cachorro.class);
            TableUtils.createTableIfNotExists(database.getConnection(), Cachorro.class);
        }
        catch(SQLException e) {
            System.out.println(e);
        }
    }

    public Cachorro create(Cachorro cachorro) {
        int nrows = 0;
        try {
            nrows = dao.create(cachorro);
            if ( nrows == 0 )
                throw new SQLException("Error: object not saved");
            this.loadedCachorro = cachorro;
            loadedCachorros.add(cachorro);
        } catch (SQLException e) {
            System.out.println(e);
        }
        return cachorro;
    }

    public void update(Cachorro cachorro) {
        // TODO
    }

    public void delete(Cachorro cachorro) {
        // TODO
    }

    public Cachorro loadFromId(int id) {
        try {
            this.loadedCachorro = dao.queryForId(id);
            if (this.loadedCachorro != null)
                this.loadedCachorros.add(this.loadedCachorro);
        } catch (SQLException e) {
            System.out.println(e);
        }
        return this.loadedCachorro;
    }

    public List<Cachorro> loadAll() {
        try {
            this.loadedCachorros =  dao.queryForAll();
            if (this.loadedCachorros.size() != 0)
                this.loadedCachorro = this.loadedCachorros.get(0);
        } catch (SQLException e) {
            System.out.println(e);
        }
        return this.loadedCachorros;
    }

    // getters and setters ommited...        
}