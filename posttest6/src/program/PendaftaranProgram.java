package program;

import service.PendaftaranService;
import java.util.InputMismatchException;
import java.util.Scanner;

public class PendaftaranProgram {
    private PendaftaranService pendaftaran = new PendaftaranService();
    private Scanner scanner = new Scanner(System.in);

    public void showMenu() {
        while (true) {
            System.out.println("\n=== Selamat Datang di " + PendaftaranService.NAMA_KLINIK + " ===");

            System.out.println("\n+----------------------------+");
            System.out.println("|         MENU UTAMA         |");
            System.out.println("+----------------------------+");
            System.out.println("| 1. Tambah Pendaftaran      |");
            System.out.println("| 2. Tampilkan Pendaftaran   |");
            System.out.println("| 3. Edit Pendaftaran        |");
            System.out.println("| 4. Hapus Pendaftaran       |");
            System.out.println("| 5. Cari Pendaftaran Berdasarkan ID Pasien |");
            System.out.println("| 0. Keluar                  |");
            System.out.println("+----------------------------+");
            System.out.print("Pilih: ");

            int pilihan = -1;
            try {
                pilihan = Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("⚠ Input tidak valid! Harap masukkan angka.");
                continue; // kembali ke awal menu
            }

            switch (pilihan) {
                case 1:
                    tambahPendaftaran();
                    tungguKonfirmasi();
                    break;
                case 2:
                    pendaftaran.tampilkanPendaftaran();
                    tungguKonfirmasi();
                    break;
                case 3:
                    editPendaftaran();
                    tungguKonfirmasi();
                    break;
                case 4:
                    hapusPendaftaran();
                    tungguKonfirmasi();
                    break;
                case 5:
                    cariPendaftaranBerdasarkanIdPasien();
                    tungguKonfirmasi();
                    break;
                case 0:
                    System.out.println("Keluar dari program...");
                    return;
                default:
                    System.out.println("⚠ Pilihan tidak valid! Silakan coba lagi.");
            }
        }
    }

    private void tungguKonfirmasi() {
        System.out.print("\nTekan Enter untuk kembali ke menu utama...");
        scanner.nextLine();
    }

    private void tambahPendaftaran() {
        pendaftaran.tampilkanDokter();
        System.out.print("\nPilih ID Dokter: ");
        String idDokter = scanner.nextLine();
        if (!pendaftaran.cekInputanIdDokter(idDokter)) {
            System.out.println("ID Dokter tidak ditemukan. Silakan coba lagi.");
            return;
        }

        pendaftaran.tampilkanJadwalByDokter(idDokter);
        System.out.print("\nPilih ID Jadwal: ");
        String idJadwal = scanner.nextLine();

        if (!pendaftaran.cekJadwalTersedia(idJadwal)) {
            System.out.println("Jadwal tidak tersedia. Silakan coba lagi.");
            return;
        }

        System.out.print("\nMasukkan Nama Pasien: ");
        String namaPasien = scanner.nextLine();
        pendaftaran.tambahPasien(namaPasien);
        pendaftaran.tambahPendaftaran(idJadwal);
    }

    private void editPendaftaran() {
        if (pendaftaran.cekPendaftaranMasihKosong()) {
            System.out.println("Belum ada pendaftaran.");
            return;
        }

        pendaftaran.tampilkanPendaftaran();
        System.out.print("\nMasukkan ID Pendaftaran yang ingin diubah: ");

        int idPendaftaran;
        try {
            idPendaftaran = Integer.parseInt(scanner.nextLine());
        } catch (NumberFormatException e) {
            System.out.println("⚠ Input tidak valid! Masukkan angka.");
            return;
        }

        pendaftaran.tampilkanDokter();
        System.out.print("\nPilih ID Dokter baru: ");
        String idDokter = scanner.nextLine();
        if (!pendaftaran.cekInputanIdDokter(idDokter)) {
            System.out.println("ID Dokter tidak ditemukan. Silakan coba lagi.");
            return;
        }

        pendaftaran.tampilkanJadwalByDokter(idDokter);
        System.out.print("\nPilih ID Jadwal baru: ");
        String idJadwalBaru = scanner.nextLine();

        if (!pendaftaran.cekJadwalTersedia(idJadwalBaru)) {
            System.out.println("Jadwal tidak tersedia. Silakan coba lagi.");
            return;
        }

        pendaftaran.editPendaftaran(idPendaftaran, idJadwalBaru);
    }

    private void hapusPendaftaran() {
        if (pendaftaran.cekPendaftaranMasihKosong()) {
            System.out.println("Belum ada pendaftaran.");
            return;
        }

        pendaftaran.tampilkanPendaftaran();
        System.out.print("\nMasukkan ID Pendaftaran yang ingin dihapus: ");

        int idPendaftaran;
        try {
            idPendaftaran = Integer.parseInt(scanner.nextLine());
        } catch (NumberFormatException e) {
            System.out.println("⚠ Input tidak valid! Masukkan angka.");
            return;
        }

        pendaftaran.HapusPendaftaran(idPendaftaran);
    }

    private void cariPendaftaranBerdasarkanIdPasien() {
        System.out.print("\nMasukkan ID Pasien yang ingin dicari: ");

        int idPasien;
        try {
            idPasien = Integer.parseInt(scanner.nextLine());
        } catch (NumberFormatException e) {
            System.out.println("⚠ Input tidak valid! Masukkan angka.");
            return;
        }

        pendaftaran.tampilkanPendaftaran(idPasien);
    }
}
