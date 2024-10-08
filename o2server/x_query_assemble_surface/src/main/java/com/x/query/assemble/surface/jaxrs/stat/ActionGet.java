package com.x.query.assemble.surface.jaxrs.stat;

import com.x.base.core.container.EntityManagerContainer;
import com.x.base.core.container.factory.EntityManagerContainerFactory;
import com.x.base.core.entity.JpaObject;
import com.x.base.core.project.bean.WrapCopier;
import com.x.base.core.project.bean.WrapCopierFactory;
import com.x.base.core.project.exception.ExceptionAccessDenied;
import com.x.base.core.project.exception.ExceptionEntityNotExist;
import com.x.base.core.project.http.ActionResult;
import com.x.base.core.project.http.EffectivePerson;
import com.x.query.assemble.surface.Business;
import com.x.query.core.entity.Query;
import com.x.query.core.entity.Stat;

class ActionGet extends BaseAction {

	ActionResult<Wo> execute(EffectivePerson effectivePerson, String id) throws Exception {
		try (EntityManagerContainer emc = EntityManagerContainerFactory.instance().create()) {
			Business business = new Business(emc);
			ActionResult<Wo> result = new ActionResult<>();
			Stat stat = business.pick(id, Stat.class);
			if (null == stat) {
				throw new ExceptionEntityNotExist(id, Stat.class);
			}
			Query query = business.pick(stat.getQuery(), Query.class);
			if (null == query) {
				throw new ExceptionEntityNotExist(stat.getQuery(), Query.class);
			}
			if (!business.readable(effectivePerson, stat)) {
				throw new ExceptionAccessDenied(effectivePerson, stat);
			}
			Wo wo = Wo.copier.copy(stat);
			result.setData(wo);
			return result;
		}
	}

	public static class Wo extends Stat {

		private static final long serialVersionUID = -8067704098385000667L;

		/** 不输出data数据,单独处理 */
		static WrapCopier<Stat, Wo> copier = WrapCopierFactory.wo(Stat.class, Wo.class, null,
				JpaObject.FieldsInvisible);
	}
}
