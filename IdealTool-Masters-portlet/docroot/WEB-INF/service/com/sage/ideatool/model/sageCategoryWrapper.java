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

package com.sage.ideatool.model;

import com.liferay.portal.model.ModelWrapper;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 * This class is a wrapper for {@link sageCategory}.
 * </p>
 *
 * @author    009
 * @see       sageCategory
 * @generated
 */
public class sageCategoryWrapper implements sageCategory,
	ModelWrapper<sageCategory> {
	public sageCategoryWrapper(sageCategory sageCategory) {
		_sageCategory = sageCategory;
	}

	public Class<?> getModelClass() {
		return sageCategory.class;
	}

	public String getModelClassName() {
		return sageCategory.class.getName();
	}

	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("categoryId", getCategoryId());
		attributes.put("companyId", getCompanyId());
		attributes.put("groupId", getGroupId());
		attributes.put("userId", getUserId());
		attributes.put("userName", getUserName());
		attributes.put("createDate", getCreateDate());
		attributes.put("modifiedDate", getModifiedDate());
		attributes.put("title", getTitle());
		attributes.put("description", getDescription());

		return attributes;
	}

	public void setModelAttributes(Map<String, Object> attributes) {
		Long categoryId = (Long)attributes.get("categoryId");

		if (categoryId != null) {
			setCategoryId(categoryId);
		}

		Long companyId = (Long)attributes.get("companyId");

		if (companyId != null) {
			setCompanyId(companyId);
		}

		Long groupId = (Long)attributes.get("groupId");

		if (groupId != null) {
			setGroupId(groupId);
		}

		Long userId = (Long)attributes.get("userId");

		if (userId != null) {
			setUserId(userId);
		}

		String userName = (String)attributes.get("userName");

		if (userName != null) {
			setUserName(userName);
		}

		Date createDate = (Date)attributes.get("createDate");

		if (createDate != null) {
			setCreateDate(createDate);
		}

		Date modifiedDate = (Date)attributes.get("modifiedDate");

		if (modifiedDate != null) {
			setModifiedDate(modifiedDate);
		}

		String title = (String)attributes.get("title");

		if (title != null) {
			setTitle(title);
		}

		String description = (String)attributes.get("description");

		if (description != null) {
			setDescription(description);
		}
	}

	/**
	* Returns the primary key of this sage category.
	*
	* @return the primary key of this sage category
	*/
	public long getPrimaryKey() {
		return _sageCategory.getPrimaryKey();
	}

	/**
	* Sets the primary key of this sage category.
	*
	* @param primaryKey the primary key of this sage category
	*/
	public void setPrimaryKey(long primaryKey) {
		_sageCategory.setPrimaryKey(primaryKey);
	}

	/**
	* Returns the category ID of this sage category.
	*
	* @return the category ID of this sage category
	*/
	public long getCategoryId() {
		return _sageCategory.getCategoryId();
	}

	/**
	* Sets the category ID of this sage category.
	*
	* @param categoryId the category ID of this sage category
	*/
	public void setCategoryId(long categoryId) {
		_sageCategory.setCategoryId(categoryId);
	}

	/**
	* Returns the company ID of this sage category.
	*
	* @return the company ID of this sage category
	*/
	public long getCompanyId() {
		return _sageCategory.getCompanyId();
	}

	/**
	* Sets the company ID of this sage category.
	*
	* @param companyId the company ID of this sage category
	*/
	public void setCompanyId(long companyId) {
		_sageCategory.setCompanyId(companyId);
	}

	/**
	* Returns the group ID of this sage category.
	*
	* @return the group ID of this sage category
	*/
	public long getGroupId() {
		return _sageCategory.getGroupId();
	}

	/**
	* Sets the group ID of this sage category.
	*
	* @param groupId the group ID of this sage category
	*/
	public void setGroupId(long groupId) {
		_sageCategory.setGroupId(groupId);
	}

	/**
	* Returns the user ID of this sage category.
	*
	* @return the user ID of this sage category
	*/
	public long getUserId() {
		return _sageCategory.getUserId();
	}

	/**
	* Sets the user ID of this sage category.
	*
	* @param userId the user ID of this sage category
	*/
	public void setUserId(long userId) {
		_sageCategory.setUserId(userId);
	}

	/**
	* Returns the user uuid of this sage category.
	*
	* @return the user uuid of this sage category
	* @throws SystemException if a system exception occurred
	*/
	public java.lang.String getUserUuid()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _sageCategory.getUserUuid();
	}

	/**
	* Sets the user uuid of this sage category.
	*
	* @param userUuid the user uuid of this sage category
	*/
	public void setUserUuid(java.lang.String userUuid) {
		_sageCategory.setUserUuid(userUuid);
	}

	/**
	* Returns the user name of this sage category.
	*
	* @return the user name of this sage category
	*/
	public java.lang.String getUserName() {
		return _sageCategory.getUserName();
	}

	/**
	* Sets the user name of this sage category.
	*
	* @param userName the user name of this sage category
	*/
	public void setUserName(java.lang.String userName) {
		_sageCategory.setUserName(userName);
	}

	/**
	* Returns the create date of this sage category.
	*
	* @return the create date of this sage category
	*/
	public java.util.Date getCreateDate() {
		return _sageCategory.getCreateDate();
	}

	/**
	* Sets the create date of this sage category.
	*
	* @param createDate the create date of this sage category
	*/
	public void setCreateDate(java.util.Date createDate) {
		_sageCategory.setCreateDate(createDate);
	}

	/**
	* Returns the modified date of this sage category.
	*
	* @return the modified date of this sage category
	*/
	public java.util.Date getModifiedDate() {
		return _sageCategory.getModifiedDate();
	}

	/**
	* Sets the modified date of this sage category.
	*
	* @param modifiedDate the modified date of this sage category
	*/
	public void setModifiedDate(java.util.Date modifiedDate) {
		_sageCategory.setModifiedDate(modifiedDate);
	}

	/**
	* Returns the title of this sage category.
	*
	* @return the title of this sage category
	*/
	public java.lang.String getTitle() {
		return _sageCategory.getTitle();
	}

	/**
	* Sets the title of this sage category.
	*
	* @param title the title of this sage category
	*/
	public void setTitle(java.lang.String title) {
		_sageCategory.setTitle(title);
	}

	/**
	* Returns the description of this sage category.
	*
	* @return the description of this sage category
	*/
	public java.lang.String getDescription() {
		return _sageCategory.getDescription();
	}

	/**
	* Sets the description of this sage category.
	*
	* @param description the description of this sage category
	*/
	public void setDescription(java.lang.String description) {
		_sageCategory.setDescription(description);
	}

	public boolean isNew() {
		return _sageCategory.isNew();
	}

	public void setNew(boolean n) {
		_sageCategory.setNew(n);
	}

	public boolean isCachedModel() {
		return _sageCategory.isCachedModel();
	}

	public void setCachedModel(boolean cachedModel) {
		_sageCategory.setCachedModel(cachedModel);
	}

	public boolean isEscapedModel() {
		return _sageCategory.isEscapedModel();
	}

	public java.io.Serializable getPrimaryKeyObj() {
		return _sageCategory.getPrimaryKeyObj();
	}

	public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
		_sageCategory.setPrimaryKeyObj(primaryKeyObj);
	}

	public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
		return _sageCategory.getExpandoBridge();
	}

	public void setExpandoBridgeAttributes(
		com.liferay.portal.service.ServiceContext serviceContext) {
		_sageCategory.setExpandoBridgeAttributes(serviceContext);
	}

	@Override
	public java.lang.Object clone() {
		return new sageCategoryWrapper((sageCategory)_sageCategory.clone());
	}

	public int compareTo(com.sage.ideatool.model.sageCategory sageCategory) {
		return _sageCategory.compareTo(sageCategory);
	}

	@Override
	public int hashCode() {
		return _sageCategory.hashCode();
	}

	public com.liferay.portal.model.CacheModel<com.sage.ideatool.model.sageCategory> toCacheModel() {
		return _sageCategory.toCacheModel();
	}

	public com.sage.ideatool.model.sageCategory toEscapedModel() {
		return new sageCategoryWrapper(_sageCategory.toEscapedModel());
	}

	@Override
	public java.lang.String toString() {
		return _sageCategory.toString();
	}

	public java.lang.String toXmlString() {
		return _sageCategory.toXmlString();
	}

	public void persist()
		throws com.liferay.portal.kernel.exception.SystemException {
		_sageCategory.persist();
	}

	/**
	 * @deprecated Renamed to {@link #getWrappedModel}
	 */
	public sageCategory getWrappedsageCategory() {
		return _sageCategory;
	}

	public sageCategory getWrappedModel() {
		return _sageCategory;
	}

	public void resetOriginalValues() {
		_sageCategory.resetOriginalValues();
	}

	private sageCategory _sageCategory;
}