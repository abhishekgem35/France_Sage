<%@page import="com.sage.ideatool.util.IdeaToolContributionsComparator"%>
<%@page import="com.liferay.portal.kernel.util.OrderByComparator"%>
<%@page import="com.liferay.portlet.blogs.model.BlogsStatsUser"%>
<%@page import="com.liferay.portal.theme.ThemeDisplay"%>
<%@page import="com.liferay.portlet.blogs.service.BlogsStatsUserLocalServiceUtil"%>
<%@include file="/init.jsp" %>

<% 
	PortletURL topSubmitterURL = renderResponse.createRenderURL();
	topSubmitterURL.setParameter("tabs1", "Top Submitters");
	topSubmitterURL.setWindowState(WindowState.NORMAL);
	
	List<String> headerNames = new ArrayList<String>();
	Map<String, String> orderableHeaders = new HashMap<String, String>();
	headerNames.add("submitter");
	headerNames.add("contributions");
	
	SearchContainer topSubmitterContainer = new SearchContainer(renderRequest, null, null, SearchContainer.DEFAULT_CUR_PARAM, SearchContainer.DEFAULT_DELTA, topSubmitterURL, headerNames, "no-web-content-were-found");
	
	OrderByComparator orderByComparator = new IdeaToolContributionsComparator(false);
	List<BlogsStatsUser> blogsStatsUserResults = BlogsStatsUserLocalServiceUtil.getGroupStatsUsers(themeDisplay.getScopeGroupId(), topSubmitterContainer.getStart(), topSubmitterContainer.getEnd(),orderByComparator);
	
	topSubmitterContainer.setResults(blogsStatsUserResults);
	topSubmitterContainer.setTotal(BlogsStatsUserLocalServiceUtil.getGroupStatsUsersCount(themeDisplay.getScopeGroupId()));
	
	List resultRows = topSubmitterContainer.getResultRows();
	for (int i = 0; i < blogsStatsUserResults.size(); i++) {
		BlogsStatsUser blogsStatsUser = blogsStatsUserResults.get(i);

		blogsStatsUser = blogsStatsUser.toEscapedModel();

		ResultRow row = new ResultRow(new Object[] {blogsStatsUser.getUserId(), blogsStatsUser}, blogsStatsUser.getStatsUserId(), i);
		
		//Submitter
		row.addJSP("/topSuggestions/user_Submitter_image.jsp");
		
		//Contributions
		row.addText(String.valueOf(blogsStatsUser.getEntryCount()));
		resultRows.add(row);
	}
	
%>

	<liferay-ui:search-iterator   searchContainer="<%= topSubmitterContainer %>" />