package zadaci;

import com.j256.ormlite.dao.Dao;
import com.j256.ormlite.dao.DaoManager;
import com.j256.ormlite.support.ConnectionSource;
import model.Avion;
import model.Roba;

public class Zadatak2DodavanjeVrednosti {
    static Dao<Avion,Integer> avionDao;
    static Dao<Roba,Integer> robaDao;

    public static void main(String[] args) {

        ConnectionSource connectionSource = null;
        try {
            avionDao= DaoManager.createDao(connectionSource, Avion.class);
            robaDao = DaoManager.createDao(connectionSource, Roba.class);
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
