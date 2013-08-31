<%@include file="/init.jsp" %>

<%@page import="com.liferay.portal.kernel.dao.search.RowChecker"%>
<%@page import="com.liferay.portal.kernel.dao.search.SearchContainer"%>
<%@page import="com.liferay.portal.kernel.dao.orm.OrderFactoryUtil"%>
<%@page import="com.liferay.portal.kernel.dao.orm.ProjectionFactoryUtil"%>
<%@page import="com.liferay.portal.kernel.dao.orm.PropertyFactoryUtil"%>
<%@page import="com.liferay.portal.kernel.dao.orm.DynamicQuery"%>
<%@page import="com.liferay.portal.kernel.dao.orm.DynamicQueryFactoryUtil"%>
<%@page import="com.liferay.portal.kernel.util.PortalClassLoaderUtil"%>

<%@page import="com.liferay.portlet.blogs.service.BlogsEntryLocalServiceUtil"%>
<%@page import="com.liferay.portlet.blogs.model.BlogsEntry"%>
<%@page import="com.liferay.portlet.ratings.service.RatingsStatsLocalServiceUtil"%>
<%@page import="com.liferay.portlet.ratings.model.RatingsStats"%>

<%@page import="java.util.HashMap"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.Map"%>
<%@page import="javax.portlet.PortletURL"%>
<%@page import="java.util.List"%>

<% 
	
	DynamicQuery blogsEntryQuery = DynamicQueryFactoryUtil.forClass(BlogsEntry.class,"articleParent", PortalClassLoaderUtil.getClassLoader())
	.add(PropertyFactoryUtil.forName("groupId").eq(themeDisplay.getScopeGroupId()))
	.setProjection(ProjectionFactoryUtil.property("entryId"));
	
	DynamicQuery ratingsStatsQuery = DynamicQueryFactoryUtil.forClass(RatingsStats.class, "articleSub", PortalClassLoaderUtil.getClassLoader())
			.add(PropertyFactoryUtil.forName("classPK").in(blogsEntryQuery))
			.addOrder(OrderFactoryUtil.desc("totalEntries"));
	
	DynamicQuery ratingsStatsCountQuery = DynamicQueryFactoryUtil.forClass(RatingsStats.class, "articleSub", PortalClassLoaderUtil.getClassLoader())
			.add(PropertyFactoryUtil.forName("classPK").in(blogsEntryQuery))
			.setProjection(ProjectionFactoryUtil.count("statsId"));
	
	
	PortletURL topSuggetionsURL = renderResponse.createRenderURL();
	topSuggetionsURL.setParameter("tabs1", "Top Suggestions");
	topSuggetionsURL.setWindowState(WindowState.NORMAL);
	
	List<String> headerNames = new ArrayList<String>();
	/* Map<String, String> orderableHeaders = new HashMap<String, String>(); */
	headerNames.add("title");
	headerNames.add("user");
	headerNames.add("votes");
	headerNames.add("create-Date");
	headerNames.add("modified-date");
	
/*	orderableHeaders.put("title", "title");
	orderableHeaders.put("user", "user");
	orderableHeaders.put("votes", "votes");
	orderableHeaders.put("create-Date", "create-Date");
	orderableHeaders.put("modified-date", "modified-date"); */
	
	SearchContainer topSuggetionsSearchContainer = new SearchContainer(renderRequest, null, null, SearchContainer.DEFAULT_CUR_PARAM, 5, topSuggetionsURL, headerNames, "no-web-content-were-found");
	
	List<RatingsStats> results = RatingsStatsLocalServiceUtil.dynamicQuery(ratingsStatsQuery,topSuggetionsSearchContainer.getStart(), topSuggetionsSearchContainer.getEnd());
	topSuggetionsSearchContainer.setResults(results);
	String count =  String.valueOf(RatingsStatsLocalServiceUtil.dynamicQuery(ratingsStatsCountQuery).get(0));
	topSuggetionsSearchContainer.setTotal(Integer.parseInt(count));
	
	List resultRows = topSuggetionsSearchContainer.getResultRows();
	for (int i = 0; i < results.size(); i++) {
		RatingsStats ratingsStats = results.get(i);
		ratingsStats =ratingsStats.toEscapedModel();
		BlogsEntry blogsEntry = BlogsEntryLocalServiceUtil.getBlogsEntry(ratingsStats.getClassPK()).toEscapedModel();

		/* ResultRow blogrow = new ResultRow(ratingsStats, ratingsStats.getClassPK(), i); */
		ResultRow row = new ResultRow(new Object[] {blogsEntry.getUserId(), ratingsStats}, blogsEntry.getEntryId(), i); 
				
		// Title
		row.addText(String.valueOf(blogsEntry.getTitle()));
		
		//User
		//row.addJSP("/html/portlet/recent_bloggers/user_Submitter_image.jsp");
		row.addJSP("/topSuggestions/user_Submitter_image.jsp");
		
		//Votes
		row.addText(String.valueOf(ratingsStats.getTotalEntries()));
	
		// Created date

		row.addText(blogsEntry.getCreateDate().toString());
			
		// Modified date

		row.addText(blogsEntry.getModifiedDate().toString());
		
		resultRows.add(row);
	}
	
	%>
	<liferay-ui:search-iterator searchContainer="<%= topSuggetionsSearchContainer %>" />
	
	