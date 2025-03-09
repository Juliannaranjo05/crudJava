document.getElementById('comprar').addEventListener('click', function () {
    document.getElementById('modalPagos').style.display = 'flex';
});
  
document.querySelector('.cerrar-modal').addEventListener('click', function () {
    document.getElementById('modalPagos').style.display = 'none';
});
  
window.addEventListener('click', function (event) {
    const modal = document.getElementById('modalPagos');
    if (event.target === modal) {
      modal.style.display = 'none';
    }
});