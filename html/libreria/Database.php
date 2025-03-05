<?php
class Database {
    private static $instance = null;
    private $connection;

    private function __construct() {
        try {
            $this->connection = new PDO('pgsql:host=localhost;dbname=hospital', 'postgres', '1077225941');
            $this->connection->setAttribute(PDO::ATTR_ERRMODE, PDO::ERRMODE_EXCEPTION);
        } catch (PDOException $e) {
            die(json_encode(['success' => false, 'message' => 'Error de conexión: ' . $e->getMessage()]));
        }
    }

    public static function getInstance() {
        if (self::$instance === null) {
            self::$instance = new Database();
        }
        return self::$instance;
    }

    public function checkConnection() {
        try {
            $this->connection->query("SELECT 1"); // Ejecuta una consulta simple
            return json_encode(['success' => true, 'message' => 'Conexión exitosa a la base de datos.']);
        } catch (PDOException $e) {
            return json_encode(['success' => false, 'message' => 'Error en la conexión: ' . $e->getMessage()]);
        }
    }
}
?>
