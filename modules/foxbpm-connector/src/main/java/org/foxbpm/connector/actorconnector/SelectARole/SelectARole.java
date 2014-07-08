/**
 * Copyright 1996-2014 FoxBPM ORG.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * 
 *      http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 * 
 * @author yangguangftlp
 */
package org.foxbpm.connector.actorconnector.SelectARole;

import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

import org.foxbpm.connector.common.constant.Constants;
import org.foxbpm.engine.Constant;
import org.foxbpm.engine.exception.FoxBPMConnectorException;
import org.foxbpm.engine.impl.connector.ActorConnectorHandler;
import org.foxbpm.engine.impl.util.StringUtil;
import org.foxbpm.engine.task.DelegateTask;
import org.foxbpm.engine.task.IdentityLinkType;

/**
 * 角色选择
 * 
 * @author yangguangftlp
 * @date 2014年7月7日
 */
public class SelectARole extends ActorConnectorHandler {

	/**
	 * 
	 */
	private static final long serialVersionUID = -5466313199990930905L;

	private java.lang.String roleId;

	public void assign(DelegateTask task) throws Exception {
		if (StringUtil.isEmpty(StringUtil.trim(roleId))) {
			throw new FoxBPMConnectorException("roleId is null!");
		}
		// 处理角色重复
		StringTokenizer st = new StringTokenizer(StringUtil.trim(roleId), Constants.COMMA);
		Set<String> roleIdSet = new HashSet<String>();
		while (st.hasMoreTokens()) {
			roleIdSet.add(StringUtil.trim(st.nextToken()));
		}
		// 处理角色
		for (String id : roleIdSet) {
			task.addGroupIdentityLink(id, Constant.ROLE_TYPE, IdentityLinkType.CANDIDATE);
		}
	}

	public void setRoleId(java.lang.String roleId) {
		this.roleId = roleId;
	}

}