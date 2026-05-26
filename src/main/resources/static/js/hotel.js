document.addEventListener("DOMContentLoaded", function () {
  const confirmLinks = document.querySelectorAll("[data-confirm]");

  confirmLinks.forEach(function (link) {
    link.addEventListener("click", function (event) {
      const message = link.dataset.confirm;

      if (!window.confirm(message)) {
        event.preventDefault();
      }
    });
  });
});