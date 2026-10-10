import java.util.Scanner;

public class SistemKasir {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        Queue antrian = new Queue();
        Stack riwayat = new Stack();
        int totalPelangganMasuk = 0;
        boolean berjalan = true;

        // user memilih menu melalui main menu
        while (berjalan) {
            System.out.println("\n=== SISTEM KASIR TOKO ===");
            System.out.println("1. Tambah Antrian");
            System.out.println("2. Layani Pelanggan");
            System.out.println("3. Tampilkan Antrian");
            System.out.println("4. Lihat Riwayat Transaksi");
            System.out.println("5. Keluar");
            System.out.print("Pilih menu: ");
            String pilihan = input.nextLine().trim();

            switch (pilihan) {
                case "1":
                    // melakukan pembatasan 5 diterapkan pada jumlah yang sedang antri
                    if (antrian.getJumlah() >= 5) {
                        System.out.println("Antrian sudah penuh (maksimal 5 pelanggan).");
                        break;
                    }
                    System.out.print("Masukkan Nomor Antrian: ");
                    String nomor = input.nextLine().trim();
                    if (nomor.isEmpty()) {
                        System.out.println("Nomor antrian tidak boleh kosong.");
                        break;
                    }
                    if (antrian.nomorSudahAda(nomor)) {
                        System.out.println("Nomor antrian sudah digunakan.");
                        break;
                    }

                    System.out.print("Masukkan Nama Pelanggan: ");
                    String nama = input.nextLine().trim();
                    if (nama.isEmpty()) {
                        System.out.println("Nama pelanggan tidak boleh kosong.");
                        break;
                    }
                    System.out.print("Masukkan Total Belanja: ");
                    String teksTotal = input.nextLine().trim();

                    // memastikan total belanja adalah angka yang bernilai positif
                    try {
                        long total = Long.parseLong(teksTotal);
                        if (total <= 0) {
                            System.out.println("Total belanja harus lebih dari 0.");
                            break;
                        }
                        Node pelanggan = new Node(nomor, nama, total);
                        if (antrian.enqueue(pelanggan)) {
                            totalPelangganMasuk++;
                            System.out.println("Data pelanggan ditambahkan ke antrian!");
                        } else {
                            System.out.println("Antrian sudah penuh (maksimal 5 pelanggan).");
                        }
                    } catch (NumberFormatException e) {
                        System.out.println("Total belanja harus berupa angka.");
                    }
                    break;

                case "2":
                    // pelanggan pertama yang akan dikeluarkan dari queue pertama
                    Node pelangganDilayani = antrian.dequeue();
                    if (pelangganDilayani == null) {
                        System.out.println("Tidak ada pelanggan dalam antrian.");
                    } else {
                        System.out.println("Melayani pelanggan "
                                + pelangganDilayani.nomorAntrian + " ("
                                + pelangganDilayani.namaPelanggan + ")");
                        // LIFO: transaksi yang selesai dimasukkan ke atas stack.
                        riwayat.push(pelangganDilayani);
                        System.out.println("Transaksi disimpan ke riwayat.");
                        antrian.tampilkanAntrian();
                    }
                    break;

                case "3":
                    antrian.tampilkanAntrian();
                    break;

                case "4":
                    riwayat.tampilkanRiwayat();
                    break;

                case "5":
                    // terdapat minimal lima data pelanggan yang di uji
                    if (totalPelangganMasuk < 5) {
                        System.out.println("Masukkan minimal 5 pelanggan sebelum keluar.");
                        System.out.println("Jumlah yang sudah dimasukkan: " + totalPelangganMasuk);
                    } else {
                        System.out.println("Program selesai. Terima kasih!");
                        berjalan = false;
                    }
                    break;

                default:
                    System.out.println("Menu tidak tersedia. Silakan pilih 1 sampai 5.");
            }
        }
        input.close();
    }
}