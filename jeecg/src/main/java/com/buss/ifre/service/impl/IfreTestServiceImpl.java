package com.buss.ifre.service.impl;
import com.buss.ifre.service.IfreTestServiceI;
import org.jeecgframework.core.common.service.impl.CommonServiceImpl;
import com.buss.ifre.entity.IfreTestEntity;
import com.buss.test.entity.IfreTestInfoEntity;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;
import org.jeecgframework.core.common.exception.BusinessException;
import org.jeecgframework.core.common.service.impl.CommonServiceImpl;
import org.jeecgframework.core.util.MyBeanUtils;
import org.jeecgframework.core.util.StringUtil;
import org.jeecgframework.core.util.oConvertUtils;
import java.util.ArrayList;
import java.util.UUID;
import java.io.Serializable;


@Service("ifreTestService")
@Transactional
public class IfreTestServiceImpl extends CommonServiceImpl implements IfreTestServiceI {
	
 	public <T> void delete(T entity) {
 		super.delete(entity);
 		//执行删除操作配置的sql增强
		this.doDelSql((IfreTestEntity)entity);
 	}
	
	public void addMain(IfreTestEntity ifreTest,
	        List<IfreTestInfoEntity> ifreTestInfoList){
			//保存主信息
			this.save(ifreTest);
		
			/**保存-cs*/
			for(IfreTestInfoEntity ifreTestInfo:ifreTestInfoList){
				//外键设置
				ifreTestInfo.setIId(ifreTest.getId());
				this.save(ifreTestInfo);
			}
			//执行新增操作配置的sql增强
 			this.doAddSql(ifreTest);
	}

	
	public void updateMain(IfreTestEntity ifreTest,
	        List<IfreTestInfoEntity> ifreTestInfoList) {
		//保存主表信息
		this.saveOrUpdate(ifreTest);
		//===================================================================================
		//获取参数
		Object id0 = ifreTest.getId();
		//===================================================================================
		//1.查询出数据库的明细数据-cs
	    String hql0 = "from IfreTestInfoEntity where 1 = 1 AND i_ID = ? ";
	    List<IfreTestInfoEntity> ifreTestInfoOldList = this.findHql(hql0,id0);
		//2.筛选更新明细数据-cs
		for(IfreTestInfoEntity oldE:ifreTestInfoOldList){
			boolean isUpdate = false;
				for(IfreTestInfoEntity sendE:ifreTestInfoList){
					//需要更新的明细数据-cs
					if(oldE.getId().equals(sendE.getId())){
		    			try {
							MyBeanUtils.copyBeanNotNull2Bean(sendE,oldE);
							this.saveOrUpdate(oldE);
						} catch (Exception e) {
							e.printStackTrace();
							throw new BusinessException(e.getMessage());
						}
						isUpdate= true;
		    			break;
		    		}
		    	}
	    		if(!isUpdate){
		    		//如果数据库存在的明细，前台没有传递过来则是删除-cs
		    		super.delete(oldE);
	    		}
	    		
			}
			//3.持久化新增的数据-cs
			for(IfreTestInfoEntity ifreTestInfo:ifreTestInfoList){
				if(oConvertUtils.isEmpty(ifreTestInfo.getId())){
					//外键设置
					ifreTestInfo.setIId(ifreTest.getId());
					this.save(ifreTestInfo);
				}
			}
		//执行更新操作配置的sql增强
 		this.doUpdateSql(ifreTest);
	}

	
	public void delMain(IfreTestEntity ifreTest) {
		//删除主表信息
		this.delete(ifreTest);
		//===================================================================================
		//获取参数
		Object id0 = ifreTest.getId();
		//===================================================================================
		//删除-cs
	    String hql0 = "from IfreTestInfoEntity where 1 = 1 AND i_ID = ? ";
	    List<IfreTestInfoEntity> ifreTestInfoOldList = this.findHql(hql0,id0);
		this.deleteAllEntitie(ifreTestInfoOldList);
	}
	
 	
 	/**
	 * 默认按钮-sql增强-新增操作
	 * @param id
	 * @return
	 */
 	public boolean doAddSql(IfreTestEntity t){
	 	return true;
 	}
 	/**
	 * 默认按钮-sql增强-更新操作
	 * @param id
	 * @return
	 */
 	public boolean doUpdateSql(IfreTestEntity t){
	 	return true;
 	}
 	/**
	 * 默认按钮-sql增强-删除操作
	 * @param id
	 * @return
	 */
 	public boolean doDelSql(IfreTestEntity t){
	 	return true;
 	}
 	
 	/**
	 * 替换sql中的变量
	 * @param sql
	 * @return
	 */
 	public String replaceVal(String sql,IfreTestEntity t){
 		sql  = sql.replace("#{id}",String.valueOf(t.getId()));
 		sql  = sql.replace("#{update_date}",String.valueOf(t.getUpdateDate()));
 		sql  = sql.replace("#{name}",String.valueOf(t.getName()));
 		sql  = sql.replace("#{pwd}",String.valueOf(t.getPwd()));
 		sql  = sql.replace("#{t}",String.valueOf(t.getT()));
 		sql  = sql.replace("#{UUID}",UUID.randomUUID().toString());
 		return sql;
 	}
}