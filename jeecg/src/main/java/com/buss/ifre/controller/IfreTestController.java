package com.buss.ifre.controller;
import com.buss.ifre.entity.IfreTestEntity;
import com.buss.ifre.service.IfreTestServiceI;
import com.buss.ifre.page.IfreTestPage;
import com.buss.test.entity.IfreTestInfoEntity;
import java.util.ArrayList;
import java.util.List;
import java.text.SimpleDateFormat;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.context.annotation.Scope;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import org.jeecgframework.core.common.controller.BaseController;
import org.jeecgframework.core.common.exception.BusinessException;
import org.jeecgframework.core.common.hibernate.qbc.CriteriaQuery;
import org.jeecgframework.core.common.model.json.AjaxJson;
import org.jeecgframework.core.common.model.json.DataGrid;
import org.jeecgframework.core.constant.Globals;
import org.jeecgframework.core.util.ExceptionUtil;
import org.jeecgframework.core.util.ResourceUtil;
import org.jeecgframework.core.util.StringUtil;
import org.jeecgframework.tag.core.easyui.TagUtil;
import org.jeecgframework.web.system.pojo.base.TSDepart;
import org.jeecgframework.web.system.service.SystemService;
import org.jeecgframework.core.util.MyBeanUtils;
import org.jeecgframework.poi.excel.ExcelImportUtil;
import org.jeecgframework.poi.excel.entity.ExportParams;
import org.jeecgframework.poi.excel.entity.ImportParams;
import org.jeecgframework.poi.excel.entity.vo.NormalExcelConstants;
import org.springframework.ui.ModelMap;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import java.io.IOException;
import java.util.Map;
/**   
 * @Title: Controller
 * @Description: test
 * @author onlineGenerator
 * @date 2016-02-19 17:24:25
 * @version V1.0   
 *
 */
@Scope("prototype") 
@Controller
@RequestMapping("/ifreTestController")
public class IfreTestController extends BaseController {
	/**
	 * Logger for this class
	 */
	private static final Logger logger = Logger.getLogger(IfreTestController.class);

	@Autowired
	private IfreTestServiceI ifreTestService;
	@Autowired
	private SystemService systemService;
	
	
	


	/**
	 * test列表 页面跳转
	 * 
	 * @return
	 */
	@RequestMapping(params = "list")
	public ModelAndView list(HttpServletRequest request) {
		return new ModelAndView("com/buss/ifre/ifreTestList");
	}

	/**
	 * easyui AJAX请求数据
	 * 
	 * @param request
	 * @param response
	 * @param dataGrid
	 * @param user
	 */

	@RequestMapping(params = "datagrid")
	public void datagrid(IfreTestEntity ifreTest,HttpServletRequest request, HttpServletResponse response, DataGrid dataGrid) {
		CriteriaQuery cq = new CriteriaQuery(IfreTestEntity.class, dataGrid);
		//查询条件组装器
		org.jeecgframework.core.extend.hqlsearch.HqlGenerateUtil.installHql(cq, ifreTest);
		try{
		//自定义追加查询条件
		}catch (Exception e) {
			throw new BusinessException(e.getMessage());
		}
		cq.add();
		this.ifreTestService.getDataGridReturn(cq, true);
		TagUtil.datagrid(response, dataGrid);
	}

	/**
	 * 删除test
	 * 
	 * @return
	 */
	@RequestMapping(params = "doDel")
	@ResponseBody
	public AjaxJson doDel(IfreTestEntity ifreTest, HttpServletRequest request) {
		AjaxJson j = new AjaxJson();
		ifreTest = systemService.getEntity(IfreTestEntity.class, ifreTest.getId());
		String message = "test删除成功";
		try{
			ifreTestService.delMain(ifreTest);
			systemService.addLog(message, Globals.Log_Type_DEL, Globals.Log_Leavel_INFO);
		}catch(Exception e){
			e.printStackTrace();
			message = "test删除失败";
			throw new BusinessException(e.getMessage());
		}
		j.setMsg(message);
		return j;
	}

