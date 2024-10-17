<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

<!-- Latest compiled and minified CSS -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">

<!-- jQuery library -->
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>

<!-- Latest compiled JavaScript -->
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script> 

</head>
<body onload="init()">
	<h1>실시간 대기오염 정보</h1>
	
	지역 : 
	<select id="location">
		<option>서울</option>
		<option>대전</option>
		<option>대구</option>
		<option>부산</option>
	</select>

	<button id="btn1" class="btn btn-sm btn-primary" onclick="getAirStatusHandler()">해당지역 대기오염 정보</button>
	
	<br><br>

	<table id="result" class="table">
		<thead>
			<tr>
				<th>측정소명</th>
				<th>측정일시</th>
				<th>통합대기환경수치</th>
				<th>미세먼지농도</th>
				<th>일산화탄소농도</th>
				<th>일산화질소농도</th>
				<th>오존농도</th>
			</tr>
		</thead>
		<tbody>
			<!--서버로부터 받아온 데이터-->
		</tbody>
	</table>

	<script>

		function init(){
			document.getElementById("btn1").click();
		}
		function getAirStatusHandler(){
			//지역명포함해서 서버로 ajax요청
			const location = document.querySelector("#location").value;

			getAirStatus({location: location}, function(airStatusList){
				console.log(airStatusList)
				const itemList = airStatusList.response.body.items;

				drawAirBody(document.querySelector("#result tbody"), itemList);
			})
		}

		function getAirStatus(data, callback){
			$.ajax({
				url: "air",
				data: data,
				success : function(result){
					callback(result)
				},
				error: function(){
					console.log("대기정보 api요청 실패")
				}
			})
		}

		function drawAirBody(parent, itemArr){
			parent.innerHTML = "";

			for(const item of itemArr){
				parent.innerHTML += ("<tr>"
										+ "<td>" + item.stationName + "</td>"
										+ "<td>" + item.dataTime + "</td>"
										+ "<td>" + item.khaiValue + "</td>"
										+ "<td>" + item.pm10Value + "</td>"
										+ "<td>" + item.coValue + "</td>"
										+ "<td>" + item.no2Value + "</td>"
										+ "<td>" + item.o3Value + "</td>"
									+ "</tr>")
			}
		}


	</script>
</body>
</html>