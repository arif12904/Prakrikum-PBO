package data;

public class Pendaftaran {
    private int idPendaftaran;
    private int idPasien;
    private String idJadwal;

    public Pendaftaran(int idPendaftaran, int idPasien, String idJadwal) {
        this.idPendaftaran = idPendaftaran;
        this.idPasien = idPasien;
        this.idJadwal = idJadwal;
    }

    public int getIdPendaftaran() {
        return idPendaftaran;
    }

    public void setIdPendaftaran(int idPendaftaran) {
        this.idPendaftaran = idPendaftaran;
    }

    public int getIdPasien() {
        return idPasien;
    }

    public void setIdPasien(int idPasien) {
        this.idPasien = idPasien;
    }

    public String getIdJadwal() {
        return idJadwal;
    }

    public void setIdJadwal(String idJadwal) {
        this.idJadwal = idJadwal;
    }
}
