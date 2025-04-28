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
![PBO-Tugas-1 drawio](https://github.com/user-attachments/assets/57fc4dd7-365d-40c7-a717-9cf199bbbda9)

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
![Login User   Admin_1](https://github.com/user-attachments/assets/6e4a66ee-4da1-43c8-801e-c5488cf86c5f)
![Login User   Admin_2](https://github.com/user-attachments/assets/a9c236b8-f280-4114-bd90-940f9119ef1b)
![Login User   Admin_3](https://github.com/user-attachments/assets/d618a4cb-0423-4d0f-96be-1677afee88d3)
![Login User   Admin_4](https://github.com/user-attachments/assets/802b0d1f-c3ae-43a8-8613-ee2f7a714ad9)
![Login User   Admin_5](https://github.com/user-attachments/assets/097b477c-2f87-4ddd-a0a1-44afa39e6056)
![Login User   Admin_6](https://github.com/user-attachments/assets/c93d4684-219c-4be5-b5f5-056cb4501c5c)
Setelah user memilih untuk melakukan login sebagai siapa, user akan  diminta login dengan username dan password mereka (yang di-hardcode dalam program). Jika login berhasil, maka user akan diarahkan ke menu sesuai role mereka. Jika login gagal, maka akan muncul pesan error untuk memberikan user dan password yang benar, lalu user akan kembali diminta untuk memilih login sebagai siapa, seperti gambar di atas.

### Menu Administrator
![Menu Admin_1](https://github.com/user-attachments/assets/87ec80ee-9f73-468c-ab2b-0727d19b8519)
![Menu Admin_2](https://github.com/user-attachments/assets/d5a2c0ae-a499-42bd-b44d-a3d9a4883661)
![Menu Admin_3](https://github.com/user-attachments/assets/4f725c8e-82de-4b5c-927e-01dc372fb0d5)
Setelah melakukan login sebagai administrator, user akan diberikan instruksi pada menu utama administrator seperti pada gambar di atas. Di menu ini, admin dapat memilih untuk mengelola data saham, mengelola data surat berharga negara (SBN), atau melakukan logout dari sistem dengan menginputkan angka sesuai dengan pilihan yang tersedia.

Jika admin memilih untuk **mengelola saham**, maka akan diarahkan ke submenu **Kelola Saham - Admin** seperti pada gambar berikutnya. Pada submenu ini, admin dapat melakukan beberapa aksi penting seperti:
 - Menambah saham baru ke dalam daftar,
 - Mengubah harga saham yang sudah ada,
 - Melihat daftar seluruh saham yang tersedia,
 - Menghapus saham dari daftar,
 - Atau kembali ke menu utama administrator.

Jika admin memilih untuk **mengelola surat berharga negara (SBN)**, maka akan diarahkan ke submenu **Kelola SBN - Admin**. Pada submenu ini, admin dapat:
 - Menambahkan SBN baru,
 - Melihat daftar seluruh SBN yang tersedia,
 - Menghapus SBN dari daftar,
 - Atau kembali ke menu utama administrator.

### Menu Customer
![Menu Customer](https://github.com/user-attachments/assets/dae601dc-4143-4bff-925b-1a1a5a0732a9)
Setelah melakukan login sebagai customer, user akan diberikan instruksi kembali pada menu utama customer seperti pada gambar berikut. Pada menu ini, customer akan diminta untuk memilih opsi dengan menginputkan angka sesuai dengan pilihan yang tersedia. Fitur-fitur yang dapat dilakukan oleh customer, yaitu:
 - Customer dapat membeli saham dari daftar saham yang tersedia di sistem.
 - Customer dapat menjual saham yang telah dimiliki dalam portofolionya.
 - Customer dapat membeli Surat Berharga Negara (SBN) yang tersedia.
 - Customer dapat melakukan simulasi bunga untuk menghitung potensi keuntungan dari investasi di SBN.
 - Customer dapat melihat seluruh portofolio investasinya, baik saham maupun SBN yang sudah dibeli.
 - Customer dapat melihat semua daftar saham yang tersedia di sistem.
 - Customer dapat melihat semua daftar Surat Berharga Negara (SBN) yang tersedia.
 - Customer dapat keluar dari akun dan kembali ke halaman login utama.

### Lihat Daftar Saham dan SBN
Pada sistem ini, baik administrator maupun customer dapat melihat daftar saham dan daftar Surat Berharga Negara (SBN) yang tersedia.
![Lihat Daftar Saham](https://github.com/user-attachments/assets/1388ac07-e122-46c0-b87c-481e1c0569f2)
Pada tampilan ini, sistem akan menampilkan seluruh saham yang tersedia dalam format tabel. Informasi yang ditampilkan mencakup kode saham, nama perusahaan, dan harga saham.
Pengguna dapat membaca daftar saham ini untuk memilih saham mana yang akan dibeli atau diubah (khusus admin).

![Lihat Daftar SBN](https://github.com/user-attachments/assets/33f451a7-7f10-4751-afd8-210c21282c03)
Pada bagian daftar SBN, sistem akan menampilkan seluruh Surat Berharga Negara yang tersedia. Informasi yang diberikan meliputi nama SBN, persentase bunga tahunan, jangka waktu dalam tahun, tanggal jatuh tempo, dan kuota nasional.

Maka dengan melihat daftar ini, customer dapat mempertimbangkan untuk membeli saham atau SBN yang diinginkan, sedangkan admin dapat mengelola data saham atau SBN yang telah terdaftar di sistem.
