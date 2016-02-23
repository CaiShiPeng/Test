package com.buss.ifre.service;
import com.buss.ifre.entity.IfreTestEntity;
import com.buss.test.entity.IfreTestInfoEntity;

import java.util.List;
import org.jeecgframework.core.common.service.CommonService;
import java.io.Serializable;

public interface IfreTestServiceI extends CommonService{
	
 	public <T> void delete(T entity);
	/**
	 * 添加一对多
	 * 
	 */
	public void addMain(IfreTestEntity ifreTest,
	        List<IfreTestInfoEntity> ifreTestInfoList) ;
	/**
	 * 修改一对多
	 * 
	 */
	public void updateMain(IfreTestEntity ifreTest,
	        List<IfreTestInfoEntity> ifreTestInfoList);
	public void delMain (IfreTestEntity ifreTest);
	
 	/**
	 * 默认按钮-sql增强-新增操作
	 * @param id
	 * @return
	 */
 	public boolean doAddSql(IfreTestEntity t);
 	/**
	 * 默认按钮-sql增强-更新操作
	 * @param id
	 * @return
	 */
 	public boolean doUpdateSql(IfreTestEntity t);
 	/**
	 * 默认按钮-sql增强-删除操作
	 * @param id
	 * @return
	 */
 	public boolean doDelSql(IfreTestEntity t);
}
