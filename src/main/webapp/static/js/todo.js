document.addEventListener("DOMContentLoaded", () => {
  const checkbox = document.querySelector("table.todotable");

  checkbox?.addEventListener("click", (e) => {
    const td = e.target;
    if (td.tagName === "CON") {
      const tr = td.closest("TR");
      const a_seq = tr.dataset.seq;
      document.location.href = `${rootPath}/${seq}/complete}`;
    }
  });
});
