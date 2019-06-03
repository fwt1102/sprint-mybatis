// 左边菜单栏
$(function () {
    var ul = $("#ul");
    var urStr="";
    var ul2Str=""
    var ulId="";
    $.ajax({
        type :'post',
        url : "SelectUserRoleMenuById",
        contentType :"application/json;charset=utf-8",
        success : function(data){
            $(data).each(function (index, item) {
                if (item.pid==0){

                    //赋值给子ul的id
                    ulId=item.name;

                    urStr=" <li class=\"list-group-item\">" +
                            "<span><i class=\"glyphicon glyphicon-ok\"></i>"+item.name+" <span class=\"badge\" style=\"float:right\">"+item.children.length+"</span></span>" +
                            "<ul style=\"margin-top:10px;display:none;\" id="+ulId+" >"+"</ul>"+
                            "</li>"
                }
                //添加父菜单
                ul.append(urStr)
                //遍历子菜单
                $(item.children).each(function (index1,item1) {
                    //判断子id与父id
                    if (item.id==item1.pid){

                        ul2Str=	"<li style=\"height:30px;\">"+
                               "<a href="+item1.url+'.html'+"><i class=\"glyphicon glyphicon-lock\"></i> "+item1.name+"</a>"+
                               "</li>"
                        //获取子菜单ul并添加Li
                        var ul2 = $("#"+ulId).append(ul2Str)
                    }
                })
            })
          //菜单开闭
            $(".list-group-item").click(function(){
                // jquery对象的回调方法中的this关键字为DOM对象
                // $(DOM) ==> JQuery
                if ( $(this).find("ul") ) { // 3 li
                    $(this).toggleClass("tree-closed");
                    if ( $(this).hasClass("tree-closed") ) {
                        $("ul", this).hide("fast");
                    } else {
                        $("ul", this).show("fast");
                    }
                }
            });
        },
        dataType :"json"
    });




})