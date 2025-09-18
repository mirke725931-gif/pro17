<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    import = "java.util.*, sec01.practice.*"
    isELIgnored="false"
%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"  %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
    request.setCharacterEncoding("UTF-8");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>공지사항</title>
<Style>
    .cls1{
      font-size: 40px;
      text-align: center;
      }
    .cls2{
      font-size: 20px;
      text-align: center;
      }
</Style>
</head>
<body>
   <p class="cls1">공지사항</p>
   <table align="center" border="1">
      <tr align="center" bgcolor="lightgreen">
        <td width="7%"><b>No</b></td>
        <td width="7%"><b>제목</b></td>
        <td width="7%"><b>게시일</b></td>
      </tr>
      
      <c:choose>
        <c:when test="${empty noticeList}">
          <tr>
            <td colspan="5">
              <b>등록된 공지사항이 없습니다.</b>
            </td>
          </tr>
         </c:when>
         <c:when test="${!empty noticeList}">
           <c:forEach var="noti" items="${noticeList}">
             <tr align = "center">
               <td>${noti.id}</td>
               <td>${noti.title}</td>
               <td>${noti.date}</td>
             </tr>
           </c:forEach>
         </c:when>
       </c:choose>
     </table>
     <a href="${contextPath}/pro17/member/memberForm.do">
       <p class="cls2">공지등록하기</p>
     </a>
</body>
</html>