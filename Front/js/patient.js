document.addEventListener('DOMContentLoaded', function () {
  cargarPacientes();

  const form = document.getElementById('pacienteForm');
  form.addEventListener('submit', function (e) {
    e.preventDefault();
    const id = document.getElementById('patientId').value;
    if (id) {
      actualizarPaciente(id);
    } else {
      registrarPaciente();
    }
  });

  document.getElementById('filtroNombre').addEventListener('input', function () {
    filtrarPacientes(this.value);
  });
});

function registrarPaciente() {
  const paciente = obtenerDatosFormulario();

  fetch('http://localhost:8080/api/patients', {
    method: 'POST',
    headers: { 'Content-Type': 'application/json' },
    body: JSON.stringify(paciente)
  })
    .then(res => {
      if (!res.ok) throw new Error('Error al registrar paciente');
      return res.json();
    })
    .then(() => {
      limpiarFormulario();
      cargarPacientes();
    })
    .catch(error => console.error('Error al registrar:', error));
}

function cargarPacientes() {
  fetch('http://localhost:8080/api/patients')
    .then(res => res.json())
    .then(data => mostrarPacientes(data))
    .catch(error => console.error('Error al cargar pacientes:', error));
}

function mostrarPacientes(pacientes) {
  const tabla = document.getElementById('tablaPacientes');
  tabla.innerHTML = '';

  pacientes.forEach(paciente => {
    const fila = document.createElement('tr');
    fila.innerHTML = `
      <td>${paciente.name}</td>
      <td>${paciente.birthDate}</td>
      <td>${paciente.gender}</td>
      <td>${paciente.phone}</td>
      <td>${paciente.address}</td>
      <td>
        <button class="btn btn-warning btn-sm me-2" onclick="editarPaciente(${paciente.id})">Editar</button>
        <button class="btn btn-danger btn-sm" onclick="eliminarPaciente(${paciente.id})">Eliminar</button>
      </td>
    `;
    tabla.appendChild(fila);
  });
}

function editarPaciente(id) {
  fetch(`http://localhost:8080/api/patients/${id}`)
    .then(res => res.json())
    .then(paciente => {
      document.getElementById('patientId').value = paciente.id;
      document.getElementById('name').value = paciente.name;
      document.getElementById('birthDate').value = paciente.birthDate;
      document.getElementById('gender').value = paciente.gender;
      document.getElementById('phone').value = paciente.phone;
      document.getElementById('address').value = paciente.address;
    })
    .catch(error => console.error('Error al cargar paciente para editar:', error));
}

function actualizarPaciente(id) {
  const paciente = obtenerDatosFormulario();

  fetch(`http://localhost:8080/api/patients/${id}`, {
    method: 'PUT',
    headers: { 'Content-Type': 'application/json' },
    body: JSON.stringify(paciente)
  })
    .then(res => {
      if (!res.ok) throw new Error('Error al actualizar paciente');
      return res.json();
    })
    .then(() => {
      limpiarFormulario();
      cargarPacientes();
    })
    .catch(error => console.error('Error al actualizar:', error));
}

function eliminarPaciente(id) {
  if (!id) {
    console.error('ID no definido para eliminar');
    return;
  }

  if (!confirm('¿Estás seguro de eliminar este paciente?')) return;

  fetch(`http://localhost:8080/api/patients/${id}`, {
    method: 'DELETE'
  })
    .then(res => {
      if (!res.ok) throw new Error('Error al eliminar paciente');
      cargarPacientes();
    })
    .catch(error => console.error('Error al eliminar:', error));
}

function obtenerDatosFormulario() {
  return {
    name: document.getElementById('name').value,
    birthDate: document.getElementById('birthDate').value,
    gender: document.getElementById('gender').value,
    phone: document.getElementById('phone').value,
    address: document.getElementById('address').value
  };
}

function limpiarFormulario() {
  document.getElementById('pacienteForm').reset();
  document.getElementById('patientId').value = '';
}

function filtrarPacientes(filtro) {
  const filas = document.querySelectorAll('#tablaPacientes tr');
  filas.forEach(fila => {
    const nombre = fila.children[0].textContent.toLowerCase();
    fila.style.display = nombre.includes(filtro.toLowerCase()) ? '' : 'none';
  });
}
