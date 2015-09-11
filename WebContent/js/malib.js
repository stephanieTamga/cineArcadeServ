/**
 *  fonction  JavaScript pour CineArcade 
 */

function changementQuantite(qte,ref){
	
	//var qte =document.getElementById("quantiteId"+numeroLigne).value;
	//var ref=document.getElementById("referenceId"+numeroLigne).value;
	var xhr= new XMLHttpRequest(); 
	xhr.onreadystatechange=function(){
		if(xhr.readyState==4){
			if(xhr.status==200){
				var resultat= xhr.responseText;
				alert("resultat :" +resultat);
			}
		}
		
	}
	xhr.open("GET", "changementQuantite.htm?qte="+qte+"&ref="+ref, true);
	xhr.send(null);
}