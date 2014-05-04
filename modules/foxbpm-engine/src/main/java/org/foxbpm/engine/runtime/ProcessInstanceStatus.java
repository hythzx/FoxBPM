/**
 * Copyright 1996-2014 FoxBPM Co.,Ltd.
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
 */
package org.foxbpm.engine.runtime;

/**
 * 流程实例状态
 * 
 * @author kenshin
 * 
 */
public class ProcessInstanceStatus {

	/**
	 * 运行中
	 */
	public static final String RUNNING = "running";

	/**
	 * 暂停
	 */
	public static final String SUSPEND = "suspend";

	/**
	 * 终止
	 */
	public static final String TERMINATION = "termination";

	/**
	 * 正常结束
	 */
	public static final String COMPLETE = "complete";

}