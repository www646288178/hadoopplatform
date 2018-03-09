<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/res/css/global.css">
    <script type="application/javascript" src="${pageContext.request.contextPath}/resources/layui/layui.js"></script>
</head>
<body>
    <div id="domid">11111111</div>
</body>
<script type="application/javascript">
    layui.use(['jquery','layer'],function(){
        var $ = layui.$;
        var layer = layui.layer;
        layer.msg($('#domid').html());
    });

</script>
</html>
