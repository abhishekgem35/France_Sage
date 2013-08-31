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

package com.sage.ideatool.service.persistence;

import com.liferay.portal.kernel.bean.PortletBeanLocatorUtil;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.ReferenceRegistry;
import com.liferay.portal.service.ServiceContext;

import com.sage.ideatool.model.sageCategory;

import java.util.List;

/**
 * The persistence utility for the sage category service. This utility wraps {@link sageCategoryPersistenceImpl} and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author 009
 * @see sageCategoryPersistence
 * @see sageCategoryPersistenceImpl
 * @generated
 */
public class sageCategoryUtil {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#clearCache()
	 */
	public static void clearCache() {
		getPersistence().clearCache();
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#clearCache(com.liferay.portal.model.BaseModel)
	 */
	public static void clearCache(sageCategory sageCategory) {
		getPersistence().clearCache(sageCategory);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#countWithDynamicQuery(DynamicQuery)
	 */
	public long countWithDynamicQuery(DynamicQuery dynamicQuery)
		throws SystemException {
		return getPersistence().countWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery)
	 */
	public static List<sageCategory> findWithDynamicQuery(
		DynamicQuery dynamicQuery) throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<sageCategory> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end)
		throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<sageCategory> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		return getPersistence()
				   .findWithDynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel, boolean)
	 */
	public static sageCategory update(sageCategory sageCategory, boolean merge)
		throws SystemException {
		return getPersistence().update(sageCategory, merge);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel, boolean, ServiceContext)
	 */
	public static sageCategory update(sageCategory sageCategory, boolean merge,
		ServiceContext serviceContext) throws SystemException {
		return getPersistence().update(sageCategory, merge, serviceContext);
	}

	/**
	* Caches the sage category in the entity cache if it is enabled.
	*
	* @param sageCategory the sage category
	*/
	public static void cacheResult(
		com.sage.ideatool.model.sageCategory sageCategory) {
		getPersistence().cacheResult(sageCategory);
	}

	/**
	* Caches the sage categories in the entity cache if it is enabled.
	*
	* @param sageCategories the sage categories
	*/
	public static void cacheResult(
		java.util.List<com.sage.ideatool.model.sageCategory> sageCategories) {
		getPersistence().cacheResult(sageCategories);
	}

	/**
	* Creates a new sage category with the primary key. Does not add the sage category to the database.
	*
	* @param categoryId the primary key for the new sage category
	* @return the new sage category
	*/
	public static com.sage.ideatool.model.sageCategory create(long categoryId) {
		return getPersistence().create(categoryId);
	}

