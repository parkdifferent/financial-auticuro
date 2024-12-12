CREATE TABLE IF NOT EXISTS account_balance_views (
    account_number VARCHAR(64) PRIMARY KEY,
    balance DECIMAL(20,8) NOT NULL,
    version INT NOT NULL,
    last_updated DATETIME NOT NULL,
    INDEX idx_version (version),
    INDEX idx_last_updated (last_updated)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- Index for query performance
CREATE INDEX IF NOT EXISTS idx_event_time_account ON balance_change_events (event_time, account_number);
CREATE INDEX IF NOT EXISTS idx_transaction_events ON balance_change_events (transaction_id, event_time);
