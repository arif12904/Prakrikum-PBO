package service;

import data.Dokter;
import data.Jadwal;
import data.Pasien;
import data.Pendaftaran;

import java.util.ArrayList;

public class PendaftaranService {
    private ArrayList<Pendaftaran> daftarPendaftaran = new ArrayList<>();
    private ArrayList<Pasien> daftarPasien = new ArrayList<>();
    private ArrayList<Dokter> daftarDokter = new ArrayList<>();
    private ArrayList<Jadwal> daftarJadwal = new ArrayList<>();
    private int idPendaftaran = 1;
    private int idPasien = 1;

    public PendaftaranService() {
        Dokter dokter1 = new Dokter("D001", "Dr. Aisyah", "Umum");
        Dokter dokter2 = new Dokter("D002", "Dr. Bambang", "Gigi");
        Dokter dokter3 = new Dokter("D003", "Dr. Cindy", "Jantung");

        daftarDokter.add(dokter1);
        daftarDokter.add(dokter2);
        daftarDokter.add(dokter3);

        daftarJadwal.add(new Jadwal("J001", dokter1, "Senin", "08:00", "10:00", true));
        daftarJadwal.add(new Jadwal("J002", dokter1, "Selasa", "10:00", "12:00", true));
        daftarJadwal.add(new Jadwal("J003", dokter1, "Kamis", "14:00", "16:00", true));
        daftarJadwal.add(new Jadwal("J004", dokter1, "Sabtu", "09:00", "11:00", true));

        daftarJadwal.add(new Jadwal("J005", dokter2, "Senin", "09:00", "11:00", true));
        daftarJadwal.add(new Jadwal("J006", dokter2, "Rabu", "13:00", "15:00", true));
        daftarJadwal.add(new Jadwal("J007", dokter2, "Jumat", "15:00", "17:00", true));
        daftarJadwal.add(new Jadwal("J008", dokter2, "Minggu", "08:00", "10:00", true));

        daftarJadwal.add(new Jadwal("J009", dokter3, "Selasa", "11:00", "13:00", true));
        daftarJadwal.add(new Jadwal("J010", dokter3, "Kamis", "09:00", "11:00", true));
        daftarJadwal.add(new Jadwal("J011", dokter3, "Sabtu", "13:00", "15:00", true));
        daftarJadwal.add(new Jadwal("J012", dokter3, "Minggu", "10:00", "12:00", true));
    }

    public void tambahPasien(String namaPasien){
        daftarPasien.add(new Pasien(idPasien,namaPasien));
        idPasien++;
    }

    private int ambilIdPasien(){
        return daftarPasien.getLast().getId();
    }

    public void tambahPendaftaran(String idJadwal){
        int idPasien = ambilIdPasien();
        daftarPendaftaran.add(new Pendaftaran(idPendaftaran,idPasien,idJadwal));
        System.out.println("Pendaftaran Berhasil");
        updateJadwalTersedia(idJadwal,false);
        idPendaftaran++;
    }

    public Boolean cekJadwalTersedia(String idJadwal){
        for (Jadwal jadwal : daftarJadwal){
            if (jadwal.idJadwal.equals(idJadwal) && jadwal.tersedia){
                return true;
            }
        }
        return false;
    }

    private void updateJadwalTersedia(String idJadwal, boolean status){
        for (Jadwal jadwal : daftarJadwal) {
            if (jadwal.idJadwal.equals(idJadwal)) {
                jadwal.tersedia = false;
                break;
            }
        }
    }

    public void tampilkanPendaftaran(){
        System.out.println("\nDaftar Pendaftaran:");
        for (Pendaftaran pendaftaran : daftarPendaftaran) {
            String namaPasien = ambilNamaPasienDariId(pendaftaran.idPasien);
            String namaDokter = ambilNamadokterDariId(pendaftaran.idJadwal);
            String jadwalDetail = ambilDetailJadwalDariID(pendaftaran.idJadwal);

            System.out.println("ID Pendaftaran: " + pendaftaran.idPendaftaran);
            System.out.println("Pasien: " + namaPasien);
            System.out.println("Dokter: " + namaDokter);
            System.out.println("Jadwal: " + jadwalDetail);
            System.out.println("------------------------------------------------");
        }
    }

    private String ambilNamaPasienDariId(int idPasien){
        for (Pasien pasien : daftarPasien){
            if (pasien.idPasien.equals(idPasien)){
                return pasien.nama;
            }
        }
        return "Pasien tidak ditemukan";
    }

    private String ambilNamadokterDariId(String idJadwal){
        for (Jadwal jadwal:daftarJadwal){
            if (jadwal.idJadwal.equals(idJadwal)){
                return jadwal.dokter.nama;
            }
        }
        return "Dokter tidak tersedia";
    }

    private String ambilDetailJadwalDariID(String idJadwal){
        for (Jadwal jadwal: daftarJadwal){
            if (jadwal.idJadwal.equals(idJadwal)){
                return jadwal.hari + " (" + jadwal.jamMulai + " - " + jadwal.jamSelesai + ")";
            }
        }
        return "Jadwal tidak tersedia";
    }

    public void tampilkanDokter() {
        System.out.println("\nDaftar Dokter:");
        for (Dokter dokter : daftarDokter) {
            System.out.println(dokter.idDokter + " - " + dokter.nama + " (" + dokter.spesialis + ")");
        }
    }

    public void tampilkanJadwalByDokter(String idDokter) {
        System.out.println("\nJadwal Tersedia:");
        boolean adaJadwal = false;
        for (Jadwal jadwal : daftarJadwal) {
            if (jadwal.dokter.idDokter.equals(idDokter) && jadwal.tersedia) {
                adaJadwal = true;
                System.out.println(jadwal.idJadwal + " - " + jadwal.hari + " (" + jadwal.jamMulai + " - " + jadwal.jamSelesai + ")");
            }
        }
        if (!adaJadwal) {
            System.out.println("⚠Tidak ada jadwal tersedia untuk dokter ini.");
        }
    }

    public void editPendaftaran(int idPendaftaran, String idJadwalBaru){
        for (Pendaftaran pendaftaran: daftarPendaftaran){
            if(pendaftaran.idPendaftaran == idPendaftaran){
                updateJadwalTersedia(pendaftaran.idJadwal,true);
                pendaftaran.idJadwal = idJadwalBaru;
                updateJadwalTersedia(idJadwalBaru,false);
                System.out.println("Pendaftaran berhasil diperbarui");
                return;
            }
        }
        System.out.println("ID Pendaftaran tidak ditemukan.");
    }

    public void HapusPendaftaran(int idPendaftaran){
        for (int i = 0; i < daftarPendaftaran.size(); i++){
            if (daftarPendaftaran.get(i).idPendaftaran == idPendaftaran){
                updateJadwalTersedia(daftarPendaftaran.get(i).idJadwal,true);
                daftarPendaftaran.remove(i);
                System.out.println("Pendaftaran berhasil dihapus.");
                return;
            }
        }
        System.out.println("ID Pendaftaran tidak ditemukan.");
    }

    public Boolean cekInputanIdDokter(String idDokter){
        for (Dokter dokter : daftarDokter){
            if (dokter.idDokter.equals(idDokter)){
                return true;
            }
        }
        return false;
    }

    public Boolean cekPendaftaranMasihKosong(){
        return daftarPendaftaran.isEmpty();
    }
}
