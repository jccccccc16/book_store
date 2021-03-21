<%--
  Created by IntelliJ IDEA.
  User: 61702
  Date: 2020/4/8
  Time: 17:18
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<div align="center">
    <c:if test="${requestScope.page.pageNo>1}">
        <a href="${requestScope.page.url}&pageNo=1">首页</a>
        <a href="${requestScope.page.url}&pageNo=${requestScope.page.pageNo-1}">上一页</a>
    </c:if>
    <c:choose>
        <c:when test="${requestScope.page.pageTotal <=5}">
            <c:forEach begin="1" end="${requestScope.page.pageTotal}" var="i">
                <c:if test="${requestScope.page.pageNo == i}">
                    【${i}】
                </c:if>
                <c:if test="${requestScope.page.pageNo!=i}">
                    <a href="${requestScope.page.url}&pageNo=${i}">${i}</a>
                </c:if>
            </c:forEach>
        </c:when>
        <c:when test="${requestScope.page.pageTotal>5}">
            <c:if test="${requestScope.page.pageNo<=5}">
                <c:forEach begin="1" end="5" var="i">
                    <c:if test="${requestScope.page.pageNo == i}">
                        【${i}】
                    </c:if>
                    <c:if test="${requestScope.page.pageNo!=i}">
                        <a href="${requestScope.page.url}&pageNo=${i}">${i}</a>
                    </c:if>
                </c:forEach>
                .....
                <a href="${requestScope.page.url}&pageNo=${requestScope.page.pageTotal}">${requestScope.page.pageTotal}</a>
            </c:if>
            <c:if test="${requestScope.page.pageNo>5&&requestScope.page.pageNo<requestScope.page.pageTotal-5}">
                <a href="${requestScope.page.url}&pageNo=1">1</a>
                <c:forEach begin="${requestScope.page.pageNo-2}" end="${requestScope.page.pageNo+2}" var="i">
                    <c:if test="${requestScope.page.pageNo == i}">
                        【${i}】
                    </c:if>
                    <c:if test="${requestScope.page.pageNo!=i}">
                        <a href="${requestScope.page.url}&pageNo=${i}">${i}</a>
                    </c:if>
                </c:forEach>
                <a href="${requestScope.page.url}&pageNo=${requestScope.page.pageTotal}">${requestScope.page.pageTotal}</a>
            </c:if>
            <c:if test="${requestScope.page.pageNo>requestScope.page.pageTotal-5}">
                <a href="${requestScope.page.url}&pageNo=1">1</a>
                ....
                <c:forEach begin="${requestScope.page.pageTotal-5}" end="${requestScope.page.pageTotal}" var="i">
                    <c:if test="${requestScope.page.pageNo == i}">
                        【${i}】
                    </c:if>
                    <c:if test="${requestScope.page.pageNo!=i}">
                        <a href="${requestScope.page.url}&pageNo=${i}">${i}</a>
                    </c:if>
                </c:forEach>
            </c:if>


        </c:when>

    </c:choose>
    <c:if test="${requestScope.page.pageNo<requestScope.page.pageTotal}">
        <a href="${requestScope.page.url}&pageNo=${requestScope.page.pageNo+1}">下一页</a>
        <a href="${requestScope.page.url}&pageNo=${requestScope.page.pageTotal}">末页</a>
    </c:if>

    共${requestScope.page.pageTotal}页,${requestScope.page.pageTotalCount}条记录
    到第<input id="pn_input" value="" name="pn" />页
    <input id="searchPageBtn" type="button"  value="确定"/>
</div>
<script type="text/javascript">

    $(function () {
        $("#searchPageBtn").click(function () {
            alert(1);
            var $pageNo = $("#pn_input").val();

            location.href="${pageScope.basePath}${requestScope.page.url}&pageNo="+$pageNo;

        });
    });


</script>

</body>
</html>
