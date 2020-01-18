package zadaci;

import com.j256.ormlite.dao.Dao;
import com.j256.ormlite.dao.DaoManager;
import com.j256.ormlite.support.ConnectionSource;
import model.Avion;
import model.Roba;

import java.sql.SQLException;
import java.util.List;

public class Zadatak4BrisanjeVrednosti {
    public static void main(String[] args) {
        Dao<Avion, Integer> avionDao;
        Dao<Roba, Integer> robaDao = null;


        ConnectionSource connectionSource = null;
        try {

            robaDao = DaoManager.createDao(connectionSource, Roba.class);


            List<Roba> list = robaDao.queryForAll();
            for (Roba roba : list) {
                System.out.println(roba);

            }
            List<Roba> robaZaBrisanje = robaDao.queryForEq(Roba.POLJE_OPIS, "Voda");
            for (Roba roba : robaZaBrisanje) {
                robaDao.delete(roba);



            }
            List<Roba> list1 = robaDao.queryForAll();
            for (Roba roba : list1){
                System.out.println(list1);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}