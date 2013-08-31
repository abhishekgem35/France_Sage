package com.sage.ideatool.portlet;


import java.util.Date;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;

import com.sage.ideatool.model.sageCategory;
import com.sage.ideatool.service.sageCategoryLocalServiceUtil;

import org.apache.log4j.Logger;

import com.liferay.portal.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.WebKeys;
import com.liferay.util.bridges.mvc.MVCPortlet;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.model.User;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.counter.service.CounterLocalServiceUtil;

public class IdeaToolPortlet extends MVCPortlet{

	private static Logger s_log = Logger.getLogger(IdeaToolPortlet.class);
	
	protected String viewMastersJSP = "/masters/view.jsp";
	
	protected String addCategoryJSP = "/categories/view_add_category.jsp";
	protected String viewCategoryJSP = "/categories/view.jsp";
	
	public void addCategoryInfo(ActionRequest request, ActionResponse response) throws Exception
	{
		try
		{
			s_log.debug("addCategory: Starting");
			
			ThemeDisplay themeDisplay = (ThemeDisplay) request.getAttribute(WebKeys.THEME_DISPLAY);
			sageCategory objSageCategoryInfo = ActionUtil.getInitialSageCategoryObject(request, themeDisplay);
			
			request.setAttribute("sageCategoryInfo", objSageCategoryInfo);
			response.setRenderParameter("jspPage", addCategoryJSP);
			request.setAttribute("mode", "add");
		
			s_log.debug("addCategory: Done");
		}
		catch(Exception excep)
		{
			s_log.error("addDenominationInfo: Exception - ", excep);
			throw excep;
		}
		
	}
	 public void addCategoryInfoToDB (ActionRequest request, ActionResponse response) throws Exception 
	    {
			try
			{
				s_log.debug("IdeaToolPortlet -- addCategoryInfoToDB: Starting");
				ThemeDisplay themeDisplay = (ThemeDisplay) request.getAttribute(WebKeys.THEME_DISPLAY);
				sageCategory objSageCategoryInfo = ActionUtil.getInitialSageCategoryObject(request, themeDisplay);
				
				objSageCategoryInfo.setCategoryId(CounterLocalServiceUtil.increment(sageCategory.class.getName()));
				
				objSageCategoryInfo.setCompanyId(themeDisplay.getCompanyId());
				objSageCategoryInfo.setGroupId(themeDisplay.getScopeGroupId());
				//TODO: Validations Pending
				objSageCategoryInfo.setTitle(ParamUtil.getString(request, "categoryTitle"));
				
			    objSageCategoryInfo.setDescription(ParamUtil.getString(request, "categoryDescription"));
			    
			    User user = themeDisplay.getUser();
			    objSageCategoryInfo.setUserId(user.getUserId());
			    objSageCategoryInfo.setUserName(user.getScreenName());
			    
			    objSageCategoryInfo.setCreateDate(new Date());
			    objSageCategoryInfo.setModifiedDate(new Date());
			    
			    sageCategoryLocalServiceUtil.addsageCategory(objSageCategoryInfo);
			    response.setRenderParameter("jspPage", viewMastersJSP);
				s_log.debug("addCategoryInfoToDB: Done");
			}
			catch(Exception excep)
			{
				s_log.error("addCategoryInfoToDB: Exception - ", excep);
				throw excep;
			}
	    }   

	    public void editCategoryInfo(ActionRequest request, ActionResponse response) throws Exception 
		{
			try
			{
				int sageCatTitleKey = ParamUtil.getInteger(request, "resourcePrimKey");
			
				if (Validator.isNotNull(sageCatTitleKey)) {
					sageCategory objSageCategoryInfo =
						sageCategoryLocalServiceUtil.getsageCategory(sageCatTitleKey);
					request.setAttribute("sageCategoryInfo", objSageCategoryInfo);
					response.setRenderParameter("jspPage", addCategoryJSP);
					request.setAttribute("mode", "edit");
				}
					
				s_log.debug("editCategoryInfo: Done");
			}
			catch(Exception excep)
			{
				s_log.error("editCategoryInfo: Exception - ", excep);
				throw excep;
			}
		}
	    
	   	public void updateCategoryToDB(ActionRequest request, ActionResponse response) throws Exception 
		{
			try
			{
				long categoryId = ParamUtil.getLong(request, "sageCategoryId");
				sageCategory oCategoryInfo = sageCategoryLocalServiceUtil.getsageCategory(categoryId);
				//TODO: Validations Pending
				oCategoryInfo.setTitle(ParamUtil.getString(request, "categoryTitle"));
				oCategoryInfo.setDescription(ParamUtil.getString(request, "categoryDescription"));
				
				ThemeDisplay themeDisplay = (ThemeDisplay) request.getAttribute(WebKeys.THEME_DISPLAY);
				User user = themeDisplay.getUser();
				oCategoryInfo.setUserId(user.getUserId());
				oCategoryInfo.setUserName(user.getScreenName());
			    
				oCategoryInfo.setModifiedDate(new Date());
				sageCategoryLocalServiceUtil.updatesageCategory(oCategoryInfo);
			    
//				ArrayList<String> errors = new ArrayList();
//				ThemeDisplay themeDisplay = (ThemeDisplay)request.getAttribute(WebKeys.THEME_DISPLAY);
//				int langTitleKey = oDenominationInfo.getDenominationID();
//				
//				String tabsName = String.valueOf(request.getParameter("tabs1"));
//				response.setRenderParameter("tabs1", tabsName);
//				
//				if (InputValidator.validateDenominations(oDenominationInfo, errors)) 
//				{
//					oDenominationInfo.setDenominationID(langTitleKey);
//					DenominationInfoLocalServiceUtil.updateDenominationInfo(oDenominationInfo);
//					SessionMessages.add(request, "denomination-updated-successfully");
//					response.setRenderParameter("jspPage", viewJSP);
//				}
//				else 
//				{
//					for (String error : errors)
//					{
//						SessionErrors.add(request, error);
//					}
//					SessionErrors.add(request, "error-saving-denomination");
//					response.setRenderParameter("jspPage", addDenominationJSP);
//					request.setAttribute("DenominationInfo", oDenominationInfo);
//					request.setAttribute("mode", "edit");
//				}
					
				s_log.debug("updateCategoryToDB: Done");
			}
			catch(Exception excep)
			{
				s_log.error("updateCategoryToDB: Exception - ", excep);
				throw excep;
			}
		}
	   	
	    public void deleteCategoryInfo(ActionRequest request, ActionResponse response) throws Exception 
		{
			try
			{
				int sageCatTitleKey = ParamUtil.getInteger(request, "resourcePrimKey");
				
				if (Validator.isNotNull(sageCatTitleKey)) {
					sageCategory objSageCategoryInfo =
						sageCategoryLocalServiceUtil.deletesageCategory(sageCatTitleKey);
					request.setAttribute("sageCategoryInfo", objSageCategoryInfo);
					response.setRenderParameter("jspPage", viewCategoryJSP);
					request.setAttribute("tabs1", "Categories");
				}
					
				s_log.debug("deleteCategoryInfo: Done");
			}
			catch(Exception excep)
			{
				s_log.error("deleteCategoryInfo: Exception - ", excep);
				throw excep;
			}
		}
	   	
}
