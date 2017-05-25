-- phpMyAdmin SQL Dump
-- version 4.6.4
-- https://www.phpmyadmin.net/
--
-- Client :  127.0.0.1
-- Généré le :  Jeu 25 Mai 2017 à 16:49
-- Version du serveur :  5.7.14
-- Version de PHP :  5.6.25

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de données :  `proxiv3`
--

-- --------------------------------------------------------

--
-- Structure de la table `adresse`
--

CREATE TABLE `adresse` (
  `idAdresse` bigint(20) NOT NULL,
  `codePostal` varchar(255) DEFAULT NULL,
  `rue` varchar(255) DEFAULT NULL,
  `ville` varchar(255) DEFAULT NULL
) ENGINE=MyISAM DEFAULT CHARSET=utf8;

--
-- Contenu de la table `adresse`
--

INSERT INTO `adresse` (`idAdresse`, `codePostal`, `rue`, `ville`) VALUES
(1, '69740', 'rue du chat qui tousse', 'GENAS'),
(2, '25148', 'avenue du chateau', 'LOURDE'),
(3, '42563', 'rue du mouton qui broute', 'SAINT-ETIENNE'),
(4, '56240', 'avenue de la rue', 'QUIBERON');

-- --------------------------------------------------------

--
-- Structure de la table `agence`
--

CREATE TABLE `agence` (
  `idAgence` bigint(20) NOT NULL,
  `dateCreation` bigint(20) NOT NULL,
  `numAgence` varchar(255) DEFAULT NULL,
  `gerant_idPersonne` bigint(20) DEFAULT NULL
) ENGINE=MyISAM DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Structure de la table `cartebancaire`
--

CREATE TABLE `cartebancaire` (
  `CARTE_TYPE` varchar(31) NOT NULL,
  `idCarteBancaire` bigint(20) NOT NULL,
  `bloquee` bit(1) NOT NULL,
  `compte_numeroCompte` bigint(20) DEFAULT NULL
) ENGINE=MyISAM DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Structure de la table `compte`
--

CREATE TABLE `compte` (
  `TYPE_COMPTE` varchar(31) NOT NULL,
  `numeroCompte` bigint(20) NOT NULL,
  `dateOuverture` varchar(255) DEFAULT NULL,
  `solde` double NOT NULL,
  `remuneration` double DEFAULT NULL,
  `decouvert` double DEFAULT NULL,
  `carteBancaire_idCarteBancaire` bigint(20) DEFAULT NULL,
  `client_idPersonne` bigint(20) DEFAULT NULL
) ENGINE=MyISAM DEFAULT CHARSET=utf8;

--
-- Contenu de la table `compte`
--

INSERT INTO `compte` (`TYPE_COMPTE`, `numeroCompte`, `dateOuverture`, `solde`, `remuneration`, `decouvert`, `carteBancaire_idCarteBancaire`, `client_idPersonne`) VALUES
('COURANT', 1, '2009-12-05', 1800, NULL, 1000, NULL, 2),
('COURANT', 2, '2015-02-25', 3000, NULL, 1000, NULL, 3),
('COURANT', 3, '2013-06-07', 4200, NULL, 1000, NULL, 5),
('EPARGNE', 4, '2008-01-30', 20000, 0.03, NULL, NULL, 2),
('EPARGNE', 5, '2014-08-02', 10000, 0.03, NULL, NULL, 4),
('EPARGNE', 6, '2012-05-27', 8500, 0.03, NULL, NULL, 5);

-- --------------------------------------------------------

--
-- Structure de la table `hibernate_sequence`
--

CREATE TABLE `hibernate_sequence` (
  `next_val` bigint(20) DEFAULT NULL
) ENGINE=MyISAM DEFAULT CHARSET=utf8;

--
-- Contenu de la table `hibernate_sequence`
--

INSERT INTO `hibernate_sequence` (`next_val`) VALUES
(12);

-- --------------------------------------------------------

--
-- Structure de la table `personne`
--

CREATE TABLE `personne` (
  `PERSONNE_TYPE` varchar(31) NOT NULL,
  `idPersonne` bigint(20) NOT NULL,
  `email` varchar(255) DEFAULT NULL,
  `nom` varchar(255) DEFAULT NULL,
  `prenom` varchar(255) DEFAULT NULL,
  `telephone` varchar(255) DEFAULT NULL,
  `entreprise` bit(1) DEFAULT NULL,
  `nomEntreprise` varchar(255) DEFAULT NULL,
  `login` varchar(255) DEFAULT NULL,
  `pwd` varchar(255) DEFAULT NULL,
  `adresse_idAdresse` bigint(20) DEFAULT NULL,
  `conseiller_idPersonne` bigint(20) DEFAULT NULL,
  `gerant_idPersonne` bigint(20) DEFAULT NULL
) ENGINE=MyISAM DEFAULT CHARSET=utf8;

--
-- Contenu de la table `personne`
--

