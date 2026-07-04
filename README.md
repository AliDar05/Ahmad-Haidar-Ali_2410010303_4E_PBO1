# Sistem Manajemen Peternakan

Proyek ini adalah aplikasi sederhana untuk mengolah data hewan ternak menggunakan Java, dibuat sebagai tugas akhir (UAS) dari mata kuliah Pemrograman Berbasis Objek.

## Deskripsi

Aplikasi ini menerima input berupa ID, jenis, berat, dan keterangan pakan hewan ternak, lalu menyediakan fitur untuk mengelola data tersebut melalui menu interaktif berbasis teks. Fitur yang tersedia meliputi menambah data hewan, memberi pakan, menjual hewan (lengkap dengan perhitungan harga jual), melihat total berat seluruh ternak, dan mencetak laporan.

Aplikasi ini mengimplementasikan beberapa konsep penting dalam pemrograman berorientasi objek (OOP) seperti Class, Object, Atribut, Method Constructor, Method Mutator, Method Accessor, Encapsulation, Inheritance, Polymorphism (Overriding), Seleksi, Perulangan, IO Sederhana, Collection (ArrayList), dan Error Handling.

## Struktur Proyek

```
UAS/
├── Ternak.java          # Class induk (parent)
├── TernakDetail.java    # Class anak (child), mewarisi Ternak
└── TernakBeraksi.java   # Class utama (main program / menu)
```

## Fitur Menu

| No | Menu             | Keterangan                                             |
| :-: | ---------------- | ------------------------------------------------------- |
| 1  | Tambah Hewan     | Menambahkan data hewan baru ke dalam daftar kandang     |
| 2  | Beri Pakan       | Mengubah status pakan hewan berdasarkan ID              |
| 3  | Jual Hewan       | Menjual hewan dan menghitung total harga jual           |
| 4  | Lihat Total Berat| Menampilkan jumlah hewan dan total berat seluruh ternak |
| 5  | Cetak Laporan    | Menampilkan seluruh data hewan yang ada di kandang      |
| 6  | Keluar           | Mengakhiri program                                      |

## Penjelasan Kode

Berikut adalah bagian kode yang relevan dengan konsep OOP yang diterapkan:

### 1. Class

Class adalah template atau blueprint dari object. Pada kode ini, `Ternak`, `TernakDetail`, dan `TernakBeraksi` adalah contoh dari class.

```java
public class Ternak {
    ...
}

public class TernakDetail extends Ternak {
    ...
}

public class TernakBeraksi {
    ...
}
```

### 2. Object

Object adalah instance dari class. Pada kode ini, `hd` adalah object yang dibuat dari class `TernakDetail`.

```java
TernakDetail hd = new TernakDetail(id, jenis, berat, ket);
daftarKandang.add(hd);
```

### 3. Atribut

Atribut adalah variabel yang ada dalam class. Pada kode ini, `id`, `jenis`, `berat`, `sudahDiberiPakan` (di `Ternak`) dan `keterangan` (di `TernakDetail`) adalah contoh atribut.

```java
private String id;
private String jenis;
private double berat;
private boolean sudahDiberiPakan;
```

```java
private String keterangan;
```

### 4. Constructor

Constructor adalah method yang pertama kali dijalankan saat pembuatan object. Pada kode ini, constructor ada di dalam class `Ternak` dan `TernakDetail`, di mana `TernakDetail` memanggil constructor induknya menggunakan `super()`.

```java
public Ternak(String id, String jenis, double berat) {
    this.id = id;
    this.jenis = jenis;
    this.berat = berat;
    this.sudahDiberiPakan = false;
}
```

```java
public TernakDetail(String id, String jenis, double berat, String keterangan) {
    super(id, jenis, berat);
    this.keterangan = keterangan;
}
```

### 5. Mutator

Mutator atau setter digunakan untuk mengubah nilai dari suatu atribut. Pada kode ini, `setId`, `setJenis`, `setBerat`, `setSudahDiberiPakan`, dan `setKeterangan` adalah contoh method mutator.

```java
public void setSudahDiberiPakan(boolean sudahDiberiPakan) {
    this.sudahDiberiPakan = sudahDiberiPakan;
}

public void setKeterangan(String keterangan) {
    this.keterangan = keterangan;
}
```

### 6. Accessor

Accessor atau getter digunakan untuk mengambil nilai dari suatu atribut. Pada kode ini, `getId`, `getJenis`, `getBerat`, `isSudahDiberiPakan`, `getKeterangan`, `getHargaPerKg`, dan `getTotalHarga` adalah contoh method accessor.

```java
public String getId() {
    return id;
}

public double getBerat() {
    return berat;
}
```

