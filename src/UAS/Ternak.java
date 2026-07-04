package UAS;

public class Ternak {
    // Encapsulation & Attribute
    private String id;
    private String jenis;
    private double berat;   
    private boolean sudahDiberiPakan;

        // Constructor
    public Ternak(String id, String jenis, double berat) {
        this.id = id;
        this.jenis = jenis;
        this.berat = berat;
        this.sudahDiberiPakan = false;
    }

    // Accessor (Getter)
    public String getId() {
        return id;
    }

    public String getJenis() {
        return jenis;
    }

    public double getBerat() {
        return berat;
    }

    public boolean isSudahDiberiPakan() {
        return sudahDiberiPakan;
    }

    // Mutator (Setter)
    public void setId(String id) {
        this.id = id;
    }

    public void setJenis(String jenis) {
        this.jenis = jenis;
    }

    public void setBerat(double berat) {
        this.berat = berat;
    }

    public void setSudahDiberiPakan(boolean sudahDiberiPakan) {
        this.sudahDiberiPakan = sudahDiberiPakan;
    }

    // Method
    // (Akan dioverride oleh class anak)
    public String getInfo() {

        String statusPakan;

        if (sudahDiberiPakan) {
            statusPakan = "Sudah Diberi Pakan";
        } else {
            statusPakan = "Belum Diberi Pakan";
        }

        return "ID : " + id
                + " | Jenis : " + jenis
                + " | Berat : " + berat + " Kg"
                + " | Status : " + statusPakan;
    }
}