package data;

public class Pasien {
    public Integer idPasien;
    public String nama;
    public Pasien(Integer idPasien,String nama){
        this.idPasien = idPasien;
        this.nama = nama;
    }
    public int getId() {
        return idPasien;
    }
}
