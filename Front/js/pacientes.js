let pacientes = [];
let modoEdicion = false;
let idEditar = null;

const formulario = document.getElementById("pacienteForm");
const tabla = document.getElementById("tablaPacientes");
const filtro = document.getElementById("filtroNombre");

const nameInput = document.getElementById("name");
const birthDateInput = document.getElementById("birthDate");
const genderInput = document.getElementById("gender");
const phoneInput = document.getElementById("phone");
const addressInput = document.getElementById("address");
const patientIdInput = document.getElementById("patientId");

const API_URL = "http://localhost:8080/api/patients";

// Cargar pacientes al iniciar
window.onload = () => {
  cargarPacientes();
};

function cargarPacientes() {
  fetch(API_URL)
    .then(res => res.json())
    .then(data => {
      pacientes = data;
      mostrarPacientes(pacientes);
    })
    .catch(err => console.error("Error al cargar pacientes:", err));
}

function mostrarPacientes(lista) {
  tabla.innerHTML = "";
  lista.forEach(p => {
    tabla.innerHTML += `
      <tr>
        <td>${p.name}</td>
        <td>${p.birthDate}</td>
        <td>${p.gender}</td>
        <td>${p.phone}</td>
        <td>${p.address}</td>
        <td>
          <button class="btn btn-warning btn-sm me-2" onclick="editarPaciente(${p.id})">Editar</button>
          <button class="btn btn-danger btn-sm" onclick="eliminarPaciente(${p.id})">Eliminar</button>
        </td>
      </tr>
    `;
  });
}

formulario.addEventListener("submit", function (e) {
  e.preventDefault();

  const paciente = {
    name: nameInput.value,
    birthDate: birthDateInput.value,
    gender: genderInput.value,
    phone: phoneInput.value,
    address: addressInput.value
  };

  if (modoEdicion && idEditar !== null) {
    // Editar paciente
    fetch(`${API_URL}/${idEditar}`, {
      method: "PUT",
      headers: { "Content-Type": "application/json" },
      body: JSON.stringify(paciente)
    })
      .then(res => res.json())
      .then(() => {
        resetForm();
        cargarPacientes();
      })
      .catch(err => console.error("Error al actualizar paciente:", err));
  } else {
    // Crear paciente
    fetch(API_URL, {
      method: "POST",
      headers: { "Content-Type": "application/json" },
      body: JSON.stringify(paciente)
    })
      .then(res => res.json())
      .then(() => {
        resetForm();
        cargarPacientes();
      })
      .catch(err => console.error("Error al crear paciente:", err));
  }
});

function editarPaciente(id) {
  const paciente = pacientes.find(p => p.id === id);
  if (paciente) {
    modoEdicion = true;
    idEditar = id;
    nameInput.value = paciente.name;
    birthDateInput.value = paciente.birthDate;
    genderInput.value = paciente.gender;
    phoneInput.value = paciente.phone;
    addressInput.value = paciente.address;
  }
}

function eliminarPaciente(id) {
  // Verifica que el id es válido antes de hacer la solicitud
  if (id) {
    if (confirm("¿Estás seguro de que quieres eliminar este paciente?")) {
      fetch(`${API_URL}/${id}`, {
        method: "DELETE"
      })
        .then(res => {
          if (res.ok) {
            // Si la eliminación fue exitosa, recarga los pacientes
            cargarPacientes();
          } else {
            console.error("Error al eliminar el paciente:", res.statusText);
          }
        })
        .catch(err => console.error("Error al eliminar paciente:", err));
    }
  } else {
    console.error("ID del paciente no válido");
  }
}

filtro.addEventListener("input", () => {
  const texto = filtro.value.toLowerCase();
  const filtrados = pacientes.filter(p => p.name.toLowerCase().includes(texto));
  mostrarPacientes(filtrados);
});

function resetForm() {
  formulario.reset();
  modoEdicion = false;
  idEditar = null;
  patientIdInput.value = "";
}
