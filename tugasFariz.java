public class tugasFariz {
    public static void main(String[] args) {
        // Deklarasi Fixed-Size Array kapasitas 10
        String[] nimArray = new String[10];
        String[] namaArray = new String[10];
        String[] jkArray = new String[10];

        int count = 0;
        int capacity = 10;
        int choice;

        java.util.Scanner sc = new java.util.Scanner(System.in);

        // HEADER
        System.out.println("\n=================================================");
        System.out.println("            TUGAS STRUKTUR DATA ARRAY            ");
        System.out.println("=================================================");
        System.out.println(" Nama    : Fariz Husain Albar");
        System.out.println(" Kelas   : Informatika A");
        System.out.println(" NIM     : 24106050011");
        System.out.println(" Matkul  : Struktur Data");
        System.out.println("=================================================");
        System.out.println(" >> Tekan ENTER untuk masuk ke Menu Program...");
        sc.nextLine();

        while (true) {
            System.out.println("\n=== MENU MAHASISWA (Count: " + count + "/" + capacity + ") ===");
            System.out.println("1. Insert at beginning");
            System.out.println("2. Insert at given position");
            System.out.println("3. Insert at end");
            System.out.println("4. Delete from beginning");
            System.out.println("5. Delete given position");
            System.out.println("6. Delete from end");
            System.out.println("7. Delete first occurence (by NIM)");
            System.out.println("8. Show data");
            System.out.println("9. Exit");
            System.out.print("Pilih menu: ");

            if (sc.hasNextInt()) {
                choice = sc.nextInt();
                sc.nextLine();
            } else {
                System.out.println(">> Input salah! Harap masukkan angka.");
                sc.next();
                continue;
            }

            // LOGIKA MENU

            // 1. INSERT AT BEGINNING
            if (choice == 1) {
                if (count >= capacity) {
                    System.out.println(">> GAGAL: Array Penuh!");
                } else {
                    // INPUT NIM (LOOP SAMPAI BENAR)
                    String nim = "";
                    while (true) {
                        System.out.print("Masukkan NIM: ");
                        nim = sc.nextLine();

                        if (!nim.matches("[0-9]+")) {
                            System.out.println(">> ERROR: NIM harus berupa ANGKA saja! Coba lagi.");
                            continue;
                        }

                        boolean isDuplicate = false;
                        for (int i = 0; i < count; i++) {
                            if (nimArray[i].equals(nim)) {
                                isDuplicate = true;
                                break;
                            }
                        }

                        if (isDuplicate) {
                            System.out.println(">> ERROR: NIM " + nim + " sudah ada! Coba NIM lain.");
                        } else {
                            break; // Lolos Validasi
                        }
                    }

                    // INPUT NAMA (LOOP SAMPAI BENAR)
                    String nama = "";
                    while (true) {
                        System.out.print("Masukkan Nama: ");
                        nama = sc.nextLine();

                        boolean isNamaDuplicate = false;
                        for (int i = 0; i < count; i++) {
                            if (namaArray[i].equalsIgnoreCase(nama)) {
                                isNamaDuplicate = true;
                                break;
                            }
                        }

                        if (isNamaDuplicate) {
                            System.out.println(">> ERROR: Nama \"" + nama + "\" sudah ada! Coba nama lain.");
                        } else {
                            break;
                        }
                    }

                    // INPUT JK (LOOP SAMPAI BENAR)
                    String jk = "";
                    while (true) {
                        System.out.print("Masukkan Jenis Kelamin (L/P): ");
                        String inputJk = sc.nextLine().toUpperCase();
                        if (inputJk.equals("L") || inputJk.equals("P")) {
                            jk = inputJk;
                            break;
                        } else {
                            System.out.println(">> ERROR: Input salah! Ketik 'L' atau 'P'.");
                        }
                    }

                    // PROSES INSERT DEPAN
                    for (int i = count; i > 0; i--) {
                        nimArray[i] = nimArray[i - 1];
                        namaArray[i] = namaArray[i - 1];
                        jkArray[i] = jkArray[i - 1];
                    }
                    nimArray[0] = nim;
                    namaArray[0] = nama;
                    jkArray[0] = jk;
                    count++;
                    System.out.println(">> SUKSES: Data disimpan di awal.");
                }
            }

            // 2. INSERT AT GIVEN POSITION
            else if (choice == 2) {
                if (count >= capacity) {
                    System.out.println(">> GAGAL: Array Penuh!");
                } else {
                    // INPUT POSISI (LOOP SAMPAI BENAR)
                    // Ini yang kamu minta diperbaiki
                    int pos = 0;
                    while (true) {
                        System.out.print("Masukkan Posisi Insert (1 - " + (count + 1) + "): ");
                        if (sc.hasNextInt()) {
                            pos = sc.nextInt();
                            sc.nextLine(); // clear buffer

                            // Validasi Range
                            if (pos >= 1 && pos <= count + 1) {
                                break; // Posisi valid, keluar loop
                            } else {
                                System.out.println(">> ERROR: Posisi tidak valid! Hanya boleh 1 s/d " + (count + 1));
                            }
                        } else {
                            System.out.println(">> ERROR: Harap masukkan angka!");
                            sc.next(); // buang input sampah
                        }
                    }

                    // INPUT NIM (LOOP SAMPAI BENAR)
                    String nim = "";
                    while (true) {
                        System.out.print("Masukkan NIM: ");
                        nim = sc.nextLine();

                        if (!nim.matches("[0-9]+")) {
                            System.out.println(">> ERROR: NIM harus berupa ANGKA saja!");
                            continue;
                        }

                        boolean isDuplicate = false;
                        for (int i = 0; i < count; i++) {
                            if (nimArray[i].equals(nim)) {
                                isDuplicate = true;
                                break;
                            }
                        }
                        if (isDuplicate) {
                            System.out.println(">> ERROR: NIM " + nim + " sudah ada!");
                        } else {
                            break;
                        }
                    }

                    // INPUT NAMA (LOOP SAMPAI BENAR)
                    String nama = "";
                    while (true) {
                        System.out.print("Masukkan Nama: ");
                        nama = sc.nextLine();

                        boolean isNamaDuplicate = false;
                        for (int i = 0; i < count; i++) {
                            if (namaArray[i].equalsIgnoreCase(nama)) {
                                isNamaDuplicate = true;
                                break;
                            }
                        }
                        if (isNamaDuplicate) {
                            System.out.println(">> ERROR: Nama \"" + nama + "\" sudah ada!");
                        } else {
                            break;
                        }
                    }

                    // INPUT JK (LOOP SAMPAI BENAR)
                    String jk = "";
                    while (true) {
                        System.out.print("Masukkan Jenis Kelamin (L/P): ");
                        String inputJk = sc.nextLine().toUpperCase();
                        if (inputJk.equals("L") || inputJk.equals("P")) {
                            jk = inputJk;
                            break;
                        } else {
                            System.out.println(">> ERROR: Input salah! Ketik 'L' atau 'P'.");
                        }
                    }

                    // PROSES INSERT POSISI
                    int index = pos - 1;
                    for (int i = count; i > index; i--) {
                        nimArray[i] = nimArray[i - 1];
                        namaArray[i] = namaArray[i - 1];
                        jkArray[i] = jkArray[i - 1];
                    }
                    nimArray[index] = nim;
                    namaArray[index] = nama;
                    jkArray[index] = jk;
                    count++;
                    System.out.println(">> SUKSES: Data disisipkan di posisi " + pos);
                }
            }

            // 3. INSERT AT END
            else if (choice == 3) {
                if (count >= capacity) {
                    System.out.println(">> GAGAL: Array Penuh!");
                } else {
                    // INPUT NIM (LOOP)
                    String nim = "";
                    while (true) {
                        System.out.print("Masukkan NIM: ");
                        nim = sc.nextLine();

                        if (!nim.matches("[0-9]+")) {
                            System.out.println(">> ERROR: NIM harus berupa ANGKA saja!");
                            continue;
                        }

                        boolean isDuplicate = false;
                        for (int i = 0; i < count; i++) {
                            if (nimArray[i].equals(nim)) {
                                isDuplicate = true;
                                break;
                            }
                        }
                        if (isDuplicate) {
                            System.out.println(">> ERROR: NIM " + nim + " sudah ada!");
                        } else {
                            break;
                        }
                    }

                    // INPUT NAMA (LOOP)
                    String nama = "";
                    while (true) {
                        System.out.print("Masukkan Nama: ");
                        nama = sc.nextLine();

                        boolean isNamaDuplicate = false;
                        for (int i = 0; i < count; i++) {
                            if (namaArray[i].equalsIgnoreCase(nama)) {
                                isNamaDuplicate = true;
                                break;
                            }
                        }
                        if (isNamaDuplicate) {
                            System.out.println(">> ERROR: Nama \"" + nama + "\" sudah ada!");
                        } else {
                            break;
                        }
                    }

                    // INPUT JK (LOOP)
                    String jk = "";
                    while (true) {
                        System.out.print("Masukkan Jenis Kelamin (L/P): ");
                        String inputJk = sc.nextLine().toUpperCase();
                        if (inputJk.equals("L") || inputJk.equals("P")) {
                            jk = inputJk;
                            break;
                        } else {
                            System.out.println(">> ERROR: Input salah! Ketik 'L' atau 'P'.");
                        }
                    }

                    // PROSES INSERT BELAKANG
                    nimArray[count] = nim;
                    namaArray[count] = nama;
                    jkArray[count] = jk;
                    count++;
                    System.out.println(">> SUKSES: Data ditambahkan di akhir.");
                }
            }

            // 4. DELETE FROM BEGINNING
            else if (choice == 4) {
                if (count == 0) {
                    System.out.println(">> GAGAL: Array Kosong!");
                } else {
                    for (int i = 0; i < count - 1; i++) {
                        nimArray[i] = nimArray[i + 1];
                        namaArray[i] = namaArray[i + 1];
                        jkArray[i] = jkArray[i + 1];
                    }
                    nimArray[count - 1] = null;
                    namaArray[count - 1] = null;
                    jkArray[count - 1] = null;
                    count--;
                    System.out.println(">> SUKSES: Data pertama dihapus.");
                }
            }

            // 5. DELETE GIVEN POSITION
            else if (choice == 5) {
                if (count == 0) {
                    System.out.println(">> GAGAL: Array Kosong!");
                } else {
                    // INPUT POSISI HAPUS (LOOP SAMPAI BENAR)
                    int pos = 0;
                    while (true) {
                        System.out.print("Masukkan Posisi Hapus (1 - " + count + "): ");
                        if (sc.hasNextInt()) {
                            pos = sc.nextInt();
                            sc.nextLine();

                            if (pos >= 1 && pos <= count) {
                                break; // Posisi valid
                            } else {
                                System.out.println(">> ERROR: Posisi tidak ditemukan! Pilih 1 s/d " + count);
                            }
                        } else {
                            System.out.println(">> ERROR: Harap masukkan angka!");
                            sc.next();
                        }
                    }

                    // PROSES HAPUS
                    int index = pos - 1;
                    for (int i = index; i < count - 1; i++) {
                        nimArray[i] = nimArray[i + 1];
                        namaArray[i] = namaArray[i + 1];
                        jkArray[i] = jkArray[i + 1];
                    }
                    nimArray[count - 1] = null;
                    namaArray[count - 1] = null;
                    jkArray[count - 1] = null;
                    count--;
                    System.out.println(">> SUKSES: Data posisi " + pos + " dihapus.");
                }
            }

            // 6. DELETE FROM END
            else if (choice == 6) {
                if (count == 0) {
                    System.out.println(">> GAGAL: Array Kosong!");
                } else {
                    nimArray[count - 1] = null;
                    namaArray[count - 1] = null;
                    jkArray[count - 1] = null;
                    count--;
                    System.out.println(">> SUKSES: Data terakhir dihapus.");
                }
            }

            // 7. DELETE BY NIM (FIRST OCCURRENCE)
            else if (choice == 7) {
                if (count == 0) {
                    System.out.println(">> GAGAL: Array Kosong!");
                } else {
                    // Untuk Menu 7, logikanya beda sedikit.
                    // Jika NIM tidak ketemu, lebih baik kembali ke menu (bukan looping),
                    // karena mungkin user salah lihat NIM atau berubah pikiran.
                    System.out.print("Masukkan NIM yang akan dihapus: ");
                    String targetNim = sc.nextLine();
                    int foundIndex = -1;

                    for (int i = 0; i < count; i++) {
                        if (nimArray[i].equals(targetNim)) {
                            foundIndex = i;
                            break;
                        }
                    }

                    if (foundIndex != -1) {
                        for (int i = foundIndex; i < count - 1; i++) {
                            nimArray[i] = nimArray[i + 1];
                            namaArray[i] = namaArray[i + 1];
                            jkArray[i] = jkArray[i + 1];
                        }
                        nimArray[count - 1] = null;
                        namaArray[count - 1] = null;
                        jkArray[count - 1] = null;
                        count--;
                        System.out.println(">> SUKSES: NIM " + targetNim + " dihapus.");
                    } else {
                        System.out.println(">> GAGAL: NIM tidak ditemukan.");
                    }
                }
            }

            // 8. SHOW DATA
            else if (choice == 8) {
                System.out.println("\nData Mahasiswa:");
                System.out.println("+-----+--------------+---------------------------+-----+");
                System.out.printf("| %-3s | %-12s | %-25s | %-3s |%n", "No", "NIM", "Nama", "L/P");
                System.out.println("+-----+--------------+---------------------------+-----+");

                if (count == 0) {
                    System.out.printf("| %-50s |%n", "                  DATA KOSONG");
                } else {
                    for (int i = 0; i < count; i++) {
                        System.out.printf("| %-3d | %-12s | %-25s | %-3s |%n",
                                (i + 1), nimArray[i], namaArray[i], jkArray[i]);
                    }
                }
                System.out.println("+-----+--------------+---------------------------+-----+");
            }

            // 9. EXIT PROGRAM
            else if (choice == 9) {
                System.out.println("Keluar program...");
                break;
            } else {
                System.out.println(">> Menu tidak valid!");
            }
        } // End While

        sc.close();
    }
}