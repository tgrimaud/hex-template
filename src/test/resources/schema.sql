---- JOINED TABLE ---------

CREATE TABLE IF NOT EXISTS `nodejt` (
  `id` varchar(255) NOT NULL,
  PRIMARY KEY (`id`)
);

CREATE TABLE IF NOT EXISTS `relationjt` (
  `id` varchar(255) NOT NULL,
  `destination_id` varchar(255) DEFAULT NULL,
  `origin_id` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`),
  FOREIGN KEY (`origin_id`) REFERENCES `nodejt` (`id`),
  FOREIGN KEY (`destination_id`) REFERENCES `nodejt` (`id`)
);

CREATE TABLE IF NOT EXISTS `account_joinedtable` (
  `last_name` varchar(255) DEFAULT NULL,
  `first_name` varchar(255) DEFAULT NULL,
  `type` varchar(255) DEFAULT NULL,
  `id` varchar(255) NOT NULL,
  PRIMARY KEY (`id`),
  FOREIGN KEY (`id`) REFERENCES `nodejt` (`id`)
);

CREATE TABLE IF NOT EXISTS `equipment_joinedtable` (
  `part_number` varchar(255) DEFAULT NULL,
  `serial_number` varchar(255) DEFAULT NULL,
  `id` varchar(255) NOT NULL,
  PRIMARY KEY (`id`),
  FOREIGN KEY (`id`) REFERENCES `nodejt` (`id`)
);

CREATE TABLE IF NOT EXISTS `feature_joinedtable` (
  `id` varchar(255) NOT NULL,
  PRIMARY KEY (`id`),
  FOREIGN KEY (`id`) REFERENCES `nodejt` (`id`)
);

CREATE TABLE IF NOT EXISTS `service_joinedtable` (
  `number` varchar(255) DEFAULT NULL,
  `id` varchar(255) NOT NULL,
  PRIMARY KEY (`id`),
  FOREIGN KEY (`id`) REFERENCES `nodejt` (`id`)
);

CREATE TABLE IF NOT EXISTS `usage_joinedtable` (
  `id` varchar(255) NOT NULL,
  PRIMARY KEY (`id`),
  FOREIGN KEY (`id`) REFERENCES `nodejt` (`id`)
);

CREATE TABLE IF NOT EXISTS `addon_joinedtable` (
  `from_date` varchar(255) DEFAULT NULL,
  `id` varchar(255) NOT NULL,
  PRIMARY KEY (`id`),
  FOREIGN KEY (`id`) REFERENCES `relationjt` (`id`)
);

CREATE TABLE IF NOT EXISTS `subscription_joinedtable` (
  `created_at` date DEFAULT NULL,
  `last_updated_at` date DEFAULT NULL,
  `terminated_at` date DEFAULT NULL,
  `id` varchar(255) NOT NULL,
  PRIMARY KEY (`id`),
  FOREIGN KEY (`id`) REFERENCES `relationjt` (`id`)
);

CREATE TABLE IF NOT EXISTS `included_joinedtable` (
  `id` varchar(255) NOT NULL,
  PRIMARY KEY (`id`),
  FOREIGN KEY (`id`) REFERENCES `relationjt` (`id`)
);

------ MAPPER SUPER CLASS --------

CREATE TABLE IF NOT EXISTS `acoount_mappersuperclass` (
  `id` varchar(255) NOT NULL,
  `name` varchar(255) DEFAULT NULL,
  `type` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
);

CREATE TABLE IF NOT EXISTS `equipment_mappersuperclass` (
  `id` varchar(255) NOT NULL,
  `description` varchar(255) DEFAULT NULL,
  `type` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
);

CREATE TABLE IF NOT EXISTS `addon_mappersuperclass` (
  `id` varchar(255) NOT NULL,
  `from_date` varchar(255) DEFAULT NULL,
  `destination_id` varchar(255) DEFAULT NULL,
  `origin_id` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`),
  FOREIGN KEY (`origin_id`) REFERENCES `equipment_mappersuperclass` (`id`),
  FOREIGN KEY (`destination_id`) REFERENCES `equipment_mappersuperclass` (`id`)
);

