package amil.ku1;


public class zakat extends Koneksi {

    static void showMenu() {
        System.out.println("\n========= MENU UTAMA =========");
        System.out.println("1. Insert Data Zakat");
        System.out.println("2. Show Data Zakat");
        System.out.println("3. Edit Data Zakat");
        System.out.println("4. Delete Data Zakat");
        System.out.println("0. Keluar");
        System.out.println("");
        System.out.print("PILIHAN> ");

        try {
            int pilihan = Integer.parseInt(input.readLine());

            switch (pilihan) {
                case 0:
                    System.exit(0);
                    break;
                case 1:
                    insertZakat();
                    break;
                case 2:
                    showData();     
                    break;
                case 3:
                    updateZakat();
                    break;
                case 4:
                    deleteZakat();
                    break;
                default:
                    System.out.println("Pilihan salah!");

            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    static void showData(){
            String sql = "SELECT * FROM zakat";

            try {
                rs = stmt.executeQuery(sql);

                System.out.println("+--------------------------------+");
                System.out.println("|       DATA Zakat         |");
                System.out.println("+--------------------------------+");

                while (rs.next()) {
                    int idMuzakki = rs.getInt("idMuzakki");
                    String namaMuzakki= rs.getString("namaMuzakki");
                    float jumlah = rs.getFloat("jumlah");
                    String tanggal = rs.getString("tanggal");
                    System.out.println(String.format("%d.%s--%s--(%s)", idMuzakki , namaMuzakki, jumlah, tanggal));
                }

            } catch (Exception e) {
                e.printStackTrace();
            }
            
        }

    static void insertZakat() {
        try {
            // ambil input dari user
            
 
            System.out.print("Nama Muzakki : ");
            String namaMuzakki = input.readLine().trim();
            
            System.out.print("Jumlah: ");
            String jumlah = input.readLine().trim();
            
            System.out.print("Tanggal (2 November 2020) :  ");
            String tanggal = input.readLine().trim();
            
            // query simpan
            String sql = "INSERT INTO zakat (namaMuzakki, jumlah, tanggal) VALUE('%s', '%s', '%s')";
            sql = String.format(sql, namaMuzakki, jumlah, tanggal);

            // simpan Akun
            stmt.execute(sql);
            
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    static void updateZakat() {
        try {
            
            // ambil input dari user
            System.out.print("ID yang mau diedit: ");
            int idMuzakki = Integer.parseInt(input.readLine());
            System.out.print("Nama Muzakki : ");
            String namaMuzakki = input.readLine().trim();
            
            System.out.print("Jumlah: ");
            String jumlah = input.readLine().trim();
            
            System.out.print("Tanggal (2 November 2020) :  ");
            String tanggal = input.readLine().trim();

            // query update
            String sql = "UPDATE zakat SET namaMuzakki='%s', jumlah='%s', tanggal='%s' WHERE idMuzakki=%d";
            sql = String.format(sql, namaMuzakki, jumlah, tanggal, idMuzakki);

            // update data Akun
            stmt.execute(sql);
            
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    static void deleteZakat() {
        try {
            
            // ambil input dari user
            System.out.print("ID yang mau dihapus: ");
            int idMuzakki = Integer.parseInt(input.readLine());
            
            // buat query hapus
            String sql = String.format("DELETE FROM zakat WHERE idMuzakki=%d", idMuzakki);

            // hapus data
            stmt.execute(sql);
            
            System.out.println("Data telah terhapus...");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}


