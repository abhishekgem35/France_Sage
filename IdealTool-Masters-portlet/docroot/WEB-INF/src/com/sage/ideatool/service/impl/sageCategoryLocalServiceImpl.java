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

package com.sage.ideatool.service.impl;

import java.util.Date;
import java.util.List;

import org.apache.log4j.Logger;

import com.liferay.counter.service.CounterLocalServiceUtil;
import com.liferay.portal.NoSuchUserException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.model.User;
import com.liferay.portal.service.persistence.UserUtil;
import com.sage.ideatool.model.sageCategory;
import com.sage.ideatool.service.base.sageCategoryLocalServiceBaseImpl;

/**
 * The implementation of the sage category local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the {@link com.sage.ideatool.service.sageCategoryLocalService} interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author 009
 * @see com.sage.ideatool.service.base.sageCategoryLocalServiceBaseImpl
 * @see com.sage.ideatool.service.sageCategoryLocalServiceUtil
 */
public class sageCategoryLocalServiceImpl
	extends sageCategoryLocalServiceBaseImpl {
	
	private static Logger s_log = Logger.getLogger(sageCategoryLocalServiceImpl.class.getName());
	
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never reference this interface directly. Always use {@link com.sage.ideatool.service.sageCategoryLocalServiceUtil} to access the sage category local service.
	 */
	
	public sageCategory addsageCategory(String title, String description, long userId, String userName)
	throws SystemException {
		User user = null;
		try{
			user = UserUtil.findByPrimaryKey(userId);
		}catch(NoSuchUserException nue)
		{
			s_log.error("No Such User found with the key" + userId);
			return null;
		}
		
		long categoryId = CounterLocalServiceUtil.increment(sageCategory.class.getName());
		
		sageCategory category = sageCategoryPersistence.create(categoryId);
		category.setTitle(title);
		category.setDescription(description);
		category.setUserId(userId);
		
		category.setUserName(user.getScreenName());
		
		category.setCreateDate(new Date());
		category.setModifiedDate(new Date());
		
		return sageCategoryPersistence.update(category, false);
	}
	
	public sageCategory updatesageCategory(String title,String description, long userId)
	throws SystemException {
		List<sageCategory> categoriesByTitle = sageCategoryPersistence.findBytitle(title);
		sageCategory category = categoriesByTitle.get(0);
		
		category.setDescription(description);
		category.setUserId(userId);
		
		category.setModifiedDate(new Date());
		
		return sageCategoryPersistence.update(category, false);
	}
}