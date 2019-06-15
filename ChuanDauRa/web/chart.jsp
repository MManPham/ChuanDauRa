<%-- 
    Document   : chart
    Created on : Jun 14, 2019, 7:59:47 PM
    Author     : 16521
--%>
<%@page import="com.models.Chart"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <script type="text/javascript" src="https://www.gstatic.com/charts/loader.js"></script>
        <script type="text/javascript">
                google.load("visualization", "1", {packages:["corechart"]});
                google.setOnLoadCallback(chart);

                function chart()
                {
                //var data = new google.visualization.DataTable();

                var dataArray = [
                    ['LO[i]', '${yearOne}', '${yearTwo}']
                ];
                                
                <c:forEach items="${pieDataList}" var="entry">
                    dataArray.push(['${entry.chuanDauRa}', ${entry.getKetQuaNienKhoaDau()},${entry.getKetQuaNienKhoaSau()}]);
                </c:forEach>
                
                
                
                var data = google.visualization.arrayToDataTable(dataArray);

                var chart = new google.visualization.BarChart(document.getElementById('chart_div'));

                var options = {
                isStacked: true,
                hAxis: {
                    format: ';'
                },
                vAxis: {
                    direction: -1
                },
                title:'Biểu đồ LO[i] Chênh lệch LO[i] của 2 năm ',
                     width:500,
                     height:800
                };


                var formatter = new google.visualization.NumberFormat({
                    pattern: ';'
                });

                formatter.format(data, 2);

                chart.draw(data, options);
            }
        </script>
    </head>
    <body>
        <div id="chart_div" style="width: 900px; height: 500px;"></div>
    </body>
</html>
