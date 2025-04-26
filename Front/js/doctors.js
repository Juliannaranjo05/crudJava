const doctorForm = document.getElementById("doctorForm");
const doctorTable = document.getElementById("doctorTable");
const filterInput = document.getElementById("filterInput");
const editDoctorModalEl = document.getElementById('editDoctorModal');
const editDoctorModal = new bootstrap.Modal(editDoctorModalEl);
const editDoctorFormElement = document.getElementById("editDoctorForm");
const updateDoctorButton = document.getElementById("updateDoctorButton");

const url = "http://localhost:8080/api/doctors";

let doctors = [];
let editingDoctorId = null;

function displayDoctors(filteredDoctors = doctors) {
  const doctorTableBody = doctorTable.querySelector("tbody");
  doctorTableBody.innerHTML = "";

  filteredDoctors.sort((a, b) => a.doctorId - b.doctorId);

  filteredDoctors.forEach((doctor) => {
    const row = doctorTableBody.insertRow();
    const nameCell = row.insertCell();
    const specialtyCell = row.insertCell();
    const phoneCell = row.insertCell();
    const emailCell = row.insertCell();
    const addressCell = row.insertCell();
    const actionsCell = row.insertCell();

    nameCell.textContent = doctor.name;
    specialtyCell.textContent = doctor.specialty;
    phoneCell.textContent = doctor.phone || "";
    emailCell.textContent = doctor.email || "";
    addressCell.textContent = doctor.address || "";

    const editButton = document.createElement("button");
    editButton.textContent = "Editar";
    editButton.className = "btn btn-primary btn-sm me-2";
    editButton.addEventListener("click", () => showEditModal(doctor));
    actionsCell.appendChild(editButton);

    const deleteButton = document.createElement("button");
    deleteButton.textContent = "Eliminar";
    deleteButton.className = "btn btn-danger btn-sm";
    deleteButton.addEventListener("click", () => deleteDoctor(doctor.doctorId));
    actionsCell.appendChild(deleteButton);
  });
}

function getDoctors() {
  fetch(url)
    .then((response) => response.json())
    .then((data) => {
      doctors = data;
      displayDoctors();
    })
    .catch((error) => console.error("Error:", error));
}

function saveDoctor(event) {
  event.preventDefault();

  const doctor = {
    name: document.getElementById("name").value,
    specialty: document.getElementById("specialty").value,
    phone: document.getElementById("phone").value,
    email: document.getElementById("email").value,
    address: document.getElementById("address").value
  };

  fetch(url, {
    method: "POST",
    headers: { "Content-Type": "application/json" },
    body: JSON.stringify(doctor)
  })
    .then((response) => response.json())
    .then(() => {
      getDoctors();
      doctorForm.reset();
    })
    .catch((error) => console.error("Error:", error));
}

function deleteDoctor(doctorId) {
  fetch(`${url}/${doctorId}`, { method: "DELETE" })
    .then(() => getDoctors())
    .catch((error) => console.error("Error:", error));
}

function showEditModal(doctor) {
  editingDoctorId = doctor.doctorId;
  document.getElementById("editName").value = doctor.name;
  document.getElementById("editSpecialty").value = doctor.specialty;
  document.getElementById("editPhone").value = doctor.phone || "";
  document.getElementById("editEmail").value = doctor.email || "";
  document.getElementById("editAddress").value = doctor.address || "";

  editDoctorModal.show();
}

function updateDoctor() {
  const updatedDoctor = {
    name: document.getElementById("editName").value,
    specialty: document.getElementById("editSpecialty").value,
    phone: document.getElementById("editPhone").value,
    email: document.getElementById("editEmail").value,
    address: document.getElementById("editAddress").value
  };

  fetch(`${url}/${editingDoctorId}`, {
    method: "PUT",
    headers: { "Content-Type": "application/json" },
    body: JSON.stringify(updatedDoctor)
  })
    .then(() => {
      getDoctors();
      editDoctorModal.hide();
    })
    .catch((error) => console.error("Error:", error));
}

doctorForm.addEventListener("submit", saveDoctor);
updateDoctorButton.addEventListener("click", updateDoctor);

filterInput.addEventListener("input", function () {
  const searchText = this.value.toLowerCase();
  const filtered = doctors.filter(d => d.name.toLowerCase().includes(searchText));
  displayDoctors(filtered);
});

getDoctors();
