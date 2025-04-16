package data;

public class Orang {
    protected String nama;

    public Orang(String nama) {
        this.nama = nama;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    // Method override
    public String getInfo() {
        return "Nama: " + nama;
    }
}
