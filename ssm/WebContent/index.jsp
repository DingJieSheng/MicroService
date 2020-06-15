<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
	<title>语料库查询</title>
	<%
		pageContext.setAttribute("APP_PATH",request.getContextPath());
	%>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
    <!-- 引入jQuery -->
    <script type="text/javascript" src="${APP_PATH}/static/bootstrap/js/jquery.js"></script>
    <!-- 引入 Bootstrap -->
    <link href="${APP_PATH}/static/bootstrap/css/bootstrap.min.css" rel="stylesheet" type="text/css"></link>
    <link href="${APP_PATH}/static/bootstrap/css/bootstrap.css" rel="stylesheet" type="text/css"></link>
    <script type="text/javascript" src="${APP_PATH}/static/bootstrap/js/bootstrap.min.js"></script>
    <script type="text/javascript" src="${APP_PATH}/static/bootstrap/js/bootstrap.js"></script>
    
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
                <a class="btn btn-info col-lg-12 disabled" style="text-decoration: none">中文情感文本列表</a>
                <a class="btn btn-info col-lg-12" href="${APP_PATH }/textinfo" style="text-decoration: none">文本情感分析</a>
            </div >
            <div class="col-lg-10">
                <form action="/querytext" method="post" class="form-inline" style="padding-left: 15px;margin-top:10px;">
                    <div class="form-group row">
                        <label for="textcontent" >模糊查询</label>
                        <input type="text" class="form-control " id="textcontent" placeholder="请输入模糊匹配的文本" name="searchtext">
                        <label for="emotionLabel1" >正面情感</label>
                        <input class="radio" type="radio" class="form-control " id="emotionLabel1" name="emotionLabel" value="1">
                        <label for="emotionLabel2" >负面情感</label>
                        <input class="radio" type="radio" class="form-control " id="emotionLabel2" name="emotionLabel" value="0">
                        <input type="submit" value="搜索" class="btn btn-info">
                    </div>
                </form>
                <table class="table table-bordered table-condensed table-hover table-striped" style="padding: 0;margin:0;" id="texttabel">
                    <thead class="">　　　　　　　　　　　　　　　　　
                        <tr class="bg-info">　　　　
                            <th class="col-lg-1 text-center">ID</th>　　　　　　　　　　<!--每列标题-->
                            <th class="col-lg-9 text-center">文本内容</th>
                            <th class="col-lg-1 text-center">情感标签</th>
                            <th class="col-lg-1 text-center">新旧标签</th>
                        </tr>
                    </thead>

                    <tbody>　
<!--                     传统的解析方式，此处用ajax改进。 -->
<%--                     	<c:forEach items="${pageinfo.list}" var="text"> --%>
<!--                     		<tr class="bg-info">　　　　 -->
<%-- 	                            <th class="col-lg-1 text-center"><a class="col-lg-12" href="${APP_PATH }/textinfo?textID=${text.id}" style="text-decoration: none">${text.id}</a></th>　　　　　　　　　　<!--每列标题--> --%>
<%-- 	                            <th class="col-lg-9 text-center">${text.textcontent}</th> --%>
<%-- 	                            <th class="col-lg-1 text-center">${text.emotionlabel == 0?"消极":"积极"}</th> --%>
<%-- 	                            <th class="col-lg-1 text-center">${text.isnew == 0?"旧文本":"新文本"}</th> --%>
<!-- 	                        </tr> -->
<%--                     	</c:forEach>　　　　　　　　　　　　　　　　　　　　　　　 --%>
                    	
                    </tbody>
                </table>
                <!-- 显示分页信息 -->
                <div class="row">
                    <!-- 分页文字信息 -->
                    <div class="col-md-6" id="navigator-summary">
<%--                     	当前为第${pageinfo.pageNum}页,总共${pageinfo.pages}页,总共${pageinfo.total}条记录。 --%>
                    </div>
                    <!-- 分页条信息 -->
                    <div class="col-md-6">
                    	<nav aria-label="pagination">
	                    	<ul class="pagination" id="navigator-ul">
