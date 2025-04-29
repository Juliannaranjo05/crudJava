const patientForm = document.getElementById("patientForm");
const patientTable = document.getElementById("patientTable");
const filterInput = document.getElementById("filterInput");
const editPatientModalEl = document.getElementById('editPatientModal');  // Elemento del modal
const editPatientModal = new bootstrap.Modal(editPatientModalEl); // Instancia del modal de Bootstrap
const editPatientFormElement = document.getElementById("editPatientForm");
const updatePatientButton = document.getElementById("updatePatientButton");


const url = "http://localhost:8080/api/patients";

let patients = [];
let editingPatientId = null;

function displayPatients(filteredPatients = patients) {
  const patientTableBody = patientTable.querySelector("tbody");
  patientTableBody.innerHTML = "";

  // Ordenar los pacientes por ID de menor a mayor
  filteredPatients.sort((a, b) => a.patientId - b.patientId);

  filteredPatients.forEach((patient) => {
    const row = patientTableBody.insertRow();
    const nameCell = row.insertCell();
    const birthDateCell = row.insertCell();
    const genderCell = row.insertCell();
    const phoneCell = row.insertCell();
    const addressCell = row.insertCell();
    const actionsCell = row.insertCell();


    nameCell.textContent = patient.name;
    birthDateCell.textContent = patient.birthDate;
    genderCell.textContent = patient.gender;
    phoneCell.textContent = patient.phone || "";
    addressCell.textContent = patient.address || "";

    const editButton = document.createElement("button");
    editButton.textContent = "Editar";
    editButton.className = "btn btn-primary btn-sm me-2";
    editButton.addEventListener("click", () => showEditModal(patient));
    actionsCell.appendChild(editButton);

    const deleteButton = document.createElement("button");
    deleteButton.textContent = "Eliminar";
    deleteButton.className = "btn btn-danger btn-sm";
    deleteButton.addEventListener("click", () => deletePatient(patient.patientId));
    actionsCell.appendChild(deleteButton);
  });
}

function getPatients() {
  fetch(url)
    .then((response) => response.json())
    .then((data) => {
    patients = data;

    // Obtener todos los IDs existentes
    const usedIds = new Set(patients.map(p => p.patientId));

    // Buscar el menor ID libre
    let id = 1;
    while (usedIds.has(id)) {
      id++;
    }
    nextPatientId = id;

    displayPatients();
  })
}

function savePatient(event) {
  event.preventDefault();

  const patient = {
    name: document.getElementById("name").value,
    birthDate: document.getElementById("birthDate").value,
    gender: document.getElementById("gender").value,
    phone: document.getElementById("phone").value,
    address: document.getElementById("address").value,
  };

  const method = editingPatientId ? "PUT" : "POST";
  const urlToUse = editingPatientId ? `${url}/${editingPatientId}` : url;

  fetch(urlToUse, {
    method: method,
    headers: {
      "Content-Type": "application/json",
    },
    body: JSON.stringify(patient),
  })
    .then((response) => response.json())
    .then((data) => {
      if (!editingPatientId) {
        patients.push(data);
      } else {
        const index = patients.findIndex((p) => p.patientId === data.patientId);
        patients[index] = data;
      }
      displayPatients();
      patientForm.reset();
      document.getElementById("gender").selectedIndex = 0;
      editingPatientId = null;
      document.querySelector('button[type="submit"]').textContent = "Guardar Paciente";
    })
    .catch((error) => console.error("Error:", error));
}

function showEditModal(patient) {
  editingPatientId = patient.patientId;
  document.getElementById("editName").value = patient.name;
  document.getElementById("editBirthDate").value = patient.birthDate;
  document.getElementById("editGender").value = patient.gender;
  document.getElementById("editPhone").value = patient.phone || "";
  document.getElementById("editAddress").value = patient.address || "";
  editPatientModal.show();
}

function updatePatient() {
  const updatedPatientData = {
    name: document.getElementById("editName").value,
    birthDate: document.getElementById("editBirthDate").value,
    gender: document.getElementById("editGender").value,
    phone: document.getElementById("editPhone").value,
    address: document.getElementById("editAddress").value,
  };

  fetch(`${url}/${editingPatientId}`, {
    method: "PUT",
    headers: {
      "Content-Type": "application/json",
    },
    body: JSON.stringify(updatedPatientData),
  })
    .then((response) => response.json())
    .then((data) => {
      const index = patients.findIndex((p) => p.patientId === data.patientId);
      patients[index] = data;
      displayPatients();
      editPatientModal.hide();
      editingPatientId = null;
    })
    .catch((error) => console.error("Error:", error));
}

function deletePatient(id) {
  if (confirm("¿Estás seguro de que deseas eliminar este paciente?")) {
    fetch(`${url}/${id}`, {
      method: "DELETE",
    })
      .then(() => {
        patients = patients.filter((p) => p.patientId !== id);
        displayPatients();
      })
      .catch((error) => console.error("Error:", error));
  }
}

filterInput.addEventListener("input", (event) => {
  const searchTerm = event.target.value.toLowerCase();
  const filteredPatients = patients.filter((patient) =>
    patient.name.toLowerCase().includes(searchTerm)
  );
  displayPatients(filteredPatients);
});

patientForm.addEventListener("submit", savePatient);
updatePatientButton.addEventListener("click", updatePatient);

getPatients();
