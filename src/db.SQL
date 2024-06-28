-- Drop existing tables if they exist
DROP TABLE IF EXISTS devis;
DROP TABLE IF EXISTS maintenance;
DROP TABLE IF EXISTS operateurs;
DROP TABLE IF EXISTS clients;
DROP TABLE IF EXISTS ResponsableMaintenance;
DROP TABLE IF EXISTS Contrat;
DROP TABLE IF EXISTS CompteRendu;

-- Create table clients
CREATE TABLE clients (
    id INT PRIMARY KEY,
    nom VARCHAR(255) NOT NULL,
    numeroIFU VARCHAR(255) NOT NULL,
    RCCM VARCHAR(255) NOT NULL,
    adresse VARCHAR(255) NOT NULL,
    codeAPE VARCHAR(255) NOT NULL
);

-- Create table operateurs
CREATE TABLE operateurs (
    id INT PRIMARY KEY,
    nom VARCHAR(255) NOT NULL,
    prenom VARCHAR(255) NOT NULL,
    specialisation VARCHAR(255) NOT NULL,
    telephone VARCHAR(255) NOT NULL,
    clientId INT,
    FOREIGN KEY (clientId) REFERENCES clients(id)
);

-- Create table ResponsableMaintenance
CREATE TABLE ResponsableMaintenance (
    id INT PRIMARY KEY,
    nom VARCHAR(255) NOT NULL,
    prenom VARCHAR(255) NOT NULL,
    specialisation VARCHAR(255) NOT NULL,
    clientId INT,
    FOREIGN KEY (clientId) REFERENCES clients(id)
);

-- Create table maintenance
CREATE TABLE maintenance (
    id INT PRIMARY KEY,
    type VARCHAR(255) NOT NULL,
    details VARCHAR(255) NOT NULL,
    description VARCHAR(255) NOT NULL,
    clientId INT NOT NULL,
    responsableMaintenanceId INT NOT NULL,
    FOREIGN KEY (clientId) REFERENCES clients(id),
    FOREIGN KEY (responsableMaintenanceId) REFERENCES ResponsableMaintenance(id)
);

-- Create table devis
CREATE TABLE devis (
    id INT PRIMARY KEY,
    description VARCHAR(255) NOT NULL,
    montant DOUBLE NOT NULL,
    statut VARCHAR(255) NOT NULL,
    maintenanceId INT,
    FOREIGN KEY (maintenanceId) REFERENCES maintenance(id)
);

-- Create table Contrat
CREATE TABLE Contrat (
    id INT PRIMARY KEY,
    description VARCHAR(255) NOT NULL,
    dateDebut DATE NOT NULL,
    dateFin DATE NOT NULL,
    clientId INT NOT NULL,
    FOREIGN KEY (clientId) REFERENCES clients(id)
);

-- Create table CompteRendu
CREATE TABLE CompteRendu (
    id INT PRIMARY KEY,
    rapport TEXT NOT NULL,
    date DATE NOT NULL,
    maintenanceId INT NOT NULL,
    operateurId INT NOT NULL,
    FOREIGN KEY (maintenanceId) REFERENCES maintenance(id),
    FOREIGN KEY (operateurId) REFERENCES operateurs(id)
);
