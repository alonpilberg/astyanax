/*******************************************************************************
 * Copyright 2011 Netflix
 * 
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * 
 *   http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 ******************************************************************************/
package com.netflix.astyanax.connectionpool;

import java.util.concurrent.TimeUnit;

public interface OperationResult<R> {
    /**
     * Get the host on which the operation was performed
     * 
     * @return
     */
    Host getHost();

    /**
     * Get the result data
     * 
     * @return
     */
    R getResult();

    /**
     * Return the length of time to perform the operation. Does not include
     * connection pool overhead. This time is in nanoseconds
     * 
     * @return
     */
    long getLatency();

    /**
     * Return the length of time to perform the operation. Does not include
     * connection pool overhead.
     * 
     * @param units
     * @return
     */
    long getLatency(TimeUnit units);

    /**
     * Return the number of times the operation had to be retried. This includes
     * retries for aborted connections.
     * 
     * @return
     */
    int getAttemptsCount();

    /**
     * Set the number of attempts executing this connection
     * 
     * @param count
     */
    void setAttemptsCount(int count);
}
