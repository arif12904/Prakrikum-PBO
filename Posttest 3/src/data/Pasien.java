package data;

public class Pasien extends Orang {
    private Integer idPasien;

    public Pasien(Integer idPasien, String nama) {
        super(nama); 
        this.idPasien = idPasien;
    }

    public Integer getIdPasien() {
        return idPasien;
    }

    public void setIdPasien(Integer idPasien) {
        this.idPasien = idPasien;
    }
}
