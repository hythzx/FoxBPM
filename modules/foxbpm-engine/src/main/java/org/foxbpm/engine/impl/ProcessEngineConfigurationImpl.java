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
 * @author kenshin
 * @author ych
 */
package org.foxbpm.engine.impl;

import java.io.InputStream;
import java.net.URL;
import java.util.List;
import java.util.Map;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.ecore.xmi.impl.XMIResourceFactoryImpl;
import org.foxbpm.engine.ConnectionManagement;
import org.foxbpm.engine.ProcessEngine;
import org.foxbpm.engine.ProcessEngineConfiguration;
import org.foxbpm.engine.exception.ExceptionCode;
import org.foxbpm.engine.exception.ExceptionI18NCore;
import org.foxbpm.engine.exception.FixFlowClassLoadingException;
import org.foxbpm.engine.impl.util.ReflectUtil;
import org.foxbpm.model.config.foxbpmconfig.FoxBPMConfig;
import org.foxbpm.model.config.foxbpmconfig.FoxBPMConfigPackage;
import org.foxbpm.model.config.foxbpmconfig.ResourcePath;
import org.foxbpm.model.config.foxbpmconfig.ResourcePathConfig;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


public class ProcessEngineConfigurationImpl extends ProcessEngineConfiguration {

	private static Logger log = LoggerFactory.getLogger(ProcessEngineConfigurationImpl.class);
	
	protected FoxBPMConfig foxBpmConfig;
	
	protected ResourcePathConfig resourcePathConfig;
	
	protected ConnectionManagement connectionManagementDefault;
	protected Map<String, ConnectionManagement> connectionManagementMap;
	public ProcessEngine buildProcessEngine() {
		init();
		return new ProcessEngineImpl(this);
	}

	protected void init() {
		initExceptionResource();
		initEmfFile();
//		initRulesConfig();
//		// initSqlMappingFile();
		initResourcePathConfig();
//		initDataVariableConfig();
//		initCommandContextFactory();
//		initCommandExecutors();
//		initConnectionManagementConfig();
//		initServices();
//		initConnection();
//		// initDataBaseTable();
//		initCache();
//		initDeployers();
//		initGroupDefinitions();
//		initDbConfig();// dbType
//		// 任务命令配置加载
//		initTaskCommandConfig();
//
//		initImportDataVariableConfig();
//
//		initQuartz();
//		initUserDefinition();
//		initSysMailConfig();
//		initExpandClassConfig();
//		initEventSubscriptionConfig();
//		initMessageSubscription();
//		initScriptLanguageConfig();
//		initInternationalizationConfig();
//		initFixFlowResources();
//		initPigeonholeConfig();
//		initExpandCmdConfig();
//		initAbstractCommandFilter();
//		initBizData();
//		initPriorityConfig();
//		initAssignPolicyConfig();
//		initThreadPool();

	}
	
	public void initExceptionResource(){
		ExceptionI18NCore.system_init("I18N/exception");
	}
	
	


	protected void initEmfFile() {
		ResourceSet resourceSet = new ResourceSetImpl();
		resourceSet.getResourceFactoryRegistry().getExtensionToFactoryMap().put("xml", new XMIResourceFactoryImpl());
		InputStream inputStream = null;
		String classPath = "config/foxbpm.cfg.xml";
		inputStream = ReflectUtil.getResourceAsStream("foxbpm.cfg.xml");
		if (inputStream != null) {
			classPath = "foxbpm.cfg.xml";
			log.info("开始从classes根目录加载foxbpm.cfg.xml文件");
		}else{
			log.info("开始从classes/config/foxbpm.cfg.xml目录加载foxbpm.cfg.xml文件");
		}
		URL url = this.getClass().getClassLoader().getResource(classPath);
		if(url == null){
			log.error("未能从{}目录下找到foxbpm.cfg.xml文件",classPath);
			throw new FixFlowClassLoadingException(ExceptionCode.CLASSLOAD_EXCEPTION_FILENOTFOUND ,"foxbpm.cfg.xml");
		}
		String filePath = url.toString();
		Resource resource = null;
		try {
			if (!filePath.startsWith("jar")) {
				filePath = java.net.URLDecoder.decode(ReflectUtil.getResource(classPath).getFile(), "utf-8");
				resource = resourceSet.createResource(URI.createFileURI(filePath));
			} else {
				resource = resourceSet.createResource(URI.createURI(filePath));
			}
			resourceSet.getPackageRegistry().put(FoxBPMConfigPackage.eINSTANCE.getNsURI(), FoxBPMConfigPackage.eINSTANCE);
			resource.load(null);
		} catch (Exception e) {
			log.error("fixflowconfig.xml文件加载失败", e);
			throw new FixFlowClassLoadingException(ExceptionCode.CLASSLOAD_EXCEPTION,"fixflowconfig.xml", e);
		}
		
		foxBpmConfig =  (FoxBPMConfig)resource.getContents().get(0);
		
	}
	
	private void initResourcePathConfig(){
		resourcePathConfig = foxBpmConfig.getResourcePathConfig();
	}
	
	public FoxBPMConfig getFoxBpmConfig(){
		return foxBpmConfig;
	}
	
	public String getInternationPath(){
		return getResourcePath("internationalization").getSrc();
	}
	
	public ResourcePath getResourcePath(String resourceId) {
		List<ResourcePath> resourcePaths = this.resourcePathConfig.getResourcePath();
		for (ResourcePath resourcePath : resourcePaths) {
			if (resourcePath.getId().equals(resourceId)) {
				return resourcePath;
			}
		}
		return null;
	}

}
