/*
 * Copyright (C) 2017 Julien Viet
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 *
 */

package io.vertx.sqlclient.impl.command;

import io.vertx.core.Handler;
import io.vertx.sqlclient.impl.PreparedStatement;

import java.util.List;

public class PrepareStatementCommand extends CommandBase<PreparedStatement> {

  private final String sql;
  private final boolean cached;
  private final List<Class<?>> parameterTypes;

  public PrepareStatementCommand(String sql, boolean cached) {
    this(sql, cached, null);
  }

  public PrepareStatementCommand(String sql, boolean cached, List<Class<?>> parameterTypes) {
    this.sql = sql;
    this.cached = cached;
    this.parameterTypes = parameterTypes;
  }

  public String sql() {
    return sql;
  }

  /**
   * @return the list of the prepared statement parameter types or {@code null} when they are not yet determined.
   */
  public List<Class<?>> parameterTypes() {
    return parameterTypes;
  }

  /**
   * Indicate whether the prepared statement will be cached or not.
   *
   * When a prepared statement is not cached it will be valid only for a single execution and should
   * be disposed after the prepared statement has been executed.
   */
  public boolean isCached() {
    return cached;
  }

}
