//Exercício 1
var chelsea = {
  nome: 'Chelsea Football Club',
  titulos: [
    { desc: 'Nacionais', qtd: 5 },
    { desc: 'Continentais', qtd: 1 },
    { desc: 'Mundiais', qtd: 0 }
  ]
};

var manutd = {
  nome: 'Manchester United Football Club',
  titulos: [
    { desc: 'Nacionais', qtd: 57 },
    { desc: 'Continentais', qtd: 5 },
    { desc: 'Mundiais', qtd: 2 }
  ]
};

var liverpool = {
  nome: 'Liverpool Football Club',
  titulos: [
    { desc: 'Nacionais', qtd: 0 },
    { desc: 'Continentais', qtd: 11 },
    { desc: 'Mundiais', qtd: 48 }
  ]
};

var arsenal = {
  nome: 'Arsenal Football Club',
  titulos: [
    { desc: 'Nacionais', qtd: 39 },
    { desc: 'Continentais', qtd: 2 },
    { desc: 'Mundiais', qtd: 0 }
  ]
};

// Exercicio 2A
	var clubes = [chelsea, manutd, liverpool, arsenal];

	function ordenaPorNacionais(Array){
		var arrayOrdenado = Array.sort(function (a, b) {
		  	if (a.titulos[0].qtd < b.titulos[0].qtd) {
		    return 1;
		  	}		
		});
		return arrayOrdenado;

	}	


