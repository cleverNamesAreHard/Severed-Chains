package legend.game.submap;

import legend.core.gte.MV;
import org.joml.Vector2f;

/** Used for ortho quad trail attached sobj effect particles (footprints and some kinds of dust). */
public class OrthoTrailParticle54 {
  public boolean used;

  public int renderMode_00;
  public int textureIndex_02;
  public int tick_04;
  public int maxTicks_06;
  public float size_08;
  public float sizeStep_0c;
  // Appears to just be a second size attribute
  // public float _10;

  public int x_18;
  public int y_1c;
  public MV lw = new MV();
  public final Vector2f sxy0_20 = new Vector2f();
  public float centerX_26;
  public final Vector2f sxy1_28 = new Vector2f();
  public float centerY_2e;
  public final Vector2f sxy2_30 = new Vector2f();
  public final Vector2f sxy3_38 = new Vector2f();
  /** 16.16 fixed-point */
  public float stepBrightness_40;
  // /** 16.16 fixed-point */
  // public int brightnessAccumulator_44; // No longer necessary
  public float brightness_48;
  public float z_4c;
  // public OrthoTrailParticle54 next_50;

  public OrthoTrailParticle54() {
    this.used = true;
  }
}
