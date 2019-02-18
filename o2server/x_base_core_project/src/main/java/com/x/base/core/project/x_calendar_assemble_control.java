package com.x.base.core.project;

import com.x.base.core.entity.StorageType;
import com.x.base.core.project.annotation.Module;
import com.x.base.core.project.annotation.ModuleCategory;
import com.x.base.core.project.annotation.ModuleType;

@Module(type = ModuleType.ASSEMBLE, category = ModuleCategory.OFFICIAL, name = "日程管理")
public class x_calendar_assemble_control extends AssembleA {

	public x_calendar_assemble_control() {
		super();
		dependency.containerEntities.add("com.x.calendar.core.entity.Calendar");
		dependency.containerEntities.add("com.x.calendar.core.entity.Calendar_Event");
		dependency.containerEntities.add("com.x.calendar.core.entity.Calendar_EventRepeatMaster");
		dependency.containerEntities.add("com.x.calendar.core.entity.Calendar_Setting");
		dependency.containerEntities.add("com.x.calendar.core.entity.Calendar_SettingLobValue");
		dependency.storageTypes.add(StorageType.calendar.toString());
		dependency.storeJars.add(x_organization_core_express.class.getSimpleName());
		dependency.storeJars.add(x_organization_core_entity.class.getSimpleName());
		dependency.storeJars.add(x_calendar_core_entity.class.getSimpleName());
	}
}
