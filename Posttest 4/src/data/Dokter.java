package data;

public class Dokter extends Orang {
    private String idDokter;
    private String spesialis;

    public Dokter(String idDokter, String nama, String spesialis) {
        super(nama);
        this.idDokter = idDokter;
        this.spesialis = spesialis;
    }

    public String getIdDokter() {
        return idDokter;
    }

    public void setIdDokter(String idDokter) {
        this.idDokter = idDokter;
    }

    public String getSpesialis() {
        return spesialis;
    }

    public void setSpesialis(String spesialis) {
        this.spesialis = spesialis;
    }
//  melakukan override
    @Override
    public String getInfo() {
        return "ID Dokter: " + idDokter + "\nNama: " + nama + "\nSpesialis: " + spesialis;
    }
}
