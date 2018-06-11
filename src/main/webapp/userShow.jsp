<%--
  Created by IntelliJ IDEA.
  User: Mr.K
  Date: 2018/6/11
  Time: 10:54
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Insert title here</title>
    <link rel="stylesheet" type="text/css"
          href="${pageContext.request.contextPath}/jquery-easyui-1.3.3/themes/default/easyui.css">
    <link rel="stylesheet" type="text/css"
          href="${pageContext.request.contextPath}/jquery-easyui-1.3.3/themes/icon.css">
    <script type="text/javascript"
            src="${pageContext.request.contextPath}/jquery-easyui-1.3.3/jquery.min.js"></script>
    <script type="text/javascript"
            src="${pageContext.request.contextPath}/jquery-easyui-1.3.3/jquery.easyui.min.js"></script>
    <script type="text/javascript"
            src="${pageContext.request.contextPath}/jquery-easyui-1.3.3/locale/easyui-lang-zh_CN.js"></script>
</head>

<body>


<table id="dg" title="用户管理" class="easyui-datagrid" fitColumns="true"
       pagination="true" rownumbers="true"
       url="${pageContext.request.contextPath}/stud/datagrid" fit="true"
       toolbar="#tb">

    <thead>
    <tr>
        <th field="cb" checkbox="true" align="center"></th>
        <th field="id" width="50" align="center">id</th>
        <th field="name" width="100" align="center">name</th>
        <th field="age" width="50" align="center">age</th>
        <th field="sex" width="50" align="center">sex</th>
        <th field="addr" width="50" align="center">adr</th>

    </tr>
    </thead>
</table>

<div id="tb">
    <div>
        <a href="javascript:openUserAddDialog()" class="easyui-linkbutton"
           iconCls="icon-add" plain="true">添加</a> <a
            href="javascript:openUserModifyDialog()" class="easyui-linkbutton"
            iconCls="icon-edit" plain="true">修改</a> <a
            href="javascript:deleteUser()" class="easyui-linkbutton"
            iconCls="icon-remove" plain="true">删除</a>
    </div>
    <div>
        &nbsp;用户名：&nbsp;<input type="text" id="s_name" size="20"
                               onkeydown="if(event.keyCode==13) searchUser()"/> <a
            href="javascript:searchUser()" class="easyui-linkbutton"
            iconCls="icon-search" plain="true">搜索</a>
    </div>
</div>


</body>
<script type="text/javascript">
    function searchUser() {
        $("#dg").datagrid('load', {
            "name": $("#s_name").val()
        });
    }
</script>
</html>
