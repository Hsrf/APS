CREATE TABLE `playlist` (
    `id` INT(10) AUTO_INCREMENT PRIMARY KEY,
    `ownerId` INT(10) NOT NULL,
    `name` VARCHAR(255) NOT NULL,
    `artist_id` INT(10),

    FOREIGN KEY (`ownerId`) REFERENCES `users`(`id`)
);