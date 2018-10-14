<!DOCTYPE html>
<html>
<head lang="en">
    <title>zuul</title>
    <script type="text/javascript" src="http://lib.sinaapp.com/js/jquery/1.9.1/jquery-1.9.1.min.js"></script>
    <#--<script type="text/javascript" src="http://lib.sinaapp.com/js/jquery/1.9.1/jquery-1.9.1.js"></script><!-- 8300 &ndash;&gt;-->

</head>
<body>
        <h2>通过Zuul网关方式</h2>
        <button id="btn">调用order获取信息</button>
    <#--这里发出去的不是xhr，所以不会报错-->
    <#--<img src="http://b.alucard.com:8081/getOrderInfo" />-->
        <br/>
        result:<label id="lab"></label>

        <script type="application/javascript">
            $(function () {
                $("#btn").on("click", function () {
                    $.ajax({
                        type: "get",//如果我这里换成post会不会报错？
                        async: false,
                        url: "http://api.alucard.com/api-b/getOrderInfo",
                        dataType: "json",
                        success: function (data) {
                            $("#lab").text(data.code + "," + data.info);
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