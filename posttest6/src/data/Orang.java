package data;

public abstract class Orang {
    protected String nama;

    public Orang(String nama) {
        this.nama = nama;
    }

    public String getNama() {
        return nama;
    }

    public final void setNama(String nama) { // final method
        this.nama = nama;
    }

    // Abstract
    public abstract String getInfo();
}
