/*
 * Copyright [2020] [hogae.com]
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
 */

package com.hogae.freamwork.web.api.web;

import com.hogae.freamwork.core.api.model.Model;
import com.hogae.freamwork.web.api.Controller;
import com.hogae.freamwork.web.model.JsonResponse;

public interface UpdateController<K, M extends Model<K>> extends Controller {

    JsonResponse<Void> update(M t);


}
