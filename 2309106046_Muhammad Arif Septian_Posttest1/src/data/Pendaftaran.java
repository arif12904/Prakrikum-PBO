package data;

public class Pendaftaran {
    public int idPendaftaran;
    public int idPasien;
    public String idJadwal;

    public Pendaftaran(int idPendaftaran,
                       int idPasien,
                       String idJadwal)
    {
        this.idPendaftaran = idPendaftaran;
        this.idPasien = idPasien;
        this.idJadwal = idJadwal;
    }
}
