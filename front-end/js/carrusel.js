let indiceActual = 0;
let intervalo;

function moverCarrusel(direccion) {
  const items = document.querySelectorAll('.carrusel-item');
  const totalItems = items.length;

  items[indiceActual].classList.remove('active');

  indiceActual = (indiceActual + direccion + totalItems) % totalItems;

  items[indiceActual].classList.add('active');

  const carruselContenedor = document.querySelector('.carrusel-contenedor');
  carruselContenedor.style.transform = `translateX(-${indiceActual * 100}%)`;

  reiniciarIntervalo();
}

function iniciarIntervalo() {
  intervalo = setInterval(() => {
    moverCarrusel(1);
  }, 5000);
}

function reiniciarIntervalo() {
  clearInterval(intervalo);
  iniciarIntervalo();
}

iniciarIntervalo();