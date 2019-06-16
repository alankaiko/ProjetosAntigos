$(document).ready(

	function () {
		var formulario = $(document.body).children('.formulario');
		var painelLogin = formulario.children('.login-panel');
		var uig = painelLogin.children('.ui-g');
		var uig12 = uig.children('.ui-g-12');
		var campo = uig12.children('.md-inputfield');
		var campoTexto = campo.children('.ui-inputtext');
		var campoSenha = campo.children('.ui-password');
		
		campoTexto.keyup(
			function () {									
				if(campoTexto.val() != ''){
					campoTexto.addClass('ui-state-filled');
				}else{
					campoTexto.removeClass('ui-state-filled');
				}
			}
		);

		
		campoSenha.keyup(
			function () {									
				if(campoSenha.val() != ''){
					campoSenha.addClass('ui-state-filled');
				}else{
					campoSenha.removeClass('ui-state-filled');
				}
			}
		);
		
	}
	

);