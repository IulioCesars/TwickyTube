
function mostrar(activo, objeto)
{
	/*alert(activo, objeto);*/
	switch(objeto)
	{
		case "LOG-REG":
		{
			if(activo)
			{
				document.getElementById("reg-txt-correo").value = document.getElementById("idx-txt-correo").value;
				document.getElementById("reg-psw-contrasenia-01").value = document.getElementById("idx-psw-contrasenia").value;
				
				document.getElementById("idx-login").style = "display:none";
				document.getElementById("idx-singup").style = "display:block";
			}
			else
			{
				document.getElementById("idx-singup").style = "display:none";
				document.getElementById("idx-login").style = "display:block";
				
			}
			break;
		}
		case "MENU-OPC-01":
		{
			if(activo)
			{
				document.getElementById("glob-header-menu-01").style = "display:block";
				document.getElementById("glob-header-menu-02").style = "display:none";
				
			}
			else
			{
				document.getElementById("glob-header-menu-01").style = "display:none";
				document.getElementById("glob-header-menu-02").style = "display:none";
				
			}
			break;
		}
		case "MENU-OPC-02":
		{
			if(activo)
			{
				document.getElementById("glob-header-menu-01").style = "display:none";
				document.getElementById("glob-header-menu-02").style = "display:block";
			}
			else
			{
				document.getElementById("glob-header-menu-01").style = "display:none";
				document.getElementById("glob-header-menu-02").style = "display:none";
			}
			break;
		}
		case "MENU-OPC-OCULTAR":
		{
				document.getElementById("glob-header-menu-01").style = "display:none";
				document.getElementById("glob-header-menu-02").style = "display:none";
		}
	}
	
	
	
}

function ir_a(pagina)
{
	switch(pagina)
	{
		case 1: // INDEX
			//alert("entra");
			window.location('index.html');
		break;
		case 2:
			window.location('upload.html');
		break;
	}
}

var habilitar_perfil = true;
function habilitar(parametro)
{
	
	switch(parametro)
	{
		case "PERFIL":
			habilitar_perfil = !habilitar_perfil;
			
			var x = document.getElementsByClassName("glob-object-input");
			var i;
			/*
				for (i = 0; i < x.length; i++) {
				x[i].disabled = habilitar_perfil;
			}
			*/
			x = document.getElementsByClassName("habilita-deshabilita");
			
			for (i = 0; i < x.length; i++) {
				x[i].disabled = habilitar_perfil;
			}
			
			
			x = document.getElementsByClassName("per-object-save");
			for (i = 0; i < x.length; i++) {
				x[i].disabled = habilitar_perfil;
			}
			
			x = document.getElementsByClassName("per-object-edit");
			for (i = 0; i < x.length; i++) {
				if(habilitar_perfil) 	x[i].innerHTML  = "Editar";
				else 					x[i].innerHTML  = "Cancelar";
			}
			
			
			
			
		break;
	}
}

function validacionCamposVacios()
{
	if (document.getElementById('reg-psw-contrasenia-01').value == document.getElementById('reg-psw-contrasenia-02').value) 
	{
		return true;
	}
	else 
	{
		alert('LAS CONTRASEÑAS NO COINCIDEN, vuelve a escribirlas u.u'); 
		return false;
	}
}