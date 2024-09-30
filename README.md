# Profil
Rofi Hanif Fauzan
2309116026
Manajemen Warnet

# Deskripsi
Program ini merupakan aplikasi sederhana yang digunakan untuk mengelola member di sebuah warnet. Dengan fitur CRUD (Create, Read, Update, Delete), pengguna dapat menambahkan, melihat, memperbarui, dan menghapus data member

# Member.java
package model;

    public class Member {
        private String username;
        private String password;
        private int durasi; 
        private int nomorPC;
    
        public Member(String username, String password, int durasi, int nomorPC) {
            this.username = username;
            this.password = password;
            this.durasi = durasi;
            this.nomorPC = nomorPC;
        }
    
        public String getUsername() {
            return username;
        }
    
        public void setUsername(String username) {
            this.username = username;
        }
    
        public String getPassword() {
            return password;
        }
    
        public void setPassword(String password) {
            this.password = password;
        }
    
        public int getDurasi() {
            return durasi;
        }
    
        public void setDurasi(int durasi) {
            this.durasi = durasi;
        }
    
        public int getNomorPC() {
            return nomorPC;
        }
    
        public void setNomorPC(int nomorPC) {
            this.nomorPC = nomorPC;
        }
    
        @Override
        public String toString() {
            return "Username: " + username + "\n" +
                   "Password: " + password + "\n" +
                   "Durasi: " + durasi + " jam\n" +
                   "Nomor PC: " + nomorPC + "\n" +
                   "-----------------------------------------";
        }
    }

# ManajemenWarnet.java
    package service;
    
    import model.Member;
    import java.util.ArrayList;
    import java.util.Scanner;
    
    public class ManajemenWarnet {
    
        private static ArrayList<Member> daftarMember = new ArrayList<>();
    
        public static void tambahMember(Member member) {
            daftarMember.add(member);
            System.out.println("Member berhasil ditambahkan!");
        }
    
        public static void lihatDaftarMember() {
            if (daftarMember.isEmpty()) {
                System.out.println("Belum ada member.");
            } else {
                System.out.println("Daftar Member:");
                for (Member m : daftarMember) {
                    System.out.println(m.toString());
                }
            }
        }
    
        public static void updateMember(String username) {
            Scanner scanner = new Scanner(System.in);
            for (Member m : daftarMember) {
                if (m.getUsername().equals(username)) {
                    System.out.println("Masukkan data baru (ketik 0 jika tidak ingin mengubah):");
                    System.out.print("Username baru: ");
                    String newUsername = scanner.nextLine();
                    if (!newUsername.equals("0")) m.setUsername(newUsername);
    
                    System.out.print("Password baru: ");
                    String newPassword = scanner.nextLine();
                    if (!newPassword.equals("0")) m.setPassword(newPassword);
    
                    System.out.print("Durasi baru (dalam jam): ");
                    int newDurasi = scanner.nextInt();
                    if (newDurasi != 0) m.setDurasi(newDurasi);
    
                    System.out.print("Nomor PC baru: ");
                    int newNomorPC = scanner.nextInt();
                    if (newNomorPC != 0) m.setNomorPC(newNomorPC);
    
                    System.out.println("Member berhasil diperbarui!");
                    return;
                }
            }
            System.out.println("Member tidak ditemukan.");
        }
    
        public static void hapusMember(String username) {
            Member memberDihapus = null;
            for (Member m : daftarMember) {
                if (m.getUsername().equals(username)) {
                    memberDihapus = m;
                    break;
                }
            }
    
            if (memberDihapus != null) {
                daftarMember.remove(memberDihapus);
                System.out.println("Member " + username + " berhasil dihapus.");
            } else {
                System.out.println("Member tidak ditemukan.");
            }
        }
    
        public static void main(String[] args) {
            Scanner scanner = new Scanner(System.in);
            boolean running = true;
    
            while (running) {
                System.out.println("\n=== Manajemen Member Warnet ===");
                System.out.println("1. Tambah Member");
                System.out.println("2. Lihat Daftar Member");
                System.out.println("3. Update Member");
                System.out.println("4. Hapus Member");
                System.out.println("5. Keluar");
                System.out.print("Pilih menu: ");
                int pilihan = scanner.nextInt();
                scanner.nextLine();  // Konsumsi newline
    
                switch (pilihan) {
                    case 1:
                        System.out.print("Masukkan username: ");
                        String username = scanner.nextLine();
                        System.out.print("Masukkan password: ");
                        String password = scanner.nextLine();
                        System.out.print("Masukkan durasi (dalam jam): ");
                        int durasi = scanner.nextInt();
                        System.out.print("Masukkan nomor PC: ");
                        int nomorPC = scanner.nextInt();
                        Member memberBaru = new Member(username, password, durasi, nomorPC);
                        tambahMember(memberBaru);
                        break;
                    case 2:
                        lihatDaftarMember();
                        break;
                    case 3:
                        System.out.print("Masukkan username member yang ingin di-update: ");
                        String usernameUpdate = scanner.nextLine();
                        updateMember(usernameUpdate);
                        break;
                    case 4:
                        System.out.print("Masukkan username member yang ingin dihapus: ");
                        String usernameHapus = scanner.nextLine();
                        hapusMember(usernameHapus);
                        break;
                    case 5:
                        running = false;
                        System.out.println("Terima kasih telah menggunakan Manajemen Member.");
                        break;
                    default:
                        System.out.println("Pilihan tidak valid.");
                }
            }
    
            scanner.close();
        }
    }

