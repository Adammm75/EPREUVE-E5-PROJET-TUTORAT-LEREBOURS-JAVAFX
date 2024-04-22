-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Hôte : 127.0.0.1:3306
-- Généré le : lun. 22 avr. 2024 à 19:28
-- Version du serveur : 8.2.0
-- Version de PHP : 8.2.13

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de données : `projet_lereboursjava`
--

-- --------------------------------------------------------

--
-- Structure de la table `competence`
--

DROP TABLE IF EXISTS `competence`;
CREATE TABLE IF NOT EXISTS `competence` (
  `id` int NOT NULL AUTO_INCREMENT,
  `id_matiere` int NOT NULL,
  `id_user` int NOT NULL,
  `sous_matiere` longtext NOT NULL,
  `statut` int NOT NULL,
  PRIMARY KEY (`id`),
  KEY `id_user_competence` (`id_user`),
  KEY `id_matiere_competence` (`id_matiere`)
) ENGINE=InnoDB AUTO_INCREMENT=77 DEFAULT CHARSET=latin1;

--
-- Déchargement des données de la table `competence`
--

INSERT INTO `competence` (`id`, `id_matiere`, `id_user`, `sous_matiere`, `statut`) VALUES
(1, 5, 6, 'java#sql#python', 1),
(2, 5, 6, 'orthographe#conjugaison#participepassé', 1),
(3, 1, 5, '#nombres', 3),
(5, 2, 5, '#structurejuridique#droit', 1),
(6, 2, 2, '#intégration#rôleétat#environnement#facteurséconomiques', 2),
(7, 2, 7, '#facteurséconomiques#structurejuridique#droit', 3),
(8, 2, 6, '#contrats#régulation#organisation#intégration#rôleétat#environnement#facteurséconomiques#structurejuridique#droit', 1),
(9, 2, 3, '#organisation#intégration', 3),
(10, 2, 4, '#droit', 1),
(11, 3, 7, '#orthographe#conjugaison', 1),
(12, 3, 4, '#présent#futursimple#pronompersonnel#conjonctioncoordination#auxiliareavoir#indicatif', 3),
(13, 3, 6, '#participepassé#présent#futursimple#pronompersonnel', 1),
(14, 1, 3, 'participepassé', 1),
(15, 4, 1, '#loidepoisson#probabilités#statistiques', 1),
(16, 4, 5, '#équations#factorisation#nombresrelatifs#intégrale#dérivée', 3),
(17, 4, 7, '#tableaudevariation#matrice', 1),
(18, 1, 3, 'orthographe', 1),
(19, 4, 4, '#nombresrelatifs#intégrale#dérivée#tableaudevariation', 1),
(20, 4, 2, '#factorisation', 1),
(21, 5, 1, '#java#sql#python#php#javascript#modelosi#tcpip', 1),
(22, 5, 5, '#windows#linux#dhcp', 1),
(23, 5, 2, '#poo#boucles#conditions#json#api', 1),
(24, 5, 7, '#java#sql', 3),
(25, 5, 6, '#linux#dhcp#dns#voip#cisco', 2),
(26, 1, 3, 'participepassé', 1),
(27, 5, 4, '#javascript#modelosi#tcpip#windows#linux#dhcp#dns#voip#cisco', 1),
(28, 6, 7, '#puissanceetenjeuxmondiaux', 1),
(29, 6, 6, '#crise1929#rÃ©gimestotalitaires#secondeguerremondiale#tiersmonde#france', 1),
(30, 6, 3, '#secondeguerremondiale#tiersmonde#france#constructioneuropÃ©enne', 1),
(31, 6, 4, '#tiersmonde#france', 3),
(45, 6, 8, 'secondeguerremondiale#tiersmonde#france', 3),
(50, 1, 1, 'gérondif', 1),
(51, 1, 3, '#date', 3),
(53, 1, 3, 'pronompersonnel,#conjonctioncoordination#indicatif', 3),
(59, 6, 1, 'crise1929', 3),
(60, 4, 1, 'factorisation#nombresrelatifs#intégrale', 3),
(61, 6, 3, 'crise1929#régimestotalitaires', 3),
(62, 1, 7, 'présent#date#nombres', 3),
(63, 4, 7, 'intégrale', 3),
(64, 1, 3, 'date#nombres', 3),
(65, 5, 3, 'sql#python', 3),
(66, 5, 3, 'sql#python', 3),
(67, 2, 3, '#contrats#régulation#organisation', 3),
(68, 5, 3, '#sql#python', 3),
(69, 1, 3, '#date#nombres', 3),
(70, 5, 7, '#sql#python', 3),
(71, 5, 7, '#sql#json#api', 3),
(72, 1, 7, '#présent', 1),
(73, 1, 7, 'gérondif#présent#date', 1),
(74, 2, 3, '#contrats#régulation', 3),
(75, 1, 7, '#présent#date', 1),
(76, 1, 7, '#date#nombres', 3);

