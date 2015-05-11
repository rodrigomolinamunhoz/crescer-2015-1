//'use strict';
a = 10;
console.log(a);

function Elfo(options) {

  var teste = function(a,b,c,d,aerererr,a){
    console.log(a);
  }

  b = 1;
  console.log(b);

  // usamos este or lógico para atribuir valores default caso options esteja nulo
  options = options || {};
  this.nome = options.nome;
  this.flechas = options.flechas || 42;
  this.experiencia = 0;

  Elfo.prototype.atirarFlecha = function(){
	this.experiencia++;
	this.flechas--:
  }
}