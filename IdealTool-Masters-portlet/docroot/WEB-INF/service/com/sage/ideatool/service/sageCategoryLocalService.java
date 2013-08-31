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

package com.sage.ideatool.service;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.transaction.Isolation;
import com.liferay.portal.kernel.transaction.Propagation;
import com.liferay.portal.kernel.transaction.Transactional;
import com.liferay.portal.service.BaseLocalService;
import com.liferay.portal.service.InvokableLocalService;
import com.liferay.portal.service.PersistedModelLocalService;

/**
 * The interface for the sage category local service.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author 009
 * @see sageCategoryLocalServiceUtil
 * @see com.sage.ideatool.service.base.sageCategoryLocalServiceBaseImpl
 * @see com.sage.ideatool.service.impl.sageCategoryLocalServiceImpl
 * @generated
 */
@Transactional(isolation = Isolation.PORTAL, rollbackFor =  {
	PortalException.class, SystemException.class})
public interface sageCategoryLocalService extends BaseLocalService,
	InvokableLocalService, PersistedModelLocalService {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link sageCategoryLocalServiceUtil} to access the sage category local service. Add custom service methods to {@link com.sage.ideatool.service.impl.sageCategoryLocalServiceImpl} and rerun ServiceBuilder to automatically copy the method declarations to this interface.
	 */

	/**
	* Adds the sage category to the database. Also notifies the appropriate model listeners.
	*
	* @param sageCategory the sage category
	* @return the sage category that was added
	* @throws SystemException if a system exception occurred
	*/
	public com.sage.ideatool.model.sageCategory addsageCategory(
		com.sage.ideatool.model.sageCategory sageCategory)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Creates a new sage category with the primary key. Does not add the sage category to the database.
	*
	* @param categoryId the primary key for the new sage category
	* @return the new sage category
	*/
	public com.sage.ideatool.model.sageCategory createsageCategory(
		long categoryId);

	/**
	* Deletes the sage category with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param categoryId the primary key of the sage category
	* @return the sage category that was removed
	* @throws PortalException if a sage category with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.sage.ideatool.model.sageCategory deletesageCategory(
		long categoryId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Deletes the sage category from the database. Also notifies the appropriate model listeners.
	*
	* @param sageCategory the sage category
	* @return the sage category that was removed
	* @throws SystemException if a system exception occurred
	*/
	public com.sage.ideatool.model.sageCategory deletesageCategory(
		com.sage.ideatool.model.sageCategory sageCategory)
		throws com.liferay.portal.kernel.exception.SystemException;

	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery();

	/**
	* Performs a dynamic query on the database and returns the matching rows.
	*
	* @param dynamicQuery the dynamic query
	* @return the matching rows
	* @throws SystemException if a system exception occurred
	*/
	@SuppressWarnings("rawtypes")
	public java.util.List dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Performs a dynamic query on the database and returns a range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param dynamicQuery the dynamic query
	* @param start the lower bound of the range of model instances
	* @param end the upper bound of the range of model instances (not inclusive)
	* @return the range of matching rows
	* @throws SystemException if a system exception occurred
	*/
	@SuppressWarnings("rawtypes")
	public java.util.List dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end) throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Performs a dynamic query on the database and returns an ordered range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param dynamicQuery the dynamic query
	* @param start the lower bound of the range of model instances
	* @param end the upper bound of the range of model instances (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching rows
	* @throws SystemException if a system exception occurred
	*/
	@SuppressWarnings("rawtypes")
	public java.util.List dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of rows that match the dynamic query.
	*
	* @param dynamicQuery the dynamic query
	* @return the number of rows that match the dynamic query
	* @throws SystemException if a system exception occurred
	*/
	public long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
		throws com.liferay.portal.kernel.exception.SystemException;

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public com.sage.ideatool.model.sageCategory fetchsageCategory(
		long categoryId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the sage category with the primary key.
	*
	* @param categoryId the primary key of the sage category
	* @return the sage category
	* @throws PortalException if a sage category with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public com.sage.ideatool.model.sageCategory getsageCategory(long categoryId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException;

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public com.liferay.portal.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the sage categories.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param start the lower bound of the range of sage categories
	* @param end the upper bound of the range of sage categories (not inclusive)
	* @return the range of sage categories
	* @throws SystemException if a system exception occurred
	*/
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public java.util.List<com.sage.ideatool.model.sageCategory> getsageCategories(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of sage categories.
	*
	* @return the number of sage categories
	* @throws SystemException if a system exception occurred
	*/
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public int getsageCategoriesCount()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Updates the sage category in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param sageCategory the sage category
	* @return the sage category that was updated
	* @throws SystemException if a system exception occurred
	*/
	public com.sage.ideatool.model.sageCategory updatesageCategory(
		com.sage.ideatool.model.sageCategory sageCategory)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Updates the sage category in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param sageCategory the sage category
	* @param merge whether to merge the sage category with the current session. See {@link com.liferay.portal.service.persistence.BatchSession#update(com.liferay.portal.kernel.dao.orm.Session, com.liferay.portal.model.BaseModel, boolean)} for an explanation.
	* @return the sage category that was updated
	* @throws SystemException if a system exception occurred
	*/
	public com.sage.ideatool.model.sageCategory updatesageCategory(
		com.sage.ideatool.model.sageCategory sageCategory, boolean merge)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the Spring bean ID for this bean.
	*
	* @return the Spring bean ID for this bean
	*/
	public java.lang.String getBeanIdentifier();

	/**
	* Sets the Spring bean ID for this bean.
	*
	* @param beanIdentifier the Spring bean ID for this bean
	*/
	public void setBeanIdentifier(java.lang.String beanIdentifier);

	public java.lang.Object invokeMethod(java.lang.String name,
		java.lang.String[] parameterTypes, java.lang.Object[] arguments)
		throws java.lang.Throwable;

	public com.sage.ideatool.model.sageCategory addsageCategory(
		java.lang.String title, java.lang.String description, long userId,
		java.lang.String userName)
		throws com.liferay.portal.kernel.exception.SystemException;

	public com.sage.ideatool.model.sageCategory updatesageCategory(
		java.lang.String title, java.lang.String description, long userId)
		throws com.liferay.portal.kernel.exception.SystemException;
}