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

import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.model.CacheModel;

import com.sage.ideatool.model.sageCategory;

import java.io.Serializable;

import java.util.Date;

/**
 * The cache model class for representing sageCategory in entity cache.
 *
 * @author 009
 * @see sageCategory
 * @generated
 */
public class sageCategoryCacheModel implements CacheModel<sageCategory>,
	Serializable {
	@Override
	public String toString() {
		StringBundler sb = new StringBundler(19);

		sb.append("{categoryId=");
		sb.append(categoryId);
		sb.append(", companyId=");
		sb.append(companyId);
		sb.append(", groupId=");
		sb.append(groupId);
		sb.append(", userId=");
		sb.append(userId);
		sb.append(", userName=");
		sb.append(userName);
		sb.append(", createDate=");
		sb.append(createDate);
		sb.append(", modifiedDate=");
		sb.append(modifiedDate);
		sb.append(", title=");
		sb.append(title);
		sb.append(", description=");
		sb.append(description);
		sb.append("}");

		return sb.toString();
	}

	public sageCategory toEntityModel() {
		sageCategoryImpl sageCategoryImpl = new sageCategoryImpl();

		sageCategoryImpl.setCategoryId(categoryId);
		sageCategoryImpl.setCompanyId(companyId);
		sageCategoryImpl.setGroupId(groupId);
		sageCategoryImpl.setUserId(userId);

		if (userName == null) {
			sageCategoryImpl.setUserName(StringPool.BLANK);
		}
		else {
			sageCategoryImpl.setUserName(userName);
		}

		if (createDate == Long.MIN_VALUE) {
			sageCategoryImpl.setCreateDate(null);
		}
		else {
			sageCategoryImpl.setCreateDate(new Date(createDate));
		}

		if (modifiedDate == Long.MIN_VALUE) {
			sageCategoryImpl.setModifiedDate(null);
		}
		else {
			sageCategoryImpl.setModifiedDate(new Date(modifiedDate));
		}

		if (title == null) {
			sageCategoryImpl.setTitle(StringPool.BLANK);
		}
		else {
			sageCategoryImpl.setTitle(title);
		}

		if (description == null) {
			sageCategoryImpl.setDescription(StringPool.BLANK);
		}
		else {
			sageCategoryImpl.setDescription(description);
		}

		sageCategoryImpl.resetOriginalValues();

		return sageCategoryImpl;
	}

	public long categoryId;
	public long companyId;
	public long groupId;
	public long userId;
	public String userName;
	public long createDate;
	public long modifiedDate;
	public String title;
	public String description;
}