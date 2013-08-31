package com.sage.ideatool.util;

import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portlet.journal.util.comparator.ArticleCreateDateComparator;
import com.liferay.portlet.journal.util.comparator.ArticleDisplayDateComparator;
import com.liferay.portlet.journal.util.comparator.ArticleIDComparator;
import com.liferay.portlet.journal.util.comparator.ArticleModifiedDateComparator;
import com.liferay.portlet.journal.util.comparator.ArticleReviewDateComparator;
import com.liferay.portlet.journal.util.comparator.ArticleTitleComparator;
import com.liferay.portlet.journal.util.comparator.ArticleVersionComparator;

public class IdeaToolCategoryUtil {
	
	public static OrderByComparator getCategoryOrderByComparator(
			String orderByCol, String orderByType) {

			boolean orderByAsc = false;

			if (orderByType.equals("asc")) {
				orderByAsc = true;
			}

			OrderByComparator orderByComparator = null;

			if (orderByCol.equals("create-date")) {
				orderByComparator = new IdeaToolCategoryCreateDateComparator(orderByAsc,"createDate");
			}
			else if (orderByCol.equals("modified-date")) {
				orderByComparator = new IdeaToolCategoryCreateDateComparator(orderByAsc,"modifiedDate");
			}
			else if (orderByCol.equals("category-id")) {
				orderByComparator = new IdeaToolCategoryIDComparator(orderByAsc);
			}

			return orderByComparator;
		}

}
