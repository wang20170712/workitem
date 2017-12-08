<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta charset="utf-8">
<meta name="renderer" content="webkit|ie-comp|ie-stand">
<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
<meta name="viewport" content="width=device-width,initial-scale=1,minimum-scale=1.0,maximum-scale=1.0,user-scalable=no" />
<meta http-equiv="Cache-Control" content="no-siteapp" />
<!--[if lt IE 9]>
<script type="text/javascript" src="lib/html5shiv.js"></script>
<script type="text/javascript" src="lib/respond.min.js"></script>
<![endif]-->
<link href="static/h-ui/css/H-ui.min.css" rel="stylesheet" type="text/css" />
<link href="static/h-ui.admin/css/H-ui.login.css" rel="stylesheet" type="text/css" />
<link href="static/h-ui.admin/css/style.css" rel="stylesheet" type="text/css" />
<link href="lib/Hui-iconfont/1.0.8/iconfont.css" rel="stylesheet" type="text/css" />
<!--[if IE 6]>
<script type="text/javascript" src="lib/DD_belatedPNG_0.0.8a-min.js" ></script>
<script>DD_belatedPNG.fix('*');</script>
<![endif]-->
<title>后台登录</title>
<meta name="keywords" content="H-ui.admin v3.1,H-ui网站后台模版,后台模版下载,后台管理系统模版,HTML后台模版下载">
<meta name="description" content="H-ui.admin v3.1，是一款由国人开发的轻量级扁平化网站后台模板，完全免费开源的网站后台管理系统模版，适合中小型CMS后台系统。">
  <script type="text/javascript" src="lib/jquery/1.9.1/jquery.min.js"></script>
  <script type="text/javascript" src="static/h-ui/js/H-ui.min.js"></script>
  <script type="text/javascript">
      $(function () {
          if ($.cookie("rmbPassword") == "true") {
              $("#online").attr("checked", true);
              $("#userName").val($.cookie("username"));
              $("#password").val($.cookie("passWord"));
          }
          $("#login_action").click(function () {
              if($("#userName").val() == null || $("#userName").val() == ""){
                  alert("邮箱不能为空");
                  return false;
              }
              if($("#password").val() == null || $("#password").val() == ""){
                  alert("密码不能为空");
                  return false;
              }
              if($("#vcode").val() == null || $("#vcode").val() == ""){
                  alert("验证码不能为空");
                  return false;
              }
              $.ajax({
                  type:"post",
                  url:"/toIndex",
                  dataType:"json",
                  data:{
                      userName:$("#userName").val(),
                      password:$("#password").val(),
                      vcode:$("#vcode").val()
                  },
                  success:function (json) {
                     if(json.resultMsg == "00"){
                         if ($("#online").is(':checked')) {
                             var str_username = $("#userName").val();
                             var str_password = $("#password").val();
                             $.cookie("rmbPassword", "true", { expires: 7 }); //存储一个带7天期限的cookie
                             $.cookie("username", str_username, { expires: 7 });
                             $.cookie("passWord", str_password, { expires: 7 });
                         }
                         else {
                             $.cookie("rmbPassword", "false", { expire: -1 });
                             $.cookie("username", "", { expires: -1 });
                             $.cookie("passWord", "", { expires: -1 });
                         }
                          setTimeout("window.location.href='/main'",1000);
                      }else if(json.resultMsg == "99"){
                          alert("邮箱或密码不正确")
                      }else if(json.resultMsg == "01"){
                          alert("邮箱不存在");
                      }else if (json.resultMsg = "VERIFY_CODE_ERROR"){
                         alert("验证码错误");
                      }else {
                         alert("未知异常");
                     }
                  }
              });
          });
      });


      //点击图片刷新验证码
      function vcodeclick() {
          //$("#vcode").select();
          $("#vimg").attr("src", "${ctx}/getVcode?random=" + Math.random());
      }
  </script>
</head>
<body>
<input type="hidden" id="TenantId" name="TenantId" value="" />
<div class="header"></div>
<div class="loginWraper">
  <div id="loginform" class="loginBox">
    <form class="form form-horizontal"  method="post" id="formId">
      <div class="row cl">
        <label class="form-label col-xs-3"><i class="Hui-iconfont">&#xe60d;</i></label>
        <div class="formControls col-xs-8">
          <input id="userName" name="userName" type="text" placeholder="邮箱" class="input-text size-L">
        </div>
      </div>
      <div class="row cl">
        <label class="form-label col-xs-3"><i class="Hui-iconfont">&#xe60e;</i></label>
        <div class="formControls col-xs-8">
          <input id="password" name="password" type="password" placeholder="密码" class="input-text size-L">
        </div>
      </div>
      <div class="row cl">
        <div class="formControls col-xs-8 col-xs-offset-3">
          <input id="vcode" class="input-text size-L" type="text" placeholder="验证码" onblur="if(this.value==''){this.value='验证码:'}" onclick="if(this.value=='验证码:'){this.value='';}" value="验证码:" style="width:150px;">
          <img  id="vimg" src="/getVcode" onclick="vcodeclick()"> <a id="kanbuq" href="javascript:vcodeclick()">换一张</a> </div>
      </div>
      <div class="row cl">
        <div class="formControls col-xs-8 col-xs-offset-3">
          <label for="online">
            <input type="checkbox" name="online" id="online" value="">
            记住密码</label>
        </div>
      </div>
      <div class="row cl">
        <div class="formControls col-xs-8 col-xs-offset-3">
          <input  id="login_action" name="" type="button" class="btn btn-success radius size-L" value="&nbsp;登&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;录&nbsp;">
          <input  id="register" name="" type="button" class="btn btn-success radius size-L" value="&nbsp;注&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;册&nbsp;">
        </div>
      </div>
    </form>
  </div>
</div>
<div class="footer">Copyright by 王林</div>
</body>
</html>