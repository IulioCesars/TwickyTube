
function validar_dos_input_por_id(idInput1, idInput2)
{
    if(document.getElementById(idInput1).value == document.getElementById(idInput2).value)
    {
        alert('ok, iguales');
    }
    else
    {
        alert('eh, perate, no son iguales >:v');
    }
}
