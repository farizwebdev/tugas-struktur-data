public class tugasFariz {
    public static void main(String[] args) {

        String[][] dataArray = new String[10][3];

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
                    // INPUT NIM
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
                            // Cek Kolom 0 (NIM)
                            if (dataArray[i][0].equals(nim)) {
                                isDuplicate = true;
                                break;
                            }
                        }

                        if (isDuplicate) {
                            System.out.println(">> ERROR: NIM " + nim + " sudah ada! Coba NIM lain.");
                        } else {
                            break;
                        }
                    }

                    // INPUT NAMA
                    String nama = "";
                    while (true) {
                        System.out.print("Masukkan Nama: ");
                        nama = sc.nextLine();

                        boolean isNamaDuplicate = false;
                        for (int i = 0; i < count; i++) {
                            // Cek Kolom 1 (Nama)
                            if (dataArray[i][1].equalsIgnoreCase(nama)) {
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

                    // INPUT JK
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
                        dataArray[i][0] = dataArray[i - 1][0]; // NIM
                        dataArray[i][1] = dataArray[i - 1][1]; // Nama
                        dataArray[i][2] = dataArray[i - 1][2]; // JK
                    }
                    dataArray[0][0] = nim;
                    dataArray[0][1] = nama;
                    dataArray[0][2] = jk;
                    count++;
                    System.out.println(">> SUKSES: Data disimpan di awal.");
                }
            }

            // 2. INSERT AT GIVEN POSITION
            else if (choice == 2) {
                if (count >= capacity) {
                    System.out.println(">> GAGAL: Array Penuh!");
                } else {
                    // INPUT POSISI
                    int pos = 0;
                    while (true) {
                        System.out.print("Masukkan Posisi Insert (1 - " + (count + 1) + "): ");
                        if (sc.hasNextInt()) {
                            pos = sc.nextInt();
                            sc.nextLine();

                            if (pos >= 1 && pos <= count + 1) {
                                break;
                            } else {
                                System.out.println(">> ERROR: Posisi tidak valid! Hanya boleh 1 s/d " + (count + 1));
                            }
                        } else {
                            System.out.println(">> ERROR: Harap masukkan angka!");
                            sc.next();
                        }
                    }

                    // INPUT NIM
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
                            if (dataArray[i][0].equals(nim)) {
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

                    // INPUT NAMA
                    String nama = "";
                    while (true) {
                        System.out.print("Masukkan Nama: ");
                        nama = sc.nextLine();

                        boolean isNamaDuplicate = false;
                        for (int i = 0; i < count; i++) {
                            if (dataArray[i][1].equalsIgnoreCase(nama)) {
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

                    // INPUT JK
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
                        dataArray[i][0] = dataArray[i - 1][0];
                        dataArray[i][1] = dataArray[i - 1][1];
                        dataArray[i][2] = dataArray[i - 1][2];
                    }
                    dataArray[index][0] = nim;
                    dataArray[index][1] = nama;
                    dataArray[index][2] = jk;
                    count++;
                    System.out.println(">> SUKSES: Data disisipkan di posisi " + pos);
                }
            }

            // 3. INSERT AT END
            else if (choice == 3) {
                if (count >= capacity) {
                    System.out.println(">> GAGAL: Array Penuh!");
                } else {
                    // INPUT NIM
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
                            if (dataArray[i][0].equals(nim)) {
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

                    // INPUT NAMA
                    String nama = "";
                    while (true) {
                        System.out.print("Masukkan Nama: ");
                        nama = sc.nextLine();

                        boolean isNamaDuplicate = false;
                        for (int i = 0; i < count; i++) {
                            if (dataArray[i][1].equalsIgnoreCase(nama)) {
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

                    // INPUT JK
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
                    dataArray[count][0] = nim;
                    dataArray[count][1] = nama;
                    dataArray[count][2] = jk;
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
                        dataArray[i][0] = dataArray[i + 1][0];
                        dataArray[i][1] = dataArray[i + 1][1];
                        dataArray[i][2] = dataArray[i + 1][2];
                    }
                    dataArray[count - 1][0] = null;
                    dataArray[count - 1][1] = null;
                    dataArray[count - 1][2] = null;
                    count--;
                    System.out.println(">> SUKSES: Data pertama dihapus.");
                }
            }

            // 5. DELETE GIVEN POSITION
            else if (choice == 5) {
                if (count == 0) {
                    System.out.println(">> GAGAL: Array Kosong!");
                } else {
                    // INPUT POSISI HAPUS
                    int pos = 0;
                    while (true) {
                        System.out.print("Masukkan Posisi Hapus (1 - " + count + "): ");
                        if (sc.hasNextInt()) {
                            pos = sc.nextInt();
                            sc.nextLine();

                            if (pos >= 1 && pos <= count) {
                                break;
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
                        dataArray[i][0] = dataArray[i + 1][0];
                        dataArray[i][1] = dataArray[i + 1][1];
                        dataArray[i][2] = dataArray[i + 1][2];
                    }
                    dataArray[count - 1][0] = null;
                    dataArray[count - 1][1] = null;
                    dataArray[count - 1][2] = null;
                    count--;
                    System.out.println(">> SUKSES: Data posisi " + pos + " dihapus.");
                }
            }

            // 6. DELETE FROM END
            else if (choice == 6) {
                if (count == 0) {
                    System.out.println(">> GAGAL: Array Kosong!");
                } else {
                    dataArray[count - 1][0] = null;
                    dataArray[count - 1][1] = null;
                    dataArray[count - 1][2] = null;
                    count--;
                    System.out.println(">> SUKSES: Data terakhir dihapus.");
                }
            }

            // 7. DELETE BY NIM (FIRST OCCURRENCE)
            else if (choice == 7) {
                if (count == 0) {
                    System.out.println(">> GAGAL: Array Kosong!");
                } else {
                    System.out.print("Masukkan NIM yang akan dihapus: ");
                    String targetNim = sc.nextLine();
                    int foundIndex = -1;

                    for (int i = 0; i < count; i++) {
                        // Cek Kolom 0 (NIM)
                        if (dataArray[i][0].equals(targetNim)) {
                            foundIndex = i;
                            break;
                        }
                    }

                    if (foundIndex != -1) {
                        for (int i = foundIndex; i < count - 1; i++) {
                            dataArray[i][0] = dataArray[i + 1][0];
                            dataArray[i][1] = dataArray[i + 1][1];
                            dataArray[i][2] = dataArray[i + 1][2];
                        }
                        dataArray[count - 1][0] = null;
                        dataArray[count - 1][1] = null;
                        dataArray[count - 1][2] = null;
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
                        // Akses array 2D: [Baris][0], [Baris][1], [Baris][2]
                        System.out.printf("| %-3d | %-12s | %-25s | %-3s |%n",
                                (i + 1), dataArray[i][0], dataArray[i][1], dataArray[i][2]);
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
