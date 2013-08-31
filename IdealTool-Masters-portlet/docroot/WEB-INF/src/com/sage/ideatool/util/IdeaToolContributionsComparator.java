/**
 * Copyright (c) 2000-2012 Liferay, Inc. All rights reserved.
 *
 * This library is free software; you can redistribute it and/or modify it under
 * the terms of the GNU Lesser General Public License as published by the Free
 * Software Foundation; either version 2.1 of the License, or (at your option)
 * any later version.
 *
 * This library is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
 * FOR A PARTICULAR PURPOSE. See the GNU Lesser General Public License for more
 * details.
 */

package com.sage.ideatool.util;

import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portlet.blogs.model.BlogsStatsUser;

/**
 * @author Brian Wing Shun Chan
 */
public class IdeaToolContributionsComparator extends OrderByComparator {

	public static final String ORDER_BY_ASC = "BlogsStatsUser.entryCount ASC";

	public static final String ORDER_BY_DESC = "BlogsStatsUser.entryCount DESC";

	public static final String[] ORDER_BY_FIELDS = {"entryCount"};

	public IdeaToolContributionsComparator() {
		this(false);
	}

	public IdeaToolContributionsComparator(boolean ascending) {
		_ascending = ascending;
	}

	@Override
	public int compare(Object obj1, Object obj2) {
		BlogsStatsUser blogsStatsUser1 = (BlogsStatsUser)obj1;
		BlogsStatsUser blogsStatsUser2 = (BlogsStatsUser)obj2;

		long entryCount1 = blogsStatsUser1.getEntryCount();
		long entryCount2 = blogsStatsUser2.getEntryCount();

		int value = 0;

		if (entryCount1 < entryCount2) {
			value = -1;
		}
		else if (entryCount1 > entryCount2) {
			value = 1;
		}

		if (_ascending) {
			return value;
		}
		else {
			return -value;
		}
	}

	@Override
	public String getOrderBy() {
		if (_ascending) {
			return ORDER_BY_ASC;
		}
		else {
			return ORDER_BY_DESC;
		}
	}

	@Override
	public String[] getOrderByFields() {
		return ORDER_BY_FIELDS;
	}

	@Override
	public boolean isAscending() {
		return _ascending;
	}

	private boolean _ascending;

}