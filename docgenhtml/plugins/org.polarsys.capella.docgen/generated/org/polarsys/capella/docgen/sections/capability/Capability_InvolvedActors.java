//Generated with EGF 1.6.2.202001031546
package org.polarsys.capella.docgen.sections.capability;

import java.util.*;
import org.eclipse.egf.model.pattern.*;
import org.eclipse.egf.pattern.execution.*;
import org.eclipse.egf.pattern.query.*;
import org.polarsys.capella.core.data.ctx.Capability;
import org.polarsys.capella.docgen.util.pattern.helper.CapellaCapabilityHelper;

public class Capability_InvolvedActors {
	protected static String nl;

	public static synchronized Capability_InvolvedActors create(String lineSeparator) {
		nl = lineSeparator;
		Capability_InvolvedActors result = new Capability_InvolvedActors();
		nl = null;
		return result;
	}

	public final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
	protected final String TEXT_1 = "";
	protected final String TEXT_2 = NL;

	public Capability_InvolvedActors() {
		//Here is the constructor
		StringBuffer stringBuffer = new StringBuffer();

		// add initialisation of the pattern variables (declaration has been already done).

	}

	public String generate(Object argument) throws Exception {
		final StringBuffer stringBuffer = new StringBuffer();

		InternalPatternContext ctx = (InternalPatternContext) argument;
		Map<String, String> queryCtx = null;
		IQuery.ParameterDescription paramDesc = null;
		Node.Container currentNode = ctx.getNode();

		List<Object> parameterList = null;
		//this pattern can only be called by another (i.e. it's not an entry point in execution)
		List<Object> projectNameParameterList = null;
		//this pattern can only be called by another (i.e. it's not an entry point in execution)
		List<Object> outputFolderParameterList = null;
		//this pattern can only be called by another (i.e. it's not an entry point in execution)

		for (Object parameterParameter : parameterList) {
			for (Object projectNameParameterParameter : projectNameParameterList) {
				for (Object outputFolderParameterParameter : outputFolderParameterList) {

					this.parameter = (org.polarsys.capella.core.data.ctx.Capability) parameterParameter;
					this.projectNameParameter = (java.lang.String) projectNameParameterParameter;
					this.outputFolderParameter = (java.lang.String) outputFolderParameterParameter;

					if (preCondition(ctx)) {
						ctx.setNode(new Node.Container(currentNode, getClass()));
						orchestration(ctx);
					}

				}
			}
		}
		ctx.setNode(currentNode);
		if (ctx.useReporter()) {
			ctx.getReporter().executionFinished(OutputManager.computeExecutionOutput(ctx), ctx);
		}

		stringBuffer.append(TEXT_2);
		stringBuffer.append(TEXT_2);
		return stringBuffer.toString();
	}

	public String orchestration(PatternContext ctx) throws Exception {
		InternalPatternContext ictx = (InternalPatternContext) ctx;

		method_body(new StringBuffer(), ictx);

		if (ictx.useReporter()) {
			Map<String, Object> parameterValues = new HashMap<String, Object>();
			parameterValues.put("parameter", this.parameter);
			parameterValues.put("projectNameParameter", this.projectNameParameter);
			parameterValues.put("outputFolderParameter", this.outputFolderParameter);
			String outputWithCallBack = OutputManager.computeLoopOutput(ictx);
			String loop = OutputManager.computeLoopOutputWithoutCallback(ictx);
			ictx.getReporter().loopFinished(loop, outputWithCallBack, ictx, parameterValues);
		}
		return null;
	}

	protected org.polarsys.capella.core.data.ctx.Capability parameter = null;

	public void set_parameter(org.polarsys.capella.core.data.ctx.Capability object) {
		this.parameter = object;
	}

	protected java.lang.String projectNameParameter = null;

	public void set_projectNameParameter(java.lang.String object) {
		this.projectNameParameter = object;
	}

	protected java.lang.String outputFolderParameter = null;

	public void set_outputFolderParameter(java.lang.String object) {
		this.outputFolderParameter = object;
	}

	public Map<String, Object> getParameters() {
		final Map<String, Object> parameters = new HashMap<String, Object>();
		parameters.put("parameter", this.parameter);
		parameters.put("projectNameParameter", this.projectNameParameter);
		parameters.put("outputFolderParameter", this.outputFolderParameter);
		return parameters;
	}

	protected void method_body(final StringBuffer stringBuffer, final PatternContext ctx) throws Exception {

		Collection<String> actors = CapellaCapabilityHelper.INSTANCE.getInvolvedActors(projectNameParameter,
				outputFolderParameter, parameter);
		if (actors.size() > 0) {
			String title = "Involved Actors";
			Integer level = 2;

			stringBuffer.append(TEXT_1);
			{
				//<%@ egf:patternCall patternId="platform:/plugin/org.polarsys.capella.docgen/egf/HTMLDocGenCapella.fcore#LogicalName=org.polarsys.capella.docgen.sections.display.BuletteListFromStringCollection" args="actors:parameterListParameter, projectNameParameter:projectNameParameter, outputFolderParameter:outputFolderParameter, title:sectionTitleParameter, level:sectionLevelParameter"%>

				InternalPatternContext ictx = (InternalPatternContext) ctx;
				new Node.DataLeaf(ictx.getNode(), getClass(), null, stringBuffer.toString());
				stringBuffer.setLength(0);

				final Map<String, Object> callParameters = new HashMap<String, Object>();
				callParameters.put("parameterListParameter", actors);
				callParameters.put("projectNameParameter", projectNameParameter);
				callParameters.put("outputFolderParameter", outputFolderParameter);
				callParameters.put("sectionTitleParameter", title);
				callParameters.put("sectionLevelParameter", level);
				CallHelper.executeWithParameterInjection(
						"platform:/plugin/org.polarsys.capella.docgen/egf/HTMLDocGenCapella.fcore#_WyRCkKawEeuJhsj8yYqhhw",
						new ExecutionContext((InternalPatternContext) ctx), callParameters);
				stringBuffer.setLength(0);
			}

		}

		InternalPatternContext ictx = (InternalPatternContext) ctx;
		new Node.DataLeaf(ictx.getNode(), getClass(), "body", stringBuffer.toString());
	}

	public boolean preCondition(PatternContext ctx) throws Exception {
		return parameter instanceof Capability;
	}
}