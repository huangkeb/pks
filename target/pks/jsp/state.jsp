<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ page import = "com.hkb.Bean.Park,java.util.*" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <link href="<%=request.getContextPath()%>/css/state.css" type="text/css" rel="stylesheet"/>
    <link href="<%=request.getContextPath()%>/css/common.css" type="text/css" rel="stylesheet"/>
    <script type="text/javascript" src="<%=request.getContextPath()%>/js/common.js"></script>
    <title>空位查询</title>
</head>
<body class="body">
<div class="head">
    杭州XX停车场收费管理系统-空位查询
</div>
<div id="displaydate"></div>
<div id="displaytime"></div>
<table>
    <% ArrayList<Park> stateList = (ArrayList<Park>)session.getAttribute("stateList");Park state;%>
    <tr>
        <% for(int i = 1;i<=20;i++){
            state = stateList.get(i-1);%>
        <td class="Park <%= state.getCarno() %>"><span><%= state.getCarno() %></span>
            <%= state.getParkno() %></td>
        <%} %>
    </tr>
    <tr>
        <% for(int i = 21;i<=40;i++){
            state = stateList.get(i-1);%>

        <td class="Park <%= state.getCarno() %>"><span><%= state.getCarno() %></span>
            <%= state.getParkno() %></td>
        <%} %>
    </tr>
    <tr>
        <% for(int i = 41;i<=60;i++){
            state = stateList.get(i-1);%>

        <td class="Park <%= state.getCarno() %>"><span><%= state.getCarno() %></span>
            <%= state.getParkno() %></td>
        <%} %>
    </tr>
    <tr>
        <% for(int i = 61;i<=80;i++){
            state = stateList.get(i-1);%>

        <td class="Park <%= state.getCarno() %>"><span><%= state.getCarno() %></span>
            <%= state.getParkno() %></td>
        <%} %>
    </tr>
    <tr>
        <% for(int i = 81;i<=100;i++){
            state = stateList.get(i-1);%>

        <td class="Park <%= state.getCarno() %>"><span><%= state.getCarno() %></span>
            <%= state.getParkno() %></td>
        <%} %>
    </tr>
</table>
<a href="Skip?action=index">返回首页</a>
</body>
</html>