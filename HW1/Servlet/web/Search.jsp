<%--
  Created by IntelliJ IDEA.
  User: 12627
  Date: 2020/9/26
  Time: 17:40
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>CVOID_19疫情等级查询</title>
    <script type="text/javascript" src="statics/js/jquery-3.5.1.min.js"></script>
    <link rel="stylesheet" href="statics/css/bootstrap.min.css">
    <script type="text/javascript">
        $(function (){
            $('#ContID').change(function (){
                $("#CountID option:not(:first)").remove();
                var contID = $(this).val();
                if(contID != ""){
                    var url = "/zhm/GetCountry";    // FirstServlet对应URL
                    var args = {"ContID": contID};
                    $.getJSON(url, args, function (data){
                        if(data.length == 0){
                            alert("暂无该洲具体国家数据");
                        }else{
                            var CountList = data.country;
                            for(var i = 0;i < CountList.length;++i){
                                $('#CountID').append("<option value='" + CountList[i] + "'>" + CountList[i] + "</option>");
                            }
                        }
                    });
                }
            });
        });

        function GetData(){
            var contID = $("#ContID").val();
            var countID = $("#CountID").val();
            if(contID != "" && countID != ""){
                var url = "/zhm/servlet/GetData";    // FirstServlet对应URL
                var args = {"ContID": contID, "CountID": countID};
                $.getJSON(url, args, function (data){
                    if(data.length != 0){
                        // {"Level":4, "All":120000, "Add":1200, "Dead": 231};
                        document.getElementById("Level").innerText = data.Level;
                        document.getElementById("All").innerText = data.All;
                        document.getElementById("Add").innerText = data.Add;
                        document.getElementById("Dead").innerText = data.Dead;
                    }else{
                        alert("当前无该国家数据");
                    }
                });
            }else{
                alert("请选择大洲和国家");
            }
        }
    </script>
</head>
<body>
<div class="container">
    <div class="col col-centered">
        <form role="form">
            <div class="form-control" style="text-align: center;">
                <label class="col-sm-2 control-label">大洲</label>
                <div class="col-sm-4" style="margin:0 auto">
                    <select id="ContID" name="Cont" class="form-control">
                        <option value="" disabled selected hidden>Choose</option>
                        <%
                            String []contlist = (String[]) request.getAttribute("ContList");
                            for (String cont:
                                    contlist) {
                                out.print(String.format("<option value=\"%s\">%s</option>", cont, cont));
                            }
                        %>
                    </select>
                </div>
                <label class="col-sm-2 control-label">国家</label>
                <div class="col-sm-4"  style="margin:0 auto;">
                    <select id="CountID" name="Country" class="form-control">
                        <option value="" disabled selected hidden>Choose</option>
                        <!-- ajax获取对应洲所有国家 然后显示 -->
                    </select>
                </div>
                <br>
                <div style="text-align: center;">
                    <button type="button" class="btn btn waves-effect waves-light" onclick="GetData()">查询</button>
                </div>
            </div>
        </form>
    </div>
</div>
<div class="container" style="text-align: center;">
    <label class="col-sm-2 control-label">
        防控等级:
        <span id="Level" class="text-warning">0</span>
    </label>
    <br>
    <label class="col-sm-2 control-label">
        总患者数:
        <span id="All" class="text-primary">0</span>
    </label>
    <br>
    <label class="col-sm-2 control-label">
        当日新增:
        <span id="Add" class="text-primary">0</span>
    </label>
    <br>
    <label class="col-sm-2 control-label">
        总死亡数:
        <span id="Dead" class="text-danger">0</span>
    </label>
</div>
</body>
</html>