	/**
	* Removes the sage category with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param categoryId the primary key of the sage category
	* @return the sage category that was removed
	* @throws com.sage.ideatool.NoSuchCategoryException if a sage category with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.sage.ideatool.model.sageCategory remove(long categoryId)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sage.ideatool.NoSuchCategoryException {
		return getPersistence().remove(categoryId);
	}

	public static com.sage.ideatool.model.sageCategory updateImpl(
		com.sage.ideatool.model.sageCategory sageCategory, boolean merge)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().updateImpl(sageCategory, merge);
	}

	/**
	* Returns the sage category with the primary key or throws a {@link com.sage.ideatool.NoSuchCategoryException} if it could not be found.
	*
	* @param categoryId the primary key of the sage category
	* @return the sage category
	* @throws com.sage.ideatool.NoSuchCategoryException if a sage category with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.sage.ideatool.model.sageCategory findByPrimaryKey(
		long categoryId)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sage.ideatool.NoSuchCategoryException {
		return getPersistence().findByPrimaryKey(categoryId);
	}

	/**
	* Returns the sage category with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param categoryId the primary key of the sage category
	* @return the sage category, or <code>null</code> if a sage category with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.sage.ideatool.model.sageCategory fetchByPrimaryKey(
		long categoryId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByPrimaryKey(categoryId);
	}

	/**
	* Returns all the sage categories where title = &#63;.
	*
	* @param title the title
	* @return the matching sage categories
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.sage.ideatool.model.sageCategory> findBytitle(
		java.lang.String title)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findBytitle(title);
	}

	/**
	* Returns a range of all the sage categories where title = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param title the title
	* @param start the lower bound of the range of sage categories
	* @param end the upper bound of the range of sage categories (not inclusive)
	* @return the range of matching sage categories
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.sage.ideatool.model.sageCategory> findBytitle(
		java.lang.String title, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findBytitle(title, start, end);
	}

	/**
	* Returns an ordered range of all the sage categories where title = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param title the title
	* @param start the lower bound of the range of sage categories
	* @param end the upper bound of the range of sage categories (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching sage categories
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.sage.ideatool.model.sageCategory> findBytitle(
		java.lang.String title, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findBytitle(title, start, end, orderByComparator);
	}

	/**
	* Returns the first sage category in the ordered set where title = &#63;.
	*
	* @param title the title
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching sage category
	* @throws com.sage.ideatool.NoSuchCategoryException if a matching sage category could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.sage.ideatool.model.sageCategory findBytitle_First(
		java.lang.String title,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sage.ideatool.NoSuchCategoryException {
		return getPersistence().findBytitle_First(title, orderByComparator);
	}

	/**
	* Returns the first sage category in the ordered set where title = &#63;.
	*
	* @param title the title
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching sage category, or <code>null</code> if a matching sage category could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.sage.ideatool.model.sageCategory fetchBytitle_First(
		java.lang.String title,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchBytitle_First(title, orderByComparator);
	}

	/**
	* Returns the last sage category in the ordered set where title = &#63;.
	*
	* @param title the title
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching sage category
	* @throws com.sage.ideatool.NoSuchCategoryException if a matching sage category could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.sage.ideatool.model.sageCategory findBytitle_Last(
		java.lang.String title,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sage.ideatool.NoSuchCategoryException {
		return getPersistence().findBytitle_Last(title, orderByComparator);
	}

	/**
	* Returns the last sage category in the ordered set where title = &#63;.
	*
	* @param title the title
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching sage category, or <code>null</code> if a matching sage category could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.sage.ideatool.model.sageCategory fetchBytitle_Last(
		java.lang.String title,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchBytitle_Last(title, orderByComparator);
	}

	/**
	* Returns the sage categories before and after the current sage category in the ordered set where title = &#63;.
	*
	* @param categoryId the primary key of the current sage category
	* @param title the title
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next sage category
	* @throws com.sage.ideatool.NoSuchCategoryException if a sage category with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.sage.ideatool.model.sageCategory[] findBytitle_PrevAndNext(
		long categoryId, java.lang.String title,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sage.ideatool.NoSuchCategoryException {
		return getPersistence()
				   .findBytitle_PrevAndNext(categoryId, title, orderByComparator);
	}

	/**
	* Returns all the sage categories where userId = &#63;.
	*
	* @param userId the user ID
	* @return the matching sage categories
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.sage.ideatool.model.sageCategory> findByuserId(
		long userId) throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByuserId(userId);
	}

	/**
	* Returns a range of all the sage categories where userId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param userId the user ID
	* @param start the lower bound of the range of sage categories
	* @param end the upper bound of the range of sage categories (not inclusive)
	* @return the range of matching sage categories
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.sage.ideatool.model.sageCategory> findByuserId(
		long userId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByuserId(userId, start, end);
	}

	/**
	* Returns an ordered range of all the sage categories where userId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param userId the user ID
	* @param start the lower bound of the range of sage categories
	* @param end the upper bound of the range of sage categories (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching sage categories
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.sage.ideatool.model.sageCategory> findByuserId(
		long userId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByuserId(userId, start, end, orderByComparator);
	}

	/**
	* Returns the first sage category in the ordered set where userId = &#63;.
	*
	* @param userId the user ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching sage category
	* @throws com.sage.ideatool.NoSuchCategoryException if a matching sage category could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.sage.ideatool.model.sageCategory findByuserId_First(
		long userId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sage.ideatool.NoSuchCategoryException {
		return getPersistence().findByuserId_First(userId, orderByComparator);
	}

	/**
	* Returns the first sage category in the ordered set where userId = &#63;.
	*
	* @param userId the user ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching sage category, or <code>null</code> if a matching sage category could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.sage.ideatool.model.sageCategory fetchByuserId_First(
		long userId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByuserId_First(userId, orderByComparator);
	}

	/**
	* Returns the last sage category in the ordered set where userId = &#63;.
	*
	* @param userId the user ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching sage category
	* @throws com.sage.ideatool.NoSuchCategoryException if a matching sage category could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.sage.ideatool.model.sageCategory findByuserId_Last(
		long userId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sage.ideatool.NoSuchCategoryException {
		return getPersistence().findByuserId_Last(userId, orderByComparator);
	}

	/**
	* Returns the last sage category in the ordered set where userId = &#63;.
	*
	* @param userId the user ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching sage category, or <code>null</code> if a matching sage category could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.sage.ideatool.model.sageCategory fetchByuserId_Last(
		long userId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByuserId_Last(userId, orderByComparator);
	}

	/**
	* Returns the sage categories before and after the current sage category in the ordered set where userId = &#63;.
	*
	* @param categoryId the primary key of the current sage category
	* @param userId the user ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next sage category
	* @throws com.sage.ideatool.NoSuchCategoryException if a sage category with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.sage.ideatool.model.sageCategory[] findByuserId_PrevAndNext(
		long categoryId, long userId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sage.ideatool.NoSuchCategoryException {
		return getPersistence()
				   .findByuserId_PrevAndNext(categoryId, userId,
			orderByComparator);
	}

	/**
	* Returns all the sage categories.
	*
	* @return the sage categories
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.sage.ideatool.model.sageCategory> findAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll();
	}

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
	public static java.util.List<com.sage.ideatool.model.sageCategory> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end);
	}

	/**
	* Returns an ordered range of all the sage categories.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param start the lower bound of the range of sage categories
	* @param end the upper bound of the range of sage categories (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of sage categories
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.sage.ideatool.model.sageCategory> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	* Removes all the sage categories where title = &#63; from the database.
	*
	* @param title the title
	* @throws SystemException if a system exception occurred
	*/
	public static void removeBytitle(java.lang.String title)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeBytitle(title);
	}

	/**
	* Removes all the sage categories where userId = &#63; from the database.
	*
	* @param userId the user ID
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByuserId(long userId)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeByuserId(userId);
	}

	/**
	* Removes all the sage categories from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public static void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeAll();
	}

	/**
	* Returns the number of sage categories where title = &#63;.
	*
	* @param title the title
	* @return the number of matching sage categories
	* @throws SystemException if a system exception occurred
	*/
	public static int countBytitle(java.lang.String title)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countBytitle(title);
	}

	/**
	* Returns the number of sage categories where userId = &#63;.
	*
	* @param userId the user ID
	* @return the number of matching sage categories
	* @throws SystemException if a system exception occurred
	*/
	public static int countByuserId(long userId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByuserId(userId);
	}

	/**
	* Returns the number of sage categories.
	*
	* @return the number of sage categories
	* @throws SystemException if a system exception occurred
	*/
	public static int countAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countAll();
	}

	public static sageCategoryPersistence getPersistence() {
		if (_persistence == null) {
			_persistence = (sageCategoryPersistence)PortletBeanLocatorUtil.locate(com.sage.ideatool.service.ClpSerializer.getServletContextName(),
					sageCategoryPersistence.class.getName());

			ReferenceRegistry.registerReference(sageCategoryUtil.class,
				"_persistence");
		}

		return _persistence;
	}

	/**
	 * @deprecated
	 */
	public void setPersistence(sageCategoryPersistence persistence) {
	}

	private static sageCategoryPersistence _persistence;
}