# SuitMediaTest_Elvindo
Technical Test Suit Media  - Mochamad Elvindo 

# Technical Test Suit Media (Intern Mobile Developer)

## 📖 Deskripsi
Aplikasi Android ini memiliki tiga layar utama:
1. **First Screen** - Memeriksa apakah suatu kata atau kalimat adalah *palindrome* dan menyimpan nama pengguna.
2. **Second Screen** - Menampilkan nama pengguna yang dimasukkan dari First Screen dan memungkinkan pengguna memilih user dari daftar.
3. **Third Screen** - Menampilkan daftar user dari API dan memungkinkan pengguna memilih salah satu user.

---

### 🎥 Video Demo
(https://drive.google.com/file/d/13kp9DS3fOhiKHe3hx03BFt95ISkl7RH5/view?usp=sharing)

---

## 📸 Tampilan Aplikasi
### **🔹 First Screen - Input Name dan Palindrome Checker**
Menampilkan input nama, input teks untuk pengecekan palindrome, dan dua tombol:  
- **"Check"** untuk menampilkan dialog apakah teks adalah palindrome.
- **"Next"** untuk menuju ke Second Screen.

<img src="https://drive.google.com/uc?export=view&id=1fGmzlpi0qMN1gzij_Ao9RzibaCf8kFmQ" width="300">

---

### **🔹 Second Screen - User Selector**
- Menampilkan **nama pengguna dari First Screen**.
- Menampilkan **nama user yang dipilih dari Third Screen**.
- Tombol **"Choose a User"** untuk berpindah ke Third Screen.

<img src="https://drive.google.com/uc?export=view&id=1kchm4VY7o8qZwzf68AVV-wazuLB0bJ7L" width="300">

---

### **🔹 Third Screen - User List dari API**
- Mengambil daftar user dari `https://reqres.in/api/`.
- Menggunakan **RecyclerView** untuk menampilkan avatar, nama, dan email.
- Ketika user dipilih, namanya akan kembali ke Second Screen.

<img src="https://drive.google.com/uc?export=view&id=1-A42EhjcONbEIX--CgiF_SC36ykHLsQp" width="300">

---

## 🎯 Fitur Utama
✅ **Palindrome Checker** - Menentukan apakah teks yang dimasukkan adalah *palindrome*.  
✅ **API Integration** - Mengambil daftar user dari API.  
✅ **RecyclerView** - Menampilkan daftar user dengan avatar, nama, dan email.  
✅ **Navigation Component** - Mengelola perpindahan antar layar dengan *safe args*.  
