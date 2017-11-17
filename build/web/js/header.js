var estado_h01= true;
var estado_h02 = true;
function mostrar_header(objeto)
{
	/*alert(activo, objeto);*/
	switch(objeto)
	{
		case "MENU-OPC-01":
		{
			if(estado_h01)
			{
				document.getElementById("glob-header-menu-01").style = "display:block";
				document.getElementById("glob-header-menu-02").style = "display:none";
				
			}
			else
			{
				document.getElementById("glob-header-menu-01").style = "display:none";
				document.getElementById("glob-header-menu-02").style = "display:none";
				
			}
			estado_h01 = !estado_h01;
			break;
		}
		case "MENU-OPC-02":
		{
			if(estado_h02)
			{
				document.getElementById("glob-header-menu-01").style = "display:none";
				document.getElementById("glob-header-menu-02").style = "display:block";
				
			}
			else
			{
				document.getElementById("glob-header-menu-01").style = "display:none";
				document.getElementById("glob-header-menu-02").style = "display:none";
			}
			estado_h02 = !estado_h02;
			break;
		}
		case "MENU-OPC-OCULTAR":
		{
				document.getElementById("glob-header-menu-01").style = "display:none";
				document.getElementById("glob-header-menu-02").style = "display:none";
				break;
		}
	}
	
	
	
}

function ocultar_header()
{
	estado_h01 = false;
	mostrar_header('MENU-OPC-01');
	
	estado_h02 = false;
	mostrar_header('MENU-OPC-02');
}
