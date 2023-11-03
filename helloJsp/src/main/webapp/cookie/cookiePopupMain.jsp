<%@page import="com.momo.utils.CookieManager"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
    div#popup {
        position: absolute;
        top: 100px;
        left: 50px;
        color: yellow;
        width: 270px;
        height: 100px;
        background-color: gray;
    }
    div#popup > div {
        position: relative;
        background-color: #ffffff;
        top: 0px;
        border: 1px solid gray;
        padding: 10px;
        color: black;
    }
</style>
</head>
<body>
<h2>쿠키를 이용한 팝업창 제어 ver 1.0</h2>
<!-- script 화면(요소)의 동적인 제어 -->
<script>
    // window 객체의 onload 이벤트가 발생하면 실행
    // HTML 요소를 모두 생성된 상태에서 실행
    window.onload = function() {
        // 팝업닫음 쿠키의 값이 'Y'이면, 팝업창을 화면에서 숨김처리
        var popupClose = '<%= CookieManager.readCookie(request, "popupClose") %>';
        if (popupClose !== 'Y') {
            // 요소를 선택 후 화면에서 숨김처리
            var popup = document.querySelector('#popup');
            popup.style.display = 'none';
        }
        
        var closeBtn = document.querySelector('#closeBtn');
        closeBtn.onclick = function() {
            // 체크박스가 체크되어 있으면
            // 체크박스가 선택 되었습니다. 메세지를 출력하시오
            if (document.querySelector('#inactiveToday').checked) {
                // 서버에 요청 방법
                // 1. href: queryString을 이용해서 파라미터에 전달
                // 2. form submit: form 안에 요소들을 가지고 이동
                document.forms['popupForm'].submit();
            }
            
            var popup = document.querySelector('#popup');
            popup.style.display = 'none';
        }
    }