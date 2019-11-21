let stopwatch = document.getElementById("stopwatch"),
  start = document.getElementById("btn-start"),
  stop = document.getElementById("btn-stop"),
  reset = document.getElementById("btn-reset"),
  hours = 0,
  minutes = 0,
  seconds = 0,
  time;

function add() {
  seconds++;
  if (seconds >= 60) {
    seconds = 0;
    minutes++;
    if (minutes >= 60) {
      minutes = 0;
      hours++;
    }
  }

  stopwatch.textContent =
    (hours ? (hours > 9 ? hours : "0" + hours) : "00") +
    ":" +
    (minutes ? (minutes > 9 ? minutes : "0" + minutes) : "00") +
    ":" +
    (seconds > 9 ? seconds : "0" + seconds);

  timer();
}

function timer() {
  time = setTimeout(add, 1000);
}

start.onclick = timer;

stop.onclick = function() {
  clearTimeout(time);
};

reset.onclick = function() {
  stopwatch.textContent = "00:00:00";
  seconds = 0;
  minutes = 0;
  hours = 0;
};

/*
start.addEventListener("keyup", function(event) {
  // Number 13 is the "Enter" key on the keyboard
  if (event.keyCode === 13) {
    // Cancel the default action, if needed
    event.preventDefault();
    // Trigger the button element with a click
    document.getElementById("btn-start").click();
  }
});

stop.addEventListener("keyup", function(event) {
    // Number 13 is the "Enter" key on the keyboard
    if (event.keyCode === 13) {
      // Cancel the default action, if needed
      event.preventDefault();
      // Trigger the button element with a click
      document.getElementById("btn-stop").click();
    }
  });
  */