-- --------------------------------------------------------

--
-- Structure de la table `demande`
--

DROP TABLE IF EXISTS `demande`;
CREATE TABLE IF NOT EXISTS `demande` (
  `id` int NOT NULL AUTO_INCREMENT,
  `date_updated` date NOT NULL,
  `date_fin_demande` date NOT NULL,
  `sous_matiere` longtext NOT NULL,
  `id_user` int NOT NULL,
  `id_matiere` int NOT NULL,
  `status` int NOT NULL,
  PRIMARY KEY (`id`),
  KEY `id_user` (`id_user`),
  KEY `id_matiere` (`id_matiere`)
) ENGINE=InnoDB AUTO_INCREMENT=50 DEFAULT CHARSET=latin1;

--
-- Déchargement des données de la table `demande`
--

INSERT INTO `demande` (`id`, `date_updated`, `date_fin_demande`, `sous_matiere`, `id_user`, `id_matiere`, `status`) VALUES
(2, '2023-09-25', '2023-10-04', '#nombresrelatifs#intégrale#loidepoisson#probabilités#statistiques', 5, 4, 1),
(4, '2023-10-08', '2023-10-13', '#conjonctioncoordination#auxiliareavoir', 6, 3, 1),
(5, '2023-10-08', '2023-10-13', '#nombres', 6, 1, 1),
(6, '2023-10-08', '2023-10-13', '#intégration#rôleétat#environnement', 6, 2, 1),
(7, '2023-10-22', '2023-10-27', '#date#nombres', 1, 1, 1),
(9, '2024-04-22', '2023-10-20', '#régimestotalitaires', 7, 1, 1),
(10, '2024-04-22', '2023-11-03', 'rôleétat', 7, 1, 1),
(11, '2023-10-22', '2023-10-31', '#boucles#conditions', 9, 5, 1),
(12, '2023-11-12', '2023-11-17', '#json#api#sql', 8, 5, 1),
(13, '2023-11-19', '2023-11-22', '#dhcp#dns#voip', 5, 5, 1),
(14, '2023-10-17', '2023-10-20', '#sql#python', 5, 5, 1),
(15, '2023-10-29', '2023-10-31', '#probabilités#statistiques', 7, 4, 1),
(23, '2023-12-13', '2023-10-31', 'crise1929#régimestotalitaires#secondeguerremondiale', 4, 6, 1),
(25, '2023-12-16', '2023-12-28', 'crise1929#régimestotalitaires#secondeguerremondiale', 9, 6, 1),
(26, '2023-12-17', '2023-12-21', 'régimestotalitaires#secondeguerremondiale#tiersmonde', 8, 6, 1),
(32, '2023-12-22', '2023-12-17', 'boucles#conditions#json', 3, 5, 1),
(33, '2023-12-22', '2023-12-26', 'contrats#régulation#organisation', 3, 2, 1),
(34, '2023-12-22', '2023-12-23', 'secondeguerremondiale#tiersmonde', 3, 6, 1),
(35, '2023-12-22', '2026-12-27', 'secondeguerremondiale#tiersmonde', 3, 6, 1),
(36, '2023-12-22', '2023-12-14', 'intégrale', 3, 4, 1),
(37, '2023-12-22', '2023-12-13', 'nombresrelatifs', 3, 4, 1),
(39, '2023-12-22', '2023-12-30', 'conjugaison', 3, 3, 1),
(40, '2023-12-23', '2023-12-30', 'factorisation', 3, 4, 1),
(42, '2024-04-03', '2024-04-11', 'contrats#régulation#organisation', 3, 2, 1),
(43, '2024-04-15', '2024-04-18', 'factorisation#nombresrelatifs#intégrale', 3, 4, 1),
(44, '2024-04-16', '2024-04-17', 'crise1929#régimestotalitaires#secondeguerremondiale', 1, 6, 1),
(45, '2024-04-17', '2024-04-19', 'présent#date#nombres', 4, 1, 1),
(46, '2024-04-22', '2024-06-06', 'nbr#test#test', 7, 1, 1),
(47, '2024-04-22', '2024-04-25', 'factorisation#nombresrelatifs#intégrale', 7, 4, 1),
(48, '2024-04-22', '2024-05-02', '#participepassé', 7, 3, 1),
(49, '2024-04-22', '2024-05-02', '#régimestotalitaires#secondeguerremondiale#tiersmonde', 7, 3, 1);

