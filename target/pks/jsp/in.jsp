<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <link href="../css/common.css" type="text/css" rel="stylesheet"/>
    <link href="../css/in.css" type="text/css" rel="stylesheet"/>
    <script type="text/javascript" src="../js/common.js"></script>
    <title>车辆入库</title>
</head>
<body class = "body">
<div class="head">
    杭州XX停车场收费管理系统-车辆入库
</div>
<div id="displaydate"></div>
<div id="displaytime"></div>
<form class="form" action="Controler?action=in" method="post">
    <div class="div1">车牌号码<input name="carno" required="required" pattern="^[京津沪渝冀豫云辽黑湘皖鲁新苏浙赣鄂桂甘晋蒙陕吉闽贵粤青藏川宁琼使领A-Z]{1}[A-Z]{1}[A-Z0-9]{4}[A-Z0-9挂学警港澳]{1}$" class="carno" type="text"/></div>
    <div class="div2">车辆类型</div>
    <div class="div">
        <div class="div3"><input required="required" name="cartype" type="radio" class="cartype" value="1">小型汽车</div>
        <div class="div3"><input required="required" name="cartype" type="radio" class="cartype" value="2">大型客车</div>
        <div class="div3"><input required="required" name="cartype" type="radio" class="cartype" value="3">载货卡车</div><br>
        <div class="div3"><input required="required" name="cartype" type="radio" class="cartype" value="4">施工挂车</div>
        <div class="div3"><input required="required" name="cartype" type="radio" class="cartype" value="5">小型轿车</div>
        <div class="div3"><input required="required" name="cartype" type="radio" class="cartype" value="6">小型客车</div>
    </div>
    <input class="in" type="submit" value="车辆入库"/>
</form>
<a href="Skip?action=index">返回首页</a>
</body>
</html>
