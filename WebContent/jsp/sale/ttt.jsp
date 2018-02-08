<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<script>
$(document).ready(function(){
    $("#why").click(function(){
        $("#div1").load("tt.html");
    });
});
</script>
</head>
<body>

<div id="div1">왜.......

<button id="why">왜 안되죠..</button>
</div>

</body>
</html>