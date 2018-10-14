<!DOCTYPE html>
<html>
<head lang="en">
    <title>Spring Boot Demo - FreeMarker</title>
    <script type="text/javascript" src="https://code.jquery.com/jquery-3.3.1.js"></script>

</head>
<body>
<h2>首页<h2>
    <button id="btn">调用order获取信息</button>
    <#--这里发出去的不是xhr，所以不会报错-->
    <#--<img src="http://b.alucard.com:8081/getOrderInfo" />-->
    <br/>
    result:<label id="lab"></label>
    <script type="application/javascript">
        $(function () {
           $("#btn").on("click",function () {
               $.ajax({
                   type: "get",
                   async: false,
                   url:"http://b.alucard.com:8081/getOrderInfo",
                   dataType:"json",
                   success:function (data) {
                        $("#lab").text(data.code+","+data.info);
                   },
                   error:function () {
                       alert('fail');
                   }
               })
           })
        });
    </script>
</body>
</html>