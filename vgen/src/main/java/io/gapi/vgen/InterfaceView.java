/* Copyright 2016 Google Inc
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
package io.gapi.vgen;

import com.google.api.tools.framework.model.Interface;
import com.google.api.tools.framework.model.Model;

import java.util.ArrayList;

/**
 * An interface-based view of model, consisting of a strategy for getting the interfaces of the
 * model.
 */
public class InterfaceView implements InputElementView<Interface> {

  /**
   * Gets the reachable interfaces of the model.
   */
  @Override
  public Iterable<Interface> getElementIterable(Model model) {
    ArrayList<Interface> interfaces = new ArrayList<>();
    for (Interface iface : model.getSymbolTable().getInterfaces()) {
      if (iface.isReachable()) {
        interfaces.add(iface);
      }
    }
    return interfaces;
  }
}