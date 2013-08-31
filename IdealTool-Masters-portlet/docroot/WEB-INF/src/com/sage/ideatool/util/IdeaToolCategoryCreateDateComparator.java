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

import com.liferay.portal.kernel.util.DateUtil;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.sage.ideatool.model.sageCategory;

/**
 * @author Brian Wing Shun Chan
 */
public class IdeaToolCategoryCreateDateComparator extends OrderByComparator {

	public final String ORDER_BY_ASC ;

	public final String ORDER_BY_DESC;

	public final String[] ORDER_BY_FIELDS = new String[1];

	/*public CategoryCreateDateComparator() {
		this(false,);
	}*/

	public IdeaToolCategoryCreateDateComparator(boolean ascending,String dateColumn) {
		_ascending = ascending;
		ORDER_BY_ASC = "sageCategory."+dateColumn+" ASC";
		ORDER_BY_DESC = "sageCategory."+dateColumn+" DESC";
		ORDER_BY_FIELDS[0] = dateColumn;
	}

	@Override
	public int compare(Object obj1, Object obj2) {
		sageCategory article1 = (sageCategory)obj1;
		sageCategory article2 = (sageCategory)obj2;

		int value = DateUtil.compareTo(
			article1.getCreateDate(), article2.getCreateDate());

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