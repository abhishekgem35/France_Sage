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

package com.sage.ideatool.model.impl;

import com.liferay.portal.kernel.exception.SystemException;

import com.sage.ideatool.model.sageCategory;
import com.sage.ideatool.service.sageCategoryLocalServiceUtil;

/**
 * The extended model base implementation for the sageCategory service. Represents a row in the &quot;sage_sageCategory&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This class exists only as a container for the default extended model level methods generated by ServiceBuilder. Helper methods and all application logic should be put in {@link sageCategoryImpl}.
 * </p>
 *
 * @author 009
 * @see sageCategoryImpl
 * @see com.sage.ideatool.model.sageCategory
 * @generated
 */
public abstract class sageCategoryBaseImpl extends sageCategoryModelImpl
	implements sageCategory {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. All methods that expect a sage category model instance should use the {@link sageCategory} interface instead.
	 */
	public void persist() throws SystemException {
		if (this.isNew()) {
			sageCategoryLocalServiceUtil.addsageCategory(this);
		}
		else {
			sageCategoryLocalServiceUtil.updatesageCategory(this);
		}
	}
}