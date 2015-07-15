<%-- 
    Document   : index
    Created on : Jul 13, 2015, 12:19:38 PM
    Author     : Sunnatilla
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        
        <link rel="stylesheet" type="text/css" href="css/style.css" />
        <script type="text/javascript" src="js/jquery1.10.min.js"></script>
        <script type="text/javascript" src="js/validation.js"></script>
    </head>
    <body>
        <div id="title">Расчет суммы ежемесячного платежа по указанным условиям кредитования</div>
               
        <form action="Servlet" method="get" >
            <table>
                <tr>
                    <td class="request">CR_SUM</td>
                    <td class="request_form"><input type="text" name="CR_SUM" id="CR_SUM"/><span id="valid_CR_SUM"></span></td>
                </tr>
                <tr>
                    <td class="request">CR_OWN_SUM</td>
                    <td class="request_form"><input type="text" name="CR_OWN_SUM" id="CR_OWN_SUM" /><span id="valid_CR_OWN_SUM"></span></td>
                </tr>
                <tr>
                    <td class="request">CR_MONTHES</td>
                    <td class="request_form"><input type="text" name="CR_MONTHES" id="CR_MONTHES" /><span id="valid_CR_MONTHES"></span></td>
                </tr>
                <tr>
                    <td class="request">CR_FEE_RATE</td>
                    <td class="request_form"><input type="text" name="CR_FEE_RATE" id="CR_FEE_RATE" /><span id="valid_CR_FEE_RATE"></span></td>
                </tr>
                <tr>
                    <td class="request"></td>
                    <td class="request_form"><input type="submit" id="submit" disabled/></td>
                </tr>
            </table>
        </form>
        
        
        
        <table>
            <thead>
                <td class="subtitle">Параметр</td>
                <td class="subtitle">Тип</td>
                <td class="subtitle">Значение</td>
            </thead>
            <tr>
                <td class="request">CR_SUM</td>
                <td class="request">IN</td>
                <td class="response">
                    <% if(request.getParameter("CR_SUM") != null){ %>
                    <%=request.getParameter("CR_SUM") %>
                    <% } %>
                </td>
            </tr>
            <tr>
                <td class="request">CR_OWN_SUM</td>
                <td class="request">IN</td>
                <td class="response">
                    <% if(request.getParameter("CR_OWN_SUM") != null){ %>
                    <%=request.getParameter("CR_OWN_SUM") %>
                    <% } %>
                </td>
            </tr>
            <tr>
                <td class="request">CR_MONTHES</td>
                <td class="request">IN</td>
                <td class="response">
                    <% if(request.getParameter("CR_MONTHES") != null){ %>
                    <%=request.getParameter("CR_MONTHES") %>
                    <% } %>
                </td>
            </tr>
            <tr>
                <td class="request">CR_FEE_RATE</td>
                <td class="request">IN</td>
                <td class="response">
                    <% if(request.getParameter("CR_FEE_RATE") != null){ %>
                    <%=request.getParameter("CR_FEE_RATE") %>
                    <% } %>
                </td>
            </tr>
            <tr>
                <td class="request">CR_OWN_SUM_PERCENT</td>
                <td class="request">OUT</td>
                <td class="response">
                    <% if(request.getAttribute("CR_OWN_SUM_PERCENT") != null){ %>
                    <%=request.getAttribute("CR_OWN_SUM_PERCENT") %>
                    <% } %>
                </td>
            </tr>
            <tr>
                <td class="request">CR_PAYMENT_SUM</td>
                <td class="request">OUT</td>
                <td class="response">
                    <% if(request.getAttribute("CR_PAYMENT_SUM") != null){ %>
                    <%=request.getAttribute("CR_PAYMENT_SUM") %>
                    <% } %>
                </td>
            </tr>
            <tr>
                <td class="request">CR_OVERPAY</td>
                <td class="request">OUT</td>
                <td class="response">
                    <% if(request.getAttribute("CR_OVERPAY") != null){ %>
                    <%=request.getAttribute("CR_OVERPAY") %>
                    <% } %>
                </td>
            </tr>
            <tr>
                <td class="request">OUT_RES</td>
                <td class="request">OUT</td>
                <td class="response">
                    <% if(request.getAttribute("OUT_RES") != null){ %>
                    <%=request.getAttribute("OUT_RES") %>
                    <% } %>
                </td>
            </tr>
        </table>
        
        
    </body>
</html>
