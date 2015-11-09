var canvas = document.getElementById("juego");
var imports = "";

function include(url) {
    imports += " " + url;
}

include("src/mdl/Animacion.java");
include("src/mdl/Agente.java");
include("src/mdl/Lapix.java");
include("src/mdl/ILetra.java");
include("src/mdl/LetraA.java");
include("src/mdl/LetraB.java");
include("src/mdl/Letra.java");
include("src/mdl/Nivel.java");
include("src/mdl/Nivel1.java");

include("src/main/Main.java");
include("src/main/main.pjs");

canvas.setAttribute("data-processing-sources", imports);
window.addEventListener('load', function () { // on page load
    canvas.addEventListener('touchstart', function (e) {
        var touchobj = e.changedTouches[0];
        var x = parseInt(touchobj.clientX);
        var y = parseInt(touchobj.clientY);
        var p = Processing.getInstanceById('juego');
        p.touchEnd(x, y);
    });
}, false);

var bonusn = 0;

function playA(name){
    var audio = document.getElementById(name + bonusn);
    audio.play();
    bonusn ++;
    if (bonusn >= 4){
        bonusn = 0;
    }
}


//python -m SimpleHTTPServer 8000