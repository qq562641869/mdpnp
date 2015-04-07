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
package org.mdpnp.apps.device;

import java.util.Set;

import org.mdpnp.apps.fxbeans.InfusionStatusFx;

import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;

/**
 * @author Jeff Plourde
 *
 */
public class InfusionPumpPanel extends DevicePanel {

    private final Label active = new Label(), drugName = new Label(), drugMass = new Label(), solutionVolume = new Label(),
            vtbiMl = new Label(), durationSec = new Label(), fracComplete = new Label();

    public InfusionPumpPanel() {
        GridPane gridPane = new GridPane();
        gridPane.add(new Label("Active"), 0, 0);
        gridPane.add(active, 1, 0);
        gridPane.add(new Label("Drug Name"), 0, 1);
        gridPane.add(drugName, 1, 1);
        gridPane.add(new Label("Drug Mass (mcg)"), 0, 2);
        gridPane.add(drugMass, 1, 2);
        gridPane.add(new Label("Solution Volume (mL)"), 0, 3);
        gridPane.add(solutionVolume, 1, 3);
        gridPane.add(new Label("VTBI (mL)"), 0, 4);
        gridPane.add(vtbiMl, 1, 4);
        gridPane.add(new Label("Duration (seconds)"), 0, 5);
        gridPane.add(durationSec, 1, 5);
        gridPane.add(new Label("Percent complete"), 0, 6);
        gridPane.add(fracComplete, 1, 6);
        setCenter(gridPane);
    }



    public static boolean supported(Set<String> numerics) {
        return false;
    }

    @Override
    public void set(DeviceDataMonitor deviceMonitor) {
        super.set(deviceMonitor);
        deviceMonitor.getInfusionStatusModel().addListener(infusionStatusListener);
    }
    
    @Override
    public void destroy() {
        super.destroy();
        deviceMonitor.getInfusionStatusModel().removeListener(infusionStatusListener);
    }
    
    protected void infusionStatusUpdate(InfusionStatusFx data) {
        active.setText(Boolean.toString(data.isInfusionActive()));
        drugMass.setText(Integer.toString(data.getDrug_mass_mcg()) + " mcg");
        drugName.setText(data.getDrug_name());
        durationSec.setText(Integer.toString(data.getInfusion_duration_seconds()) + " seconds");
        fracComplete.setText(Integer.toString((int) (100f * data.getInfusion_fraction_complete())) + "%");
        solutionVolume.setText(Integer.toString(data.getSolution_volume_ml()) + " mL");
        vtbiMl.setText(Integer.toString(data.getVolume_to_be_infused_ml()) + " mL");
    }
    
    private final OnListChange<InfusionStatusFx> infusionStatusListener = new OnListChange<InfusionStatusFx>(
            null, (t)->infusionStatusUpdate(t), null);


}
