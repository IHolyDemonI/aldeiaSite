<%--
  Created by IntelliJ IDEA.
  User: Vera Estanqueiro
  Date: 08/11/2018
  Time: 16:46
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<html>
<head>
    <title>Waiting...</title>
    <meta http-equiv="refresh" content="5"/>
</head>

<body onload="myFunction()">

<p id="texto" style="display: none">Na mesa, arraste o seu avatar para uma área de jogo dispoível. Depois arraste uma carta.</p>

<form action="waitingAction" method="post">
    <input type="submit" id="check" value="Seguinte" style="visibility: hidden;"/>
</form>

</body>
<script>
    function myFunction() {
        setInterval(function() {document.getElementById("check").click()}, 1000);
        //setTimeout(function() {console.log("Refresh")}, 2000);
    }
</script>
</html>
