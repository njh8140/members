<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt"  prefix="fmt"%> 
<%@ include file="../includes/header.jsp" %>

	<div class="row">
   		<div class="col-lg-12">
    	<h1 class="page-header">Members List Page</h1>
    	</div>
    <!-- /.col-lg-12 -->
    </div>
    	<!-- /.row -->
    	<div class="row">
        	<div class="col-lg-12">
            	<div class="panel panel-default">
                	<div class="panel-heading">
                    	Members 목록 (Total : ${pageMaker.total})
                    	<button id="regBtn" type="button" class="btn btn-xs btn-info pull-right">신규 등록</button>
                    </div>
                        <!-- /.panel-heading -->
                        <div class="panel-body">
                        	<table width="100%" class="table table-striped table-bordered table-hover">
                                <thead>
                                    <tr>
                                        <th>일련번호</th>
                                        <th>이메일</th>
                                        <!-- <th>비밀번호</th> -->
                                        <th>이름</th>
                                        <th>등록일자</th>
                                        <th>수정일자</th>
                                    </tr>
                                </thead>
                               	
                               	<c:forEach var="members" items="${list}">
                               		<tr>
	                               		<td><c:out value="${members.mno}"></c:out></td>
	                               		<td><a class="move" href="${members.mno}">${members.email}</a></td>
	                               		<%-- <td>${members.pwd}</td> --%>
	                               		<td>${members.mname}</td>
	                               		<td><fmt:formatDate value="${members.cre_date}" pattern="yyyy-MM-dd"/></td>
	                               		<td><fmt:formatDate value="${members.mod_date}" pattern="yyyy-MM-dd"/></td>
                               		</tr>
                               	</c:forEach>
                               
                            </table>
                            <!-- /.table-responsive -->
                            
                            <div class="row">
                            	<div class="col-lg-12">
                            		<form action="/members/list" id="searchForm" method="get">
                            			<select name="type">
                            				<option value="T" ${pageMaker.cri.type=='T' ? 'selected' : '' }>이름</option>
                            			</select>
                            			<input type="text" name="keyword" value="${pageMaker.cri.keyword}">
                            			<input type="hidden" name="pageNum" value="${pageMaker.cri.pageNum}">
                            			<input type="hidden" name="amount" value="${pageMaker.cri.amount}">
                            			<button class="btn btn-default">검색</button>
                            		</form>
                            	</div>
                            </div>
                            
                            <div class="pull-right">
                            	<ul class="pagination">
                            		<c:if test="${pageMaker.prev}">
                            			<li class="paginate_button previous"><a href="${pageMaker.startPage-1}">Previous</a></li>
                            		</c:if>
                            		<c:forEach var="num" begin="${pageMaker.startPage}" end="${pageMaker.endPage}">
                            			<li class="paginate_button button ${pageMaker.cri.pageNum == num ? 'active' : ''}"><a href="${num}">${num}</a></li>
                            		</c:forEach>
                            		
                            		<c:if test="${pageMaker.next}">
                            			<li class="paginate_button next"><a href="${pageMaker.endPage+1}">Next</a></li>
                            		</c:if>
                            	</ul>
                            </div>
                            
                            <form action="" id="actionForm" method="get">
                            	<input type="hidden" name="pageNum" value="${pageMaker.cri.pageNum}">
                            	<input type="hidden" name="amount" value="${pageMaker.cri.amount}">
                            	<input type="hidden" name="type" value="${pageMaker.cri.type}">
                            	<input type="hidden" name="keyword" value="${pageMaker.cri.keyword}">
                            </form>
                            
                            <!-- Modal  추가 -->
							<div class="modal fade" id="myModal" tabindex="-1" role="dialog"
								aria-labelledby="myModalLabel" aria-hidden="true">
								<div class="modal-dialog">
									<div class="modal-content">
										<div class="modal-header">
											<button type="button" class="close" data-dismiss="modal"
												aria-hidden="true">&times;</button>
											<h4 class="modal-title" id="myModalLabel">Modal title</h4>
										</div>
										<div class="modal-body">처리가 완료되었습니다.</div>
										<div class="modal-footer">
											<button type="button" class="btn btn-default"
												data-dismiss="modal">Close</button>
											<button type="button" class="btn btn-primary" data-dismiss="modal">Save
												changes</button>
										</div>
									</div>
									<!-- /.modal-content -->
								</div>
								<!-- /.modal-dialog -->
							</div>
							<!-- /.modal -->
                            
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
		
		var result = '<c:out value="${result}"/>';
		console.log(result);
		
		checkModal(result);
		
		$("#regBtn").on("click", function() {
			self.location = "/members/register";
		});
		
		var actionForm = $("#actionForm");
		
		$(".paginate_button a").on("click", function(e){
			e.preventDefault();
			actionForm.find("input[name='pageNum']").val($(this).attr("href"));
			actionForm.attr("action", "/members/list");
			actionForm.submit();
			
		});
		
		$(".move").on("click", function(e){
			e.preventDefault();
			actionForm.append("<input type='text' name='mno' value='" + $(this).attr("href") + "'>");
			actionForm.attr("action", "/members/get");
			actionForm.submit();
		});
		
		function checkModal(result){
			if(result === ''){
				return;
			}
			if(parseInt(result)>0){
				$(".modal-body").html("Members " + parseInt(result) + "번 등록");
			}
			$("#myModal").modal("show");
		}
		
	});
</script>
           
<%@ include file="../includes/footer.jsp" %>