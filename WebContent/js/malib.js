/**
 * fonction JavaScript pour CineArcade
 */

function changementQuantite(qte, ref) {

	// var qte =document.getElementById("quantiteId"+numeroLigne).value;
	// var ref=document.getElementById("referenceId"+numeroLigne).value;
	var xhr = new XMLHttpRequest();
	xhr.onreadystatechange = function() {
		if (xhr.readyState == 4) {
			if (xhr.status == 200) {
				var resultat = xhr.responseText;
				// resultats contient 3 donnees sommeTotal, prixLigne, nombreProduit
				var tabResultat = resultat.split(",");
				document.getElementById("nombreId").innerHTML=tabResultat[2];
				document.getElementById("sommeTotaleId").innerHTML=tabResultat[0];
				// alert("resultat :" +resultat);
			}
		}

	}
	xhr.open("GET", "changementQuantite.htm?qte=" + qte + "&ref=" + ref, true);
	xhr.send(null);
}