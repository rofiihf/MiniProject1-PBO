# Profil
## Rofi Hanif Fauzan
## 2309116026
## Manajemen Warnet

# Deskripsi
## Program ini merupakan aplikasi sederhana yang digunakan untuk mengelola member di sebuah warnet. Dengan fitur CRUD (Create, Read, Update, Delete), pengguna dapat menambahkan, melihat, memperbarui, dan menghapus data member

# Member.java
## package model;

public class Member {
    private String username;
    private String password;
    private int durasi;  // Durasi dalam jam
    private int nomorPC;

    // Konstruktor
    public Member(String username, String password, int durasi, int nomorPC) {
        this.username = username;
        this.password = password;
        this.durasi = durasi;
        this.nomorPC = nomorPC;
    }

    // Getter dan setter
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
