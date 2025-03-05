document.addEventListener("DOMContentLoaded", listarPacientes);

document.getElementById("formPaciente").addEventListener("submit", function(e) {
    e.preventDefault();
    let id = document.getElementById("id").value;
    let nombre = document.getElementById("nombre").value;
    let email = document.getElementById("email").value;
    let telefono = document.getElementById("telefono").value;
    let action = id ? "update" : "insert";

    fetch("/libreria/crud.php", {
        method: "POST",
        body: new URLSearchParams({ id, nombre, email, telefono, action })
    }).then(response => response.json())
    .then(() => {
        this.reset();
        listarPacientes();
    });
});

document.getElementById("search").addEventListener("input", listarPacientes);

function listarPacientes() {
    fetch("/libreria/crud.php", {
        method: "POST",
        body: new URLSearchParams({ action: "list", search: document.getElementById("search").value })
    }).then(response => response.json())
    .then(data => {
        let tbody = document.getElementById("pacientes");
        tbody.innerHTML = "";
        data.forEach(p => {
            tbody.innerHTML += `
                <tr>
                    <td>${p.nombre}</td>
                    <td>${p.email}</td>
                    <td>${p.telefono}</td>
                    <td>
                        <button class="btn btn-primary btn-sm" onclick='editar(${JSON.stringify(p)})'>Editar</button>
                        <button class="btn btn-danger btn-sm" onclick='eliminar(${p.id})'>Eliminar</button>
                    </td>
                </tr>`;
        });
    });
}

function editar(p) {
    document.getElementById("id").value = p.id;
    document.getElementById("nombre").value = p.nombre;
    document.getElementById("email").value = p.email;
    document.getElementById("telefono").value = p.telefono;
}

function eliminar(id) {
    fetch("/libreria/crud.php", {
        method: "POST",
        body: new URLSearchParams({ id, action: "delete" })
    }).then(response => response.json())
    .then(() => listarPacientes());
}