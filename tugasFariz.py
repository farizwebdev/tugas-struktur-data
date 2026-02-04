# Deklarasi Fixed-Size Array kapasitas 10
# Di Python, Saya simulasikan fixed size dengan mengisi None sebanyak 10 kali
capacity = 10
nim_array = [None] * capacity
nama_array = [None] * capacity
jk_array = [None] * capacity

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
        # Input menu
        choice_input = input("Pilih menu: ")
        # Validasi apakah input angka atau bukan
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
            # INPUT NIM (LOOP SAMPAI BENAR)
            nim = ""
            while True:
                nim = input("Masukkan NIM: ")

                # Cek apakah angka
                if not nim.isdigit():
                    print(">> ERROR: NIM harus berupa ANGKA saja! Coba lagi.")
                    continue

                is_duplicate = False
                for i in range(count):
                    if nim_array[i] == nim:
                        is_duplicate = True
                        break

                if is_duplicate:
                    print(f">> ERROR: NIM {nim} sudah ada! Coba NIM lain.")
                else:
                    break # Lolos Validasi

            # INPUT NAMA (LOOP SAMPAI BENAR)
            nama = ""
            while True:
                nama = input("Masukkan Nama: ")

                is_nama_duplicate = False
                for i in range(count):
                    # .lower() agar tidak case sensitive
                    if nama_array[i].lower() == nama.lower():
                        is_nama_duplicate = True
                        break

                if is_nama_duplicate:
                    print(f">> ERROR: Nama \"{nama}\" sudah ada! Coba nama lain.")
                else:
                    break

            # INPUT JK (LOOP SAMPAI BENAR)
            jk = ""
            while True:
                input_jk = input("Masukkan Jenis Kelamin (L/P): ").upper()
                if input_jk == "L" or input_jk == "P":
                    jk = input_jk
                    break
                else:
                    print(">> ERROR: Input salah! Ketik 'L' atau 'P'.")

            # PROSES INSERT DEPAN (Geser ke Kanan)
            # range(start, stop, step) -> mundur dari count ke 1
            for i in range(count, 0, -1):
                nim_array[i] = nim_array[i-1]
                nama_array[i] = nama_array[i-1]
                jk_array[i] = jk_array[i-1]

            nim_array[0] = nim
            nama_array[0] = nama
            jk_array[0] = jk
            count += 1
            print(">> SUKSES: Data disimpan di awal.")

    # 2. INSERT AT GIVEN POSITION
    elif choice == 2:
        if count >= capacity:
            print(">> GAGAL: Array Penuh!")
        else:
            # INPUT POSISI (LOOP SAMPAI BENAR)
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
                    if nim_array[i] == nim:
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
                    if nama_array[i].lower() == nama.lower():
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

            # PROSES INSERT POSISI (Geser ke Kanan)
            index = pos - 1
            for i in range(count, index, -1):
                nim_array[i] = nim_array[i-1]
                nama_array[i] = nama_array[i-1]
                jk_array[i] = jk_array[i-1]

            nim_array[index] = nim
            nama_array[index] = nama
            jk_array[index] = jk
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
                    if nim_array[i] == nim:
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
                    if nama_array[i].lower() == nama.lower():
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
            nim_array[count] = nim
            nama_array[count] = nama
            jk_array[count] = jk
            count += 1
            print(">> SUKSES: Data ditambahkan di akhir.")

    # 4. DELETE FROM BEGINNING
    elif choice == 4:
        if count == 0:
            print(">> GAGAL: Array Kosong!")
        else:
            # Geser ke Kiri (Maju)
            for i in range(0, count - 1):
                nim_array[i] = nim_array[i+1]
                nama_array[i] = nama_array[i+1]
                jk_array[i] = jk_array[i+1]

            # Hapus data terakhir (bersihkan sampah)
            nim_array[count - 1] = None
            nama_array[count - 1] = None
            jk_array[count - 1] = None
            count -= 1
            print(">> SUKSES: Data pertama dihapus.")

    # 5. DELETE GIVEN POSITION
    elif choice == 5:
        if count == 0:
            print(">> GAGAL: Array Kosong!")
        else:
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
                nim_array[i] = nim_array[i+1]
                nama_array[i] = nama_array[i+1]
                jk_array[i] = jk_array[i+1]

            nim_array[count - 1] = None
            nama_array[count - 1] = None
            jk_array[count - 1] = None
            count -= 1
            print(f">> SUKSES: Data posisi {pos} dihapus.")

    # 6. DELETE FROM END
    elif choice == 6:
        if count == 0:
            print(">> GAGAL: Array Kosong!")
        else:
            nim_array[count - 1] = None
            nama_array[count - 1] = None
            jk_array[count - 1] = None
            count -= 1
            print(">> SUKSES: Data terakhir dihapus.")

    # 7. DELETE BY NIM (FIRST OCCURRENCE)
    elif choice == 7:
        if count == 0:
            print(">> GAGAL: Array Kosong!")
        else:
            target_nim = input("Masukkan NIM yang akan dihapus: ")
            found_index = -1

            # Linear Search
            for i in range(count):
                if nim_array[i] == target_nim:
                    found_index = i
                    break

            if found_index != -1:
                # Geser Kiri
                for i in range(found_index, count - 1):
                    nim_array[i] = nim_array[i+1]
                    nama_array[i] = nama_array[i+1]
                    jk_array[i] = jk_array[i+1]

                nim_array[count - 1] = None
                nama_array[count - 1] = None
                jk_array[count - 1] = None
                count -= 1
                print(f">> SUKSES: NIM {target_nim} dihapus.")
            else:
                print(">> GAGAL: NIM tidak ditemukan.")

    # 8. SHOW DATA
    elif choice == 8:
        print("\nData Mahasiswa:")
        print("+-----+--------------+---------------------------+-----+")
        # Menggunakan f-string formatting untuk merapikan tabel
        # :<3 artinya rata kiri, lebar 3
        # :<12 artinya rata kiri, lebar 12, dst
        print(f"| {'No':<3} | {'NIM':<12} | {'Nama':<25} | {'L/P':<3} |")
        print("+-----+--------------+---------------------------+-----+")

        if count == 0:
            print(f"| {'DATA KOSONG':^50} |") # ^50 artinya rata tengah lebar 50
        else:
            for i in range(count):
                print(f"| {i+1:<3} | {nim_array[i]:<12} | {nama_array[i]:<25} | {jk_array[i]:<3} |")

        print("+-----+--------------+---------------------------+-----+")

    # 9. EXIT
    elif choice == 9:
        print("Keluar program...")
        break

    else:
        print(">> Menu tidak valid!")