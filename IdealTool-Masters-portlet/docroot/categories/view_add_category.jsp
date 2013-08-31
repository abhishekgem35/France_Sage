<%@include file="/init.jsp" %>

<jsp:useBean id="sageCategoryInfo" type="com.sage.ideatool.model.sageCategory" scope="request" />

<%
String sFormName = null;
String sMode = null;
String sSubmitButtonName = null;
//String sCancelLinkValue = null;
sMode = String.valueOf(request.getAttribute("mode"));

if(sMode.equalsIgnoreCase("edit"))
{
	sFormName = "updateCategoryToDB";
	sSubmitButtonName = "Edit Category";
	//sCancelLinkValue="/country/viewSearchCountriesInfo.jsp";
}
else if(sMode.equalsIgnoreCase("add"))
{
	sFormName = "addCategoryInfoToDB";
	sSubmitButtonName = "Add Category";
	//sCancelLinkValue="/country/view.jsp";
}
else
{
	throw new Exception("Invalid Mode");
}
%>

<portlet:actionURL name="<%= sFormName %>" var="url" />

<aui:form name="<%= sFormName %>" action="<%=url.toString() %>" method="post">

  <aui:fieldset>
 	
 	 <aui:input type="hidden" name="sageCategoryId" value="<%=sageCategoryInfo.getCategoryId() %>" />
 	
	 <liferay-ui:error key="categoryTitle-required" message="categoryTitle-required" />
     <aui:input type="text" name="categoryTitle" value="<%=sageCategoryInfo.getTitle() %>" size="20" />
     
     <liferay-ui:error key="categoryDescription-required" message="categoryDescription-required" />
     <aui:input type="text" name="categoryDescription" value="<%=sageCategoryInfo.getDescription() %>" size="45" />
   	 
  
  <aui:button type="submit" value="<%= sSubmitButtonName %>" name="saveCategory" />
	  <portlet:renderURL var="cancelURL" windowState="maximized">
	  	<portlet:param name="jspPage" value="/masters/view.jsp" />
	  </portlet:renderURL>
  <aui:button type="cancel" value="Cancel" onClick="<%=cancelURL %>"/>
  </aui:fieldset>
</aui:form>




