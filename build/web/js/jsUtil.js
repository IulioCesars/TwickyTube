var imported = document.createElement('script');
imported.src = '/TwickyTube/js/jquery-3.2.1.min.js';
document.head.appendChild(imported);
class jsUtil{
        static constructor(){
            
        }
        
        static Ajax(p_action, p, completo){
            $.ajax(
                {  
                    type: "POST",  
                    url: "wsTwickyTube",  
                    data: "action="+p_action+"&p="+ p,  
                    success: function(result){
                        if(result != "Error"){
                            completo(result);
                        }
                    },
                    error: function (xhr, ajaxOptions, thrownError) {
                        alert("Error status code: "+xhr.status);
                        alert("Error details: "+ thrownError);
                    }   
                }
            ); 
        }
        
        static Suscribirse(id_usuario){
            this.Ajax("Suscribirse", id_usuario, (result)=>{ alert(result); });
        }
        
        static MeGusta(id_video){
            this.Ajax("MeGusta", id_video, (result)=>{ 
                if(result == "Me Gusta"){
                    $("#btnLike").attr("src","resources/images/dislike_01.png");
                    $("#lblLike").text( parseInt( $("#lblLike").text()) +1 );
                }else{
                    $("#btnLike").attr("src","resources/images/like_01.png");
                    $("#lblLike").text( parseInt( $("#lblLike").text()) -1 );
                }
            });
        }
        
        static Reportar(id_video){
            this.Ajax("Reportar", id_video, (result)=>{ alert("Reportado lince"); });
        }
        
        static Favorito(id_video){
            this.Ajax("Favorito", id_video, (result)=>{ alert(result); });
        }
        
        static Comentar(comentario, id_video){
        if(comentario == null || comentario.length==0){ return; }    
        $("body").css("cursor", "progress");
        var Comentario = `<div class='glob-separate-top-bottom'>
                    <img class='vid-main-coments-img' onclick='mostrar_x();' src="MostrarAvatar?id={nombreUsuario}">
                    <label class='vid-main-coments-user'> <a href='canal.jsp?id={nombreUsuario}'>{nombreUsuario}</a> 
                    <label class='vid-main-coments-date'>{fecha}</label> </label>
                    <label class='vid-main-coments-coment'>{comentario}</label>
                </div>`;
            $.ajax(
                {  
                    type: "POST",  
                    url: "wsTwickyTube",  
                    data: "action="+"Comentario"+"&p="+ id_video + "&comentario=" + comentario,
                    success: function(result){
                        var jsonComentario = JSON.parse(result);
                        Comentario = Comentario.replace("{nombreUsuario}",jsonComentario.fk_usuario);
                        Comentario = Comentario.replace("{nombreUsuario}",jsonComentario.fk_usuario);
                        Comentario = Comentario.replace("{nombreUsuario}",jsonComentario.fk_usuario);
                        Comentario = Comentario.replace("{fecha}","Hace un momento");
                        Comentario = Comentario.replace("{comentario}",jsonComentario.comentario);

                        $("#txtComentarios").val('');
                        $("body").css("cursor", "default");
                        $("#divComentarios").append(Comentario);
                    },
                    error: function (xhr, ajaxOptions, thrownError) {
                        alert("Error status code: "+xhr.status);
                        alert("Error details: "+ thrownError);
                        $("body").css("cursor", "default");
                    }   
                }
            );
        }
}