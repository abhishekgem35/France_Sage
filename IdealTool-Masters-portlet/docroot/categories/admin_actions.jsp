<%@page import="com.sage.ideatool.model.sageCategory"%>
<%@include file="/init.jsp" %>

	<% 
		ResultRow row = (ResultRow)request.getAttribute(WebKeys.SEARCH_CONTAINER_RESULT_ROW);
		sageCategory oCategoryInfo = (sageCategory)row.getObject();
		long groupId = themeDisplay.getLayout().getGroupId();
		String name = sageCategory.class.getName();
		String primKey = String.valueOf(oCategoryInfo.getPrimaryKey());
		boolean UPDATE = permissionChecker.hasPermission(groupId, name, null, ActionKeys.UPDATE);
		
		//DevNote:
		UPDATE = true;	
	%>

	<liferay-ui:icon-menu>

	<% 
	if(UPDATE) 
	{
	%>
			<portlet:actionURL name="editCategoryInfo" var="editURL">
				<portlet:param name="resourcePrimKey" value="<%=primKey %>" />
				<portlet:param name="mode" value="edit" />
				<portlet:param name="tabs1" value="Categories" />
			</portlet:actionURL>
			<liferay-ui:icon image="edit" message="Edit" url="<%=editURL.toString() %>" />
			
			<portlet:actionURL name="deleteCategoryInfo" var="deleteURL">
				<portlet:param name="resourcePrimKey" value="<%=primKey %>" />
				<portlet:param name="mode" value="edit" />
				<portlet:param name="tabs1" value="Categories" />
			</portlet:actionURL>
			<liferay-ui:icon image="delete" message="Delete" url="<%=deleteURL.toString() %>" />
	<%
	}
	else{}
	%>

	
		
		
		
	</liferay-ui:icon-menu>