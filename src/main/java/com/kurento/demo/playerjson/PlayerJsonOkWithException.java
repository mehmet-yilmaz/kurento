/*
 * (C) Copyright 2013 Kurento (http://kurento.org/)
 *
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the GNU Lesser General Public License
 * (LGPL) version 2.1 which accompanies this distribution, and is available at
 * http://www.gnu.org/licenses/lgpl-2.1.html
 *
 * This library is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the GNU
 * Lesser General Public License for more details.
 *
 */
package com.kurento.demo.playerjson;

import com.kurento.demo.internal.EventListener;
import com.kurento.demo.internal.VideoURLs;
import com.kurento.kmf.content.ContentCommand;
import com.kurento.kmf.content.ContentCommandResult;
import com.kurento.kmf.content.HttpPlayerHandler;
import com.kurento.kmf.content.HttpPlayerService;
import com.kurento.kmf.content.HttpPlayerSession;

/**
 * HTTP Player Handler; tunnel strategy; JSON control protocol; in
 * onContentRequest method an exception is raised, then in onUncaughtException
 * this exception is handled and a MP4 video media is started.
 * 
 * @author Boni García (bgarcia@gsyc.es)
 * @since 1.0.0
 */
@HttpPlayerService(path = "/playerFlowOkWithExcp", redirect = false, useControlProtocol = true)
public class PlayerJsonOkWithException extends HttpPlayerHandler {

	@Override
	public void onContentRequest(final HttpPlayerSession contentSession)
			throws Exception {
		EventListener.clearEventList();
		EventListener.addEvent();

		throw new Exception();
	}

	@Override
	public void onContentStarted(HttpPlayerSession contentSession)
			throws Exception {
		EventListener.addEvent();
		super.onContentStarted(contentSession);
	}

	@Override
	public void onSessionTerminated(HttpPlayerSession contentSession, int code,
			String reason) throws Exception {
		EventListener.addEvent();
		super.onSessionTerminated(contentSession, code, reason);
	}

	@Override
	public ContentCommandResult onContentCommand(
			HttpPlayerSession contentSession, ContentCommand contentCommand)
			throws Exception {
		EventListener.addEvent();
		return super.onContentCommand(contentSession, contentCommand);
	}

	@Override
	public void onSessionError(HttpPlayerSession contentSession, int code,
			String description) throws Exception {
		EventListener.addEvent();
		super.onSessionError(contentSession, code, description);
	}

	@Override
	public void onUncaughtException(HttpPlayerSession contentSession,
			Throwable exception) throws Exception {
		EventListener.addEvent();
		contentSession.start(VideoURLs.map.get("webm"));
	}

}
