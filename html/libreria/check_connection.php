<?php
require 'database.php';

$db = Database::getInstance();
echo $db->checkConnection();
?>
