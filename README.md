# PBO-Tugas1

# Program Investasi Saham dan Surat Berharga Negara (SBN)

Halo! Ini adalah proyek kecil kami untuk mengembangkan aplikasi investasi sederhana bernama GoInvest, yang dibuat untuk memenuhi Tugas 1 Mata Kuliah Pemrograman Berorientasi Objek (PBO).

Program berbasis Java ini dirancang untuk mendukung dua tipe pengguna, dengan hak akses berbeda:
1. **Admin** diberi kemampuan untuk mengelola daftar produk investasi, seperti menambah, melihat, dan menghapus produk saham dan SBN.
2. **Customer** diberikan akses untuk melakukan aktivitas investasi seperti membeli atau menjual saham, membeli produk SBN, melakukan simulasi kupon SBN, dan melihat portofolio investasinya.

Program ini juga menerapkan mekanisme login berbasis akun yang **hardcoded** langsung ke dalam kode program. Semua data dikelola di memori tanpa memanfaatkan database eksternal maupun file penyimpanan.

Di bawah ini akan dijelaskan fitur utama, cara kerja program, struktur kelas yang digunakan, dan UML dari program ini. Penjelasan lebih teknis dan detail bisa dilihat pada source code di repository ini, yang sudah disertai komentar untuk memudahkan pemahaman. Selamat membaca! 📚

---

# Identitas Kelompok

* Nama  : I Gusti Bagus Narendratanaya Wiweka  
  NIM   : 2405551007  
  Mata Kuliah : PBO (E)

* Nama  : Anak Agung Ngurah Bramanda Maha Saputra  
  NIM   : 2405551018  
  Mata Kuliah : PBO (E)

---

# UML
![UML_Program Investasi Saham dan SBN](https://github.com/user-attachments/assets/cdebc7f0-4613-4d63-a9aa-29bad1df4ddd)

---

# Struktur Kelas

- **Saham**
  - Atribut:
    - `kode` (String)
    - `namaPerusahaan` (String)
    - `harga` (int)

- **SuratBerhargaNegara**
  - Atribut:
    - `nama` (String)
    - `bunga` (double)
    - `jangkaWaktu` (int)
    - `tanggalJatuhTempo` (String)
    - `kuotaNasional` (int)

- **Admin**
  - Bertugas mengelola produk investasi.

- **Customer**
  - Bertugas melakukan investasi dan mengelola portofolio.

---

# Alur Penggunaan

1. Program pertama-tama meminta pengguna untuk login.
2. Setelah login berhasil:
   - **Admin** dapat masuk ke menu kelola saham dan kelola SBN.
   - **Customer** bisa memilih untuk beli saham, jual saham, beli SBN, simulasi kupon SBN, melihat portofolio, melihat daftar saham, atau melihat daftar SBN yang tersedia.
3. **Investasi Saham**:
   - Customer melihat daftar saham.
   - Memilih saham yang ingin dibeli.
   - Memasukkan jumlah lembar yang ingin dibeli.
4. **Penjualan Saham**:
   - Customer melihat daftar saham yang dimiliki.
   - Memilih saham untuk dijual.
   - Memasukkan jumlah lembar yang ingin dijual (dengan validasi jumlah kepemilikan).
5. **Pembelian SBN**:
   - Customer melihat daftar SBN yang tersedia.
   - Memilih SBN yang diinginkan.
   - Memasukkan nominal investasi yang akan dibeli, selama kuota masih tersedia.
6. **Simulasi SBN**:
   - Customer dapat menghitung estimasi kupon bulanan dari SBN yang dimiliki.
   - Formula simulasi kupon SBN:
     ```
     (%Bunga / 12 bulan) * 90% * Nominal Investasi
     ```
7. **Portofolio**:
   - Menampilkan daftar saham dan SBN yang dimiliki lengkap dengan:
     - Jumlah lembar saham.
     - Total nilai pembelian saham.
     - Total nilai pasar saham berdasarkan harga terbaru.
     - Daftar SBN dan total nominal investasinya.
     - Estimasi bunga SBN per bulan.

---

# Konsep Pemrograman yang Diterapkan

Dalam membangun program ini, kami menggunakan berbagai konsep dari Pemrograman Berorientasi Objek (OOP), antara lain:
1. **Penggunaan Class dan Object** dalam memodelkan entitas investasi.
2. **Control Flow Statements** seperti while loop, do-while loop, if-else, dan switch-case untuk mengelola alur program.
3. **ArrayList** digunakan untuk menyimpan daftar produk investasi dan portofolio.
4. **Inheritance** untuk memperluas fungsionalitas penanganan error input dengan mewarisi sifat dari kelas Exception melalui pembuatan kelas InvalidInputException, yang digunakan oleh kelas Input untuk validasi input user.
5. **Encapsulation** dalam pengaturan atribut dan metode di setiap class.

---

# Struktur Program

## Fitur-fitur Program
Di bawah ini merupakan penggunaan dan fitur-fitur dari Program Investasi Saham dan Surat Berharga Negara (SBN) beserta hasil screenshotdari setiap skenario kode program. Beberapa penjelasan mengenai bagaimana kode program berjalan dijelaskan di bawah ini.
### Login Admin dan Customer
![Login User   Admin_1](https://github.com/user-attachments/assets/cdfd2a1e-8ff9-4b5b-8e6c-239f74194550)
![Login User   Admin_2](https://github.com/user-attachments/assets/a9c236b8-f280-4114-bd90-940f9119ef1b)
![Login User   Admin_3](https://github.com/user-attachments/assets/d618a4cb-0423-4d0f-96be-1677afee88d3)
![Login User   Admin_4](https://github.com/user-attachments/assets/802b0d1f-c3ae-43a8-8613-ee2f7a714ad9)
![Login User   Admin_5](https://github.com/user-attachments/assets/097b477c-2f87-4ddd-a0a1-44afa39e6056)
![Login User   Admin_6](https://github.com/user-attachments/assets/c93d4684-219c-4be5-b5f5-056cb4501c5c)
Setelah user memilih untuk melakukan login sebagai siapa, user akan  diminta login dengan username dan password mereka (yang di-hardcode dalam program). Jika login berhasil, maka user akan diarahkan ke menu sesuai role mereka. Jika login gagal, maka akan muncul pesan error untuk memberikan user dan password yang benar, lalu user akan kembali diminta untuk memilih login sebagai siapa, seperti gambar di atas.
