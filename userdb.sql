-- phpMyAdmin SQL Dump
-- version 4.7.0
-- https://www.phpmyadmin.net/
--
-- Host: localhost
-- Generation Time: Jul 31, 2017 at 12:58 AM
-- Server version: 10.1.21-MariaDB
-- PHP Version: 5.6.30

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `userdb`
--

-- --------------------------------------------------------

--
-- Table structure for table `Asset`
--

CREATE TABLE `Asset` (
  `assetID` int(11) NOT NULL,
  `name` varchar(100) DEFAULT NULL,
  `serialNo` varchar(20) DEFAULT NULL,
  `type` varchar(10) DEFAULT NULL,
  `model` varchar(10) DEFAULT NULL,
  `make` varchar(10) DEFAULT NULL,
  `purchaseDate` date DEFAULT NULL,
  `lifeSpan` int(11) DEFAULT NULL,
  `comment` varchar(100) DEFAULT NULL,
  `make_id` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `Asset`
--

INSERT INTO `Asset` (`assetID`, `name`, `serialNo`, `type`, `model`, `make`, `purchaseDate`, `lifeSpan`, `comment`, `make_id`) VALUES
(32, 'Dell Laptop', '54', 'type', 'moddel', NULL, '2017-07-30', 3, 'Comment', 2),
(37, 'Dell Keyboard', '54', 'Type', 'Model', NULL, '2017-07-30', 3, 'jhgyuguh', 2),
(46, 'TEst Name', 'SN12345', NULL, 'DN', NULL, NULL, NULL, NULL, 1),
(48, 'TEst Name edited', 'SN12345', '', 'DN', NULL, '2017-07-30', NULL, '', 1);

-- --------------------------------------------------------

--
-- Table structure for table `makes`
--

CREATE TABLE `makes` (
  `make_id` bigint(20) NOT NULL,
  `name` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `makes`
--

INSERT INTO `makes` (`make_id`, `name`) VALUES
(1, 'My Make 1'),
(2, 'My Make 2');

-- --------------------------------------------------------

--
-- Table structure for table `Role`
--

CREATE TABLE `Role` (
  `roleID` int(11) NOT NULL,
  `descr` varchar(255) NOT NULL,
  `name` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `Role`
--

INSERT INTO `Role` (`roleID`, `descr`, `name`) VALUES
(1, 'System Administrator', 'Admin'),
(2, 'Normal User', 'Normal');

-- --------------------------------------------------------

--
-- Table structure for table `User`
--

CREATE TABLE `User` (
  `userID` int(11) NOT NULL,
  `username` varchar(100) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL,
  `password` varchar(100) NOT NULL,
  `businessUnt` varchar(100) DEFAULT NULL,
  `comment` varchar(100) DEFAULT NULL,
  `userRole_roleID` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `User`
--

INSERT INTO `User` (`userID`, `username`, `password`, `businessUnt`, `comment`, `userRole_roleID`) VALUES
(2, 'Colleen', '123456', 'digital', 'administrator/receptionist', 1),
(60, 'thakgatso', '12345', 'Test', 'Comment', 2),
(61, 'Test', 'test', 'test edited', 'test', 2);

-- --------------------------------------------------------

--
-- Table structure for table `user_asset`
--

CREATE TABLE `user_asset` (
  `user_asset_id` int(11) NOT NULL,
  `assignmentDate` date DEFAULT NULL,
  `unassignDate` date DEFAULT NULL,
  `comment` varchar(100) DEFAULT NULL,
  `userID` int(11) NOT NULL,
  `assetID` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `user_asset`
--

INSERT INTO `user_asset` (`user_asset_id`, `assignmentDate`, `unassignDate`, `comment`, `userID`, `assetID`) VALUES
(77, NULL, NULL, NULL, 60, 32),
(78, NULL, NULL, NULL, 60, 37),
(79, NULL, NULL, NULL, 60, 48),
(82, NULL, NULL, NULL, 61, 37),
(83, NULL, NULL, NULL, 61, 46);

--
-- Indexes for dumped tables
--

--
-- Indexes for table `Asset`
--
ALTER TABLE `Asset`
  ADD PRIMARY KEY (`assetID`),
  ADD KEY `FK_naqfi8b40gm4jhkbes9q4q494` (`make_id`);

--
-- Indexes for table `makes`
--
ALTER TABLE `makes`
  ADD PRIMARY KEY (`make_id`);

--
-- Indexes for table `Role`
--
ALTER TABLE `Role`
  ADD PRIMARY KEY (`roleID`);

--
-- Indexes for table `User`
--
ALTER TABLE `User`
  ADD PRIMARY KEY (`userID`),
  ADD KEY `FK_2a5gvr892cadkbrp00gduvo6s` (`userRole_roleID`);

--
-- Indexes for table `user_asset`
--
ALTER TABLE `user_asset`
  ADD PRIMARY KEY (`user_asset_id`),
  ADD KEY `FK_jndc9fceiskpj3pdp9jclu55q` (`assetID`),
  ADD KEY `FK_hkytcb9qey0pogk389dj8skn9` (`userID`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `Asset`
--
ALTER TABLE `Asset`
  MODIFY `assetID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=51;
--
-- AUTO_INCREMENT for table `makes`
--
ALTER TABLE `makes`
  MODIFY `make_id` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;
--
-- AUTO_INCREMENT for table `Role`
--
ALTER TABLE `Role`
  MODIFY `roleID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;
--
-- AUTO_INCREMENT for table `User`
--
ALTER TABLE `User`
  MODIFY `userID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=62;
--
-- AUTO_INCREMENT for table `user_asset`
--
ALTER TABLE `user_asset`
  MODIFY `user_asset_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=84;
--
-- Constraints for dumped tables
--

--
-- Constraints for table `user_asset`
--
ALTER TABLE `user_asset`
  ADD CONSTRAINT `FK_hkytcb9qey0pogk389dj8skn9` FOREIGN KEY (`userID`) REFERENCES `User` (`userID`),
  ADD CONSTRAINT `FK_jndc9fceiskpj3pdp9jclu55q` FOREIGN KEY (`assetID`) REFERENCES `Asset` (`assetID`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
