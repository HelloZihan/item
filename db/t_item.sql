DROP TABLE IF EXISTS `t_item`;
CREATE TABLE `t_item` (
  `id` bigint(20) unsigned NOT NULL AUTO_INCREMENT,
  `status` tinyint(4) NOT NULL DEFAULT '1',
  `name` varchar(64) NOT NULL,
  `price` decimal(20,2) DEFAULT NULL,
  `create_time` bigint(20) DEFAULT NULL,
  `update_time` bigint(20) DEFAULT NULL,
  `images` varchar(255) DEFAULT NULL,
  `stock` smallint(5) unsigned DEFAULT '0',
  `desc` varchar(1024) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;