INSERT INTO `personne` (`PERSONNE_TYPE`, `idPersonne`, `email`, `nom`, `prenom`, `telephone`, `entreprise`, `nomEntreprise`, `login`, `pwd`, `adresse_idAdresse`, `conseiller_idPersonne`, `gerant_idPersonne`) VALUES
('CONSEILLER', 1, 'roro69@gmail.fr', 'Robichet', 'Robert', '4565458', NULL, NULL, 'demo', 'demo', NULL, NULL, 8),
('CLIENT', 2, 'berner@hotmail.fr', 'ZEZE', 'Bernard', '05548922852', b'0', NULL, NULL, NULL, 1, 1, NULL),
('CLIENT', 3, 'Atutu@hotmail.fr', 'tutu', 'alice', '6584572222', b'0', NULL, NULL, NULL, 2, 1, NULL),
('CLIENT', 4, 'jojotutu@hotmail.fr', 'gaga', 'Jojo', '9879495925', b'1', 'MomoEnterprise', NULL, NULL, 3, 1, NULL),
('CLIENT', 5, 'lulu@hotmail.fr', 'momo', 'Lulu', '65484821212', b'0', NULL, NULL, NULL, 4, 1, NULL),
('CONSEILLER', 6, 'Conseiller2@gmail.fr', 'TheConseiller', 'PrenomCon', '9874556', NULL, NULL, 'demo2', 'demo2', NULL, NULL, 8),
('CLIENT', 7, 'jojodu56@hotmail.fr', 'LE BAIL', 'Jonathan', '6525482323', b'0', NULL, NULL, NULL, 2, 6, NULL),
('GERANT', 8, 'gerant_Proxi@proxi.ru', 'THE BOSS', 'Lebig', '0565522552', NULL, NULL, 'demo3', 'demo3', NULL, NULL, NULL);

-- --------------------------------------------------------

--
-- Structure de la table `placement`
--

CREATE TABLE `placement` (
  `idPlacement` bigint(20) NOT NULL,
  `montant` double NOT NULL,
  `placeFinanciere` varchar(255) DEFAULT NULL,
  `client_idPersonne` bigint(20) DEFAULT NULL
) ENGINE=MyISAM DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Structure de la table `user`
--

CREATE TABLE `user` (
  `id` bigint(20) NOT NULL,
  `nom` varchar(255) DEFAULT NULL,
  `prenom` varchar(255) DEFAULT NULL
) ENGINE=MyISAM DEFAULT CHARSET=utf8;

--
-- Index pour les tables exportées
--

--
-- Index pour la table `adresse`
--
ALTER TABLE `adresse`
  ADD PRIMARY KEY (`idAdresse`);

--
-- Index pour la table `agence`
--
ALTER TABLE `agence`
  ADD PRIMARY KEY (`idAgence`),
  ADD KEY `FK_q5i0kapmsupoohhrnsncedqel` (`gerant_idPersonne`);

--
-- Index pour la table `cartebancaire`
--
ALTER TABLE `cartebancaire`
  ADD PRIMARY KEY (`idCarteBancaire`),
  ADD KEY `FK_tgkd80bbfqqdb4llixj62cek0` (`compte_numeroCompte`);

--
-- Index pour la table `compte`
--
ALTER TABLE `compte`
  ADD PRIMARY KEY (`numeroCompte`),
  ADD KEY `FK_46qebeyknlenfg9mkh5le6y0t` (`carteBancaire_idCarteBancaire`),
  ADD KEY `FK_1b66ossdbkhm0r1fjomaq3w2a` (`client_idPersonne`);

--
-- Index pour la table `personne`
--
ALTER TABLE `personne`
  ADD PRIMARY KEY (`idPersonne`),
  ADD KEY `FK_i5um1923bfjej5jwwibkwf5ii` (`adresse_idAdresse`),
  ADD KEY `FK_cqwvt7lbjti4cxm4m9mkd0730` (`conseiller_idPersonne`),
  ADD KEY `FK_97hs2ki1kf3t629fyvjieb08i` (`gerant_idPersonne`);

--
-- Index pour la table `placement`
--
ALTER TABLE `placement`
  ADD PRIMARY KEY (`idPlacement`),
  ADD KEY `FK_g50ecye3xx6yrn4pqyc8787iu` (`client_idPersonne`);

--
-- Index pour la table `user`
--
ALTER TABLE `user`
  ADD PRIMARY KEY (`id`);

--
-- AUTO_INCREMENT pour les tables exportées
--

--
-- AUTO_INCREMENT pour la table `adresse`
--
ALTER TABLE `adresse`
  MODIFY `idAdresse` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;
--
-- AUTO_INCREMENT pour la table `agence`
--
ALTER TABLE `agence`
  MODIFY `idAgence` bigint(20) NOT NULL AUTO_INCREMENT;
--
-- AUTO_INCREMENT pour la table `cartebancaire`
--
ALTER TABLE `cartebancaire`
  MODIFY `idCarteBancaire` bigint(20) NOT NULL AUTO_INCREMENT;
--
-- AUTO_INCREMENT pour la table `compte`
--
ALTER TABLE `compte`
  MODIFY `numeroCompte` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=7;
--
-- AUTO_INCREMENT pour la table `personne`
--
ALTER TABLE `personne`
  MODIFY `idPersonne` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=9;
--
-- AUTO_INCREMENT pour la table `placement`
--
ALTER TABLE `placement`
  MODIFY `idPlacement` bigint(20) NOT NULL AUTO_INCREMENT;
--
-- AUTO_INCREMENT pour la table `user`
--
ALTER TABLE `user`
  MODIFY `id` bigint(20) NOT NULL AUTO_INCREMENT;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
