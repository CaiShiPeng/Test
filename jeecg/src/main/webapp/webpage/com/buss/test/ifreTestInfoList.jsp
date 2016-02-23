<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/context/mytags.jsp"%>
<script type="text/javascript">
$(document).ready(function(){
    	if(location.href.indexOf("load=detail")!=-1){
			$(":input").attr("disabled","true");
		}
    });
</script>
<div style="width: auto;height: 300px;overflow-y:auto;overflow-x:auto;">
<table cellpadding="0" cellspacing="1" class="formtable" id="ifreTestInfo_table" >
	<tbody id="add_ifreTestInfo_table" >	
	<c:if test="${fn:length(ifreTestInfoList)  <= 0 }">
			<tr>
					<input name="ifreTestInfoList[0].id" type="hidden"  value="${poVal.id}"/>
					<input name="ifreTestInfoList[0].createName" type="hidden"  value="${poVal.createName}"/>
					<input name="ifreTestInfoList[0].createBy" type="hidden"  value="${poVal.createBy}"/>
					<input name="ifreTestInfoList[0].updateName" type="hidden"  value="${poVal.updateName}"/>
					<input name="ifreTestInfoList[0].updateBy" type="hidden"  value="${poVal.updateBy}"/>
					<input name="ifreTestInfoList[0].sysOrgCode" type="hidden"  value="${poVal.sysOrgCode}"/>
					<input name="ifreTestInfoList[0].sysCompanyCode" type="hidden"  value="${poVal.sysCompanyCode}"/>
					<input name="ifreTestInfoList[0].createDate" type="hidden"  value="${poVal.createDate}"/>
					<input name="ifreTestInfoList[0].updateDate" type="hidden"  value="${poVal.updateDate}"/>
			</tr>
				<tr>
				  <td align="right">
					<label class="Validform_label">
										外键:
									</label>
					</td>
				  <td class="value">
					  	<input name="ifreTestInfoList[0].iId" maxlength="32" 
					  		type="text" class="inputxt" >
					  <label class="Validform_label" style="display: none;">外键</label>
					</td>
				</tr>
	</c:if>
	<c:if test="${fn:length(ifreTestInfoList)  > 0 }">
		<c:forEach items="${ifreTestInfoList}" var="poVal" varStatus="stuts" begin="0" end="0">
			<tr>
					<input name="ifreTestInfoList[0].id" type="hidden" value="${poVal.id}"/>
					<input name="ifreTestInfoList[0].createName" type="hidden" value="${poVal.createName}"/>
					<input name="ifreTestInfoList[0].createBy" type="hidden" value="${poVal.createBy}"/>
					<input name="ifreTestInfoList[0].updateName" type="hidden" value="${poVal.updateName}"/>
					<input name="ifreTestInfoList[0].updateBy" type="hidden" value="${poVal.updateBy}"/>
					<input name="ifreTestInfoList[0].sysOrgCode" type="hidden" value="${poVal.sysOrgCode}"/>
					<input name="ifreTestInfoList[0].sysCompanyCode" type="hidden" value="${poVal.sysCompanyCode}"/>
					<input name="ifreTestInfoList[0].createDate" type="hidden" value="${poVal.createDate}"/>
					<input name="ifreTestInfoList[0].updateDate" type="hidden" value="${poVal.updateDate}"/>
			</tr>
			<tr>
				  <td align="right">
					<label class="Validform_label">
										外键:
									</label>
					</td>
				  <td class="value">
					  	<input name="ifreTestInfoList[0].iId" maxlength="32" 
					  		type="text" class="inputxt"  value="${poVal.iId }">
					  <label class="Validform_label" style="display: none;">外键</label>
					</td>
				</tr>
		</c:forEach>
	</c:if>	
	</tbody>
</table>
</div>