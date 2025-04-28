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

# Penggunaan dan Fitur-fitur Program

Di bawah ini merupakan penggunaan dan fitur-fitur dari Program Investasi Saham dan Surat Berharga Negara (SBN) beserta hasil screenshotdari setiap skenario kode program. Beberapa penjelasan mengenai bagaimana kode program berjalan dijelaskan di bawah ini.
## Login Admin dan Customer
![Login User   Admin_1](https://github.com/user-attachments/assets/6e4a66ee-4da1-43c8-801e-c5488cf86c5f)
![Login User   Admin_2](https://github.com/user-attachments/assets/a9c236b8-f280-4114-bd90-940f9119ef1b)
![Login User   Admin_3](https://github.com/user-attachments/assets/d618a4cb-0423-4d0f-96be-1677afee88d3)
![Login User   Admin_4](https://github.com/user-attachments/assets/802b0d1f-c3ae-43a8-8613-ee2f7a714ad9)
![Login User   Admin_5](https://github.com/user-attachments/assets/097b477c-2f87-4ddd-a0a1-44afa39e6056)
![Login User   Admin_6](https://github.com/user-attachments/assets/c93d4684-219c-4be5-b5f5-056cb4501c5c)
Setelah user memilih untuk melakukan login sebagai siapa, user akan  diminta login dengan username dan password mereka (yang di-hardcode dalam program). Jika login berhasil, maka user akan diarahkan ke menu sesuai role mereka. Jika login gagal, maka akan muncul pesan error untuk memberikan user dan password yang benar, lalu user akan kembali diminta untuk memilih login sebagai siapa, seperti gambar di atas.

## Menu Administrator
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

## Menu Customer
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

## Lihat Daftar Saham dan SBN
Pada sistem ini, baik administrator maupun customer dapat melihat daftar saham dan daftar Surat Berharga Negara (SBN) yang tersedia.
![Lihat Daftar Saham](https://github.com/user-attachments/assets/1388ac07-e122-46c0-b87c-481e1c0569f2)
Pada tampilan ini, sistem akan menampilkan seluruh saham yang tersedia dalam format tabel. Informasi yang ditampilkan mencakup kode saham, nama perusahaan, dan harga saham.
Pengguna dapat membaca daftar saham ini untuk memilih saham mana yang akan dibeli atau diubah (khusus admin).

![Lihat Daftar SBN](https://github.com/user-attachments/assets/33f451a7-7f10-4751-afd8-210c21282c03)
Pada bagian daftar SBN, sistem akan menampilkan seluruh Surat Berharga Negara yang tersedia. Informasi yang diberikan meliputi nama SBN, persentase bunga tahunan, jangka waktu dalam tahun, tanggal jatuh tempo, dan kuota nasional.

Maka dengan melihat daftar ini, customer dapat mempertimbangkan untuk membeli saham atau SBN yang diinginkan, sedangkan admin dapat mengelola data saham atau SBN yang telah terdaftar di sistem.

## Tambah Saham dan SBN
![Tambah Saham dan SBN_1](https://github.com/user-attachments/assets/b2c3be06-9741-4505-9490-1786ae561c9f)
![Tambah Saham dan SBN_2](https://github.com/user-attachments/assets/6d2294d7-3743-421c-901b-ee0c347ee468)
![Tambah Saham dan SBN_3](https://github.com/user-attachments/assets/fb0267e0-5db8-460d-9199-8a449aaa1930)
Pada proses penambahan saham baru, admin akan diarahkan ke tampilan **Tambah Saham** seperti yang terlihat pada gambar di atas. Pada tahap ini, admin diminta untuk menginputkan data berupa **Kode Saham**, **Nama Perusahaan**, dan **Harga Saham**. Setelah semua data berhasil diinputkan, sistem akan menampilkan pesan **"Saham berhasil ditambahkan!"** sebagai tanda bahwa proses penambahan sudah sukses.

Setelah itu, sistem secara otomatis akan menampilkan **daftar saham terbaru** yang sudah mencakup saham yang baru saja ditambahkan. Hal ini memudahkan admin untuk langsung memverifikasi apakah data yang diinputkan sudah masuk ke dalam daftar.

![Tambah Saham dan SBN_4](https://github.com/user-attachments/assets/59e55cfd-3fbe-4c46-889d-acebc2d31925)
![Tambah Saham dan SBN_5](https://github.com/user-attachments/assets/8320da92-735d-4b04-9ff6-b102ffa7a9a6)
![Tambah Saham dan SBN_6](https://github.com/user-attachments/assets/2ab0a5df-5e4d-412f-833e-7d1c639d61f4)
Begitu juga dalam proses penambahan Surat Berharga Negara (SBN), seperti pada gambar di atas. Admin akan diarahkan ke tampilan **Tambah SBN** di mana admin diminta menginputkan **Nama SBN**, **Bunga (%)**, **Jangka Waktu (tahun)**, **Tanggal Jatuh Tempo (yyyy-MM-dd)**, dan **Kuota Nasional**. Setelah seluruh data diisi dengan benar, sistem akan memberikan pesan **"SBN berhasil ditambahkan!"** untuk memastikan bahwa proses penambahan berhasil.

Selanjutnya, sistem akan menampilkan **daftar SBN terbaru** yang sudah diperbarui dengan data SBN yang baru saja diinputkan. Dengan demikian, admin dapat langsung memastikan bahwa penambahan SBN telah berhasil dan terlihat pada daftar yang tersedia.

## Ubah Saham
Pada submenu **Kelola Saham - Admin**, admin dapat memilih opsi untuk mengubah harga saham yang sudah terdaftar. Setelah memilih opsi ini, akan ditampilkan form input dengan prompt:
![Ubah Harga Saham_1](https://github.com/user-attachments/assets/49ac731f-78bd-4d62-b406-12b05d76044e)
Admin kemudian akan diminta untuk memilih kode saham dari **daftar saham yang tersedia**, kemudian menginputkan **harga baru** untuk saham tersebut. Setelah admin selesai memasukkan harga baru dan mengonfirmasi perubahan, program akan menampilkan pesan sukses berupa:

![Ubah Harga Saham_2](https://github.com/user-attachments/assets/c43442f7-aee0-4df1-9ced-a42edeb73290)
Setelah pesan sukses ditampilkan, program akan menunggu admin untuk menekan tombol enter. Begitu enter ditekan, admin akan diarahkan kembali ke submenu **Kelola Saham - Admin**, sehingga admin bisa memilih aksi lain seperti menambah saham, melihat daftar saham, atau kembali ke menu utama administrator.

## Hapus Saham dan SBN
![Hapus Saham dan SBN_1](https://github.com/user-attachments/assets/ddbfea16-1cfb-4483-91d0-283a2d03be28)
![Hapus Saham dan SBN_2](https://github.com/user-attachments/assets/a0f98230-bc15-4d9d-b8d0-bbdd78437901)
![Hapus Saham dan SBN_3](https://github.com/user-attachments/assets/2e3af75d-fc10-43cd-9259-a67c85e559ff)
![Hapus Saham dan SBN_4](https://github.com/user-attachments/assets/00ee1e6a-bbd7-4db9-9a4b-1e7648a52ff7)
![Hapus Saham dan SBN_5](https://github.com/user-attachments/assets/f33307e0-4f12-4eee-bb5e-6b57b6352c87)
![Hapus Saham dan SBN_6](https://github.com/user-attachments/assets/b396ab12-825d-4e23-a903-10ae5f72397c)
Pada submenu **Kelola Saham - Admin** atau **Kelola SBN - Admin**, admin memiliki opsi untuk menghapus seluruh data saham atau seluruh data surat berharga negara (SBN) yang tersedia. Ketika admin memilih opsi ini, program akan terlebih dahulu memeriksa apakah daftar saham atau daftar SBN masih memiliki data.
- Jika daftar masih berisi data, maka seluruh data dalam daftar tersebut akan dihapus (dikosongkan). Setelah penghapusan berhasil, program akan menampilkan pesan sukses:
   ```
   Seluruh data Saham berhasil dihapus!
   ```
   atau
   ```
   Seluruh data SBN berhasil dihapus!
   ```
- Setelah muncul pesan sukses, apabila admin kembali memilih menu "Lihat Daftar Saham" atau "Lihat Daftar SBN", maka daftar akan tampil dalam kondisi kosong tanpa data apa pun.
- Jika admin mencoba memilih opsi hapus saham atau hapus SBN lagi setelah semua data dihapus, program akan menampilkan pesan gagal:
   ```
   Daftar Saham sudah kosong!
   ```
   atau
   ```
   Daftar SBN sudah kosong!
   ```
