import java.util.ArrayList;
import java.util.Scanner;

class PencarianNilaiTerbesar {
    protected ArrayList<Integer> angkaList;
    
    public PencarianNilaiTerbesar(ArrayList<Integer> angkaList) {
        this.angkaList = angkaList;
    }

    public int cariNilaiTerbesar() {
        if (angkaList.isEmpty()) {
            throw new IllegalArgumentException("Daftar angka kosong!");
        }

        int nilaiTerbesar = angkaList.get(0);
        for (int angka : angkaList) {
            if (angka > nilaiTerbesar) {
                nilaiTerbesar = angka;
            }
        }

        return nilaiTerbesar;
    }

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

class PencarianNilaiTerbesarDescending extends PencarianNilaiTerbesar {

    public PencarianNilaiTerbesarDescending(ArrayList<Integer> angkaList) {
        super(angkaList);
    }

    @Override
    public int cariNilaiTerbesar() {
        if (angkaList.isEmpty()) {
            throw new IllegalArgumentException("Daftar angka kosong!");
        }

        int nilaiTerkecil = angkaList.get(0);

        for (int angka : angkaList) {
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
            System.out.print("Masukkan Angka: ");
            int angkainput = scanner.nextInt();
            angka.add(angkainput);
            PencarianNilaiTerbesar pencarian = new PencarianNilaiTerbesar(angka);
            PencarianNilaiTerbesarDescending pencarianDescending = new PencarianNilaiTerbesarDescending(angka);
            System.out.println("Nilai terbesar dalam daftar adalah: " + pencarian.cariNilaiTerbesar());
            System.out.println("Nilai terkecil dalam daftar adalah: " + pencarianDescending.cariNilaiTerbesar());
            System.out.println("List Angka Saat Ini: " + angka);
        }
    }
}