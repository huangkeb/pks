<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>停车场收费管理系统</title>
    <link href="css/index.css" type="text/css" rel="stylesheet"/>
    <link href="css/common.css" type="text/css" rel="stylesheet"/>
    <script type="text/javascript" src="js/common.js"></script>
</head>
<body class="body">
<div class="head">
    欢迎进入杭州XX停车场收费管理系统
</div>
<div id="displaydate"></div>
<div id="displaytime"></div>
<div class="buttondiv">
    <div class="div1">
        <a href="Skip?action=in" class="button" id="button1">车辆入库</a>
        <a href="Skip?action=out" class="button" id="button2">收费管理</a>
        <a href="State" class="button" id="button3">空位查询</a>
    </div>
    <div class="div2">
        <a href="Controler?action=recond" class="button" id="button4">停车记录查询</a>
        <a href="Controler?action=admin" class="button" id="button5">停车数据统计</a>
    </div>
</div>
</body>
</html>