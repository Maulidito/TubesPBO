-- phpMyAdmin SQL Dump
-- version 4.9.2
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Dec 12, 2019 at 03:47 PM
-- Server version: 10.4.10-MariaDB
-- PHP Version: 7.1.33

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `database`
--

-- --------------------------------------------------------

--
-- Table structure for table `customer`
--

CREATE TABLE `customer` (
  `Id_Customer` varchar(50) NOT NULL,
  `Nama_Customer` varchar(50) NOT NULL,
  `JenisKelamin_Customer` varchar(10) NOT NULL,
  `Tgl_Lahir_Customer` date NOT NULL,
  `Alamat_Customer` varchar(100) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `customer`
--

INSERT INTO `customer` (`Id_Customer`, `Nama_Customer`, `JenisKelamin_Customer`, `Tgl_Lahir_Customer`, `Alamat_Customer`) VALUES
('C001', 'Antika', 'PEREMPUAN', '2019-12-12', 'di hati');

-- --------------------------------------------------------

--
-- Table structure for table `pegawai`
--

CREATE TABLE `pegawai` (
  `Id_Pegawai` varchar(50) NOT NULL,
  `Nama_Pegawai` varchar(50) NOT NULL,
  `JenisKelamin_Pegawai` varchar(10) NOT NULL,
  `Tgl_Lahir_Pegawai` date NOT NULL,
  `Password_Pegawai` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Table structure for table `transaksi`
--

CREATE TABLE `transaksi` (
  `Id_Transaksi` varchar(50) NOT NULL,
  `id_Pegawai` varchar(50) NOT NULL,
  `id_Customer` varchar(50) NOT NULL,
  `JmlPakaian` int(20) NOT NULL,
  `JmlSepatu` int(20) NOT NULL,
  `TotalHarga` int(20) NOT NULL,
  `Proses` varchar(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Indexes for dumped tables
--

--
-- Indexes for table `customer`
--
ALTER TABLE `customer`
  ADD PRIMARY KEY (`Id_Customer`);

--
-- Indexes for table `pegawai`
--
ALTER TABLE `pegawai`
  ADD PRIMARY KEY (`Id_Pegawai`);

--
-- Indexes for table `transaksi`
--
ALTER TABLE `transaksi`
  ADD PRIMARY KEY (`Id_Transaksi`),
  ADD UNIQUE KEY `id_customer_fk` (`id_Customer`),
  ADD KEY `id_pegawai_fk` (`id_Pegawai`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
