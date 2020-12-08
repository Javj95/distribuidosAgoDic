/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

var identificador;
var rol;
var historial;

//
var cargarExpediente = function (curp) {
    fetch('http://localhost:8080/ServletExpediente/'+curp, { method: 'GET'})
            .then(res => res.json())
            .then(datos => {
                console.log(datos)
    })
            .catch(error => console.log("Ocurrió un error" + error));

}

var llenarHistorial = function () {
    document.getElementsById("historial");
}

function getCookie(name) {
  const value = `; ${document.cookie}`;
  const parts = value.split(`; ${name}=`);
  if (parts.length === 2) return parts.pop().split(';').shift();
}