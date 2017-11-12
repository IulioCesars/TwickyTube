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
            this.Ajax("MeGusta", id_video, (result)=>{ alert(result); });
        }
        
        static Reportar(id_video){
            this.Ajax("Reportar", id_video, (result)=>{ alert("Reportado lince"); });
        }
        
        static Favorito(id_video){
            this.Ajax("Favorito", id_video, (result)=>{ });
        }
        
        static Comentar(comentario, id_video){
            $.ajax(
                {  
                    type: "POST",  
                    url: "wsTwickyTube",  
                    data: "action="+"Comentario"+"&p="+ id_video + "&comentario=" + comentario,
                    success: function(result){
                        alert(result);
                    },
                    error: function (xhr, ajaxOptions, thrownError) {
                        alert("Error status code: "+xhr.status);
                        alert("Error details: "+ thrownError);
                    }   
                }
            );
            var Comentario = `<div class='glob-separate-top-bottom'>
                                <img class='vid-main-coments-img' onclick='mostrar_x();' src="resources/images/esteban.jpg">
                                <label class='vid-main-coments-user'> <a href='canal.html'>{nombreUsuario}</a> 
                                <label class='vid-main-coments-date'>{fecha}</label> </label>
                                <label class='vid-main-coments-coment'>{comentario}</label>
                            </div>`;
        
            $("#divComentarios").append(Comentario);
        }
}