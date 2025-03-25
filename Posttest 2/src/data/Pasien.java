package data;

public class Pasien {
    private Integer idPasien;
    private String nama;

    public Pasien(Integer idPasien, String nama) {
        this.idPasien = idPasien;
        this.nama = nama;
    }

    public Integer getIdPasien() {
        return idPasien;
    }

    public void setIdPasien(Integer idPasien) {
        this.idPasien = idPasien;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }
}

