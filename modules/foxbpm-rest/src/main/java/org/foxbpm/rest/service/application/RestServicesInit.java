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
 * @author ych
 */
package org.foxbpm.rest.service.application;

import org.foxbpm.rest.service.api.config.FlowConfigResouce;
import org.foxbpm.rest.service.api.engine.RollbackNodeCollectionResource;
import org.foxbpm.rest.service.api.engine.RollbackTaskCollectionResource;
import org.foxbpm.rest.service.api.engine.TaskCommandCollectionResource;
import org.foxbpm.rest.service.api.identity.GroupCollectionResouce;
import org.foxbpm.rest.service.api.identity.GroupDefinitionCollection;
import org.foxbpm.rest.service.api.identity.GroupRelationCollectionResouce;
import org.foxbpm.rest.service.api.identity.UserCollectionResouce;
import org.foxbpm.rest.service.api.model.BizDataObjectResouce;
import org.foxbpm.rest.service.api.model.DeploymentCollectionResource;
import org.foxbpm.rest.service.api.model.DeploymentResource;
import org.foxbpm.rest.service.api.model.ModelsResouce;
import org.foxbpm.rest.service.api.model.ProcessDefinitionCollectionResouce;
import org.foxbpm.rest.service.api.model.ProcessDefinitionResouce;
import org.foxbpm.rest.service.api.model.ResourceResource;
import org.foxbpm.rest.service.api.model.VariableDefinitonResouces;
import org.foxbpm.rest.service.api.task.FlowGraphicImgResource;
import org.foxbpm.rest.service.api.task.TaskInforResource;
import org.foxbpm.rest.service.api.task.TaskRunTrackResource;
import org.foxbpm.rest.service.designer.TestConnectionResource;
import org.restlet.routing.Router;

/**
 * foxbpm 的资源初始化服务
 * 
 * @author ych
 */
public class RestServicesInit {
	
	public static void attachResources(Router router) {
		
		//设计器测试是否网络连通
		router.attach("/testConnection", TestConnectionResource.class);
		
		router.attach("/models", ModelsResouce.class);
		router.attach("/model/deployments", DeploymentCollectionResource.class);
		router.attach("/model/deployment/{deploymentId}", DeploymentResource.class);
		router.attach("/model/resource/{deploymentId}/{resourceName}", ResourceResource.class);
		
		router.attach("/process-definitions", ProcessDefinitionCollectionResouce.class);
		router.attach("/process-definition/{processDefinitionId}", ProcessDefinitionResouce.class);
		router.attach("/variable-definition/{key}/{version}/variables", VariableDefinitonResouces.class);
		router.attach("/flowconfig", FlowConfigResouce.class);
		router.attach("/bizDataObjects/{behaviorId}/{dataSource}", BizDataObjectResouce.class);
		
		router.attach("/identity/allGroups", GroupCollectionResouce.class);
		router.attach("/identity/allRelations", GroupRelationCollectionResouce.class);
		router.attach("/identity/allUsers", UserCollectionResouce.class);
		router.attach("/identity/allGroupDefinitions", GroupDefinitionCollection.class);
		
		router.attach("/task/taskCommands", TaskCommandCollectionResource.class);
		/***********************************详细页面*******************************************************/
		//type all,endData,notEnd
		router.attach("/task/taskInfor", TaskInforResource.class);
		router.attach("/task/runTrack", TaskRunTrackResource.class);
		router.attach("/flowGraphic/flowImg", FlowGraphicImgResource.class);
		router.attach("/task/rollbackTasks", RollbackTaskCollectionResource.class);
		router.attach("/flowNode/rollbackNodes", RollbackNodeCollectionResource.class);
	}
}
