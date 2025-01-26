-- phpMyAdmin SQL Dump
-- version 5.2.0
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Waktu pembuatan: 26 Jan 2025 pada 14.02
-- Versi server: 10.4.27-MariaDB
-- Versi PHP: 8.2.0

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `db_uaspbo_krs`
--

-- --------------------------------------------------------

--
-- Struktur dari tabel `mahasiswa`
--

CREATE TABLE `mahasiswa` (
  `id_mahasiswa` int(11) NOT NULL,
  `nama_mahasiswa` varchar(50) NOT NULL,
  `npm` varchar(10) NOT NULL,
  `tempat_lahir` varchar(50) NOT NULL,
  `tanggal_lahir` date NOT NULL,
  `jurusan` varchar(50) NOT NULL,
  `angkatan` varchar(4) NOT NULL,
  `alamat` varchar(100) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data untuk tabel `mahasiswa`
--

INSERT INTO `mahasiswa` (`id_mahasiswa`, `nama_mahasiswa`, `npm`, `tempat_lahir`, `tanggal_lahir`, `jurusan`, `angkatan`, `alamat`) VALUES
(1, 'ss', '22100022', 'rantau', '2025-01-01', 'Teknik Informatika', '2022', 'da'),
(2, 'sani', '2210010100', 'rantau', '2025-01-02', 'Teknik Informatika', '2022', 'sani'),
(3, 'syarwani', '2210010100', 'Rantau', '2025-01-08', 'Teknik Informatika', '2022', 'jl. sekumpul'),
(4, 'Syarwani', '2210001000', 'Martapura', '2025-01-02', 'Teknik Informatika', '2022', 'sekumpul');

-- --------------------------------------------------------

--
-- Struktur dari tabel `table_krs`
--

CREATE TABLE `table_krs` (
  `id_krs` int(11) NOT NULL,
  `npm` varchar(10) NOT NULL,
  `nama_mahasiswa` varchar(50) NOT NULL,
  `semester` varchar(50) NOT NULL,
  `mata_kuliah` varchar(50) NOT NULL,
  `tahun_akademik` varchar(4) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data untuk tabel `table_krs`
--

INSERT INTO `table_krs` (`id_krs`, `npm`, `nama_mahasiswa`, `semester`, `mata_kuliah`, `tahun_akademik`) VALUES
(1, '22100022', 'ss', 'Item 1', 'Item 1', '2022'),
(2, '22100022', 'ss', 'Item 1', 'Item 1', '2022'),
(3, '2210010100', 'sani', 'Item 1', 'Item 1', '2022'),
(4, '22100022', 'ss', 'Item 2', 'Item 1', '2022'),
(5, '2210010100', 'sani', 'Item 4', 'Item 2', '2001'),
(6, '22100022', 'ss', 'Semester 2', 'ss', '2022'),
(7, '2210001000', 'Syarwani', 'Semester 2', 'PBO', '2022');

-- --------------------------------------------------------

--
-- Struktur dari tabel `table_matakuliah`
--

CREATE TABLE `table_matakuliah` (
  `id_matakuliah` int(11) NOT NULL,
  `kode_matakuliah` varchar(20) NOT NULL,
  `nama_matakuliah` varchar(50) NOT NULL,
  `jumlah_sks` varchar(20) NOT NULL,
  `semester` varchar(50) NOT NULL,
  `dosen` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data untuk tabel `table_matakuliah`
--

INSERT INTO `table_matakuliah` (`id_matakuliah`, `kode_matakuliah`, `nama_matakuliah`, `jumlah_sks`, `semester`, `dosen`) VALUES
(1, '001', 'PBO', 'Item 1', 'Semester 1', 'saidi'),
(2, '22100022', 'ss', 'Item 2', 'Item 3', '2022'),
(3, '22100022', 'ss', 'Item 1', 'Item 1', '2022'),
(4, '0001', 'PBO', 'Item 2', 'Semester 2', 'Suryani');

--
-- Indexes for dumped tables
--

--
-- Indeks untuk tabel `mahasiswa`
--
ALTER TABLE `mahasiswa`
  ADD PRIMARY KEY (`id_mahasiswa`);

--
-- Indeks untuk tabel `table_krs`
--
ALTER TABLE `table_krs`
  ADD PRIMARY KEY (`id_krs`);

--
-- Indeks untuk tabel `table_matakuliah`
--
ALTER TABLE `table_matakuliah`
  ADD PRIMARY KEY (`id_matakuliah`);

--
-- AUTO_INCREMENT untuk tabel yang dibuang
--

--
-- AUTO_INCREMENT untuk tabel `mahasiswa`
--
ALTER TABLE `mahasiswa`
  MODIFY `id_mahasiswa` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;

--
-- AUTO_INCREMENT untuk tabel `table_krs`
--
ALTER TABLE `table_krs`
  MODIFY `id_krs` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=8;

--
-- AUTO_INCREMENT untuk tabel `table_matakuliah`
--
ALTER TABLE `table_matakuliah`
  MODIFY `id_matakuliah` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
