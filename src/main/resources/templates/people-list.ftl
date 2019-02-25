<!doctype html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <meta name="description" content="">
    <meta name="author" content="">
    <link rel="icon" href="img/favicon.ico">

    <title>People list</title>
    <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.0.13/css/all.css"
          integrity="sha384-DNOHZ68U8hZfKXOrtjWvjxusGo9WQnrNx2sqG0tfsghAvtVlRW3tvkXWZh58N9jp" crossorigin="anonymous">
    <!-- Bootstrap core CSS -->
    <#include "css/bootstrap.min.css">
    <!-- Custom styles for this template -->
    <#include "css/style.css">
</head>
<body>

<div class="container">
    <div class="row">
        <div class="col-8 offset-2">
            <div class="panel panel-default user_panel">
                <div class="panel-heading">
                    <h3 class="panel-title">Liked users</h3>
                </div>
                <div class="panel-body">
                    <div class="table-container">
                        <table class="table-users table" border="0">
                            <tbody>
                            <#list users as user>
                            <tr>
                                <td width="10">
                                    <div class="avatar-img">
                                        <img alt="no img" class="img-circle"
                                             src="${user.imgUrl}"/>  
                                    </div>

                                </td>
                                <td class="align-middle">
                                    ${user.name} ${user.surname}
                                </td>
                                <td class="align-middle">
                                    You liked this user
                                </td>
                                <td class="align-middle">
                                <#--Last Login:  6/10/2017<br><small class="text-muted">5 days ago</small>-->
                                    <form action="/message" method="get">
                                        <input type="hidden" name="user" value="${user.id}">
                                        <button style="cursor: pointer" type="submit">Send message</button>
                                    </form>
                                </td>
                            </tr>
                            </#list>
                            </tbody>
                        </table>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>

<#if messages == 1>
<div class="container chat-container" id="1">
    <div class="row">
        <div class="chat-main col-6 offset-3">
            <div class="col-md-12 chat-header">
                <div class="row header-one text-white p-1">
                    <#--name-->
                    <div class="col-md-6 name pl-2">
                        <i class="fa fa-comment"></i>
                        <h6 class="ml-1 mb-0">${counterpart.name} ${counterpart.surname}</h6>
                    </div>
                        <#--cross-->
                    <div class="col-md-6 options text-right pr-0">
                        <i onclick="document.getElementById('1').classList.toggle('hide');
" class="fa fa-times hover text-center pt-1"></i>
                    </div>
                </div>
                <div class="row header-two w-100">
                    <div class="col-md-6 options-left pl-1">

                    </div>
                    <div class="col-md-6 options-right text-right pr-2">
                        <i class="fa"></i>
                    </div>
                </div>
            </div>
            <div class="chat-content">
                <div class="col-md-12 chats pt-3 pl-2 pr-3 pb-3">
                    <ul class="p-0">
                        <#--send message-->
                            <#list messageList as message>
                            <#if message.status == "sent">
                        <li class="send-msg float-right mb-2">
                            <p class="pt-1 pb-1 pl-2 pr-2 m-0 rounded">
                                ${message.text}
                            </p>
                            <span class="send-msg-time">${message.time}</span>
                        </li>
                            <#--receive message-->
                            <#else>
                        <li class="receive-msg float-left mb-2">
                            <div class="sender-img">
                                <img src="${counterpart.imgUrl}" alt="photo" class="float-left">
                            </div>
                            <div class="receive-msg-desc float-left ml-2">
                                <p class="bg-white m-0 pt-1 pb-1 pl-2 pr-2 rounded">
                                    ${message.text}
                                </p>
                                <span class="receive-msg-time">${counterpart.name}, ${message.time}</span>
                            </div>
                        </li>
                            </#if>
                            </#list>
                    </ul>
                </div>
                <div style="position: relative" class="col-md-12 p-2 msg-box border border-primary">
                    <div class="row">
                        <div class="col-md-1 options-left">
                            <i class="fa fa-smile-o"></i>
                        </div>
                        <#--text-->
                        <form action="/message" method="post" class="col-md-11 pl-0">
                            <input name="text" style="width: 80%;" type="text" class="border-0" placeholder=" Send message"/>
                            <input name="user" type="hidden" value="${counterpart.id}">
                            <button style="cursor: pointer; position: absolute; right: 10px; top: 0; " type="submit">Send</button>
                        </form>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>
</#if>
</body>
</html>