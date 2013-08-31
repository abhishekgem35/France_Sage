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

import com.liferay.portal.service.persistence.BasePersistence;

import com.sage.ideatool.model.sageCategory;

/**
 * The persistence interface for the sage category service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author 009
 * @see sageCategoryPersistenceImpl
 * @see sageCategoryUtil
 * @generated
 */
public interface sageCategoryPersistence extends BasePersistence<sageCategory> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link sageCategoryUtil} to access the sage category persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	* Caches the sage category in the entity cache if it is enabled.
	*
	* @param sageCategory the sage category
	*/
	public void cacheResult(com.sage.ideatool.model.sageCategory sageCategory);

	/**
	* Caches the sage categories in the entity cache if it is enabled.
	*
	* @param sageCategories the sage categories
	*/
	public void cacheResult(
		java.util.List<com.sage.ideatool.model.sageCategory> sageCategories);

	/**
	* Creates a new sage category with the primary key. Does not add the sage category to the database.
	*
	* @param categoryId the primary key for the new sage category
	* @return the new sage category
	*/
	public com.sage.ideatool.model.sageCategory create(long categoryId);

	/**
	* Removes the sage category with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param categoryId the primary key of the sage category
	* @return the sage category that was removed
	* @throws com.sage.ideatool.NoSuchCategoryException if a sage category with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.sage.ideatool.model.sageCategory remove(long categoryId)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sage.ideatool.NoSuchCategoryException;

	public com.sage.ideatool.model.sageCategory updateImpl(
		com.sage.ideatool.model.sageCategory sageCategory, boolean merge)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the sage category with the primary key or throws a {@link com.sage.ideatool.NoSuchCategoryException} if it could not be found.
	*
	* @param categoryId the primary key of the sage category
	* @return the sage category
	* @throws com.sage.ideatool.NoSuchCategoryException if a sage category with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.sage.ideatool.model.sageCategory findByPrimaryKey(
		long categoryId)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sage.ideatool.NoSuchCategoryException;

	/**
	* Returns the sage category with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param categoryId the primary key of the sage category
	* @return the sage category, or <code>null</code> if a sage category with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.sage.ideatool.model.sageCategory fetchByPrimaryKey(
		long categoryId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the sage categories where title = &#63;.
	*
	* @param title the title
	* @return the matching sage categories
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.sage.ideatool.model.sageCategory> findBytitle(
		java.lang.String title)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<com.sage.ideatool.model.sageCategory> findBytitle(
		java.lang.String title, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<com.sage.ideatool.model.sageCategory> findBytitle(
		java.lang.String title, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first sage category in the ordered set where title = &#63;.
	*
	* @param title the title
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching sage category
	* @throws com.sage.ideatool.NoSuchCategoryException if a matching sage category could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.sage.ideatool.model.sageCategory findBytitle_First(
		java.lang.String title,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sage.ideatool.NoSuchCategoryException;

	/**
	* Returns the first sage category in the ordered set where title = &#63;.
	*
	* @param title the title
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching sage category, or <code>null</code> if a matching sage category could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.sage.ideatool.model.sageCategory fetchBytitle_First(
		java.lang.String title,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last sage category in the ordered set where title = &#63;.
	*
	* @param title the title
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching sage category
	* @throws com.sage.ideatool.NoSuchCategoryException if a matching sage category could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.sage.ideatool.model.sageCategory findBytitle_Last(
		java.lang.String title,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sage.ideatool.NoSuchCategoryException;

	/**
	* Returns the last sage category in the ordered set where title = &#63;.
	*
	* @param title the title
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching sage category, or <code>null</code> if a matching sage category could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.sage.ideatool.model.sageCategory fetchBytitle_Last(
		java.lang.String title,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public com.sage.ideatool.model.sageCategory[] findBytitle_PrevAndNext(
		long categoryId, java.lang.String title,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sage.ideatool.NoSuchCategoryException;

	/**
	* Returns all the sage categories where userId = &#63;.
	*
	* @param userId the user ID
	* @return the matching sage categories
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.sage.ideatool.model.sageCategory> findByuserId(
		long userId) throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<com.sage.ideatool.model.sageCategory> findByuserId(
		long userId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<com.sage.ideatool.model.sageCategory> findByuserId(
		long userId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first sage category in the ordered set where userId = &#63;.
	*
	* @param userId the user ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching sage category
	* @throws com.sage.ideatool.NoSuchCategoryException if a matching sage category could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.sage.ideatool.model.sageCategory findByuserId_First(
		long userId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sage.ideatool.NoSuchCategoryException;

	/**
	* Returns the first sage category in the ordered set where userId = &#63;.
	*
	* @param userId the user ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching sage category, or <code>null</code> if a matching sage category could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.sage.ideatool.model.sageCategory fetchByuserId_First(
		long userId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last sage category in the ordered set where userId = &#63;.
	*
	* @param userId the user ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching sage category
	* @throws com.sage.ideatool.NoSuchCategoryException if a matching sage category could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.sage.ideatool.model.sageCategory findByuserId_Last(long userId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sage.ideatool.NoSuchCategoryException;

	/**
	* Returns the last sage category in the ordered set where userId = &#63;.
	*
	* @param userId the user ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching sage category, or <code>null</code> if a matching sage category could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.sage.ideatool.model.sageCategory fetchByuserId_Last(
		long userId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public com.sage.ideatool.model.sageCategory[] findByuserId_PrevAndNext(
		long categoryId, long userId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sage.ideatool.NoSuchCategoryException;

	/**
	* Returns all the sage categories.
	*
	* @return the sage categories
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.sage.ideatool.model.sageCategory> findAll()
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<com.sage.ideatool.model.sageCategory> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<com.sage.ideatool.model.sageCategory> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the sage categories where title = &#63; from the database.
	*
	* @param title the title
	* @throws SystemException if a system exception occurred
	*/
	public void removeBytitle(java.lang.String title)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the sage categories where userId = &#63; from the database.
	*
	* @param userId the user ID
	* @throws SystemException if a system exception occurred
	*/
	public void removeByuserId(long userId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the sage categories from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of sage categories where title = &#63;.
	*
	* @param title the title
	* @return the number of matching sage categories
	* @throws SystemException if a system exception occurred
	*/
	public int countBytitle(java.lang.String title)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of sage categories where userId = &#63;.
	*
	* @param userId the user ID
	* @return the number of matching sage categories
	* @throws SystemException if a system exception occurred
	*/
	public int countByuserId(long userId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of sage categories.
	*
	* @return the number of sage categories
	* @throws SystemException if a system exception occurred
	*/
	public int countAll()
		throws com.liferay.portal.kernel.exception.SystemException;
}