CREATE TABLE IF NOT EXISTS `service_mappersuperclass` (
  `id` varchar(255) NOT NULL,
  `name` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
);

CREATE TABLE IF NOT EXISTS `subscription_mappersuperclass` (
  `id` varchar(255) NOT NULL,
  `end_date` varchar(255) DEFAULT NULL,
  `start_date` varchar(255) DEFAULT NULL,
  `destination_id` varchar(255) DEFAULT NULL,
  `origin_id` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`),
  FOREIGN KEY (`origin_id`) REFERENCES `equipment_mappersuperclass` (`id`),
  FOREIGN KEY (`destination_id`) REFERENCES `equipment_mappersuperclass` (`id`)
);

----- TABLE PER CLASS ---------

CREATE TABLE IF NOT EXISTS `acoount_tableperclass` (
  `id` varchar(255) NOT NULL,
  `last_name` varchar(255) DEFAULT NULL,
  `first_name` varchar(255) DEFAULT NULL,
  `type` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
);

CREATE TABLE IF NOT EXISTS `addon_tableperclass` (
  `id` varchar(255) NOT NULL,
  `destination_id` varchar(255) NOT NULL,
  `origin_id` varchar(255) NOT NULL,
  `from_date` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
);

CREATE TABLE IF NOT EXISTS `equipment_tableperclass` (
  `id` varchar(255) NOT NULL,
  `part_number` varchar(255) DEFAULT NULL,
  `serial_number` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
);

CREATE TABLE IF NOT EXISTS `feature_tableperclass` (
  `id` varchar(255) NOT NULL,
  PRIMARY KEY (`id`)
);

CREATE TABLE IF NOT EXISTS `included_tableperclass` (
  `id` varchar(255) NOT NULL,
  `destination_id` varchar(255) NOT NULL,
  `origin_id` varchar(255) NOT NULL,
  PRIMARY KEY (`id`)
);

CREATE TABLE IF NOT EXISTS `service_tableperclass` (
  `id` varchar(255) NOT NULL,
  `number` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
);

CREATE TABLE IF NOT EXISTS `subscription_tableperclass` (
  `id` varchar(255) NOT NULL,
  `destination_id` varchar(255) NOT NULL,
  `origin_id` varchar(255) NOT NULL,
  `created_at` date DEFAULT NULL,
  `last_updated_at` date DEFAULT NULL,
  `terminated_at` date DEFAULT NULL,
  PRIMARY KEY (`id`)
);

CREATE TABLE IF NOT EXISTS `usage_tableperclass` (
  `id` varchar(255) NOT NULL,
  PRIMARY KEY (`id`)
);

---- SINGLE TABLE   ------

CREATE TABLE IF NOT EXISTS `nodest` (
  `dtype` varchar(31) NOT NULL,
  `id` varchar(255) NOT NULL,
  `last_name` varchar(255) DEFAULT NULL,
  `first_name` varchar(255) DEFAULT NULL,
  `type` varchar(255) DEFAULT NULL,
  `part_number` varchar(255) DEFAULT NULL,
  `serial_number` varchar(255) DEFAULT NULL,
  `number` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
);

CREATE TABLE IF NOT EXISTS `relationst` (
  `dtype` varchar(31) NOT NULL,
  `id` varchar(255) NOT NULL,
  `from_date` varchar(255) DEFAULT NULL,
  `created_at` date DEFAULT NULL,
  `last_updated_at` date DEFAULT NULL,
  `terminated_at` date DEFAULT NULL,
  `destination_id` varchar(255) NOT NULL,
  `origin_id` varchar(255) NOT NULL,
  PRIMARY KEY (`id`),
  FOREIGN KEY (`destination_id`) REFERENCES `nodest` (`id`),
  FOREIGN KEY (`origin_id`) REFERENCES `nodest` (`id`)
);

