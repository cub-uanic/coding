// export from browser
var data = JSON.stringify(localStorage); console.log(data); copy(data);

// import to the browser
var data = /* exported/copied data */;
Object.keys(data).forEach(function (k) {
  localStorage.setItem(k, data[k]);
});

