const mainNav = document.getElementById("mainNav");

const headerSubTitle = document.querySelector(".header-subtitle");

function shrinkingNavBar() {
  if (
    document.body.scrollTop > 100 ||
    document.documentElement.scrollTop > 100
  ) {
    mainNav.style.backgroundColor = "white";
    // mainNav.style.backgroundImage =
    //   "linear-gradient(to left,rgba(170, 255, 169, 0.95),rgba(17, 255, 188, 0.9))";
    mainNav.style.padding = "0.15rem 1rem";

    mainNav.classList.add("material");
  } else {
    mainNav.style.backgroundColor = "rgba(0,0,0,0)";
    mainNav.style.backgroundImage =
      "linear-gradient(to left,rgba(170, 255, 169, 0.0),rgba(17, 255, 188, 0.0))";
    mainNav.style.padding = "1rem 1rem";

    mainNav.classList.remove("material");
  }
}

window.onscroll = function () {
  shrinkingNavBar();
};
