package data;

public class Jadwal {
    public String idJadwal;
    public Dokter dokter;
    public String hari,jamMulai, jamSelesai;
    public Boolean tersedia;

    public Jadwal(String idJadwal,
                  Dokter dokter,
                  String hari,
                  String jamMulai,
                  String jamSelesai,
                  Boolean tersedia)
    {
        this.idJadwal = idJadwal;
        this.dokter = dokter;
        this.hari = hari;
        this.jamMulai = jamMulai;
        this.jamSelesai = jamSelesai;
        this.tersedia = tersedia;
    }

}
