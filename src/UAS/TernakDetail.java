package UAS;

// Inheritance
public class TernakDetail extends Ternak {

    // Attribute tambahan
    private String keterangan;

    // Constructor
    public TernakDetail(String id, String jenis, double berat, String keterangan) {

        // Memanggil constructor milik class induk
        super(id, jenis, berat);

        this.keterangan = keterangan;
    }

    // Accessor (Getter)
    public String getKeterangan() {
        return keterangan;
    }

    // Mutator (Setter)
    public void setKeterangan(String keterangan) {
        this.keterangan = keterangan;
    }

    // Method untuk menentukan harga per Kg
    public double getHargaPerKg() {

        if (getJenis().equalsIgnoreCase("Sapi")) {
            return 80000;
        } else if (getJenis().equalsIgnoreCase("Kambing")) {
            return 90000;
        } else if (getJenis().equalsIgnoreCase("Ayam")) {
            return 45000;
        } else {
            return 50000;
        }

    }

    // Method menghitung total harga jual
    public double getTotalHarga() {

        return getBerat() * getHargaPerKg();

    }

    // Polymorphism (Method Overriding dan [Overloading])
    @Override
    public String getInfo() {

        return super.getInfo()
                + " | Keterangan : " + keterangan;

    }

}