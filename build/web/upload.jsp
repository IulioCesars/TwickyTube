<!DOCTYPE html>
<html>
    <head>
        <title> Upload </title>
        <meta charset='utf-8'>
        <meta name="viewport" content="width=device-width, initial-scale=1.0" />
        <link href='css/glob-style.css?v=1.1.1' type='text/css' rel='stylesheet'>
        <link href='css/idx-style.css?v=1.1.1' type='text/css' rel='stylesheet'>
        <script src="js/idx-js.js?v=1" type="text/javascript" ></script>
    </head>
    <body>
        <jsp:include page="header.jsp" flush="true" />
        <section onclick="mostrar(true, 'MENU-OPC-OCULTAR');">
            <div id='idx-login' class='idx-login dbd-main overflow'>
                <div class='dbd-start'>
                    <form method='post' action='Publicacion' enctype='multipart/form-data'>
                        <label class='idx-login-gen-label dbd-start-title center-text'> Subir nuevo video </label>
                        <span class='dbd-start-span upl-span upl-span-sec-01'>
                            <div id='upl-div-content' class='width-100x shadow-center-1004 padding-TB'>
                                <div> Video </div>
                                <img  id='upl-video-example' class='height-quad-100' src='resources/images/upload_video.png'/>
                                <output id='upl-output-vid'></output>
                            </div>
                            <input name='path_vid_video' id='upl-vid' type='file' class='glob-object-input upl-content shadow-center-1004' required accept="video/mp4">
                        </span>
                        <span class='dbd-start-span upl-span upl-span-sec-01'>
                            <div id='upl-div-content' class='width-100x shadow-center-1004 padding-TB'>
                                <div> Imagen de vista previa </div>
                                <img id='upl-image-example' class='height-quad-100' src='resources/images/upload_image.png'/>
                                <output id='upl-output-img'></output>
                            </div>
                            <input name='path_img_video' id='upl-img' type='file' class='glob-object-input upl-content shadow-center-1004' required accept="image/png, .jpeg, .jpg, image/gif">
                        </span>
                        <span class='dbd-start-span upl-span upl-span-sec-02'>						
                            <div id='upl-div-content' class='width-100x shadow-center-1004'>
                                <input name='titulo' class='glob-object-input not-shadows' type='text' placeholder='Escribe aqui la descripcion del video' required>
                                <input class='glob-object-submit not-shadows' type='submit' placeholder='Subir video'>
                            </div>
                        </span>
                    </form>
                </div>
            </div>
        </section>    
        <jsp:include page="footer.jsp" flush="true" />
    </body>
</html>
<script>
function mostrar_video(evt) 
{
	var files = evt.target.files; // FileList object
	document.getElementById('upl-video-example').style = 'display:none;';
	/*document.getElementById('upl-div-content').removeClass('padding-TB');*/
	//Obtenemos la imagen del campo "file". 
	for (var i = 0, f; f = files[i]; i++) 
	{         
		//Solo admitimos imágenes.
		if (!f.type.match('video.*')) 
		{
			continue;
		}
   
		var reader = new FileReader();
	   
		reader.onload = (function(theFile) 
		{
		   return function(e) 
		   {
				// Creamos la imagen.
				document.getElementById("upl-output-vid").innerHTML = ['<video class=upload-height src="', e.target.result,'" title="', escape(theFile.name), '"/>'].join('');
		   };
	   })(f);

	   reader.readAsDataURL(f);
	}
}
function mostrar_imagen(evt) 
{
	var files = evt.target.files; // FileList object
	document.getElementById('upl-image-example').style = 'display:none;';
	/*document.getElementById('upl-div-content').removeClass('padding-TB');*/
	//Obtenemos la imagen del campo "file". 
	for (var i = 0, f; f = files[i]; i++) 
	{         
		//Solo admitimos imágenes.
		if (!f.type.match('image.*')) 
		{
			continue;
		}
   
		var reader = new FileReader();
	   
		reader.onload = (function(theFile) 
		{
		   return function(e) 
		   {
				// Creamos la imagen.
				document.getElementById("upl-output-img").innerHTML = ['<img class=upload-height src="', e.target.result,'" title="', escape(theFile.name), '"/>'].join('');
		   };
	   })(f);

	   reader.readAsDataURL(f);
	}
}	
	document.getElementById('upl-vid').addEventListener('change', mostrar_video, false);
	document.getElementById('upl-img').addEventListener('change', mostrar_imagen, false);
</script>