	/**
	 * 批量删除test
	 * 
	 * @return
	 */
	 @RequestMapping(params = "doBatchDel")
	@ResponseBody
	public AjaxJson doBatchDel(String ids,HttpServletRequest request){
		AjaxJson j = new AjaxJson();
		String message = "test删除成功";
		try{
			for(String id:ids.split(",")){
				IfreTestEntity ifreTest = systemService.getEntity(IfreTestEntity.class,
				id
				);
				ifreTestService.delMain(ifreTest);
				systemService.addLog(message, Globals.Log_Type_DEL, Globals.Log_Leavel_INFO);
			}
		}catch(Exception e){
			e.printStackTrace();
			message = "test删除失败";
			throw new BusinessException(e.getMessage());
		}
		j.setMsg(message);
		return j;
	}

	/**
	 * 添加test
	 * 
	 * @param ids
	 * @return
	 */
	@RequestMapping(params = "doAdd")
	@ResponseBody
	public AjaxJson doAdd(IfreTestEntity ifreTest,IfreTestPage ifreTestPage, HttpServletRequest request) {
		List<IfreTestInfoEntity> ifreTestInfoList =  ifreTestPage.getIfreTestInfoList();
		AjaxJson j = new AjaxJson();
		String message = "添加成功";
		try{
			ifreTestService.addMain(ifreTest, ifreTestInfoList);
			systemService.addLog(message, Globals.Log_Type_INSERT, Globals.Log_Leavel_INFO);
		}catch(Exception e){
			e.printStackTrace();
			message = "test添加失败";
			throw new BusinessException(e.getMessage());
		}
		j.setMsg(message);
		return j;
	}
	/**
	 * 更新test
	 * 
	 * @param ids
	 * @return
	 */
	@RequestMapping(params = "doUpdate")
	@ResponseBody
	public AjaxJson doUpdate(IfreTestEntity ifreTest,IfreTestPage ifreTestPage, HttpServletRequest request) {
		List<IfreTestInfoEntity> ifreTestInfoList =  ifreTestPage.getIfreTestInfoList();
		AjaxJson j = new AjaxJson();
		String message = "更新成功";
		try{
			ifreTestService.updateMain(ifreTest, ifreTestInfoList);
			systemService.addLog(message, Globals.Log_Type_UPDATE, Globals.Log_Leavel_INFO);
		}catch(Exception e){
			e.printStackTrace();
			message = "更新test失败";
			throw new BusinessException(e.getMessage());
		}
		j.setMsg(message);
		return j;
	}

	/**
	 * test新增页面跳转
	 * 
	 * @return
	 */
	@RequestMapping(params = "goAdd")
	public ModelAndView goAdd(IfreTestEntity ifreTest, HttpServletRequest req) {
		if (StringUtil.isNotEmpty(ifreTest.getId())) {
			ifreTest = ifreTestService.getEntity(IfreTestEntity.class, ifreTest.getId());
			req.setAttribute("ifreTestPage", ifreTest);
		}
		return new ModelAndView("com/buss/ifre/ifreTest-add");
	}
	
	/**
	 * test编辑页面跳转
	 * 
	 * @return
	 */
	@RequestMapping(params = "goUpdate")
	public ModelAndView goUpdate(IfreTestEntity ifreTest, HttpServletRequest req) {
		if (StringUtil.isNotEmpty(ifreTest.getId())) {
			ifreTest = ifreTestService.getEntity(IfreTestEntity.class, ifreTest.getId());
			req.setAttribute("ifreTestPage", ifreTest);
		}
		return new ModelAndView("com/buss/ifre/ifreTest-update");
	}
	
	
	/**
	 * 加载明细列表[cs]
	 * 
	 * @return
	 */
	@RequestMapping(params = "ifreTestInfoList")
	public ModelAndView ifreTestInfoList(IfreTestEntity ifreTest, HttpServletRequest req) {
	
		//===================================================================================
		//获取参数
		Object id0 = ifreTest.getId();
		//===================================================================================
		//查询-cs
	    String hql0 = "from IfreTestInfoEntity where 1 = 1 AND i_ID = ? ";
	    try{
	    	List<IfreTestInfoEntity> ifreTestInfoEntityList = systemService.findHql(hql0,id0);
			req.setAttribute("ifreTestInfoList", ifreTestInfoEntityList);
		}catch(Exception e){
			logger.info(e.getMessage());
		}
		return new ModelAndView("com/buss/test/ifreTestInfoList");
	}

