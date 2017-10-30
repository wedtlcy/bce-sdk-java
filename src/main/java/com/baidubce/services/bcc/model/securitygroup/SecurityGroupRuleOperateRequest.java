/*
 * Copyright (c) 2014 Baidu.com, Inc. All Rights Reserved
 *
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not use this file except in compliance with
 * the License. You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software distributed under the License is distributed on
 * an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the License for the
 * specific language governing permissions and limitations under the License.
 */
package com.baidubce.services.bcc.model.securitygroup;

import com.baidubce.auth.BceCredentials;
import com.baidubce.model.AbstractBceRequest;
import com.baidubce.services.bcc.model.SecurityGroupRuleModel;
import com.fasterxml.jackson.annotation.JsonIgnore;

/**
 * request model to authorize security group rule
 */
public class SecurityGroupRuleOperateRequest extends AbstractBceRequest {

    /**
     * An ASCII string whose length is less than 64.
     * The request will be idempotent if client token is provided.
     * If the clientToken is not specified by the user, a random String generated by default algorithm will be used.
     * See more detail at
     * <a href = "https://bce.baidu.com/doc/BCC/API.html#.E5.B9.82.E7.AD.89.E6.80.A7">
     *     BCE API doc</a>
     */
    @JsonIgnore
    private String clientToken;

    /**
     * the id of security group which will be authorized/revoked to
     */
    @JsonIgnore
    private String securityGroupId;

    /**
     * security group rule info
     * through protocol/portRange/direction/sourceIp/sourceGroupId, we can confirmed one rule which will be updated
     */
    private SecurityGroupRuleModel rule;

    public String getClientToken() {
        return clientToken;
    }

    public void setClientToken(String clientToken) {
        this.clientToken = clientToken;
    }

    public SecurityGroupRuleOperateRequest withClientToken(String clientToken) {
        this.clientToken = clientToken;
        return this;
    }

    public String getSecurityGroupId() {
        return securityGroupId;
    }

    public void setSecurityGroupId(String securityGroupId) {
        this.securityGroupId = securityGroupId;
    }

    public SecurityGroupRuleOperateRequest withSecurityGroupId(String securityGroupId) {
        this.securityGroupId = securityGroupId;
        return this;
    }

    public SecurityGroupRuleModel getRule() {
        return rule;
    }

    public void setRule(SecurityGroupRuleModel rule) {
        this.rule = rule;
    }

    public SecurityGroupRuleOperateRequest withRule(SecurityGroupRuleModel rule) {
        this.rule = rule;
        return this;
    }

    @Override
    public SecurityGroupRuleOperateRequest withRequestCredentials(BceCredentials credentials) {
        this.setRequestCredentials(credentials);
        return this;
    }
}