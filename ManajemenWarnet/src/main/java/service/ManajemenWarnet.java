/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
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

