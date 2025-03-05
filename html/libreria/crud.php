<?php
require 'database.php';

$db = Database::getInstance();

$action = $_POST['action'] ?? '';

switch ($action) {
    case 'insert':
        $nombre = $_POST['nombre'];
        $email = $_POST['email'];
        $telefono = $_POST['telefono'];

        $query = "INSERT INTO pacientes (nombre, email, telefono) VALUES (?, ?, ?)";
        $success = $db->execute($query, [$nombre, $email, $telefono]);

        echo json_encode(['success' => $success]);
        break;

    case 'list':
        $search = $_POST['search'] ?? '';
        $query = "SELECT * FROM pacientes WHERE nombre ILIKE ?";
        $result = $db->execute($query, ["%$search%"], true);

        echo json_encode($result);
        break;

    case 'update':
        $id = $_POST['id'];
        $nombre = $_POST['nombre'];
        $email = $_POST['email'];
        $telefono = $_POST['telefono'];

        $query = "UPDATE pacientes SET nombre = ?, email = ?, telefono = ? WHERE id = ?";
        $success = $db->execute($query, [$nombre, $email, $telefono, $id]);

        echo json_encode(['success' => $success]);
        break;

    case 'delete':
        $id = $_POST['id'];

        $query = "DELETE FROM pacientes WHERE id = ?";
        $success = $db->execute($query, [$id]);

        echo json_encode(['success' => $success]);
        break;

    default:
        echo json_encode(['success' => false, 'message' => 'Acción no válida']);
        break;
}
?>
