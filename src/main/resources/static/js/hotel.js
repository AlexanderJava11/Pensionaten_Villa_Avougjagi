document.addEventListener('DOMContentLoaded', () => {
  document.querySelectorAll('[data-confirm]').forEach(link => {
    link.addEventListener('click', e => {
      if (!confirm(link.dataset.confirm)) e.preventDefault();
    });
  });
});
