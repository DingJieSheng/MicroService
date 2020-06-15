<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
	<title>文本详情</title>
	<%
		pageContext.setAttribute("APP_PATH",request.getContextPath());
	%>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
    <!-- 引入jQuery -->
    <script type="text/javascript" src="${APP_PATH}/static/bootstrap/js/jquery.js"></script>
    <!-- 引入 Bootstrap -->
    <link href="${APP_PATH}/static/bootstrap/css/bootstrap.min.css" rel="stylesheet" type="text/css">
    <link href="${APP_PATH}/static/bootstrap/css/bootstrap.css" rel="stylesheet" type="text/css">
    <script type="text/javascript" src="${APP_PATH}/static/bootstrap/js/bootstrap.min.js"></script>
    <script type="text/javascript" src="${APP_PATH}/static/bootstrap/js/bootstrap.js"></script>
    <script type="text/javascript" src="${APP_PATH}/static/bootstrap/js/echarts.js" charset="UTF-8"></script>
    
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
            <a class="btn btn-info col-lg-12" href="${APP_PATH }/index.jsp" style="text-decoration: none">中文情感文本列表</a>
            <a class="btn btn-info col-lg-12 disabled" href="${APP_PATH }/textinfo" style="text-decoration: none">文本情感分析</a>
        </div >
        <div class="col-lg-10">
            <form id="textinfo" style="padding-left: 15px;margin-top:10px;">
                <div class="form-group row form-inline">
                    <label for="CNNLSTM" >CNN-LSTM</label>
                    <input class="checkbox form-control" type="checkbox" id="CNNLSTM" name="network" value="0">
                    <label for="CNN" >CNN</label>
                    <input class="checkbox form-control" type="checkbox" id="CNN" name="network" value="1">
                    <label for="LSTM" >LSTM</label>
                    <input class="checkbox form-control" type="checkbox" id="LSTM" name="network" value="2">
                    <label for="LSTM" >LSTM-CNN</label>
                    <input class="checkbox form-control" type="checkbox" id="LSTMCNN" name="network" value="3">
                    <input type="button" value="提交分析" class="btn btn-info" onclick="predict()">
                </div>
                <div class="form-group row form-inline" id="newData" style="padding-top: 10px;padding-bottom: 20px;" name="saveData">
                	<c:if test="${textinfo != null}">
                        <textarea form="textinfo" class="form-control" rows="10" cols="78" id="text" name="text" readonly="true" style="resize: none">${textinfo.textcontent}</textarea>
                        <label for="emotion" >情感标签</label>
                        <input class="form-control " type="text" id="emotion" name="emotionLabel" value="${textinfo.emotionlabel==0?'消极文本':'积极文本'}" readonly="true">
                        <label for="isNew" >文本新旧</label>
                        <input class="form-control " type="text" id="isNew" name="isNew" value="${textinfo.isnew==0?'旧文本':'新文本'}" readonly="true">
                    </c:if>
                    <c:if test="${textinfo == null}">
                        <textarea form="textinfo" class="form-control" rows="10" cols="78" id="text" name="text" style="resize: none" placeholder="请输入您想要分析的文本数据......"></textarea>
                        <label for="label" >情感标签</label>
                        <select class="form-control" id="label" name="emotionLabel">
                            <option value="1">正面情感</option>
                            <option value="0">负面情感</option>
                        </select>
                        <label for="save" >文本新旧</label>
                        <select class="form-control" id="new" name="isNew">
                            <option value="0">旧文本</option>
                            <option value="1">新文本</option>
                        </select>
                    </c:if>
                    <c:if test="${textinfo == null}">
	                	<a class="btn btn-info" id="save-btn" href="#">保存</a>
	                </c:if>
                </div>
            </form>
            <table class="table">
                <thead>
                    <tr class="bg-info">
                        <th class="col-lg-12 text-center" colspan="4">分析结果可视化图表</th>
                    </tr>
                </thead>
                <tbody>
                    <tr>
                        <td class="col-lg-3"><div id="CNNLSTMCHART" style=";height:300px;"></div></td>
                        <td class="col-lg-3"><div id="CNNCHART" style=";height:300px;"></div></td>
                        <td class="col-lg-3"><div id="LSTMCHART" style=";height:300px;"></div></td>
                        <td class="col-lg-3"><div id="LSTMCNNCHART" style=";height:300px;"></div></td>
                    </tr>
                </tbody>
            </table>
            <div style="padding-bottom:20px;">
                <div id="bottom"></div>
                <button type="button" class="btn btn-info center-block" onclick="goback()">返回</button>
            </div>
        </div>
    </div>
</div>
<script type="text/javascript" src="${APP_PATH}/static/bootstrap/js/ajaxsubmit.js" charset="UTF-8"></script>
<script type="text/javascript">
	$(function(){
		$("#save-btn").click(function(){
			if(validation()){
				save();
			}
		});
	});
	
	function validation(){
		var text = $("#text").val();
		var regex = /^\s+$/;
		if(text == null || regex.test(text)){
			alert("文本不能为空或以空白字符串开头！")
			return false;
		}
		return true;
	}
	
	function save(){
		var text = $("#text").serialize();
		var label = $("#label").serialize();
		var isnew = $("#new").serialize();
		var param = text + "&" + label + "&" + isnew;
		$.ajax({
	        //几个参数需要注意一下
	        type: "POST",//方法类型
	        dataType: "json",//预期服务器返回的数据类型
	        url: "${APP_PATH}/insertText" ,//url
	        data: param,
	        success: function (data) {
	        	if (data.code == 100) {
	                alert("SUCCESS!");
	            }
	        	else{
	        		alert("Save Failed!");
	        	}
	        },
	        error : function() {
	        	alert("Save Failed!");
	        }
	    });
	}
</script>
</body>
</html>