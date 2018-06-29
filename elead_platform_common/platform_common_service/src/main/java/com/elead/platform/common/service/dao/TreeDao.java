package com.elead.platform.common.service.dao;
import com.elead.platform.common.entity.ELTreeItem;
import java.util.List;

/**
 * DAO支持类实现
 * @author ThinkGem
 * @version 2014-05-16
 * @param <T>
 */
public interface TreeDao<T extends ELTreeItem<T>> extends CrudDao<T> {

	/**
	 * 找到所有子节点
	 *
	 * @param entity
	 * @return
	 */
	List<T> findByParentIdsLike(T entity);

	/**
	 * 更新所有父节点字段
	 *
	 * @param entity
	 * @return
	 */
	int updateParentIds(T entity);
}