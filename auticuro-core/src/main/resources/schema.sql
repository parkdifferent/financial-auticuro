CREATE DATABASE IF NOT EXISTS auticuro;

USE auticuro;

CREATE TABLE IF NOT EXISTS accounts (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    account_number VARCHAR(64) NOT NULL UNIQUE,
    asset_type VARCHAR(32) NOT NULL,
    balance DECIMAL(20,8) NOT NULL DEFAULT 0,
    upper_limit DECIMAL(20,8),
    lower_limit DECIMAL(20,8),
    locked BOOLEAN NOT NULL DEFAULT FALSE,
    version INT NOT NULL DEFAULT 0,
    create_time DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP,
    update_time DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
    INDEX idx_account_number (account_number),
    INDEX idx_asset_type (asset_type)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

CREATE TABLE IF NOT EXISTS balance_change_events (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    account_number VARCHAR(64) NOT NULL,
    transaction_id VARCHAR(64) NOT NULL,
    amount DECIMAL(20,8) NOT NULL,
    balance_after DECIMAL(20,8) NOT NULL,
    event_type VARCHAR(32) NOT NULL,
    account_version INT NOT NULL,
    event_time DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP,
    metadata JSON,
    INDEX idx_account_number (account_number),
    INDEX idx_transaction_id (transaction_id),
    INDEX idx_event_time (event_time)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

CREATE TABLE IF NOT EXISTS dedup_records (
    transaction_id VARCHAR(64) PRIMARY KEY,
    create_time DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP,
    INDEX idx_create_time (create_time)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;
