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
 * 
 * 
 * AssociationSVGFactory
 * 
 * MAENLIANG 2014年7月15日 下午8:11:12
 * 
 * @version 1.0.0
 * 
 */
public class AssociationSVGFactory extends AbstractFlowElementSVGFactory {
	
	public AssociationSVGFactory(KernelBaseElement kernelBaseElement, String svgTemplateFileName) {
		super(kernelBaseElement, svgTemplateFileName);
	}
	@Override
	public VONode createSVGVO(String svgType) {
		return (SvgVO) super.loadSVGVO(voTemplateFileName);
	}
	
	@Override
	public void filterChildVO(VONode voNode, List<String> filterCondition) {
		
	}
	
}