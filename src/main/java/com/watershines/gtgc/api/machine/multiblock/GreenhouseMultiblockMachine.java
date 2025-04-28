package com.watershines.gtgc.api.machine.multiblock;

import com.gregtechceu.gtceu.api.machine.IMachineBlockEntity;
import com.gregtechceu.gtceu.api.machine.multiblock.WorkableElectricMultiblockMachine;

import com.watershines.gtgc.api.block.IGlassType;
import com.watershines.gtgc.api.block.ISoilType;
import com.watershines.gtgc.common.block.GlassBlock;
import com.watershines.gtgc.common.block.SoilBlock;

public class GreenhouseMultiblockMachine extends WorkableElectricMultiblockMachine {

    private ISoilType soilType = SoilBlock.SoilType.FARMLAND;
    private IGlassType glassType = GlassBlock.GlassType.GLASS;

    public GreenhouseMultiblockMachine(IMachineBlockEntity holder) {
        super(holder);
    }

    @Override
    public void onStructureFormed() {
        super.onStructureFormed();
        var soilType = getMultiblockState().getMatchContext().get("SoilType");
        var glassType = getMultiblockState().getMatchContext().get("GlassType");

        if (soilType instanceof ISoilType soil) {
            this.soilType = soil;
        }
        if (glassType instanceof IGlassType glass) {
            this.glassType = glass;
        }
    }

    public ISoilType getSoilType() {
        return this.soilType;
    }

    public IGlassType getGlassType() {
        return this.glassType;
    }

    public double getSoilSpeedBonus() {
        return this.soilType.getSpeedBonus();
    }

    public int getSoilTier() {
        return this.soilType.getTier();
    }

    public int getGlassTier() {
        return this.glassType.getTier();
    }
}
