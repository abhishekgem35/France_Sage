<%@page import="com.sage.ideatool.service.sageCategoryLocalServiceUtil"%>
<%@page import="com.sage.ideatool.service.persistence.sageCategoryUtil"%>
<%@page import="com.liferay.portal.kernel.util.OrderByComparator"%>
<%@page import="com.sage.ideatool.model.sageCategory"%>
<%@page import="com.sage.ideatool.portlet.ActionUtil"%>
<%@include file="/init.jsp" %>
 	
 	<portlet:actionURL name="addCategoryInfo" var="addCategoryInfoURL" windowState="maximized">
	 	<portlet:param name="mode" value="add" />
	 	<portlet:param name="tabs1" value="Categories" />
	</portlet:actionURL>
	
	<aui:form action="<%=addCategoryInfoURL  %>" id="<portlet:namespace/>RegisterForm" method="post">
	    <input type="submit" value="Add Category" name="RegisterButton" />
	</aui:form>
<BR>	

<% 
	PortletURL categoryURL = renderResponse.createRenderURL();
	categoryURL.setParameter("tabs1", "Categories");
	categoryURL.setWindowState(WindowState.NORMAL);
	
	List<String> headerNames = new ArrayList<String>();
	Map<String, String> orderableHeaders = new HashMap<String, String>();
	headerNames.add("category-id");
	headerNames.add("title");
	headerNames.add("description");
	headerNames.add("create-date");
	headerNames.add("modified-date");

	orderableHeaders.put("category-id", "category-id");
	//orderableHeaders.put("title", "title");
	//orderableHeaders.put("version", "version");
	orderableHeaders.put("create-date", "create-date");
	orderableHeaders.put("modified-date", "modified-date");
			
	SearchContainer categorySearchContainer = new SearchContainer(renderRequest, null, null, SearchContainer.DEFAULT_CUR_PARAM, SearchContainer.DEFAULT_DELTA, categoryURL, headerNames, "no-web-content-were-found");
	
	/* try {

		String orderByCol = ParamUtil.getString(
				renderRequest, "orderByCol");
		String orderByType = ParamUtil.getString(
				renderRequest, "orderByType"); 
		
		 if (Validator.isNotNull(orderByCol) &&
			Validator.isNotNull(orderByType)) {

			preferences.setValue(
				"IdeaToolCategory", "category-order-by-col", orderByCol);
			preferences.setValue(
					"IdeaToolCategory", "category-order-by-type", orderByType);
		}
		else {
			orderByCol = preferences.getValue(
					"IdeaToolCategory", "category-order-by-col", "category-id");
			orderByType = preferences.getValue(
					"IdeaToolCategory", "category-order-by-type", "asc");
		} 

		OrderByComparator orderByComparator =
			CategoryUtil.getCategoryOrderByComparator(orderByCol, orderByType);

		categorySearchContainer.setOrderableHeaders(orderableHeaders);
		categorySearchContainer.setOrderByCol(orderByCol);
		categorySearchContainer.setOrderByType(orderByType);
		categorySearchContainer.setOrderByComparator(orderByComparator); 
	}
	catch (Exception e) {
		e.printStackTrace();
	}  */
	
	
//	List<sageCategory> results = sageCategoryUtil.findAll(categorySearchContainer.getStart(), categorySearchContainer.getEnd(), null); 
	List<sageCategory> categoryResults = sageCategoryLocalServiceUtil.getsageCategories(categorySearchContainer.getStart(), categorySearchContainer.getEnd());
	categorySearchContainer.setResults(categoryResults);
	categorySearchContainer.setTotal(sageCategoryLocalServiceUtil.getsageCategoriesCount());
	List resultRows = categorySearchContainer.getResultRows();

	for (int i = 0; i < categoryResults.size(); i++) {
		sageCategory assetCategory = categoryResults.get(i);

		assetCategory = assetCategory.toEscapedModel();

		ResultRow row = new ResultRow(assetCategory, assetCategory.getCategoryId(), i);

		/* PortletURL rowURL = renderResponse.createRenderURL();

		rowURL.setParameter("struts_action", "/journal/edit_structure");
		rowURL.setParameter("redirect", currentURL);
		rowURL.setParameter("groupId", String.valueOf(structure.getGroupId()));
		rowURL.setParameter("structureId", structure.getStructureId()); */

		// Article id

		row.addText(Long.toString(assetCategory.getCategoryId()));

		// Title

		row.addText(assetCategory.getTitle());

		// Description

		row.addText(assetCategory.getDescription() );

		// Created date

		row.addText(assetCategory.getCreateDate().toString());
		
		// Modified date

		row.addText(assetCategory.getModifiedDate().toString());

		// Action

		row.addJSP("right", SearchEntry.DEFAULT_VALIGN, "/categories/admin_actions.jsp");
		resultRows.add(row);
	}
	%>

	<liferay-ui:search-iterator   searchContainer="<%= categorySearchContainer %>" />
	