-- --------------------------------------------------------

--
-- Structure de la table `matiere`
--

DROP TABLE IF EXISTS `matiere`;
CREATE TABLE IF NOT EXISTS `matiere` (
  `id` int NOT NULL AUTO_INCREMENT,
  `designation` varchar(200) NOT NULL,
  `code` int NOT NULL,
  `sous_matiere` longtext NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=21 DEFAULT CHARSET=latin1;

--
-- Déchargement des données de la table `matiere`
--

INSERT INTO `matiere` (`id`, `designation`, `code`, `sous_matiere`) VALUES
(1, 'Anglais', 1, '#verbesirréguliers#gérondif#présent#date#nombres'),
(2, 'CEJM', 2, '#contrats#régulation#organisation#intégration#rôleétat#environnement#facteurséconomiques#structurejuridique#droit'),
(3, 'Français', 3, '#orthographe#conjugaison#participepassé#présent#futursimple,#pronompersonnel,#conjonctioncoordination#auxiliareavoir#indicatif'),
(4, 'Mathématiques', 2, '#équations#factorisation#nombresrelatifs#intégrale#dérivée#tableaudevariation#matrice#développement#loidepoisson#probabilités#statistiques'),
(5, 'Informatique', 5, '#java#sql#python#php#javascript#modelosi#tcpip#windows#linux#dhcp#dns#voip#cisco#poo#boucles#conditions#json#api'),
(6, 'Histoire', 6, '#crise1929#régimestotalitaires#secondeguerremondiale#tiersmonde#france#constructioneuropéenne#puissanceetenjeuxmondiaux'),
(20, 'Espagnol', 0, 'nbr#test#test');

-- --------------------------------------------------------

--
-- Structure de la table `salle`
--

DROP TABLE IF EXISTS `salle`;
CREATE TABLE IF NOT EXISTS `salle` (
  `id` int NOT NULL AUTO_INCREMENT,
  `code_salle` varchar(10) NOT NULL,
  `etage` int NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1112 DEFAULT CHARSET=latin1;

--
-- Déchargement des données de la table `salle`
--

INSERT INTO `salle` (`id`, `code_salle`, `etage`) VALUES
(0, 'Salle 0', 0),
(101, 'Salle 101', 1),
(102, 'Salle 102', 1),
(103, 'Salle 103', 1),
(108, 'Salle 108', 1),
(111, 'Salle 111', 1),
(115, 'Salle 115', 1),
(202, 'Salle 202', 2),
(222, 'Salle 222', 2);

-- --------------------------------------------------------

--
-- Structure de la table `soutien`
--

DROP TABLE IF EXISTS `soutien`;
CREATE TABLE IF NOT EXISTS `soutien` (
  `id` int NOT NULL AUTO_INCREMENT,
  `id_demande` int NOT NULL,
  `id_competence` int NOT NULL,
  `id_salle` int NOT NULL,
  `date_du_soutien` date NOT NULL,
  `date_updated` date NOT NULL,
  `description` longtext NOT NULL,
  `status` int NOT NULL,
  PRIMARY KEY (`id`),
  KEY `id_competence` (`id_competence`),
  KEY `id_demande` (`id_demande`),
  KEY `id_salle_soutien` (`id_salle`)
) ENGINE=InnoDB AUTO_INCREMENT=21 DEFAULT CHARSET=latin1;

--
-- Déchargement des données de la table `soutien`
--

INSERT INTO `soutien` (`id`, `id_demande`, `id_competence`, `id_salle`, `date_du_soutien`, `date_updated`, `description`, `status`) VALUES
(17, 13, 73, 0, '2023-11-19', '2023-11-22', 'eee', 1),
(18, 14, 68, 111, '2023-10-17', '2023-10-20', 'aaaa', 2),
(19, 14, 68, 202, '2023-10-17', '2023-10-20', 'bonjour', 2),
(20, 7, 76, 103, '2023-10-22', '2023-10-27', 'à bientot', 2);

-- --------------------------------------------------------

--
-- Structure de la table `user`
--

DROP TABLE IF EXISTS `user`;
CREATE TABLE IF NOT EXISTS `user` (
  `id` int NOT NULL AUTO_INCREMENT,
  `nom` varchar(50) NOT NULL,
  `prenom` varchar(50) NOT NULL,
  `email` varchar(50) NOT NULL,
  `password` varchar(50) CHARACTER SET latin1 COLLATE latin1_swedish_ci NOT NULL,
  `role` varchar(50) CHARACTER SET latin1 COLLATE latin1_swedish_ci NOT NULL,
  `niveau` varchar(50) CHARACTER SET latin1 COLLATE latin1_swedish_ci NOT NULL,
  `sexe` int NOT NULL,
  `telephone` varchar(10) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=13 DEFAULT CHARSET=latin1;

--
-- Déchargement des données de la table `user`
--

INSERT INTO `user` (`id`, `nom`, `prenom`, `email`, `password`, `role`, `niveau`, `sexe`, `telephone`) VALUES
(1, 'Castaing', 'c', 'sabine.castaing@lerebours.org', 'c', 'Etudiant', 'BTS 1', 2, '0661010101'),
(2, 'Thouri', 'Erwan', 'erwan.thouri@lerebours.org', 'erwtho', 'Etudiant', 'BTS 2', 1, '0661020202'),
(3, 'a', 'a', 'nicolas.bloch@lerebours.org', 'e', 'Etudiant', 'Bachelor', 1, '0661030303'),
(4, 'Chittarath', 'Christophe', 'chittarath.christophe@lerebours.org', 'chrchi', 'Etudiant', 'Bachelor', 1, '0661040404'),
(5, 'Buffeteau', 'b', 'jacques.buffeteau@lerebours.org', 'b', 'Etudiant', 'Terminale', 1, '0661050505'),
(6, 'Pamart', 'Marie-Sophie', 'pamart.marie.sophie@lerebours.org', 'pammar', 'Etudiant', 'Master 1', 2, '0661060606'),
(7, 'Sordet', 'Evelyne', 'evelyne.sordet@lerebours.org', 'evesor', 'Etudiant', 'Master 2', 2, '0661070707'),
(8, 'Cornia', 'Alberto', 'alberto.cornia@lerebours.org', 'albcor', 'Etudiant', 'Bachelor', 1, '0661080808'),
(9, 'Ioualitene', 'Fatah', 'loualitene.fatah@lerebours.org', 'fatlou', 'Etudiant', 'BTS 2', 1, '0661090909'),
(10, 'a', 'a', 'admin@gmail.com', 'a', 'Administrateur', 'Bac +5', 1, '0604039854'),
(11, 'admin2', 'admin2', 'admin2@gmail.com', 'admin2', 'Administrateur', 'Bac +5', 1, '0604039859');

--
-- Contraintes pour les tables déchargées
--

--
-- Contraintes pour la table `competence`
--
ALTER TABLE `competence`
  ADD CONSTRAINT `id_matiere_competence` FOREIGN KEY (`id_matiere`) REFERENCES `matiere` (`id`),
  ADD CONSTRAINT `id_user_competence` FOREIGN KEY (`id_user`) REFERENCES `user` (`id`);

--
-- Contraintes pour la table `demande`
--
ALTER TABLE `demande`
  ADD CONSTRAINT `id_matiere` FOREIGN KEY (`id_matiere`) REFERENCES `matiere` (`id`),
  ADD CONSTRAINT `id_user` FOREIGN KEY (`id_user`) REFERENCES `user` (`id`);

--
-- Contraintes pour la table `soutien`
--
ALTER TABLE `soutien`
  ADD CONSTRAINT `id_competence` FOREIGN KEY (`id_competence`) REFERENCES `competence` (`id`),
  ADD CONSTRAINT `id_demande` FOREIGN KEY (`id_demande`) REFERENCES `demande` (`id`),
  ADD CONSTRAINT `id_salle_soutien` FOREIGN KEY (`id_salle`) REFERENCES `salle` (`id`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
