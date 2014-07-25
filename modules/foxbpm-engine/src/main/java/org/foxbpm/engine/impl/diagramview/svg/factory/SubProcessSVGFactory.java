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
 * @author MAENLIANG
 */
package org.foxbpm.engine.impl.diagramview.svg.factory;

import java.util.List;

import org.foxbpm.engine.impl.diagramview.svg.vo.SvgVO;
import org.foxbpm.engine.impl.diagramview.vo.VONode;
import org.foxbpm.kernel.process.KernelBaseElement;

/**
 * SubProcessSVGFactory 子流程创建工厂
 * 
 * MAENLIANG 2014年7月25日 上午10:52:04
 * 
 * @version 1.0.0
 * 
 */
public class SubProcessSVGFactory extends AbstractFlowElementSVGFactory {
	
	/**
	 * 
	 * 创建一个新的实例 SubProcessSVGFactory.
	 * 
	 * @param kernelBaseElement
	 * @param svgTemplateFileName
	 */
	public SubProcessSVGFactory(KernelBaseElement kernelBaseElement, String svgTemplateFileName) {
		super(kernelBaseElement, svgTemplateFileName);
	}
	
	@Override
	public VONode createSVGVO(String svgType) {
		return (SvgVO) super.loadSVGVO(this.voTemplateFileName);
	}
	
	@Override
	public void filterChildVO(VONode voNode, List<String> filterCondition) {
		// TODO Auto-generated method stub
		
	}
	
}