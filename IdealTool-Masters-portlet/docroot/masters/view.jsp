<%@include file="/init.jsp" %>
<%@page import="com.liferay.portal.util.PortalUtil"%>

<%
String tabNames = "Suggestions,Top Suggestions,Top Submitters,Categories";
String[] tabs1NamesArray = StringUtil.split(tabNames);
String tabs2 = ParamUtil.getString(request, "tabs1");
String displayNext = ParamUtil.getString(request, "displayNext");
String tabs1 = ParamUtil.getString(request, "tabs1", "Suggestions");

PortletURL portletURL = renderResponse.createRenderURL();
portletURL.setParameter("tabs1", tabs1);

portletURL.setWindowState(WindowState.NORMAL);

%>

<liferay-ui:tabs
   names="<%= tabNames %>"
   url="<%= portletURL.toString() %>"
/>



<c:if test='<%= tabs1.equals("Suggestions") %>'>
  <%@ include file="/suggestions/view.jsp" %>
</c:if>
<c:if test='<%= tabs1.equals("Top Suggestions") %>'>
   <%@ include file="/topSuggestions/view.jsp" %>
</c:if>
<c:if test='<%= tabs1.equals("Top Submitters") %>'>
   <%@ include file="/topSubmitters/view.jsp" %>
</c:if>
<c:if test='<%= tabs1.equals("Categories") %>'>
   <%@ include file="/categories/view.jsp" %>
</c:if>


<%-- 
<liferay-ui:tabs names="<%= tabNames %>" value="<%= tabs1 %>" param="tab"  refresh="<%= false %>">

	<liferay-ui:section>
		<%@ include file="/suggestions/view.jsp" %>
	</liferay-ui:section>
	<liferay-ui:section>
		<%@ include file="/topSuggestions/view.jsp" %>
	</liferay-ui:section>
	<liferay-ui:section>
		<%@ include file="/topSubmitters/view.jsp" %>
	</liferay-ui:section>
	<liferay-ui:section>
		<%@ include file="/categories/view.jsp" %>
	</liferay-ui:section>
</liferay-ui:tabs> --%>
