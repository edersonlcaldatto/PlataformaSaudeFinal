var AtendimentoController = new function () {

	let baseUrl = "http://localhost:8080/atendimentos";

	this.getAtendimentos = function () {
		$.get({
			type: 'GET',
			url: baseUrl,
			success: function (result) {
				loadAtendimentos(result)
			},
			error: (xhr) => {
				alert("Erro ao buscar os Atendimentos: " + xhr.status + " - " + xhr.statusText)
			},
		});
	}

	this.delete = function (event) {
		let idAtendimento = event.target.parentNode.parentNode.querySelector('.idAtendimento').innerText;
		console.log("delete " + idAtendimento);

		$.ajax({
			url: baseUrl + '/' + idAtendimento,
			method: 'DELETE',
			contentType: 'application/json',
			success: function (result) {
				AtendimentoController.getAtendimentos();
			},
			error: function (request, msg, error) {
				alert('Erro ao deletar');
			}
		});
	}

	this.save = function () {
		var idAtendimentoToEdit = $("#idAtendimento").val();

		if (idAtendimentoToEdit == null || idAtendimentoToEdit == "") {
			var atendimento = this.getDadosAtendimentoModal();

			$.ajax({
				url: baseUrl,
				type: 'POST',
				contentType: "application/json; charset=utf-8",
				dataType: "json",
				data: JSON.stringify(atendimento),
				success: function () {
					$("#idAtendimento").val("");
					$('#cadastrarAtendimento').modal('hide');
					AtendimentoController.getAtendimentos();
					AtendimentoController.limparDadosAtendimentoModal();
				},
				error: function (request, msg, error) {
					$("#idAtendimento").val("");
					$('#cadastrarAtendimento').modal('hide');
					AtendimentoController.getAtendimentos();
					AtendimentoController.limparDadosAtendimentoModal();
				}
			});
		}
		else {
			AtendimentoController.update(idAtendimentoToEdit);
		}
	}

	this.update = function (idAtendimento) {
		var atendimento = this.getDadosAtendimentoModal();

		$.ajax({
			url: baseUrl + '/' + idAtendimento,
			method: 'PUT',
			contentType: "application/json; charset=utf-8",
			dataType: "json",
			data: JSON.stringify(atendimento),
			success: function (result) {
				$("#idAtendimento").val("");
				$('#cadastrarAtendimento').modal('hide');
				AtendimentoController.getAtendimentos();
				AtendimentoController.limparDadosAtendimentoModal();
			},
			error: function (request, msg, error) {
				$("#idAtendimento").val("");
				$('#cadastrarAtendimento').modal('hide');
				AtendimentoController.getAtendimentos();
				AtendimentoController.limparDadosAtendimentoModal();
			}
		});
	}

	this.edit = function (event) {
		let idAtendimento = event.target.parentNode.parentNode.querySelector('.idAtendimento').innerText;

		$("#idAtendimento").val(idAtendimento);
		console.log(idAtendimento);
		$.get(baseUrl + '/' + idAtendimento, function (data) {
			$('#cadastrarAtendimento').modal('show');
			AtendimentoController.setDadosAtendimentoModal(data);
		});
	}

	this.setDadosAtendimentoModal = function (atendimento) {
		$('#atendimentoModalidade').val(atendimento.modalidade);
		$('#atendimentoProcedimento').val(atendimento.procedimento);
        $('#atendimentoMedico').val(atendimento.medico.nome);
        $('#atendimentoPaciente').val(atendimento.paciente.nome);
	}

	this.limparDadosAtendimentoModal = function () {
		$('#atendimentoModalidade').val("");
		$('#atendimentoProcedimento').val("");
        $('#atendimentoMedico').val("");
        $('#atendimentoPaciente').val("");

	}

	this.getDadosAtendimentoModal = function () {

        var atendimento = {
			modalidade: $('#atendimentoModalidade').val(),
			nomeProcedimento: $('#atendimentoProcedimento').val(),
            medico: getMedico(),
            paciente: getPaciente()           
		}
        console.log(atendimento);

		return atendimento;
    }

    function getPaciente() {
        return {
            idPaciente : $('#atendimentoPaciente').val()
        }
    }
    
    function getMedico() {
        return  { 
            idMedico: $('#atendimentoMedico').val() 
        }
    }

	function loadAtendimentos(atendimentoJson) {

		$('#atendimentosTableBody').empty();

		for (i = 0; i <= atendimentoJson.length; i++) {
			adicionaAtendimento(atendimentoJson[i]);
		}
	}

	function adicionaAtendimento(atendimento) {
		let atendimentoTr = montaTr(atendimento);
		let tabela = document.getElementById("atendimentosTableBody");
		tabela.appendChild(atendimentoTr);
	}

	function montaTr(atendimento) {
		let atendimentoTr = document.createElement("tr");
		atendimentoTr.classList.add("atendimento");
		atendimentoTr.appendChild(montaTd(atendimento.idAtendimento, "idAtendimento"));
		atendimentoTr.appendChild(montaTd(atendimento.dataHora, "dataHora"));
        atendimentoTr.appendChild(montaTd(atendimento.modalidade, "modalidade"));
        atendimentoTr.appendChild(montaTd(atendimento.nomeProcedimento, "nomeProcedimento"));
        atendimentoTr.appendChild(montaTd(atendimento.medico.nome, "medicoNome"));
        atendimentoTr.appendChild(montaTd(atendimento.paciente.nome, "pacienteNome"));

		let td = document.createElement("td");
		td.classList = "actions";

        let a = document.createElement("a");
		a.classList = "btn btn-warning btn-xs";
		a.addEventListener("click", AtendimentoController.edit);
		a.innerText = "Editar";
		td.appendChild(a);

		let a1 = document.createElement("a");
		a1.classList = "btn btn-danger btn-xs";
		a1.addEventListener("click", AtendimentoController.delete);
		a1.innerText = "Excluir";
		td.appendChild(a1);

		atendimentoTr.appendChild(td)

		return atendimentoTr;
	}

	function montaTd(dado, classe) {
		let td = document.createElement("td");
		td.textContent = dado;
		td.classList.add(classe);

		return td;
	}
}

window.onload = AtendimentoController.getAtendimentos();