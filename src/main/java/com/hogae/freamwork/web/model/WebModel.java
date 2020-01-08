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

package com.hogae.freamwork.web.model;

import com.hogae.freamwork.core.api.model.Model;
import com.hogae.freamwork.web.validator.KeyCheck;
import lombok.Data;

import javax.validation.constraints.NotNull;
import java.util.Date;

@Data
public class WebModel<K> implements Model<K> {

    @NotNull(groups = KeyCheck.class)
    public K key;

    public Date createTime;

    public Date updateTime;

    public Date getCreateTime() {
        if (createTime == null) return new Date();
        return createTime;
    }

    public Date getUpdateTime() {
        if (updateTime == null) return new Date();
        return updateTime;
    }
}
