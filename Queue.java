// melakukan penyimpanan pelanggan berdasarkan urutan awal
public class Queue {
    private Node depan;
    private Node belakang;
    private int jumlah;
    private static final int MAKSIMAL_ANTRIAN = 5;

    // pelanggan baru masuk dari paling akhir dengan maksimal yang antri 5 antrian
    public boolean enqueue(Node pelanggan) {
        if (jumlah >= MAKSIMAL_ANTRIAN) {
            return false;
        }
        pelanggan.next = null;
        if (depan == null) {
            depan = pelanggan;
            belakang = pelanggan;
        } else {
            belakang.next = pelanggan;
            belakang = pelanggan;
        }
        jumlah++;
        return true;
    }

    // melakukan pengambilan pelanggan paling depan untuk dilayani
    public Node dequeue() {
        if (depan == null) {
            return null;
        }
        Node dilayani = depan;
        depan = depan.next;
        if (depan == null) {
            belakang = null;
        }
        dilayani.next = null;
        jumlah--;
        return dilayani;
    }

    // melakukan cek nomor antrian yang sedang tunggu agar tdk double
    public boolean nomorSudahAda(String nomor) {
        Node sekarang = depan;
        while (sekarang != null) {
            if (sekarang.nomorAntrian.equalsIgnoreCase(nomor)) {
                return true;
            }
            sekarang = sekarang.next;
        }
        return false;
    }

    // melakukan show antrian sekarang dari awal sampe akhir
    public void tampilkanAntrian() {
        System.out.println("\nDaftar Antrian:");
        if (depan == null) {
            System.out.println("Antrian masih kosong.");
        }
        Node sekarang = depan;
        while (sekarang != null) {
            System.out.println("Nomor: " + sekarang.nomorAntrian
                    + " | Nama: " + sekarang.namaPelanggan
                    + " | Total Belanja: Rp" + sekarang.totalBelanja);
            sekarang = sekarang.next;
        }
        System.out.println("Total Antrian: " + jumlah);
    }

    public int getJumlah() {
        return jumlah;
    }
}
