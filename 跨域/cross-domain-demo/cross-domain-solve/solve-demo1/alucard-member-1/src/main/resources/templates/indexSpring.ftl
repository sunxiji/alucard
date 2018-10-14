<!DOCTYPE html>
<html>
<head lang="en">
    <title>Spring Boot Demo - FreeMarker</title>
    <#--<script type="text/javascript" src="http://lib.sinaapp.com/js/jquery/1.9.1/jquery-1.9.1.min.js"></script>-->
    <script type="text/javascript" src="http://lib.sinaapp.com/js/jquery/1.9.1/jquery-1.9.1.js"></script><!-- 8300 -->

</head>
<body>
<h2>首页
    <h2>


        <button id="btn2">调用getOrderInfoCrossOrigin获取信息</button>
        <#--这里发出去的不是xhr，所以不会报错-->
        <#--<img src="http://b.alucard.com:8081/getOrderInfo" />-->
        <br/>
        result:<label id="lab2"></label>
        <script type="application/javascript">
            $(function () {
                <#-- OPTIONS -->
                $("#btn2").on("click", function () {
                    $.ajax({
                        type: "post",//如果我这里换成post会不会报错？
                        contentType:"application/json;charset=utf-8",
                        url: "http://b.alucard.com:8081/getOrderInfoCrossOrigin",
                        dataType: "json",
                        data:JSON.stringify({name:"old driver",age:"18"}),
                        success: function (data) {
                            $("#lab2").text(data.code + "," + data.info);
                        },
                        error: function () {
                            alert('fail');
                        }
                    })
                })
            });
        </script>
</body>
</html>