### 7. Encapsulation

Encapsulation adalah konsep menyembunyikan data dengan membuat atribut menjadi private dan hanya bisa diakses melalui method. Pada kode ini, seluruh atribut di `Ternak` dan `TernakDetail` dienkapsulasi sebagai `private`.

```java
private String id;
private String jenis;
private double berat;
private boolean sudahDiberiPakan;
private String keterangan;
```

### 8. Inheritance

Inheritance adalah konsep di mana sebuah class bisa mewarisi property dan method dari class lain. Pada kode ini, `TernakDetail` mewarisi `Ternak` dengan sintaks `extends`.

```java
public class TernakDetail extends Ternak {
    ...
}
```

### 9. Polymorphism

Polymorphism adalah konsep di mana sebuah nama dapat digunakan untuk merujuk ke beberapa tipe atau bentuk objek berbeda, sehingga method dengan nama yang sama bisa berperilaku berbeda tergantung objeknya. Pada kode ini, digunakan bentuk **Overriding**, yaitu method `getInfo()` di `TernakDetail` meng-override method `getInfo()` milik `Ternak`, sekaligus tetap memanggil versi induknya lewat `super.getInfo()`.

```java
// Ternak.java
public String getInfo() {
    ...
    return "ID : " + id
            + " | Jenis : " + jenis
            + " | Berat : " + berat + " Kg"
            + " | Status : " + statusPakan;
}
```

```java
// TernakDetail.java
@Override
public String getInfo() {
    return super.getInfo()
            + " | Keterangan : " + keterangan;
}
```

### 10. Seleksi

Seleksi adalah statement kontrol untuk membuat keputusan berdasarkan kondisi. Pada kode ini, digunakan seleksi `switch` untuk memilih menu dan `if-else` untuk menentukan harga per kilogram berdasarkan jenis hewan.

```java
switch (menu) {
    case "1":
        ...
    case "2":
        ...
}
```

```java
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
```

### 11. Perulangan

Perulangan adalah statement kontrol untuk menjalankan blok kode secara berulang. Pada kode ini, digunakan `while` untuk menjaga menu tetap berjalan, `for` dengan indeks untuk mencari dan menghapus data saat penjualan, serta `for-each` untuk menampilkan seluruh data ternak.

```java
while (jalan) {
    ...
}
```

```java
for (TernakDetail h : daftarKandang) {
    System.out.println(h.getInfo());
}
```

### 12. Input Output Sederhana

Input Output Sederhana digunakan untuk menerima input dari user dan menampilkan output ke user. Pada kode ini, digunakan class `Scanner` untuk menerima input dan method `System.out.println` / `System.out.print` untuk menampilkan output.

```java
Scanner input = new Scanner(System.in);
System.out.print("ID Hewan : ");
String id = input.nextLine();
```

### 13. Collection (ArrayList)

Sebagai pengganti array statis, proyek ini menggunakan `ArrayList` untuk menyimpan data ternak secara dinamis, sehingga jumlah data hewan tidak dibatasi di awal program.

```java
ArrayList<TernakDetail> daftarKandang = new ArrayList<>();
```

### 14. Error Handling

Error Handling digunakan untuk menangani error yang mungkin terjadi saat runtime. Pada kode ini, digunakan `try-catch` untuk menangani kesalahan input angka pada saat memasukkan berat hewan.

```java
try {
    System.out.print("Berat Hewan (Kg) : ");
    berat = Double.parseDouble(input.nextLine());
    valid = true;
} catch (NumberFormatException e) {
    System.out.println("Input harus berupa angka!");
}
```

## Daftar Harga per Kg

| Jenis Hewan | Harga per Kg |
| ----------- | ------------: |
| Sapi        | Rp 80.000     |
| Kambing     | Rp 90.000     |
| Ayam        | Rp 45.000     |
| Lainnya     | Rp 50.000     |

## Usulan Nilai

| No  | Materi                | Nilai   |
| :-: | --------------------- | :-----: |
|  1  | Class                 |    5    |
|  2  | Object                |    5    |
|  3  | Atribut               |    5    |
|  4  | Constructor           |    5    |
|  5  | Mutator               |    5    |
|  6  | Accessor              |    5    |
|  7  | Encapsulation         |    5    |
|  8  | Inheritance           |    5    |
|  9  | Polymorphism          |   10    |
| 10  | Seleksi               |    5    |
| 11  | Perulangan            |    5    |
| 12  | IO Sederhana          |   10    |
| 13  | Collection (ArrayList)|   15    |
| 14  | Error Handling        |   15    |
|     | **TOTAL**             | **100** |

## Pembuat

Nama: Ahmad Haidar Ali
NPM: 2410010303
