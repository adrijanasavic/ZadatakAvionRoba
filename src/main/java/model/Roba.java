package model;

import com.j256.ormlite.field.DatabaseField;

public class Roba {

    //Avion avion;

    public static final String POLJE_NAZIV = "naziv";
    public static final String POLJE_OPIS = "opis";
    public static final String POLJE_TEZINA = "tezina";

    @DatabaseField(generatedId = true)
    private int id;
    @DatabaseField(columnName = POLJE_NAZIV, canBeNull = false)
    private String naziv;
    @DatabaseField(columnName = POLJE_OPIS, canBeNull = false)
    private String opis;
    @DatabaseField(columnName = POLJE_TEZINA, canBeNull = false)
    private String tezina;
    @DatabaseField(foreign =  true, foreignAutoRefresh = true )
    private Avion avion;

    public Roba() {
    }

    public Roba(int id, String naziv, String opis, String tezina) {
        this.id = id;
        this.naziv = naziv;
        this.opis = opis;
        this.tezina = tezina;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNaziv() {
        return naziv;
    }

    public void setNaziv(String naziv) {
        this.naziv = naziv;
    }

    public String getOpis() {
        return opis;
    }

    public void setOpis(String opis) {
        this.opis = opis;
    }

    public String getTezina() {
        return tezina;
    }

    public void setTezina(String tezina) {
        this.tezina = tezina;
    }

    @Override
    public String toString() {
        return "Roba{" +
                "id=" + id +
                ", naziv='" + naziv + '\'' +
                ", opis='" + opis + '\'' +
                ", tezina='" + tezina + '\'' +
                '}';
    }
}
