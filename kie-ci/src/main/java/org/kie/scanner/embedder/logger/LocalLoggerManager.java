/*
 * Copyright 2017 Red Hat, Inc. and/or its affiliates.
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
 */

package org.kie.scanner.embedder.logger;

import org.codehaus.plexus.logging.BaseLoggerManager;
import org.codehaus.plexus.logging.Logger;
import org.kie.scanner.embedder.MavenRequest;

/**
 * This class enables the consumption of logs generated by the maven infrastructure Mojos when a maven build is
 * launched in embedded mode. The user should create an instance of this class, register a set of desired consumers and
 * set current instance as the LoggerManager for the MavenRequest.
 * @see MavenRequest
 */
public class LocalLoggerManager
        extends BaseLoggerManager {

    private LocalLoggerConsumer consumer;

    public LocalLoggerManager( LocalLoggerConsumer consumer ) {
        this.consumer = consumer;
        initialize();
    }

    @Override
    protected Logger createLogger( String name ) {
        return new LocalLogger( getThreshold(), name, consumer );
    }
}
