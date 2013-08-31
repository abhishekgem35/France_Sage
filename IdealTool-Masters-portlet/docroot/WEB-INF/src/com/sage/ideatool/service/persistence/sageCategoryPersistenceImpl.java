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

import com.liferay.portal.NoSuchModelException;
import com.liferay.portal.kernel.bean.BeanReference;
import com.liferay.portal.kernel.cache.CacheRegistryUtil;
import com.liferay.portal.kernel.dao.orm.EntityCacheUtil;
import com.liferay.portal.kernel.dao.orm.FinderCacheUtil;
import com.liferay.portal.kernel.dao.orm.FinderPath;
import com.liferay.portal.kernel.dao.orm.Query;
import com.liferay.portal.kernel.dao.orm.QueryPos;
import com.liferay.portal.kernel.dao.orm.QueryUtil;
import com.liferay.portal.kernel.dao.orm.Session;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.InstanceFactory;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.PropsKeys;
import com.liferay.portal.kernel.util.PropsUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.kernel.util.StringUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.model.CacheModel;
import com.liferay.portal.model.ModelListener;
import com.liferay.portal.service.persistence.BatchSessionUtil;
import com.liferay.portal.service.persistence.ResourcePersistence;
import com.liferay.portal.service.persistence.UserPersistence;
import com.liferay.portal.service.persistence.impl.BasePersistenceImpl;

import com.sage.ideatool.NoSuchCategoryException;
import com.sage.ideatool.model.impl.sageCategoryImpl;
import com.sage.ideatool.model.impl.sageCategoryModelImpl;
import com.sage.ideatool.model.sageCategory;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * The persistence implementation for the sage category service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author 009
 * @see sageCategoryPersistence
 * @see sageCategoryUtil
 * @generated
 */
