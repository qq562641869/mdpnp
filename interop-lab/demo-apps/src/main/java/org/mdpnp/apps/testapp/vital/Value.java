/*******************************************************************************
 * Copyright (c) 2014, MD PnP Program
 * All rights reserved.
 * 
 * Redistribution and use in source and binary forms, with or without modification, are permitted provided that the following conditions are met:
 * 
 * 1. Redistributions of source code must retain the above copyright notice, this list of conditions and the following disclaimer.
 * 
 * 2. Redistributions in binary form must reproduce the above copyright notice, this list of conditions and the following disclaimer in the documentation and/or other materials provided with the distribution.
 * 
 * THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS "AS IS" AND ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE IMPLIED WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE ARE DISCLAIMED. IN NO EVENT SHALL THE COPYRIGHT HOLDER OR CONTRIBUTORS BE LIABLE FOR ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, OR CONSEQUENTIAL DAMAGES (INCLUDING, BUT NOT LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR SERVICES; LOSS OF USE, DATA, OR PROFITS; OR BUSINESS INTERRUPTION) HOWEVER CAUSED AND ON ANY THEORY OF LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY, OR TORT (INCLUDING NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT OF THE USE OF THIS SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.
 ******************************************************************************/
package org.mdpnp.apps.testapp.vital;

import org.mdpnp.apps.testapp.Device;

import javafx.beans.property.ReadOnlyBooleanProperty;
import javafx.beans.property.ReadOnlyFloatProperty;
import javafx.beans.property.ReadOnlyIntegerProperty;
import javafx.beans.property.ReadOnlyLongProperty;
import javafx.beans.property.ReadOnlyStringProperty;
import ice.Numeric;

import com.rti.dds.subscription.SampleInfo;

public interface Value {
    ReadOnlyFloatProperty valueProperty();
    float getValue();
    
    ReadOnlyLongProperty timestampProperty();
    long getTimestamp();
    
    Device getDevice();
    String getUniqueDeviceIdentifier();

    ReadOnlyStringProperty metricIdProperty();
    String getMetricId();

    ReadOnlyIntegerProperty instanceIdProperty();
    int getInstanceId();

    Vital getParent();

    ReadOnlyBooleanProperty atOrAboveHighProperty();
    boolean isAtOrAboveHigh();

    ReadOnlyBooleanProperty atOrBelowLowProperty();
    boolean isAtOrBelowLow();

    ReadOnlyBooleanProperty atOrOutsideOfBoundsProperty();
    boolean isAtOrOutsideOfBounds();

    ReadOnlyBooleanProperty atOrAboveCriticalHighProperty();
    boolean isAtOrAboveCriticalHigh();

    ReadOnlyBooleanProperty atOrBelowCriticalLowProperty();
    boolean isAtOrBelowCriticalLow();

    ReadOnlyBooleanProperty atOrOutsideOfCriticalBoundsProperty();
    boolean isAtOrOutsideOfCriticalBounds();

    ReadOnlyBooleanProperty atOrAboveValueMsHighProperty();
    boolean isAtOrAboveValueMsHigh();

    ReadOnlyBooleanProperty atOrAboveValueMsLowProperty();
    boolean isAtOrAboveValueMsLow();

    ReadOnlyBooleanProperty ignoreProperty();
    boolean isIgnore();

    ReadOnlyLongProperty ageInMillisecondsProperty();
    long getAgeInMilliseconds();

    void updateFrom(Numeric numeric, SampleInfo sampleInfo);

    ReadOnlyLongProperty valueMsBelowLowProperty();
    long getValueMsBelowLow();

    ReadOnlyLongProperty valueMsAboveHighProperty();
    long getValueMsAboveHigh();
}
