package zadaci;

import com.j256.ormlite.dao.Dao;
import com.j256.ormlite.dao.DaoManager;
import com.j256.ormlite.jdbc.JdbcConnectionSource;
import com.j256.ormlite.support.ConnectionSource;
import com.j256.ormlite.table.TableUtils;
import model.Avion;
import model.Roba;

import java.util.List;


public class Zadatak2DodavanjeVrednosti {
    static Dao<Avion,Integer> avionDao;
    static Dao<Roba,Integer> robaDao;

    public static void main(String[] args) {

        try {
            ConnectionSource connectionSource = new JdbcConnectionSource("jdbc:sqlite:avionRoba.db");
            avionDao= DaoManager.createDao(connectionSource, Avion.class);
            robaDao = DaoManager.createDao(connectionSource, Roba.class);


            TableUtils.clearTable(connectionSource,Avion.class);
            TableUtils.clearTable(connectionSource,Roba.class);


            Avion avion1 = new Avion("Avion1", 34);
            avionDao.create(avion1);

            Avion avion2 = new Avion("Avion2", 21);
            avionDao.create(avion2);


            Roba roba1 = new Roba("Patike","Duboke patike", 1,avion1 );
            robaDao.create(roba1);
            Roba roba2 = new Roba("Kosulja","Na duge rukave", 0,avion1 );
            robaDao.create(roba2);
            Roba roba3 = new Roba("Voda","Voda za pice", 1.4,avion1 );
            robaDao.create(roba3);
            Roba roba4 = new Roba("Ploce","Drvene ploce", 3.4,avion2 );
            robaDao.create(roba4);
            Roba roba5 = new Roba("Stolica","Plasticna stolica", 2.4,avion2 );
            robaDao.create(roba5);

            List<Roba> list = robaDao.queryForAll();
            for (Roba roba:list)
                System.out.println(roba);





        }catch (Exception e) {
            e.printStackTrace();


        }
    }
}
