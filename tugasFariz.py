# Deklarasi Fixed-Size Array kapasitas 10
capacity = 10

# Saya menginisialisasi array 2D yang benar di Python agar setiap baris independen pak
data_array = [[None] * 3 for _ in range(capacity)]

count = 0

# HEADER IDENTITAS
print("\n" + "="*49)
print("            TUGAS STRUKTUR DATA ARRAY            ")
print("="*49)
print(" Nama    : Fariz Husain Albar")
print(" NIM     : 24106050011")
print(" Kelas   : Informatika A")
print(" Matkul  : Struktur Data")
print("="*49)
input(" >> Tekan ENTER untuk masuk ke Menu Program...")

while True:
    print(f"\n=== MENU MAHASISWA (Count: {count}/{capacity}) ===")
    print("1. Insert at beginning")
    print("2. Insert at given position")
    print("3. Insert at end")
    print("4. Delete from beginning")
    print("5. Delete given position")
    print("6. Delete from end")
    print("7. Delete first occurence (by NIM)")
    print("8. Show data")
    print("9. Exit")

    try:
        choice_input = input("Pilih menu: ")
        if not choice_input.isdigit():
             print(">> Input salah! Harap masukkan angka.")
             continue
        choice = int(choice_input)

    except ValueError:
        print(">> Input salah! Harap masukkan angka.")
        continue

    # LOGIKA MENU

    # 1. INSERT AT BEGINNING
    if choice == 1:
        if count >= capacity:
            print(">> GAGAL: Array Penuh!")
        else:
            # INPUT NIM
            nim = ""
            while True:
                nim = input("Masukkan NIM: ")
                if not nim.isdigit():
                    print(">> ERROR: NIM harus berupa ANGKA saja! Coba lagi.")
                    continue

                is_duplicate = False
                for i in range(count):
                    # Cek Kolom 0 (NIM)
                    if data_array[i][0] == nim:
                        is_duplicate = True
                        break

                if is_duplicate:
                    print(f">> ERROR: NIM {nim} sudah ada! Coba NIM lain.")
                else:
                    break

            # INPUT NAMA
            nama = ""
            while True:
                nama = input("Masukkan Nama: ")
                is_nama_duplicate = False
                for i in range(count):
                    # Cek Kolom 1 (Nama)
                    if data_array[i][1].lower() == nama.lower():
                        is_nama_duplicate = True
                        break
                if is_nama_duplicate:
                    print(f">> ERROR: Nama \"{nama}\" sudah ada! Coba nama lain.")
                else:
                    break

            # INPUT JK
            jk = ""
            while True:
                input_jk = input("Masukkan Jenis Kelamin (L/P): ").upper()
                if input_jk == "L" or input_jk == "P":
                    jk = input_jk
                    break
                else:
                    print(">> ERROR: Input salah! Ketik 'L' atau 'P'.")

            # PROSES INSERT DEPAN (Geser ke Kanan)
            for i in range(count, 0, -1):
                # Geser per kolom
                data_array[i][0] = data_array[i-1][0] # NIM
                data_array[i][1] = data_array[i-1][1] # Nama
                data_array[i][2] = data_array[i-1][2] # JK

            # Isi Index 0
            data_array[0][0] = nim
            data_array[0][1] = nama
            data_array[0][2] = jk
            count += 1
            print(">> SUKSES: Data disimpan di awal.")

    # 2. INSERT AT GIVEN POSITION
    elif choice == 2:
        if count >= capacity:
            print(">> GAGAL: Array Penuh!")
        else:
            # INPUT POSISI
            pos = 0
            while True:
                try:
                    pos_input = input(f"Masukkan Posisi Insert (1 - {count + 1}): ")
                    if not pos_input.isdigit():
                        print(">> ERROR: Harap masukkan angka!")
                        continue

                    pos = int(pos_input)
                    if 1 <= pos <= count + 1:
                        break
                    else:
                        print(f">> ERROR: Posisi tidak valid! Hanya boleh 1 s/d {count + 1}")
                except ValueError:
                    print(">> ERROR: Harap masukkan angka!")

            # INPUT NIM
            nim = ""
            while True:
                nim = input("Masukkan NIM: ")
                if not nim.isdigit():
                    print(">> ERROR: NIM harus berupa ANGKA saja!")
                    continue

                is_duplicate = False
                for i in range(count):
                    if data_array[i][0] == nim:
                        is_duplicate = True
                        break
                if is_duplicate:
                    print(f">> ERROR: NIM {nim} sudah ada!")
                else:
                    break

            # INPUT NAMA
            nama = ""
            while True:
                nama = input("Masukkan Nama: ")
                is_nama_duplicate = False
                for i in range(count):
                    if data_array[i][1].lower() == nama.lower():
                        is_nama_duplicate = True
                        break
                if is_nama_duplicate:
                    print(f">> ERROR: Nama \"{nama}\" sudah ada!")
                else:
                    break

            # INPUT JK
            jk = ""
            while True:
                input_jk = input("Masukkan Jenis Kelamin (L/P): ").upper()
                if input_jk == "L" or input_jk == "P":
                    jk = input_jk
                    break
                else:
                    print(">> ERROR: Input salah! Ketik 'L' atau 'P'.")

            # PROSES INSERT POSISI
            index = pos - 1
            for i in range(count, index, -1):
                data_array[i][0] = data_array[i-1][0]
                data_array[i][1] = data_array[i-1][1]
                data_array[i][2] = data_array[i-1][2]

            data_array[index][0] = nim
            data_array[index][1] = nama
            data_array[index][2] = jk
            count += 1
            print(f">> SUKSES: Data disisipkan di posisi {pos}")

    # 3. INSERT AT END
    elif choice == 3:
        if count >= capacity:
            print(">> GAGAL: Array Penuh!")
        else:
            # INPUT NIM
            nim = ""
            while True:
                nim = input("Masukkan NIM: ")
                if not nim.isdigit():
                    print(">> ERROR: NIM harus berupa ANGKA saja!")
                    continue
                is_duplicate = False
                for i in range(count):
                    if data_array[i][0] == nim:
                        is_duplicate = True
                        break
                if is_duplicate:
                    print(f">> ERROR: NIM {nim} sudah ada!")
                else:
                    break

            # INPUT NAMA
            nama = ""
            while True:
                nama = input("Masukkan Nama: ")
                is_nama_duplicate = False
                for i in range(count):
                    if data_array[i][1].lower() == nama.lower():
                        is_nama_duplicate = True
                        break
                if is_nama_duplicate:
                    print(f">> ERROR: Nama \"{nama}\" sudah ada!")
                else:
                    break

            # INPUT JK
            jk = ""
            while True:
                input_jk = input("Masukkan Jenis Kelamin (L/P): ").upper()
                if input_jk == "L" or input_jk == "P":
                    jk = input_jk
                    break
                else:
                    print(">> ERROR: Input salah! Ketik 'L' atau 'P'.")

            # PROSES INSERT BELAKANG
            data_array[count][0] = nim
            data_array[count][1] = nama
            data_array[count][2] = jk
            count += 1
            print(">> SUKSES: Data ditambahkan di akhir.")

    # 4. DELETE FROM BEGINNING
    elif choice == 4:
        if count == 0:
            print(">> GAGAL: Array Kosong!")
        else:
            # Geser ke Kiri (Maju)
            for i in range(0, count - 1):
                data_array[i][0] = data_array[i+1][0]
                data_array[i][1] = data_array[i+1][1]
                data_array[i][2] = data_array[i+1][2]

            # Hapus data terakhir
            data_array[count - 1][0] = None
            data_array[count - 1][1] = None
            data_array[count - 1][2] = None
            count -= 1
            print(">> SUKSES: Data pertama dihapus.")

    # 5. DELETE GIVEN POSITION
    elif choice == 5:
        if count == 0:
            print(">> GAGAL: Array Kosong!")
        else:
            # INPUT POSISI
            pos = 0
            while True:
                try:
                    pos_input = input(f"Masukkan Posisi Hapus (1 - {count}): ")
                    if not pos_input.isdigit():
                        print(">> ERROR: Harap masukkan angka!")
                        continue

                    pos = int(pos_input)
                    if 1 <= pos <= count:
                        break
                    else:
                        print(f">> ERROR: Posisi tidak ditemukan! Pilih 1 s/d {count}")
                except ValueError:
                    print(">> ERROR: Harap masukkan angka!")

            index = pos - 1
            # Geser ke Kiri
            for i in range(index, count - 1):
                data_array[i][0] = data_array[i+1][0]
                data_array[i][1] = data_array[i+1][1]
                data_array[i][2] = data_array[i+1][2]

            data_array[count - 1][0] = None
            data_array[count - 1][1] = None
            data_array[count - 1][2] = None
            count -= 1
            print(f">> SUKSES: Data posisi {pos} dihapus.")

    # 6. DELETE FROM END
    elif choice == 6:
        if count == 0:
            print(">> GAGAL: Array Kosong!")
        else:
            data_array[count - 1][0] = None
            data_array[count - 1][1] = None
            data_array[count - 1][2] = None
            count -= 1
            print(">> SUKSES: Data terakhir dihapus.")

    # 7. DELETE BY NIM (FIRST OCCURRENCE)
    elif choice == 7:
        if count == 0:
            print(">> GAGAL: Array Kosong!")
        else:
            target_nim = input("Masukkan NIM yang akan dihapus: ")
            found_index = -1

            # Linear Search di Kolom 0
            for i in range(count):
                if data_array[i][0] == target_nim:
                    found_index = i
                    break

            if found_index != -1:
                # Geser Kiri
                for i in range(found_index, count - 1):
                    data_array[i][0] = data_array[i+1][0]
                    data_array[i][1] = data_array[i+1][1]
                    data_array[i][2] = data_array[i+1][2]

                data_array[count - 1][0] = None
                data_array[count - 1][1] = None
                data_array[count - 1][2] = None
                count -= 1
                print(f">> SUKSES: NIM {target_nim} dihapus.")
            else:
                print(">> GAGAL: NIM tidak ditemukan.")

    # 8. SHOW DATA
    elif choice == 8:
        print("\nData Mahasiswa:")
        print("+-----+--------------+---------------------------+-----+")
        print(f"| {'No':<3} | {'NIM':<12} | {'Nama':<25} | {'L/P':<3} |")
        print("+-----+--------------+---------------------------+-----+")

        if count == 0:
            print(f"| {'DATA KOSONG':^50} |")
        else:
            for i in range(count):
                # Akses data 2D: [i][0], [i][1], [i][2]
                print(f"| {i+1:<3} | {data_array[i][0]:<12} | {data_array[i][1]:<25} | {data_array[i][2]:<3} |")

        print("+-----+--------------+---------------------------+-----+")

    # 9. EXIT
    elif choice == 9:
        print("Keluar program...")
        break

    else:
        print(">> Menu tidak valid!")
