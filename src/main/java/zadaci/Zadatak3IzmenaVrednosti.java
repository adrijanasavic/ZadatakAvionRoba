package zadaci;

import com.j256.ormlite.dao.Dao;
import com.j256.ormlite.dao.DaoManager;
import com.j256.ormlite.support.ConnectionSource;
import model.Avion;
import model.Roba;

import java.util.List;

public class Zadatak3IzmenaVrednosti {
    public static void main(String[] args) {
         Dao<Avion, Integer> avionDao;
         Dao<Roba, Integer> robaDao;


            ConnectionSource connectionSource = null;
            try {
                avionDao = DaoManager.createDao(connectionSource, Avion.class);
                robaDao = DaoManager.createDao(connectionSource, Roba.class);



               List <Roba> robaZaIzmenu = robaDao.queryForEq(Roba.POLJE_OPIS, "Plasticna stolica");
                for (Roba roba:robaZaIzmenu) {
                    roba.setOpis("Drvena stolica");
                   robaDao.update((Roba) robaZaIzmenu);

                }
                List<Roba> list = robaDao.queryForAll();
                for (Roba roba:list)
                    System.out.println(roba);




            } catch (Exception e) {
                e.printStackTrace();


            }
        }

}
