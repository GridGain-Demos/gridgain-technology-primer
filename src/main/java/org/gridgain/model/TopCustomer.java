/*
 * Licensed to the Apache Software Foundation (ASF) under one or more
 * contributor license agreements.  See the NOTICE file distributed with
 * this work for additional information regarding copyright ownership.
 * The ASF licenses this file to You under the Apache License, Version 2.0
 * (the "License"); you may not use this file except in compliance with
 * the License.  You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.gridgain.model;

import java.math.BigDecimal;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
@EqualsAndHashCode
public class TopCustomer implements Comparable<TopCustomer>{
    private int customerId;

    private String fullName;

    private String country;

    private String city;

    BigDecimal totalPurchases;
    
    public TopCustomer(int customerId, BigDecimal totalPurchases) {
        this.customerId = customerId;
        this.totalPurchases = totalPurchases;
    }

    @Override public int compareTo(TopCustomer customer) {
        int result = totalPurchases.compareTo(customer.getTotalPurchases());

        if (result == 0)
            return customerId - customer.getCustomerId();

        return result;
    }

}
