public class RekeningBank {

    // atribut //
    private String nomorRekening;
    private String namaPemilik;
    private double saldo;

    // constructor
    public RekeningBank(String nomorRekening, String namaPemilik, double saldo) {
        this.nomorRekening = nomorRekening;
        this.namaPemilik = namaPemilik;
        this.saldo = saldo;
    }

    // get //
    public String getNomorRekening() {
        return nomorRekening;
    }

    public String getNamaPemilik() {
        return namaPemilik;
    }

    public double getSaldo() {
        return saldo;
    }

    // set //
    public void setNomorRekening(String nomorRekening) {
        this.nomorRekening = nomorRekening;
    }

    public void setNamaPemilik(String namaPemilik) {
        this.namaPemilik = namaPemilik;
    }

    public void setSaldo(double saldo) {
        if (saldo >= 0) {
            this.saldo = saldo;
        } else {
            System.out.println("Saldo tidak boleh negatif!");
        }
    }

    // method setor //
    public void setorTunai(double jumlah) {
        if (jumlah > 0) {
            saldo += jumlah;
            System.out.println("Setor tunai Rp" + jumlah + " berhasil.");
        } else {
            System.out.println("Jumlah setoran harus lebih dari 0!");
        }
    }

    // method tarik //
    public void tarikTunai(double jumlah) {
        if (jumlah <= 0) {
            System.out.println("Jumlah penarikan harus lebih dari 0!");
        } else if (jumlah > saldo) {
            System.out.println("Saldo tidak cukup! Saldo Anda: Rp" + saldo);
        } else {
            saldo -= jumlah;
            System.out.println("Tarik tunai Rp" + jumlah + " berhasil.");
        }
    }

    // method tampil info //
    public void tampilkanInfo() {
        System.out.println("=============================");
        System.out.println("Nomor Rekening : " + nomorRekening);
        System.out.println("Nama Pemilik   : " + namaPemilik);
        System.out.println("Saldo          : Rp" + saldo);
        System.out.println("=============================");
    }

    public static void main(String[] args) {
        // bikin objek //
        RekeningBank rekening = new RekeningBank("1234567890", "Budi Santoso", 500000);

        System.out.println("--- Data Awal ---");
        rekening.tampilkanInfo();

        // coba method //
        System.out.println("\n--- Transaksi ---");
        rekening.setorTunai(250000);
        rekening.tarikTunai(100000);
        rekening.tarikTunai(5000000); // saldo tidak cukup

        // coba set //
        System.out.println("\n--- Ubah data (set) ---");
        rekening.setNamaPemilik("Budi Santoso, S.Kom");
        rekening.setNomorRekening("0987654321");

        // coba get //
        System.out.println("\n--- Ambil data (get) ---");
        System.out.println("Nomor Rekening : " + rekening.getNomorRekening());
        System.out.println("Nama Pemilik   : " + rekening.getNamaPemilik());
        System.out.println("Saldo Akhir    : Rp" + rekening.getSaldo());

        System.out.println("\n--- Data Akhir ---");
        rekening.tampilkanInfo();
    }
}