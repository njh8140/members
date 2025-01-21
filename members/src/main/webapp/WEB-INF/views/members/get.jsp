<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt"  prefix="fmt"%> 
<%@ include file="../includes/header.jsp" %>

	<div class="row">
   		<div class="col-lg-12">
    	<h1 class="page-header">Members 조회</h1>
    	</div>
    <!-- /.col-lg-12 -->
    </div>
    	<!-- /.row -->
    	<div class="row">
        	<div class="col-lg-12">
            	<div class="panel panel-default">
                	<div class="panel-heading">
                    	Members 조회
                    </div>
                        <!-- /.panel-heading -->
                        <div class="panel-body">
                        
                        		<div class="form-group">
                        			<label>일련번호</label>
                        			<input class="form-control" name="mno" value="${members.mno}" readonly>
                        		</div>
                        
                        
                        		<div class="form-group">
                        			<label>이메일</label>
                        			<input class="form-control" name="email" value="${members.email}" readonly>
                        		</div>
                        		<div class="form-group">
                        			<label>비밀번호</label>
                        			<textarea class="form-control" name="pwd" rows="3" readonly>${members.pwd}</textarea>
                        		</div>
                        		<div class="form-group">
                        			<label>이름</label>
                        			<input class="form-control" name="mname" value="${members.mname}" readonly>
                        		</div>
                        		<button data-oper="modify" class="btn btn-warning">수정</button>
                        		<button data-oper="list" class="btn btn-info">목록</button>
                        		
                        		<form action="/members/modify" id="operForm" method="get">
                        			<input type="hidden" id="mno" name="mno" value="${members.mno}">
                        			<input type="hidden" name="pageNum" value="1">
                        			<input type="hidden" name="amount" value="${cri.amount}">
                        			<input type="hidden" name="type" value="${cri.type}">
                        			<input type="hidden" name="keyword" value="${cri.keyword}">
                        		</form>
                        </div>
                        <!-- /.panel-body -->
                    </div>
                    <!-- /.panel -->
                </div>
                <!-- /.col-lg-12 -->
            </div>
            <!-- /.row -->
<script>
	$(document).ready(function(){
		var operForm = $("#operForm")
		
		$("button[data-oper='modify']").on("click", function(e){
			operForm.attr("action", "/members/modify").submit();
		});
		
		$("button[data-oper='list']").on("click", function(e){
			operForm.find("#mno").remove();
			operForm.attr("action", "/members/list");
			operForm.submit();
		});
	});
</script>
           
<%@ include file="../includes/footer.jsp" %>