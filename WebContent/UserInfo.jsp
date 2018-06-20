<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>

<head>

    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">


    <title>首页</title>

    <link rel="shortcut icon" href="favicon.ico"> <link href="css/bootstrap.min14ed.css?v=3.3.6" rel="stylesheet">
    <link href="css/font-awesome.min93e3.css?v=4.4.0" rel="stylesheet">
    <link href="css/animate.min.css" rel="stylesheet">
    <link href="css/style.min862f.css?v=4.1.0" rel="stylesheet">
     <!-- jqgrid-->
    <link href="css/plugins/jqgrid/ui.jqgridffe4.css?0820" rel="stylesheet">


</head>

<body class="gray-bg">
    <div class="wrapper wrapper-content animated fadeInRight">
        <!-- 客户管理 -->
        <div class="row">
            <div class="col-lg-12">
                <div class="ibox float-e-margins">
                    <div class="ibox-title">
                        <h5>账号对应信息</h5>
                    </div>
                    <div class="ibox-content">
                        <div class="jqGrid_wrapper">
                            <table id="table_list_2"></table>
                            <div id="pager_list_2"></div>
                        </div>
                    </div>
                </div>
            </div>
        </div>

    </div>

    <script src="js/jquery.min.js?v=2.1.4"></script>
    <script src="js/bootstrap.min.js?v=3.3.6"></script>
    <script src="js/plugins/peity/jquery.peity.min.js"></script>
    <script src="js/plugins/jqgrid/i18n/grid.locale-cnffe4.js?0820"></script>
    <script src="js/plugins/jqgrid/jquery.jqGrid.minffe4.js?0820"></script>

    <script type="text/javascript">
        function InitCustomerManageGrid(parameters) {
           $.jgrid.defaults.styleUI="Bootstrap";
           var mydata=<%=request.getAttribute("data_user")%>;

           $("#table_list_2").jqGrid(
            {  data:mydata,datatype:"local",height:450,autowidth:true,shrinkToFit:true,rowNum:20,rowList:[10,20,30],
                 colNames  : [' ', 'ID','身份证号','SAP账户名', 'SAP账户密码（密文）'],
                colModel  : [
                        {   width         : 80,
                            fixed         : true,
                            sortable      : true,
                            resize        : true,
                            formatter     : 'actions', // show edit buttons and delete buttons
                            formatoptions : {          // formatting
                                keys:true,
                                editformbutton: false,
                                editOptions:    { recreateForm: true  },
                                delOptions:     { recreateForm: true }
                            }
                        },
                        { name:'id',    index:'id',    width:60,  sorttype: "int", editable: false },
                        { name:'customID', index:'customID', width:90,  editable: true },
                        { name:'sapUsername',  index:'sapUsername',  width:150, editable: true},
                        { name:'sapPassword', index:'sapPassword', width:150,  editable: true },

                    ],
                pager:"#pager_list_2",viewrecords:true,caption:"账号对应信息",add:true,edit:true,addtext:"Add",edittext:"Edit",hidegrid:false,editurl:"./EditUserInfoServlet",
            });

           $("#table_list_2").jqGrid("navGrid","#pager_list_2",{edit:true,add:true,del:true,search:true},{height:200,reloadAfterSubmit:true});
           $(window).bind("resize",function(){var width=$(".jqGrid_wrapper").width();$("#table_list_2").setGridWidth(width)}) ;

        };

         $(document).ready(function(){InitCustomerManageGrid();}) ;


    </script>
</body>

</html>