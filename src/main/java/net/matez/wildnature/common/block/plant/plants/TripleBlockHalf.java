package net.matez.wildnature.common.block.plant.plants;

import net.minecraft.util.StringRepresentable;

public enum TripleBlockHalf implements StringRepresentable {
   UPPER,
   MIDDLE,
   LOWER;

   public String toString() {
      return this.getSerializedName();
   }

   public String getSerializedName() {
      return this == UPPER ? "upper" : (this == LOWER ? "lower" : "middle");
   }
}