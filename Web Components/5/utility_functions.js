function onClickResolution() {
  const res = getResolution();
  // document.getElementById("screen-res").textContent = res;
  document.getElementById("info-list").innerHTML += `<li>${res}</li>`;
}

function onClickDate() {
  const dt = getDate();
  // document.getElementById("crt-date").textContent = dt;
  document.getElementById("info-list").innerHTML += `<li>${dt}</li>`;
}

// functie care returneaza rezolutia ecranului
function getResolution() {
  return `${screen.width} x ${screen.height}`;
}

// functie care returneaza data curenta
function getDate() {
  return new Date().toDateString();
}

// functie care determina lat si long
function getLocation() {
  if ("geolocation" in navigator) {
    navigator.geolocation.getCurrentPosition(position => {
      const latitude = position.coords.latitude;
      const longitude = position.coords.longitude;
      //document.getElementById("geoloc").textContent = `${latitude}, ${longitude}`;
      document.getElementById(
        "info-list"
      ).innerHTML += `<li>${latitude} , ${longitude}</li>`;
    });
  } else {
    window.alert("Your browser does not support geolocation");
    return undefined;
  }
}

(() => getLocation())();
