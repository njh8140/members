<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt"  prefix="fmt"%> 
<%@ include file="../includes/header.jsp" %>

	<div class="row">
   		<div class="col-lg-12">
    	<h1 class="page-header">신규 등록</h1>
    	</div>
    <!-- /.col-lg-12 -->
    </div>
    	<!-- /.row -->
    	<div class="row">
        	<div class="col-lg-12">
            	<div class="panel panel-default">
                	<div class="panel-heading">
                    	Members 등록
                    </div>
                        <!-- /.panel-heading -->
                        <div class="panel-body">
                        	<form action="/members/register" method="post">
                        		<div class="form-group">
                        			<label>이메일</label>
                        			<input class="form-control" name="email">
                        		</div>
                        		<div class="form-group">
                        			<label>비밀번호</label>
                        			<input class="form-control" name="pwd">
                        		</div>
                        		<div class="form-group">
                        			<label>이름</label>
                        			<input class="form-control" name="mname">
                        		</div>
                        		<button type="submit" class="btn btn-default">신규 등록</button>
                        		<button type="reset" class="btn btn-default">취소</button>
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
		
		$("#regBtn").on("click", function() {
			self.location = "/members/register";
		});
	});
</script>
           
<%@ include file="../includes/footer.jsp" %>