$(document).ready(

	function () {
		var classeGeral = $(document.body).children('.layout-wrapper');
		var menuinicial = classeGeral.children('#menuInicial');
		var divisaoconteudo = classeGeral.children('.divisao-conteudo');
		
		
		
		var painelesquerdo = divisaoconteudo.children('#painelEsquerdo');
		var sidebar = painelesquerdo.children('.layout-sidebar');
		var layoutmenu = sidebar.children('#layout-menu');
		var formesquerdo = layoutmenu.children("#formesquerdo");
		var listaesquerda = formesquerdo.children('li');
		var topicolista = listaesquerda.children('a');
		var menulatera = sidebar.children('#layout-aberto');
		var itenslatera = menulatera.children('ul');
		
		var formmenu = menuinicial.children('#formTeste');
		var topbar = formmenu.children('.topbar');
		var divseta = topbar.children('#menuEsquerda');
		var seta = divseta.children('#menu-button');
		var gira = seta.children('span');
		
		var divisaoconteudo = classeGeral.children('.divisao-conteudo');
		var conteudo = divisaoconteudo.children('#conteudo');
		
		
		seta.on(
			'click', function () {									
				if(classeGeral.hasClass("layout-wrapper-menu-active")){
					classeGeral.removeClass('layout-wrapper-menu-active');
					sidebar.css('overflow', 'hidden');
					listaesquerda.removeClass('active-topmenuitem'); 
					conteudo.addClass("ativandocont");
				}else{
					classeGeral.addClass("layout-wrapper-menu-active");
					sidebar.css('overflow','visible');
					conteudo.addClass("ativandocont");
				}
				
				
				if(!itenslatera.hasClass("ativando-lista")){
					$('#arquivo').addClass("ativando-lista");
				}
			}
		);
		
		listaesquerda.on(
			'click', function (){
				var link = $(this);
				
				classeGeral.addClass("layout-wrapper-menu-active");
				sidebar.css('overflow', 'visible');
				
				
				link.addClass("active-item");
				link.siblings('.active-item').removeClass('active-item');	

				itenslatera.siblings('.activemenus').removeClass('activemenus');
				
				if(link.hasClass("sidebar-arquivo")){
					itenslatera.siblings('.menuopcao').removeClass('ativando-lista');
					$('#arquivo').addClass("ativando-lista");	
					conteudo.removeClass("ativandocont");
				}
				
				if(link.hasClass("sidebar-atendimento")){
					itenslatera.siblings('.menuopcao').removeClass('ativando-lista');
					$('#atendimento').addClass("ativando-lista");
					conteudo.removeClass("ativandocont");
				}

				if(link.hasClass("sidebar-cadastro")){
					itenslatera.siblings('.menuopcao').removeClass('ativando-lista');
					$('#cadastro').addClass("ativando-lista");	
					conteudo.removeClass("ativandocont");
				}
				
				if(link.hasClass("sidebar-usuarios")){
					itenslatera.siblings('.menuopcao').removeClass('ativando-lista');
					$('#usuarios').addClass("ativando-lista");	
					conteudo.removeClass("ativandocont");
				}
				
				if(link.hasClass("sidebar-farmacia")){
					itenslatera.siblings('.menuopcao').removeClass('ativando-lista');
					$('#farmacia').addClass("ativando-lista");	
					conteudo.removeClass("ativandocont");
				}
				
				if(link.hasClass("sidebar-relatorios")){
					itenslatera.siblings('.menuopcao').removeClass('ativando-lista');
					$('#relatorios').addClass("ativando-lista");	
					conteudo.removeClass("ativandocont");
				}
			}
		);
		
		
		
		
		
		
	}



);