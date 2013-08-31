package com.sage.ideatool.portlet;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import javax.portlet.ActionRequest;
import javax.portlet.RenderRequest;

import org.apache.log4j.Logger;

import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.theme.ThemeDisplay;

import com.sage.ideatool.model.sageCategory;
import com.sage.ideatool.model.impl.sageCategoryImpl;
import com.sage.ideatool.service.sageCategoryLocalServiceUtil;
public class ActionUtil {
	private static Logger s_log = Logger.getLogger(ActionUtil.class);
	
	public static List<sageCategory> getSageCategories(RenderRequest request)
	{
		List<sageCategory> sageCategories = new ArrayList<sageCategory>();
		try {
			sageCategories = sageCategoryLocalServiceUtil.getsageCategories(-1, -1);
		} catch (SystemException ex) {
			s_log.error("ActionUtil -> getSageCategories: Exception - " , ex);		
			sageCategories  = Collections.emptyList();
		}
		return sageCategories;
	}
	
	public static sageCategory getInitialSageCategoryObject(ActionRequest request, ThemeDisplay themeDisplay)
	{
		sageCategory oSageCategory = null;
		oSageCategory = new sageCategoryImpl();
		
		return oSageCategory;
	}
}