    /**
    * 导出excel
    *
    * @param request
    * @param response
    */
    @RequestMapping(params = "exportXls")
    public String exportXls(IfreTestEntity ifreTest,HttpServletRequest request, HttpServletResponse response, DataGrid dataGrid,ModelMap map) {
    	CriteriaQuery cq = new CriteriaQuery(IfreTestEntity.class, dataGrid);
    	//查询条件组装器
    	org.jeecgframework.core.extend.hqlsearch.HqlGenerateUtil.installHql(cq, ifreTest);
    	try{
    	//自定义追加查询条件
    	}catch (Exception e) {
    		throw new BusinessException(e.getMessage());
    	}
    	cq.add();
    	List<IfreTestEntity> list=this.ifreTestService.getListByCriteriaQuery(cq, false);
    	List<IfreTestPage> pageList=new ArrayList<IfreTestPage>();
        if(list!=null&&list.size()>0){
        	for(IfreTestEntity entity:list){
        		try{
        		IfreTestPage page=new IfreTestPage();
        		   MyBeanUtils.copyBeanNotNull2Bean(entity,page);
            	    Object id0 = entity.getId();
				    String hql0 = "from IfreTestInfoEntity where 1 = 1 AND i_ID = ? ";
        	        List<IfreTestInfoEntity> ifreTestInfoEntityList = systemService.findHql(hql0,id0);
            		page.setIfreTestInfoList(ifreTestInfoEntityList);
            		pageList.add(page);
            	}catch(Exception e){
            		logger.info(e.getMessage());
            	}
            }
        }
        map.put(NormalExcelConstants.FILE_NAME,"test");
        map.put(NormalExcelConstants.CLASS,IfreTestPage.class);
        map.put(NormalExcelConstants.PARAMS,new ExportParams("test列表", "导出人:Jeecg",
            "导出信息"));
        map.put(NormalExcelConstants.DATA_LIST,pageList);
        return NormalExcelConstants.JEECG_EXCEL_VIEW;
	}

    /**
	 * 通过excel导入数据
	 * @param request
	 * @param
	 * @return
	 */
	@RequestMapping(params = "importExcel", method = RequestMethod.POST)
	@ResponseBody
	public AjaxJson importExcel(HttpServletRequest request, HttpServletResponse response) {
		AjaxJson j = new AjaxJson();
		MultipartHttpServletRequest multipartRequest = (MultipartHttpServletRequest) request;
		Map<String, MultipartFile> fileMap = multipartRequest.getFileMap();
		for (Map.Entry<String, MultipartFile> entity : fileMap.entrySet()) {
			MultipartFile file = entity.getValue();// 获取上传文件对象
			ImportParams params = new ImportParams();
			params.setTitleRows(2);
			params.setHeadRows(2);
			params.setNeedSave(true);
			try {
				List<IfreTestPage> list =  ExcelImportUtil.importExcel(file.getInputStream(), IfreTestPage.class, params);
				IfreTestEntity entity1=null;
				for (IfreTestPage page : list) {
					entity1=new IfreTestEntity();
					MyBeanUtils.copyBeanNotNull2Bean(page,entity1);
		            ifreTestService.addMain(entity1, page.getIfreTestInfoList());
				}
				j.setMsg("文件导入成功！");
			} catch (Exception e) {
				j.setMsg("文件导入失败！");
				logger.error(ExceptionUtil.getExceptionMessage(e));
			}finally{
				try {
					file.getInputStream().close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			}
			return j;
	}
	/**
	* 导出excel 使模板
	*/
	@RequestMapping(params = "exportXlsByT")
	public String exportXlsByT(ModelMap map) {
		map.put(NormalExcelConstants.FILE_NAME,"test");
		map.put(NormalExcelConstants.CLASS,IfreTestPage.class);
		map.put(NormalExcelConstants.PARAMS,new ExportParams("test列表", "导出人:"+ ResourceUtil.getSessionUserName().getRealName(),
		"导出信息"));
		map.put(NormalExcelConstants.DATA_LIST,new ArrayList());
		return NormalExcelConstants.JEECG_EXCEL_VIEW;
	}
	/**
	* 导入功能跳转
	*
	* @return
	*/
	@RequestMapping(params = "upload")
	public ModelAndView upload(HttpServletRequest req) {
		req.setAttribute("controller_name", "ifreTestController");
		return new ModelAndView("common/upload/pub_excel_upload");
	}

}
