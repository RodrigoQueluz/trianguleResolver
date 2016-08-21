<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Triangule type Resolver</title>

<script type="text/javascript">
	$('#submitTriangule').click(
			function() {
				var side1 = $("#side1").val();
				var side2 = $("#side2").val();
				var side3 = $("#side3").val();

				if (side1 == "" || side2 == "" || side3 == "")
					alert("Please input all the sides of the triangule!")
				else if (!$.isNumeric(side1) || !$.isNumeric(side2) || !$.isNumeric(side3))
					alert("The sides must be numerics only!")
				else if  parseInt(side1) < 0 || parseInt(side2) < 0  || parseInt(side3) < 0 )
					alert("The sides must be greater than ZERO!")
				else {
					$.ajax({
					    url: '/triangule',
					    dataType: 'json',
					  }).done(successFunction)
					    .fail(errorFunction)
					});
				}

			});
			
			function successFunction(data) {
				if (data.length > 0) {
					var trianguleType = data.result;
					
					$("#trianguleType").text(trianguleType);
					$("#result").show();
				}
			}
			
			function errorFunction(){
				alert("There was an error with the process!")
			}
</script>

</head>
<body>
	<h1>Input the Triangule</h1>
	<form action="/triangule" method="post">
		<div>
			<table>
				<tr>
					<td>First Side: <input type="text" name="size1" /></td>
					<td>Second Side: <input type="text" name="size2" /></td>
					<td>Third Side: <input type="text" name="size3" /></td>
				</tr>
				<tr id="result" style="display:none">
					Type of the given Triangule: <b><label id="trianguleType"></label></b>
				</tr>
			</table>
		</div>
		<a id="submitTriangule" href="#">Analyze</a>
	</form>
</body>
</html>