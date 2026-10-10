// node ini berisi data pelanggan dari queue dan stack
public class Node {
    String nomorAntrian;
    String namaPelanggan;
    long totalBelanja;
    Node next;

    public Node(String nomorAntrian, String namaPelanggan, long totalBelanja) {
        this.nomorAntrian = nomorAntrian;
        this.namaPelanggan = namaPelanggan;
        this.totalBelanja = totalBelanja;
        this.next = null;
    }
}