<%-- 	                   			<li><a href="${APP_PATH }/searchtext?page=1">首页</a></li> --%>
<%-- 	                    		<c:if test="${pageinfo.hasPreviousPage}"> --%>
<%-- 	                    				<li><a href="${APP_PATH }/searchtext?page=${pageinfo.pageNum-1}" aria-label="Previous"><span aria-hidden="true">&laquo;</span></a></li> --%>
<%-- 	                    		</c:if> --%>
<%-- 	                    		<c:forEach items="${pageinfo.navigatepageNums}" var="page_Num"> --%>
<%-- 	                    			<c:if test="${page_Num == pageinfo.pageNum }"> --%>
<%-- 	                    				<li class="active disable"><a href="#">${page_Num}</a></li> --%>
<%-- 	                    			</c:if> --%>
<%-- 	                    			<c:if test="${page_Num != pageinfo.pageNum }"> --%>
<%-- 	                    				<li><a href="${APP_PATH }/searchtext?page=${page_Num}">${page_Num}</a></li> --%>
<%-- 	                    			</c:if> --%>
<%-- 	                    		</c:forEach> --%>
<%-- 	                    		<c:if test="${pageinfo.hasNextPage}"> --%>
<%-- 	                    				<li><a href="${APP_PATH }/searchtext?page=${pageinfo.pageNum+1}" aria-label="Next"><span aria-hidden="true">&raquo;</span></a></li> --%>
<%-- 	                    		</c:if> --%>
<%-- 	                    		<li><a href="${APP_PATH }/searchtext?page=${pageinfo.pages}">末页</a></li> --%>
	                    	</ul>
                    	</nav>
                    </div>
                </div>
            </div>
        </div>
    </div>
    <script type="text/javascript">
    	//页面加载完成后，直接发送ajax请求，查询分页数据并在前端页面显示
    	$(function(){
    		pageOfText(1);
		});
    	
    	function pageOfText(page){
    		$.ajax({
    	        //几个参数需要注意一下
    	        type: "GET",//方法类型
    	        dataType: "json",//预期服务器返回的数据类型
    	        url: "${APP_PATH}/searchtext" ,//url
    	        data: "page="+page,
    	        success: function (data) {
    	        	build_textlist(data);
    	        	build_nav(data);
    	        },
    	        error : function() {
    	            
    	        }
    	    });
    	}
    	
    	function build_textlist(result) {
//     		每次发起ajax请求都要清空上一次的数据，否则会堆叠。
    		$("#texttabel tbody").empty();
			var list = result.resultMap.pageInfo.list;
			$.each(list,function(index, item){
// 				超链接用点击事件
				var link = $("<a></a>").append(item.id).attr("href","${APP_PATH }/textinfo?textID="+item.id);
				var textid = $("<td></td>").append(link).addClass("text-center");
				var textcontent = $("<td></td>").append(item.textcontent);
				var emotionlabel = $("<td></td>").append(item.emotionlabel == 0?"消极":"积极").addClass("text-center");
				var isnew = $("<td></td>").append(item.isnew == 0?"旧文本":"新文本").addClass("text-center");
				$("<tr></tr>").addClass("bg-info").append(textid)
							.append(textcontent)
							.append(emotionlabel)
							.append(isnew)
							.appendTo("#texttabel tbody");
			});
		}
    	
		function build_nav(result) {
			$("#navigator-summary").empty();
			$("#navigator-ul").empty();
			var pageinfo = result.resultMap.pageInfo;
			$("#navigator-summary").append("当前为第"+pageinfo.pageNum+"页,总共"+pageinfo.pages+"页,总共"+pageinfo.total+"条记录。");
			var firstPageLi = $("<li></li>").append($("<a></a>").append("首页").attr("href", "#"));
			var lastPageLi = $("<li></li>").append($("<a></a>").append("末页").attr("href", "#"));
			var prePageLi = $("<li></li>").append($("<a></a>").append("&laquo;").attr("href", "#"));
			var nextPageLi = $("<li></li>").append($("<a></a>").append("&raquo;").attr("href", "#"));
			if(pageinfo.hasPreviousPage == false){
				firstPageLi.addClass("disabled");
				prePageLi.addClass("disabled");
			}
			else{
				firstPageLi.click(function(){
					pageOfText(1);
				});
				prePageLi.click(function(){
					pageOfText(pageinfo.pageNum - 1);
				});
			}
			if(pageinfo.hasNextPage == false){
				lastPageLi.addClass("disabled");
				nextPageLi.addClass("disabled");
			}
			else{
				lastPageLi.click(function(){
					pageOfText(pageinfo.pages);
				});
				nextPageLi.click(function(){
					pageOfText(pageinfo.pageNum + 1);
				});
			}
			$("#navigator-ul").append(firstPageLi).append(prePageLi);
			$.each(pageinfo.navigatepageNums,function(index, item){
				var numLi = $("<li></li>").append($("<a></a>").append(item).attr("href", "#"));
				if(pageinfo.pageNum == item){
					numLi.addClass("active");
				}
				numLi.click(function(){
					pageOfText(item);
				});
				$("#navigator-ul").append(numLi);
			});
			$("#navigator-ul").append(nextPageLi).append(lastPageLi);
		}
    </script>
</body>
</html>