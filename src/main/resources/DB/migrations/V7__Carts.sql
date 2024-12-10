CREATE TABLE cart (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    status VARCHAR(20) NOT NULL,  -- 'active' ou 'completed'
    FOREIGN KEY (user_id) REFERENCES app_user(id)
);