public class sageCategoryPersistenceImpl extends BasePersistenceImpl<sageCategory>
	implements sageCategoryPersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link sageCategoryUtil} to access the sage category persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = sageCategoryImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_TITLE = new FinderPath(sageCategoryModelImpl.ENTITY_CACHE_ENABLED,
			sageCategoryModelImpl.FINDER_CACHE_ENABLED, sageCategoryImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findBytitle",
			new String[] {
				String.class.getName(),
				
			"java.lang.Integer", "java.lang.Integer",
				"com.liferay.portal.kernel.util.OrderByComparator"
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_TITLE = new FinderPath(sageCategoryModelImpl.ENTITY_CACHE_ENABLED,
			sageCategoryModelImpl.FINDER_CACHE_ENABLED, sageCategoryImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findBytitle",
			new String[] { String.class.getName() },
			sageCategoryModelImpl.TITLE_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_TITLE = new FinderPath(sageCategoryModelImpl.ENTITY_CACHE_ENABLED,
			sageCategoryModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countBytitle",
			new String[] { String.class.getName() });
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_USERID = new FinderPath(sageCategoryModelImpl.ENTITY_CACHE_ENABLED,
			sageCategoryModelImpl.FINDER_CACHE_ENABLED, sageCategoryImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByuserId",
			new String[] {
				Long.class.getName(),
				
			"java.lang.Integer", "java.lang.Integer",
				"com.liferay.portal.kernel.util.OrderByComparator"
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_USERID =
		new FinderPath(sageCategoryModelImpl.ENTITY_CACHE_ENABLED,
			sageCategoryModelImpl.FINDER_CACHE_ENABLED, sageCategoryImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByuserId",
			new String[] { Long.class.getName() },
			sageCategoryModelImpl.USERID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_USERID = new FinderPath(sageCategoryModelImpl.ENTITY_CACHE_ENABLED,
			sageCategoryModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByuserId",
			new String[] { Long.class.getName() });
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(sageCategoryModelImpl.ENTITY_CACHE_ENABLED,
			sageCategoryModelImpl.FINDER_CACHE_ENABLED, sageCategoryImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(sageCategoryModelImpl.ENTITY_CACHE_ENABLED,
			sageCategoryModelImpl.FINDER_CACHE_ENABLED, sageCategoryImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(sageCategoryModelImpl.ENTITY_CACHE_ENABLED,
			sageCategoryModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);

	/**
	 * Caches the sage category in the entity cache if it is enabled.
	 *
	 * @param sageCategory the sage category
	 */
	public void cacheResult(sageCategory sageCategory) {
		EntityCacheUtil.putResult(sageCategoryModelImpl.ENTITY_CACHE_ENABLED,
			sageCategoryImpl.class, sageCategory.getPrimaryKey(), sageCategory);

		sageCategory.resetOriginalValues();
	}

	/**
	 * Caches the sage categories in the entity cache if it is enabled.
	 *
	 * @param sageCategories the sage categories
	 */
	public void cacheResult(List<sageCategory> sageCategories) {
		for (sageCategory sageCategory : sageCategories) {
			if (EntityCacheUtil.getResult(
						sageCategoryModelImpl.ENTITY_CACHE_ENABLED,
						sageCategoryImpl.class, sageCategory.getPrimaryKey()) == null) {
				cacheResult(sageCategory);
			}
			else {
				sageCategory.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all sage categories.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
			CacheRegistryUtil.clear(sageCategoryImpl.class.getName());
		}

		EntityCacheUtil.clearCache(sageCategoryImpl.class.getName());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the sage category.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(sageCategory sageCategory) {
		EntityCacheUtil.removeResult(sageCategoryModelImpl.ENTITY_CACHE_ENABLED,
			sageCategoryImpl.class, sageCategory.getPrimaryKey());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@Override
	public void clearCache(List<sageCategory> sageCategories) {
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (sageCategory sageCategory : sageCategories) {
			EntityCacheUtil.removeResult(sageCategoryModelImpl.ENTITY_CACHE_ENABLED,
				sageCategoryImpl.class, sageCategory.getPrimaryKey());
		}
	}

	/**
	 * Creates a new sage category with the primary key. Does not add the sage category to the database.
	 *
	 * @param categoryId the primary key for the new sage category
	 * @return the new sage category
	 */
	public sageCategory create(long categoryId) {
		sageCategory sageCategory = new sageCategoryImpl();

		sageCategory.setNew(true);
		sageCategory.setPrimaryKey(categoryId);

		return sageCategory;
	}

	/**
	 * Removes the sage category with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param categoryId the primary key of the sage category
	 * @return the sage category that was removed
	 * @throws com.sage.ideatool.NoSuchCategoryException if a sage category with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public sageCategory remove(long categoryId)
		throws NoSuchCategoryException, SystemException {
		return remove(Long.valueOf(categoryId));
	}

	/**
	 * Removes the sage category with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the sage category
	 * @return the sage category that was removed
	 * @throws com.sage.ideatool.NoSuchCategoryException if a sage category with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public sageCategory remove(Serializable primaryKey)
		throws NoSuchCategoryException, SystemException {
		Session session = null;

		try {
			session = openSession();

			sageCategory sageCategory = (sageCategory)session.get(sageCategoryImpl.class,
					primaryKey);

			if (sageCategory == null) {
				if (_log.isWarnEnabled()) {
					_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchCategoryException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(sageCategory);
		}
		catch (NoSuchCategoryException nsee) {
			throw nsee;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	@Override
	protected sageCategory removeImpl(sageCategory sageCategory)
		throws SystemException {
		sageCategory = toUnwrappedModel(sageCategory);

		Session session = null;

		try {
			session = openSession();

			BatchSessionUtil.delete(session, sageCategory);
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		clearCache(sageCategory);

		return sageCategory;
	}

	@Override
	public sageCategory updateImpl(
		com.sage.ideatool.model.sageCategory sageCategory, boolean merge)
		throws SystemException {
		sageCategory = toUnwrappedModel(sageCategory);

		boolean isNew = sageCategory.isNew();

		sageCategoryModelImpl sageCategoryModelImpl = (sageCategoryModelImpl)sageCategory;

		Session session = null;

		try {
			session = openSession();

			BatchSessionUtil.update(session, sageCategory, merge);

			sageCategory.setNew(false);
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

		if (isNew || !sageCategoryModelImpl.COLUMN_BITMASK_ENABLED) {
			FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
		}

		else {
			if ((sageCategoryModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_TITLE.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						sageCategoryModelImpl.getOriginalTitle()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_TITLE, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_TITLE,
					args);

				args = new Object[] { sageCategoryModelImpl.getTitle() };

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_TITLE, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_TITLE,
					args);
			}

			if ((sageCategoryModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_USERID.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						Long.valueOf(sageCategoryModelImpl.getOriginalUserId())
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_USERID, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_USERID,
					args);

				args = new Object[] {
						Long.valueOf(sageCategoryModelImpl.getUserId())
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_USERID, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_USERID,
					args);
			}
		}

		EntityCacheUtil.putResult(sageCategoryModelImpl.ENTITY_CACHE_ENABLED,
			sageCategoryImpl.class, sageCategory.getPrimaryKey(), sageCategory);

		return sageCategory;
	}

	protected sageCategory toUnwrappedModel(sageCategory sageCategory) {
		if (sageCategory instanceof sageCategoryImpl) {
			return sageCategory;
		}

		sageCategoryImpl sageCategoryImpl = new sageCategoryImpl();

		sageCategoryImpl.setNew(sageCategory.isNew());
		sageCategoryImpl.setPrimaryKey(sageCategory.getPrimaryKey());

		sageCategoryImpl.setCategoryId(sageCategory.getCategoryId());
		sageCategoryImpl.setCompanyId(sageCategory.getCompanyId());
		sageCategoryImpl.setGroupId(sageCategory.getGroupId());
		sageCategoryImpl.setUserId(sageCategory.getUserId());
		sageCategoryImpl.setUserName(sageCategory.getUserName());
		sageCategoryImpl.setCreateDate(sageCategory.getCreateDate());
		sageCategoryImpl.setModifiedDate(sageCategory.getModifiedDate());
		sageCategoryImpl.setTitle(sageCategory.getTitle());
		sageCategoryImpl.setDescription(sageCategory.getDescription());

		return sageCategoryImpl;
	}

	/**
	 * Returns the sage category with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the sage category
	 * @return the sage category
	 * @throws com.liferay.portal.NoSuchModelException if a sage category with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public sageCategory findByPrimaryKey(Serializable primaryKey)
		throws NoSuchModelException, SystemException {
		return findByPrimaryKey(((Long)primaryKey).longValue());
	}

	/**
	 * Returns the sage category with the primary key or throws a {@link com.sage.ideatool.NoSuchCategoryException} if it could not be found.
	 *
	 * @param categoryId the primary key of the sage category
	 * @return the sage category
	 * @throws com.sage.ideatool.NoSuchCategoryException if a sage category with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public sageCategory findByPrimaryKey(long categoryId)
		throws NoSuchCategoryException, SystemException {
		sageCategory sageCategory = fetchByPrimaryKey(categoryId);

		if (sageCategory == null) {
			if (_log.isWarnEnabled()) {
				_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + categoryId);
			}

			throw new NoSuchCategoryException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				categoryId);
		}

		return sageCategory;
	}

	/**
	 * Returns the sage category with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the sage category
	 * @return the sage category, or <code>null</code> if a sage category with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public sageCategory fetchByPrimaryKey(Serializable primaryKey)
		throws SystemException {
		return fetchByPrimaryKey(((Long)primaryKey).longValue());
	}

	/**
	 * Returns the sage category with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param categoryId the primary key of the sage category
	 * @return the sage category, or <code>null</code> if a sage category with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public sageCategory fetchByPrimaryKey(long categoryId)
		throws SystemException {
		sageCategory sageCategory = (sageCategory)EntityCacheUtil.getResult(sageCategoryModelImpl.ENTITY_CACHE_ENABLED,
				sageCategoryImpl.class, categoryId);

		if (sageCategory == _nullsageCategory) {
			return null;
		}

		if (sageCategory == null) {
			Session session = null;

			boolean hasException = false;

			try {
				session = openSession();

				sageCategory = (sageCategory)session.get(sageCategoryImpl.class,
						Long.valueOf(categoryId));
			}
			catch (Exception e) {
				hasException = true;

				throw processException(e);
			}
			finally {
				if (sageCategory != null) {
					cacheResult(sageCategory);
				}
				else if (!hasException) {
					EntityCacheUtil.putResult(sageCategoryModelImpl.ENTITY_CACHE_ENABLED,
						sageCategoryImpl.class, categoryId, _nullsageCategory);
				}

				closeSession(session);
			}
		}

		return sageCategory;
	}

	/**
	 * Returns all the sage categories where title = &#63;.
	 *
	 * @param title the title
	 * @return the matching sage categories
	 * @throws SystemException if a system exception occurred
	 */
	public List<sageCategory> findBytitle(String title)
		throws SystemException {
		return findBytitle(title, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
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
	public List<sageCategory> findBytitle(String title, int start, int end)
		throws SystemException {
		return findBytitle(title, start, end, null);
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
	public List<sageCategory> findBytitle(String title, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_TITLE;
			finderArgs = new Object[] { title };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_TITLE;
			finderArgs = new Object[] { title, start, end, orderByComparator };
		}

		List<sageCategory> list = (List<sageCategory>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (sageCategory sageCategory : list) {
				if (!Validator.equals(title, sageCategory.getTitle())) {
					list = null;

					break;
				}
			}
		}

		if (list == null) {
			StringBundler query = null;

			if (orderByComparator != null) {
				query = new StringBundler(3 +
						(orderByComparator.getOrderByFields().length * 3));
			}
			else {
				query = new StringBundler(3);
			}

			query.append(_SQL_SELECT_SAGECATEGORY_WHERE);

			if (title == null) {
				query.append(_FINDER_COLUMN_TITLE_TITLE_1);
			}
			else {
				if (title.equals(StringPool.BLANK)) {
					query.append(_FINDER_COLUMN_TITLE_TITLE_3);
				}
				else {
					query.append(_FINDER_COLUMN_TITLE_TITLE_2);
				}
			}

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}

			else {
				query.append(sageCategoryModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (title != null) {
					qPos.add(title);
				}

				list = (List<sageCategory>)QueryUtil.list(q, getDialect(),
						start, end);
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (list == null) {
					FinderCacheUtil.removeResult(finderPath, finderArgs);
				}
				else {
					cacheResult(list);

					FinderCacheUtil.putResult(finderPath, finderArgs, list);
				}

				closeSession(session);
			}
		}

		return list;
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
	public sageCategory findBytitle_First(String title,
		OrderByComparator orderByComparator)
		throws NoSuchCategoryException, SystemException {
		sageCategory sageCategory = fetchBytitle_First(title, orderByComparator);

		if (sageCategory != null) {
			return sageCategory;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("title=");
		msg.append(title);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchCategoryException(msg.toString());
	}

	/**
	 * Returns the first sage category in the ordered set where title = &#63;.
	 *
	 * @param title the title
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching sage category, or <code>null</code> if a matching sage category could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public sageCategory fetchBytitle_First(String title,
		OrderByComparator orderByComparator) throws SystemException {
		List<sageCategory> list = findBytitle(title, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
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
	public sageCategory findBytitle_Last(String title,
		OrderByComparator orderByComparator)
		throws NoSuchCategoryException, SystemException {
		sageCategory sageCategory = fetchBytitle_Last(title, orderByComparator);

		if (sageCategory != null) {
			return sageCategory;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("title=");
		msg.append(title);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchCategoryException(msg.toString());
	}

	/**
	 * Returns the last sage category in the ordered set where title = &#63;.
	 *
	 * @param title the title
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching sage category, or <code>null</code> if a matching sage category could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public sageCategory fetchBytitle_Last(String title,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countBytitle(title);

		List<sageCategory> list = findBytitle(title, count - 1, count,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
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
	public sageCategory[] findBytitle_PrevAndNext(long categoryId,
		String title, OrderByComparator orderByComparator)
		throws NoSuchCategoryException, SystemException {
		sageCategory sageCategory = findByPrimaryKey(categoryId);

		Session session = null;

		try {
			session = openSession();

			sageCategory[] array = new sageCategoryImpl[3];

			array[0] = getBytitle_PrevAndNext(session, sageCategory, title,
					orderByComparator, true);

			array[1] = sageCategory;

			array[2] = getBytitle_PrevAndNext(session, sageCategory, title,
					orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected sageCategory getBytitle_PrevAndNext(Session session,
		sageCategory sageCategory, String title,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_SAGECATEGORY_WHERE);

		if (title == null) {
			query.append(_FINDER_COLUMN_TITLE_TITLE_1);
		}
		else {
			if (title.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_TITLE_TITLE_3);
			}
			else {
				query.append(_FINDER_COLUMN_TITLE_TITLE_2);
			}
		}

		if (orderByComparator != null) {
			String[] orderByConditionFields = orderByComparator.getOrderByConditionFields();

			if (orderByConditionFields.length > 0) {
				query.append(WHERE_AND);
			}

			for (int i = 0; i < orderByConditionFields.length; i++) {
				query.append(_ORDER_BY_ENTITY_ALIAS);
				query.append(orderByConditionFields[i]);

				if ((i + 1) < orderByConditionFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(WHERE_GREATER_THAN_HAS_NEXT);
					}
					else {
						query.append(WHERE_LESSER_THAN_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(WHERE_GREATER_THAN);
					}
					else {
						query.append(WHERE_LESSER_THAN);
					}
				}
			}

			query.append(ORDER_BY_CLAUSE);

			String[] orderByFields = orderByComparator.getOrderByFields();

			for (int i = 0; i < orderByFields.length; i++) {
				query.append(_ORDER_BY_ENTITY_ALIAS);
				query.append(orderByFields[i]);

				if ((i + 1) < orderByFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(ORDER_BY_ASC_HAS_NEXT);
					}
					else {
						query.append(ORDER_BY_DESC_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(ORDER_BY_ASC);
					}
					else {
						query.append(ORDER_BY_DESC);
					}
				}
			}
		}

		else {
			query.append(sageCategoryModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		if (title != null) {
			qPos.add(title);
		}

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(sageCategory);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<sageCategory> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Returns all the sage categories where userId = &#63;.
	 *
	 * @param userId the user ID
	 * @return the matching sage categories
	 * @throws SystemException if a system exception occurred
	 */
	public List<sageCategory> findByuserId(long userId)
		throws SystemException {
		return findByuserId(userId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
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
	public List<sageCategory> findByuserId(long userId, int start, int end)
		throws SystemException {
		return findByuserId(userId, start, end, null);
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
	public List<sageCategory> findByuserId(long userId, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_USERID;
			finderArgs = new Object[] { userId };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_USERID;
			finderArgs = new Object[] { userId, start, end, orderByComparator };
		}

		List<sageCategory> list = (List<sageCategory>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (sageCategory sageCategory : list) {
				if ((userId != sageCategory.getUserId())) {
					list = null;

					break;
				}
			}
		}

		if (list == null) {
			StringBundler query = null;

			if (orderByComparator != null) {
				query = new StringBundler(3 +
						(orderByComparator.getOrderByFields().length * 3));
			}
			else {
				query = new StringBundler(3);
			}

			query.append(_SQL_SELECT_SAGECATEGORY_WHERE);

			query.append(_FINDER_COLUMN_USERID_USERID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}

			else {
				query.append(sageCategoryModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(userId);

				list = (List<sageCategory>)QueryUtil.list(q, getDialect(),
						start, end);
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (list == null) {
					FinderCacheUtil.removeResult(finderPath, finderArgs);
				}
				else {
					cacheResult(list);

					FinderCacheUtil.putResult(finderPath, finderArgs, list);
				}

				closeSession(session);
			}
		}

		return list;
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
	public sageCategory findByuserId_First(long userId,
		OrderByComparator orderByComparator)
		throws NoSuchCategoryException, SystemException {
		sageCategory sageCategory = fetchByuserId_First(userId,
				orderByComparator);

		if (sageCategory != null) {
			return sageCategory;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("userId=");
		msg.append(userId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchCategoryException(msg.toString());
	}

	/**
	 * Returns the first sage category in the ordered set where userId = &#63;.
	 *
	 * @param userId the user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching sage category, or <code>null</code> if a matching sage category could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public sageCategory fetchByuserId_First(long userId,
		OrderByComparator orderByComparator) throws SystemException {
		List<sageCategory> list = findByuserId(userId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
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
	public sageCategory findByuserId_Last(long userId,
		OrderByComparator orderByComparator)
		throws NoSuchCategoryException, SystemException {
		sageCategory sageCategory = fetchByuserId_Last(userId, orderByComparator);

		if (sageCategory != null) {
			return sageCategory;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("userId=");
		msg.append(userId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchCategoryException(msg.toString());
	}

	/**
	 * Returns the last sage category in the ordered set where userId = &#63;.
	 *
	 * @param userId the user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching sage category, or <code>null</code> if a matching sage category could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public sageCategory fetchByuserId_Last(long userId,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countByuserId(userId);

		List<sageCategory> list = findByuserId(userId, count - 1, count,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
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
	public sageCategory[] findByuserId_PrevAndNext(long categoryId,
		long userId, OrderByComparator orderByComparator)
		throws NoSuchCategoryException, SystemException {
		sageCategory sageCategory = findByPrimaryKey(categoryId);

		Session session = null;

		try {
			session = openSession();

			sageCategory[] array = new sageCategoryImpl[3];

			array[0] = getByuserId_PrevAndNext(session, sageCategory, userId,
					orderByComparator, true);

			array[1] = sageCategory;

			array[2] = getByuserId_PrevAndNext(session, sageCategory, userId,
					orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected sageCategory getByuserId_PrevAndNext(Session session,
		sageCategory sageCategory, long userId,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_SAGECATEGORY_WHERE);

		query.append(_FINDER_COLUMN_USERID_USERID_2);

		if (orderByComparator != null) {
			String[] orderByConditionFields = orderByComparator.getOrderByConditionFields();

			if (orderByConditionFields.length > 0) {
				query.append(WHERE_AND);
			}

			for (int i = 0; i < orderByConditionFields.length; i++) {
				query.append(_ORDER_BY_ENTITY_ALIAS);
				query.append(orderByConditionFields[i]);

				if ((i + 1) < orderByConditionFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(WHERE_GREATER_THAN_HAS_NEXT);
					}
					else {
						query.append(WHERE_LESSER_THAN_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(WHERE_GREATER_THAN);
					}
					else {
						query.append(WHERE_LESSER_THAN);
					}
				}
			}

			query.append(ORDER_BY_CLAUSE);

			String[] orderByFields = orderByComparator.getOrderByFields();

			for (int i = 0; i < orderByFields.length; i++) {
				query.append(_ORDER_BY_ENTITY_ALIAS);
				query.append(orderByFields[i]);

				if ((i + 1) < orderByFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(ORDER_BY_ASC_HAS_NEXT);
					}
					else {
						query.append(ORDER_BY_DESC_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(ORDER_BY_ASC);
					}
					else {
						query.append(ORDER_BY_DESC);
					}
				}
			}
		}

		else {
			query.append(sageCategoryModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(userId);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(sageCategory);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<sageCategory> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Returns all the sage categories.
	 *
	 * @return the sage categories
	 * @throws SystemException if a system exception occurred
	 */
	public List<sageCategory> findAll() throws SystemException {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
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
	public List<sageCategory> findAll(int start, int end)
		throws SystemException {
		return findAll(start, end, null);
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
	public List<sageCategory> findAll(int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		FinderPath finderPath = null;
		Object[] finderArgs = new Object[] { start, end, orderByComparator };

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL;
			finderArgs = FINDER_ARGS_EMPTY;
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_ALL;
			finderArgs = new Object[] { start, end, orderByComparator };
		}

		List<sageCategory> list = (List<sageCategory>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 3));

				query.append(_SQL_SELECT_SAGECATEGORY);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_SAGECATEGORY.concat(sageCategoryModelImpl.ORDER_BY_JPQL);
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (orderByComparator == null) {
					list = (List<sageCategory>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);
				}
				else {
					list = (List<sageCategory>)QueryUtil.list(q, getDialect(),
							start, end);
				}
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (list == null) {
					FinderCacheUtil.removeResult(finderPath, finderArgs);
				}
				else {
					cacheResult(list);

					FinderCacheUtil.putResult(finderPath, finderArgs, list);
				}

				closeSession(session);
			}
		}

		return list;
	}

	/**
	 * Removes all the sage categories where title = &#63; from the database.
	 *
	 * @param title the title
	 * @throws SystemException if a system exception occurred
	 */
	public void removeBytitle(String title) throws SystemException {
		for (sageCategory sageCategory : findBytitle(title)) {
			remove(sageCategory);
		}
	}

	/**
	 * Removes all the sage categories where userId = &#63; from the database.
	 *
	 * @param userId the user ID
	 * @throws SystemException if a system exception occurred
	 */
	public void removeByuserId(long userId) throws SystemException {
		for (sageCategory sageCategory : findByuserId(userId)) {
			remove(sageCategory);
		}
	}

	/**
	 * Removes all the sage categories from the database.
	 *
	 * @throws SystemException if a system exception occurred
	 */
	public void removeAll() throws SystemException {
		for (sageCategory sageCategory : findAll()) {
			remove(sageCategory);
		}
	}

	/**
	 * Returns the number of sage categories where title = &#63;.
	 *
	 * @param title the title
	 * @return the number of matching sage categories
	 * @throws SystemException if a system exception occurred
	 */
	public int countBytitle(String title) throws SystemException {
		Object[] finderArgs = new Object[] { title };

		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_COUNT_BY_TITLE,
				finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_SAGECATEGORY_WHERE);

			if (title == null) {
				query.append(_FINDER_COLUMN_TITLE_TITLE_1);
			}
			else {
				if (title.equals(StringPool.BLANK)) {
					query.append(_FINDER_COLUMN_TITLE_TITLE_3);
				}
				else {
					query.append(_FINDER_COLUMN_TITLE_TITLE_2);
				}
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (title != null) {
					qPos.add(title);
				}

				count = (Long)q.uniqueResult();
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (count == null) {
					count = Long.valueOf(0);
				}

				FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_TITLE,
					finderArgs, count);

				closeSession(session);
			}
		}

		return count.intValue();
	}

	/**
	 * Returns the number of sage categories where userId = &#63;.
	 *
	 * @param userId the user ID
	 * @return the number of matching sage categories
	 * @throws SystemException if a system exception occurred
	 */
	public int countByuserId(long userId) throws SystemException {
		Object[] finderArgs = new Object[] { userId };

		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_COUNT_BY_USERID,
				finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_SAGECATEGORY_WHERE);

			query.append(_FINDER_COLUMN_USERID_USERID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(userId);

				count = (Long)q.uniqueResult();
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (count == null) {
					count = Long.valueOf(0);
				}

				FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_USERID,
					finderArgs, count);

				closeSession(session);
			}
		}

		return count.intValue();
	}

	/**
	 * Returns the number of sage categories.
	 *
	 * @return the number of sage categories
	 * @throws SystemException if a system exception occurred
	 */
	public int countAll() throws SystemException {
		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_COUNT_ALL,
				FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(_SQL_COUNT_SAGECATEGORY);

				count = (Long)q.uniqueResult();
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (count == null) {
					count = Long.valueOf(0);
				}

				FinderCacheUtil.putResult(FINDER_PATH_COUNT_ALL,
					FINDER_ARGS_EMPTY, count);

				closeSession(session);
			}
		}

		return count.intValue();
	}

	/**
	 * Initializes the sage category persistence.
	 */
	public void afterPropertiesSet() {
		String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
					com.liferay.util.service.ServiceProps.get(
						"value.object.listener.com.sage.ideatool.model.sageCategory")));

		if (listenerClassNames.length > 0) {
			try {
				List<ModelListener<sageCategory>> listenersList = new ArrayList<ModelListener<sageCategory>>();

				for (String listenerClassName : listenerClassNames) {
					listenersList.add((ModelListener<sageCategory>)InstanceFactory.newInstance(
							listenerClassName));
				}

				listeners = listenersList.toArray(new ModelListener[listenersList.size()]);
			}
			catch (Exception e) {
				_log.error(e);
			}
		}
	}

	public void destroy() {
		EntityCacheUtil.removeCache(sageCategoryImpl.class.getName());
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@BeanReference(type = sageCategoryPersistence.class)
	protected sageCategoryPersistence sageCategoryPersistence;
	@BeanReference(type = ResourcePersistence.class)
	protected ResourcePersistence resourcePersistence;
	@BeanReference(type = UserPersistence.class)
	protected UserPersistence userPersistence;
	private static final String _SQL_SELECT_SAGECATEGORY = "SELECT sageCategory FROM sageCategory sageCategory";
	private static final String _SQL_SELECT_SAGECATEGORY_WHERE = "SELECT sageCategory FROM sageCategory sageCategory WHERE ";
	private static final String _SQL_COUNT_SAGECATEGORY = "SELECT COUNT(sageCategory) FROM sageCategory sageCategory";
	private static final String _SQL_COUNT_SAGECATEGORY_WHERE = "SELECT COUNT(sageCategory) FROM sageCategory sageCategory WHERE ";
	private static final String _FINDER_COLUMN_TITLE_TITLE_1 = "sageCategory.title IS NULL";
	private static final String _FINDER_COLUMN_TITLE_TITLE_2 = "sageCategory.title = ?";
	private static final String _FINDER_COLUMN_TITLE_TITLE_3 = "(sageCategory.title IS NULL OR sageCategory.title = ?)";
	private static final String _FINDER_COLUMN_USERID_USERID_2 = "sageCategory.userId = ?";
	private static final String _ORDER_BY_ENTITY_ALIAS = "sageCategory.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No sageCategory exists with the primary key ";
	private static final String _NO_SUCH_ENTITY_WITH_KEY = "No sageCategory exists with the key {";
	private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
				PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
	private static Log _log = LogFactoryUtil.getLog(sageCategoryPersistenceImpl.class);
	private static sageCategory _nullsageCategory = new sageCategoryImpl() {
			@Override
			public Object clone() {
				return this;
			}

			@Override
			public CacheModel<sageCategory> toCacheModel() {
				return _nullsageCategoryCacheModel;
			}
		};

	private static CacheModel<sageCategory> _nullsageCategoryCacheModel = new CacheModel<sageCategory>() {
			public sageCategory toEntityModel() {
				return _nullsageCategory;
			}
		};
}