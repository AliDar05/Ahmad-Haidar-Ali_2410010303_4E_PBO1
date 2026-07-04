package UAS;

import java.util.ArrayList;
import java.util.Scanner;

public class TernakBeraksi {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        // ArrayList
        ArrayList<TernakDetail> daftarKandang = new ArrayList<>();
        boolean jalan = true;
        while (jalan) {
            System.out.println("\n=========================================");
            System.out.println(" SISTEM MANAJEMEN PETERNAKAN ");
            System.out.println("=========================================");
            System.out.println("1. Tambah Hewan");
            System.out.println("2. Beri Pakan");
            System.out.println("3. Jual Hewan");
            System.out.println("4. Lihat Total Berat");
            System.out.println("5. Cetak Laporan");
            System.out.println("6. Keluar");
            System.out.print("Pilih Menu : ");

            String menu = input.nextLine();

            switch (menu) {

                case "1":

                    System.out.print("ID Hewan : ");
                    String id = input.nextLine();

                    System.out.print("Jenis Hewan (Sapi/Kambing/Ayam) : ");
                    String jenis = input.nextLine();

                    double berat = 0;
                    boolean valid = false;
                    
                    // Error Handling
                    while (!valid) {

                        try {

                            System.out.print("Berat Hewan (Kg) : ");
                            berat = Double.parseDouble(input.nextLine());

                            valid = true;

                        } catch (NumberFormatException e) {

                            System.out.println("Input harus berupa angka!");

                        }

                    }

                    System.out.print("Pakan : ");
                    String ket = input.nextLine();

                    // Object
                    TernakDetail hd = new TernakDetail(id, jenis, berat, ket);

                    daftarKandang.add(hd);

                    System.out.println("Data berhasil ditambahkan.");

                    break;

                case "2":

                    System.out.print("Masukkan ID Hewan : ");
                    String idPakan = input.nextLine();

                    boolean ketemu = false;

                    for (TernakDetail h : daftarKandang) {

                        if (h.getId().equalsIgnoreCase(idPakan)) {

                            h.setSudahDiberiPakan(true);

                            System.out.println("Hewan berhasil diberi pakan.");

                            ketemu = true;

                            break;

                        }

                    }

                    if (!ketemu) {

                        System.out.println("ID Hewan tidak ditemukan.");

                    }

                    break;

                case "3":

                    System.out.print("Masukkan ID Hewan yang akan dijual : ");
                    String idJual = input.nextLine();

                    boolean ditemukan = false;

                    for (int i = 0; i < daftarKandang.size(); i++) {

                        TernakDetail h = daftarKandang.get(i);

                        if (h.getId().equalsIgnoreCase(idJual)) {

                            System.out.println("\n===== DATA PENJUALAN =====");
                            System.out.println("ID             : " + h.getId());
                            System.out.println("Jenis          : " + h.getJenis());
                            System.out.println("Berat          : " + h.getBerat() + " Kg");
                            System.out.println("Harga / Kg     : Rp " + (int) h.getHargaPerKg());
                            System.out.println("Total Harga    : Rp " + (int) h.getTotalHarga());

                            System.out.print("\nYakin dijual? (Y/T) : ");
                            String jawab = input.nextLine();

                            if (jawab.equalsIgnoreCase("Y")) {

                                daftarKandang.remove(i);

                                System.out.println("Hewan berhasil dijual.");

                            } else {

                                System.out.println("Penjualan dibatalkan.");

                            }

                            ditemukan = true;

                            break;

                        }

                    }

                    if (!ditemukan) {

                        System.out.println("ID tidak ditemukan.");

                    }

                    break;

                case "4":

                    double totalBerat = 0;

                    for (TernakDetail h : daftarKandang) {

                        totalBerat += h.getBerat();

                    }

                    System.out.println("\n===== TOTAL BERAT =====");
                    System.out.println("Jumlah Hewan : " + daftarKandang.size());
                    System.out.println("Total Berat  : " + totalBerat + " Kg");

                    break;

                case "5":

                    if (daftarKandang.isEmpty()) {

                        System.out.println("Belum ada data.");

                    } else {

                        System.out.println("\n========== LAPORAN ==========");

                        for (TernakDetail h : daftarKandang) {

                            // Polymorphism
                            System.out.println(h.getInfo());

                        }

                    }

                    break;

                case "6":

                    jalan = false;

                    System.out.println("Terima kasih.");

                    break;

                default:

                    System.out.println("Menu tidak tersedia.");

            }

        }

        input.close();

    }

}