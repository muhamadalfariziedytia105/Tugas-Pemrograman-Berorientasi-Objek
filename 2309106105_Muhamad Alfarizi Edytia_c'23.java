import java.util.ArrayList;
import java.util.Scanner;

// Kelas utama untuk pencarian nilai terbesar
class PencarianNilaiTerbesar {
    protected ArrayList<Integer> angkaList;

    // Konstruktor untuk menginisialisasi daftar angka
    public PencarianNilaiTerbesar(ArrayList<Integer> angkaList) {
        this.angkaList = angkaList;
    }

    // Metode untuk mencari nilai terbesar
    public int cariNilaiTerbesar() {
        // Memastikan daftar tidak kosong
        if (angkaList.isEmpty()) {
            throw new IllegalArgumentException("Daftar angka kosong!");
        }

        // Menyebut angka pertama sebagai nilai terbesar sementara
        int nilaiTerbesar = angkaList.get(0);

        // Menggunakan perulangan untuk memeriksa semua angka
        for (int angka : angkaList) {
            // Menggunakan kondisi untuk memeriksa apakah angka saat ini lebih besar
            if (angka > nilaiTerbesar) {
                nilaiTerbesar = angka;
            }
        }

        return nilaiTerbesar;
    }

    // Method overloading: mencari nilai terbesar berdasarkan jumlah parameter
    // Versi pertama: mencari nilai terbesar dalam seluruh daftar
    public int cariNilaiTerbesar(int batas) {
        int nilaiTerbesar = Integer.MIN_VALUE;
        for (int angka : angkaList) {
            if (angka <= batas && angka > nilaiTerbesar) {
                nilaiTerbesar = angka;
            }
        }
        return nilaiTerbesar;
    }
}

// Subclass yang mengoverride metode cariNilaiTerbesar
class PencarianNilaiTerbesarDescending extends PencarianNilaiTerbesar {

    // Konstruktor untuk menginisialisasi daftar angka
    public PencarianNilaiTerbesarDescending(ArrayList<Integer> angkaList) {
        super(angkaList);
    }

    // Override metode untuk mencari nilai terkecil (untuk contoh polymorphism)
    @Override
    public int cariNilaiTerbesar() {
        // Memastikan daftar tidak kosong
        if (angkaList.isEmpty()) {
            throw new IllegalArgumentException("Daftar angka kosong!");
        }

        // Menyebut angka pertama sebagai nilai terkecil sementara
        int nilaiTerkecil = angkaList.get(0);

        // Menggunakan perulangan untuk memeriksa semua angka
        for (int angka : angkaList) {
            // Menggunakan kondisi untuk memeriksa apakah angka saat ini lebih kecil
            if (angka < nilaiTerkecil) {
                nilaiTerkecil = angka;
            }
        }

        return nilaiTerkecil;
    }
}

public class Main {
    public static void main(String[] args) {
        ArrayList<Integer> angka = new ArrayList<>();
        boolean berjalan = true;
        Scanner scanner = new Scanner(System.in);

        while (berjalan) {
            // Input string
            System.out.print("Masukkan Angka: ");
            int angkainput = scanner.nextInt();
            angka.add(angkainput);

            // Membuat objek dari kelas PencarianNilaiTerbesar
            PencarianNilaiTerbesar pencarian = new PencarianNilaiTerbesar(angka);
            
            // Membuat objek dari kelas PencarianNilaiTerbesarDescending (subclass)
            PencarianNilaiTerbesarDescending pencarianDescending = new PencarianNilaiTerbesarDescending(angka);

            // Menampilkan nilai terbesar menggunakan metode dari superclass
            System.out.println("Nilai terbesar dalam daftar adalah: " + pencarian.cariNilaiTerbesar());

            // Menampilkan nilai terkecil menggunakan metode yang di-override (polymorphism)
            System.out.println("Nilai terkecil dalam daftar adalah: " + pencarianDescending.cariNilaiTerbesar());

            System.out.println("List Angka Saat Ini: " + angka);
        }
    }
}