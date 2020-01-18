package zadaci;

import com.j256.ormlite.dao.Dao;
import com.j256.ormlite.dao.DaoManager;
import com.j256.ormlite.jdbc.JdbcConnectionSource;
import com.j256.ormlite.support.ConnectionSource;
import model.Avion;

import java.util.List;

public class AvionNiti extends Thread {
    private static Object sinhronizacija = new Object();
    private static boolean dozvoljenoPoletanje = true;
    private int id;




    @Override
    public void run() {

        boolean dobioDozvolu = false;
        try {
            this.sleep((int) (Math.random()* 1000));
        }catch (InterruptedException e){
            e.printStackTrace();
        }
        System.out.println("Avion " + id + " trazi dozvolu za poletanje.");

        do {

            synchronized (AvionNiti.sinhronizacija) {
                if (AvionNiti.dozvoljenoPoletanje) {
                    AvionNiti.dozvoljenoPoletanje = false;
                    dobioDozvolu = true;
                }
            }

        } while (!dobioDozvolu);
        System.out.println("Avion izlazi na pistu i polece " + avion.getId());
        try {
            this.sleep(2000);
        }catch (InterruptedException e){
            e.printStackTrace();
        }
        System.out.println("Avion je poleteo " + avion.getId());

      synchronized (AvionNiti.sinhronizacija) {
          dozvoljenoPoletanje = true;
      }
    }

    public static void main(String[] args) {
        Dao<Avion, Integer> avionDao;


        try {
            ConnectionSource connectionSource = new JdbcConnectionSource("jdbc:sqlite:avionRoba.db");
            avionDao = DaoManager.createDao(connectionSource, Avion.class);

            List<Avion> a  = avionDao.queryForAll();
            for (Avion avion:a) {
                AvionNiti a1 = new AvionNiti(avion);

                System.out.println(a);

                a1.start();
            }


        } catch (Exception e) {
            e.printStackTrace();


        }
    }

    private Avion avion;
    public AvionNiti(Avion avion) {
        this.avion = avion;
    }

}



