<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt"  prefix="fmt"%> 
<%@ include file="../includes/header.jsp" %>

	<div class="row">
   		<div class="col-lg-12">
    	<h1 class="page-header">Members 수정</h1>
    	</div>
    <!-- /.col-lg-12 -->
    </div>
    	<!-- /.row -->
    	<div class="row">
        	<div class="col-lg-12">
            	<div class="panel panel-default">
                	<div class="panel-heading">
                    	Members 수정
                    </div>
                        <!-- /.panel-heading -->
                        <form action="/members/modify" method="post">
                        <input type="hidden" name="pageNum" value="${cri.pageNum}">
                        <input type="hidden" name="amount" value="${cri.amount}">
                        <input type="hidden" name="type" value="${cri.type}">
                        <input type="hidden" name="keyword" value="${cri.keyword}">
                        <div class="panel-body">
                        
                        		<div class="form-group">
                        			<label>일련번호</label>
                        			<input class="form-control" name="mno" value="${members.mno}" readonly>
                        		</div>
                        
                        
                        		<div class="form-group">
                        			<label>이메일</label>
                        			<input class="form-control" name="email" value="${members.email}">
                        		</div>
                        		<div class="form-group">
                        			<label>비밀번호</label>
                        			<input class="form-control" name="pwd" value="${members.pwd}">
                        		</div>
                        		<div class="form-group">
                        			<label>이름</label>
                        			<input class="form-control" name="mname" value="${members.mname}">
                        		</div>
                        		<div class="form-group">
                        			<label>등록일자</label>
                        			<input class="form-control" name="cre_date" value='<fmt:formatDate value="${members.cre_date}" pattern="yyyy-MM-dd"/>' readonly>
                        		</div>
                        		<div class="form-group">
                        			<label>수정일자</label>
                        			<input class="form-control" name="mod_date" value='<fmt:formatDate value="${members.mod_date}" pattern="yyyy-MM-dd"/>' readonly>
                        		</div>
                        		
                        		
                        		<button data-oper="modify" class="btn btn-warning">수정</button>
                        		<button data-oper="remove" class="btn btn-danger">삭제</button>
                        		<button data-oper="list" class="btn btn-info">목록</button>
                        </div>
                        <!-- /.panel-body -->
                        </form>
                    </div>
                    <!-- /.panel -->
                </div>
                <!-- /.col-lg-12 -->
            </div>
            <!-- /.row -->
<script>
	$(document).ready(function(){
		var formObj = $("form");
		
		$("button").on("click", function(e){
			e.preventDefault();
			
			var operation = $(this).data("oper");
			
			console.log(operation);
			
			if(operation === "remove"){
				formObj.attr("action", "/members/remove");	
			}else if(operation === "list"){
				
				formObj.attr("action", "/members/list");
				formObj.attr("method", "get");
				
				var pageNumTag = $("input[name='pageNum']").clone();
				var amountTag = $("input[name='amount']").clone();
				var typeTag = $("input[name='type']").clone();
				var keywordTag = $("input[name='keyword']").clone();
				
				formObj.empty();
				formObj.append(pageNumTag);
				formObj.append(amountTag);
				formObj.append(typeTag);
				formObj.append(keywordTag);
			
			}
			formObj.submit();
		});
	});
</script>
           
<%@ include file="../includes/footer.jsp" %>