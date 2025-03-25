package data;

public class Jadwal {
    private String idJadwal;
    private Dokter dokter;
    private String hari, jamMulai, jamSelesai;
    private Boolean tersedia;

    public Jadwal(String idJadwal, Dokter dokter, String hari, String jamMulai, String jamSelesai, Boolean tersedia) {
        this.idJadwal = idJadwal;
        this.dokter = dokter;
        this.hari = hari;
        this.jamMulai = jamMulai;
        this.jamSelesai = jamSelesai;
        this.tersedia = tersedia;
    }

    public String getIdJadwal() {
        return idJadwal;
    }

    public void setIdJadwal(String idJadwal) {
        this.idJadwal = idJadwal;
    }

    public Dokter getDokter() {
        return dokter;
    }

    public void setDokter(Dokter dokter) {
        this.dokter = dokter;
    }

    public String getHari() {
        return hari;
    }

    public void setHari(String hari) {
        this.hari = hari;
    }

    public String getJamMulai() {
        return jamMulai;
    }

    public void setJamMulai(String jamMulai) {
        this.jamMulai = jamMulai;
    }

    public String getJamSelesai() {
        return jamSelesai;
    }

    public void setJamSelesai(String jamSelesai) {
        this.jamSelesai = jamSelesai;
    }

    public Boolean getTersedia() {
        return tersedia;
    }

    public void setTersedia(Boolean tersedia) {
        this.tersedia = tersedia;
    }
}