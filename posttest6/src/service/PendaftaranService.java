package service;

import data.*;

import java.util.ArrayList;

public class PendaftaranService implements ValidasiInput {
    private final ArrayList<Pendaftaran> daftarPendaftaran = new ArrayList<>();
    private final ArrayList<Pasien> daftarPasien = new ArrayList<>();
    private final ArrayList<Dokter> daftarDokter = new ArrayList<>();
    private final ArrayList<Jadwal> daftarJadwal = new ArrayList<>();
    private int idPendaftaran = 1;
    private int idPasien = 1;
    public static final String NAMA_KLINIK = "Klinik Sehat Bersama";

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

    public void tambahPasien(String namaPasien) {
        daftarPasien.add(new Pasien(idPasien, namaPasien));
        idPasien++;
    }

    private int ambilIdPasien() {
        return daftarPasien.getLast().getIdPasien();
    }

    public void tambahPendaftaran(String idJadwal) {
        int idPasien = ambilIdPasien();
        daftarPendaftaran.add(new Pendaftaran(idPendaftaran, idPasien, idJadwal));
        System.out.println("Pendaftaran Berhasil");
        updateJadwalTersedia(idJadwal, false);
        idPendaftaran++;
    }

    private boolean cekPasienAda(int idPasien) {
        for (Pasien pasien : daftarPasien) {
            if (pasien.getIdPasien().equals(idPasien)) {
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean cekJadwalTersedia(String idJadwal) {
        for (Jadwal jadwal : daftarJadwal) {
            if (jadwal.getIdJadwal().equals(idJadwal) && jadwal.getTersedia()) {
                return true;
            }
        }
        return false;
    }

    private void updateJadwalTersedia(String idJadwal, boolean status) {
        for (Jadwal jadwal : daftarJadwal) {
            if (jadwal.getIdJadwal().equals(idJadwal)) {
                jadwal.setTersedia(status);
                break;
            }
        }
    }

    public void tampilkanPendaftaran() {
        System.out.println("\nDaftar Pendaftaran:");
        for (Pendaftaran pendaftaran : daftarPendaftaran) {
            String namaPasien = ambilNamaPasienDariId(pendaftaran.getIdPasien());
            String namaDokter = ambilNamadokterDariId(pendaftaran.getIdJadwal());
            String jadwalDetail = ambilDetailJadwalDariID(pendaftaran.getIdJadwal());

            System.out.println("ID Pendaftaran: " + pendaftaran.getIdPendaftaran());
            System.out.println("Pasien: " + namaPasien);
            System.out.println("Dokter: " + namaDokter);
            System.out.println("Jadwal: " + jadwalDetail);
            System.out.println("------------------------------------------------");
        }
    }

    public final void tampilkanPendaftaran(int idPasien) {
        System.out.println("\nDaftar Pendaftaran untuk Pasien ID: " + idPasien);
        boolean ditemukan = false;

        for (Pendaftaran pendaftaran : daftarPendaftaran) {
            if (pendaftaran.getIdPasien() == idPasien) {
                ditemukan = true;
                String namaPasien = ambilNamaPasienDariId(pendaftaran.getIdPasien());
                String namaDokter = ambilNamadokterDariId(pendaftaran.getIdJadwal());
                String jadwalDetail = ambilDetailJadwalDariID(pendaftaran.getIdJadwal());

                System.out.println("ID Pendaftaran: " + pendaftaran.getIdPendaftaran());
                System.out.println("Pasien: " + namaPasien);
                System.out.println("Dokter: " + namaDokter);
                System.out.println("Jadwal: " + jadwalDetail);
                System.out.println("------------------------------------------------");
            }
        }

        if (!ditemukan) {
            System.out.println("Tidak ada pendaftaran untuk pasien dengan ID: " + idPasien);
        }
    }

    private String ambilNamaPasienDariId(int idPasien) {
        for (Pasien pasien : daftarPasien) {
            if (pasien.getIdPasien().equals(idPasien)) {
                return pasien.getNama();
            }
        }
        return "Pasien tidak ditemukan";
    }

    private String ambilNamadokterDariId(String idJadwal) {
        for (Jadwal jadwal : daftarJadwal) {
            if (jadwal.getIdJadwal().equals(idJadwal)) {
                return jadwal.getDokter().getNama();
            }
        }
        return "Dokter tidak tersedia";
    }

    private String ambilDetailJadwalDariID(String idJadwal) {
        for (Jadwal jadwal : daftarJadwal) {
            if (jadwal.getIdJadwal().equals(idJadwal)) {
                return jadwal.getHari() + " (" + jadwal.getJamMulai() + " - " + jadwal.getJamSelesai() + ")";
            }
        }
        return "Jadwal tidak tersedia";
    }

    public void tampilkanDokter() {
        System.out.println("\nDaftar Dokter:");
        for (Dokter dokter : daftarDokter) {
            System.out.println(dokter.getIdDokter() + " - " + dokter.getNama() + " (" + dokter.getSpesialis() + ")");
        }
    }

    public void tampilkanJadwalByDokter(String idDokter) {
        System.out.println("\nJadwal Tersedia:");
        boolean adaJadwal = false;

        for (Jadwal jadwal : daftarJadwal) {
            if (jadwal.getDokter().getIdDokter().equals(idDokter) && jadwal.getTersedia()) {
                if (!adaJadwal) {
                    System.out.println("\n" + jadwal.getDokter().getInfo());
                    System.out.println("Jadwal-jadwal yang tersedia:");
                }

                adaJadwal = true;
                System.out.println(jadwal.getIdJadwal() + " - " + jadwal.getHari() +
                        " (" + jadwal.getJamMulai() + " - " + jadwal.getJamSelesai() + ")");
            }
        }

        if (!adaJadwal) {
            System.out.println("⚠Tidak ada jadwal tersedia untuk dokter ini.");
        }
    }

    public void editPendaftaran(int idPendaftaran, String idJadwalBaru) {
        for (Pendaftaran pendaftaran : daftarPendaftaran) {
            if (pendaftaran.getIdPendaftaran() == idPendaftaran) {
                updateJadwalTersedia(pendaftaran.getIdJadwal(), true);
                pendaftaran.setIdJadwal(idJadwalBaru);
                updateJadwalTersedia(idJadwalBaru, false);
                System.out.println("Pendaftaran berhasil diperbarui");
                return;
            }
        }
        System.out.println("ID Pendaftaran tidak ditemukan.");
    }

    public void HapusPendaftaran(int idPendaftaran) {
        for (int i = 0; i < daftarPendaftaran.size(); i++) {
            if (daftarPendaftaran.get(i).getIdPendaftaran() == idPendaftaran) {
                updateJadwalTersedia(daftarPendaftaran.get(i).getIdJadwal(), true);
                daftarPendaftaran.remove(i);
                System.out.println("Pendaftaran berhasil dihapus.");
                return;
            }
        }
        System.out.println("ID Pendaftaran tidak ditemukan.");
    }

    @Override
    public boolean cekInputanIdDokter(String idDokter) {
        for (Dokter dokter : daftarDokter) {
            if (dokter.getIdDokter().equals(idDokter)) {
                return true;
            }
        }
        return false;
    }

    public Boolean cekPendaftaranMasihKosong() {
        return daftarPendaftaran.isEmpty();
    }

    public ArrayList<Dokter> getDaftarDokter() {
        return daftarDokter;
    }

}
