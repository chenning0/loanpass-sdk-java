// Copyright 2021 YouLand Inc. (youland.com)
//
// Licensed under the Apache License, Version 2.0 (the "License");
// you may not use this file except in compliance with the License.
// You may obtain a copy of the License at
//
//      http://www.apache.org/licenses/LICENSE-2.0
//
// Unless required by applicable law or agreed to in writing, software
// distributed under the License is distributed on an "AS IS" BASIS,
// WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
// See the License for the specific language governing permissions and
// limitations under the License.

package com.youland.vendor.loanpass.converter;

import com.youland.lib.core.JsonUtil;
import com.youland.vendor.loanpass.converter.Obj2FieldValueMappingTest.AnnotatedInput;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class FieldValueMapping2ObjTest {
    @Test
    void test_convert_Ok() {
        //Arrange
        var source = new AnnotatedInput();
        var fields = Obj2FieldValueMappingTest.CreateFields(source);

        //Action
        AnnotatedInput result
                = FieldValueMapping2Obj.create(fields, AnnotatedInput.class);

        //Assert
        String sourceJson = JsonUtil.stringify(source);
        String resultJson = JsonUtil.stringify(result);

        System.out.println(sourceJson);
        System.out.println(resultJson);

        Assertions.assertNotNull(result);
        Assertions.assertEquals(sourceJson, resultJson);
    }
}