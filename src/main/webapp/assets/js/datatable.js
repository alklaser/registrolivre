var RegistroLivre = RegistroLivre || {};
var tabelaGlobal;


RegistroLivre.DataTable = function DataTable(){
	
	function cria(dados){
		var checkbox = 0;
		var dataEmissaoDocumento = 3;
		var dataEmissaoOrdenada = 4;
		var dataRegistro = 5;
		var id = 6;
		
		var tabela = $('#tabelaListagem').DataTable({
			data : dados,
			responsive: true,
			stateSave: true,
			
			columns : [ {"render" :	function(data,type,row){return '<input type="checkbox" class="datatable-selecao">';},
							className: "dt-body-center"},
						{ data : 'nomeFantasia'	}, 
			            { data : 'endereco.logradouro', className:"desktop"},
			            { data : 'dataEmissaoDocumento', className:"desktop dt-body-center"},
	 		            { data : 'dataEmissaoOrdenada', className:"never"},
			            { data : 'dataRegistro', className:"never"},
			            { data : 'id', className:"never"}
			          ],		
	        "aoColumnDefs" : [ {
				"iDataSort" : dataEmissaoOrdenada,
				"aTargets" : [dataEmissaoDocumento]
			},
			{ 
				'aTargets': [checkbox],
				'orderable': false
			},
			{
				"aTargets" : [dataEmissaoOrdenada],
				"aTargets" : [id],
				"aTargets" : [dataRegistro],
				"visible" : false,
			}],
			"order": [[ dataRegistro, "desc" ]],
			"rowCallback": function(row, data){
				$("td:gt("+checkbox+")", row).on('click', function(){					
					window.location.href = '/visualizacao/' + data.id;
				});
				
				$(".datatable-selecao", row).on("click", function(){					
					selecionarLinha($(this).parents('tr'), $(this).prop("checked"));
				});
			},
			"language": {
	            "lengthMenu": "Mostrar _MENU_ resultados por página",
	            "zeroRecords": "Nenhum registro de empresa encontrado.",
	            "search": "Filtrar resultados:",
	            "info": "Mostrando página _PAGE_ de _PAGES_",
	            "infoEmpty": "Sem registros disponíveis",
	            "paginate": {
	                "first":      "Primeiro",
	                "last":       "Último",
	                "next":       "Próximo",
	                "previous":   "Anterior"
	            }
	        },       
	        
	        "autoWidth": false
		});
		
		criaBotaoDownloadMultiplo();		
		eventoSelecionaTodos();
		tabelaGlobal = tabela;
	};

	var criaBotaoDownloadMultiplo = function criaBotaoDownloadMultiplo(){
		if($('#btn-multi-download').length === 0){
			var $botaoDownload = $('<button id="btn-multi-download" class="btn btn-success">Download</button>');
			$("#tabelaListagem_length").append($botaoDownload);
			eventoBotaoMultiDownload();			
		}		
	} 
	
	var selecionarLinha = function selecionarLinha(tr, checked){			
			(checked)? tr.addClass('selected') : tr.removeClass('selected');	 		

			var $botaoDownload = $('#btn-multi-download');
			(tabelaGlobal.rows('.selected')[0].length === 0)? $botaoDownload.hide(): $botaoDownload.show();					
	}
	
	var eventoBotaoMultiDownload = function eventoBotaoMultiDownload(){
		$('#btn-multi-download').click(function(){
			var nomeEmpresas = "Você está baixando o arquivo das empresas: ";			
			var get = '/empresa/download?';
			tabelaGlobal.rows('.selected').data().each(function(data){
				get += 'ids=' + data.id + '&'; 
				nomeEmpresas += data.nomeFantasia + ", ";
			});
			
			nomeEmpresas = nomeEmpresas.substring(0, nomeEmpresas.length-2) + ".";
			
			if(confirm($('<textarea />').html(nomeEmpresas).text())){
				window.location.href = get;
			}
		});
	};
	
	var eventoSelecionaTodos = function eventoSelecionaTodos(){		
		$selecionaTodos = $('#seleciona-todos');
		$selecionaTodos.on("click", function(){			
			$("tr").each(function(){		
				criaBotaoDownloadMultiplo();
				$(this).find(".datatable-selecao").prop("checked",$selecionaTodos.prop("checked"));
				selecionarLinha($(this), $(this).find(".datatable-selecao").prop("checked"));
			});
		});
	}
	
	return {
		cria : cria
	}
}

var datatable = new RegistroLivre.DataTable();