<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<title>分析结果展示</title>
	<%
		pageContext.setAttribute("APP_PATH",request.getContextPath());
	%>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
    <!-- 引入jQuery -->
    <script type="text/javascript" src="${APP_PATH}/static/bootstrap/js/jquery.js"></script>
    <!-- 引入 Bootstrap -->
    <link href="${APP_PATH}/static/bootstrap/css/bootstrap.min.css" rel="stylesheet" type="text/css"></link>
    <link href="${APP_PATH}/static/bootstrap/css/bootstrap.css" rel="stylesheet" type="text/css"></link>
    <script type="text/javascript" src="${APP_PATH}/static/bootstrap/js/bootstrap.min.js'"></script>
    <script type="text/javascript" src="${APP_PATH}/static/bootstrap/js/bootstrap.js"></script>
    <script type="text/javascript" src="${APP_PATH}/static/bootstrap/js/echarts.js"></script>
    
</head>
<body>
<div>
    <div class="row bg-info" style="padding: 0;margin:0;">
        <div class="col-lg-16 text-lg-left" style="width: auto;height: 80px; padding: 3px 40px; background: #417690;line-height: 40px;color: #ffc;overflow: hidden;">
            <h1 class="h1">中文文本情感分析系统</h1>
        </div>
    </div>
    <div class="row" style="padding: 0;margin:0;">
        <div class="col-lg-2" style="padding: 0;margin:0;">
            <ol class="list-group">
                <li class="list-group-item btn btn-info" >
                    <a href="textList/?page=1" style="text-decoration: none">中文情感文本列表</a>
                </li>
                <li  class="list-group-item btn btn-info">
                    <a href="textinfo/" style="text-decoration: none">文本情感分析</a>
                </li>
            </ol>
        </div >
        <div class="col-lg-10">
            <form id="textinfo" action="/backtotextinfopage/" method="post" style="padding-left: 15px;margin-top:10px;">
                <div class="form-group row form-inline">
                    {% if text.textContent and text.textContent != '' %}
                        <textarea form="textinfo" class="form-control" rows="10" cols="90" id="text" name="inputtext" readonly="true">{{ text.textContent }}</textarea>
                        <label for="emotion" >情感标签</label>
                        <input class="form-control" type="text" id="emotion" name="emotionLabel" value="{{ label }}" readonly="true">
                        <label for="isNew" >文本新旧</label>
                        <input class="form-control" type="text" id="isNew" name="isNew" value="{{ new }}" readonly="true">
                    {% endif %}
                    <input type="submit" class="btn btn-info" value="返回">
                </div>
            </form>
            <div class="form-group row form-inline">
                <div id="CNNLSTMCHART" style="width: 300px;height:400px;background-color: #00b3ee">CNNLSTM</div>
                <div id="CNNCHART" style="width: 300px;height:400px;background-color: #98d237">CNN</div>
                <div id="LSTMCHART" style="width:300px;height:400px;background-color: #0f0f0f">LSTM</div>
            </div>
        </div>
    </div>
</div>
</body>
</html>