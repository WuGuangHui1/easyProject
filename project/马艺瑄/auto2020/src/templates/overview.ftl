<?xml version="1.0" encoding="utf-8" ?>

<head>
    <title>test</title>
    <meta http-equiv="Content-Type" content="text/html;charset=utf-8" />
    <meta name="description" content="TestNG unit test results." />
    <style type="text/css">
        body
        {
            margin: 10px 20px;
            font-size: 14px;
            font-family: "Arial","Microsoft YaHei","黑体","宋体",sans-serif;
        }
        /*table*/
        /*{*/
            /*border-collapse: collapse;*/
            /*text-align: center;*/
            /*font-size: 14px;*/
        /*}*/
        /*table td, table th*/
        /*{*/
            /*border: 2px solid #cc6f4a;*/
            /*color: #666;*/
            /*height: 20px;*/
            /*text-align: center;*/
            /*padding: 3px 3px;*/
        /*}*/
        /*table thead th*/
        /*{*/
            /**/
            /*width: 100px;*/
        /*}*/
        /*table tr:nth-child(odd)*/
        /*{*/
            /*background: #fff;*/
        /*}*/
        /*table tr:nth-child(even)*/
        /*{*/
            /*background: #c9dafa;*/
        /*}*/
        .successBtn {
            width: 60px;
            padding:3px;
            background-color: #58ab48;
            border-color: #58ab48;
            color: #fff;
            -moz-border-radius: 10px;
            -webkit-border-radius: 10px;
            border-radius: 10px; /* future proofing */
            -khtml-border-radius: 10px; /* for old Konqueror browsers */
            text-align: center;
            vertical-align: middle;
            border: 1px solid transparent;
            font-weight: 500;
            /*font-size:125%*/
        }
        .failBtn{
            width: 60px;
            padding:3px;
            background-color: #ab2e2d;
            border-color: #ab2e2d;
            color: #fff;
            -moz-border-radius: 10px;
            -webkit-border-radius: 10px;
            border-radius: 10px; /* future proofing */
            -khtml-border-radius: 10px; /* for old Konqueror browsers */
            text-align: center;
            vertical-align: middle;
            border: 1px solid transparent;
            font-weight: 500;
            /*font-size:125%*/
        }
    </style>

    <style>
        /* Border styles */
        .tabNoBorder thead, .tabNoBorder tr {
            border-top-width: 1px;
            border-top-style: solid;
            border-top-color: rgb(211, 202, 221);
        }
        .tabNoBorder {
            border-bottom-width: 1px;
            border-bottom-style: solid;
            border-bottom-color: rgb(211, 202, 221);
        }

        /* Padding and font style */
        .tabNoBorder td, .tabNoBorder th {
            padding: 5px 10px;
            font-size: 14px;
            font-family: Verdana;
            color: rgb(95, 74, 121);
        }

        /* Alternating background colors */
        .tabNoBorder tr:nth-child(even) {
            background: rgb(223, 216, 232)
        }
        .tabNoBorder tr:nth-child(odd) {
            background: #FFF
        }
    </style>


</head>
<body>
<br/>
<h2>Summary</h2>
<table id="summary" class="tabNoBorder">
    <tr class="columnHeadings">
        <th>用例总数</th>
        <th>未执行用例数</th>
        <th>执行通过</th>
        <th>执行失败</th>
        <th>跳过用例数</th>
        <th>执行时间(s)</th>
        <th>用例通过率</th>
        <#--<th>alltestMethod</th>-->
        <#--<th>excluedMethod</th>-->
    </tr>

    <tr>
        <td>${overView.allTestsSize}</td>
        <td>${overView.excludeTestsSize}</td>
        <td>${overView.passedTestsSize}</td>
        <td>${overView.failedTestsSize}</td>
        <td>${overView.skippedTestsSize}</td>
        <td>${overView.testsTime}</td>
        <td>${overView.passPercent}</td>
        <#--<td>-->
            <#--<#list overView.allTestsMethod as item>-->
                <#--${item.methodName}-->
            <#--</#list>-->
        <#--</td>-->
        <#--<td>-->
            <#--<#list overView.excludeTestsMethod as item1>-->
                <#--${item1.methodName}-->
            <#--</#list>-->
        <#--</td>-->
    </tr>
</table>
<br/><br/>
<h2>Detail</h2>
<table class="tabNoBorder">
    <tr class="columnHeadings">
        <th>编号</th>
        <th>Class</th>
        <th>MethodName</th>
        <th>用例描述</th>
        <th>执行结果</th>
        <th>执行时间(s)</th>
        <th>报错信息</th>
    </tr>
    <#assign caseNo = 0>
    <#list fail as failCase>
        <tr>
            <#assign caseNo=caseNo+1>
            <td>${caseNo}</td>
            <td>${failCase.className}</td>
            <td>${failCase.testName}</td>
            <td>${failCase.description!}</td>
            <td><div class="failBtn">Fail</div></td>
            <td>${failCase.duration!}</td>
            <td>${failCase.throwable!}</td>
        </tr>
    </#list>
    <#list pass as passCase>
        <tr>
            <#assign caseNo=caseNo+1>
            <td>${caseNo}</td>
            <td>${passCase.className}</td>
            <td>${passCase.testName}</td>
            <td>${passCase.description!}</td>
            <td><div class="successBtn">Success</div></td>
            <td>${passCase.duration!}</td>
            <td>${passCase.throwable!}</td>
        </tr>
    </#list>


</table>



<br/><br/>



</body>
</html>