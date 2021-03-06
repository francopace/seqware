<%@ include file="/WEB-INF/common/Taglibs.jsp" %>
<c:set var="res" value="" scope="request"/>
<c:set var="laneCnt" value="${fn:length(sample.lanes)}"/>
<c:set var="procCnt" value="${fn:length(sample.processings) + laneCnt}" scope="request"/>

<c:forEach items="${sample.processings}" var="processing">
	<c:set var="procCnt" value="${procCnt - 1}" scope="request"/>
	<c:set var="isOwner" value="false" scope="request"/>
	<c:if test="${registration.registrationId == processing.owner.registrationId || registration.LIMSAdmin}">
		<c:set var="isOwner" value="true" scope="request"/>
	</c:if> 
	<c:set var="node" value="${processing}" scope="request" />
	<c:set var="isLastCollapsable" value="true" scope="request"/>
	<%@ include file="JsonSubnode.jsp" %>
</c:forEach>

<c:forEach items="${sample.lanes}" var="lane">
	<c:set var="laneCnt" value="${laneCnt - 1}"/>
	
	<c:set var="isOwner" value="false"/>
	<c:if test="${registration.registrationId == lane.owner.registrationId || registration.LIMSAdmin}">
		<c:set var="isOwner" value="true"/>
	</c:if>

	<c:set var="liClass" value="collapsable end"/>

	<c:set var="lastClass" value=""/>
	<c:if test="${laneCnt == 0}">
		<c:set var="lastClass" value="lastCollapsable"/>
	</c:if>
	<c:set var="liClass" value="${liClass} ${lastClass}"/>
	
    <c:set var="laneProcessingCnt" value="${lane.processingCnt}"/>
    <c:set var="laneErrorCnt" value="${lane.errorCnt}"/>
    <c:set var="laneProcessedCnt" value="${lane.processedCnt}"/>

	<c:set var="statusesInfo" value=""/>
	<c:if test="${laneProcessingCnt > 0 || laneErrorCnt > 0 || laneProcessedCnt > 0}">
		<c:set var="statusesInfo" value="( ${laneProcessedCnt} successes "/>
		<c:if test="${laneErrorCnt > 0}">
			<c:set var="statusesInfo" value="${statusesInfo}, ${laneErrorCnt} errors "/>
		</c:if>
		<c:if test="${laneProcessingCnt > 0}">
			<c:set var="statusesInfo" value="${statusesInfo}, ${laneProcessingCnt} running"/>
		</c:if>
		<c:set var="statusesInfo" value="${statusesInfo})"/>
	</c:if>

	<c:set var="ownerHtml" value="${registration.registrationId} == ${lane.owner.registrationId} ${isOwner}"/>
	<c:if test="${isOwner}">
		<c:set var="sampleLinksHtml" value="Associated with"/>
		<c:set var="sampleCnt" value="${fn:length(lane.samples)}"/>
		<c:forEach items="${lane.samples}" var="assSample">
			<c:set var="sampleCnt" value="${sampleCnt - 1}"/>
			<c:set var="delimiter" value=""/>
			<c:if test="${sampleCnt > 0}"><c:set var="delimiter" value=","/></c:if>
			<c:set var="sampleLinksHtml" value="${sampleLinksHtml} <a href='sampleSetup.htm?sampleId=${assSample.sampleId}&laneId=${lane.laneId}&tt=${typeTree}' root-id='?' sn='y'> Sample SWID:${assSample.swAccession} ${assSample.jsonEscapeTitle}</a>${delimiter}"/>
		</c:forEach>
		<c:set var="ownerHtml" value="<span class='m-link'><a href='laneSetup.htm?laneId=${lane.laneId}&tt=${typeTree}' root-id='?' sn='y'>edit</a> - <a href='#' popup-delete='true' form-action='laneDelete.htm' tt='${typeTree}' root-id='?' object-id='${lane.laneId}' object-name='${fn:substring(lane.jsonEscapeName, 0, 100)} sequence'>delete</a> - <a href='uploadFileSetup.htm?id=${lane.laneId}&tn=seq' sn='y'>upload file</a> - ${sampleLinksHtml} </span>"/>
	</c:if>

	<c:set var="test" value="<li id='liseq_${lane.laneId}' class='${liClass}'><div class='hitarea hasChildren-hitarea expandable-hitarea' ></div><span id='seq_${lane.laneId}'>Sequence: ${fn:substring(lane.jsonEscapeName, 0, 100)} SWID:${lane.swAccession}${statusesInfo}</span> <span><a class='m-question np-mousetrack supernote-hover-demo1' href='#demo1'><img src='i/ico/ico_question.gif'></a></span> ${ownerHtml}  <span class='m-description'>Description: ${lane.jsonEscapeDescription}</span><ul style='display: none;'></ul></li>"/>
	<c:set var="res" value="${res}${test}"/>

  </c:forEach>
  
({html: [{ "text": "${res}" }] })