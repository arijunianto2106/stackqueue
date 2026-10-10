// melakukan penyimpanan riwayat transaksi terbaru di bagian atas
public class Stack {
    private Node atas;

    // melakukan penyimpanan transaksi yang baru selesai dilayani
    public void push(Node transaksi) {
        transaksi.next = atas;
        atas = transaksi;
    }

    // melakukan tampilan riwayat transaksi dari terbaru ke terlama
    public void tampilkanRiwayat() {
        System.out.println("\nRiwayat Transaksi:");
        if (atas == null) {
            System.out.println("Belum ada transaksi.");
            return;
        }
        Node sekarang = atas;
        while (sekarang != null) {
            System.out.println("Nomor: " + sekarang.nomorAntrian
                    + " | Nama: " + sekarang.namaPelanggan
                    + " | Total Belanja: Rp" + sekarang.totalBelanja);
            sekarang = sekarang.next;
        }
    }
}
