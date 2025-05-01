package com.watershines.gtgc.api.machine.multiblock;

import com.gregtechceu.gtceu.api.machine.IMachineBlockEntity;
import com.gregtechceu.gtceu.api.machine.multiblock.WorkableElectricMultiblockMachine;

import com.watershines.gtgc.api.block.ICatalystType;
import com.watershines.gtgc.api.block.IGlassType;
import com.watershines.gtgc.api.block.ISoilType;
import com.watershines.gtgc.common.block.CatalystBlock;
import com.watershines.gtgc.common.block.GlassBlock;
import com.watershines.gtgc.common.block.SoilBlock;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class GreenhouseMultiblockMachine extends WorkableElectricMultiblockMachine {

    private ISoilType soilType = SoilBlock.SoilType.FARMLAND;
    private IGlassType glassType = GlassBlock.GlassType.GLASS;
    private ICatalystType catalystType = CatalystBlock.CatalystType.TIER_1;
    public static final String CATALYST_HEADER = "Catalyst_";
    private double totalSpeedBoost;
    private double averageSpeedBoost;

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

        List<ICatalystType> catalysts = new ArrayList<>();
        for (Map.Entry<String, Object> catalyst : getMultiblockState().getMatchContext().entrySet()) {
            if (catalyst.getKey().startsWith(CATALYST_HEADER) &&
                    catalyst.getValue() instanceof GreenhouseMultiblockMachine.CatalystMatchWrapper wrapper) {
                for (int i = 0; i < wrapper.amount; i++) {
                    catalysts.add(wrapper.partType);
                }
            }
        }
        for (int i = 0; i < catalysts.size(); i++) {
            this.totalSpeedBoost += catalysts.get(i).getSpeedBoost();
        }
        if (catalysts.isEmpty()) {
            // only empty batteries found in the structure
            this.averageSpeedBoost = 1;
        } else {
            this.averageSpeedBoost = this.totalSpeedBoost / catalysts.size();
        }
        this.totalSpeedBoost = 0;
    }

    @Override
    public void onStructureInvalid() {
        super.onStructureInvalid();
        this.totalSpeedBoost = 0;
    }

    public ISoilType getSoilType() {
        return this.soilType;
    }

    public IGlassType getGlassType() {
        return this.glassType;
    }

    public int getSoilTier() {
        return this.soilType.getTier();
    }

    public double getAverageSpeedBoost() {
        return this.averageSpeedBoost;
    }

    public static class CatalystMatchWrapper {

        private final ICatalystType partType;
        private int amount;

        public CatalystMatchWrapper(ICatalystType partType) {
            this.partType = partType;
        }

        public GreenhouseMultiblockMachine.CatalystMatchWrapper increment() {
            amount++;
            return this;
        }
    }
}
