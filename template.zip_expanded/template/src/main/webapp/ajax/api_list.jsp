<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>ORACLE Data를 API로 전달 받아서 web에 출력하는 형태</title>
</head>
<body>
<table border="1">
<thead>
<tr>
	<th>번호</th>
	<th>내용1</th>
	<th>내용2</th>
	<th>내용3</th>
	<th>내용4</th>
	<th>내용5</th>
</tr>
</thead>

<tbody id="table_view">

</tbody>
</table>
<script type="module">
import {api_select} from "./api_list.js?v=2";
api_select();

</script>
</body>


</html>