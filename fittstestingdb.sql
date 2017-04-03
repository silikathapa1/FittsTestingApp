-- phpMyAdmin SQL Dump
-- version 4.6.5.2
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Apr 04, 2017 at 12:37 AM
-- Server version: 10.1.21-MariaDB
-- PHP Version: 7.0.15

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `fittstestingdb`
--

-- --------------------------------------------------------

--
-- Table structure for table `trails_table`
--

CREATE TABLE `trails_table` (
  `id` int(11) NOT NULL,
  `username` varchar(55) NOT NULL,
  `trials` int(11) NOT NULL,
  `clicks` int(11) NOT NULL,
  `time` bigint(20) NOT NULL,
  `distance` int(11) NOT NULL,
  `CircleWidth` int(11) NOT NULL,
  `Amplitude` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `trails_table`
--

INSERT INTO `trails_table` (`id`, `username`, `trials`, `clicks`, `time`, `distance`, `CircleWidth`, `Amplitude`) VALUES
(476, 'silika', 1, 0, 2879, 3996, 16, 128),
(477, 'silika', 2, 0, 1832, 9555, 64, 512),
(478, 'silika', 3, 0, 1507, 6286, 32, 128);

--
-- Indexes for dumped tables
--

--
-- Indexes for table `trails_table`
--
ALTER TABLE `trails_table`
  ADD PRIMARY KEY (`id`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `trails_table`
--
ALTER TABLE `trails_table`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=479;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
