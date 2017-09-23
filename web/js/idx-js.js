
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
				document.getElementById("reg-psw-contrasenia").value = document.getElementById("idx-psw-contrasenia").value;
				
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
