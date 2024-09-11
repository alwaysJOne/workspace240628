<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>* EL(Expression language)</h1>

    <p>
        기존에 사용했던 표현식(출력식) &lt;%=name%&gt;와 같이 <br>
        JSP상에서 표현하고자하는 값을 ${name}의 형식으로 표현해서 작성하는 것
    </p>

    <h4><a href="el.do">01_EL의 기본구문</a></h4>
    <h4><a href="operation.do">02_EL의 연산자</a></h4>

    <h1>JSP Action Tag</h1>
    <%--
        *JSP를 이루는 구성
        1. 스크립팅원소 : jsp페이지내에서 자바코드를 직접기술할 수 있게 하는 기술
            ex) 스크립틀릿, 표현식...

        2. 지시어 : JSP페이지 정보에 대한 내용을 표현한다거나 또 다른페이지를 포함할 때 사용
                    JSP 기능을 확장시키는 라이브러리를 등록할 때 사용
        
        3. 액션태그 : jsp페이지에서 어떤 동작을 하도록 지시하는 태그
                     xml기술을 이용하여 기존의 jsp문법을 확장하는 기술을 제공하는 태그

            >>표준 액션 태그(Standard Action Tag) : jsp페이지에서 바로 사용가능(별로도 연동 필요 없음)
                -> 모든 태그명 앞에 jsp: 접두어를 붙여서 사용 <jsp: 태그명>
            >>커스텀 액션 태그(Custom Action Tag) : jsp페이지에서 바로 사용 불가능(별도에 라이브러리 연동 필요)
                -> 접두어에 jsp:가 있는 모든태그를 제외한 모든태그
                    가장 많이사용하는 대표적인 라이브러리가 jstl
    --%>

    <h3>* 표준액션태그</h3>
    <a href="views/2_Standard_Action_Tag/01_include.jsp">01_jsp:include</a><br>
    <a href="views/2_Standard_Action_Tag/02_forward.jsp">02_jsp:forward</a><br>
    
    <h1>JSTL이란? </h1>
    <p>
    	JSP에서 사용되는 커스텀액션태그로 <br>
    	공통적으로 자주 사용되는 코드들을 집합아여 보다 쉽게 사용할 수 있도록 태그화하여 표준으로 제공하는 라이브러리
    </p>
    
    <h3>라이브러리 추가</h3>
    1) 톰캣사이트 접속<br>
    2) 메뉴바 Taglibs 메뉴로 이동<br>
    3) 4개의 .jar전부 다운로드<br>
    4) WEB-INF/lib/() 추가<br>
    
    <h3> JSTL 선언방법 </h3>
    <p>
    	JSTL을 사용하고자하는 해당 JSP페이지 상단에 <br>
    	taglib 지시어를 사용해서 선언함<br><br>
    	
    	&lt;%@ taglib prefix="접두어" uri="라이브러리 파일상의 uri주소" %&gt;
    </p>
    
    <h3>* Custom Action Tag</h3>
    <h4>1. JSTL Core Library</h4>
    <p>변수와 조건문, 반복문등 로직과 관련된 문법을 제공한다.</p>
    <a href="views/3_Custom_Action_Tag/01_core.jsp">01_core</a>
</body>
</html>





