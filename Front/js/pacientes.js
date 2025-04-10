const URL_API = "http://localhost:8080/api/patients";

document.addEventListener('DOMContentLoaded', () => {
    cargarPacientes();

    const form = document.getElementById('pacienteForm');

    form.addEventListener('submit', async (e) => {
        e.preventDefault();

        const paciente = {
            name: document.getElementById('name').value,
            birthDate: document.getElementById('birthDate').value,
            gender: document.getElementById('gender').value,
            phone: document.getElementById('phone').value,
            address: document.getElementById('address').value
        };

        try {
            const response = await fetch(URL_API, {
                method: 'POST',
                headers: { 'Content-Type': 'application/json' },
                body: JSON.stringify(paciente)
            });

            if (!response.ok) {
                throw new Error("Error al guardar paciente");
            }

            form.reset();
            cargarPacientes();
            alert("✅ Paciente registrado correctamente.");
        } catch (error) {
            console.error("Error en la solicitud:", error);
            alert("❌ Hubo un error al guardar el paciente.");
        }
    });
});

async function cargarPacientes() {
    try {
        const response = await fetch(URL_API);
        const pacientes = await response.json();

        const tabla = document.getElementById('tablaPacientes');
        if (tabla) {
            tabla.innerHTML = ""; // Limpia la tabla antes de cargar nuevos datos
            pacientes.forEach(p => {
                tabla.innerHTML += `
                    <tr>
                        <td>${p.patientId}</td>
                        <td>${p.name}</td>
                        <td>${p.birthDate}</td>
                        <td>${p.gender}</td>
                        <td>${p.phone}</td>
                        <td>${p.address}</td>
                    </tr>
                `;
            });
        }
    } catch (error) {
        console.error("Error al cargar pacientes:", error);
        alert("❌ Error al cargar la lista de pacientes.");
    }
}
