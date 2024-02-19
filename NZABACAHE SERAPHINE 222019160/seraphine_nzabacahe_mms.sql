\-- phpMyAdmin SQL Dump
-- version 3.3.9
-- http://www.phpmyadmin.net
--
-- Host: localhost
-- Generation Time: Feb 19, 2024 at 10:00 AM
-- Server version: 5.5.8
-- PHP Version: 5.3.5

SET SQL_MODE="NO_AUTO_VALUE_ON_ZERO";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

--
-- Database: `seraphine_nzabacahe_mms`
--

-- --------------------------------------------------------

--
-- Table structure for table `accountcreation`
--

CREATE TABLE IF NOT EXISTS `accountcreation` (
  `id` int(5) NOT NULL AUTO_INCREMENT,
  `fullname` varchar(100) NOT NULL,
  `address` varchar(120) NOT NULL,
  `email` varchar(140) NOT NULL,
  `age` int(8) NOT NULL,
  `username` varchar(200) NOT NULL,
  `usertype` varchar(170) NOT NULL,
  `password` varchar(145) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=13 ;

--
-- Dumping data for table `accountcreation`
--

INSERT INTO `accountcreation` (`id`, `fullname`, `address`, `email`, `age`, `username`, `usertype`, `password`) VALUES
(1, 'serafina', 'muhanga', 'sera@gmail.com', 23, 'sese', 'admin', '123'),
(2, 'nzabacahe', 'kamonyi', 'nza@gmail.com', 57, 'nzanza', 'mnbv', '12345'),
(3, 'nzabacahe', 'kamonyi', 'sera@gmail.com', 23, 'sera', 'admin', '1234'),
(12, 'ad', 'kgl', 'er@gmail.com', 23, 'fat', 'manager', '3245');

-- --------------------------------------------------------

--
-- Table structure for table `customers`
--

CREATE TABLE IF NOT EXISTS `customers` (
  `customer_id` int(10) NOT NULL AUTO_INCREMENT,
  `customer_name` varchar(100) NOT NULL,
  `phone` varchar(110) NOT NULL,
  `email` varchar(200) NOT NULL,
  `username` varchar(220) NOT NULL,
  `password` varchar(210) NOT NULL,
  PRIMARY KEY (`customer_id`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=13 ;

--
-- Dumping data for table `customers`
--

INSERT INTO `customers` (`customer_id`, `customer_name`, `phone`, `email`, `username`, `password`) VALUES
(1, 'asdfghj', '0987654', 'asdfghj', 'asd', '1234'),
(3, 'agnes', '098765443', 'adn@gmail.com', 'agn', '1234'),
(12, 'asdfg', '098765', ',kjuytre', 'mjhg', 'nhgf');

-- --------------------------------------------------------

--
-- Table structure for table `employee`
--

CREATE TABLE IF NOT EXISTS `employee` (
  `employee_id` int(1) NOT NULL AUTO_INCREMENT,
  `employee_name` varchar(230) NOT NULL,
  `telephone` varchar(100) NOT NULL,
  `email` varchar(200) NOT NULL,
  `salary` int(20) NOT NULL,
  `position` varchar(198) NOT NULL,
  PRIMARY KEY (`employee_id`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=14 ;

--
-- Dumping data for table `employee`
--

INSERT INTO `employee` (`employee_id`, `employee_name`, `telephone`, `email`, `salary`, `position`) VALUES
(1, 'agnes', '780547013', 'ag@gmail.com', 500, 'admin'),
(2, 'nickita', '0785463666', 'neck@gmail.com', 6700000, 'user'),
(3, 'ange', 'an@gmail.com', '078976543', 23456, 'asdfghj'),
(7, 'kjuyt', 'mjhgfd', '098765', 123456, 'mjhtr'),
(11, 'veve', '725573438', 've@gmail.com', 45000, 'admin'),
(12, 'asdfgh', 'asdfghj', '0987654', 23456, 'asdfgh'),
(13, 'seraphine', 'sd@gmail.com', '0987654', 234567, 'admin');

-- --------------------------------------------------------

--
-- Table structure for table `harvest`
--

CREATE TABLE IF NOT EXISTS `harvest` (
  `harvest_id` int(12) NOT NULL AUTO_INCREMENT,
  `harvest_name` varchar(200) NOT NULL,
  `quantity` int(18) NOT NULL,
  `unit_price` int(12) NOT NULL,
  `total price` int(16) NOT NULL,
  `mushroom_id` int(12) NOT NULL,
  PRIMARY KEY (`harvest_id`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=13 ;

--
-- Dumping data for table `harvest`
--

INSERT INTO `harvest` (`harvest_id`, `harvest_name`, `quantity`, `unit_price`, `total price`, `mushroom_id`) VALUES
(1, 'wwe', 34, 500, 2300, 3),
(3, 'asdfgh', 9876, 3456, 98765, 6789),
(12, 'sese', 43, 70, 4000, 15);

-- --------------------------------------------------------

--
-- Table structure for table `mushroom`
--

CREATE TABLE IF NOT EXISTS `mushroom` (
  `mushroom_id` int(12) NOT NULL AUTO_INCREMENT,
  `mushroom_name` varchar(255) NOT NULL,
  `description` varchar(68) NOT NULL,
  `quantity` int(12) NOT NULL,
  `unit price` int(12) NOT NULL,
  `total price` int(21) NOT NULL,
  PRIMARY KEY (`mushroom_id`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=13 ;

--
-- Dumping data for table `mushroom`
--

INSERT INTO `mushroom` (`mushroom_id`, `mushroom_name`, `description`, `quantity`, `unit price`, `total price`) VALUES
(1, 'asdfgh', 'asdf', 123, 3456, 6789),
(4, 'agnes', 'imegeri', 430, 2345, 23456),
(12, 'sese', 'ibiyege', 23, 500, 650);

-- --------------------------------------------------------

--
-- Table structure for table `sales`
--

CREATE TABLE IF NOT EXISTS `sales` (
  `sales_id` int(12) NOT NULL AUTO_INCREMENT,
  `sales_name` varchar(200) NOT NULL,
  `quantity` int(18) NOT NULL,
  `total_price` int(12) NOT NULL,
  `mushroom_id` int(16) NOT NULL,
  `customer_id` int(12) NOT NULL,
  PRIMARY KEY (`sales_id`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=24 ;

--
-- Dumping data for table `sales`
--

INSERT INTO `sales` (`sales_id`, `sales_name`, `quantity`, `total_price`, `mushroom_id`, `customer_id`) VALUES
(1, 'imegeri', 34, 5000, 3, 2),
(21, 'emma', 43, 3400, 21336, 4300),
(23, 'ertrty', 234, 234567, 45678, 87654);
