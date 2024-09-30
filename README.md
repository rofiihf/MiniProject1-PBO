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

# Output Program
## Main Menu
Saat program pertama kali dijalankan, akan menampilkan beberapa opsi yaitu Create, Read, Update, dan Delete
![image](https://github.com/user-attachments/assets/86eab476-14b4-410a-8843-b0814fc15435)
## Create
Opsi ini memungkinkan pengguna untuk menambahkan member baru. Setelah dipilih, program akan meminta pengguna untuk memasukkan informasi member, seperti username, password, durasi, dan nomor PC yang digunakan. Setelah data dimasukkan, member akan disimpan dalam daftar

![image](https://github.com/user-attachments/assets/b5327816-0b48-48be-9845-08d7e15305f5)
## Read
Opsi ini menampilkan daftar semua member yang telah terdaftar dalam sistem. Setiap member ditampilkan dengan informasi lengkap yang meliputi username, password, durasi, dan nomor PC
![image](https://github.com/user-attachments/assets/af70f5f0-6873-4409-bb56-98b23d29c953)
## Update
Opsi ini digunakan untuk memperbarui informasi dari member yang ada. Pengguna harus memasukkan username dari member yang ingin diperbarui. Setelah itu, pengguna akan diminta untuk memasukkan data baru untuk username, password, durasi penggunaan, dan nomor PC. Jika ada data yang tidak ingin diubah, pengguna dapat mengetik 0 untuk melewatkan bagian tersebut.
![image](https://github.com/user-attachments/assets/ba81f6a9-d8d9-4c7b-b6a3-2345ab6d3e1d)
## Delete
Opsi ini memungkinkan pengguna untuk menghapus member dari sistem. Pengguna akan diminta memasukkan username dari member yang ingin dihapus. Jika username ditemukan, member tersebut akan dihapus dari daftar dan tidak akan muncul lagi di daftar member.
![image](https://github.com/user-attachments/assets/83b10c42-8c30-4dca-a6e1-1bff3e39a9b7)
## Exit
Opsi ini digunakan untuk mengakhiri program.
![image](https://github.com/user-attachments/assets/c22a4194-24f0-4e1c-bcf0-4b7f84399510)



