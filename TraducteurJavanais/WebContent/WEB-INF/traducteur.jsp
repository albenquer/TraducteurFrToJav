<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Traducteur Français-Javanais</title>
</head>
<body>

	<p>Entrez votre texte puis choisissez le sens de traduction</p>

	<form method="post" action="traduction">
		<label for="nom">Texte à traduire : </label> 
		<input type="text" 	 name="texteOrigine" id="texteOrigine" /> 
		<input type="submit" name="action" value="FrToJav" /> 
		<input type="submit" name="action"	value="JavToFr" />
	</form>

	<p>----- Résultat -----</p>
	<%
		String texteTraduit = (String) request.getAttribute("texteTraduit");

		if (texteTraduit != null) {
			out.println(texteTraduit);
		}
	%>

</body>
</html>